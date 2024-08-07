package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettingStarted {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable if it's not in your system PATH
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Open Google
            driver.get("https://www.google.com");

            // Find the search box
            WebElement searchBox = driver.findElement(By.name("q"));

            // Type the search query
            searchBox.sendKeys("Selenium WebDriver");

            // Submit the search form
            searchBox.submit();

            // Wait for the results page to load and display the results
            Thread.sleep(2000);  // This is a simple way to wait, but it's better to use WebDriverWait

            // Print the title of the first result
            WebElement firstResult = driver.findElement(By.cssSelector("h3"));
            System.out.println("First result title: " + firstResult.getText());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
