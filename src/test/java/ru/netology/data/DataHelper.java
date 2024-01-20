package ru.netology.data;

public class DataHelper {

}
    @Value
    public static class CardDetails {
        String numbercard;
        String month;
        String year;
        String name;
        String cvc;

    }
        public static void creatingTestDataMap() {
            number.put("number1", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "Lili Petrova", "111"));
            number.put("number2", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(365 * 2, "yy"), "Lili Petrova", "200"));
            number.put("number3", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "L P", "100"));
            number.put("number4", new CardDetails("4444 4444 4444 4442", generateDate(20 * 2, "MM"), generateDate(365 * 2, "yy"), generateName(), generatecvc()));
            number.put("number5", new CardDetails("0000 0000 0000 0000", generateDate(20 * 2, "MM"), generateDate(365 * 2, "yy"), generateName(), generatecvc()));
            number.put("number6", new CardDetails(" ", generateDate(20 * 2, "MM"), generateDate(365 * 2 "yy"), generateName(), generatecvc()));
            number.put("number7", new CardDetails("4444 444", generateDate(20 * 2, "MM"), generateDate(365 * 2, "yy"), generateName(), generatecvc()));
            number.put("number8", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(-3, "yy"), generateName(), generatecvc()));
            number.put("number9", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(365 * 2, "yy"), generateName(), generatecvc()));
            number.put("number10", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), "00", generateName(), generatecvc()));
            number.put("number11", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), " ", generateName(), generatecvc()));
            number.put("number12", new CardDetails("4444 4444 4444 4441", generateDate(-3, "MM"), generateDate(0, "yy"), generateName(), generatecvc()));
            number.put("number13", new CardDetails("4444 4444 4444 4441", generateDate(13, "MM"), generateDate(356 * 2, "yy"), generateName(), generatecvc()));
            number.put("number14", new CardDetails("4444 4444 4444 4441", "00", generateDate(0, "yy"), generateName(), generatecvc()));
            number.put("number15", new CardDetails("4444 4444 4444 4441", "18", generateDate(0, "yy"), generateName(), generatecvc()));
            number.put("number16", new CardDetails("4444 4444 4444 4441", " ", generateDate(0, "yy"), generateName(), generatecvc()));
            number.put("number17", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "L P", generatecvc()));
            number.put("number18", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "Lili Petrova:", generatecvc()));
            number.put("number19", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "Lili Petrova55", generatecvc()));
            number.put("number20", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "LiliPetrova", generatecvc()));
            number.put("number21", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "-Lili Petrova", generatecvc()));
            number.put("number22", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "Lili Petrova*", generatecvc()));
            number.put("number23", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "Lili +Petrova", generatecvc()));
            number.put("number24", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), "Lili- Petrova", generatecvc()));
            number.put("number25", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), " ", generatecvc()));
            number.put("number26", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), generateName(), "1"));
            number.put("number27", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), generateName(), "000"));
            number.put("number28", new CardDetails("4444 4444 4444 4441", generateDate(0, "MM"), generateDate(0, "yy"), generateName(), " "));
}
        public static CardDetails generateUser(String number) {

        return number.get(number);
}
