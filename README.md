# Bus Reservation System (JDBC & MySQL)

## 📋 Project Overview
This project is a back-end system for a Bus Travelling Agency. It manages bus inventory and passenger bookings using **Java JDBC** and **MySQL**.

## 🏗️ System Architecture
- **Singleton Pattern**: The `DbConnection` class uses a private constructor to ensure a single database connection instance, optimizing resource usage.
- **DAO Pattern**: Data Access Objects (`BookingDAO`, `BusDAO`) isolate the database layer from the business logic.
- **JUnit 5 Testing**: Automated unit tests verify bus availability and data integrity.

## 📊 Analytical Capabilities (Data Science Focus)
- **Revenue Reports**: SQL aggregate functions calculate total earnings per bus.
- **Capacity Tracking**: Real-time checking of seat availability based on passenger counts.

## 🚀 How to Run
1. Run the `schema.sql` script in MySQL to set up tables.
2. Add the `mysql-connector-j` and `JUnit 5` JARs to your project libraries.
3. Update credentials in `DbConnection.java`.
4. Run `Main.java` or execute tests in the `test` folder.