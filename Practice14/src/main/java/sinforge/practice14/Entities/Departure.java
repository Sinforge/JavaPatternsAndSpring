package sinforge.practice14.Entities;

import java.util.Date;

public class Departure implements TwoFieldable{
    public Departure(String type, String departureDate) {
        this.type = type;
        this.departureDate = departureDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    private String type;
    private String departureDate;

    @Override
    public String getFirstField() {
        return type;
    }

    @Override
    public String getSecondField() {
        return departureDate;
    }
}
