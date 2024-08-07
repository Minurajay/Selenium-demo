package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTraining {

    WebDriver driver;

    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        SearchTraining searchTraining = new SearchTraining();
        searchTraining.driver = new ChromeDriver();
        searchTraining.driver.get("https://www.simplilearn.com/");
        searchTraining.driver.manage().window().maximize();
        
        // Perform the search
        searchTraining.search();

        // Optional sleep to let the user actually see the result
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        searchTraining.driver.quit();
    }

    public void search() {
        // Wait for the search box to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header_srch")));

        // Enter "Selenium" in the search box and submit
        searchBox.sendKeys("Selenium");
        searchBox.submit();
    }
}
