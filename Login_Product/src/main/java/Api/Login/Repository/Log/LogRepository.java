package Api.Login.Repository.Log;

import Api.Login.Domain.Log;

import java.util.List;
import java.util.Optional;

public interface LogRepository {
    Log saveLog(Log log);
    Optional<Log> findByName(String username);
    List<Log> findAll();
}
