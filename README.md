create allure report

1. setup plugins in pom.xml
2. make annotations in the code (@Step, @Epic, @Feature, @Description and so on)
3. mvn clean
4. mvn test
5. mvn allure:serve
6. go to http to see the report