# **TEST AUTOMATION SELENIUM 2 TA DASHBOARD**

## 🔆 SOME FEATURES IMPLEMENTED
1. Run the parallel test case
2. Read Config from Properties file
3. Extent Report
4. Read data test from Json file
5. Run Selenium Grid 
6. Retry Failed Test in TestNG with IRetryAnalyzer and IAnnotationTransformer
7. Change parameters via command line 

### ✳️ **SYSTEM REQUIREMENTS**

- Install JDK (recommend JDK >= 11)
- Download jar and setting Variable Environment as Java JDK

## ✳️ HOW TO USE

### 1. Run the parallel test case 

Run test case in testng XML (src/test/resources/testng.xml)

### 2. Read Config from Properties file

Read Config from Properties file  (src/test/resources/config/config.properties)

### 3. Extend Report
Read report from resources/output

### 4. Read data test from Json file

JsonUtils class select the json file path and call "get" method with key

### 5. Run Selenium Grid

Download Selenium Grid 4: https://www.selenium.dev/downloads/
selenium-server-4.24.0.jar (updated 22/09/2024)

### 6. Retry Failed Test in TestNG with IRetryAnalyzer and IAnnotationTransformer

Edit the number of time to retry in config file (src/test/resources/config/config.properties)

### 7. Change parameters via command line 
* Import maven plugin maven-surefire-plugin
* Open command line
* mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml -Dbrowser=chrome -Ddataproviderthreadcount=2



