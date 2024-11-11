package exam.entity;

import jakarta.persistence.*;

@Entity
public class EntityTest04 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIME) //DB타입이 time
    private java.util.Date utilTime;

    @Temporal(TemporalType.DATE) //DB타입이 date
    private java.util.Date utilDate;


    @Temporal(TemporalType.TIMESTAMP) //DB타입이 datetime
    private java.util.Date utilTimestamp;

}
