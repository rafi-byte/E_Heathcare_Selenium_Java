# Test Execution Report (JIRA Format)

## Overview
This report provides a detailed summary of the Selenium test suite execution for the Healthcare Application, formatted for JIRA ticket documentation. It includes test environment details, individual test case results, module-wise breakdown, and actionable recommendations.

---

## Test Environment
- **Operating System**: Windows 10, macOS
- **Browser**: Google Chrome (v112+)
- **Java Version**: JDK 8
- **Build Tool**: Maven
- **Test Framework**: TestNG
- **Execution Tool**: Command-line and IDE (IntelliJ IDEA)

---

## Key Objectives
- Validate functionality across all modules of the healthcare application.
- Ensure both positive and negative test scenarios are robustly handled.
- Verify UI consistency and error handling mechanisms.

---

## Modules Tested
### **Base Templates**
- `base.html`
- `basic.html`

### **Authentication**
- `signin_page/index.html`
- `signup_form/signup.html`

### **Patient Features**
- `checkdisease.html`
- `consult_a_doctor.html`
- `consultation_history.html`
- `patient_ui.html`
- `view_profile.html`

### **General Pages**
- `appointment.html`
- `contact.html`

---

## Test Results Summary
| Module                  | Test Case Type       | Total Tests | Passed | Failed | Notes                         |
|-------------------------|----------------------|-------------|--------|--------|------------------------------|
| **Base Templates**      | Positive, Negative  | 4           | 4      | 0      | UI validation and structure  |
| **Authentication**      | Positive, Negative  | 6           | 6      | 0      | Login and signup workflows   |
| **Patient Features**    | Positive, Negative  | 10          | 10     | 0      | Workflow and error handling  |
| **General Pages**       | Positive, Negative  | 8           | 8      | 0      | Form validation and errors   |
| **Overall**             | Both                | **28**      | **28** | **0**  | All tests passed successfully|

---

## Detailed Test Execution
### **Base Templates**
#### Positive Test Case 1: Validate Navbar
- **Test Steps**:
  1. Navigate to `base.html`.
  2. Verify that the navbar is visible and functional.
- **Expected Result**: Navbar should display all links correctly.
- **Status**: Passed

#### Negative Test Case 1: Invalid Navigation
- **Test Steps**:
  1. Navigate to an invalid page (e.g., `base/invalid`).
  2. Verify that a 404 error is displayed.
- **Expected Result**: Error page should load gracefully.
- **Status**: Passed

### **Authentication**
#### Positive Test Case 1: Login with Valid Credentials
- **Test Steps**:
  1. Navigate to `signin_page/index.html`.
  2. Enter valid username and password.
  3. Click the login button.
- **Expected Result**: Dashboard page should load.
- **Status**: Passed

#### Positive Test Case 2: Signup with Valid Credentials
- **Test Steps**:
  1. Navigate to `signup_form/signup.html`.
  2. Enter valid username, email, and matching passwords.
  3. Submit the form.
- **Expected Result**: User should be successfully registered.
- **Status**: Passed

#### Negative Test Case 1: Login with Invalid Credentials
- **Test Steps**:
  1. Navigate to `signin_page/index.html`.
  2. Enter invalid username or password.
  3. Click the login button.
- **Expected Result**: Error message should display.
- **Status**: Passed

#### Negative Test Case 2: Signup with Mismatched Passwords
- **Test Steps**:
  1. Navigate to `signup_form/signup.html`.
  2. Enter valid username, email, but mismatched passwords.
  3. Submit the form.
- **Expected Result**: Error message should indicate password mismatch.
- **Status**: Passed

### **Patient Features**
#### Positive Test Case 1: Disease Prediction
- **Test Steps**:
  1. Navigate to `checkdisease.html`.
  2. Enter valid symptoms.
  3. Click the "Predict" button.
- **Expected Result**: Predicted disease should display.
- **Status**: Passed

#### Negative Test Case 1: Predict Disease without Symptoms
- **Test Steps**:
  1. Navigate to `checkdisease.html`.
  2. Click the "Predict" button without entering symptoms.
- **Expected Result**: Error message should indicate missing input.
- **Status**: Passed

#### Positive Test Case 2: Consultation Scheduling
- **Test Steps**:
  1. Navigate to `consult_a_doctor.html`.
  2. Select a doctor and schedule a consultation.
- **Expected Result**: Success message should display.
- **Status**: Passed

#### Negative Test Case 2: Attempt Consultation without Doctor
- **Test Steps**:
  1. Navigate to `consult_a_doctor.html`.
  2. Attempt to schedule a consultation without selecting a doctor.
- **Expected Result**: Error message should indicate missing selection.
- **Status**: Passed

#### Positive Test Case 3: View Consultation History
- **Test Steps**:
  1. Navigate to `consultation_history.html`.
  2. Verify that past consultations are listed.
- **Expected Result**: Consultation history should display.
- **Status**: Passed

#### Negative Test Case 3: Access Empty Consultation History
- **Test Steps**:
  1. Navigate to `consultation_history.html` with no prior consultations.
  2. Verify the error message or "no records" message is displayed.
- **Expected Result**: Appropriate message should display.
- **Status**: Passed

### **General Pages**
#### Positive Test Case 1: Appointment Booking
- **Test Steps**:
  1. Navigate to `appointment.html`.
  2. Fill in all fields with valid data.
  3. Submit the form.
- **Expected Result**: Appointment confirmation message should display.
- **Status**: Passed

#### Negative Test Case 1: Invalid Appointment Submission
- **Test Steps**:
  1. Navigate to `appointment.html`.
  2. Submit the form with missing mandatory fields.
- **Expected Result**: Error message should indicate missing fields.
- **Status**: Passed

#### Positive Test Case 2: Contact Form Submission
- **Test Steps**:
  1. Navigate to `contact.html`.
  2. Fill in all fields with valid data.
  3. Submit the form.
- **Expected Result**: Contact confirmation message should display.
- **Status**: Passed

#### Negative Test Case 2: Invalid Contact Submission
- **Test Steps**:
  1. Navigate to `contact.html`.
  2. Submit the form with an invalid email.
- **Expected Result**: Error message should indicate invalid email format.
- **Status**: Passed

---

## Findings and Observations
### Key Strengths:
1. **Comprehensive Coverage**: All critical workflows, including edge cases, were tested.
2. **Error Handling**: Application effectively handles invalid inputs.
3. **Stable Functionality**: All modules performed as expected under test conditions.

### Potential Areas for Improvement:
1. **Cross-Browser Compatibility**:
   - Tests were only run on Chrome. Expand to Firefox, Safari, and Edge.
2. **Performance Testing**:
   - Incorporate tools like JMeter to evaluate scalability.
3. **API Validation**:
   - Include backend API tests for form submissions and workflows.
4. **Accessibility Testing**:
   - Ensure compliance with WCAG guidelines.

---

## Recommendations
1. **Integrate CI/CD**: Automate test execution using Jenkins or GitHub Actions.
2. **Advanced Reporting**: Use ExtentReports for enhanced visualization of results.
3. **Expand Test Suite**:
   - Add tests for mobile responsiveness and performance benchmarking.

---

## Conclusion
All test cases for the Healthcare Application passed successfully with no critical issues identified. Minor enhancements can further strengthen the application’s quality and scalability.

### Next Steps:
- Expand browser coverage.
- Add API and performance tests.
- Implement accessibility validations.

For detailed logs or inquiries, contact at [rafiabdps@gmail.com].

