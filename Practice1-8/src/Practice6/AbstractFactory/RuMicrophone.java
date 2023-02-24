package Practice6.AbstractFactory;

public class RuMicrophone implements Microphone{
    @Override
    public void record() {
        System.out.println("Запись");
    }

    @Override
    public void stop() {
        System.out.println("Остановка записи");
    }
}
