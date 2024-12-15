import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConsultationHistoryNegativeTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the Patient/consultation_history.html page
        driver.get("http://localhost:8000/consultation_history");

        // Maximize window
        driver.manage().window().maximize();

        // Negative Test: Attempt to view history with no records
        try {
            WebElement noRecordsMessage = driver.findElement(By.id("no-records-message"));
            System.out.println("Negative Test - No records message displayed: " + noRecordsMessage.isDisplayed());
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - No records message handling: Failed");
        }

        // Negative Test: Click on a non-existent prescription link
        try {
            driver.findElement(By.linkText("NonExistentPrescription")).click();
            System.out.println("Negative Test - Non-existent prescription link clicked: Failed");
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Non-existent prescription link clicked: Passed");
        }

        driver.quit();
    }
}
