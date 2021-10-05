package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends GeneralPageMethods {


    public StartPage (WebDriver driver) {
        super(driver);
    }

    String urlStartPage = "https://www.pravda.com.ua/";

    @FindBy(xpath  = "//*[@class='cls-1']")
    public WebElement mainHeadImgPage;

    @FindBy(xpath  = "//*[@class='container_sub_top_news_wrapper']//*[@data-vr-global-position='1']")
    public WebElement firstFrame;

    public void openPagePravda(){
        driver.get(urlStartPage);
        System.out.println("openPagePravda");
        waitElementVisible(mainHeadImgPage);
    }
    public boolean checkFirstNews(){
        driver.get(urlStartPage);
        waitElementVisible(firstFrame);
        return false;
    }

    public String getMainUrl() {
        return urlStartPage;
    }

    public void clickFirstNews() {
        driver.get(urlStartPage);
        clickElement(firstFrame);
    }

}