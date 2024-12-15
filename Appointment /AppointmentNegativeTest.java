import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppointmentNegativeTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Open the Appointment.html page
        driver.get("http://localhost:8000/appointment");

        // Maximize window
        driver.manage().window().maximize();

        // Negative Test: Submit form with missing mandatory fields
        try {
            driver.findElement(By.name("name")).sendKeys(""); // Missing name
            driver.findElement(By.name("email")).sendKeys(""); // Missing email
            driver.findElement(By.name("phonenumber")).sendKeys("1234567890");
            driver.findElement(By.name("date_added")).sendKeys("2024-12-20");
            driver.findElement(By.name("doc_name")).sendKeys("Dr. Smith");
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
            driver.findElement(By.name("phonenumber")).sendKeys("1234567890");
            driver.findElement(By.name("date_added")).sendKeys("2024-12-20");
            driver.findElement(By.name("doc_name")).sendKeys("Dr. Smith");
            driver.findElement(By.tagName("button")).click();

            String errorMessage = driver.findElement(By.id("error-message")).getText();
            System.out.println("Negative Test - Invalid email error: " + errorMessage.contains("Invalid email"));
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Invalid email error handling: Failed");
        }

        driver.quit();
    }
}
