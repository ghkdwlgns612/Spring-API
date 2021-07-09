package Api.Login.Repository;

import Api.Login.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.*;

public class JdbcTempleteUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTempleteUserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User save(User user) {
        jdbcTemplate.update("insert into users (seq,name,email,passwd,login_count) values (null,?,?,?,0)"
        ,user.getName()
        ,user.getEmail()
        ,user.getPasswd());
        return null;
    }

    @Override
    public Optional<User> findByName(String name) {
        List<User> result = jdbcTemplate.query("select * from users where name = ?"
        ,userRowMapper()
        ,name);
        return result.stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users", userRowMapper());
    }

    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setSeq(rs.getLong("seq"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPasswd(rs.getString("passwd"));
            user.setLogin_count(rs.getInt("login_count"));
            return user;
        };
    }
}
