DROP TABLE IF EXISTS Ingredient_type;
DROP TABLE IF EXISTS Ingredient;
DROP TABLE IF EXISTS Burger_Order;
DROP TABLE IF EXISTS Burger_Component;
DROP TABLE IF EXISTS Employee;

-- Create tables for each entity and many-to-many relation
CREATE TABLE Ingredient_type (
  ingrdient_type_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  ingredient_type_name VARCHAR(50) NOT NULL
);

CREATE TABLE Ingredient (
  ingredient_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  ingredient_type INTEGER NOT NULL,
  ingredient_name VARCHAR(50) NOT NULL,
  unit_price DOUBLE NOT NULL,
  quantity INTEGER NOT NULL,
  FOREIGN KEY (ingredient_type) REFERENCES Ingredient_type (ingrdient_type_id)
);

CREATE TABLE Burger_Order (
  order_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  user_alias VARCHAR(50) NOT NULL,
  user_phone INTEGER NOT NULL,
  order_completed BOOLEAN NOT NULL DEFAULT 0,
  timestamp TEXT NOT NULL,
  employee_id INTEGER,
  FOREIGN KEY (employee_id) REFERENCES Employee (employee_id)
);

CREATE TABLE Burger_Component (
  component_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  ingredient_id INTEGER NOT NULL,
  order_id INTEGER NOT NULL,
  FOREIGN KEY (ingredient_id) REFERENCES Ingredient (ingredient_id),
  FOREIGN KEY (order_id) REFERENCES Burger_Order (order_id)
);

CREATE TABLE Employee (
  employee_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  employee_fname VARCHAR(50),
  employee_lname VARCHAR(50),
  hash TEXT NOT NULL,
  salt TEXT NOT NULL,
  iterations INT NOT NULL
);