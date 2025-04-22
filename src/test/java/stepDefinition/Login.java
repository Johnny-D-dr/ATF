package stepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static Actions.Action.*;
import static UTIL.DataKeys.PASSWORD;
import static UTIL.DataKeys.USERNAME;
import static UTIL.HighlightElement.highlightElement;
import static UTIL.ScenarioContext.getData;
import static UTIL.ScenarioContext.saveData;
import static UTIL.WaitUntil.waitUntil;

public class Login extends AbstractStepDef {

    @Given("user insert username")
    public void userInsertUsername() throws InterruptedException {
        navigate(loginPageUrl, driver);
        waitUntil(3);
        sendKey(loginPage.getUsernameField(), "Admin");
        saveData(USERNAME, "Admin");
    }

    @And("user insert password")
    public void userInsertPassword() throws InterruptedException {
        waitUntil(3);
        sendKey(loginPage.getPasswordFiled(), "admin123");
        isDisplayed(loginPage.getLoginLogo());
        saveData(PASSWORD, "admin123");


    }

    @When("user clicks on Login button")
    public void userClicksOnLoginButton() {
        click(loginPage.getSubmitButton(), 3);
    }

    @Then("user is redirect to homepage")
    public void userIsRedirectToHomepage() {
        waitUntil(3);
        highlightElement(homePage.getDashboardSign());
        Assert.assertEquals("Dashboard", homePage.getDashboardSign().getText());
    }

    @And("user clicks on LogOut button")
    public void userClickOnLogOutButton() {
        click(homePage.getUserMeniu(), 3);
        highlightElement(homePage.getLogOutButton());
        waitUntil(3);
        click(homePage.getLogOutButton(), 3);
    }

    @And("insert username")
    public void insertUsername(){
        waitUntil(3);
        sendKey(loginPage.getUsernameField(), getData(USERNAME).toString());
    }
    @And("insert password")
    public void insertPassword() {
        waitUntil(3);
        sendKey(loginPage.getPasswordFiled(), getData(PASSWORD).toString());
    }
}
