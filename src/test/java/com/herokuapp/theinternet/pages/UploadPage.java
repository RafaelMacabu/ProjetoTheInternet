package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class UploadPage extends BasePage {
    @FindBy(xpath = "//input[@id = 'file-upload']")
    private WebElement fileUpload;
    @FindBy(xpath = "//input[@id = 'file-submit']")
    private WebElement fileSubmit;
    @FindBy(xpath = "//div[@id ='uploaded-files']")
    private WebElement fileName;

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public static UploadPage action() {
        return new UploadPage(getDriver());
    }

    public UploadPage load(){
        load("/upload");
        return this;
    }

    public UploadPage uploadFile(){
        String filename = "test-file.txt";
        File file = new File(filename);
        String path = "C:\\Users\\Rafael\\IdeaProjects\\ProjetoTheInternet\\src\\test\\resources\\" + filename;
        fileUpload.sendKeys(path);
        return this;
    }

    public UploadPage clickUploadButton(){
        fileSubmit.click();
        return this;
    }

    public void assertFileName(String Name){
        Assert.assertEquals(fileName.getText(),Name);
        System.out.println(fileName.getText());

    }
}
