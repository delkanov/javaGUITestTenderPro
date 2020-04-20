package PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenderProMainPageHeader extends PageBlock {
    @FindBy(id="HeaderHolder")
    WebElement headerContainer;
    @FindBy(linkText="Главная")
    WebElement gotomain;
    @FindBy(linkText="Контакты")
    WebElement gotocontacts;
    @FindBy(linkText="Обновленный интерфейс")
    WebElement gotonew;
    @FindBy(id="form_tenders")
    WebElement tender;
    @FindBy(id="form_nomenclature")
    WebElement catalog;
    @FindBy(id="form_company")
    WebElement companies;
    @FindBy(id="form_forum")
    WebElement forum;
    @FindBy(id="form_help")
    WebElement sprawka;
    @FindBy(linkText="Тарифы")
    WebElement tarif;
    @FindBy(name="usetenderlogin")
    WebElement username;
    @FindBy(name="usetenderpassword")
    WebElement password;
    @FindBy(name="submit")
    WebElement log_in;
    @FindBy(name="filter")
    WebElement filter;
    @FindBy(id="form_clear")
    WebElement form_clear;
    @FindBy(id="form_submit")
    WebElement form_submit;
    @FindBy(linkText="Регистрация")
    WebElement register;
    @FindBy(linkText="Вспомнить пароль")
    WebElement reset_password;

    public TenderProMainPageHeader(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getGoToMainText(){
        return gotomain.getText();
    }
    public String getGoToContactsText(){
        return gotocontacts.getText();
    }
    public String getGoToNewText(){
        return gotonew.getText();
    }
    public String getGoToMainHref(){
        return gotomain.getAttribute("href");
    }
    public String getGoToContactsHref(){
        return gotocontacts.getAttribute("href");
    }
    public String getGoToNewHref(){
        return gotonew.getAttribute("href");
    }

    public String getTenderText(){
        return tender.getText();
    }
    public String getCatalogText(){
        return catalog.getText();
    }
    public String getCompaniesText(){
        return companies.getText();
    }
    public String getForumText(){
        return forum.getText();
    }
    public String getSprawkaText(){
        return sprawka.getText();
    }
    public String getTarifText(){
        return tarif.getText();
    }
    public String getTenderHref(){
        return tender.getAttribute("href");
    }
    public String getCatalogHref(){
        return catalog.getAttribute("href");
    }
    public String getCompaniesHref(){
        return companies.getAttribute("href");
    }
    public String getForumHref(){
        return forum.getAttribute("href");
    }
    public String getSprawkaHref(){
        return sprawka.getAttribute("href");
    }
    public String getTarifHref(){
        return tarif.getAttribute("href");
    }

    public void setUserName(String text){
        username.sendKeys(text);
    }
    public void setPassword(String text){
        password.sendKeys(text);
    }
    public void login(){
        log_in.click();
    }

    public void tenderSearch(String text){
        filter.sendKeys(text);
        form_submit.click();
    }
    public void tenderSearchClear(){
        filter.clear();
    }
}
