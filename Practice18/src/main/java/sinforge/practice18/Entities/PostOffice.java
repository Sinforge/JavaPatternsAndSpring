package sinforge.practice18.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Table(name="postofficeupdated")
@Getter
@Setter
public class PostOffice {
    @Id
    @SequenceGenerator(name = "departure_seq", sequenceName =
            "departure_sequence", allocationSize = 1)
    @GeneratedValue(generator = "departure_seq", strategy =
            GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="name")
    private String name;
    @Column(name="cityname")
    private String cityname;

    @OneToMany(mappedBy ="office")
    private List<Departure> departures;

    public PostOffice(String name, String cityname) {
        this.name = name;
        this.cityname = cityname;
    }

    public PostOffice() {

    }


}
