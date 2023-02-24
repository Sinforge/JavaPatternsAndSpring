package Practice5;

public class Singleton {
    private Singleton instance;
    public synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
            return instance;
        }
        return instance;
    }

}

