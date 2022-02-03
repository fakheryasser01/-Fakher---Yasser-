
# Facebook Automation Project

Automated tests for facebook registration and login scenarios

### The main Frameworks included in the project:
* Selenium Webdriver
* TestNG
* Maven
* Allure Report
* Apachi POI

### Project Design:
* Page Object Model (POM) design pattern (method chaining)
* Data Driven framework (Excel)
* A PageBase class in *src/main/java/pages/PageBase.java* file path, that includes many wrapper methods in static classes which services as a core engine for the project 
* A screenShot for failure 
* A Allure / emailable-report report After excuting 


### How to run the project test cases :
* Can find the test cases in the *src/test/java* folder mainly in the *pagesTest* package
* Can find the test data with it's reader in the *src/test/java* folder mainly in the *data* package
* Can find the TestBase in the *src/test/java* folder mainly in the *base* package
* Can find the test suite for all the test cases in the *FacebookProject* folder in the *testng.xml* file
* To start the execution, please make sure that Maven and allure Report are setuped on the enviroment 
* Can run through TestNG xml: by right click on the test suite xml file and click Run As >> TestNG Suit 
* Can run through maven : by opening a command-line terminal on the project root path and type `mvn clean` then `mvn Test`
* After executing, you can easily generate the ***Allure Report*** by opening a command-line terminal on the project root path and type `allure. bat serve`



