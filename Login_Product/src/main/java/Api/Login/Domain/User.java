package Api.Login.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long seq;
    private String name;
    private String email;
    private String passwd;
    private int login_count;
}
