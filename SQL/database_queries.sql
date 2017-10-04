-- Development of database queries

-- Orders
-- Collect all open-orders for a specific employee
SELECT o.order_id, i.ingredient_name FROM Burger_Order as o, Employee as e, Ingredient as i, Burger_Component as bc WHERE e.employee_id = o.employee_id AND o.employee_id = 1 AND o.order_completed = 0 AND bc.order_id = o.order_id AND bc.ingredient_id = i.ingredient_id;

-- Collect all open-orders that are not presently allocated
SELECT o.order_id, o.timestamp
FROM Burger_Order as o WHERE o.order_completed = 0 AND o.employee_id is NULL ORDER BY o.timestamp ASC;

-- Employee queries
-- Check whether an employee exists based on an employee id
SELECT e.employee_id, e.employee_fname, e.employee_lname, e.hash, e.salt, e.iterations FROM Employee as e WHERE employee_id = 1;

-- Update an order to assign to an employee
UPDATE Burger_Order SET employee_id = 1 WHERE order_id = 4;

-- Update an order to be completed
UPDATE Burger_Order SET order_completed = 0 WHERE order_id = 1;

-- Ingredient queries
SELECT i.ingredient_name FROM Ingredient as i WHERE i.quantity < 5;

-- Restock ingredient
UPDATE Ingredient SET quantity = 3 WHERE ingredient_name = "Cucumber";

-- Query stock level
SELECT i.quantity FROM Ingredient as i WHERE ingredient_name = "Cucumber";

-- Query all burger types
SELECT i.ingredient_name FROM Ingredient as i, Ingredient_type as it WHERE it.ingrdient_type_id = i.ingredient_type AND it.ingredient_type_name = "Meat";

-- Query all bread types
SELECT i.ingredient_name FROM Ingredient as i, Ingredient_type as it WHERE it.ingrdient_type_id = i.ingredient_type AND it.ingredient_type_name = "Bun";

-- Query all filling types
SELECT i.ingredient_name FROM Ingredient as i, Ingredient_type as it WHERE it.ingrdient_type_id = i.ingredient_type AND it.ingredient_type_name = "Filling";

-- Query all sauce types
SELECT i.ingredient_name FROM Ingredient as i, Ingredient_type as it WHERE it.ingrdient_type_id = i.ingredient_type AND it.ingredient_type_name = "Sauce";



