import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppointmentPositiveTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the appointment.html page
        driver.get("http://localhost:8000/appointment");

        // Maximize window
        driver.manage().window().maximize();

        // Positive Test: Verify appointment form fields are displayed
        WebElement nameField = driver.findElement(By.name("name"));
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement phoneField = driver.findElement(By.name("phonenumber"));
        WebElement dateField = driver.findElement(By.name("date_added"));
        WebElement doctorField = driver.findElement(By.name("doc_name"));
        boolean isFormDisplayed = nameField.isDisplayed() && emailField.isDisplayed() && phoneField.isDisplayed()
                && dateField.isDisplayed() && doctorField.isDisplayed();
        System.out.println("Positive Test - Appointment form displayed: " + isFormDisplayed);

        // Positive Test: Submit appointment form with valid data
        nameField.sendKeys("Rafi");
        emailField.sendKeys("rafi@example.com");
        phoneField.sendKeys("1234567890");
        dateField.sendKeys("2024-12-20");
        doctorField.sendKeys("Dr. Zabir");
        driver.findElement(By.tagName("button")).click();

        // Verify success message
        WebElement successMessage = driver.findElement(By.id("success-message"));
        System.out.println("Positive Test - Appointment submission success: " + successMessage.getText().contains("Appointment booked successfully"));

        driver.quit();
    }
}
