package Api.Login.Repository.User;

import Api.Login.Domain.User;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findByName(String name);
    List<User> findAll();
}
