package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper {

    WebDriver driver;
    public WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;

    public ElementHelper(WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        actions = new Actions(webDriver);
        js = (JavascriptExecutor) driver;
    }

    public void scroll(By by) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'instant', block: 'center', inline: 'center'});", element);
    }

    public void click(By by) {
        scroll(by);
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void clickIfVisible(By by, int timeoutInSeconds) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement element = shortWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            element.click();
        } catch (Exception e) {
        }
    }

    public void sendKeys(By by, String text) {
        scroll(by);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.clear();
        element.sendKeys(text);
    }

    public boolean isElementVisible(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getText(By by) {
        scroll(by);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
    }

    public void clearText(By by) {
        scroll(by);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.clear();
    }

    public void selectAll(By by) {
        scroll(by);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.click();
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
    }


    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void hoverOverElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void hoverAndClick(By hoverElement, By clickElement) {
        WebElement hover = wait.until(ExpectedConditions.visibilityOfElementLocated(hoverElement));
        actions.moveToElement(hover).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickElement)).click();
    }
    public void waitForTextToAppear(By element, String expectedText) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(element, expectedText));
    }
}
