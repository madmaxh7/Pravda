package tests;

import general.DriverSetUp;
import org.openqa.selenium.WebElement;
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
    public void Test_1_OpenTheHomePageAndTextChecks() {
        StartPage startPage = new StartPage(driver);
        String url = startPage.getMainUrl();
        System.out.println("Main url is: " + url);
        startPage.openPagePravda();
        Reporter.log("Check that " + url + "page opened");
        Assert.assertTrue(startPage.checkElementExisting(startPage.mainHeadImgPage));
        Reporter.log(url + "page opened");
    }

    @Test
    public void Test_2_CheckTitleMainAndSecondPage () {
        StartPage startPage = new StartPage(driver);
        SecondPage secondPage = new SecondPage(driver);
        String url = startPage.getMainUrl();
        System.out.println("Main url is: " + url);
        startPage.openPagePravda();
        Reporter.log("Check that " + url + "page opened");
        Assert.assertTrue(startPage.checkElementExisting(startPage.mainHeadImgPage));
        Reporter.log(url + "page opened");
        Reporter.log("First News is visible" + startPage.checkFirstNews());
        String expectedResult = startPage.getElementTest(startPage.firstFrame);
        System.out.println("First News is visible");
        Reporter.log("Click first element");
        startPage.clickFirstNews();
        secondPage.selectSecondTabAndCloseOther();
        WebElement elementLocator = secondPage.checkSecondPageTabTitle(secondPage.secondPageTabTitle);
        Reporter.log("Check that " + url + "page opened");
        Assert.assertTrue(startPage.checkElementExisting(secondPage.secondHeadTitle));
        String actualResult = secondPage.getElementTest(elementLocator);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterTest
    public void closeDriver() {
        quitDriver();
    }
}