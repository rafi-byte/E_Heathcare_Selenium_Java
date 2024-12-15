# Selenium Test Automation for Healthcare Application

## Overview
This project automates the functional testing of a healthcare application using **Selenium WebDriver** with **Java**. It ensures critical workflows such as authentication, disease prediction, profile management, and appointment booking function reliably across browsers.

---

## Table of Contents
1. [Test Objectives](#test-objectives)
2. [Test Environment](#test-environment)
3. [Dependencies](#dependencies)
4. [Test Scenarios](#test-scenarios)
5. [Test Cases](#test-cases)
6. [Execution Strategy](#execution-strategy)
7. [Reporting](#reporting)
8. [Browser Compatibility](#browser-compatibility)
9. [Maintenance](#maintenance)

---

## Test Objectives
The main goals of this test automation are:
- Verify user interactions such as **sign-up**, **login**, and **logout**.
- Validate core features: **disease prediction**, **consultation booking**, and **profile management**.
- Ensure proper error handling, form validation, and AJAX responses.
- Run tests across multiple browsers for compatibility.

---

## Test Environment

### Tools & Frameworks:
- **Selenium WebDriver**: Browser automation.
- **TestNG**: Test management and assertions.
- **Maven**: Dependency management.
- **ExtentReports**: HTML reporting.
- **Browser Drivers**: ChromeDriver, GeckoDriver, EdgeDriver.

### Supported Environments:
- **Browsers**: Chrome (v110+), Firefox (v100+), Edge (latest).
- **Operating Systems**: Windows 10, macOS.
- **Data**: Dummy test data for users, appointments, and consultations.

---

## Dependencies
Add the following dependencies to your `pom.xml`:

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

## Test Scenarios

### 1. **Authentication Module**
- **Sign-Up**: Validate mandatory fields, password strength, and duplicate user errors.
- **Login**: Test valid/invalid credentials and error messages.
- **Logout**: Verify redirection post-logout.

### 2. **Patient Features**
- **Check Disease**: Add symptoms, trigger predictions, and verify results.
- **Consult a Doctor**: Validate doctor list loading, navigation, and booking consultation.
- **Consultation History**: Check correct display of past records.

### 3. **Profile Management**
- **View Profile**: Ensure correct data display.
- **Edit Profile**: Validate field-level updates and error handling.

### 4. **General Features**
- **Appointment**: Validate mandatory fields for booking.
- **Contact Form**: Ensure form submission and email validation.

---

## Test Cases

### Example 1: Login with Valid Credentials
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
        driver.findElement(By.name("username")).sendKeys("testuser");
        driver.findElement(By.name("password")).sendKeys("testpassword");
        driver.findElement(By.className("login100-form-btn")).click();
        Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
```

### Example 2: Add Symptoms and Check Disease
```java
@Test
public void testCheckDisease() {
    driver.findElement(By.name("username")).sendKeys("patientUser");
    driver.findElement(By.name("password")).sendKeys("password123");
    driver.findElement(By.className("login100-form-btn")).click();
    
    driver.findElement(By.linkText("Check Disease")).click();
    driver.findElement(By.id("searchbar")).sendKeys("Headache");
    driver.findElement(By.xpath("//a[contains(text(),'Headache')]")).click();
    driver.findElement(By.id("predict")).click();
    
    String result = driver.findElement(By.id("diseasefield")).getText();
    Assert.assertNotNull(result, "Prediction result not displayed");
}
```

---

## Execution Strategy

### Daily Smoke Tests
- Validate critical workflows such as **login** and **navigation**.

### Weekly Regression Tests
- Execute all test cases to ensure no new defects are introduced.

### Test Execution Command
Run the test suite using Maven:
```bash
mvn clean test
```

---

## Reporting
Test execution reports are generated using **ExtentReports**.

Example Usage:
```java
ExtentReports extent = new ExtentReports();
ExtentTest test = extent.createTest("Login Test");
test.log(Status.PASS, "Login successful");
extent.flush();
```
Reports will be saved in the `test-output` directory.

---

## Browser Compatibility
- **Browsers**: Chrome, Firefox, Edge.
- For parallel execution, configure **Selenium Grid**.

---

## Maintenance
- Update test scripts as new features are added.
- Regularly verify compatibility with the latest browser versions.
- Refactor test scripts for better modularity and reusability.

---

## Contribution
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch.
3. Submit a pull request with a detailed description of changes.

---

## License
This project is licensed under the **MIT License**.

---

## Contact
For queries or support, reach out at **support@healthapp.com**.
