import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseNegativeTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the Base.html page
        driver.get("http://localhost:8000/base");

        // Maximize window
        driver.manage().window().maximize();

        // Negative Test: Try to access an invalid link
        try {
            driver.findElement(By.linkText("InvalidLink")).click();
            System.out.println("Negative Test - Invalid link clicked: Failed");
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Invalid link clicked: Passed");
        }

        // Negative Test: Check for a missing element
        try {
            driver.findElement(By.id("nonexistentElement"));
            System.out.println("Negative Test - Non-existent element found: Failed");
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Non-existent element found: Passed");
        }

        driver.quit();
    }
}
