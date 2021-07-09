package Api.Login.Service.Product;

import Api.Login.Domain.Log;
import Api.Login.Domain.Product;
import Api.Login.Domain.User;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findByName(String name);
    List<Product> findAll();
}
