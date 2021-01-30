package tests.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HelperBase {
    public AppiumDriver driver;

    public HelperBase(AppiumDriver driver){
        this.driver = driver;
    }

    public WebElement findElementOnPage(By locator){
        return driver.findElement(locator);
    }

    public boolean ifElementExists(By locator){
        return driver.findElements(locator).size() > 0;
    }

    public void clickElement(By locator){
        findElementOnPage(locator).click();
    }

    public void fillField(By locator, String cityName) {
        findElementOnPage(locator).clear();
        findElementOnPage(locator).sendKeys(cityName);
    }



}
