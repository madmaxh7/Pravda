package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class SecondPage extends GeneralPageMethods {
    public SecondPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='main_logo']/*/*")
    public WebElement secondHeadTitle;

    @FindBy(xpath = "//*[@class='main_logo']/*/*/*")
    public WebElement secondPageTabTitle;

    @FindBy(xpath = "//*[@class='post_header']/h1")
    public WebElement secondPageNewsTitleUP;

    @FindBy(xpath = "//*[@class='post__header']/h1")
    public WebElement secondPageNewsTitleEP;

    public void selectSecondTabAndCloseOther() {
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        if (windowHandles.size() > 2) {
            String currentWindowHandle = driver.getWindowHandle();
            for (String window : windowHandles) {
                if (!window.equals(currentWindowHandle)) {
                    driver.switchTo().window(window);
                    driver.close();
                }
            }
        }
    }

    public WebElement checkSecondPageTabTitle(WebElement element) {
        WebElement elementLocator;
        if (element.getText().equals("Українська правда")) {
            System.out.println("Second Page is: " + element.getText());
            elementLocator = secondPageNewsTitleUP;
        } else if (element.getText().equals("Економічна правда")) {
            System.out.println("Second Page is: " + element.getText());
            elementLocator = secondPageNewsTitleEP;
        } else {elementLocator = secondPageNewsTitleUP;}
                return elementLocator;
    }
}
