# Order Management System

## Описание
Order Management System — это приложение для управления заказами, клиентами и продуктами. Оно позволяет создавать, обновлять, удалять и просматривать заказы, а также управлять клиентами и продуктами и расчитывать общую стоимость товаров.

## Зависимости
Для запуска приложения необходимы следующие зависимости:

- **Java 21** или выше
- **Spring Boot v3.3.1 или выше
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL** (или другая реляционная база данных)
- **Lombok**
- **Jackson** (для сериализации/десериализации JSON)
- **Maven** (для управления зависимостями и сборки проекта)

## Установка и запуск

### Шаг 1: Клонирование репозитория
git clone https://github.com/SterlikovSergey/orderManagement.git
cd ordermanagement

### Шаг 2: Настройка базы данных

Создайте базу данных в PostgreSQL (или другой реляционной базе данных) и настройте параметры подключения в файле application.yml
spring.datasource.url=jdbc:postgresql://localhost:5432/ordermanagement
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

### Шаг 3: Сборка и запуск приложения
mvn clean install
mvn spring-boot:run

### Шаг 4: Использование API
После запуска приложения API будет доступен по адресу http://localhost:8898. Вы можете использовать следующие конечные точки:

Клиенты (Customers)
- POST /customers — Создание нового клиента
- GET /customers — Получение списка всех клиентов
- GET /customers/{id} — Получение клиента по ID
- PUT /customers/{id} — Обновление клиента
- DELETE /customers/{id} — Удаление клиента
Заказы (Orders)
- POST /orders — Создание нового заказа
- GET /orders — Получение списка всех заказов
- GET /orders/{id} — Получение заказа по ID
- DELETE /orders/{id} — Удаление заказа
Продукты (Products)
- POST /products — Создание нового продукта
- GET /products — Получение списка всех продуктов
- GET /products/{id} — Получение продукта по ID
- PUT /products/{id} — Обновление продукта
- DELETE /products/{id} — Удаление продукта

  пример json для создания заказа: 
  {
    "customerId": 2,
    "products": {
        "3": 4,
        "2": 5,
				"1": 1,
				"5": 1
    }
}
где "3": 4 - id_Product: quantity product  

## Структура проекта
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── ordermanagement/
│   │               ├── controller/
│   │               │   ├── CustomerController.java
│   │               │   ├── OrderController.java
│   │               │   └── ProductController.java
│   │               ├── model/
│   │               │   ├── Customer.java
│   │               │   ├── Order.java
│   │               │   ├── OrderItem.java
│   │               │   └── Product.java
│   │               ├── repository/
│   │               │   ├── CustomerRepository.java
│   │               │   ├── OrderRepository.java
│   │               │   └── ProductRepository.java
│   │               ├── service/
│   │               │   ├── CustomerService.java
│   │               │   ├── OrderItemService.java
│   │               │   └── OrderService.java
│   │               └── OrderManagementApplication.java
│   └── resources/
│       ├── application.properties
│       └── data.sql
└── test/
    └── java/
        └── com/
            └── example/
                └── ordermanagement/
                    └── OrderManagementApplicationTests.java

## Контакты 
Если у вас есть вопросы или предложения, пожалуйста, свяжитесь с нами по адресу: sterlikovsergey@icloud.com
