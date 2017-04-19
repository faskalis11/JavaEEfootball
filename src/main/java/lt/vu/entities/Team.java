package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NamedQueries({
        @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t"),
        @NamedQuery(name = "Team.findById", query = "SELECT t FROM Team t WHERE t.id = :id"),
})
@Table(name = "team")
@EqualsAndHashCode(of = "name")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Size(max = 20)
    @NotNull
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Footballer> footballerList = new ArrayList<>();

    @ManyToMany(mappedBy = "teamList")
    private List<Stadium> stadiumList = new ArrayList<>();

    /*@Override
    public String toString() {
        return name;
    }*/
}
