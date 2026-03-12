-- Create tables inside employee_db database
-- Note: When used with Docker/Kubernetes, the database is already created by POSTGRES_DB environment variable

-- Drop existing tables if they exist (in reverse dependency order)
DROP TABLE IF EXISTS employees CASCADE;
DROP TABLE IF EXISTS department CASCADE;

-- Create department table first (referenced by employees)
CREATE TABLE department (
  deptno INTEGER PRIMARY KEY,
  dname VARCHAR(14),
  loc VARCHAR(13)
);

-- Create employees table with proper constraints
CREATE TABLE employees (
    emp_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    job_name VARCHAR(50) NOT NULL,
    manager_id INTEGER,
    hire_date DATE NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    commission DECIMAL(10, 2),
    dep_id INTEGER NOT NULL,
    CONSTRAINT fk_department FOREIGN KEY (dep_id) REFERENCES department(deptno)
);

-- Insert department data FIRST (before employees due to foreign key constraint)
INSERT INTO department (deptno, dname, loc) VALUES
    (1, 'ACCOUNTING', 'NEW YORK'),
    (2, 'RESEARCH', 'DALLAS'),
    (3, 'SALES', 'CHICAGO'),
    (4, 'OPERATIONS', 'BOSTON');

-- Insert employee data
INSERT INTO employees (name, job_name, manager_id, hire_date, salary, commission, dep_id)
VALUES
    ('John Doe', 'Manager', NULL, '2022-01-01', 80000.00, 1000.00, 1),
    ('Jane Smith', 'Salesperson', 1, '2020-01-01', 50000.00, 2000.00, 1),
    ('Bob Johnson', 'Salesperson', 1, '2020-02-01', 55000.00, 1500.00, 1),
    ('Mary Lee', 'Salesperson', 1, '2020-02-15', 60000.00, 1000.00, 1),
    ('Tom Williams', 'Manager', NULL, '2019-01-01', 90000.00, 2000.00, 2),
    ('Emily Chen', 'Salesperson', 5, '2018-01-15', 60000.00, 1500.00, 2),
    ('David Kim', 'Salesperson', 5, '2020-02-01', 65000.00, 1000.00, 2),
    ('Amy Park', 'Salesperson', 5, '2020-03-01', 70000.00, 2000.00, 2),
    ('Michael Brown', 'Manager', NULL, '2022-01-01', 100000.00, 3000.00, 3),
    ('Sarah Johnson', 'Salesperson', 9, '2023-02-01', 60000.00, 1500.00, 3),
    ('Adam Lee', 'Salesperson', 9, '2020-03-01', 55000.00, 1000.00, 3),
    ('Emma Davis', 'Manager', NULL, '2017-01-01', 110000.00, 4000.00, 4),
    ('Oliver Smith', 'Salesperson', 12, '2020-02-01', 50000.00, 2000.00, 4),
    ('Sophia Brown', 'Salesperson', 12, '2020-03-01', 55000.00, 1500.00, 4),
    ('Ethan Johnson', 'Salesperson', 12, '2020-04-01', 60000.00, 1000.00, 4),
    ('Ava Lee', 'Salesperson', 12, '2020-05-01', 60000.00, 1000.00, 4);

-- Verify data was inserted successfully
SELECT COUNT(*) as total_employees FROM employees;
SELECT COUNT(*) as total_departments FROM department;


SELECT * FROM employees

INSERT INTO department (deptno,dname,loc) VALUES (10,'Research','canada')