import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasicPositiveTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the Basic.html page
        driver.get("http://localhost:8000/basic");

        // Maximize window
        driver.manage().window().maximize();

        // Positive Test: Verify homepage loads with correct title
        String expectedTitle = "BONDHU";
        String actualTitle = driver.getTitle();
        System.out.println("Positive Test - Page Title: " + actualTitle.equals(expectedTitle));

        // Positive Test: Navbar links navigation
        driver.findElement(By.linkText("Home")).click();
        System.out.println("Positive Test - Navigated to Home Page: " + driver.getCurrentUrl().contains("home"));

        driver.quit();
    }
}
