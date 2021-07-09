package Api.Login.Controller.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long seq;
    private String name;
    private String details;
    private int review_count;
}
