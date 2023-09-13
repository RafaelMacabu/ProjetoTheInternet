package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;


public class FloatingMenuPage extends BasePage {
    @FindBy(xpath = "//a[@href = '#home']")
    private WebElement botaoHome;
    @FindBy (xpath = "//a[@href = '#news']")
    private WebElement botaoNews;
    @FindBy (xpath = "//a[@href = '#contact']")
    private WebElement botaoContact;
    @FindBy (xpath = "//a[@href = '#about']")
    private WebElement botaoAbout;
    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }

    public static FloatingMenuPage action() {
        return new FloatingMenuPage(getDriver());
    }

    public FloatingMenuPage load(){
        load("/floating_menu");
        return this;
    }

    public FloatingMenuPage clickHome(){
        botaoHome.click();
        return this;
    }

    public void assertUrl(String url){
        System.out.println(getDriver().getCurrentUrl());
        Assert.assertEquals(getDriver().getCurrentUrl(),url);

    }
}
