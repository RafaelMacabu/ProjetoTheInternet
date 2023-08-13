package com.herokuapp.theinternet.base;

import com.herokuapp.theinternet.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public static void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);

    }
}
