package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdata.constraints.Constraints;

import java.time.Duration;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public final By headerLocator = By.xpath(".//h1");
    public final By loginButtonLocator = By.xpath(".//button[text()='Войти в аккаунт']");
    public final By linkPersonalAccountLocator = By.xpath(".//p[text()='Личный Кабинет']");
    public final By activeLinkLocator = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span");
    public final By saucesLocator = By.xpath(".//main/section[1]/div[1]/div[2]");
    public final By fillingsLocator = By.xpath(".//main/section[1]/div[1]/div[3]");
    public final By createOrderButtonLocator = By.xpath(".//button[text()='Оформить заказ']");

    @Step("Открытие страницы")
    public void openMainPage() {
        driver.get(Constraints.MAIN_URL);
    }

    @Step("Ожидание загрузки элементов странцы")
    public void waitForLoadMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
    }

    @Step("Клик по кнопке 'Вход'")
    public void clickLoginButton() {
        WebElement element = driver.findElement(loginButtonLocator);
        element.click();
    }

    @Step("Клик по ссылке 'Личный кабинет'")
    public void clickLinkPersonalAccount() {
        WebElement element = driver.findElement(linkPersonalAccountLocator);
        element.click();
    }

    @Step("Поиск текста активного элемента")
    public String getTextActiveLink() {
        WebElement element = driver.findElement(activeLinkLocator);
        return element.getText();
    }

    @Step("Клик по элементу 'Соусы'")
    public void clickSauces() {
        WebElement element = driver.findElement(saucesLocator);
        element.click();
    }

    @Step("Клик по элементу 'Начинки'")
    public void clickFillings() {
        WebElement element = driver.findElement(fillingsLocator);
        element.click();
    }

    @Step("Поиск кнопки 'Оформить заказ'")
    public String findCreateOrderButton() {
        return driver.findElement(createOrderButtonLocator).getText();
    }
}
