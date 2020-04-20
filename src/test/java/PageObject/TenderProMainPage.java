package PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenderProMainPage {
    @FindBy(name="usetenderlogin")
    WebElement login;

    public TenderProMainPageHeader header;
    public TenderProMainPageFooter footer;
    public TenderProMainPageContent content;
    private WebDriver driver;
    private final String home="http://test.tender.pro/";
    private final Long timeout=80L;

    public TenderProMainPage(WebDriver driver){
        this.driver = driver;
        header=new TenderProMainPageHeader(driver);
        footer=new TenderProMainPageFooter(driver);
        content=new TenderProMainPageContent(driver);
        PageFactory.initElements(driver, this);
    }

    public void goHome(){
        driver.get(home);
        waitUntilPageLoads();
    }

    public void waitUntilPageLoads(){
        WebDriverWait wait=new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(login));
    }
}
