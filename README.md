# Selenium Automation Test Suite for Healthcare Application

## Overview
This project contains a comprehensive Selenium-based test suite to automate the functional testing of a healthcare web application. Each module and feature of the application is tested with both positive and negative test cases, ensuring robust validation of the system.

## Structure
The test cases are divided into multiple Java files, categorized by application modules and functionalities. Below is a list of the sections covered:

### 1. Base Template Files
- `base.html`
- `basic.html`

### 2. Feature-Specific Templates
#### Authentication
- `signin_page/index.html`
- `signup_form/signup.html`
#### Patient Features
- `checkdisease.html`
- `consult_a_doctor.html`
- `consultation_history.html`
- `patient_ui.html`
- `view_profile.html`

### 3. General Pages
- `appointment.html`
- `contact.html`

## Test Scenarios
Each module is tested with detailed **positive** and **negative** test cases, covering edge cases, valid inputs, and invalid inputs.

### Example Scenarios:
#### Positive Test Cases
- Verify form fields are visible and functional.
- Validate successful form submissions with valid inputs.
- Ensure proper navigation and display of UI components.

#### Negative Test Cases
- Test form submission with missing or invalid data.
- Validate error messages for invalid actions.
- Attempt unauthorized actions and verify proper error handling.

## Pre-requisites
To run the test suite, ensure the following:
1. **Java Development Kit (JDK)**: Version 8 or higher.
2. **Maven**: For dependency management.
3. **ChromeDriver**: Ensure compatibility with your Chrome browser version.
4. **Selenium WebDriver**: Latest version.
5. **Healthcare Application**: Running locally or on a test server.

## Setup
1. Clone the repository.
2. Install dependencies using Maven:
   ```bash
   mvn clean install
   ```
3. Configure the `ChromeDriver` path in the Java files if required.
4. Update the `baseUrl` in test files to point to your local or test environment.

## Execution
Run test cases using your preferred IDE (e.g., IntelliJ IDEA, Eclipse) or from the command line:
```bash
mvn test
```

## Test File Description
Each Java file corresponds to a specific feature or module of the healthcare application.

### Example Test Files:
1. **`SigninPositiveTest.java`**: Tests successful login functionality.
2. **`AppointmentNegativeTest.java`**: Tests invalid appointment submissions.
3. **`ConsultDoctorPositiveTest.java`**: Validates consultation scheduling workflow.

### Logs and Reports:
- Test outputs, including success messages or error validations, are logged to the console.
- For better reporting, integrate with **ExtentReports** or similar tools.

## Contribution
Feel free to contribute by:
1. Adding more test cases.
2. Improving error handling and assertions.
3. Updating the documentation.

## Contact
For any issues or inquiries, please reach out to [rafiabdps@gmail.com].



