package member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="membertbl")
public class MemberEntity {

    @Id
    @Column(length = 50)
    private String id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String pwd;


}

