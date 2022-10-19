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

public class RegisterPage {
    WebDriver driver;

    public final By headerLocator = By.xpath(".//h2[text()='Регистрация']");
    public final By nameFiledLocator = By.xpath(".//fieldset[1]//input[@name='name']");
    public final By emailFiledLocator = By.xpath(".//fieldset[2]//input[@name='name']");
    public final By passwordFiledLocator = By.xpath(".//input[@name='Пароль']");
    public final By registerButtonLocator = By.xpath(".//button[text()='Зарегистрироваться']");
    public final By errorMessageLocator = By.xpath(".//p[text()='Некорректный пароль']");
    public final By loginLinkLocator = By.xpath(".//a[text()='Войти']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Открытие страницы")
    public void openRegisterPage() {
        driver.get(Constraints.REGISTER_URL);
    }

    @Step("Ожидание загрузки элементов странцы")
    public void waitForLoadRegisterPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
    }

    @Step("Ожидание вывода сообщения об ошибке")
    public void waitForErrorMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
    }

    @Step("Поиск сообщения об ошибке")
    public String getErrorMessage() {
        WebElement element = driver.findElement(errorMessageLocator);
        return element.getText();
    }

    @Step("Клик по ссылке 'Войти'")
    public void clickLinkEnter() {
        WebElement element = driver.findElement(loginLinkLocator);
        element.click();
    }

    @Step("Регистрация ползователя с валидными данными")
    public void registerValidUser() {
        User user = User.getFakeUser();

        WebElement name = driver.findElement(nameFiledLocator);
        name.sendKeys(user.getName());

        WebElement email = driver.findElement(emailFiledLocator);
        email.sendKeys(user.getEmail());

        WebElement password = driver.findElement(passwordFiledLocator);
        password.sendKeys(user.getPassword());

        WebElement element = driver.findElement(registerButtonLocator);
        element.click();
    }

    @Step("Регистрация ползователя с невалидными данными")
    public void registerInvalidUser() {
        User user = User.getFakeUserWithShortPassword();

        WebElement name = driver.findElement(nameFiledLocator);
        name.sendKeys(user.getName());

        WebElement email = driver.findElement(emailFiledLocator);
        email.sendKeys(user.getEmail());

        WebElement password = driver.findElement(passwordFiledLocator);
        password.sendKeys(user.getPassword());

        WebElement element = driver.findElement(registerButtonLocator);
        element.click();
    }
}