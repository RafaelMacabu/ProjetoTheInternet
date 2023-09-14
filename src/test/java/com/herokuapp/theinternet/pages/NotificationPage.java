package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class NotificationPage extends BasePage {
    @FindBy(xpath = "//div[@id = 'flash']")
    private WebElement notification;
    @FindBy(xpath = "//a[@href = '/notification_message']")
    private WebElement clickHereButton;
    public NotificationPage(WebDriver driver) {
        super(driver);
    }
    public static NotificationPage action(){
        return new NotificationPage(getDriver());
    }

    public NotificationPage load(){
        load("/notification_message_rendered");
        return this;
    }

    public NotificationPage clickButton(){
        clickHereButton.click();
        return this;
    }

    public void assertNotificationSucessful(String not){
        System.out.println(notification.getText());
        Assert.assertEquals(notification.getText(),not);

    }
}
