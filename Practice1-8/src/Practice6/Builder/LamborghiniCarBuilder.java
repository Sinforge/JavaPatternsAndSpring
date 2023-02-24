package Practice6.Builder;

public class LamborghiniCarBuilder implements CarBuilder{
    @Override
    public Body createBody(String name) {
        return new Body("Lamborghini body");
    }

    @Override
    public Wheel[] createWheels(String name1, String name2, String name3, String name4) {
        return new Wheel[]{new Wheel("First lamborghini wheel"),
                new Wheel("Second lamborghini wheel"),
                new Wheel("Third lamborghini wheel"),
                new Wheel("Fourth lamborghini wheel"),
        };
    }

    @Override
    public Rudder createRudder(String name) {
        return new Rudder("Lamborghini rudder");
    }
}
