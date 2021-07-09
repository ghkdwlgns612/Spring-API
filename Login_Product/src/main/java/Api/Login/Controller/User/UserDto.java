package Api.Login.Controller.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private String name;
    private String email;
    private String passwd;
}
