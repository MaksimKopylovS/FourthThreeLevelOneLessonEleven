package max_sk.Home_Work.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "scope")
public class Scope {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "user_id")
    private Long userId;

    @Column(name = "scops")
    private int scops;
}
