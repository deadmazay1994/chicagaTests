import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static pageObjets.MainWebPage.mainPage;

@DisplayName("Переход к форме записи на пробное занятие при клике на кнопку")
public class RedirectFromButtonToFormTests extends TestBase {

    @Test
    @DisplayName("Переход к форме заполнения данных по кнопке Получить 3 бесплатных занятия в промо разделе")
    public void promoGetFreeClassesButtonRedirectToFormTest() throws InterruptedException {
        mainPage.promoGetFreeClassesButtonClick();
        Thread.sleep(1_000);
        mainPage.checkDataEntryFormIsDisplayed();
    }

    @Test
    @DisplayName("Переход к форме заполнения данных по кнопке Записаться на 3 бесплатных пробных занятия в разделе с преподавателями")
    public void teacherGetFreeClassesButtonRedirectToFormTest() throws InterruptedException {
        mainPage.teacherGetFreeClassesButtonClick();
        Thread.sleep(1_000);
        mainPage.checkDataEntryFormIsDisplayed();
    }

    @Test
    @DisplayName("Переход к форме заполнения данных по кнопке Записаться на 3 бесплатных пробных занятия в футере")
    public void footerGetFreeClassesButtonRedirectToFormTest() throws InterruptedException {
        mainPage.footerGetFreeClassesButtonClick();
        Thread.sleep(1_000);
        mainPage.checkDataEntryFormIsDisplayed();
    }
}
