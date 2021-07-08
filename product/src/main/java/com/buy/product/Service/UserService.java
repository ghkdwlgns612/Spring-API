package com.buy.product.Service;

import com.buy.product.Object.User;
import com.buy.product.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findUsers();
    public Optional<User> findOne(Long userId);
    public String CheckLogin(User user);
}
