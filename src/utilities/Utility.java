package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement move = driver.findElement(by);
        actions.moveToElement(move).build().perform();
    }


    public void mouseHoverAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement select = driver.findElement(by);
        actions.moveToElement(select).build().perform();
        actions.moveToElement(select).click().build().perform();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();

    }
}