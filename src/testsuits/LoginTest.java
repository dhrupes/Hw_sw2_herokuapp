package testsuits;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import javax.print.DocFlavor;

public class LoginTest extends Utility {

/* 3. Write down the following test into ‘LoginTest’ class
1. userSholdLoginSuccessfullyWithValidCredentials

* Enter “tomsmith” username
* Enter “SuperSecretPassword!” password

* Click on ‘LOGIN’ button
* Verify the text “Secure Area” */

    String baseurl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test

    public void userSholdLoginSuccessfullyWithValidCredentials() {
        sendKeysToElement(By.xpath("//input[@name='username']"),"tomsmith");
        //WebElement clickUsername = driver.findElement(By.xpath("//input[@name='username']"));
        //clickUsername.sendKeys("tomsmith");
        sendKeysToElement(By.xpath("//input[@name='password']"),"SuperSecretPassword!");
       // WebElement clickPassword = driver.findElement(By.xpath("//input[@name='password']"));
       // clickPassword.sendKeys("SuperSecretPassword!");
        clickOnElement(By.xpath("//button[@type='submit']"));
       // WebElement clickLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        //clickLogin.click();
        String actualMess= getTextFromElement(By.xpath("//h4[@class='subheader']"));
        String expectedMess = "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(expectedMess,actualMess);
       /* WebElement verify = driver.findElement(By.xpath("//h4[@class='subheader']"));
        String actualMess = verify.getText();
        String expectedMess = "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(expectedMess, actualMess); */
    }
    /* 2. verifyTheUsernameErrorMessage
     * Enter “tomsmith1” username
     * Enter “SuperSecretPassword!” password
     * Click on ‘LOGIN’ button
     * Verify the error message “Your username is invalid!” */

    @Test
    public void verifyTheUsernameErrorMessage() {
        sendKeysToElement(By.xpath("//input[@name='username']"),"tomsmith");
      //  WebElement clickUsername = driver.findElement(By.xpath("//input[@name='username']"));
        //clickUsername.sendKeys("tomsmith1");
        sendKeysToElement(By.xpath("//input[@name='password']"),"SuperSecretPasswordd!");
      //  WebElement clickPassword = driver.findElement(By.xpath("//input[@name='password']"));
       // clickPassword.sendKeys("SuperSecretPassword!");
        clickOnElement(By.xpath("//button[@type='submit']"));
      //  WebElement clickLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        //clickLogin.click();
        String actualMess = getTextFromElement(By.xpath("//div[@id='flash']"));
        String expectedMess = "Your password is invalid!\n" + "×";
        Assert.assertEquals(expectedMess, actualMess);

        /*WebElement verify = driver.findElement(By.linkText("Your username is invalid!"));
        String actMess = verify.getText();
        String expMess = "Your username is invalid!";
        Assert.assertEquals(expMess, actMess); */

    }
    //div[@class='flash error'] ---- xpath verify error message username

    /* 3. verifyThePasswordErrorMessage
     * Enter “tomsmith” username
     * Enter “SuperSecretPassword” password
     * Click on ‘LOGIN’ button
     * Verify the error message “Your password is invalid!”    */
    @Test
    public void verifyThePasswordErrorMessage() {
        sendKeysToElement(By.xpath("//input[@name='username']"),"ttomsmith");
       // WebElement clickUsername = driver.findElement(By.xpath("//input[@name='username']"));
       // clickUsername.sendKeys("tomsmith");
        sendKeysToElement(By.xpath("//input[@name='password']"),"SuperSecretPassword!");
      //  WebElement clickPassword = driver.findElement(By.xpath("//input[@name='password']"));
        //clickPassword.sendKeys("SuperSecretPassword");
        clickOnElement(By.xpath("//button[@type='submit']"));
      //  WebElement clickLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        //clickLogin.click();
        String actualMess = getTextFromElement(By.xpath("//div[@id='flash']"));
        String expectedMess = "Your username is invalid!\n" +
                "×";
        Assert.assertEquals(expectedMess, actualMess);
       /* WebElement verify = driver.findElement(By.xpath("//div[@id='flash']"));
        String actMess = verify.getText();
        String expMess = "Your username is invalid";
        Assert.assertEquals(expMess, actMess);  */
        //div[@id='flash']   ---- xpath of verify error message of password
    }
}
