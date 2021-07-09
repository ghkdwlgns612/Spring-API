package Api.Login.Service;

import Api.Login.Domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String join(User user);
    List<User> findUsers();
    public String CheckLogin(User user);
}
