package sinforge.practice15.Entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="postoffice")
public class PostOffice implements TwoFieldable {
    @Id
    @SequenceGenerator(name = "departure_seq", sequenceName =
            "departure_sequence", allocationSize = 1)
    @GeneratedValue(generator = "departure_seq", strategy =
            GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="name")
    private String name;
    @Column(name="cityname")
    private String cityName;

    public PostOffice(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }

    public PostOffice() {

    }

    @Override
    public String getFirstField() {
        return name;
    }

    @Override
    public String getSecondField() {
        return cityName;
    }
}
