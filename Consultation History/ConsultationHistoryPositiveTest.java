import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConsultationHistoryPositiveTest {
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

        // Positive Test: Verify consultation history is displayed
        WebElement consultationTable = driver.findElement(By.id("consultation-table"));
        boolean isTableDisplayed = consultationTable.isDisplayed();
        System.out.println("Positive Test - Consultation history table displayed: " + isTableDisplayed);

        // Positive Test: Verify navigation to view prescription
        driver.findElement(By.linkText("View Prescription")).click();
        System.out.println("Positive Test - Navigated to prescription page: " + driver.getCurrentUrl().contains("prescription"));

        driver.quit();
    }
}
