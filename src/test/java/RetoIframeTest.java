import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RetoIframeTest {

    static WebDriver webDriver;

    @BeforeAll
    public static void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void testCreateAccount() {
        //Arrange
        webDriver.get("https://automationtesting.co.uk/iframes.html");

        //Act
        //We need to switch to the iframe context to be able to interact with it.
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//div/iframe[@src='index.html']")));

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        WebElement toggle1Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='sidebar']//a[@class='toggle']")));
        toggle1Element.click();

        WebElement accordionLink = webDriver.findElement(new By.ByXPath("//div[@id='sidebar']/descendant::a[@href='accordion.html']"));
        accordionLink.click();

        //We need to switch back to the main context
        webDriver.switchTo().defaultContent();
        List<WebElement> elementsToggle = webDriver.findElements(new By.ByXPath("//div[@id='sidebar']/a[@class='toggle']"));
        elementsToggle.get(0).click();

        //Assert
        WebElement hiddenMenu = webDriver.findElement(new By.ByXPath("//div[@id='wrapper']/div[@id='sidebar' and @class='inactive']"));
        assert(hiddenMenu.isDisplayed());
    }

    @AfterAll
    public static void tearDown() {
        webDriver.quit();
    }
}
