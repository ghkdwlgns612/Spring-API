package com.buy.product.Controller;

import com.buy.product.Object.User;
import com.buy.product.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Access;

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String HomeCnt() {
        return "home";
    }

    @PostMapping("/")
    public String HomeInput(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setPasswd(userForm.getPasswd());
        userService.CheckLogin(user);
        return "redirect:/";
    }
}
