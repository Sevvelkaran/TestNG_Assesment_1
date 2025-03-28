package Ques_2_Test;

import org.testng.annotations.*;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;
import Ques_2_Page.Addto;
import Ques_2_Page.Checkout;
import Ques_2_Page.login;
import static org.testng.Assert.assertFalse;

public class main {
    WebDriver driver;
    login loginPage;
    Addto cartPage;
    Checkout checkoutPage;
    SoftAssert softAssert;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.get("https://www.saucedemo.com/v1/index.html");
        loginPage = new login(driver);
        cartPage = new Addto(driver);
        checkoutPage = new Checkout(driver);
        softAssert = new SoftAssert();
    }

    @Test(priority = 1)
    public void loginTest() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(priority = 2, dependsOnMethods = "loginTest")
    public void addToCartTest() {
        cartPage.addtocart();
        cartPage.itemverify();
    }

    @Test(priority = 3, dependsOnMethods = "addToCartTest")
    public void removeFromCartTest() {
        cartPage.removecart();
        cartPage.itemremoveverify();
    }

    @Test(priority = 4, dependsOnMethods = "addToCartTest")
    public void checkoutTest() {
        cartPage.addtocart();
        cartPage.openCart();
        checkoutPage.checkoutbtn();
        checkoutPage.details("karan", "sevvel", "09876");
        checkoutPage.finish();
        checkoutPage.verify();
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
