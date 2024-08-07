package com.sample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassLocator{
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to Google homepage
        driver.get("https://www.google.com");

        // Use a class locator to find the search bar by its class name
        WebElement searchBar = driver.findElement(By.className("gLFyf"));

        // Perform actions on the located element
        // For example, entering text into the search bar
        searchBar.sendKeys("Selenium WebDriver");

        // Submit the search form
        searchBar.submit();

        // Close the browser
//        driver.quit();
    }
}
