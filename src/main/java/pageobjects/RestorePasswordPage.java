package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdata.constraints.Constraints;

import java.time.Duration;

public class RestorePasswordPage {
    WebDriver driver;

    public final By headerLocator = By.xpath(".//h2[text()='Восстановление пароля']");
    public final By linkEnterLocator = By.xpath(".//a[text()='Войти']");

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы")
    public void openRestorePasswordPage() {
        driver.get(Constraints.RESTORE_URL);
    }

    @Step("Ожидание загрузки элементов странцы")
    public void waitForLoadRestorePage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
    }

    @Step("Клик по ссылке 'Войти'")
    public void clickLinkEnter() {
        WebElement element = driver.findElement(linkEnterLocator);
        element.click();
    }
}
