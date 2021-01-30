package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {
    AppiumDriver driver;

    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeSuite
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        final String baseDir = System.getProperty("user.dir") + "/app";
        System.out.println("current dir = " + baseDir);

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "myAndroid");
        capabilities.setCapability("platformVersion", "10");
        //   capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "io.ionic.starter");
        capabilities.setCapability("appActivity", "io.ionic.starter.MainActivity");
        capabilities.setCapability("app", baseDir + "/app-debug.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    @BeforeMethod(alwaysRun = true)
    public void startTest(Method m, Object[] p) throws MalformedURLException {
 /*       DesiredCapabilities capabilities = new DesiredCapabilities();
        final String baseDir = System.getProperty("user.dir") + "/app";
        System.out.println("current dir = " + baseDir);

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "myAndroid");
        capabilities.setCapability("platformVersion", "10");
     //   capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "io.ionic.starter");
        capabilities.setCapability("appActivity", "io.ionic.starter.MainActivity");
        capabilities.setCapability("app", baseDir + "/app-debug.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/

        logger.info("Start test: " + m.getName());
        if(p.length != 0) {
            logger.info(" --> With data: " + Arrays.asList(p));
        }

    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("Test result: PASSED");
        }else{
            logger.error("Test result: FAILED");
            logger.error("-> The cause is: ",result.getThrowable());
        }

        logger.info("Stop test: " + result.getMethod().getMethodName());
        logger.info("======================================================");

    }

    @AfterSuite
    public void quitApp(){
        driver.closeApp();
        driver.quit();
    }


}
