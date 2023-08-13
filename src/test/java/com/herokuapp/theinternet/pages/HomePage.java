package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static HomePage action(){
        return new HomePage(getDriver());
    }

    public HomePage load(){
        load("/");
        return this;
    }

}
