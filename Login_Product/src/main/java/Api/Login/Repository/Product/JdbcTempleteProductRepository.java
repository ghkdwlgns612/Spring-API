package Api.Login.Repository.Product;

import Api.Login.Domain.Product;
import Api.Login.Domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JdbcTempleteProductRepository implements ProductRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTempleteProductRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Product> findByName(String productName) {
        List<Product> result = jdbcTemplate.query("select * from products where name = ?"
        ,productRowMapper()
        ,productName);
        return result.stream().findAny();
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("select * from products",productRowMapper());
    }

    private RowMapper<Product> productRowMapper() {
        return (rs, rowNum) -> {
            Product product = new Product();
            product.setSeq(rs.getLong("seq"));
            product.setName(rs.getString("name"));
            product.setDetails(rs.getString("details"));
            product.setReview_count(rs.getInt("review_count"));
            return product;
        };
    }

}
