# Trendyol Login Test Automation

This is a TestNG + Selenium Java project that automates login tests for Trendyol.

---

## ⚙️ Tech Stack

- Java 11.0.25
- Selenium WebDriver
- TestNG
- ExtentReports
- Maven

---

## 📂 Project Structure

```
/src/test/java
  ├── tests/TrendyolTest.java
  ├── testData/LoginDataProvider.java
  ├── pages/HomePage.java, LoginPage.java
  └── utils/DriverFactory, ExtentManager, ElementHelper
```

---

## ▶️ Run Tests

1. Clone this repo
2. Replace credentials inside `LoginDataProvider.java` with your **own valid email and password**
3. Run `TrendyolTest.java` from your IDE

✅ No testng.xml required  
✅ Runs sequentially  
✅ Generates HTML report after each run

---

## 📄 Reports

After execution, a report is created under:

```
/test-Report/Trendyol_Test_Report_<timestamp>.html
```

Includes:
- Scenario names
- Test steps
- System info (OS, Java version, Tester, Browser)
- Pass/Fail details

---

## 🧪 Test Scenarios (Sample)

```java
{"your_email@example.com", "", "Please enter your password", "Empty Password", 1},
{"your_email@example.com", "wrongPassword123456", "Invalid email/password", "Wrong Password", 2},
{"your_email@example.com", "yourRealPassword", null, "Successful Login", 3}
```

Update with your real login credentials.

---

## 👤 Author

Ata Pourfarivarnezhad
