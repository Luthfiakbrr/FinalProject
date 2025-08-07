package web.stepdefinitions;

import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import utils.WebDriverManager;
import web.pages.LoginPage;

import static org.testng.Assert.assertTrue;


public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver = WebDriverManager.getDriver();
        driver.get("https://www.demoblaze.com");
        loginPage = new LoginPage(driver);
        loginPage.openLoginModal();
    }

    @Step
    @When("I enter valid username {string} and password {string}")
    public void iEnterValidUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() throws InterruptedException {
        Thread.sleep(3000); // Wait for modal to close and page to update
        assertTrue(loginPage.isLoginSuccess());
    }
}
