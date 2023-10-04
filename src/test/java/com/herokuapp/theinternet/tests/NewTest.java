package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.script.ScriptException;
import java.io.FileNotFoundException;

public class NewTest extends BaseTest {

    @Test
  public void KeyPressesTest() throws InterruptedException {
    KeyPressesPage.action()
            .load()
            .pressKey("r");

    Assert.assertTrue(KeyPressesPage.action().assertIfResultIsEqual("r"));

  }

  @Test
  public void CheckboxesTest(){
    CheckboxesPage.action()
            .load()
            .clickCheckbox2()
            .assertIfNoCheckboxesAreChecked();

  }
  @Test
  public void AddRemoveTest(){
    AddRemovePage.
            action().
            load().
            clickAdd(3).
            clickDelete(3).
            assertQuantity(0);

  }

  @Test
  public void DropdownTest() throws InterruptedException {
    DropdownPage.
            action().
            load().
            clickOption("2").
            assertSelected("2");
  }

  @Test
  public void TypoTest(){

    TypoPage.
            action().
            load().
            assertIfTextHasATypo();
  }

  @Test
  public void LoginTest(){
    LoginPage.
            action().
            load().
            inputUsername("tomsmith").
            inputPassword("").
            clickLoginButton().
            assertLoginWrongpassword();


  }

  @Test
  public void HorizontalSliderTest(){
    HorizontalSliderPage.
            action().
            load().
            scroll(100).
            AssertResult("5");
  }

  @Test //não funciona até eu descobrir como injetar javascript no codigo
  public void DragAndDropTest() throws ScriptException, FileNotFoundException {
    DragAndDropPage.
            action().
            load().
            dragAndDropColumn1();
  }

  @Test
  public void UploadTest(){
    UploadPage.
            action().
            load().
            uploadFile().
            clickUploadButton().
            assertFileName("test-file.txt");
  }

  @Test
  public void DisappearingElementTest(){
    DisappearingPage.
            action().
            load().
            assertIfElementisPresent();
  }

  @Test
  public void FloatingMenuTest(){
    FloatingMenuPage.
            action().
            load().
            clickHome().
            assertUrl("http://the-internet.herokuapp.com/floating_menu#home");
  }

  @Test
  public void NotificationTest(){
    NotificationPage.
            action().
            load().
            clickButton().
            assertNotificationSucessful("Action successful\n" +
                    "×");
  }

  @Test
  public void HoverTest(){
    HoversPage.
            action().
            load().
            hoverFigure(3).
            assertFigureIsHovered(3);
  }

  @Test
  public void BasicAuthTest(){
    BasicAuthPage.
            action().
            loadWithAuth().
            assertAuth();
  }

  @Test
  public void NewWindowTest(){
    NewWindowPage.
            action().
            load().
            setWindows().
            assertNewWindowIsDisplayed();
  }

  @Test
  public void ContextMenuTest(){
    ContextMenuPage.
            action().
            load().
            contextClickHotspot().
            assertAlertMessage();

  }

  @Test
  public void JSAlertTest(){
      JSAlertsPage.
              action().
              load().
              clickJSInputPrompt().
              inputAlert("sexo").
              acceptAlert().
              assertJSInputAlert("sexo");
  }

}
