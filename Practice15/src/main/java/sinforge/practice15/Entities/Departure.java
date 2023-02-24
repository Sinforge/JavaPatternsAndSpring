package sinforge.practice15.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="departure")
public class Departure implements TwoFieldable{
    @Id
    @SequenceGenerator(name = "departure_seq", sequenceName =
            "departure_sequence", allocationSize = 1)
    @GeneratedValue(generator = "departure_seq", strategy =
            GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="type")
    private String type;
    @Column(name="date")
    private String date;


    public Departure() {

    }



    @Override
    public String getFirstField() {
        return type;
    }

    @Override
    public String getSecondField() {
        return date;
    }
}
