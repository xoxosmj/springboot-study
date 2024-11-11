package exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="EntityTestTbl") //대문자로 적어도 소문자로 들어가는듯?
public class EntityTest01 {

    @Id
    private int id;
    private String name;
    private int age;
    private LocalDateTime birthday;

}
