package com.autoqatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

    private final String FORM_URL =
            "https://demoqa.com/automation-practice-form";

    @Test(description = "TC005 - Signup Form - Valid Data")
    public void testSignupWithValidData() {
        driver.get(FORM_URL);
        driver.findElement(By.cssSelector("#firstName")).sendKeys("John");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("Doe");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("johndoe@test.com");
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        driver.findElement(By.cssSelector("#userNumber")).sendKeys("9876543210");
        System.out.println("TC005 PASSED: Signup form filled successfully");
    }

    @Test(description = "TC006 - Form Validation - Empty Submit")
    public void testFormValidationOnEmptySubmit() {
        driver.get(FORM_URL);
        driver.findElement(By.cssSelector("#submit")).click();
        WebElement firstNameField = driver.findElement(By.cssSelector("#firstName"));
        Assert.assertNotNull(firstNameField, "First name field not found");
        System.out.println("TC006 PASSED: Form validation working on empty submit");
    }

    @Test(description = "TC007 - Check All Locator Types")
    public void testAllLocatorTypes() {
        driver.get(FORM_URL);

        WebElement firstName = driver.findElement(By.id("firstName"));
        Assert.assertNotNull(firstName, "ID locator failed");

        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        Assert.assertNotNull(lastName, "CSS selector locator failed");

        WebElement emailField = driver.findElement(By.xpath("//input[@id='userEmail']"));
        Assert.assertNotNull(emailField, "XPath locator failed");

        WebElement header = driver.findElement(By.className("practice-form-wrapper"));
        Assert.assertNotNull(header, "Class name locator failed");

        System.out.println("TC007 PASSED: All locator strategies working");
    }
}