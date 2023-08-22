package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class DropdownPage extends BasePage {

    @FindBy(xpath = "//select[@id = 'dropdown']")
    private WebElement dropdown;




    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public static DropdownPage action() {
        return new DropdownPage(getDriver());
    }

    public DropdownPage load() throws InterruptedException {
        load("/dropdown");
        return this;
    }

    public DropdownPage clickOption(String value) throws InterruptedException {
        Select select = new Select(dropdown);
        select.selectByValue(value);
        return this;
    }

    public void assertSelected(String option){
        Select select = new Select(dropdown);
       Assert.assertEquals(select.getFirstSelectedOption().getText(),"Option " + option);
    }
}
