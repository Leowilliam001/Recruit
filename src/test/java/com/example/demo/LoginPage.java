package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPage {
    private WebDriver driver;
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login");
    private By regButton = By.id("register");

    public LoginPage() {
        this.driver = new ChromeDriver();
    }

    @Test(dataProvider = "dp")
    public void registration(String username, String password) {
        driver.get("http://localhost:8080");
        driver.findElement(By.xpath("/html/body/form/a")).click();
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(regButton).click();
        // driver.navigate().back();
        // driver.quit();
    }

    @Test(dataProvider = "dp")
    public void validation(String username, String password) {
        driver.get("http://localhost:8080");
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Test(dataProvider = "dp2")
    public void addJobTest(String job, String salary, String phno) {
        driver.get("http://localhost:8080/rechome");
        driver.findElement(By.xpath("/html/body/div[2]/a[2]")).click();
        driver.switchTo().frame("cont");
        driver.findElement(By.xpath("/html/body/form/input[1]")).clear();
        driver.findElement(By.xpath("/html/body/form/input[1]")).sendKeys(job);
        driver.findElement(By.xpath("/html/body/form/input[2]")).clear();
        driver.findElement(By.xpath("/html/body/form/input[2]")).sendKeys(salary);
        driver.findElement(By.xpath("/html/body/form/input[3]")).clear();
        driver.findElement(By.xpath("/html/body/form/input[3]")).sendKeys(phno);
        driver.findElement(By.xpath("/html/body/form/input[4]")).click();
    }

    @Test
    public void remJobTest() {
        driver.get("http://localhost:8080/rechome");
        driver.findElement(By.xpath("/html/body/div[2]/a[2]")).click();
        driver.switchTo().frame("cont");
        driver.findElement(By.xpath("//*[@id=\"flash-cards\"]/div[1]/form/input[2]")).click();
    }

    @DataProvider(name = "dp")
    public Object[][] dp() {
        return new Object[][] { { "sriram", "kins@123" }, { "syed", "eric@123" } };
    }

    @DataProvider(name = "dp2")
    public Object[][] dp2() {
        return new Object[][] { { "Job 1", "$700", "4373746783" }, { "Job 2", "$1100", "3784673578" } };
    }
}
