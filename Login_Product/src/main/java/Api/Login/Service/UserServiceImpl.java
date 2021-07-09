package Api.Login.Service;

import Api.Login.Domain.User;
import Api.Login.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public String CheckLogin(User user) {
//        Optional<User> comparedb = userRepository.findByName(user.getName());
//        String dbName = comparedb.get().getName();
//        String dbPasswd = comparedb.get().getPasswd();
//        if (user.getName().equals(dbName)){
//            if (user.getPasswd().equals(dbPasswd))
//                return "success";
//            else
//                return "fail : cannot find password";
//        }
//        else
//            return "fail : cannot find id";
//    }

    @Override
    public String CheckLogin(User user) {
        Optional<User> comparedb = userRepository.findByName(user.getName());
        try {
            String dbName = comparedb.get().getName();
            String dbPasswd = comparedb.get().getPasswd();
            if (user.getName().equals(dbName)) {
                if (user.getPasswd().equals(dbPasswd))
                    return "success";
                else
                    return "fail : cannot find password";
            } else
                return "fail : cannot find id";
        } catch (NoSuchElementException e) {
            return "fail : cannot find id";
        }
    }

    @Override
    public String join(User user) {
        duplicateUser(user);
        userRepository.save(user);
        return "success";
    }

    @Override
    public List<User> findUsers() {
        userRepository.findAll();
        return userRepository.findAll();
    }


    private void duplicateUser(User user) {
        userRepository.findByName(user.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
