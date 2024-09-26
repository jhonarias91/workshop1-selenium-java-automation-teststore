import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RetoIAlertTest {

    static WebDriver webDriver;

    @BeforeAll
    public static void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void testCloseAlert() {
        //Arrange
        webDriver.get("https://automationtesting.co.uk/popups.html");

        //Act
        WebElement triggerAlertBtn = webDriver.findElement(new By.ByXPath("//div[@class='row']/child::div/button[contains(text(),'Alert')]"));
        triggerAlertBtn.click();

        // As with the iframe, we also need to change to the alert context
        Alert alert = webDriver.switchTo().alert();
        alert.accept();

    }

    @AfterAll
    public static void tearDown() {
        webDriver.quit();
    }
}
