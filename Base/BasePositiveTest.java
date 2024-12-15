import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePositiveTest {
    public static void main(String[] args) {
        // Setting up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Default");
        WebDriver driver = new ChromeDriver(options);

        // Open the Base.html page
        driver.get("http://localhost:8000/base");

        // Maximize window
        driver.manage().window().maximize();

        // Positive Test: Verify the title of the page
        String expectedTitle = "BONDHU";
        String actualTitle = driver.getTitle();
        System.out.println("Positive Test - Page Title: " + actualTitle.equals(expectedTitle));

        // Positive Test: Verify navbar is displayed
        WebElement navbar = driver.findElement(By.className("navbar"));
        boolean isNavbarDisplayed = navbar.isDisplayed();
        System.out.println("Positive Test - Navbar is displayed: " + isNavbarDisplayed);

        // Positive Test: Check navigation links functionality
        driver.findElement(By.linkText("Home")).click();
        System.out.println("Positive Test - Navigated to Home Page: " + driver.getCurrentUrl().contains("home"));

        driver.quit();
    }
}
