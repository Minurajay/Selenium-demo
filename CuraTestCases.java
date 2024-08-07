package com.sample;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CuraTestCases {
    WebDriver driver;

    public void setUp() {
        // Set the path for the WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    public void testHomePageTitle() {
        String expectedTitle = "CURA Healthcare Service";
        String actualTitle = driver.getTitle();
        assert actualTitle.equals(expectedTitle) : "Home page title does not match";
    }

    public void testLogin() {
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        assert makeAppointmentButton.isDisplayed() : "Login failed or Make Appointment button not found";
    }

    public void testMakeAppointment() {
        testLogin();
        driver.findElement(By.id("combo_facility")).sendKeys("Hongkong CURA Healthcare Center");
        driver.findElement(By.id("chk_hospotal_readmission")).click();
        driver.findElement(By.id("radio_program_medicaid")).click();
        driver.findElement(By.id("txt_visit_date")).sendKeys("30/08/2024");
        driver.findElement(By.id("txt_comment")).sendKeys("This is a test appointment.");
        driver.findElement(By.id("btn-book-appointment")).click();
        
        WebElement confirmation = driver.findElement(By.className("text-center"));
        assert confirmation.getText().contains("Appointment Confirmation") : "Appointment not booked successfully";
    }

    public void testNavigationToHomePageFromAppointmentConfirmation() {
        testMakeAppointment();
        driver.findElement(By.linkText("Go to Homepage")).click();
        
        String expectedTitle = "CURA Healthcare Service";
        String actualTitle = driver.getTitle();
        assert actualTitle.equals(expectedTitle) : "Did not navigate back to home page correctly";
    }

    public void testContactUsPage() {
        driver.findElement(By.linkText("Contact")).click();
        
        String expectedTitle = "CURA Healthcare Service";
        String actualTitle = driver.getTitle();
        assert actualTitle.equals(expectedTitle) : "Contact Us page title does not match";
    }

    public void testNavigationMenu() {
        driver.findElement(By.id("menu-toggle")).click();
        
        WebElement homeLink = driver.findElement(By.linkText("Home"));
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        WebElement contactLink = driver.findElement(By.linkText("Contact"));
        
        assert homeLink.isDisplayed() : "Home link not displayed in navigation menu";
        assert loginLink.isDisplayed() : "Login link not displayed in navigation menu";
        assert contactLink.isDisplayed() : "Contact link not displayed in navigation menu";
    }

    public void testInvalidLogin() {
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("txt-username")).sendKeys("InvalidUser");
        driver.findElement(By.id("txt-password")).sendKeys("InvalidPassword");
        driver.findElement(By.id("btn-login")).click();
        
        WebElement errorMessage = driver.findElement(By.className("text-danger"));
        assert errorMessage.isDisplayed() : "Error message not displayed for invalid login";
    }

    public void testLogout() {
        testLogin();
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.linkText("Logout")).click();
        
        WebElement loginButton = driver.findElement(By.id("btn-login"));
        assert loginButton.isDisplayed() : "Logout failed or Login button not found";
    }

    public void testAppointmentHistoryAccess() {
        testLogin();
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.linkText("History")).click();
        
        WebElement historyTable = driver.findElement(By.id("history"));
        assert historyTable.isDisplayed() : "Appointment history not accessible";
    }

    public void testFooterLinks() {
        WebElement twitterLink = driver.findElement(By.xpath("//a[@href='https://twitter.com']"));
        WebElement facebookLink = driver.findElement(By.xpath("//a[@href='https://facebook.com']"));
        WebElement linkedinLink = driver.findElement(By.xpath("//a[@href='https://linkedin.com']"));
        
        assert twitterLink.isDisplayed() : "Twitter link not displayed in footer";
        assert facebookLink.isDisplayed() : "Facebook link not displayed in footer";
        assert linkedinLink.isDisplayed() : "LinkedIn link not displayed in footer";
    }

    public void tearDown() {
        driver.quit();
    }

    public static void main(String[] args) {
        CuraTestCases test = new CuraTestCases();
        test.setUp();
        
        try {
            test.testHomePageTitle();
            test.testLogin();
            test.testMakeAppointment();
            test.testNavigationToHomePageFromAppointmentConfirmation();
            test.testContactUsPage();
            test.testNavigationMenu();
            test.testInvalidLogin();
            test.testLogout();
            test.testAppointmentHistoryAccess();
            test.testFooterLinks();
        } finally {
            test.tearDown();
        }
    }
}
