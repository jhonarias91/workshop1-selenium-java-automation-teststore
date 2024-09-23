import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class RetoTabTest {

    static WebDriver webDriver;

    @BeforeAll
    public static void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void testCloseAlert() {
        //Arrange
        webDriver.get("https://automationtesting.co.uk/browserTabs.html");

        //Geting the original window
        String originalWindow = webDriver.getWindowHandle();

        //Act
        WebElement btnSubmit = webDriver.findElement(new By.ByXPath("//form[@action='https://www.google.com']/input[@type='submit']"));
        btnSubmit.click();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));

        //Waiting until more than one window is open
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        //Getting all the windows
        Set<String> handles = webDriver.getWindowHandles();

        //Changing to the new window
        for (String handle : handles) {
            if (!handle.equals(originalWindow)) {
                webDriver.switchTo().window(handle);
                break;
            }
        }

        WebElement googleSearch = webDriver.findElement(new By.ByXPath("//div[@jsname='vdLsw']/parent::*/child::textarea[@name='q' or @class='gLFyf']"));
        googleSearch.sendKeys("Smartphones");
        googleSearch.sendKeys(Keys.ENTER);

    }

    @AfterAll
    public static void tearDown() {
        webDriver.quit();
    }
}
