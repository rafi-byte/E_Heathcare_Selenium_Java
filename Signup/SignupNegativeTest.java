import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SignupNegativeTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the Signup_form/signup.html page
        driver.get("http://localhost:8000/signup_patient");

        // Maximize window
        driver.manage().window().maximize();

        // Negative Test: Register with mismatched passwords
        try {
            driver.findElement(By.name("username")).sendKeys("newuser");
            driver.findElement(By.name("name")).sendKeys("New User");
            driver.findElement(By.name("email")).sendKeys("newuser@example.com");
            driver.findElement(By.name("password")).sendKeys("StrongPassword123");
            driver.findElement(By.name("password1")).sendKeys("WrongPassword123");
            driver.findElement(By.tagName("button")).click();

            String errorMessage = driver.findElement(By.id("error-message")).getText();
            System.out.println("Negative Test - Mismatched passwords error: " + errorMessage.contains("Passwords do not match"));
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Mismatched passwords error handling: Failed");
        }

        // Negative Test: Register with missing mandatory fields
        try {
            driver.findElement(By.name("username")).sendKeys(""); // Missing username
            driver.findElement(By.name("name")).sendKeys("New User");
            driver.findElement(By.name("email")).sendKeys("newuser@example.com");
            driver.findElement(By.name("password")).sendKeys("StrongPassword123");
            driver.findElement(By.name("password1")).sendKeys("StrongPassword123");
            driver.findElement(By.tagName("button")).click();

            String errorMessage = driver.findElement(By.id("error-message")).getText();
            System.out.println("Negative Test - Missing fields error: " + errorMessage.contains("Fields cannot be empty"));
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Missing fields error handling: Failed");
        }

        driver.quit();
    }
}
