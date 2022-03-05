package pageObjets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PrizesPage {

    public static PrizesPage prizesPage = new PrizesPage();

    //----------selectors--------
    private SelenideElement frame() {
        return $("iframe#promotion");
    }

    private ElementsCollection wantPrizeButtons() {
        return $$(".prize__button.modal-open");
    }

    private SelenideElement mobilePrizeButton() {
        return $(".button.modal-open").as("Кнопка Хочу");
    }

    private SelenideElement prizeForm() {
        return $(".modal__form").as("Форма ввода данных для участия в розыгрыше");
    }

    private SelenideElement mobilePrizeForm() {
        return $(".modal__form").as("Форма ввода данных для участия в розыгрыше в мобильной версии");
    }

    private SelenideElement prizeFormNameInput() {
        return $("input#name").as("Поле ввода имени");
    }

    private SelenideElement prizeFormPhoneInput() {
        return $("input#phone").as("Поле ввода телефона");
    }

    private SelenideElement prizeFormSelectSchoolDropDown() {
        return $("select#school").as("Поле выбора школы");
    }

    private SelenideElement prizeFormSelectSchoolChoice() {
        return $("select#school option[value='Школа в Купчино']").as("Школа в Купчино");
    }

    private SelenideElement prizeFormSubmitButton() {
        return $(".modal__button").as("Кнопка Отправить");
    }

    private SelenideElement prizeFormTitle() {
        return $("#modal .modal__title").as("Заголовок окна формы");
    }

    //---------checks-----------
    @Step("Проверить открытие формы заявления на участие в розыгрыже при клике кнопку Хочу c iPhone13")
    public void checkBigPrizeButton() {
        checkPrizeButton(wantPrizeButtons().get(0));
    }

    @Step("Проверить открытие формы заявления на участие в розыгрыже при клике на кнопку Хочу с Mercedes")
    public void checkMiddlePrizeButton() {
        checkPrizeButton(wantPrizeButtons().get(1));
    }

    @Step("Проверить открытие формы заявления на участие в розыгрыже при клике на кнопку Хочу с Beauty Box")
    public void checkKatyaPrizeButton() {
        checkPrizeButton(wantPrizeButtons().get(2));
    }

    @Step("Проверить открытие формы заявления на участие в розыгрыже при клике на кнопку Хочу в мобильной версии сайта")
    public void checkMobilePrizeButton() {
        switchTo().frame(frame());
        mobilePrizeButton().click();
        mobilePrizeForm().shouldBe(visible);
    }

    private void checkPrizeButton(SelenideElement prizeButton) {
        switchTo().frame(frame());
        prizeButton.click();
        prizeForm().shouldBe(visible);
    }

    @Step("Проверить заполнение и отправку формы розыгрыша")
    public void checkPrizeForm() throws InterruptedException {
        switchTo().frame(frame());
        wantPrizeButtons().get(1).click();
        prizeForm().shouldBe(visible);
        prizeFormNameInput().setValue("Автотест");
        prizeFormPhoneInput().setValue("+700000000000");
        prizeFormSelectSchoolDropDown().click();
        prizeFormSelectSchoolChoice().click();
        prizeFormSubmitButton().shouldBe(visible, Duration.ofSeconds(3)).click();
        Thread.sleep(100);
        prizeFormTitle().shouldBe(visible);
        prizeFormTitle().shouldHave(text("Форма успешно отправлена"));
    }
}
