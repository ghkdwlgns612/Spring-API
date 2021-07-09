package Api.Login.Repository;

import Api.Login.Domain.User;

import java.lang.reflect.Member;
import java.util.*;

import static java.util.Optional.ofNullable;

public class MemoryUserRepository implements UserRepository{

    private final Map<Long, User> store = new HashMap<>();
    private static long seq = 0L;

    @Override
    public User save(User user) {
        user.setSeq(++seq);
        store.put(user.getSeq(), user);
        return user;
    }

    @Override
    public Optional<User> findByName(String name) {
        return store.values().stream()
                .filter(user -> user.getName().equals(name))
                .findAny();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    private void clear() {
        store.clear();
    }
}
