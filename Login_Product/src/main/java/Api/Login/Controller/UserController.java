package Api.Login.Controller;

import Api.Login.Domain.User;
import Api.Login.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private User global_user = new User();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String HomeController() {
        return "Home";
    }
    @PostMapping("/")
    public String Login(UserDto userDto) {
        String res;
        global_user.setName(userDto.getName());
        global_user.setPasswd(userDto.getPasswd());
        res = userService.CheckLogin(global_user);
        if (res.equals("success"))
            return "product";
        else
            return "redirect:/";
    }

    @GetMapping(value = "/new")
    public String createUser() {
        return "createUser";
    }
    @PostMapping(value = "/new")
    public String createUser_P(UserDto userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPasswd(userForm.getPasswd());
        userService.join(user);
        return "redirect:/";
    }

    @GetMapping(value = "/users")
    @ResponseBody
    public List<User> receiveUser() {
        List<User> res = userService.findUsers();
        return res;
    }
}
