# Supermarket Automation System

College full-stack project: HTML/CSS/JavaScript frontend, Java 17 + Spring Boot backend, MySQL database.

## Requirements
- JDK 17+
- Maven 3.9+
- MySQL 8+

## Linux setup (Ubuntu/Debian)
```bash
sudo apt update
sudo apt install openjdk-17-jdk maven mysql-server unzip -y
sudo systemctl enable --now mysql
sudo mysql
```
In the MySQL prompt:
```sql
CREATE DATABASE supermarket_db;
CREATE USER 'sasuser'@'localhost' IDENTIFIED BY 'SasPass123!';
GRANT ALL PRIVILEGES ON supermarket_db.* TO 'sasuser'@'localhost';
FLUSH PRIVILEGES;
EXIT;
```
From this project folder:
```bash
mysql -u sasuser -p supermarket_db < database/schema.sql
DB_USER=sasuser DB_PASSWORD='SasPass123!' mvn spring-boot:run
```
Open http://localhost:8080

## API
GET /api/dashboard, GET /api/products, POST /api/products, PUT /api/products/{id}, DELETE /api/products/{id}, POST /api/products/{id}/stock, POST /api/checkout, GET /api/sales.

## OOP concepts
Encapsulation is demonstrated by private Product fields and domain methods. Controller, service, repository and model layers demonstrate separation of concerns and abstraction. Payment method is stored as a validated type; no real payment gateway is integrated.

## Notes
Educational prototype. No authentication or real payment processing. Do not expose it publicly without adding security, validation hardening, transaction/stock locking and audit controls.
