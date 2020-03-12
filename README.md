# Tests to cover CRUD requests for gists api


## Used toolset
* Java
* Gradle
* Rest-assured
* Lombok
* TestNG
* Allure

## Preconditions/Environment
* Test should work on any linux/unix (CentOS, RedHat, Fedora, etc.) and Windows 7 (and higher)
* java version 8 

## How to run
* Clone repo
* Wait until gradle install dependencies 
* Run test (`gradlew test`) or through ide
* Open html report (```gralew allureReport```) or automatically generated report at /build/reports/tests/test/index.html

![allure example from tests](https://drive.google.com/file/d/1FCjrxgrPUb69w1KTt0rHPRZ70dkIgrRV/view?usp=sharing)


## TODO
* implement some methods
* add additional models
* cover more negative scenarios
* refactor some classes
* add naming for tests
* add Spring
* add more detailed logging by @Slf4j

## Possible issues
* lombok plugin : required constructors for @RequiredArgsConstructor -> project need to be rebuild

## Links
* [allure](http://allure.qatools.ru/)
* [lombok](https://projectlombok.org/)
