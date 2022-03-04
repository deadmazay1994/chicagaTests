package pageObjets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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
    public void checkBigPrizeButton() throws InterruptedException {
        checkPrizeButton(wantPrizeButtons().get(0));
    }

    @Step("Проверить открытие формы заявления на участие в розыгрыже при клике на кнопку Хочу с Mercedes")
    public void checkMiddlePrizeButton() throws InterruptedException {
        checkPrizeButton(wantPrizeButtons().get(1));
    }

    @Step("Проверить открытие формы заявления на участие в розыгрыже при клике на кнопку Хочу с Beauty Box")
    public void checkKatyaPrizeButton() throws InterruptedException {
        checkPrizeButton(wantPrizeButtons().get(2));
    }

    @Step("Проверить открытие формы заявления на участие в розыгрыже при клике на кнопку Хочу в мобильной версии сайта")
    public void checkMobilePrizeButton() throws InterruptedException {
        switchTo().frame(frame());
        mobilePrizeButton().click();
        mobilePrizeForm().shouldBe(Condition.visible);
    }

    private void checkPrizeButton(SelenideElement prizeButton) throws InterruptedException {
        switchTo().frame(frame());
        prizeButton.click();
        prizeForm().shouldBe(Condition.visible);
    }

    @Step("Проверить заполнение и отправку формы розыгрыша")
    public void checkPrizeForm() throws InterruptedException {
        switchTo().frame(frame());
        wantPrizeButtons().get(1).click();
        prizeForm().shouldBe(Condition.visible);
        prizeFormNameInput().setValue("Автотест");
        prizeFormPhoneInput().setValue("+700000000000");
        prizeFormSelectSchoolDropDown().click();
        prizeFormSelectSchoolChoice().click();
        Thread.sleep(100);
        prizeFormSubmitButton().click();
        Thread.sleep(100);
        prizeFormTitle().shouldHave(Condition.text("Форма успешно отправлена"));
    }
}
