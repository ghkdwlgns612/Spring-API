package Api.Login.Controller;

import Api.Login.Domain.User;
import Api.Login.Repository.JdbcTempleteUserRepository;
import Api.Login.Repository.MemoryUserRepository;
import Api.Login.Repository.UserRepository;
import Api.Login.Service.UserService;
import Api.Login.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.swing.text.html.Option;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String HomeController() {
        return "Home";
    }

    @GetMapping(value = "/new")
    public String createUser() {
        return "createUser";
    }

    @PostMapping(value = "/new")
    public String createUser_P(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
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
