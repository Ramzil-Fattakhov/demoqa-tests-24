package utils;

import com.github.javafaker.Faker;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("en-gb"));

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomEmail());
        System.out.println(getRandomStreetAddress());
        System.out.println(getRandomInt(111, 99999999));
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
        System.out.println(getRandomSubject());

    }





    public static String getRandomString(int len) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            SecureRandom rnd = new SecureRandom();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++)
                sb.append(AB.charAt(rnd.nextInt(AB.length())));

            return sb.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@gmail.com";
    }


    public static String getRandomStreetAddress() {
        return getRandomString(10) + " " + getRandomString(10) + " " + getRandomString(10);
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

//    public static String getRandomPhone() {
//        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
//                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
//
//    }

    public static String getRandomPhone() {
        return String.format("%s%s%s%s", getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));

    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public static String[] getSolidRandomDateOfBirth() {

        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.ENGLISH);
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.ENGLISH);

        Date randomDate = faker.date().birthday();

        String day = dayFormat.format(randomDate);
        String month = monthFormat.format(randomDate);
        String year = yearFormat.format(randomDate);

        return new String[] {day, month, year};
    }

    public static String[] getRandomDateOfBirth() {
        return getSolidRandomDateOfBirth();
    }

    public static String getRandomSubject() {
        return faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry", "BiologyComputer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics");
    }

    private static final Map<String, List<String>> stateCityMap = new HashMap<>();

    static {
        stateCityMap.put("NCR", List.of("Delhi", "Gurgaon", "Noida"));
        stateCityMap.put("Uttar Pradesh", List.of("Lucknow", "Merrut", "Agra"));
        stateCityMap.put("Haryana", List.of("Karnal", "Panipat"));
        stateCityMap.put("Rajasthan", List.of("Jaipur", "Jaiselmer"));
    }

    public static String[] getRandomStateAndCity() {
        Faker faker = new Faker();
        Random random = new Random();

        String randomState = faker.options().option(stateCityMap.keySet().toArray(new String[0]));

        List<String> cities = stateCityMap.get(randomState);

        String randomCity = cities.get(random.nextInt(cities.size()));

        return new String[] {randomState, randomCity};
    }
}
