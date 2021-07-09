package Api.Login.Service.Log;

import Api.Login.Domain.Log;
import Api.Login.Domain.Product;
import Api.Login.Domain.User;
import Api.Login.Repository.Log.LogRepository;

import java.util.List;
import java.util.Optional;

public class LogServiceImpl implements LogService{

    private final LogRepository logRepository;

    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public Log saveServiceLog(User user, Product product) {
        Log log = new Log();
        log.setUsername(user.getName());
        log.setProductname(product.getName());
        logRepository.saveLog(log);
        return null;
    }

    @Override
    public Optional<Log> findOne(String name) {
        logRepository.findByName(name);
        return logRepository.findByName(name);
    }

    @Override
    public List<Log> findLogs() {
        logRepository.findAll();
        return logRepository.findAll();
    }
}
