CREATE DATABASE IF NOT EXISTS train_booking;
USE train_booking;

CREATE TABLE IF NOT EXISTS tickets (
    ticket_id INT AUTO_INCREMENT PRIMARY KEY,
    passenger_name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    seat_number INT NOT NULL UNIQUE
);
