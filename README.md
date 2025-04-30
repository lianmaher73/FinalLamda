https://github.com/LianmaherAltibbi/lamdaExam# Selenium 101 - LambdaTest Assignment

This project is a solution for the **Selenium 101 Assignment** provided by LambdaTest. It includes automated test scenarios for the [LambdaTest Selenium Playground](https://www.lambdatest.com/selenium-playground), using **Java**, **TestNG**, and **Selenium Grid on LambdaTest**.

---

##  Test Scenarios Implemented

### ✅ Test Scenario 1 - Simple Form Demo
- Open LambdaTest Playground.
- Navigate to "Simple Form Demo".
- Enter a custom message and validate it appears correctly.

### ✅ Test Scenario 2 - Drag & Drop Sliders
- Navigate to "Drag & Drop Sliders".
- Move the slider from 15 to 95.
- Assert the value is updated to 95.

### ✅ Test Scenario 3 - Input Form Submit
- Click Submit without filling in any input.
- Assert required field error message.
- Fill the form completely and submit.
- Verify success message appears.

---

## 🧪 Technology Stack

- **Java 17+**
- **TestNG**
- **Selenium WebDriver**
- **LambdaTest Cloud Selenium Grid**
- **Gitpod** (for cloud-based development)

---

## 🖥️ Parallel Test Execution

Tests are run in parallel using `testng.xml` across:
- ✅ Chrome on **Windows 10**
- ✅ Safari on **macOS Catalina**

Each class executes on a separate thread using TestNG's `parallel=classes`.

---

## 🔧 How to Run (using Gitpod)

### 1. Open Gitpod

Click below to open the repo in Gitpod:

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/LianmaherAltibbi/test1)

### 2. Run Tests

```bash
mvn clean test
"# lamda" 
