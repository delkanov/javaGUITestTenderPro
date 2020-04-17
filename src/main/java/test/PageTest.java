package test;

import org.junit.jupiter.api.AfterAll;
import test.PageObject.TenderProFailedLoginPage;
import test.PageObject.TenderProMainPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

public class PageTest {

    private static WebDriver driver;
    private static TenderProMainPage mainPage;
    private static TenderProFailedLoginPage failedLoginPage;

    @BeforeAll
    static void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-setuid-sandbox");
        options.addArguments("disable-gpu");
        options.addArguments("dbus-stub");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage=new TenderProMainPage(driver);
        failedLoginPage=new TenderProFailedLoginPage(driver);
    }

    @Test
    void testMainPageHeaderMenuTest(){
        mainPage.goHome();
        assertThat("Пункт меню \"Тендеры\" не найден на главной странице",mainPage.header.getTenderText().equals("Тендеры"));
        assertThat("Пункт меню \"Каталог\" не найден на главной странице",mainPage.header.getCatalogText().equals("Каталог"));
        assertThat("Пункт меню \"Компании\" не найден на главной странице",mainPage.header.getCompaniesText().equals("Компании"));
        assertThat("Пункт меню \"Форум\" не найден на главной странице",mainPage.header.getForumText().equals("Форум"));
        assertThat("Пункт меню \"Справка\" не найден на главной странице",mainPage.header.getSprawkaText().equals("Справка"));
        assertThat("Пункт меню \"Тарифы\" не найден на главной странице",mainPage.header.getTarifText().equals("Тарифы"));

        assertThat("Неправильная ссылка пункта меню \"Тендеры\"",mainPage.header.getTenderHref().equals("http://test.tender.pro/view_tenders_list.shtml?sid=&tenderstate=1"));
        assertThat("Неправильная ссылка пункта меню \"Каталог\"",mainPage.header.getCatalogHref().equals("http://test.tender.pro/nomenclatura_list.shtml?sid="));
        assertThat("Неправильная ссылка пункта меню \"Компании\"",mainPage.header.getCompaniesHref().equals("http://test.tender.pro/company_list.shtml?sid="));
        assertThat("Неправильная ссылка пункта меню \"Форум\"",mainPage.header.getForumHref().equals("http://test.tender.pro/forum.shtml?sid="));
        assertThat("Неправильная ссылка пункта меню \"Справка\"",mainPage.header.getSprawkaHref().equals("http://help.tender.pro/"));
        assertThat("Неправильная ссылка пункта меню \"Тарифы\"",mainPage.header.getTarifHref().equals("http://system.help.tender.pro/tarif.html"));
    }

    @Test
    void testMainPageHeaderLinksTest(){
        mainPage.goHome();
        assertThat("Ссылка \"Главная\" не найден на главной странице",mainPage.header.getGoToMainText().equals("Главная"));
        assertThat("Ссылка \"Контакты\" не найден на главной странице",mainPage.header.getGoToContactsText().equals("Контакты"));
        assertThat("Ссылка \"Обновленный интерфейс\" не найден на главной странице",mainPage.header.getGoToNewText().equals("Обновленный интерфейс"));

        assertThat("Ссылка \"Главная\" ведет на неправильную страницу",mainPage.header.getGoToMainHref().equals("http://test.tender.pro/"));
        assertThat("Ссылка \"Контакты\" ведет на неправильную страницу",mainPage.header.getGoToContactsHref().equals("http://help.tender.pro/contacts.html"));
        assertThat("Ссылка \"Обновленный интерфейс\" ведет на неправильную страницу",mainPage.header.getGoToNewHref().equals("http://test.iac.tender.pro/"));
    }

    @Test
    void testMainPageHeaderLoginTestNegative() {
        mainPage.goHome();
        mainPage.header.setUserName("invalid_user");
        mainPage.header.setPassword("invalid_password");
        mainPage.header.login();
        failedLoginPage.waitUntilPageLoads();
    }

    @AfterAll
    static void teardown(){
        driver.close();
    }
}
