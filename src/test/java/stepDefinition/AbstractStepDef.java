package stepDefinition;

import Page.HomePage;
import Page.LoginPage;
import UTIL.PropretyLoader;
import org.openqa.selenium.WebDriver;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AbstractStepDef {
 protected static WebDriver driver;
  public LoginPage loginPage = new LoginPage(driver);
  public HomePage homePage = new HomePage(driver);
//    public AdminPage adminPage = new AdminPage(driver);
//    public AutoItPage autoItPage = new AutoItPage(driver);
    protected static String chromeDriver = PropretyLoader.loadProperty("chromeDriver");
    protected static String loginPageUrl = PropretyLoader.loadProperty("loginPageUrl");
    public static String excelFilePath = PropretyLoader.loadProperty("excelFilePath");
    public static String excelSheet = PropretyLoader.loadProperty("excelSheet");
    public static String autoItUploadFileSite = PropretyLoader.loadProperty("autoItUploadFileSite");
    public static String restAssuredBaseURL = PropretyLoader.loadProperty("restAssuredBaseURL");
  //-  public Logger log = LogManager.getLogger();
}
