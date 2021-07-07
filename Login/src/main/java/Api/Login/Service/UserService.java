package Api.Login.Service;

import Api.Login.Domain.User;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Long join(User user);
    List<User> findUsers();
    Optional<User> findOne(Long userId);
}
