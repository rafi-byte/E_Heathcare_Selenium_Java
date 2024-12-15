import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckDiseaseNegativeTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the Patient/checkdisease.html page
        driver.get("http://localhost:8000/checkdisease");

        // Maximize window
        driver.manage().window().maximize();

        // Negative Test: Predict disease without selecting symptoms
        try {
            driver.findElement(By.id("predict")).click();
            String errorMessage = driver.findElement(By.id("error-message")).getText();
            System.out.println("Negative Test - No symptoms error: " + errorMessage.contains("Please select at least one symptom"));
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - No symptoms error handling: Failed");
        }

        // Negative Test: Input invalid symptom and attempt prediction
        try {
            driver.findElement(By.id("searchbar")).sendKeys("InvalidSymptom");
            driver.findElement(By.id("predict")).click();
            String errorMessage = driver.findElement(By.id("error-message")).getText();
            System.out.println("Negative Test - Invalid symptom error: " + errorMessage.contains("Invalid symptom"));
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Invalid symptom error handling: Failed");
        }

        driver.quit();
    }
}
