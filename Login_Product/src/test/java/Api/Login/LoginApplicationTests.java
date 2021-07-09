package Api.Login;

import Api.Login.Repository.User.UserRepository;
import Api.Login.Service.Log.LogService;
import Api.Login.Service.Product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginApplicationTests {

	private final LogService logService;
	private final ProductService productService;
	private final UserRepository userRepository;

	@Autowired
	public LoginApplicationTests(LogService logService, ProductService productService, UserRepository userRepository) {
		this.logService = logService;
		this.productService = productService;
		this.userRepository = userRepository;
	}

	@Test
	void chkLog() {
		System.out.println("logService = " + logService.findOne("jihuhwan").get().getUsername());
		System.out.println("productService = " + productService.findByName("product A").get().getName());
	}

}