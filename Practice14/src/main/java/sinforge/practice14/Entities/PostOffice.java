package sinforge.practice14.Entities;

public class PostOffice implements TwoFieldable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    private String cityName;

    public PostOffice(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
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
