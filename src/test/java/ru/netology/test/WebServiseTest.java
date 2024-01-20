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
        DataHelper.NewTestData();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void stopData() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setup() {
        Data.cleaningDB();
        open("http://localhost:8080");
    }

    @Test
    @DisplayName("Purchasing a tour. Everything is filled")
    void everythingFilledDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number1"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validData().getNewDB(), Data.reckon());
        assertEquals(DataHelper.validData().getPrice(), Data.debitCardDetails().getAmount());
        assertEquals(DataHelper.validData().getStatus(), Data.debitCardDetails().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour. Year more than two years")
    void yearMoreTwoYearsDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number2"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validData().getNewDB(), Data.reckon());
        assertEquals(DataHelper.validData().getPrice(), Data.debitCardDetails().getAmount());
        assertEquals(DataHelper.validData().getStatus(), Data.debitCardDetails().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour. Name by first letter")
    void nameFirstLetterDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number3"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validData().getNewDB(), Data.reckon());
        assertEquals(DataHelper.validData().getPrice(), Data.debitCardDetails().getAmount());
        assertEquals(DataHelper.validData().getStatus(), Data.debitCardDetails().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour. Month and year more than two years")
    void monthAndYearMoreTwoYearsDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number4"));
        dashboardPage.noValidPopUp();
        assertEquals(DataHelper.noValidData().getNewDB(), Data.reckon());
        assertEquals(DataHelper.noValidData().getPrice(), Data.debitCardDetails().getAmount());
        assertEquals(DataHelper.noValidData().getStatus(), Data.debitCardDetails().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour. Month and year more than two years. Numbercard zero")
    void monthAndYearMoreTwoYearsNumbercardZeroDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number5"));
        dashboardPage.noValidPopUp();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Month and year more than two years. Numbercar empty")
    void monthAndYearMoreTwoYearsNumbercarEmptyDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number6"));
        dashboardPage.inCorrectData();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Nombercard not completely. Month and year more than two years")
    void monthAndYearMoreTwoYearsNumbercarNotCompletelyDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number7"));
        dashboardPage.inCorrectData();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Year minus")
    void YearMinusDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number8"));
        dashboardPage.inCorrectDataYear();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Year more than two years")
    void YearMoreTwoYearsDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number9"));
        dashboardPage.inCorrectDataYear();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Year zero")
    void YearZeroDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number10"));
        dashboardPage.inCorrectDataYear();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Year empty")
    void YearEmptyDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number11"));
        dashboardPage.inCorrectDataYear();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Month minus")
    void MonthMinusDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number12"));
        dashboardPage.inCorrectDataMonth();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Month more. Year more than two years")
    void MonthMoreYearMoreTwoYearsDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number13"));
        dashboardPage.inCorrectDataMonthAndYear();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Month zero")
    void MontZeroDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number14"));
        dashboardPage.inCorrectDataMonth();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. There is no month")
    void ThereNoMonthDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number15"));
        dashboardPage.inCorrectDataMonth();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Month empty")
    void MonthEmptyDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number16"));
        dashboardPage.inCorrectDataMonth();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Name by first letter")
    void NameFirstLetterDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number17"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Name colon")
    void NameСolonDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number18"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Name numbers")
    void NameNumbersDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number19"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Name seamlessly")
    void NameSeamlesslyDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number20"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Name minus")
    void NameMinusDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number21"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Name star")
    void NameStarDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number22"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Name plus")
    void NamePlusDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number23"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Name dash")
    void NameDashDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number24"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Name empty")
    void NameEmptyDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number25"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Сvc one digit")
    void СvcOneDigitDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number26"));
        dashboardPage.inCorrectDataCvc();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour. Сvc three zeros")
    void СvcThreeZerosDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number27"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validData().getNewDB(), Data.reckon());
        assertEquals(DataHelper.validData().getPrice(), Data.debitCardDetails().getAmount());
        assertEquals(DataHelper.validData().getStatus(), Data.debitCardDetails().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour. Сvc empty")
    void СvcEmptyDebit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getContinueButton(DataHelper.generateUser("number28"));
        dashboardPage.inCorrectDataCvc();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Everything is filled")
    void everythingFilledCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number1"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validDataCredit().getNewDB(), Data.reckon());
        assertEquals(DataHelper.validDataCredit().getPrice(), Data.creditCardDetails().getAmount());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.creditCardDetails().getStatus());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.creditData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Year more than two years")
    void YearMoreTwoYearsCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number2"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validDataCredit().getNewDB(), Data.reckon());
        assertEquals(DataHelper.validDataCredit().getPrice(), Data.creditCardDetails().getAmount());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.creditCardDetails().getStatus());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.creditData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name by first letter")
    void nameFirstLetterCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number3"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validDataCredit().getNewDB(), Data.reckon());
        assertEquals(DataHelper.validDataCredit().getPrice(), Data.creditCardDetails().getAmount());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.creditCardDetails().getStatus());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.creditData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Month and year more than two years")
    void monthAndYearMoreTwoYearsCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number4"));
        dashboardPage.noValidPopUp();
        assertEquals(DataHelper.noValidDataCredit().getNewDB(), Data.reckon());
        assertEquals(DataHelper.noValidDataCredit().getStatus(), Data.creditData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Month and year more than two years. Numbercard zero")
    void monthAndYearMoreTwoYearsNumbercardZeroDebitCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number5"));
        dashboardPage.noValidPopUp();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Month and year more than two years. Numbercard empty")
    void monthAndYearMoreTwoYearsNumbercardEmptyCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number6"));
        dashboardPage.inCorrectDataNumdercard();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Nombercard not completely. Month and year more than two yearsd")
    void monthAndYearMoreTwoYearsNumbercardNotCompletelyCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number7"));
        dashboardPage.inCorrectDataNumdercard();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Year minus")
    void YearMinusCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number8"));
        dashboardPage.inCorrectDataYear();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Year more than two years")
    void YearMoreTwoYearsCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number9"));
        dashboardPage.inCorrectDataYear();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Year zero")
    void YearZeroCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number10"));
        dashboardPage.inCorrectDataYaer();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("MPurchasing a tour on credit. Year empty")
    void YearEmptyCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number11"));
        dashboardPage.inCorrectDataYear();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Month minus")
    void MonthMinusCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number12"));
        dashboardPage.inCorrectDataMonth();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Month more. Year more than two years")
    void MonthMoreYearMoreTwoYearsCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number13"));
        dashboardPage.inCorrectDataMonthAndYear();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Month zero")
    void MonthZeroCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number14"));
        dashboardPage.inCorrectDataMonth();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. There is no month")
    void ThereNoMonthCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number15"));
        dashboardPage.inCorrectDataMonth();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Month empty")
    void MonthEmptyCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number16"));
        dashboardPage.inCorrectDataMonth();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name by first letter")
    void NameFirstLetterCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number17"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name сolon")
    void NameСolonCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number18"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name numbers")
    void NameNumbersCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number19"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name seamlessly")
    void NameSeamlesslyCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number20"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name minus")
    void NameMinusCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number21"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name star")
    void NameStarCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number22"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(),Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name plus")
    void NamePlusCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number23"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name dash")
    void NameDashCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number24"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Name empty")
    void NameEmptyCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number25"));
        dashboardPage.inCorrectDataName();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Сvc one digit")
    void СvcOneDigitCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number26"));
        dashboardPage.inCorrectDataCvc();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Сvc three zeros")
    void СvcThreeZerosCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number27"));
        dashboardPage.validPopUp();
        assertEquals(DataHelper.validDataCredit().getNewDB(), Data.reckon());
        assertEquals(DataHelper.validDataCredit().getPrice(), Data.creditCardDetails().getAmount());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.creditCardDetails().getStatus());
        assertEquals(DataHelper.validDataCredit().getStatus(), Data.creditData().getStatus());
    }

    @Test
    @DisplayName("Purchasing a tour on credit. Сvc empty")
    void СvcEmptyCredit() {
        var dashboardPage = new DashboardPage();
        dashboardPage.getBuyCreditButton(DataHelper.generateUser("number28"));
        dashboardPage.inCorrectDataCvc();
        assertEquals(DataHelper.noValidInfo().getNewDB(), Data.reckon());
    }
}
