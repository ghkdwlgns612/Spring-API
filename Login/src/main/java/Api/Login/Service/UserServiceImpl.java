package Api.Login.Service;

import Api.Login.Domain.User;
import Api.Login.Repository.MemoryUserRepository;
import Api.Login.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long join(User user) {
        duplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public List<User> findUsers() {
        userRepository.findAll();
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findOne(Long userId) {
        return userRepository.findById(userId);
    }

    private void duplicateUser(User user) {
        userRepository.findByName(user.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
