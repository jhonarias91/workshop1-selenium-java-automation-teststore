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

        /*WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement toggle1Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='sidebar' and @class='inactive']/a[@href='#sidebar' and @class='toggle']")));
        toggle1Element.click();*/

        WebElement toggle1Element = webDriver.findElement(By.xpath("//div[@id='sidebar']//a[@class='toggle']"));
        toggle1Element.click();

        WebElement accordionLink = webDriver.findElement(new By.ByXPath("//div[@id='sidebar']/descendant::a[@href='accordion.html']"));
        accordionLink.click();


        List<WebElement> elementsToggle = webDriver.findElements(new By.ByXPath("//div/[@id='sidebar']/a[@class='toggle']"));
        elementsToggle.get(0).click();

        //Assert
        WebElement hiddenMenu = webDriver.findElement(new By.ByXPath("div[@id='wrapper']/div[@id='sidebar' and @class='inactive']"));
        assert(hiddenMenu.isDisplayed());
    }

    @AfterAll
    public static void tearDown() {
        webDriver.quit();
    }
}
