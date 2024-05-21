                                Подготовительный запуск приложений
1. Запустить Docker Desktop.
2. Запустить IntelliJ IDEA, открыть в ней клонированный проект diplom.
3. Во вкладке Terminal (Local) приложения IntelliJ IDEA, ввести в командную строку команду: docker compose up –-build

Запуск Веб-сервиса для работы с MySQL
Открыть вторую вкладку Terminal (Local (2)) приложения IntelliJ IDEA, ввести в командную строку команду: java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar

Запуск тестов для работы с MySQL
Открыть третью вкладку Terminal (Local (3)) приложения IntelliJ IDEA, ввести в командную строку команду: ./gradlew clean test -D db.url=jdbc:mysql ://localhost:3306/ msql -D schemas=msql

Запуск Веб-сервиса для работы с PostgreSQL (Docker Desktop и контейнеры запущены после тестирования с БД MySQL)
Открыть вторую вкладку Terminal (Local (2)) приложения IntelliJ IDEA, ввести в командную строку команду: java "-Dspring.datasourse.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar

Запуск тестов для работы с PostgreSQL
Открыть третью вкладку Terminal (Local (3)) приложения IntelliJ IDEA, ввести в командную строку команду: ./gradlew clean test -D db.url=jdbc:postgresql://localhost:5432/psql -D schemas=psql
