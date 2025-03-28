package Ques_2_Page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BAsePage {
    protected WebDriver driver;

    public BAsePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public  void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; 
    }
    }
}

