package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class HoversPage extends BasePage {
    @FindBy(xpath = "//div[1][@class = 'figure']")
    private WebElement figure1;
    @FindBy(xpath = "//div[2][@class = 'figure']")
    private WebElement figure2;
    @FindBy(xpath = "//div[3][@class = 'figure']")
    private WebElement figure3;
    @FindBy(xpath = "//div[@class = 'figure']")
    private List<WebElement> figureList;
    public HoversPage(WebDriver driver) {
        super(driver);
    }

    public static HoversPage action(){
        return new HoversPage(getDriver());
    }

    public HoversPage load(){
        load("/hovers");
        return this;
    }

    public HoversPage hoverFigure(int figure){
        Actions builder = new Actions(getDriver());
        switch (figure) {
            case 1 -> builder.moveToElement(figure1).build().perform();
            case 2 -> builder.moveToElement(figure2).build().perform();
            case 3 -> builder.moveToElement(figure3).build().perform();
        }
        return this;

    }

    public void assertFigureIsHovered(int figure){
        switch (figure){
            case 1 -> Assert.assertTrue(getDriver().findElement(By.xpath("//a[@href = '/users/1']")).isDisplayed());
            case 2 -> Assert.assertTrue(getDriver().findElement(By.xpath("//a[@href = '/users/2']")).isDisplayed());
            case 3 -> Assert.assertTrue(getDriver().findElement(By.xpath("//a[@href = '/users/3']")).isDisplayed());
        }

    }
}
