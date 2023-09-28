package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class ContextMenuPage extends BasePage {
    @FindBy(xpath = "//div[@id = 'hot-spot']")
    private WebElement hotSpot;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public static ContextMenuPage action() {
        return new ContextMenuPage(getDriver());
    }

    public ContextMenuPage load(){
        load("/context_menu");
        return this;
    }

    public ContextMenuPage contextClickHotspot(){
        Actions actions = new Actions(getDriver());
        actions.contextClick(hotSpot)
                .perform();
        return this;

    }

    public void assertAlertMessage(){
        Alert alert = getDriver().switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(),"You selected a context menu");
    }
}
