package test.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TenderProMainPageContent extends PageBlock {
    public TenderProMainPageContent(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
