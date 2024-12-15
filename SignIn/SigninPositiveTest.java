import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SigninPositiveTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the signin_page/index.html page
        driver.get("http://localhost:8000/login");

        // Maximize window
        driver.manage().window().maximize();

        // Positive Test: Login with valid credentials
        driver.findElement(By.name("username")).sendKeys("validuser");
        driver.findElement(By.name("password")).sendKeys("validpassword");
        driver.findElement(By.className("login100-form-btn")).click();

        // Verify successful login
        String dashboardUrl = driver.getCurrentUrl();
        System.out.println("Positive Test - Successful login: " + dashboardUrl.contains("dashboard"));

        driver.quit();
    }
}
