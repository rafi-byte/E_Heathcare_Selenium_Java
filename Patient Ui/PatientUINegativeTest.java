import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PatientUINegativeTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the Patient/patient_ui.html page
        driver.get("http://localhost:8000/patient_ui");

        // Maximize window
        driver.manage().window().maximize();

        // Negative Test: Attempt to access a non-existent section
        try {
            driver.findElement(By.linkText("NonExistentSection")).click();
            System.out.println("Negative Test - Non-existent section link clicked: Failed");
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Non-existent section link clicked: Passed");
        }

        // Negative Test: Attempt to update profile with invalid data
        try {
            driver.findElement(By.linkText("Edit Profile")).click();
            driver.findElement(By.name("email")).sendKeys("invalid-email");
            driver.findElement(By.tagName("button")).click();
            String errorMessage = driver.findElement(By.id("error-message")).getText();
            System.out.println("Negative Test - Invalid email error: " + errorMessage.contains("Invalid email"));
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Invalid email error handling: Failed");
        }

        driver.quit();
    }
}
