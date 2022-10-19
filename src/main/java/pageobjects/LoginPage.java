package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdata.constraints.Constraints;
import testdata.models.User;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public final String url = Constraints.LOGIN_URL;

    public String getUrl() {
        return url;
    }

    public final By headerLocator = By.xpath(".//h2[text()='Вход']");
    public final By emailFieldLocator = By.xpath(".//input[@name='name']");
    public final By passwordFieldLocator = By.xpath(".//input[@name='Пароль']");
    public final By enterButtonLocator = By.xpath(".//button[text()='Войти']");

    @Step("Ожидание загрузки элементов страницы")
    public void waitForLoadLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
    }

    @Step("Открытие страницы")
    public void openLoginPage() {
        driver.get(url);
    }

    @Step("Авторизация пользоватля")
    public void login() {
        User user = User.getValidUser();

        WebElement email = driver.findElement(emailFieldLocator);
        email.sendKeys(user.getEmail());

        WebElement password = driver.findElement(passwordFieldLocator);
        password.sendKeys(user.getPassword());

        WebElement element = driver.findElement(enterButtonLocator);
        element.click();
    }
}
