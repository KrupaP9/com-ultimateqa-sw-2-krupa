package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UtilityUltimateqa extends BaseTest {
    public void clickOnElement(By by){
        //find the element to click
        WebElement link = driver.findElement(by);
        //click on element
        link.click();
    }
    public void sendTextToElement(By by, String text){
        //find the element to enter text into
        WebElement field = driver.findElement(by);
        //send text
        field.sendKeys(text);
    }
    public String getTextFromElement(By by){
        //find the element to get text from
        WebElement element = driver.findElement(by);
        //return the text from the element as String
        return element.getText();
    }
}
