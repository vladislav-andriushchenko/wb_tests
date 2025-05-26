package utils;

import com.github.javafaker.Faker;

import static java.util.Objects.requireNonNull;


public class TestData {

    private static final Faker faker = new Faker();

    public static String getRandomItem() {
        return String.format("%d", faker.number().numberBetween(1, 10));
    }

    public static String getRandomInstrument() {
        return faker.music().instrument();
    }
}
