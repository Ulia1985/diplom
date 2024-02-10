package ru.netology.data;

import java.util.Locale;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import lombok.Value;
public class DataHelper {
private DataHelper() {
}
    @Value
    public static class CardDetails {
        String numbercard;
        String month;
        String year;
        String name;
        String cvc;

    }
    private static String generateDate(int shift, String pattern) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern(pattern));
    }

    private static String generateName() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    private static String generateCvc() {
        Faker faker = new Faker(new Locale("en"));
        return String.valueOf(faker.number().numberBetween(100, 999));
    }

    private static Map<String, CardDetails> numbers = new HashMap<>();

    public static void creatingTestDataMap() {
            numbers.put("number1", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "Lili Petrova", "111"));
            numbers.put("number2", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(365 * 5, "yy"), "Lili Petrova", "200"));
            numbers.put("number3", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "L P", "100"));
            numbers.put("number4", new CardDetails("4444 4444 4444 4442", generateDate(30 * 2, "MM"), generateDate(365 * 2, "yy"), generateName(), generateCvc()));
            numbers.put("number5", new CardDetails("0000 0000 0000 0000", generateDate(20 * 2, "MM"), generateDate(365 * 5, "yy"), generateName(), generateCvc()));
            numbers.put("number6", new CardDetails(" ", generateDate(20 * 2, "MM"), generateDate(365 * 2, "yy"), generateName(), generateCvc()));
            numbers.put("number7", new CardDetails("4444 444", generateDate(20 * 2, "MM"), generateDate(365 * 2, "yy"), generateName(), generateCvc()));
            numbers.put("number8", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(-3, "yy"), generateName(), generateCvc()));
            numbers.put("number9", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(365 * 2, "yy"), generateName(), generateCvc()));
            numbers.put("number10", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), "00", generateName(), generateCvc()));
            numbers.put("number11", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), " ", generateName(), generateCvc()));
            numbers.put("number12", new CardDetails("4444 4444 4444 4441", generateDate(-3, "MM"), generateDate(0, "yy"), generateName(), generateCvc()));
            numbers.put("number13", new CardDetails("4444 4444 4444 4441", generateDate(13, "MM"), generateDate(356 *2, "yy"), generateName(), generateCvc()));
            numbers.put("number14", new CardDetails("4444 4444 4444 4441", "00", generateDate(0, "yy"), generateName(), generateCvc()));
            numbers.put("number15", new CardDetails("4444 4444 4444 4441", "18", generateDate(0, "yy"), generateName(), generateCvc()));
            numbers.put("number16", new CardDetails("4444 4444 4444 4441", " ", generateDate(0, "yy"), generateName(), generateCvc()));
            numbers.put("number17", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "L P", generateCvc()));
            numbers.put("number18", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "Lili Petrova:", generateCvc()));
            numbers.put("number19", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "Lili Petrova55", generateCvc()));
            numbers.put("number20", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "LiliPetrova", generateCvc()));
            numbers.put("number21", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "-Lili Petrova", generateCvc()));
            numbers.put("number22", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "Lili Petrova*", generateCvc()));
            numbers.put("number23", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "Lili +Petrova", generateCvc()));
            numbers.put("number24", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "Lili- Petrova", generateCvc()));
            numbers.put("number25", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), " ", generateCvc()));
            numbers.put("number26", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), generateName(), "1"));
            numbers.put("number27", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), generateName(), "000"));
            numbers.put("number28", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), generateName(), " "));
}
        public static CardDetails generateUser(String number) {

        return numbers.get(number);
}
    @Value
    public static class ExpectedData {
        String newDB;
        String price;
        String status;
    }

    public static ExpectedData validData() {

        return new ExpectedData("011", "45000", "APPROVED");
    }

    public static ExpectedData validDataCredit() {

        return new ExpectedData("111", "45000", "APPROVED");
    }

    public static ExpectedData noValidData() {

        return new ExpectedData("011", "0", "DECLINED");
    }

    public static ExpectedData noValidDataCredit() {

        return new ExpectedData("101", "", "DECLINED");
    }

    public static ExpectedData noValidInfo() {

        return new ExpectedData("000", "", "");
    }
}