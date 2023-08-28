package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class HorizontalSliderPage extends BasePage {
    @FindBy(xpath = "//input[@type = 'range']")
    private WebElement slider;
    @FindBy(xpath = "//span[@id = 'range']")
    private WebElement result;

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    public static HorizontalSliderPage action(){
        return new HorizontalSliderPage(getDriver());
    }

    public HorizontalSliderPage load(){
        load("/horizontal_slider");
        return this;
    }

    public HorizontalSliderPage scroll(int coordinate){
        Actions act = new Actions(getDriver());
        act.dragAndDropBy(slider,coordinate,0).perform();
        System.out.println(result.getText());
        return this;

    }

    public void AssertResult(String expected){
        Assert.assertEquals(result.getText(),expected);
    }
}
