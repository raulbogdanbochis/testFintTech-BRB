package ui_tests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginElements {

    WebDriver driver;

    By username = By.id("email");
    By password = By.id("password");
    By login = By.name("login");

    public LoginElements(WebDriver driver1) {
        this.driver = driver1;
    }

    public void userDates(String uid) {
        driver.findElement(By.cssSelector(".controls #email")).sendKeys(uid);
    }


    public void loginName(String uid) {
        driver.findElement(By.cssSelector(".controls #name")).sendKeys(uid);
    }

    public void loginPwd(String pwd) {
        driver.findElement(By.cssSelector(".controls #password")).sendKeys(pwd);
    }

    public void loginPwd2(String pwd) {
        driver.findElement(By.cssSelector(".controls #confirmationPassword")).sendKeys(pwd);
    }

    public void buttonCreate() {
        driver.findElement(By.cssSelector(".btn-primary .icon-lock")).click();
        /*JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[1].click();", element1);*/
    }

    public void newUserButton(){
        driver.findElement(By.cssSelector(".btn-default")).click();
    }

    public String nameUniqueMessage(){
        String message = driver.findElement(By.id("user.name.error")).getText();
        return message;
    }

    public String emailUniqueMessage(){
        String message = driver.findElement(By.id("user.email.error")).getText();
        return message;
    }

    public String passwordUniqueMessage(){
        String message = driver.findElement(By.id("user.password.error")).getText();
        return message;
    }

    public String confirmationPasswordUniqueMessage(){
        String message = driver.findElement(By.id("user.confirmationPassword.error")).getText();
        return message;
    }


}

