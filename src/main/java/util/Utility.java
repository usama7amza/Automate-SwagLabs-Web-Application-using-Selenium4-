package util;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utility {

    private static Faker faker = new Faker();
    //ToDO: Method generate Random Number for select products
    // Method to generate a random set of unique numbers from 1 to 6

    public static List<Integer> getRandomProductNumbers() {
        // Create a list with numbers 1 to 6
        List<Integer> productNumbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            productNumbers.add(i);
        }

        // Shuffle the list to randomize the order
        Collections.shuffle(productNumbers);

        // Generate a random size for the list (between 1 and 6)
        Random random = new Random();
        int randomSize = random.nextInt(6) + 1;  // Random size between 1 and 6

        // Return a sublist containing a random number of elements
        return productNumbers.subList(0, randomSize);
    }


    //TODO: define action methods
    // Method to enter all user details with Faker(2)

    // Method to generate random first name
    public static String getFirstName() {
        return faker.name().firstName();
    }

    // Method to generate random last name
    public static String getLastName() {
        return faker.name().lastName();
    }

    // Method to generate random zip code
    public static String getZipCode() {
        return faker.address().zipCode();
    }

}
