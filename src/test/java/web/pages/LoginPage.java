package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
<<<<<<< HEAD
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // Locators
    private By loginNavButton = By.id("login2"); // nav bar login
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By loginButton = By.xpath("//button[text()='Log in']");
    private By loggedInUsername = By.id("nameofuser");

    // Methods
    public void openLoginModal() {
        driver.findElement(loginNavButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
    }

    public void enterCredentials(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitLogin() {
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUsername));
    }

    public void verifyLoggedIn(String expectedUsername) {
        WebElement userElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUsername));
        String actualText = userElement.getText();
        if (!actualText.contains(expectedUsername)) {
            throw new AssertionError("Expected user: " + expectedUsername + ", but got: " + actualText);
        }
=======

public class LoginPage {

    private final WebDriver driver;

    private final By usernameField = By.id("loginusername");
    private final By passwordField = By.id("loginpassword");
    private final By loginButton = By.xpath("//button[text()='Log in']");
    private final By loginModalButton = By.id("login2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginModal() {
        driver.findElement(loginModalButton).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginSuccess() {
        return driver.getPageSource().contains("Welcome");
>>>>>>> 27c271d (push Feedback)
    }
}
