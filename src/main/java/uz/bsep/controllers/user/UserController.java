package uz.bsep.controllers.user;
import org.springframework.stereotype.Controller;
import uz.bsep.controllers.AbstractController;
import uz.bsep.services.user.UserService;

@Controller
public class UserController extends AbstractController<UserService> {
    public UserController(UserService service) {
        super(service);
    }
}
