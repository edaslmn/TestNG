package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;
import utilities.Driver;

public class ZeroWebappPage {

    public HTMLInputElement payBillsLinki;

    public ZeroWebappPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "signin_button")
    public WebElement ilkSayfaSignInLinki;

    @FindBy (id = "user_login")
    public WebElement loginKutusu;

    @FindBy (id = "user_password")
    public WebElement passwordKutusu;

    @FindBy(name = "submit")
    public WebElement loginSayfasiSignInButonu;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement settingsLinki;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBankingMenu;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillsLink;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyLinki;

    @FindBy(id = "pc_currency")
    public WebElement dropDownCurrencyMenu;

}
