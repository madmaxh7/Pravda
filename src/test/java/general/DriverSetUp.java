package general;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetUp {
    protected WebDriver driver;

    public WebDriver setUpDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public void quitDriver(){
        if(driver != null){
            driver.close();
            driver.quit();
        }
    }
}