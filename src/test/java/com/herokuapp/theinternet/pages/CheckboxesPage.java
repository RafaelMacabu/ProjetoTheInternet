package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class CheckboxesPage extends BasePage {

    @FindBy(xpath = "//input[1][@type = 'checkbox']")
    private WebElement checkbox1;
    @FindBy(xpath = "//input[2][@type = 'checkbox']")
    private WebElement checkbox2;
    @FindBy(xpath = "//input[@type = 'checkbox']")
    private List<WebElement> checkboxList;

    public CheckboxesPage(WebDriver driver){
        super(driver);
    }

    public static CheckboxesPage action(){
        return new CheckboxesPage(getDriver());
    }

    public CheckboxesPage load(){
        load("/checkboxes");
        return this;
    }

    public CheckboxesPage clickCheckbox1(){
        checkboxList.get(0).click();
        return this;
    }

    public CheckboxesPage clickCheckbox2(){
        checkboxList.get(1).click();
        return this;
    }

    public void assertIfCheckbox1IsChecked(){
        Assert.assertTrue(checkboxList.get(0).isSelected());
    }

    public void assertIfCheckbox2IsChecked(){
        Assert.assertTrue(checkboxList.get(1).isSelected());
    }

    public void assertIfAllCheckboxesAreChecked(){
        Assert.assertTrue(checkboxList.get(0).isSelected());
        Assert.assertTrue(checkboxList.get(1).isSelected());
    }

    public void assertIfNoCheckboxesAreChecked(){
        Assert.assertFalse(checkboxList.get(0).isSelected());
        Assert.assertFalse(checkboxList.get(1).isSelected());
    }
}
