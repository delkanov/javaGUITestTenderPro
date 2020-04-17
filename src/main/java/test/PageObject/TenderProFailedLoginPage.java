package test.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenderProFailedLoginPage {
    @FindBy(xpath="//text()[contains(.,\"Неверный идентификатор сессии\")]/..")
    WebElement error;

    public TenderProMainPageHeader header;
    public TenderProFailedLoginPageContent content;
    private WebDriver driver;
    private final String home="http://test.tender.pro/";
    private final Long timeout=80L;

    public TenderProFailedLoginPage(WebDriver driver){
        this.driver = driver;
        header=new TenderProMainPageHeader(driver);
        content=new TenderProFailedLoginPageContent(driver);
        PageFactory.initElements(driver, this);
    }

    public void waitUntilPageLoads(){
        WebDriverWait wait=new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(error));
    }
}
