package login_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.MyMethods;
import static utilities.BaseDriver.driver;

public class US_105 {


    @BeforeMethod
    public void login(){
        MyMethods.login();
    }

    @Test
    public void US105(){

        WebElement myAccountName = driver.findElement(By.cssSelector("span[class='user-name mobileAccountName']"));
        myAccountName.click();
        MyMethods.myWait(2);

        WebElement myName = driver.findElement(By.cssSelector("div.info>div.name"));
        myName.click();
        MyMethods.myWait(1);

        WebElement accountManagement = driver.findElement(By.partialLinkText("account management"));
        accountManagement.click();
        MyMethods.myWait(1);

        WebElement deleteBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        deleteBtn.click();
        MyMethods.myWait(1);

        WebElement deleteConfirmMsg = driver.findElement(By.cssSelector("div.dialog-content"));

        Assert.assertEquals("Are you sure you want to delete your account? Think it over long and hard!",deleteConfirmMsg.getText());

        WebElement deleteConfirmBtn = driver.findElement(By.cssSelector("button[data-test='confirmation-button']"));
        deleteConfirmBtn.click();

    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
