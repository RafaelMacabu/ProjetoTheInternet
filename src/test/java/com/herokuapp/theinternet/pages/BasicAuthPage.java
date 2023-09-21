package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class BasicAuthPage extends BasePage {
    @FindBy(xpath = "//div[@id = 'content']")
    private WebElement SuccessMsg;

    public BasicAuthPage(WebDriver driver) {
        super(driver);
    }

    public static BasicAuthPage action(){
        return new BasicAuthPage(getDriver());
    }

    public BasicAuthPage load(){
        load("/basic_auth");
        return this;
    }

    public BasicAuthPage loadWithAuth(){
        getDriver().get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        return this;
    }

    public void assertAuth(){
        Assert.assertTrue(SuccessMsg.getText().contains("Congratulations!"));
        System.out.println(SuccessMsg.getText());
    }
}
