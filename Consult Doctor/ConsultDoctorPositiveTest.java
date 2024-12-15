import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConsultDoctorPositiveTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the Patient/consult_a_doctor.html page
        driver.get("http://localhost:8000/consult_a_doctor");

        // Maximize window
        driver.manage().window().maximize();

        // Positive Test: Select a doctor and schedule consultation
        driver.findElement(By.xpath("//button[text()='Consult']")).click();

        // Verify successful scheduling message
        WebElement successMessage = driver.findElement(By.id("success-message"));
        System.out.println("Positive Test - Consultation scheduling success: " + successMessage.getText().contains("Consultation scheduled successfully"));

        driver.quit();
    }
}
