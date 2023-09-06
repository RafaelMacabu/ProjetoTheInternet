package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class DisappearingPage extends BasePage {
    By disappearingElement = By.xpath("//a[@href = '/gallery/']");
    public DisappearingPage(WebDriver driver) {
        super(driver);
    }

    public static DisappearingPage action(){
        return new DisappearingPage(getDriver());
    }

    public DisappearingPage load(){
        load("/disappearing_elements");
        return this;
    }

    public void assertIfElementisPresent(){
        if (getDriver().findElements(disappearingElement).size() > 0){
            System.out.println("Element is present in current screen");
        }else {
            System.out.println("Element is not present in current screen");
        }
        Assert.assertEquals(getDriver().findElements(disappearingElement).size(),1);
    }
}
