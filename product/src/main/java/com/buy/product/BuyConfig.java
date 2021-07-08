package com.buy.product;

import com.buy.product.Repository.JdbcTempleteUserRepository;
import com.buy.product.Repository.UserRepository;
import com.buy.product.Service.UserService;
import com.buy.product.Service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BuyConfig {
    private final DataSource dataSource;

    public BuyConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public UserRepository userRepository() {
        return new JdbcTempleteUserRepository(dataSource);
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }
}
