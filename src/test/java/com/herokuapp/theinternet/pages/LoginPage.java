package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@id = 'username']")
    private WebElement username;
    @FindBy(xpath = "//input[@id = 'password']")
    private WebElement password;
    @FindBy(xpath = "//button[@class = 'radius']")
    private WebElement loginButton;
    @FindBy(xpath = "//a[@href = '/logout']")
    private WebElement logoutButton;
    @FindBy(xpath = "//div[@id = 'flash']")
    private WebElement mensagemLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static LoginPage action(){
        return new LoginPage(getDriver());
    }

    public LoginPage load(){
        load("/login");
        return this;
    }

    public LoginPage inputUsername(String username){
        this.username.sendKeys(username);
        return this;
    }

    public LoginPage inputPassword(String password){
        this.password.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton(){
        loginButton.click();
        return this;
    }

    public void assertLoginSuccessful(){
        System.out.println(mensagemLogin.getText());
        Assert.assertTrue(mensagemLogin.getText().contains("You logged into a secure area!\n"));
        logoutButton.click();
    }

    public void assertLoginWrongUsername(){
        System.out.println(mensagemLogin.getText());
        Assert.assertTrue(mensagemLogin.getText().contains("Your username is invalid!"));
    }

    public void assertLoginWrongpassword(){
        System.out.println(mensagemLogin.getText());
        Assert.assertTrue(mensagemLogin.getText().contains("Your password is invalid!"));
    }




}
