package tests.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends HelperBase{

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickHamburgerMenu() {
        clickElement(By.xpath("//android.widget.Button[@text ='menu']"));
    }

    public void clickContactsMenuItem() {
        clickElement(By.xpath("//android.view.View[@text ='Contacts']"));
    }

    public void clickHomeMenuButton() {
        clickElement(By.xpath("//android.view.View[@text ='home']"));
    }

    public void clickFromField() {
        clickElement(By.xpath("//*[@resource-id='ion-input-0-lbl']"));
    }

    public void fillFromField(String cityFrom) {
        fillField(By.xpath("//android.view.View[3]//android.view.View[2]//android.view.View//android.view.View[2]//" +
                "android.view.View[1]//android.view.View[1]//android.view.View[1]//android.view.View[1]//" +
                "android.view.View//android.view.View[2]//android.widget.EditText"), cityFrom);
    }

    public void clickFromCitiesList() {
        clickElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/" +
                "android.view.View[2]/" +
                "android.view.View[1]/android.view.View[2]/android.view.View/android.view.View[1]/" +
                "android.view.View/android.view.View/android.view.View/android.widget.Button"));
    }

    public void clickToCitiesList() {
        clickElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/" +
                "android.view.View[2]/android.view.View[2]/" +
                "android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.Button"));
    }

    public void fillToField(String cityTo) {
        fillField(By.xpath("//android.view.View[3]//android.view.View[2]//android.view.View//android.view.View[2]//" +
                "android.view.View[2]//android.view.View[1]//android.view.View[1]//android.view.View[1]//" +
                "android.view.View//android.view.View[2]//android.widget.EditText"), cityTo);
    }

    public void clickToField() {
        clickElement(By.xpath("//*[@resource-id='ion-input-1-lbl']"));
    }

    public void clickGoButton() {
        clickElement(By.xpath("//android.view.View[@content-desc=\"LET'S GO\"]/android.view.View"));
    }

    public void clickClearButton() {
        clickElement(By.xpath("//android.widget.Button[@text ='CLEAR']"));
    }

    public void clickBackButton() {
        clickElement(By.xpath("//android.widget.Button[@text ='back']"));
    }

    public boolean ifRoutesPresented() {
        return ifElementExists(By.xpath("//android.widget.Button[contains(@resource-id,'mat-expansion-panel-header-')]"));
    }

    public WebElement getContactsPageTitle() {
        return findElementOnPage(By.xpath("//android.view.View[@text ='Contacts']"));
    }

    public String getCurrentCurrency() {
        return findElementOnPage(By.xpath("//android.view.View[1]//android.view.View//android.view.View//android.view.View[1]" +
                "//android.view.View//android.widget.ListView//android.view.View[1]")).getText();
    }

    public String getCurrentLanguage() {
        return findElementOnPage(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/" +
                "android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[1]")).getText();
    }

    public String getFromFieldTitle() {
        String result = findElementOnPage(By.xpath("//android.view.View[3]//android.view.View[2]//android.view.View//android.view.View[2]" +
                "//android.view.View[1]//android.view.View//android.view.View[1]//android.view.View[1]//android.view.View" +
                "//android.view.View[1]")).getText();
        return result;
    }

    public void ClickLanguageRadioButton(String lang) {
        clickElement(By.xpath("//android.view.View[@text = '" + lang + "']"));
    }

    public void clickLanguageBox() {
        clickElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/" +
                "android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[1]"));
    }

    public boolean isAppLanguageEnglish() {
        String lang = findElementOnPage(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/" +
                "android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[1]")).getText();
        if(lang.equals("En")){
            return true;
        }
        return false;
    }

    public void setAppLanguage(){
        //open drop-down box
        clickElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/" +
                "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
                "android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/" +
                "android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[1]"));

        //select the language
        clickElement(By.xpath("//android.view.View[@text = 'En']"));
    }

}
