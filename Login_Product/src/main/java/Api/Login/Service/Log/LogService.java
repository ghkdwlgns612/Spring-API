package Api.Login.Service.Log;

import Api.Login.Domain.Log;
import Api.Login.Domain.Product;
import Api.Login.Domain.User;

import java.util.List;
import java.util.Optional;

public interface LogService {
    Log saveServiceLog(User user, Product product);
    Optional<Log> findOne(String name);
    List<Log> findLogs();
}
