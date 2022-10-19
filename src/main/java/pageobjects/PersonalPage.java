package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalPage {
    WebDriver driver;

    private final By saveButtonLocator = By.xpath("//button[text()='Сохранить']");
    private final By accountInfoLocator = By.xpath("//p[text()='В этом разделе вы можете изменить свои персональные данные']");
    private final By constructorLinkLocator = By.xpath("(//a[@href='/'])[1]");
    private final By logoLinkLocator = By.xpath("(//a[@href='/'])[2]");
    private final By exitLinkLocator = By.xpath("//button[text()='Выход']");

    public PersonalPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание загрузки элементов страницы")
    public void waitForLoadAccountPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(saveButtonLocator));
    }

    @Step("Проверка успешного перехода в личный кабинет")
    public void checkSuccessGoToPersonalAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(accountInfoLocator));
    }

    @Step("Клик по кнопке 'Конструктор'")
    public void clickConstructorLink() {
        driver.findElement(constructorLinkLocator).click();
    }

    @Step("Клик по логотипу")
    public void clickLogo() {
        driver.findElement(logoLinkLocator).click();
    }

    @Step("Клик по кнопке 'Выход'")
    public void clickExitButton() {
        driver.findElement(exitLinkLocator).click();
    }
}
