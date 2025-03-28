package Ques_1_test;

import org.testng.annotations.Test;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import Ques_1_Page.login;
import ExcelUtils.ExcelUtils;

public class logintest {
    WebDriver driver;
    login loginPage;
    String excelPath = "/Users/sevvelkaranpalanivetrivel/Desktop/TestData.xlsx"; 

    @BeforeMethod
    public void setup() {
      
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");
        loginPage = new login(driver);
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, String error) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        
        assertTrue(loginPage.getErrorMessage(error).contains("Epic sadface: Username is required"), "Expected 'Username is required' error message!");

       
           // assertTrue(loginPage.getErrorMessage().contains(error), "Error message mismatch!");
       
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return ExcelUtils.getTestData(excelPath, "Sheet1");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
