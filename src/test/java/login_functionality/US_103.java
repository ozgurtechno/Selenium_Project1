package login_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.MyMethods;

import java.time.Duration;

import static utilities.BaseDriver.driver;

public class US_103 {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeMethod
    public void login(){
        MyMethods.login();
    }

    @Test
    public void US103(){

        MyMethods.myWait(2);

        WebElement myAccountName = driver.findElement(By.cssSelector("span[class='user-name mobileAccountName']"));
        myAccountName.click();
        MyMethods.myWait(2);

        WebElement myName = driver.findElement(By.cssSelector("div.info>div.name"));
        myName.click();
        MyMethods.myWait(1);

        Assert.assertEquals("Ozgur A.",myAccountName.getText(), "Account Name = ");

        WebElement lastNameInputBox = driver.findElement(By.name("lastName"));
        lastNameInputBox.clear();
        MyMethods.myWait(1);
        lastNameInputBox.sendKeys("12");
        MyMethods.myWait(1);

        WebElement saveBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        saveBtn.click();
        MyMethods.myWait(2);

        WebElement successMsg = driver.findElement(By.cssSelector("div.success > p[aria-live='assertive']"));

        Assert.assertEquals("profile updated successfully",successMsg.getText(),"Success message");
        MyMethods.logout();

    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
