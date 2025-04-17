package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static Actions.Action.*;
import static UTIL.HighlightElement.highlightElement;
import static UTIL.WaitUntil.waitUntil;

public class Login extends AbstractStepDef {

    @Given("user insert username")
    public void userInsertUsername() throws InterruptedException {
    navigate(loginPageUrl,driver);
        waitUntil(1);
    sendKey(loginPage.getUsernameField(), "Admin");
    }

    @And("user insert password")
    public void userInsertPassword() throws InterruptedException {
        waitUntil(1);
        sendKey(loginPage.getPasswordFiled(), "admin123");
        isDisplayed(loginPage.getLoginLogo());


    }

    @When("user clicks on Login button")
    public void userClicksOnLoginButton() {
        click(loginPage.getSubmitButton(), 3);
    }

    @Then("user is redirect to homepage")
    public void userIsRedirectToHomepage() throws InterruptedException {
        waitUntil(1);
        highlightElement(homePage.getDashboardSign());
        Assert.assertEquals( "Dashboard", homePage.getDashboardSign().getText());
    }

    @And("user clicks on LogOut button")
    public void userClickOnLogOutButton() {
        highlightElement(homePage.getLogOutButton());
        waitUntil(3);
        click(homePage.getLogOutButton(), 1);
    }
}
