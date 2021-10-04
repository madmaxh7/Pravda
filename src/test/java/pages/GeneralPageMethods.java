package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralPageMethods {
    WebDriver driver;

    public GeneralPageMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public String getElementTest(WebElement element) {
        String textElement = element.getText();
        return textElement;
    }

    public boolean checkElementExisting(WebElement element){
        return element.isDisplayed();
    }

    public void clickElement (WebElement element) {
        waitElementVisible(element);
        element.click();
    }

}
