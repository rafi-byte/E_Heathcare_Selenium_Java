import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ContactPositiveTest {
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

        // Positive Test: Verify contact form fields are displayed
        WebElement nameField = driver.findElement(By.name("name"));
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement messageField = driver.findElement(By.name("body"));
        boolean isFormDisplayed = nameField.isDisplayed() && emailField.isDisplayed() && messageField.isDisplayed();
        System.out.println("Positive Test - Contact form displayed: " + isFormDisplayed);

        // Positive Test: Submit contact form with valid data
        nameField.sendKeys("Rafi Zabir");
        emailField.sendKeys("rafi.test@example.com");
        messageField.sendKeys("This is a test message.");
        driver.findElement(By.tagName("button")).click();

        // Verify success message
        WebElement successMessage = driver.findElement(By.id("success-message"));
        System.out.println("Positive Test - Contact form submission success: " + successMessage.getText().contains("Message sent successfully"));

        driver.quit();
    }
}
