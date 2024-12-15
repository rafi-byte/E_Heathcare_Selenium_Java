import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConsultDoctorNegativeTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Open the Patient/consult_a_doctor.html page
        driver.get("http://localhost:8000/consult_a_doctor");

        // Maximize window
        driver.manage().window().maximize();

        // Negative Test: Attempt consultation without selecting a doctor
        try {
            driver.findElement(By.id("schedule")).click();
            String errorMessage = driver.findElement(By.id("error-message")).getText();
            System.out.println("Negative Test - No doctor selected error: " + errorMessage.contains("Please select a doctor"));
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - No doctor selected error handling: Failed");
        }

        driver.quit();
    }
}
