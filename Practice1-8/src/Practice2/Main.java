package Practice2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<Human> (Arrays.asList(
                new Human(20, "Ivan", "Ivanov", LocalDate.of(2000, 1, 1), 70),
                new Human(30, "Petr", "Petrov", LocalDate.of(1990, 1, 1), 82),
                new Human(40, "Sidor", "Sidorov", LocalDate.of(1980, 1, 1), 90)
        ));
        humans.stream()
                .sorted((h1, h2) -> h1.firstName().charAt(1) - h2.firstName().charAt(1))
                .forEach(h-> System.out.println(h.toString()));
        System.out.println("\n\n");


        humans.stream()
                .sorted((h1, h2) -> h1.firstName().charAt(1) - h2.firstName().charAt(1))
                .filter(h-> h.weight() % 10 == 0)
                .forEach(h-> System.out.println(h.toString()));
        System.out.println("\n\n");



        humans.stream()
                .sorted((h1, h2) -> h1.firstName().charAt(1) - h2.firstName().charAt(1))
                .filter(h-> h.weight() % 10 == 0)
                .sorted((h1, h2) -> h1.age() * h1.weight() - h2.age() * h2.weight())
                .forEach(h-> System.out.println(h.toString()));
        System.out.println("\n\n");


        int result =  humans.stream()
                .sorted((h1, h2) -> h1.firstName().charAt(1) - h2.firstName().charAt(1))
                .filter(h-> h.weight() % 10 == 0)
                .sorted((h1, h2) -> h1.age() * h1.weight() - h2.age() * h2.weight())
                .mapToInt(Human::age)
                .reduce(1, (a, b) -> a * b);
        System.out.println(result);

    }
}
