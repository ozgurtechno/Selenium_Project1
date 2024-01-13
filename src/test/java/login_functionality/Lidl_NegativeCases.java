package login_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseDriver;
import utilities.MyMethods;

public class Lidl_NegativeCases extends BaseDriver {


    @Test
    public void registerNegative(){

        driver.get("https://www.lidl.com/");

        MyMethods.cookies();
        MyMethods.myWait(2);

        WebElement signIn = driver.findElement(By.cssSelector("li.sign-in"));
        signIn.click();
        MyMethods.myWait(2);

        WebElement joinMyLidl = driver.findElement(By.cssSelector("a[data-test='register']"));
        joinMyLidl.click();
        MyMethods.myWait(2);

        WebElement submit = driver.findElement(By.cssSelector("div[class='spinnie-container']"));
        submit.click();
        MyMethods.myWait(2);

        WebElement  NameInputErrorMsg = driver.findElement(By.xpath("(//p[contains(@id, 'helper-text')])[1]"));
        Assert.assertEquals("Error message = ","Enter first name.",NameInputErrorMsg.getText());

        WebElement  lastNameInputErrorMsg = driver.findElement(By.xpath("(//p[contains(@id, 'helper-text')])[2]"));
        Assert.assertEquals("Error message = ","Enter last name.",lastNameInputErrorMsg.getText());

        WebElement emailErrorMsg =driver.findElement(By.xpath("(//p[contains(@id, 'helper-text')])[3]"));
        Assert.assertEquals("Error message = ","Enter a valid email address.",emailErrorMsg.getText());

        WebElement passwordErrorMsg =driver.findElement(By.xpath("(//p[contains(@id, 'helper-text')])[4]"));
        Assert.assertEquals("Error message = ","Enter a valid password.", passwordErrorMsg.getText());

        WebElement phoneErrorMsg =driver.findElement(By.xpath("(//p[contains(@id, 'helper-text')])[5]"));
        Assert.assertEquals("Error message = ","Enter a valid phone number.", phoneErrorMsg.getText());

        WebElement zipCodeErrorMsg =driver.findElement(By.xpath("(//p[contains(@id, 'helper-text')])[6]"));
        Assert.assertEquals("Error message = ","Enter a valid zipcode.", zipCodeErrorMsg.getText());

        WebElement birthdayErrorMsg =driver.findElement(By.xpath("(//p[contains(@id, 'helper-text')])[7]"));
        Assert.assertEquals("Error message = ","Enter a valid birthday.", birthdayErrorMsg.getText());
        waitAndQuit();
    }

    @Test
    public void emailMatch(){

        driver.get("https://www.lidl.com/");

        MyMethods.cookies();
        MyMethods.myWait(2);

        WebElement signIn = driver.findElement(By.cssSelector("li.sign-in"));
        signIn.click();
        MyMethods.myWait(2);

        WebElement joinMyLidl = driver.findElement(By.cssSelector("a[data-test='register']"));
        joinMyLidl.click();

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("ndougherty19@gmail.com");
        MyMethods.myWait(2);

        WebElement confirmEmailInputBox = driver.findElement(By.name("confirm_email"));
        confirmEmailInputBox.sendKeys("ndougherty@gmail.com");
        MyMethods.myWait(2);

        WebElement emailMatchErrorMsg = driver.findElement(By.cssSelector("p[id$='helper-text']"));
        Assert.assertEquals("Email match error message = ","Emails do not match",emailMatchErrorMsg.getText());

        waitAndQuit();
    }
}