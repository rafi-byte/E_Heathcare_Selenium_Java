import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PatientUIPositiveTest {
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

        // Positive Test: Verify patient profile page is loaded
        WebElement profileHeader = driver.findElement(By.id("profile-header"));
        boolean isProfileHeaderDisplayed = profileHeader.isDisplayed();
        System.out.println("Positive Test - Profile header displayed: " + isProfileHeaderDisplayed);

        // Positive Test: Navigate to 'View Profile'
        driver.findElement(By.linkText("View Profile")).click();
        System.out.println("Positive Test - Navigated to profile view: " + driver.getCurrentUrl().contains("view_profile"));

        driver.quit();
    }
}
