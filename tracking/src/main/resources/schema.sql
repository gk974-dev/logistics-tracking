CREATE TABLE IF NOT EXISTS `customerdata` (
    `customer_id` VARCHAR(100) NOT NULL PRIMARY KEY,
    `origin_country_id` VARCHAR(2) NOT NULL,
    `destination_country_id` VARCHAR(2) NOT NULL,
    `weight` DECIMAL(10,3) NOT NULL,
    `customer_name` VARCHAR(100) NOT NULL,
    `customer_slug` VARCHAR(100) DEFAULT NULL,
    `created_at` DATETIME DEFAULT NULL,
    `tracking_id` VARCHAR(16) NOT NULL UNIQUE
);
