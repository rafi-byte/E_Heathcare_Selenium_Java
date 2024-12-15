import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UpdateEditNegativeTest2 {
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

        // Negative Test: Submit the form with invalid data
        try {
            driver.findElement(By.name("title")).sendKeys("!"); // Invalid title
            driver.findElement(By.name("body")).sendKeys("<script>alert('XSS');</script>"); // Potentially malicious input
            driver.findElement(By.tagName("button")).click();

            String errorMessage = driver.findElement(By.id("error-message")).getText();
            System.out.println("Negative Test - Invalid data error: " + errorMessage.contains("Invalid input"));
        } catch (NoSuchElementException e) {
            System.out.println("Negative Test - Invalid data error handling: Failed");
        }

        driver.quit();
    }
}
