package ru.netology.test;

import org.junit.jupiter.api.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import ru.netology.data.Data;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebServiseTest {
    @BeforeAll
    static void setUpAll() {
        DataHelper.creatingTestDataMap();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void stopData() {

        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setup() {
        Data.cleanUpDB();
        open("http://localhost:8080");
    }

    @Test
    @DisplayName("Purchasing a tour. Everything is filled")
    void everythingFilledDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number1"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validData().getNewDB(), Data.countAll());
        assertEquals(DataHelper.validData().getPrice(), Data.paymentData().getAmount());
        assertEquals(DataHelper.validData().getStatus(), Data.paymentData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour. Year more than five years")
    void yearMoreFiveYearsDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number2"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validData().getNewDB(), Data.countAll());
        assertEquals(DataHelper.validData().getPrice(), Data.paymentData().getAmount());
        assertEquals(DataHelper.validData().getStatus(), Data.paymentData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour. Name by first letter")
    void nameFirstLetterDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number3"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validData().getNewDB(), Data.countAll());
        assertEquals(DataHelper.validData().getPrice(), Data.paymentData().getAmount());
        assertEquals(DataHelper.validData().getStatus(), Data.paymentData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour. Month and year more than two years")
    void monthAndYearMoreTwoYearsDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number4"));
        dashboardPage.noValidPopUp();
        assertEquals(DataHelper.noValidData().getNewDB(), Data.countAll());
        assertEquals(DataHelper.noValidData().getPrice(), Data.paymentData().getAmount());
        assertEquals(DataHelper.noValidData().getStatus(), Data.paymentData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour. Month and year more than two years. Numbercard zero")
    void monthAndYearMoreTwoYearsNumbercardZeroDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number5"));
        dashboardPage.noValidPopUp();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Month and year more than two years. Numbercar empty")
    void monthAndYearMoreTwoYearsNumbercarEmptyDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number6"));
        dashboardPage.numberNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Nombercard not completely. Month and year more than two years")
    void monthAndYearMoreTwoYearsNumbercarNotCompletelyDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number7"));
        dashboardPage.numberNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Year minus")
    void YearMinusDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number8"));
        dashboardPage.yearCardExpired();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Year more than two years")
    void YearMoreTwoYearsDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number9"));
        dashboardPage.yearInvalidCardDate();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Year zero")
    void YearZeroDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number10"));
        dashboardPage.yearCardExpired();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Year empty")
    void YearEmptyDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number11"));
        dashboardPage.yearNotCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Month minus")
    void MonthMinusDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number12"));
        dashboardPage.monthCardExpired();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Month more. Year more than two years")
    void MonthMoreYearMoreTwoYearsDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number13"));
        dashboardPage.monthInvalidCardDate();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Month zero")
    void MontZeroDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number14"));
        dashboardPage.monthInvalidCardDate();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. There is no month")
    void ThereNoMonthDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number15"));
        dashboardPage.monthInvalidCardDate();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Month empty")
    void MonthEmptyDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number16"));
        dashboardPage.monthNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Name by first letter")
    void NameFirstLetterDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number17"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Name colon")
    void NameСolonDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number18"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Name numbers")
    void NameNumbersDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number19"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Name seamlessly")
    void NameSeamlesslyDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number20"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Name minus")
    void NameMinusDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number21"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Name star")
    void NameStarDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number22"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Name plus")
    void NamePlusDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number23"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Name dash")
    void NameDashDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number24"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Name empty")
    void NameEmptyDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number25"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Сvc one digit")
    void СvcOneDigitDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number26"));
        dashboardPage.securityCodesNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour. Сvc three zeros")
    void СvcThreeZerosDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number27"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validData().getNewDB(), Data.countAll());
        assertEquals(DataHelper.validData().getPrice(), Data.paymentData().getAmount());
        assertEquals(DataHelper.validData().getStatus(), Data.paymentData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour. Сvc empty")
    void СvcEmptyDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBayTourButton(DataHelper.generateUser("number28"));
        dashboardPage.securityCodesNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Everything is filled")
    void everythingFilledCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number1"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validDataCredit().getNewDB(), Data.countAll());
        assertEquals(DataHelper.validDataCredit().getPrice(), Data.paymentData().getAmount());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.paymentData().getStatus());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.creditData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Year more than five years")
    void YearMoreFiveYearsCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number2"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validDataCredit().getNewDB(), Data.countAll());
        assertEquals(DataHelper.validDataCredit().getPrice(), Data.paymentData().getAmount());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.paymentData().getStatus());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.creditData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name by first letter")
    void nameFirstLetterCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number3"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validDataCredit().getNewDB(), Data.countAll());
        assertEquals(DataHelper.validDataCredit().getPrice(), Data.paymentData().getAmount());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.paymentData().getStatus());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.creditData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Month and year more than two years")
    void monthAndYearMoreTwoYearsCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number4"));
        dashboardPage.noValidPopUp();
        assertEquals(DataHelper.noValidDataCredit().getNewDB(), Data.countAll());
        assertEquals(DataHelper.noValidDataCredit().getStatus(), Data.creditData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Month and year more than two years. Numbercard zero")
    void monthAndYearMoreTwoYearsNumbercardZeroDebitCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number5"));
        dashboardPage.noValidPopUp();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Month and year more than two years. Numbercard empty")
    void monthAndYearMoreTwoYearsNumbercardEmptyCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number6"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Nombercard not completely. Month and year more than two yearsd")
    void monthAndYearMoreTwoYearsNumbercardNotCompletelyCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number7"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Year minus")
    void YearMinusCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number8"));
        dashboardPage.yearCardExpired();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Year more than two years")
    void YearMoreTwoYearsCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number9"));
        dashboardPage.yearInvalidCardDate();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Year zero")
    void YearZeroCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number10"));
        dashboardPage.yearCardExpired ();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("MPurchasing a tour on credit. Year empty")
    void YearEmptyCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number11"));
        dashboardPage.yearNotCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Month minus")
    void MonthMinusCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number12"));
        dashboardPage.monthCardExpired();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Month more. Year more than two years")
    void MonthMoreYearMoreTwoYearsCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number13"));
        dashboardPage.monthInvalidCardDate();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Month zero")
    void MonthZeroCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number14"));
        dashboardPage.monthInvalidCardDate();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. There is no month")
    void ThereNoMonthCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number15"));
        dashboardPage.monthInvalidCardDate();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Month empty")
    void MonthEmptyCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number16"));
        dashboardPage.monthNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name by first letter")
    void NameFirstLetterCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number17"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name сolon")
    void NameСolonCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number18"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name numbers")
    void NameNumbersCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number19"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name seamlessly")
    void NameSeamlesslyCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number20"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name minus")
    void NameMinusCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number21"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name star")
    void NameStarCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number22"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(),Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name plus")
    void NamePlusCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number23"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name dash")
    void NameDashCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number24"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name empty")
    void NameEmptyCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number25"));
        dashboardPage.nameNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Сvc one digit")
    void СvcOneDigitCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number26"));
        dashboardPage.securityCodesNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Сvc three zeros")
    void СvcThreeZerosCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number27"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validDataCredit().getNewDB(), Data.countAll());
        assertEquals(DataHelper.validDataCredit().getPrice(), Data.paymentData().getAmount());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.paymentData().getStatus());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.creditData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Сvc empty")
    void СvcEmptyCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getCreditTourButton(DataHelper.generateUser("number28"));
        dashboardPage.securityCodesNoCorrect();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.countAll());
    }
}
