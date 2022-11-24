package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.UtilityUltimateqa;

public class LoginTest extends UtilityUltimateqa {
    @Before
    public void openBrowserLink(){
        //open the browser and launch the URL
        openBrowser("https://courses.ultimateqa.com/");
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the ‘Sign In’ link
        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']/a"));
        //define expected text
        String expectedText = "Welcome Back!";
        //get actual text
        String actualText = getTextFromElement(By.xpath("//h1[@class='page__heading']"));
        //Verify the text ‘Welcome Back!’
        Assert.assertEquals("Not on Sign In page",expectedText,actualText);
    }

    @Test
    public void verifyTheErrorMessage(){
        //click on the ‘Sign In’ link
        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']/a"));
        //Enter invalid username
        sendTextToElement(By.xpath("//input[@name='user[email]']"),"invalidemail@gmail.com");
        //Enter invalid password
        sendTextToElement(By.xpath("//input[@name='user[password]']"), "invalidpassword1");
        //Click on Login button
        clickOnElement(By.xpath("//input[@value='Sign in']"));
        //define expected text
        String expectedMessage = "Invalid email or password.";
        //get actual text
        String actualMessage = getTextFromElement(By.xpath("//li[@class='form-error__list-item']"));
        //Verify the error message ‘Invalid email or password.’
        Assert.assertEquals("Invalid Message Not Displayed",expectedMessage,actualMessage);
    }

    @After
    public void tearDown(){
        //close the browser
        closeBrowser();
    }

}
