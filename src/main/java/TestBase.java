import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static java.lang.System.setProperty;

public class TestBase {

    @BeforeEach
    @Step("Открыть браузер и перейти на страницу chicaga.ru")
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        closeWebDriver();
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        open("https://chicaga.ru/");
    }

    @AfterEach
    public void quit() {
        closeWebDriver();
    }

    @Step("Изменить размеры окна браузера под мобильные")
    public static void setUpMobileSize() {
        WebDriverRunner.driver().getWebDriver().manage().window().setSize(new Dimension(428, 926));
        webdriver().shouldHave(url("https://m.chicaga.ru/"), Duration.ofSeconds(30));
    }
}
