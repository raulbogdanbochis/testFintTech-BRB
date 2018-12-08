package ui_tests.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui_tests.pages.LoginElements;

public class Tests {
    WebDriver driver = new ChromeDriver();

    @Test
    public void createAccount() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver.get("http://85.93.17.135:9000/user/new");
        LoginElements login = new LoginElements(driver);
        login.loginName("Test1");
        login.userDates("raul_bogdan_alias@yahoo.com");
        login.loginPwd("123456");
        login.loginPwd2("123456");
        login.buttonCreate();
        driver.close();
        driver.quit();
    }

    @Test
    public void createAccountWithSameName() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver.get("http://85.93.17.135:9000/user/new");
        LoginElements login = new LoginElements(driver);
        login.loginName("Test2");
        login.userDates("raul_bogdan_alias1@yahoo.com");
        login.loginPwd("123456");
        login.loginPwd2("123456");
        login.buttonCreate();
        login.newUserButton();
        login.loginName("Test2");
        login.userDates("raul_bogdan_alias1@yahoo.com");
        login.loginPwd("123456");
        login.loginPwd2("123456");
        login.buttonCreate();
        Assert.assertEquals("Must be unique", login.nameUniqueMessage());
        driver.close();
        driver.quit();
    }

    @Test
    public void createAccountWithSameEmail() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver.get("http://85.93.17.135:9000/user/new");
        LoginElements login = new LoginElements(driver);
        login.loginName("Test3");
        login.userDates("raul_bogdan_alias2@yahoo.com");
        login.loginPwd("123456");
        login.loginPwd2("123456");
        login.buttonCreate();
        login.newUserButton();
        login.loginName("Test4");
        login.userDates("raul_bogdan_alias2@yahoo.com");
        login.loginPwd("123456");
        login.loginPwd2("123456");
        login.buttonCreate();
        Assert.assertEquals("Must be unique", login.emailUniqueMessage());
        driver.close();
        driver.quit();
    }

    @Test
    public void createAccountWithoutData() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver.get("http://85.93.17.135:9000/user/new");
        LoginElements login = new LoginElements(driver);
        login.buttonCreate();
        Assert.assertEquals("Required", login.nameUniqueMessage());
        Assert.assertEquals("Required", login.emailUniqueMessage());
        Assert.assertEquals("Required", login.passwordUniqueMessage());
        driver.close();
        driver.quit();
    }

    @Test
    public void createAccountWithoutConfirmationPass() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver.get("http://85.93.17.135:9000/user/new");
        LoginElements login = new LoginElements(driver);
        login.loginName("Test5");
        login.userDates("raul_bogdan_alias3@yahoo.com");
        login.loginPwd("123456");
        login.buttonCreate();
        Assert.assertEquals("passwords are not the same", login.confirmationPasswordUniqueMessage());
        driver.close();
        driver.quit();
    }

    @Test
    public void createAccountWithWrongConfirmationPass() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver.get("http://85.93.17.135:9000/user/new");
        LoginElements login = new LoginElements(driver);
        login.loginName("Test6");
        login.userDates("raul_bogdan_alias6@yahoo.com");
        login.loginPwd("123456");
        login.loginPwd2("12345");
        login.buttonCreate();
        Assert.assertEquals("passwords are not the same", login.confirmationPasswordUniqueMessage());
        driver.close();
        driver.quit();
    }

    @Test
    public void createAccountWithShortPass() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver.get("http://85.93.17.135:9000/user/new");
        LoginElements login = new LoginElements(driver);
        login.loginName("Test7");
        login.userDates("raul_bogdan_alias7@yahoo.com");
        login.loginPwd("1234");
        login.loginPwd2("1234");
        login.buttonCreate();
        Assert.assertEquals("Minimum size is 6", login.passwordUniqueMessage());
        driver.close();
        driver.quit();
    }

    @Test
    public void createAccountWithInvalidEmail() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver.get("http://85.93.17.135:9000/user/new");
        LoginElements login = new LoginElements(driver);
        login.loginName("Test8");
        login.userDates("raul_bogdan_alias8@");
        login.loginPwd("123456");
        login.loginPwd2("123456");
        login.buttonCreate();
        Assert.assertEquals("Invalid email address", login.emailUniqueMessage());
        driver.close();
        driver.quit();
    }

}
