package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;

import static com.herokuapp.theinternet.base.BaseTest.getDriver;

public class DragAndDropPage extends BasePage {
    @FindBy (xpath = "//div[@draggable = 'true'][1]")
    private WebElement coluna1;
    @FindBy (xpath = "//div[@draggable = 'true'][2]")
    private WebElement coluna2;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public static DragAndDropPage action() {
        return new DragAndDropPage(getDriver());
    }

    public DragAndDropPage load(){
        load("/drag_and_drop");
        return this;
    }

    public DragAndDropPage dragAndDropColumn1() throws FileNotFoundException, ScriptException {
        Reader reader = new InputStreamReader(new FileInputStream("C:/Users/Rafael/IdeaProjects/ProjetoTheInternet/src/test/java/com/herokuapp/theinternet/utils/dnd.js"));
        ((JavascriptExecutor) getDriver()).executeScript(reader+"$('#column-a').simulateDragDrop({ dropTarget: '#column-b'});");
        System.out.println(coluna1.getText());
        return this;
    }
}
