import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static pageObjets.PrizesPage.prizesPage;

@DisplayName("Переход к форме подачи заявки и участия в конкурсе при клике на кнопки Хочу")
public class WantPrizeTests extends TestBase {

    @Test
    @DisplayName("Открытие формы подачи заявки и участия в конкурсе под iPhone13")
    public void bigPrizeButtonTest() throws InterruptedException {
        prizesPage.checkBigPrizeButton();
    }

    @Test
    @DisplayName("Открытие формы подачи заявки и участия в конкурсе под Mercedes")
    public void middlePrizeButtonTest() throws InterruptedException {
        prizesPage.checkMiddlePrizeButton();
    }

    @Test
    @DisplayName("Открытие формы подачи заявки и участия в конкурсе под Beauty Box")
    public void katyaPrizeButtonTest() throws InterruptedException {
        prizesPage.checkKatyaPrizeButton();
    }

    @Test
    @DisplayName("Мобильная версия - Открытие формы подачи заявки и участия в конкурсе")
    public void mobilePrizeButtonTest() throws InterruptedException {
        setUpMobileSize();
        Thread.sleep(1_000);
        prizesPage.checkMobilePrizeButton();
    }
}
