import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SigninNegativeTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the Signin_page/index.html page
        driver.get("http://localhost:8000/login");

        // Maximize window
        driver.manage().window().maximize();

        // Negative Test: Login with invalid credentials
        try {
            driver.findElement(By.name("username")).sendKeys("invaliduser");
            driver.findElement(By.name("password")).sendKeys("wrongpassword");
            driver.findElement(By.className("login100-form-btn")).click();

            String errorMessage = driver.findElement(By.id("error-message")).getText();
            System.out.println("Negative Test - Invalid credentials error: " + errorMessage.contains("Invalid username or password"));
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Invalid credentials error handling: Failed");
        }

        // Negative Test: Login with empty fields
        try {
            driver.findElement(By.name("username")).sendKeys(""); // Empty username
            driver.findElement(By.name("password")).sendKeys(""); // Empty password
            driver.findElement(By.className("login100-form-btn")).click();

            String errorMessage = driver.findElement(By.id("error-message")).getText();
            System.out.println("Negative Test - Empty fields error: " + errorMessage.contains("Fields cannot be empty"));
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Empty fields error handling: Failed");
        }

        driver.quit();
    }
}
