package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstSeleniumScript {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        
        try {
            // Navigate to Gmail
            driver.get("http://www.gmail.com/");
            // Maximize the browser window
            driver.manage().window().maximize();

            // Initialize WebDriverWait with a 10-second timeout
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for the email field to be visible and enter the email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
            emailField.sendKeys("minura123@gmail.com");

            // Wait for the "Next" button to be clickable and click it
            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']/ancestor::button")));
            nextButton.click();

            // Additional wait to simulate the user seeing the process
            Thread.sleep(10000);

            // You can add more steps here to log in completely if needed
            // For example, entering the password and clicking the next button again

            // Wait for the title to contain "Gmail"
            wait.until(ExpectedConditions.titleContains("Gmail"));

            // Get the actual title of the page
            String actualTitle = driver.getTitle();
            // Expected title
            String expectedTitle = "Gmail";

            // Print out the actual title for debugging
            System.out.println("Actual Title: " + actualTitle);

            // Compare the actual title with the expected title
            if (actualTitle.equalsIgnoreCase(expectedTitle)) {
                System.out.println("Success");
            } else {
                System.out.println("Unsuccessful");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
