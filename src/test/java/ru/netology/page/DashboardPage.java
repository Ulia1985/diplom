package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {

    private SelenideElement tourName = $x("//h2[contains (text(), 'Путешествие дня')]");
    private SelenideElement tourPic = $x("//img[@alt='Марракэш']");
    private SelenideElement headingInCredit = $x("//h3[contains (text(), 'Кредит по данным карты')]");
    private SelenideElement headingCardPayment = $x("//h3[contains (text(), 'Оплата по карте')]");
    private SelenideElement bayButton = $x("//button[.//*[(text()='Купить')]]");
    private SelenideElement creditButton = $x("//button[.//*[(text()='Купить в кредит')]]");
    private SelenideElement numberField = $x("//span[(text()='Номер карты')]/..//input");
    private SelenideElement numberFieldFilledIncorrectly = $x("//span[(text()='Номер карты')]/..//span[@class='input__sub']");
    private SelenideElement monthField = $x("//span[(text()='Месяц')]/..//input");
    private SelenideElement monthFieldFilledIncorrectly = $x("//span[(text()='Месяц')]/..//span[@class='input__sub']");
    private SelenideElement yearField = $x("//span[(text()='Год')]/..//input");
    private SelenideElement yearFieldFilledIncorrectly = $x("//span[(text()='Год')]/..//span[@class='input__sub']");
    private SelenideElement nameField = $x("//span[(text()='Владелец')]/..//input");
    private SelenideElement nameFieldFilledIncorrectly = $x("//span[(text()='Владелец')]/..//span[@class='input__sub']");
    private SelenideElement securityCodesField = $x("//span[(text()='CVC/CVV')]/..//input");
    private SelenideElement securityCodesFieldFilledIncorrectly = $x("//span[(text()='CVC/CVV')]/..//span[@class='input__sub']");
    private SelenideElement sendButton = $x("//button[.//*[(text()='Продолжить')]]");
    private SelenideElement iconTitleGood = $x("//div[(text()='Успешно')]");
    private SelenideElement iconTextGood = $x("//div[(text()='Успешно')]/..//div[@class='notification__content']");
    private SelenideElement iconGood = $x("//div[(text()='Успешно')]/..//button");
    private SelenideElement iconTitleBad = $x("//div[(text()='Ошибка')]");
    private SelenideElement iconTextBad = $x("//div[(text()='Ошибка')]/..//div[@class='notification__content']");
    private SelenideElement iconBad = $x("//div[(text()='Ошибка')]/..//button");

    public DashboardPage() {
        tourName.shouldBe(visible);
        tourPic.isImage();
    }

    public void getBayTourButton(DataHelper.CardDetails user) {
        bayButton.click();
        headingCardPayment.shouldBe(visible);
        cardDataEntry(user);
    }

    public void getCreditTourButton(DataHelper.CardDetails user) {
        creditButton.click();
        headingInCredit.shouldBe(visible);
        cardDataEntry(user);
    }

    public void cardDataEntry(DataHelper.CardDetails user) {
        numberField.setValue(user.getNumbercard());
        monthField.setValue(user.getMonth());
        yearField.setValue(user.getYear());
        nameField.setValue(user.getName());
        securityCodesField.setValue(user.getCvc());
        sendButton.click();
    }

    public void validPopUp() {
        iconTitleGood.shouldBe(Condition.visible, Duration.ofSeconds(15));
        iconTextGood.shouldHave(Condition.text("Операция одобрена Банком.")).shouldBe(Condition.visible);
        iconGood.click();
    }

    public void noValidPopUp() {
        iconTitleBad.shouldBe(Condition.visible, Duration.ofSeconds(15));
        iconTextBad.shouldHave(Condition.text("Ошибка! Банк отказал в проведении операции.")).shouldBe(Condition.visible);
        iconBad.click();
    }

    public void numberNoCorrect() {
        numberFieldFilledIncorrectly.shouldHave(Condition.text("Неверный формат")).shouldBe(Condition.visible);
    }

    public void monthNoCorrect() {
        monthFieldFilledIncorrectly.shouldHave(Condition.text("Неверный формат")).shouldBe(Condition.visible);
    }

    public void monthCardExpired() {
        monthFieldFilledIncorrectly.shouldHave(Condition.text("Истёк срок действия карты")).shouldBe(Condition.visible);
    }

    public void monthInvalidCardDate() {
        monthFieldFilledIncorrectly.shouldHave(Condition.text("Неверно указан срок действия карты")).shouldBe(Condition.visible);
    }

    public void yearNotCorrect() {
        yearFieldFilledIncorrectly.shouldHave(Condition.text("Неверный формат")).shouldBe(Condition.visible);
    }

    public void yearCardExpired() {
        yearFieldFilledIncorrectly.shouldHave(Condition.text("Истёк срок действия карты")).shouldBe(Condition.visible);
    }

    public void yearInvalidCardDate() {
        yearFieldFilledIncorrectly.shouldHave(Condition.text("Неверно указан срок действия карты")).shouldBe(Condition.visible);
    }

    public void nameNoCorrect() {
        nameFieldFilledIncorrectly.shouldHave(Condition.text("Поле обязательно для заполнения")).shouldBe(Condition.visible);
    }

    public void securityCodesNoCorrect() {
        securityCodesFieldFilledIncorrectly.shouldHave(Condition.text("Неверный формат")).shouldBe(Condition.visible);
    }
}
