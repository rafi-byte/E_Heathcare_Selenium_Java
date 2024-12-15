import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasicNegativeTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the Basic.html page
        driver.get("http://localhost:8000/basic");

        // Maximize window
        driver.manage().window().maximize();

        // Negative Test: Try to click a non-existing link
        try {
            driver.findElement(By.linkText("NonExistingLink")).click();
            System.out.println("Negative Test - Non-existing link clicked: Failed");
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Non-existing link clicked: Passed");
        }

        // Negative Test: Invalid navigation
        try {
            driver.get("http://localhost:8000/invalid-page");
            String errorTitle = driver.getTitle();
            System.out.println("Negative Test - Navigated to invalid page: " + errorTitle.contains("404"));
        } catch (Exception e) {
            System.out.println("Negative Test - Invalid page navigation handled: Passed");
        }

        driver.quit();
    }
}
