package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class TypoPage extends BasePage {
    @FindBy(xpath = "//div[@class = 'example']")
    private WebElement typoText;

    public TypoPage(WebDriver driver) {
        super(driver);
    }

    public static TypoPage action(){
        return new TypoPage(getDriver());
    }

    public TypoPage load(){
        load("/typos");
        return this;
    }

    public String getText(){
        return typoText.getText();
    }

    public void assertIfTextHasATypo(){
        System.out.println(typoText.getText());
        Assert.assertTrue(typoText.getText().contains("Sometimes you'll see a typo, other times you won't."));
    }
}
