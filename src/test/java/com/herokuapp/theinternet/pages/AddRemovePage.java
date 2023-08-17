package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class AddRemovePage extends BasePage {

    @FindBy(xpath = "//button[@onclick = 'addElement()']")
    private WebElement addElement;
    @FindBy(xpath = "//button[@onclick = 'deleteElement()']")
    private List<WebElement> deleteElement;

    public AddRemovePage(WebDriver driver) {
        super(driver);
    }

    public static AddRemovePage action(){
        return new AddRemovePage(getDriver());
    }

    public AddRemovePage load(){
        load("/add_remove_elements/");
        return this;
    }

    public AddRemovePage clickAdd(){
        addElement.click();
        return this;
    }

    public AddRemovePage clickAdd(int times){
        for (int i = 0; i < times; i++) {
            addElement.click();
        }
        return this;
    }

    public AddRemovePage clickDelete(){
        deleteElement.get(0).click();
        return this;
    }

    public AddRemovePage clickDelete(int times){
        for (int i = 0; i < times; i++) {
            deleteElement.get(0).click();
        }
        return this;
    }

    public void assertQuantity(int times){
        Assert.assertEquals(deleteElement.size(),times);

    }

}
