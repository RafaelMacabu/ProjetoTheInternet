package com.herokuapp.theinternet.base;

import com.herokuapp.theinternet.constants.BrowserType;
import com.herokuapp.theinternet.factory.ChromeDriverManager;
import com.herokuapp.theinternet.factory.DriverManagerFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected WebDriverWait wait;

    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    public static WebDriver getDriver(){
        return driver.get();
    }


    @Parameters("browser")
    @BeforeMethod
    public void startDriver(@Optional("FIREFOX") String browser ){
        browser = System.getProperty("browser",browser);
        setDriver(DriverManagerFactory.getManager(BrowserType.valueOf(browser)).createDriver());
        System.out.println("CURRENT THREAD:" + Thread.currentThread().getId());
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    }


    @AfterMethod
    public void quitDriver(ITestResult result) throws IOException {
        System.out.println("CURRENT THREAD:" + Thread.currentThread().getId());
        getDriver().quit();

    }

    private void takeScreenshot(File destFile) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,destFile);
    }
}
