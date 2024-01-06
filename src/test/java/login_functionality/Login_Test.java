package login_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.BaseDriver;

import java.time.Duration;

public class Login_Test extends BaseDriver {

    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void initTestData(){
        driver.get("https://www.lidl.com");
    }
    @Test
    public void loginTest(){
        WebElement signinbutton = driver.findElement(By.xpath("//a[.='sign in']"));
        wait.until(ExpectedConditions.elementToBeClickable(signinbutton));
        signinbutton.click();

        WebElement cookie = driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']"));
        wait.until(ExpectedConditions.visibilityOf(cookie));
        cookie.click();
        wait.until(ExpectedConditions.invisibilityOf(cookie));

        WebElement joinMyLidlButton = driver.findElement(By.xpath("(//a[.='join myLidl'])[1]"));
        actions.moveToElement(joinMyLidlButton);
        wait.until(ExpectedConditions.elementToBeClickable(joinMyLidlButton));
        joinMyLidlButton.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.lidl.com/register");

    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}
