Github link with the source code : https://github.com/bpanja01/LeanTech-SauceLabDemo

Documentation explaining the test suite setup and execution process : 

Tech stack of Test Suite :
-Selenium Webdriver(Page Object Model) with Java
-Build Tool: Maven
-Automation Framework : BDD - Cucumber
-Reporting: Cucumber Reporting
-Logger : Slf4j
-Broswer Support : Chrome however Framework has the capability to support with other browser as well
-JDK version - JDK17
-IDE - Intellij

Any additional resources or dependencies required to run the tests:

-Need to install chrome driver and keep in : SaucelabDemoUIAutomation\src\test\resources\driver
-Tags needs to be passed in RunnerTest class as "@test" which is provided bydefault
-build the project and run the maven command clean install
-Report Folder Path : SaucelabDemoUIAutomation/target/cucumber-report-html/cucumber-html-reports/overview-features.html
-Logs should be visible in console