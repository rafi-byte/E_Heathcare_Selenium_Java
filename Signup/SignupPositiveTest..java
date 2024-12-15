import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SignupPositiveTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Open the Signup_form/signup.html page
        driver.get("http://localhost:8000/signup_patient");

        // Maximize window
        driver.manage().window().maximize();

        // Positive Test: Register with valid inputs
        driver.findElement(By.name("username")).sendKeys("newuser");
        driver.findElement(By.name("name")).sendKeys("New User");
        driver.findElement(By.name("email")).sendKeys("newuser@example.com");
        driver.findElement(By.name("password")).sendKeys("StrongPassword123");
        driver.findElement(By.name("password1")).sendKeys("StrongPassword123");
        driver.findElement(By.tagName("button")).click();

        // Verify successful registration
        WebElement successMessage = driver.findElement(By.id("success-message"));
        System.out.println("Positive Test - Registration success: " + successMessage.getText().contains("Registration successful"));

        driver.quit();
    }
}
