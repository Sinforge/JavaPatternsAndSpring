package sinforge.practice18.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="departureupdated")
@Getter
@Setter
public class Departure{
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

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "office_id")
    private PostOffice office;


    public Departure() {

    }




}
