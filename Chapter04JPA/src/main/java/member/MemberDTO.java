package member;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberDTO {

    private String id;

    private String name;

    private String pwd;

}
