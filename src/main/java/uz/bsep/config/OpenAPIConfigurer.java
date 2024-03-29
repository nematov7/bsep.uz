package uz.bsep.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@OpenAPIDefinition
@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(name = "springdoc.swagger-ui.enabled", havingValue = "true", matchIfMissing = true)
public class OpenAPIConfigurer {
    public static final String SCHEMA = "Bearer";
    public static final String BEARER_FORMAT = "JWT";
    public static final String SECURITY_SCHEMA_NAME = "Online Pharma security schema";


    @Bean
    public OpenAPI api() {
        return new OpenAPI().schemaRequirement(SECURITY_SCHEMA_NAME,
                getSecurityScheme()).security(getSecurityRequirements()).info(
                new Info().title("Movie").description("watch online movie")
        );
    }

    private SecurityScheme getSecurityScheme() {
        SecurityScheme scheme = new SecurityScheme();
        scheme.bearerFormat(BEARER_FORMAT);
        scheme.type(SecurityScheme.Type.HTTP);
        scheme.in(SecurityScheme.In.HEADER);
        scheme.scheme(SCHEMA);
        return scheme;
    }

    private List<SecurityRequirement> getSecurityRequirements() {
        SecurityRequirement requirement = new SecurityRequirement();
        requirement.addList(SECURITY_SCHEMA_NAME);
        return Collections.singletonList(requirement);
    }
}
