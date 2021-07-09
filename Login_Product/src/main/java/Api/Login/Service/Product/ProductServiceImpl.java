package Api.Login.Service.Product;

import Api.Login.Domain.Log;
import Api.Login.Domain.Product;
import Api.Login.Domain.User;
import Api.Login.Repository.Product.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findByName(String name) {
        productRepository.findByName(name);
        return productRepository.findByName(name);
    }
    @Override
    public List<Product> findAll() {
        productRepository.findAll();
        return productRepository.findAll();
    }
}
