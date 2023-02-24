package Practice1;

import java.util.Map;
import java.util.function.Function;

public class GetNOD implements Function<Map.Entry<Integer, Integer>, Integer>{

    @Override
    public Integer apply(Map.Entry<Integer, Integer> integerIntegerEntry) {
        return GetDivisor(integerIntegerEntry.getKey(), integerIntegerEntry.getValue());
    }
    public int GetDivisor(int a, int b) {
        if (b==0) return a;
        return GetDivisor(b,a%b);
    }
}
