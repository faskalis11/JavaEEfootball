package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NamedQueries({
        @NamedQuery(name = "Footballer.findAll", query = "SELECT u FROM Footballer u"),
        @NamedQuery(name = "Footballer.findTeam", query = "SELECT u FROM Footballer u WHERE u.team = :team"),
})
@Table(name = "footballer")
public class Footballer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idf")
    private int idf;

    @Size(max = 20)
    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private int number;

    @JoinColumn(name = "team", referencedColumnName = "id")
    @ManyToOne
    private Team team;
}
