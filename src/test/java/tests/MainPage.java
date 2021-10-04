package tests;

import general.DriverSetUp;
import pages.SecondPage;
import pages.StartPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainPage extends DriverSetUp {
    WebDriver driver;

    @BeforeTest
    public void startTest() {
        driver = setUpDriver();
    }

    @Test //check main page load, and internet connection is allow
    public void openTheHomePageAndTextChecks() {
        StartPage startPage = new StartPage(driver);
        String url = startPage.getMainUrl();
        startPage.openPagePravda();
        Reporter.log("Check that " + url + "page opened");
        Assert.assertTrue(startPage.checkElementExisting(startPage.mainHeadImgPage));
        Reporter.log(url + "page opened");
    }

    @Test
    public void checkTitleMainAndSecondPage () {
        StartPage startPage = new StartPage(driver);
        SecondPage secondPage = new SecondPage(driver);
        String url = startPage.getMainUrl();
        startPage.openPagePravda();
        Reporter.log("Check that " + url + "page opened");
        Assert.assertTrue(startPage.checkElementExisting(startPage.mainHeadImgPage));
        Reporter.log(url + "page opened");
        Reporter.log("First News is visible" + startPage.checkFirstNews());
        String expectedResult = startPage.getElementTest(startPage.firstFrame);
        Reporter.log("Click first element");
        startPage.clickFirstNews();
        Reporter.log("Check that " + url + "page opened");
        Assert.assertTrue(startPage.checkElementExisting(secondPage.secondHeadImgPage));
        String actualResult = secondPage.getElementTest(secondPage.secondPageTitle);
        Assert.assertTrue(expectedResult.equals(actualResult));
    }

    @AfterTest
    public void closeDriver() {
        quitDriver();
    }
}