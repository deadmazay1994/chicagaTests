package pageObjets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainWebPage {

    public static MainWebPage mainPage = new MainWebPage();

    //----------selectors--------
    private SelenideElement promoGetFreeClassesButton() {
        return $x("//div[@class='promo__main']/a[@class='button promo__button js-scrollto']/div[text()='Получить 3 бесплатных пробных занятия']")
                .as("Кнопка Получить 3 бесплатных занятия в промо разделе");
    }

    private SelenideElement teacherGetFreeClassesButton() {
        return $x("//div[@class='teachers__footer']/a[@class='button teachers__button js-scrollto']/div[text()='записаться на 3 бесплатных пробных занятия']")
                .as("Кнопка Записаться на 3 бесплатных пробных занятия в разделе с преподавателями");
    }

    private SelenideElement footerGetFreeClassesButton() {
        return $x("//div[@class='page-footer__footer']/a[@class='button page-footer__button js-scrollto']/div[text()='записаться на 3 бесплатных пробных занятия']")
                .as("Кнопка Записаться на 3 бесплатных пробных занятия в футере");
    }

    private SelenideElement getFreeClassesForm() {
        return $(".feedback__container.container form.feedback__form")
                .as("Форма ввода данных для записи на бесплатные пробные занятия");
    }

    private SelenideElement getFreeClassesFormInput(String inputName) {
        return $(".form__input[data-name='" + inputName + "']").as("Поле ввода " + inputName);
    }

    private SelenideElement getFreeClassesFormSchoolDropDown() {
        return $(".form__field .selection").as("Выбор школы");
    }

    private SelenideElement getFreeClassesFormSchoolChoice() {
        return $x("//li[contains(@id, 'Школа в Купчино')]").as("Школа в Купчино");
    }

    private SelenideElement getFreeClassesFormSubmitButton() {
        return $(".button.form__send").as("Кнопка отпавки формы Записаться на 3 бесплатных пробных занятия");
    }

    private SelenideElement thanksTitle() {
        return $(".title-thanks").as("Заголовок страницы после отправки формы");
    }

    //---------methods-----------
    @Step("Нажать на кнопку Получиться 3 бесплатных занятия в промо разделе")
    public void promoGetFreeClassesButtonClick() {
        promoGetFreeClassesButton().click();
    }

    @Step("Нажать на кнопку Записаться на 3 бесплатных пробных занятия в разделе с преподавателями")
    public void teacherGetFreeClassesButtonClick() {
        teacherGetFreeClassesButton().scrollTo();
        teacherGetFreeClassesButton().click();
    }

    @Step("Нажать на кнопку Записаться на 3 бесплатных пробных занятия в футере")
    public void footerGetFreeClassesButtonClick() {
        teacherGetFreeClassesButton().scrollTo();
        footerGetFreeClassesButton().click();
    }

    //---------checks-----------
    @Step("Проверить переход к форме заполнения данных")
    public void checkDataEntryFormIsDisplayed() {
        JavascriptExecutor executor = (JavascriptExecutor) Selenide.webdriver().driver().getWebDriver();
        Long actualY = (Long) executor.executeScript("return window.pageYOffset;");
        int expectedY = getFreeClassesForm().getCoordinates().onPage().getY();
        Assertions.assertTrue(expectedY >= actualY + 100 && expectedY <= actualY + 150,
                "Изменения по кординате Y " + actualY + " не соответствует кординате Y расположения формы заполнения данных " + expectedY);
    }

    @Step("Проверить заполнение и отправку формы на получение бесплатных пробных занятий")
    public void checkGetFreeClassesForm() {
        getFreeClassesForm().scrollTo();
        getFreeClassesFormInput("Имя").setValue("Автотест");
        getFreeClassesFormInput("Телефон").setValue("+7000000000");
        getFreeClassesFormSchoolDropDown().click();
        getFreeClassesFormSchoolChoice().click();
        getFreeClassesFormSubmitButton().click();

        webdriver().shouldHave(url("https://chicaga.ru/thank-online/"), Duration.ofSeconds(30));
        thanksTitle().shouldHave(Condition.text("Cпасибо за заявку!"));
    }
}
