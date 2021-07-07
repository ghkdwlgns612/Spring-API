package Api.Login;

import Api.Login.Repository.JdbcTempleteUserRepository;
import Api.Login.Repository.MemoryUserRepository;
import Api.Login.Repository.UserRepository;
import Api.Login.Service.UserService;
import Api.Login.Service.UserServiceImpl;
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
    public UserRepository userRepository() {
        return new JdbcTempleteUserRepository(dataSource);
    }
    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }
}
