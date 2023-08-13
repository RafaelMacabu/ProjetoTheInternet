package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class KeyPressesPage extends BasePage {

    @FindBy(xpath = "//input[@id = 'target']")
    private WebElement input;
    @FindBy(xpath = "//p[@id = 'result']")
    private WebElement result;

    public String getResult(){
        return result.getText();
    }

    public KeyPressesPage(WebDriver driver) {
        super(driver);
    }

    public static KeyPressesPage action(){
        return new KeyPressesPage(getDriver());
    }

    public KeyPressesPage load(){
        load("/key_presses");
        return this;
    }

    public void pressKey(String key){
        input.sendKeys(key);
    }

    public Boolean assertIfResultIsEqual(String expected){
        System.out.println(getResult());
        System.out.println(expected);
        return getResult().equals("You entered: " + expected.toUpperCase());
    }




}
