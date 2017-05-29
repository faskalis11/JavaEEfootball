package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@Table(name = "taxes")
public class Taxes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "footballerid", referencedColumnName = "idf")
    @OneToOne
    private Footballer footballer;

    @Column(name = "taxes_sum")
    private int taxes_sum;

}