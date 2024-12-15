import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckDiseasePositiveTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Open the Patient/checkdisease.html page
        driver.get("http://localhost:8000/checkdisease");

        // Maximize window
        driver.manage().window().maximize();

        // Positive Test: Select symptoms and predict disease
        driver.findElement(By.id("searchbar")).sendKeys("Headache");
        driver.findElement(By.xpath("//a[contains(text(),'Headache')]")).click();
        driver.findElement(By.id("predict")).click();

        // Verify prediction result
        WebElement result = driver.findElement(By.id("diseasefield"));
        System.out.println("Positive Test - Predicted Disease: " + result.getText());

        driver.quit();
    }
}
