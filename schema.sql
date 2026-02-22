-- Create the database
CREATE DATABASE IF NOT EXISTS bus_agency;
USE bus_agency;

-- Table to store Bus details
-- High-level note: capacity is crucial for your isAvailable() logic
CREATE TABLE bus (
    bus_no INT PRIMARY KEY,
    ac BOOLEAN,
    capacity INT
);

-- Table to store Passenger and Booking details
-- pass_id is AUTO_INCREMENT so you don't have to manage IDs manually
CREATE TABLE passenger (
    pass_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT,
    date_booked DATE NOT NULL,
    amount DOUBLE,
    bus_id INT,
    starting_point VARCHAR(50),
    destination VARCHAR(50),
    FOREIGN KEY (bus_id) REFERENCES bus(bus_no)
);

-- Seed data for testing (Bus 101 with capacity 2)
INSERT INTO bus (bus_no, ac, capacity) VALUES (101, true, 2);
INSERT INTO bus (bus_no, ac, capacity) VALUES (102, false, 35);