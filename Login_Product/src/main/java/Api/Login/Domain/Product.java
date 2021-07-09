package Api.Login.Domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private Long seq;
    private String name;
    private String details;
    private int review_count;
}
