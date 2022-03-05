import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static pageObjets.MainMobilePage.mainMobilePage;

@DisplayName("Мобильная версия - переход к форме записи на консультацию при клике на кнопку")
public class MobileRedirectFromButtonToFormTests extends TestBase {

    @Test
    @DisplayName("Переход к форме записи на консультацию при нажатии на кнопку 3 бесплатных пробных урока сверху страницы")
    public void firstScreenButtonRedirectToFormTest() {
        setUpMobileSize();
        mainMobilePage.checkFirstScreenButton();
    }

    @Test
    @DisplayName("Переход к форме записи на консультацию при нажатии на кнопку 3 бесплатных пробных урока под преподавателями")
    public void teamCasesButtonButtonRedirectToFormTest() {
        setUpMobileSize();
        mainMobilePage.checkTeamCasesButton();
    }

    @Test
    @DisplayName("Переход к форме записи на консультацию при нажатии на кнопку 3 бесплатных пробных урока под контактами школы")
    public void schoolContactButtonRedirectToFormTest() {
        setUpMobileSize();
        mainMobilePage.checkSchoolContactButton();
    }

    @Test
    @DisplayName("Переход к форме записи на консультацию при нажатии на кнопку Записаться на консультацию над розыгрышем")
    public void consultation1ButtonRedirectToFormTest() {
        setUpMobileSize();
        mainMobilePage.checkConsultation1Button();
    }

    @Test
    @DisplayName("Переход к форме записи на консультацию при нажатии на кнопку Записаться на консультацию под подарками")
    public void consultation2ButtonRedirectToFormTest() {
        setUpMobileSize();
        mainMobilePage.checkConsultation2Button();
    }
}
