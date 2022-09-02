# Meeting room 2.0 AQA

Фреймворк для автоматизации тестирования мобильного приложения Meeting room mobile (Android).

# Стек технологий:

- java
- testng
- rest-assured
- appium
- postgresql
- allure

# main:

java.api.core - helper-классы для создания api-запросов
java.api.dto - билдеры body
java.db - классы для работы с БД:

- DataBase - старый
- DataBaseDelete - старый
- DataBaseManager - актуальный
  java.driver.manager - singleton appium driver
  java.helpers - helper-классы, в данный момент только PropertiesProvider, необходимый для чтения пропертей
  java.ui.constants - константы
  java.ui.pages - старые PageObjects
  java.ui.screens - новые PageObjects
  java.verification - классы для проверки, в данный момент реализованы soft assets

# resources:

resources - настройки

# test:

java.steps - сквозные классы для allure
java.tests.api - api-тесты
java.tests.ui - ui-тесты

# testResources:

- тест-сьюты

# Запуст тестов:

# - запуск api-тестов:

mvn clean test -Dsurefire.suiteXmlFiles=src/testResources/testSuiteAPI.xml

# !!! для запуска ui-тестов должен быть запущен appium сервер и эмулятор android (Pixel 2 XL API 30) с установленным приложением Meeting room mobile
# Ссылка на репозиторий приложения:
https://git.andersenlab.com/Andersen/meeting-room-2.0-aqa

# - запуск старых ui-тестов:

mvn clean test -Dsurefire.suiteXmlFiles=src/testResources/testSuiteUI.xml

# - запуск норвых ui-тестов:

mvn clean test -Dsurefire.suiteXmlFiles=src/testResources/testSuiteUINew.xml