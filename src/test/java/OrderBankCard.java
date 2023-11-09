import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderBankCard {
    private WebDriver driver;

    @BeforeEach
    void setUp() { driver = new ChromeDriver(); }


    @BeforeAll
    public static void setupAll() {

        System.setProperty("WebDriver.chrome.driver","driver/chromedriver");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }


    @Test
    void shouldTestSomething () throws InterruptedException {
        driver.get("http://0.0.0.0:9999/");

        List<WebElement> elements = driver.findElements(By.className("input__control"));
        elements.get(0).sendKeys("Степанова Анна");
        elements.get(1).sendKeys("+79992224088");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button__content")).click();

        String text = driver.findElement(By.className("paragraph_theme_alfa-on-white")).getText();
        assertEquals ("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время." , text.trim());
    }
}