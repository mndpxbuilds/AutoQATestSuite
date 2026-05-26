package com.autoqatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private final String LOGIN_URL =
            "https://practicetestautomation.com/practice-test-login/";

    @Test(description = "TC001 - Valid Login Test")
    public void testValidLogin() {
        driver.get(LOGIN_URL);
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.cssSelector("#submit")).click();

        String successText = driver.findElement(
                By.cssSelector(".post-title")).getText();
        Assert.assertTrue(successText.contains("Logged In"),
                "Login failed - success message not found");

        System.out.println("TC001 PASSED: Valid login successful");
    }

    @Test(description = "TC002 - Invalid Username Test")
    public void testInvalidUsername() {
        driver.get(LOGIN_URL);
        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.cssSelector("#submit")).click();

        WebElement errorMsg = driver.findElement(By.xpath("//div[@id='error']"));
        Assert.assertTrue(errorMsg.isDisplayed());
        Assert.assertTrue(errorMsg.getText().contains("Your username is invalid"));
        System.out.println("TC002 PASSED: Invalid username handled correctly");
    }

    @Test(description = "TC003 - Invalid Password Test")
    public void testInvalidPassword() {
        driver.get(LOGIN_URL);
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("wrongpassword");
        driver.findElement(By.cssSelector("#submit")).click();

        WebElement errorMsg = driver.findElement(By.xpath("//div[@id='error']"));
        Assert.assertTrue(errorMsg.isDisplayed());
        Assert.assertTrue(errorMsg.getText().contains("Your password is invalid"));
        System.out.println("TC003 PASSED: Invalid password handled correctly");
    }

    @Test(description = "TC004 - Empty Fields Test")
    public void testEmptyFields() {
        driver.get(LOGIN_URL);
        driver.findElement(By.cssSelector("#submit")).click();

        WebElement errorMsg = driver.findElement(By.xpath("//div[@id='error']"));
        Assert.assertTrue(errorMsg.isDisplayed());
        System.out.println("TC004 PASSED: Empty field validation working");
    }
}