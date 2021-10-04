package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

public class SecondPage extends GeneralPageMethods {
    public SecondPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath  = "//*[@class='main_logo_link']/*")
    public WebElement secondHeadImgPage;

    @FindBy (xpath  = "//*[@class='post_title']")
    public WebElement secondPageTitle;



}
