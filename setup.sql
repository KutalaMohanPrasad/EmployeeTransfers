CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    name VARCHAR(50),
    job_name VARCHAR(50),
    manager_id INT,
    hire_date DATE,
    salary DECIMAL(10, 2),
    commission DECIMAL(10, 2),
    dep_id INT
);
CREATE TABLE department (
  deptno decimal(2,0) default NULL,
  dname varchar(14) default NULL,
  loc varchar(13) default NULL
);






---inserts


INSERT INTO employees (emp_id, name, job_name, manager_id, hire_date, salary, commission, dep_id)
VALUES
    (1, 'John Doe', 'Manager', NULL, '2022-01-01', 80000.00, 1000.00, 1),
    (2, 'Jane Smith', 'Salesperson', 1, '2020-01-01', 50000.00, 2000.00, 1),
    (3, 'Bob Johnson', 'Salesperson', 1, '2020-02-01', 55000.00, 1500.00, 1),
    (4, 'Mary Lee', 'Salesperson', 1, '2020-02-15', 60000.00, 1000.00, 1),
    (5, 'Tom Williams', 'Manager', NULL, '2019-01-01', 90000.00, 2000.00, 2),
    (6, 'Emily Chen', 'Salesperson', 5, '2018-01-15', 60000.00, 1500.00, 2),
    (7, 'David Kim', 'Salesperson', 5, '2020-02-01', 65000.00, 1000.00, 2),
    (8, 'Amy Park', 'Salesperson', 5, '2020-03-01', 70000.00, 2000.00, 2),
    (9, 'Michael Brown', 'Manager', NULL, '2022-01-01', 100000.00, 3000.00, 3),
    (10, 'Sarah Johnson', 'Salesperson', 9, '2023-02-01', 60000.00, 1500.00, 3),
    (11, 'Adam Lee', 'Salesperson', 9, '2020-03-01', 55000.00, 1000.00, 3),
    (12, 'Emma Davis', 'Manager', NULL, '2017-01-01', 110000.00, 4000.00, 4),
    (13, 'Oliver Smith', 'Salesperson', 12, '2020-02-01', 50000.00, 2000.00, 4),
    (14, 'Sophia Brown', 'Salesperson', 12, '2020-03-01', 55000.00, 1500.00, 4),
    (15, 'Ethan Johnson', 'Salesperson', 12, '2020-04-01', 60000.00, 1000.00, 4),
    (16, 'Ava Lee', 'Salesperson', 12, '2020-05-01', 60000.00, 1000.00, 4);
    
INSERT INTO department VALUES ('1','ACCOUNTING','NEW YORK');
INSERT INTO department VALUES ('2','RESEARCH','DALLAS');
INSERT INTO department VALUES ('3','SALES','CHICAGO');
INSERT INTO department VALUES ('4','OPERATIONS','BOSTON');
    
    