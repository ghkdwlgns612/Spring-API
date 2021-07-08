package com.buy.product.Repository;

import com.buy.product.Object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcTempleteUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTempleteUserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findByName(String name) {
        List<User> result = jdbcTemplate.query("select * from USERS where name = ? ", mapper(), name);
        return result.stream().findAny();
    }

    @Override
    public Optional<User> findBySeq(Long seq) {
        List<User> result = jdbcTemplate.query("select * from USERS where seq = ? ", mapper(), seq);
        return result.stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM USERS", mapper());
    }

    private RowMapper<User> mapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setSeq(rs.getLong("seq"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPasswd(rs.getString("passwd"));
            user.setLogin_Count(rs.getInt("login_count"));
            return user;
        };
    }
}