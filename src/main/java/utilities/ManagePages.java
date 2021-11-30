package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.Appium.MortgagePage;
import pageObjects.Desktop.CalculatePage;
import pageObjects.Electron.TodoPage;
import pageObjects.webObject.HomePage;
import pageObjects.webObject.LoginPage;
import pageObjects.webObject.ServerAdminPage;

public class ManagePages extends Base {

    // Mobile: Initiate UK Mortgage Calc app page Objects
    public static void initMortgagePage() {
        mortgagePage = new MortgagePage(mobileDriver);
    }

    //Web
    public static void initWebPages() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        serverAdminPage = PageFactory.initElements(driver, ServerAdminPage.class);
    }

    //Web
    public static void initDesktopPages() {
        calculatePage = PageFactory.initElements(windowsDriver, CalculatePage.class);

    }

    //Electron
    public static void initElectronPage() {
        todoPage = PageFactory.initElements(driver, TodoPage.class);
    }

}
