package Practice6.FactoryMethod;

public class MouseSelector {
    public static final MouseSelector mouseSelector = new MouseSelector();
    private MouseSelector() {
    }
    Mouse getMouse(String lang){
        switch (lang) {
            case "ru":
                return new RuMouse();
            case "en":
                return new EnMouse();
            default:
                return null;
        }

    }
}
