package login_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.BaseDriver;

import java.time.Duration;

public class UpdateAccount_Test extends BaseDriver {

    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void initTestData(){
        driver.get("https://www.lidl.com/stores");
    }
    @Test
    public void registerTest(){
        WebElement cookie = driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']"));
        wait.until(ExpectedConditions.elementToBeClickable(cookie));
        cookie.click();
        wait.until(ExpectedConditions.invisibilityOf(cookie));

        WebElement firstNameInput = driver.findElement(By.cssSelector("input[name='firstName']"));
        wait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
        firstNameInput.sendKeys("Ozgur");

        WebElement lastNameInput = driver.findElement(By.cssSelector("input[name='lastName']"));
        lastNameInput.sendKeys("Arslan");

        WebElement emailNameInput = driver.findElement(By.cssSelector("input[name='email']"));
        emailNameInput.sendKeys("ozgur.technostudy@gmail.com");

        WebElement confirmNameInput = driver.findElement(By.cssSelector("input[name='confirm_email']"));
        confirmNameInput.sendKeys("ozgur.technostudy@gmail.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='password']"));
        passwordInput.sendKeys("TechnoStudy01!");

        WebElement phoneInput = driver.findElement(By.cssSelector("input[name='phone']"));
        phoneInput.sendKeys("1598754448");

        WebElement zipInput = driver.findElement(By.cssSelector("input[name='zip']"));
        zipInput.sendKeys("22043");

        WebElement inputDate = driver.findElement(By.xpath("//input[@id='date-picker-dialog']"));
        inputDate.sendKeys("12/12/2010");

        WebElement addressInput = driver.findElement(By.cssSelector("input[name='mailingStreet']"));
        addressInput.sendKeys("2045 Personnel Or Dr");

        WebElement cityInput = driver.findElement(By.cssSelector("input[name='mailingCity']"));
        cityInput.sendKeys("Fairfax");

        Select state = new Select(driver.findElement(By.cssSelector("select[name='mailingState']")));
        state.getFirstSelectedOption();

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

    }

    @AfterTest
    public void close(){
//        driver.quit();
    }
}
