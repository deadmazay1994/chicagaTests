import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.setProperty;

public class TestBase {

    @BeforeEach
    @Step("Открыть браузер и перейти на страницу chicaga.ru")
    public void setUp() {
        closeWebDriver();

        Configuration.proxyEnabled = true;
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        open("https://chicaga.ru/");
    }

    @AfterEach
    public void quit() {
        closeWebDriver();
    }

    @Step("Изменить размеры окна браузера под мобильные")
    public static void setUpMobileSize() {
        Selenide.webdriver().driver().getWebDriver().manage().window().setSize(new Dimension(428,926));
    }
}
