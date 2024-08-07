package com.sample;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {

	public static void main(String[] args) {
		  // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://stackoverflow.com/users/login");
        
        //By id 
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("minurapramodjayasiriwardena@gmail.com");
        
        //(should be by name)
       WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("Kumari1899");
        
//        ((WebElement) driver.findElements(By.className("flex--item s-btn s-btn__filled"))).click();
        
        //By tag name
//        List<WebElement> links = driver.findElements(By.tagName("a"));
//        
//        System.out.println("Total anchor tags" +links.size());
//        
//        for(WebElement link: links) {
//        	System.out.println(link.getText());
//        }
        
        //CSS selectors 
        
        //tag and ID
        driver.findElement(By.cssSelector("button#submit-button")).click();
        
        //Tag and attribute
        WebElement searchbox = driver.findElement(By.cssSelector("input[name='q']"));
        
        searchbox.sendKeys("selenium");
        searchbox.sendKeys(Keys.ENTER);
        
        //tag and class
        
        driver.findElement(By.cssSelector("svg.svg-icon.iconStackExchange")).click();
        
        //tag class and attribute
        
        driver.findElement(By.cssSelector("a.js-gps-track[href='https://stackoverflow.com/users/logout']")).click();
        
        //By link text locator
        driver.findElement(By.linkText("stackexchange.com")).click();
        
        //By partial link text
        driver.findElement(By.partialLinkText("Sites")).click();

	}

}
