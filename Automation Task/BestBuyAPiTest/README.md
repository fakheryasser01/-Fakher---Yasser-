
# Best Buy API Playground Automation Project

Automated list of test cases proposed for automation

### The main Frameworks included in the project:
* Rest assured
* TestNG
* Maven
* json-simple
* jackson-databind
* Allure Report


### Project Design:
* Page Object Model (POM) design pattern 
* A ApiBase class in *src/main/java/pages/ApiBase.java* file path, that includes many wrapper methods in static classes which services as a core engine for the project 

### How to run the project test cases:
* Can find the test cases in the *src/test/java* folder mainly in the *apiTest* package
* Can find the test data  in the *src/main/java* folder mainly in the *data* package
* Can find the test suite for all the test cases in the *BestBuyAPiTest* folder in the *testng.xml* file
* To start the execution, please make sure that Maven and allure Report are setuped on the enviroment 
* Can run through TestNG xml: by right click on the test suite xml file and click Run As >> TestNG Suit 
* Can run through maven : by opening a command-line terminal on the project root path and type `mvn clean` then `mvn Test`
* After executing, you can easily generate the ***Allure Report*** by opening a command-line terminal on the project root path and type `allure. bat serve`
* After executing, you can find the ***emailable-report.html** under the following file */BestBuyAPiTest/target/surefire-reports/*




