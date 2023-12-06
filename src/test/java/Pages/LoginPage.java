package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    By username = By.cssSelector("#username");

    By password = By.cssSelector("#password");

    By loginButton = By.cssSelector(".radius");

    By logoutButton = By.cssSelector(".secondary");

    By invalidMsg = By.cssSelector("#flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    // page factory
    @FindBy(css = "#username")
    WebElement usernamePF;

    @FindBy(css = "#password")
    WebElement passwordPF;

    public WebElement enterusername() {
        return driver.findElement(username);
    }

    public WebElement enterpassword() {
        return driver.findElement(password);
    }

    public WebElement ClickonloginButton() {
        return driver.findElement(loginButton);
    }

    public boolean logoutButton() {
        return driver.findElement(logoutButton).isDisplayed();
    }

    public boolean invalidmsg() {
        return driver.findElement(invalidMsg).isDisplayed();
    }

    public void loginSteps(String username, String password) {

        // page factory
        //usernamePF.sendKeys(username);
        // passwordPF.sendKeys(password);

        enterusername().sendKeys(username);
        enterpassword().sendKeys(password);

    }
}
