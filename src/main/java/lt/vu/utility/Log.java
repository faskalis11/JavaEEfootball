package lt.vu.utility;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "logs")
@Getter
@Setter
public class Log
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long LogID;

    @Column(name = "time")
    private Timestamp time;

    @Size(max = 100)
    @Column(name = "class_name")
    private String class_name;

    @Size(max = 100)
    @Column(name = "method_name")
    private String method_name;
}
