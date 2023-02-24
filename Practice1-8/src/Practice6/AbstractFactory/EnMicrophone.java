package Practice6.AbstractFactory;

public class EnMicrophone implements Microphone{
    @Override
    public void record() {
        System.out.println("Recording");
    }

    @Override
    public void stop() {
        System.out.println("Stop recording");
    }

}
