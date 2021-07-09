package Api.Login.Repository.Log;

import Api.Login.Domain.Log;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JdbcTempleteLogRepository implements LogRepository{
    JdbcTemplate jdbcTemplate;

    public JdbcTempleteLogRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Log saveLog(Log log) {
        jdbcTemplate.update("insert into log (seq,username,productname) values (null,?,?)"
                ,log.getUsername()
                ,log.getProductname());
        return null;
    }

    @Override
    public Optional<Log> findByName(String username) {
        List<Log> result = jdbcTemplate.query("select * from log where username = ?"
        ,logRowMapper()
        ,username);
        return result.stream().findAny();
    }

    @Override
    public List<Log> findAll() {
        return jdbcTemplate.query("select * from log", logRowMapper());
    }

    private RowMapper<Log> logRowMapper() {
        return (rs, rowNum) -> {
            Log log = new Log();
            log.setSeq(rs.getLong("seq"));
            log.setUsername(rs.getString("username"));
            log.setProductname(rs.getString("productname"));
            return log;
        };
    }
}
