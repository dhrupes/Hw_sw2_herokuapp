package testsuits;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

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
        WebElement clickUsername = driver.findElement(By.xpath("//input[@name='username']"));
        clickUsername.sendKeys("tomsmith");
        WebElement clickPassword = driver.findElement(By.xpath("//input[@name='password']"));
        clickPassword.sendKeys("SuperSecretPassword!");
        WebElement clickLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        clickLogin.click();
        WebElement verify = driver.findElement(By.xpath("//h4[@class='subheader']"));
        String actualMess = verify.getText();
        String expectedMess = "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(expectedMess, actualMess);
    }
    /* 2. verifyTheUsernameErrorMessage
     * Enter “tomsmith1” username
     * Enter “SuperSecretPassword!” password
     * Click on ‘LOGIN’ button
     * Verify the error message “Your username is invalid!” */

    @Test
    public void verifyTheUsernameErrorMessage() {
        WebElement clickUsername = driver.findElement(By.xpath("//input[@name='username']"));
        clickUsername.sendKeys("tomsmith1");
        WebElement clickPassword = driver.findElement(By.xpath("//input[@name='password']"));
        clickPassword.sendKeys("SuperSecretPassword!");
        WebElement clickLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        clickLogin.click();
        WebElement verify = driver.findElement(By.linkText("Your username is invalid!"));
        String actMess = verify.getText();
        String expMess = "Your username is invalid!";
        Assert.assertEquals(expMess, actMess);

    }
    //div[@class='flash error'] ---- xpath verify error message username

    /* 3. verifyThePasswordErrorMessage
     * Enter “tomsmith” username
     * Enter “SuperSecretPassword” password
     * Click on ‘LOGIN’ button
     * Verify the error message “Your password is invalid!”    */
    @Test
    public void verifyThePasswordErrorMessage() {
        WebElement clickUsername = driver.findElement(By.xpath("//input[@name='username']"));
        clickUsername.sendKeys("tomsmith");
        WebElement clickPassword = driver.findElement(By.xpath("//input[@name='password']"));
        clickPassword.sendKeys("SuperSecretPassword");
        WebElement clickLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        clickLogin.click();
        WebElement verify = driver.findElement(By.xpath("//div[@id='flash']"));
        String actMess = verify.getText();
        String expMess = "Your username is invalid";
        Assert.assertEquals(expMess, actMess);
        //div[@id='flash']   ---- xpath of verify error message of password
    }
}
