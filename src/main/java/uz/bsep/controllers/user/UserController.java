package uz.bsep.controllers.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bsep.controllers.AbstractController;
import uz.bsep.dtos.user.LoginDto;
import uz.bsep.dtos.user.UserCreateDto;
import uz.bsep.payload.ApiResponse;
import uz.bsep.security.JWTProvider;
import uz.bsep.services.user.UserService;


import javax.validation.Valid;
import java.util.Map;

import static uz.bsep.controllers.AbstractController.PATH;


@RestController
@RequestMapping(PATH)
public class UserController extends AbstractController<UserService> {
    public UserController(UserService service, JWTProvider jwtProvider) {
        super(service);
        this.jwtProvider = jwtProvider;
    }


    private final JWTProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginDto userDto) {
        UserDetails userDetails = service.loadUserByUsername(userDto.getUsername());
        String generatedToken = jwtProvider.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(Map.of("token", generatedToken));
    }

    @PostMapping("/register")
    public ApiResponse<String> register(@Valid @RequestBody UserCreateDto dto) {
        return ApiResponse.<String>builder().content(service.create(dto)).build();
    }


}
