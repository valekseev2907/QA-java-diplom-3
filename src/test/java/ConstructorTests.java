import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ConstructorTests extends TestBase {

    public ConstructorTests(String browser) {
        super(browser);
    }

    @Test
    @DisplayName("Раздел «Конструктор»: переход к разделу 'Булки'")
    @Description("Проверка, что при клике на название 'Булки' переходим в этот раздел")
    public void transferForBunsIsActive() {
        mainPage.openMainPage();
        assertEquals("Булки", mainPage.getTextActiveLink());
    }

    @Test
    @DisplayName("Раздел «Конструктор»: переход к разделу 'Соусы'")
    @Description("Проверка, что при клике на название 'Соусы' переходим в этот раздел")
    public void transferForSaucesIsActive() {
        mainPage.openMainPage();
        mainPage.clickSauces();
        assertEquals("Соусы", mainPage.getTextActiveLink());
    }

    @Test
    @DisplayName("Раздел «Конструктор»: переход к разделу 'Начинки'")
    @Description("Проверка, что при клике на название 'Начинки' переходим в этот раздел")
    public void transferForFillingsIsActive() {
        mainPage.openMainPage();
        mainPage.clickFillings();
        assertEquals("Начинки", mainPage.getTextActiveLink());
    }
}
