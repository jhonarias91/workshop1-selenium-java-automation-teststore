import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Reto1LoginTest {

    static WebDriver webDriver;

    @BeforeAll
    public static void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void testCreateAccount() {
        //Arrange
        webDriver.get("https://teststore.automationtesting.co.uk/index.php");
        String userName = "Jhon Fredy";
        String lastName = "Arias";

        //Act
        WebElement userInfoElement = webDriver.findElement(new By.ByXPath("//div[@ID='_desktop_user_info']/div[@class='user-info']/a"));
        userInfoElement.click();

        WebElement createAccountElement = webDriver.findElement(new By.ByXPath("//div[@class='no-account']/child::a[contains(text(),'No account?')]"));
        createAccountElement.click();

        WebElement mrElement = webDriver.findElement(new By.ByXPath("//span[@class='custom-radio']/input[@name='id_gender' and @value='1']"));
        mrElement.click();

        WebElement firstNameElement = webDriver.findElement(new By.ByXPath("//div[contains(@class,'form-group')]/descendant::input[@id='field-firstname' or @name='firstname']"));
        firstNameElement.sendKeys(userName);

        WebElement lastNameElement = webDriver.findElement(new By.ByXPath("//div[contains(@class,'form-group')]/descendant::input[@id='field-lastname' or @name='lastname']"));
        lastNameElement.sendKeys(lastName);

        //create a random email
        final double random = Math.random()*10000;

        WebElement emailElement = webDriver.findElement(new By.ByXPath("//div[contains(@class,'form-group')]/descendant::input[@id='field-email' or @name='email']"));
        emailElement.sendKeys("jhon.f.arias"+random+"@gmail.com");

        WebElement passwordElement = webDriver.findElement(new By.ByXPath("//div[contains(@class,'form-group')]/descendant::input[@id='field-password' or @name='password']"));
        passwordElement.sendKeys("MyPss643*.?");

        WebElement birthdayElement = webDriver.findElement(new By.ByXPath("//div[contains(@class,'form-group')]/descendant::input[@id='field-birthday' or @name='birthday']"));
        birthdayElement.sendKeys("01/01/1990");

        WebElement customCheckAgree = webDriver.findElement(new By.ByXPath("//span[@class='custom-checkbox']/label/input[@name='psgdpr' and @value='1']"));
        customCheckAgree.click();

        WebElement saveButton = webDriver.findElement(new By.ByXPath("//footer[contains(@class, footer)]/button[contains(text(), 'Save')]"));
        saveButton.click();

        //Assert
        WebElement accountCreated = webDriver.findElement(new By.ByXPath("//div[@class='user-info']/descendant::span[text()='"+userName+ " "+ lastName + "']"));
        assert(accountCreated.isDisplayed());
    }

    @AfterAll
    public static void tearDown() {
        webDriver.quit();
    }
}
