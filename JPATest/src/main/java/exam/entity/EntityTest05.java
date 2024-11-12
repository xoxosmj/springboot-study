package exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class EntityTest05 {
    @Id
    private int id;
    private String username;

    //연관 관계 매핑
    @ManyToOne
    private Team t;  //DB의 필드명은 t_TEAM_ID로 만들어진다.
    //자동 부여가 싫으면 @JoinColumn으로 필드명을 지정하면 된다.


    public EntityTest05() {
    }

    public EntityTest05(String username, Team team) {
        this.username = username;
        t = team;

    }
}

