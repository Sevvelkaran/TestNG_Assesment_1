package Ques_1_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login extends BasePage {
    public login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



    By usernameField = By.xpath("//input[@placeholder='Username']");
    By passwordField =By.xpath("//input[@placeholder='Password']");
    By loginButton = By.xpath("//input[@type='submit']");
    By errorMessage = By.xpath("//h3");

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
       driver. findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage(String error) {
        return driver.findElement(errorMessage).getText();
    }
}
