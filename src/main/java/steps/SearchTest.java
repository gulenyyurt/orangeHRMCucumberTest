package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SearchTest {
    WebDriver driver ;

    @Given("The user have to logged in")
    public void userLogin(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        WebElement loginButton=driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();
    }

    @When("The user clicked to PIM link form left menu")
    public void pimLinkClicked() throws InterruptedException {
        Thread.sleep(5000);
        WebElement pimLink = driver.findElement(By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(2) > a"));
        pimLink.click();
    }

    @And("The user navigate to the PIM page")
    public void userNavigateToPIM(){
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @And("The user enters the employee name filter to \"123\"")
    public void userEnter123(){
        WebElement employeeName = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input"));
        employeeName.sendKeys("123");

    }

    @And("The user enters the employee id filter to \"0320\"")
    public void userEnterId123(){
        WebElement employeeId = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input"));
        employeeId.sendKeys("0320");

    }

    @And("The user clicks on the search button")
    public void userClickedSearch(){
        WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
        searchBtn.click();
    }

    @Then("the user must see the employees which are names started with \"123\"")
    public void checkRecord() throws InterruptedException {
        Thread.sleep(5000);
        WebElement firstEmployee = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]/div"));
        String name = firstEmployee.getText();
        Assert.assertEquals(name.substring(0,3),"123");
        driver.quit();
    }

    @Then("the user must see the employees which are id's equal with \"0320\"")
    public void checkIdRecord() throws InterruptedException {
        Thread.sleep(5000);
        WebElement firstEmployee = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[2]/div"));
        String id = firstEmployee.getText();
        Assert.assertEquals(id,"0320");
        driver.quit();
    }



}
