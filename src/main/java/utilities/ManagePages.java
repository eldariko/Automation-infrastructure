package utilities;

<<<<<<< Updated upstream
public class ManagePages extends Base {
=======
import org.openqa.selenium.support.PageFactory;
import pageObjects.webObject.LoginPage;

public class ManagePages extends Base {

    // Mobile: Initiate UK Mortgage Calc app page Objects
    public static void initUnitConvertor() {
        unitConvertorPage = new pageObjects.Appium.UnitConvertorPage(mobileDriver);
    }
    //Web
    public static void initWebPages(){
        loginPage=PageFactory.initElements(driver,LoginPage.class);
    }
>>>>>>> Stashed changes
}
