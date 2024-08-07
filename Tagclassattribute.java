package com.sample;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Tagclassattribute {
	    public static void main(String[] args) {
	        // Set the path to the chromedriver executable
	        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

	        // Create a new instance of the Chrome driver
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Navigate to Stack Overflow homepage
	        driver.get("https://stackoverflow.com");

	        // Use a CSS selector with tag, class, and attribute to find the search input box
	        WebElement searchBox = driver.findElement(By.cssSelector("input.s-input__search[name='q']"));

	        // Perform actions on the located element
	        // For example, entering text into the search box
	        searchBox.sendKeys("selenium");
	        searchBox.sendKeys(Keys.ENTER);

	        // Close the browser
//	        driver.quit();
	    }
	}
