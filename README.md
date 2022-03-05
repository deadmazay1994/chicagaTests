# chicagaTests

Для запуска тестов и получения отчета в окне браузера с результатами необходимо выполнить команду

`mvn clean test surefire:test -Dmaven.test.failure.ignore=true -DfailIfNoTests=false allure:serve`
