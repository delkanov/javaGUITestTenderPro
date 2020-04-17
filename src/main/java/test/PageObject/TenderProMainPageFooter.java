package test.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TenderProMainPageFooter extends PageBlock {
    public TenderProMainPageFooter(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
