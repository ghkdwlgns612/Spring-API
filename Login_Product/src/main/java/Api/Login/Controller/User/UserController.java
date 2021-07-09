package Api.Login.Controller.User;

import Api.Login.Controller.LogDto;
import Api.Login.Controller.Product.ProductDto;
import Api.Login.Domain.Log;
import Api.Login.Domain.Product;
import Api.Login.Domain.User;
import Api.Login.Service.Log.LogService;
import Api.Login.Service.Product.ProductService;
import Api.Login.Service.User.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final LogService logService;
    private final ProductService productService;
    private User global_user = new User();

    public UserController(UserService userService, LogService logService, ProductService productService) {
        this.userService = userService;
        this.logService = logService;
        this.productService = productService;
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
            return "product/product";
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

    @PostMapping(value = "/product")
    public String makeLog(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        logService.saveServiceLog(global_user,product);
        return "/product/product";
    }

    @GetMapping(value = "/users")
    @ResponseBody
    public List<User> receiveUser() {
        List<User> res = userService.findUsers();
        return res;
    }
    @GetMapping(value = "/list")
    @ResponseBody
    public List<Log> receiveList() {
        List<Log> res = logService.findLogs();
        return res;
    }

}
