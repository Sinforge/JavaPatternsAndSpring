package Practice1;

import java.util.Map;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {;
        Function<Map.Entry<Integer, Integer>, Integer> getNOD = new GetNOD();
        System.out.println(getNOD.apply(Map.entry(12, 18)));
    }



}
