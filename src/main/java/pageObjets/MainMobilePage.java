package pageObjets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainMobilePage {

    public static MainMobilePage mainMobilePage = new MainMobilePage();

    //----------selectors--------
    private SelenideElement firstScreenButton() {
        return $x("//a[@class='first-screen__btn _btn popup-btn']").as("Кнопка 3 бесплатных пробных урока сверху страницы");
    }

    private SelenideElement teamCasesButton() {
        return $x("//a[@class='team__cases-btn _btn popup-btn']").as("Кнопка 3 бесплатных пробных урока под преподавателями");
    }

    private ElementsCollection consultationButtons() {
        return $$x("//div[@class='_container']//a[@class='_btn-primary popup-btn']").as("Кнопка Записаться на консультацию");

    }

    private SelenideElement schoolContactButton() {
        return $x("//div[@class='addresses-contacts_tab active']/a[@class='addresses-contacts__btn _btn-primary popup-btn']")
                .as("Кнопка 3 бесплатных пробных урока под контактами школы");
    }

    private SelenideElement consultationForm() {
        return $(".popup__form-group").as("Форма записи на консультацию");
    }

    private SelenideElement footerForm() {
        return $("form#footer-form").as("Форма обратно связи в футере");
    }

    private ElementsCollection footerFormInputs() {
        return $$("form#footer-form .form-control.form-control__input").as("Поле ввода в форме обратной связи в футере");
    }

    private SelenideElement footerFormSelectSchoolDropDownButton() {
        return $("form#footer-form .select").as("Кнопка отображения списка школ");
    }

    private SelenideElement footerFormSelectSchoolFirstResult() {
        return $("form#footer-form .select .new-select__item").as("Первый элемент в списке выбора школ");
    }

    private SelenideElement footerFormQuestionInput() {
        return $("form#footer-form .form-control[name='question']").as("Поле ввода вопроса/предложения");
    }

    private SelenideElement footerFormSubmitButton() {
        return $("form#footer-form .form__btn._btn-primary").as("Кнопка Отправить");
    }

    private SelenideElement footerFormSuccessNotification() {
        return $x("//div[@id='jGrowl']//div[@class='jGrowl-message']").as("Сообщение об отправке формы");
    }


    //---------checks-----------
    @Step("Проверить появление формы для записи на консультацию при нажатии на кнопку 3 бесплатных пробных урока сверху страницы")
    public void checkFirstScreenButton() throws InterruptedException {
        checkButton(firstScreenButton());
    }

    @Step("Проверить появление формы для записи на консультацию при нажатии на кнопку 3 бесплатных пробных урока под преподавателями")
    public void checkTeamCasesButton() throws InterruptedException {
        checkButton(teamCasesButton());
    }

    @Step("Проверить появление формы для записи на консультацию при нажатии на кнопку 3 бесплатных пробных урока под контактами школы")
    public void checkSchoolContactButton() throws InterruptedException {
        checkButton(schoolContactButton());
    }

    @Step("Проверить появление формы для записи на консультацию при нажатии на кнопку Записаться на консультацию над розыгрышем")
    public void checkConsultation1Button() throws InterruptedException {
        checkButton(consultationButtons().get(0));
    }

    @Step("Проверить появление формы для записи на консультацию при нажатии на кнопку Записаться на консультацию под подарками")
    public void checkConsultation2Button() throws InterruptedException {
        checkButton(consultationButtons().get(1));
    }

    private void checkButton(SelenideElement button) throws InterruptedException {
        button.click();
        Thread.sleep(1_000);
        consultationForm().shouldBe(Condition.visible);
    }

    @Step("Проверить заполнение и отправку формы для записи на консультацию в футере")
    public void checkFooterForm() {
        footerForm().scrollTo();
        footerFormInputs().get(0).setValue("Автотест");
        footerFormInputs().get(1).setValue("+700000000000");
        footerFormSelectSchoolDropDownButton().click();
        footerFormSelectSchoolFirstResult().click();
        footerFormQuestionInput().setValue("Работает автотест! Хорошего дня :)");
        footerFormSubmitButton().click();
        footerFormSuccessNotification().shouldBe(Condition.visible);
        footerFormSuccessNotification().shouldHave(Condition.text("Форма успешно отправлена"));
    }
}
