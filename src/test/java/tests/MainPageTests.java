package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MainPageTests extends TestBase{
    @Test
    public void start() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Hello!");
    }

    @Test(groups = "UI")
    public void sloganIsDisplayed(){
        WebElement slogan = driver.findElement(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
                        "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view." +
                        "ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.V" +
                        "iew/android.view.View/android.view.View/android.view.View/android.view." +
                        "View/android.view.View/android.view.View/android.view.View/android.view." +
                        "View/android.view.View[1]/android.view.View[2]/android.view.View[2]"));

        System.out.println(slogan.getText());
        Assert.assertEquals(slogan.getText(), "CheapTrip.Pay less, travel more");

 
    }
}
