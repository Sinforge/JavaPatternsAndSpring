package Practice2;

import java.time.LocalDate;

public record Human (int age, String firstName, String lastName, LocalDate birthDate, int weight) {
    @Override
    public String toString() {
        return "{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                '}';
    }
}
