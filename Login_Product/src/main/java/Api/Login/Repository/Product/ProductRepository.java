package Api.Login.Repository.Product;

import Api.Login.Domain.Product;
import Api.Login.Domain.User;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findByName(String productName);
    List<Product> findAll();
}
