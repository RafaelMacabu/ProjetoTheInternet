package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.KeyPressesPage;
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

  }

}
