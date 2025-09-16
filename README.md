🚀 CCPC App Automation Project

Appium-based mobile automation testing framework designed for the CCPC App.
Built with Java, Maven, TestNG, JSON, and Extent Reports, this project ensures scalable, reusable, and maintainable test automation following the Page Object Model (POM) design pattern.

✨ Features Tested

The framework covers end-to-end functional testing of the entire CCPC App:

🔑 Login, Logout, ForgotPassword and Signup
📜 All screens/pages navigation and functionality validation
📸 Image swipe, gallery interactions, and media checks
📜 Page scroll, content verification, and UI element checks
⚙️ Form submissions and input validations
🔔 Notifications and alert handling
📂 Page Object Model (POM) implementation for reusability
🧪 TestNG for structured test execution & reporting
📊 Extent Reports for interactive test reports
📑 JSON integration for test data management

🛠️ Tech Stack

Java
Appium
TestNG
Maven
JSON
Extent Reports

⚙️ How to Run

Follow these steps to execute the automated tests:

1️⃣ Clone the Repository
git clone https://github.com/your-username/ccpc-app-automation.git
2️⃣ Navigate to Project Folder
cd ccpc-app-automation
3️⃣ Install Dependencies
Make sure Maven is installed. Install project dependencies:
mvn clean install
4️⃣ Configure Test Data & Devices
Update JSON test data if needed.
Connect your mobile device/emulator.
Update Appium server URL and device capabilities in BaseTest.java or config.properties.
5️⃣ Run Tests
Execute all tests using Maven:
mvn clean test
⚡ Tests will execute on the connected device/emulator and generate Extent Reports automatically.
6️⃣ View Test Reports
After execution, open Extent Reports HTML in the reports/ folder to check test results with screenshots, logs, and pass/fail status.

📌 Project Highlights

✅ Full application functional coverage for CCPC App
✅ Login, Signup, Logout, ForgotPassword, Media, Navigation, Forms, Notifications all tested
✅ Scalable, reusable framework suitable for QA portfolio

📸 Screenshots / Application Flow (Optional)
Add screenshots or a high-level framework diagram here to make README more attractive.

👩‍💻 Author
Annu Kumari



