package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginstepDefinition {

    WebDriver driver;
    LoginPage loginPageObj;


    @Given("user open the browser")
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        loginPageObj = new LoginPage(driver);
    }

    @And("user navigates to login page")
    public void user_navigate(){
        driver.get("https://the-internet.herokuapp.com/login");

    }
    //valid and invalid scenario
    @When("^user enter \"(.*)\" and \"(.*)\"$")
    public void validData(String username ,String password){
        loginPageObj.loginSteps(username,password);

    }

    @And("click on login button")
    public void loginButton(){
        loginPageObj.ClickonloginButton().click();

    }

    @Then("user can login successfully")
    public void loginSuccessfully(){

        Assert.assertTrue(loginPageObj.logoutButton());
    }

    @And("user go to home page")
    public void go_to_homepage(){

        Assert.assertEquals("https://the-internet.herokuapp.com/secure", driver.getCurrentUrl());

    }

    //invalid scenario
    @Then("user can not login successfully")
    public void wronglogin(){

        Assert.assertTrue(loginPageObj.invalidmsg());
    }

    @After
    public void closebrowser(){
        driver.quit();
    }



}
