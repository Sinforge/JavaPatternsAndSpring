package Practice6.Builder;

public class Car {
    private Body _body;
    private Rudder _rudder;
    private final Wheel[] wheels = new Wheel[4];


    public Body get_body() {
        return _body;
    }

    public void set_body(Body _body) {
        this._body = _body;
    }

    public Rudder get_rudder() {
        return _rudder;
    }

    public void set_rudder(Rudder _rudder) {
        this._rudder = _rudder;
    }

    public Wheel[] getWheels() {
        return wheels;
    }
}
