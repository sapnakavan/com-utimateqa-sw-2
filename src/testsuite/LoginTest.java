package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl ="https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);

    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //* click on the ‘Sign In’ link
        // driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        WebElement signin = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        signin.click();

        // * Verify the text ‘Welcome Back!’

        WebElement verify = driver.findElement(By.xpath("//h1[@class='page__heading']"));
        String accmess =verify.getText();

        String expmess ="Welcome Back!";

        Assert.assertEquals(expmess,accmess);
    }
    @Test
    public void verifyTheErrorMessage(){
       // * click on the ‘Sign In’ link
        // driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        WebElement signin = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        signin.click();

        //* Enter invalid username
        // driver.findElement(By.xpath("//input[@id='user[email]']")).sendkeys("test@gmail.com");
        WebElement username = driver.findElement(By.xpath("//input[@id='user[email]']"));
        username.sendKeys("test@gmail.com");

        //* Enter invalid password
        // driver.findElement(By.xpath("//input[@id='user[password]']")).sendkeys("123456");
        WebElement password = driver.findElement(By.xpath("//input[@id='user[password]']"));
        password.sendKeys("123456");



        // * Click on Login button
        // driver.findElement(By.xpath("//input[@class='button button-primary g-recaptcha']")).click();
        WebElement login = driver.findElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
        login.click();



        // * Verify the error message ‘Invalid email or password.’
        WebElement verify = driver.findElement(By.xpath("//div[@class='notice__form-error']"));
        String accmess =verify.getText();

        String expmess ="Invalid email or password.";

        Assert.assertEquals(expmess,accmess);


    }
    @After
    public void teardown(){
        closeBrowser();
    }
    }

