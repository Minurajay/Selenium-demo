package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YouTubeSearchTest {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable if it's not in your system PATH
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Open YouTube
            driver.get("https://www.youtube.com");
            driver.manage().window().maximize();

            // Wait for the search box to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search_query")));

            // Find the search box
            WebElement searchBox = driver.findElement(By.name("search_query"));

            // Type the search query
            searchBox.sendKeys("Sri Lanka cricket");

            // Submit the search form
            searchBox.submit();

            // Wait for the search results to load
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("video-title")));

            // Click on the first video in the search results
            WebElement firstVideo = driver.findElement(By.id("video-title"));
            firstVideo.click();

            // Wait for a few seconds to allow the video to start playing
            Thread.sleep(5000);  // Adjust the sleep duration as needed

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
           // driver.quit();
        }
    }
}
