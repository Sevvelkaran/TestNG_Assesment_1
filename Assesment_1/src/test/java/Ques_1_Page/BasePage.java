package Ques_1_Page;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

   
    public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
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


