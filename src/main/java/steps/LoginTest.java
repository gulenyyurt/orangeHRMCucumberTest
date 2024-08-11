package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver ;

    @Given("The user is open the OrangeHRM login page")
    public void theUserIsOpenOrangeHRMLoginPage(){
        driver=new ChromeDriver();
        driver .manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    @When ("The user enters valid username and password")
    public void theUserEntersValidUsernameAndPassword() throws InterruptedException {
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        Thread.sleep(2000);
    }
    @And ("The user clicks on the login button")
    public void theUserClicksOnTheLoginButton(){
        WebElement loginButton=driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();
    }
    @Then ("The user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard(){
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(expectedUrl,actualUrl);
        driver.quit();
    }

    @When ("The user enters invalid username and password")
    public void theUserEntersInvalidUsernameAndPassword() throws InterruptedException {
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        username.sendKeys("deneme");
        password.sendKeys("deneme123");
        Thread.sleep(2000);
    }

    @Then ("The user shown an error message in display")
    public void theUserShownAnErrorMessageInDisplay(){
        WebElement errorMessage=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
        String expectedMessage="Invalid credentials";
        String actualMessage=errorMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        driver.quit();

    }
    @When ("The user enters invalid username and valid password")
    public void theUserEntersInvalidUsernameAndValidPassword() throws InterruptedException {
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        username.sendKeys("deneme");
        password.sendKeys("admin123");
        Thread.sleep(2000);
    }
    @When ("The user enters valid username and invalid password")
    public void theUserEntersValidUsernameAndInvalidPassword() throws InterruptedException {
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        username.sendKeys("Admin");
        password.sendKeys("deneme123");
        Thread.sleep(2000);
    }

}
