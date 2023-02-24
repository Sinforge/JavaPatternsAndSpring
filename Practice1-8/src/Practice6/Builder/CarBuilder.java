package Practice6.Builder;

public interface CarBuilder {
    Body createBody(String name);
    Wheel[] createWheels(String name1, String name2, String name3, String name4);
    Rudder createRudder(String name);
}
