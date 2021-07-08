package com.buy.product.Repository;

import com.buy.product.Object.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public Optional<User> findByName(String name);
    public Optional<User> findBySeq(Long seq);
    public List<User> findAll();
}
