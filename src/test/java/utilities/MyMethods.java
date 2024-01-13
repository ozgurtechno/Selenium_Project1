package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.BaseDriver.driver;

public class MyMethods {
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void myWait(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cookies(){
        myWait(3);
        WebElement cookie = driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']"));
//            wait.until(ExpectedConditions.visibilityOf(cookie));
//            wait.until(ExpectedConditions.elementToBeClickable(cookie));
        cookie.click();
        wait.until(ExpectedConditions.invisibilityOf(cookie));
    }


    public static void login(){
        driver.get("https://www.lidl.com");
        cookies();
        myWait(1);
        WebElement signIn = driver.findElement(By.cssSelector("a[href=\"/login\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(signIn));
        signIn.click();

        WebElement loginEmail = driver.findElement(By.cssSelector("input[type=\"email\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(loginEmail));
        loginEmail.sendKeys("ozgur.technostudy@gmail.com");

        WebElement loginPassword = driver.findElement(By.cssSelector("input[type=\"password\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(loginPassword));
        loginPassword.sendKeys("TechnoStudy01!");

        WebElement signInButton = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();

    }

    public static void logout(){

        WebElement myAccountName = driver.findElement(By.cssSelector("span[class='user-name mobileAccountName']"));
        myAccountName.click();
        MyMethods.myWait(1);

        WebElement signOut = driver.findElement(By.cssSelector("li[data-test='signOut']"));
        signOut.click();
        MyMethods.myWait(2);
    }
}