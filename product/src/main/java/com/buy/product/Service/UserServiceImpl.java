package com.buy.product.Service;

import com.buy.product.Object.User;
import com.buy.product.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findOne(Long userId) {
        return userRepository.findBySeq(userId);
    }

    @Override
    public String CheckLogin(User user) {
        Optional<User> comparedb = userRepository.findByName(user.getName());
        if (comparedb.get().getName().equals(user.getName())){
            if (comparedb.get().getPasswd().equals(user.getPasswd()))
                return "success";
            else
                return "비밀번호가 일치하지 않습니다";
        }
        else
            return "존재하지 않는 ID입니다.";
    }
}
