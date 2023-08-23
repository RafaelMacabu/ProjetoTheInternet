package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

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

}
