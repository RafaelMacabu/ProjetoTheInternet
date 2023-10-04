package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class JSAlertsPage extends BasePage {
    @FindBy(xpath = "//button[@onclick = 'jsAlert()']")
    private WebElement jsAlert;
    @FindBy(xpath = "//button[@onclick = 'jsConfirm()']")
    private WebElement jsConfirm;
    @FindBy(xpath = "//button[@onclick = 'jsPrompt()']")
    private WebElement jsPrompt;
    @FindBy(xpath = "//p[@id = 'result']")
    private WebElement result;
    public JSAlertsPage(WebDriver driver) {
        super(driver);
    }
    public static JSAlertsPage action(){
        return new JSAlertsPage(getDriver());
    }

    public JSAlertsPage load(){
        load("/javascript_alerts");
        return this;
    }

    public JSAlertsPage clickJSAlert(){
        jsAlert.click();
        return this;
    }

    public JSAlertsPage clickJSInputPrompt(){
        jsPrompt.click();
        return this;
    }

    public JSAlertsPage clickJSConfirm(){
        jsConfirm.click();
        return this;
    }

    public JSAlertsPage acceptAlert(){
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        return this;
    }

    public JSAlertsPage inputAlert(String text){
        getDriver().switchTo().alert().sendKeys(text);
        return this;
    }

    public void assertJSInputAlert(String expectedText){
        System.out.println(result.getText());
        Assert.assertEquals(result.getText(),"You entered: " + expectedText);
    }

    public void assertJSAlert(){
        System.out.println(result.getText());
        Assert.assertEquals(result.getText(),"You successfully clicked an alert");
    }

    public void assertJSClick(){
        System.out.println(result.getText());
        Assert.assertEquals(result.getText(),"You clicked: Ok");
    }
}
