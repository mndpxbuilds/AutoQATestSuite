package com.autoqatest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class FormValidationTest extends BaseTest {

    private final String CONTACT_URL =
            "https://www.selenium.dev/selenium/web/web-form.html";

    @Test(description = "TC008 - Web Form Elements Test")
    public void testWebFormElements() {
        driver.get(CONTACT_URL);

        WebElement textInput = driver.findElement(By.cssSelector("#my-text-id"));
        textInput.sendKeys("Test Input Value");
        Assert.assertEquals(textInput.getAttribute("value"), "Test Input Value");

        WebElement pwdField = driver.findElement(By.cssSelector("[name='my-password']"));
        pwdField.sendKeys("SecurePass123");
        Assert.assertEquals(pwdField.getAttribute("value"), "SecurePass123");

        WebElement textarea = driver.findElement(By.cssSelector("[name='my-textarea']"));
        textarea.sendKeys("This is a test message");

        System.out.println("TC008 PASSED: Form elements interacted successfully");
    }

    @Test(description = "TC009 - Explicit Wait Test")
    public void testExplicitWait() {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement usernameField = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("username")));

        usernameField.sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        WebElement successMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".post-title")));
        Assert.assertTrue(successMsg.isDisplayed());

        System.out.println("TC009 PASSED: Explicit wait working correctly");
    }

    @Test(description = "TC010 - JavaScript Executor Test")
    public void testJavaScriptExecutor() {
        driver.get(CONTACT_URL);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement submitBtn = driver.findElement(By.cssSelector("[type='submit']"));
        js.executeScript("arguments[0].click();", submitBtn);

        System.out.println("TC010 PASSED: JavaScript executor working");
    }
}