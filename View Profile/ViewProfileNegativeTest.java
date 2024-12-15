import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ViewProfileNegativeTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the Patient/view_profile.html page
        driver.get("http://localhost:8000/view_profile");

        // Maximize window
        driver.manage().window().maximize();

        // Negative Test: Attempt to access a non-existent profile element
        try {
            WebElement nonExistentField = driver.findElement(By.id("nonexistent-field"));
            System.out.println("Negative Test - Non-existent field found: Failed");
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Non-existent field found: Passed");
        }

        // Negative Test: Attempt to edit profile without permissions
        try {
            driver.findElement(By.id("edit-profile-button")).click();
            String errorMessage = driver.findElement(By.id("error-message")).getText();
            System.out.println("Negative Test - Unauthorized edit error: " + errorMessage.contains("Permission denied"));
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Unauthorized edit error handling: Failed");
        }

        driver.quit();
    }
}
