package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Set;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class NewWindowPage extends BasePage {
    @FindBy(xpath = "//a[@href = '/windows/new']")
    private WebElement newWindowButton;

    String firstWindow;
    String newWindow;

    public NewWindowPage(WebDriver driver) {
        super(driver);
    }

    public static NewWindowPage action(){
        return new NewWindowPage(getDriver());
    }

    public NewWindowPage load(){
        load("/windows");
        return this;
    }

    public NewWindowPage setWindows(){
        firstWindow = getDriver().getWindowHandle();
        newWindow = "";
        newWindowButton.click();
        Set<String> allWindows = getDriver().getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(firstWindow)){
                newWindow = window;
            }

        }

        return this;
    }

    public NewWindowPage clickNewWindow(){
        newWindowButton.click();
        return this;
    }

    public void assertNewWindowIsDisplayed(){
        if (newWindow != null){
            getDriver().switchTo().window(newWindow);
            System.out.println(getDriver().getTitle());
            Assert.assertEquals(getDriver().getTitle(),"New Window");
        }else {
            System.out.println(getDriver().getWindowHandle());
            System.out.println("There isn't any new Windows open");
            Assert.assertEquals(getDriver().getTitle(),"New Window");
        }

    }


}
