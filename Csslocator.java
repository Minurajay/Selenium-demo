package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Csslocator {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to Stack Overflow homepage
        driver.get("https://stackoverflow.com");

        // Use a CSS selector with tag and class to find the search input box
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));

        // Perform actions on the located element
        // For example, entering text into the search box
        searchBox.sendKeys("selenium");
        searchBox.sendKeys(Keys.ENTER);

        // Use a CSS selector with tag and class to find the "Ask Question" button
        WebElement askQuestionButton = driver.findElement(By.cssSelector("a.ws-nowrap"));

        // Perform an action on the located element
        // For example, clicking the "Ask Question" button
        askQuestionButton.click();

        // Close the browser
//        driver.quit();
    }
}
