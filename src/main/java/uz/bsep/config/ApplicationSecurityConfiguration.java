package uz.bsep.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.ldap.EmbeddedLdapServerContextSourceFactoryBean;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import uz.bsep.repositories.user.UserRepository;
import uz.bsep.security.JWTFilter;
import uz.bsep.security.JwtAuthenticationEntryPoint;
import uz.bsep.services.user.UserServiceImp;


import java.util.Arrays;
import java.util.Collections;

import static uz.bsep.controllers.AbstractController.PATH;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
public class ApplicationSecurityConfiguration  {

    private final UserServiceImp service;

    @Value("${server.port}")
    private Integer port;

    public final static String[] WHITE_LIST = {
            "/swagger-ui/**",
            "/swagger/**",
            "/ui/**",
            "/docs/**",
            PATH+"/admin/login/**"

    };

    public final static String[] WHITE_LIST_METHOD_GET = {
            PATH + "/types/**",
            PATH + "/genre/**",
            PATH + "/file/**",
            PATH + "/review/**"

    };
    private final ObjectMapper mapper;
    private final UserRepository repository;

    public ApplicationSecurityConfiguration(@Lazy UserServiceImp service, ObjectMapper mapper, UserRepository repository) {
        this.service = service;
        this.mapper = mapper;
        this.repository = repository;
    }


    @Autowired
    JwtAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationProvider getProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(service);
        provider.setPasswordEncoder(getEncoder());
        return provider;
    }




    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer
                        .configurationSource(corsConfigurationSource()))
                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeRequests(expressionInterceptUrlRegistry -> expressionInterceptUrlRegistry
                        .antMatchers(HttpMethod.GET, WHITE_LIST_METHOD_GET).permitAll()
                        .antMatchers(WHITE_LIST).permitAll()
                        .antMatchers(HttpMethod.POST, PATH + "/types/**", PATH + "/file/**").hasRole("ADMIN")
                        .mvcMatchers("/").permitAll()
                        .anyRequest().permitAll()
                );
        http.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }





    @Bean
    public JWTFilter jwtFilter() {
        return new JWTFilter();
    }
}
