import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UpdateEditPositiveTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the UpdateEdit.html page
        driver.get("http://localhost:8000/update_edit");

        // Maximize window
        driver.manage().window().maximize();

        // Positive Test: Verify the form fields are accessible
        WebElement titleField = driver.findElement(By.name("title"));
        WebElement bodyField = driver.findElement(By.name("body"));
        boolean isTitleFieldDisplayed = titleField.isDisplayed();
        boolean isBodyFieldDisplayed = bodyField.isDisplayed();
        System.out.println("Positive Test - Title field displayed: " + isTitleFieldDisplayed);
        System.out.println("Positive Test - Body field displayed: " + isBodyFieldDisplayed);

        // Positive Test: Submit the form with valid data
        titleField.sendKeys("Test Post Title");
        bodyField.sendKeys("This is a test body for the post.");
        driver.findElement(By.tagName("button")).click();

        // Verify success message
        WebElement successMessage = driver.findElement(By.id("success-message"));
        System.out.println("Positive Test - Form submission success: " + successMessage.getText().contains("Post updated successfully"));

        driver.quit();
    }
}
