import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ContactNegativeTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the Contact.html page
        driver.get("http://localhost:8000/contact");

        // Maximize window
        driver.manage().window().maximize();

        // Negative Test: Submit form with missing mandatory fields
        try {
            driver.findElement(By.name("name")).sendKeys(""); // Missing name
            driver.findElement(By.name("email")).sendKeys(""); // Missing email
            driver.findElement(By.name("body")).sendKeys("This is a test message.");
            driver.findElement(By.tagName("button")).click();

            String errorMessage = driver.findElement(By.id("error-message")).getText();
            System.out.println("Negative Test - Missing fields error: " + errorMessage.contains("Fields cannot be empty"));
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Missing fields error handling: Failed");
        }

        // Negative Test: Submit form with invalid email
        try {
            driver.findElement(By.name("name")).sendKeys("John Doe");
            driver.findElement(By.name("email")).sendKeys("invalid-email");
            driver.findElement(By.name("body")).sendKeys("This is a test message.");
            driver.findElement(By.tagName("button")).click();

            String errorMessage = driver.findElement(By.id("error-message")).getText();
            System.out.println("Negative Test - Invalid email error: " + errorMessage.contains("Invalid email"));
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Invalid email error handling: Failed");
        }

        driver.quit();
    }
}
