package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.pages.MainPage;

public class MainPageTests extends TestBase{

    MainPage mainPage;

    @BeforeTest
    public void insurePreconditions(){

        mainPage = new MainPage(driver);

        if(!mainPage.isAppLanguageEnglish()){
            mainPage.setAppLanguage();
        }
    }

    @Test(enabled = false)
    public void start() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Hello!");
    }

    @Test(groups = "UI")
    public void sloganIsDisplayed(){
        WebElement slogan = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
                "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit." +
                "WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view." +
                "View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]"));

        System.out.println(slogan.getText());
        Assert.assertEquals(slogan.getText(), "CheapTrip.Pay less, travel more");
    }

    @Test(groups = "Functional")
    public void YuliaB_ContactsPageIsOpenedTest()  {
        //click Hamburger Menu
        mainPage.clickHamburgerMenu();

        //click Contacts item in menu
        mainPage.clickContactsMenuItem();

        //verify the contacts page is opened
        WebElement pageTitle = mainPage.getContactsPageTitle();
        Assert.assertEquals(pageTitle.getText(), "Contacts", "Contacts page is not opened");

        //click Hamburger Menu
        mainPage.clickHamburgerMenu();
        mainPage.clickHomeMenuButton();
    }

    @Test(dataProvider = "usingValidCities",dataProviderClass = DataProviders.class, groups = "Functional")
    public void YuliaB_SearchRoutePositiveTest(String cityFrom, String cityTo) {

        //fill FROM field
        mainPage.clickFromField();
        mainPage.fillFromField(cityFrom);
        mainPage.clickFromCitiesList();

        //fill TO field
        mainPage.clickToField();
        mainPage.fillToField(cityTo);
        mainPage.clickToCitiesList();

        //click Let's Go button
        mainPage.clickGoButton();

        //verify the route page is opened
        Assert.assertTrue(mainPage.ifRoutesPresented(), "Routes are not presented.");

        //click back button
        mainPage.clickBackButton();

        //click clear button
        mainPage.clickClearButton();

    }

    @Test(groups = "UI")
    public void YuliaB_GetCurrentCurrencyTest(){
        //get currency
        String currency = mainPage.getCurrentCurrency();

        //verify the currency is EUR
        Assert.assertEquals(currency, "EUR","Current currency is not EUR");
    }

    @Test(groups = "UI")
    public void YuliaB_GetCurrentLanguageTest(){
        //get language
        String language = mainPage.getCurrentLanguage();

        //verify the language is En
        Assert.assertEquals(language, "En","Current language is not EN");
    }

    @Test(groups = "UI")
    public void YuliaB_SetLanguageTest()  {
        String lang = "Ru";
        //open drop-down box
        mainPage.clickLanguageBox();

        //select the language
        mainPage.ClickLanguageRadioButton(lang);

        //verify the page is on correct language
        mainPage.clickFromField();
        String result = mainPage.getFromFieldTitle();

        Assert.assertEquals(result, "Откуда:","Current language is not " + lang + ".");

    }


    //earth icon id="tab-button-multi" text = MultiCity earth
}
