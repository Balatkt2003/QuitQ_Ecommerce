CREATE DATABASE QuitQ;
USE QuitQ;

CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    gender VARCHAR(10),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    mobile VARCHAR(15),
    address TEXT,
    role ENUM('buyer', 'seller') NOT NULL
);
INSERT INTO users (name, gender, email, password, mobile, address, role) VALUES
('Ravi Kumar', 'Male', 'ravi@gmail.com', 'ravi123', '9876543210', 'Chennai, Tamil Nadu', 'buyer'),
('Anjali Mehta', 'Female', 'anjali@gmail.com', 'anjali123', '9876512345', 'Mumbai, Maharashtra', 'buyer'),
('Rahul Sharma', 'Male', 'rahul@gmail.com', 'rahul123', '9123456789', 'Delhi', 'seller'),
('Priya Singh', 'Female', 'priya@gmail.com', 'priya123', '9988776655', 'Bangalore, Karnataka', 'buyer'),
('Karthik R', 'Male', 'karthik@gmail.com', 'karthik123', '9876000000', 'Hyderabad', 'seller'),
('Divya Jain', 'Female', 'divya@gmail.com', 'divya123', '9090909090', 'Kolkata', 'buyer'),
('Amit Patel', 'Male', 'amit@gmail.com', 'amit123', '9112233445', 'Ahmedabad', 'buyer'),
('Sneha Iyer', 'Female', 'sneha@gmail.com', 'sneha123', '9345678123', 'Pune', 'seller'),
('Sathish B', 'Male', 'sathish@gmail.com', 'sathish123', '9087654321', 'Coimbatore', 'buyer'),
('Meera Nair', 'Female', 'meera@gmail.com', 'meera123', '9456123789', 'Thiruvananthapuram', 'seller');
CREATE TABLE sellers (
    seller_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    contact VARCHAR(15),
    company_name VARCHAR(100)
);

INSERT INTO sellers (name, email, password, contact, company_name) VALUES
('Vishal Electronics', 'vishal@electronics.com', 'vishal123', '9988776655', 'Vishal Electronics'),
('Trendy Wear', 'trendy@wear.com', 'trendy123', '9876543211', 'Trendy Wear Fashions'),
('HomeStyle', 'home@style.com', 'home123', '9123456781', 'HomeStyle Interiors'),
('Gadgetz', 'info@gadgetz.com', 'gadget123', '9012345678', 'Gadgetz India');
CREATE TABLE products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    seller_id INT,
    name VARCHAR(100),
    category VARCHAR(50),
    description TEXT,
    price DECIMAL(10,2),
    stock INT,
    FOREIGN KEY (seller_id) REFERENCES sellers(seller_id)
);

INSERT INTO products (seller_id, name, category, description, price, stock) VALUES
(1, 'Samsung Galaxy M14', 'Mobile', '5G Phone, 6000 mAh Battery', 13999.00, 50),
(2, 'Levis Jeans', 'Fashion', 'Men Slim Fit Denim', 2499.00, 100),
(3, 'Wooden Dining Table', 'Home & Furniture', '6-seater, Teak Finish', 15999.00, 15),
(4, 'Sony Bluetooth Speaker', 'Electronics', 'Portable Speaker with Bass Boost', 4999.00, 40),
(2, 'Nike Running Shoes', 'Fashion', 'Lightweight sports shoes', 3299.00, 60),
(1, 'Redmi Note 13 Pro', 'Mobile', 'AMOLED display, 5000mAh', 17999.00, 30),
(3, 'Sofa Set', 'Home & Furniture', '5-seater with recliner', 28999.00, 8),
(4, 'HP Wireless Mouse', 'Electronics', '2.4GHz USB Mouse', 799.00, 200),
(4, 'Dell Laptop i5 12th Gen', 'Electronics', '8GB RAM, 512GB SSD', 58999.00, 10),
(1, 'Realme Buds Wireless', 'Electronics', 'Neckband with 20hrs battery', 1299.00, 70);
CREATE TABLE cart_items (
    cart_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

INSERT INTO cart_items (user_id, product_id, quantity) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 4, 1),
(4, 6, 1),
(5, 5, 3),
(6, 3, 1),
(7, 7, 1),
(8, 8, 2),
(9, 9, 1),
(10, 10, 2);
CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    order_date DATE,
    total_amount DECIMAL(10,2),
    status VARCHAR(50),
    shipping_address TEXT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO orders (user_id, order_date, total_amount, status, shipping_address) VALUES
(1, '2025-06-01', 13999.00, 'Delivered', 'Chennai, Tamil Nadu'),
(2, '2025-06-02', 4998.00, 'Shipped', 'Mumbai, Maharashtra'),
(3, '2025-06-03', 4999.00, 'Processing', 'Delhi'),
(4, '2025-06-04', 17999.00, 'Cancelled', 'Bangalore, Karnataka'),
(5, '2025-06-05', 9897.00, 'Delivered', 'Hyderabad'),
(6, '2025-06-06', 15999.00, 'Shipped', 'Kolkata'),
(7, '2025-06-07', 28999.00, 'Processing', 'Ahmedabad'),
(8, '2025-06-08', 1598.00, 'Delivered', 'Pune'),
(9, '2025-06-09', 58999.00, 'Delivered', 'Coimbatore'),
(10, '2025-06-10', 2598.00, 'Processing', 'Thiruvananthapuram');

