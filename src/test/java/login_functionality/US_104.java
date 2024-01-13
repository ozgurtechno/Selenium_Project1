package login_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.MyMethods;

import static utilities.BaseDriver.driver;

public class US_104 {

    @BeforeMethod
    public void login(){
        MyMethods.login();
    }

    @Test
    public void US104(){

        MyMethods.myWait(2);

        WebElement myAccountName = driver.findElement(By.cssSelector("span[class='user-name mobileAccountName']"));
        myAccountName.click();
        MyMethods.myWait(2);

        WebElement myName = driver.findElement(By.cssSelector("div.info>div.name"));
        myName.click();
        MyMethods.myWait(1);

        WebElement preferences = driver.findElement(By.partialLinkText("preferences"));
        preferences.click();

        WebElement kidFriendlyToggle = driver.findElement(By.cssSelector("input[name='kidfriendly']"));
        kidFriendlyToggle.click();

        WebElement kosherToggle = driver.findElement(By.cssSelector("input[name='kosher']"));
        kosherToggle.click();

        WebElement organicToggle = driver.findElement(By.cssSelector("input[name='organic']"));
        organicToggle.click();

        MyMethods.myWait(1);

        WebElement saveBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        saveBtn.click();
        WebElement successMsg = driver.findElement(By.cssSelector("div.success > p[aria-live='assertive']"));
        System.out.println(successMsg.getText());
        MyMethods.myWait(2);

        Assert.assertEquals("profile updated successfully",successMsg.getText(), "Success message");
        MyMethods.logout();

    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
