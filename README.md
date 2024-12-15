# Heathcare_App_Testing_with-Selenium_Java
Test Automation Project with Selenium in Java Test Plan

Here's a **detailed and extensive Selenium-based test plan for your healthcare application using Java**:

---

## Test Plan: Selenium Automation for Healthcare Application

### 1. **Test Objectives**
Automate the end-to-end functional testing of the healthcare application, ensuring the following:
- User interactions (sign-up, login, navigation) are functioning as expected.
- Core features (disease check, consultation, profile management) are tested across multiple browsers.
- Validation of form inputs, AJAX responses, and proper error handling.

---

### 2. **Test Environment**
#### Tools and Frameworks:
1. **Selenium WebDriver**: For browser automation.
2. **TestNG**: For test case management and assertions.
3. **Maven**: For dependency management.
4. **ExtentReports**: For generating HTML reports.
5. **Browser Drivers**: ChromeDriver, GeckoDriver (Firefox), EdgeDriver.

#### Test Environment:
1. **Browsers**: Chrome (v110+), Firefox (v100+), Edge.
2. **Operating Systems**: Windows 10, macOS.
3. **Data**: Dummy test data for users, appointments, and consultation.

#### Dependencies (Maven `pom.xml`):
```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.14.0</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>extentreports</artifactId>
        <version>5.0.9</version>
    </dependency>
</dependencies>
```

---

### 3. **Test Scenarios and Cases**
#### A. Authentication Module
1. **Sign-Up as Patient**
   - Verify mandatory fields (`username`, `email`, `password`).
   - Check password strength validation.
   - Ensure successful redirection after registration.
   - Test duplicate user error messages.
   
2. **Login**
   - Validate with valid and invalid credentials.
   - Test error message for incorrect credentials.
   - Ensure "Forgot Password" navigation works.

3. **Logout**
   - Verify logout redirects to the home page.

---

#### B. Patient Features
1. **Check Disease**
   - Add symptoms to the list and trigger disease prediction.
   - Verify AJAX response displays the correct predicted disease.
   - Validate proper error handling when no symptoms are selected.

2. **Consult a Doctor**
   - Verify the doctor list is loaded with correct details.
   - Check navigation to doctor's profile.
   - Test consultation booking and error scenarios.

3. **Consultation History**
   - Ensure consultation records display correct data.
   - Validate "Resume Consultation" and "View Prescription" links.

---

#### C. Profile Management
1. **View Profile**
   - Verify data is loaded correctly (name, email, age, etc.).
   - Test error handling for unauthorized access.

2. **Edit Profile**
   - Validate form updates (e.g., changing the phone number).
   - Check validations for each field.

---

#### D. General Features
1. **Appointment**
   - Verify mandatory fields for booking an appointment.
   - Test navigation to appointment history.

2. **Contact**
   - Validate submission of contact forms.
   - Test email validation.

---

### 4. **Test Case Examples**

#### 4.1 Test Case: Login with Valid Credentials
```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8000/login");
    }

    @Test
    public void testLoginWithValidCredentials() {
        // Enter username
        driver.findElement(By.name("username")).sendKeys("testuser");
        // Enter password
        driver.findElement(By.name("password")).sendKeys("testpassword");
        // Click login
        driver.findElement(By.className("login100-form-btn")).click();
        // Assert successful login
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Dashboard"), "Login failed: Expected Dashboard page");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
```

---

#### 4.2 Test Case: Add Symptoms and Check Disease
```java
@Test
public void testCheckDisease() {
    // Login as a patient
    driver.findElement(By.name("username")).sendKeys("patientUser");
    driver.findElement(By.name("password")).sendKeys("password123");
    driver.findElement(By.className("login100-form-btn")).click();
    
    // Navigate to Check Disease
    driver.findElement(By.linkText("Check Disease")).click();

    // Add symptoms
    driver.findElement(By.id("searchbar")).sendKeys("Headache");
    driver.findElement(By.xpath("//a[contains(text(),'Headache')]")).click();

    // Predict disease
    driver.findElement(By.id("predict")).click();

    // Assert prediction results
    WebElement result = driver.findElement(By.id("diseasefield"));
    Assert.assertNotNull(result.getText(), "No disease prediction result displayed.");
}
```

---

### 5. **Test Data**
#### User Data:
- Valid Credentials: `{ username: "testuser", password: "testpassword" }`
- Invalid Credentials: `{ username: "wronguser", password: "wrongpassword" }`

#### Disease Data:
- Symptoms: `{ "Headache", "Fever", "Cough" }`

---

### 6. **Test Execution**
#### Test Execution Strategy:
- **Daily Smoke Test**: Validate critical paths like login and navigation.
- **Weekly Regression Test**: Cover all test scenarios.

#### Execution Commands:
- Run tests using TestNG:
```bash
mvn clean test
```

#### Reporting:
- Use **ExtentReports** for HTML test reports.
- Example:
```java
ExtentReports extent = new ExtentReports();
ExtentTest test = extent.createTest("Login Test");

// Log test steps
test.log(Status.PASS, "Login successful");
extent.flush();
```

---

### 7. **Browser Compatibility**
- Chrome, Firefox, Edge.
- Use Selenium Grid for parallel execution.

---

### 8. **Maintenance**
- Regularly update test scripts as new features are added.
- Ensure compatibility with newer browser versions.

Let me know if you'd like implementation assistance or further refinements!
