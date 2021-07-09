package Api.Login;

import Api.Login.Repository.Log.JdbcTempleteLogRepository;
import Api.Login.Repository.Log.LogRepository;
import Api.Login.Repository.Product.JdbcTempleteProductRepository;
import Api.Login.Repository.Product.ProductRepository;
import Api.Login.Repository.User.JdbcTempleteUserRepository;
import Api.Login.Repository.User.UserRepository;
import Api.Login.Service.Log.LogService;
import Api.Login.Service.Log.LogServiceImpl;
import Api.Login.Service.Product.ProductService;
import Api.Login.Service.Product.ProductServiceImpl;
import Api.Login.Service.User.UserService;
import Api.Login.Service.User.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LoginConfig {

    private final DataSource dataSource;

    public LoginConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public LogRepository logRepository() {
        return new JdbcTempleteLogRepository(dataSource);
    }
    @Bean
    public LogService logService() {
        return new LogServiceImpl(logRepository());
    }

    @Bean
    public ProductRepository productRepository() {
        return new JdbcTempleteProductRepository(dataSource);
    }
    @Bean
    public ProductService productService() {
        return new ProductServiceImpl(productRepository());
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
