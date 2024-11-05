package thymeleaf.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor // 이유?
@Data
public class PersonDTO {
    private String name;
    private int age;
}
