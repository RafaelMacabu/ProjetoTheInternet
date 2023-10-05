package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class DynamicContentPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'large-10 columns']")
    private List<WebElement> textoGeral;
    @FindBy (xpath = "//a[@href = '/dynamic_content?with_content=static']")
    private WebElement staticButton;

    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    public static DynamicContentPage action() {
        return new DynamicContentPage(getDriver());
    }

    public DynamicContentPage load(){
        load("/dynamic_content");
        return this;
    }

    public DynamicContentPage makeStatic(){
        staticButton.click();
        return this;
    }

    public void assertContentIsStatic(){
        System.out.println(textoGeral.get(0).getText());
        Assert.assertTrue(textoGeral.get(0).getText().contains("Accusantium eius ut architecto neque vel voluptatem vel nam eos minus ullam dolores voluptates enim sed voluptatem rerum qui sapiente nesciunt aspernatur et accusamus laboriosam culpa tenetur hic aut placeat error autem qui sunt."));
    }
}
