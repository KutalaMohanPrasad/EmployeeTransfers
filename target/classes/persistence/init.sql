CREATE TABLE employees (
    emp_id SERIAL PRIMARY KEY ,
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


INSERT INTO department (deptno,dname,loc) VALUES ('1','ACCOUNTING','NEW YORK');
INSERT INTO department VALUES ('2','RESEARCH','DALLAS');
INSERT INTO department VALUES ('3','SALES','CHICAGO');
INSERT INTO department VALUES ('4','OPERATIONS','BOSTON');

INSERT INTO employees (name, job_name, manager_id, hire_date, salary, commission, dep_id)
VALUES
    ( 'John Doe', 'Manager', NULL, '2022-01-01', 80000.00, 1000.00, 1),
    ( 'Jane Smith', 'Salesperson', 1, '2020-01-01', 50000.00, 2000.00, 1),
    ( 'Bob Johnson', 'Salesperson', 1, '2020-02-01', 55000.00, 1500.00, 1),
    ( 'Mary Lee', 'Salesperson', 1, '2020-02-15', 60000.00, 1000.00, 1),
    ( 'Tom Williams', 'Manager', NULL, '2019-01-01', 90000.00, 2000.00, 2),
    ( 'Emily Chen', 'Salesperson', 5, '2018-01-15', 60000.00, 1500.00, 2),
    ( 'David Kim', 'Salesperson', 5, '2020-02-01', 65000.00, 1000.00, 2),
    ( 'Amy Park', 'Salesperson', 5, '2020-03-01', 70000.00, 2000.00, 2),
    ( 'Michael Brown', 'Manager', NULL, '2022-01-01', 100000.00, 3000.00, 3),
    ( 'Sarah Johnson', 'Salesperson', 9, '2023-02-01', 60000.00, 1500.00, 3),
    ( 'Adam Lee', 'Salesperson', 9, '2020-03-01', 55000.00, 1000.00, 3),
    ( 'Emma Davis', 'Manager', NULL, '2017-01-01', 110000.00, 4000.00, 4),
    ( 'Oliver Smith', 'Salesperson', 12, '2020-02-01', 50000.00, 2000.00, 4),
    ( 'Sophia Brown', 'Salesperson', 12, '2020-03-01', 55000.00, 1500.00, 4),
    ( 'Ethan Johnson', 'Salesperson', 12, '2020-04-01', 60000.00, 1000.00, 4),
    ( 'Ava Lee', 'Salesperson', 12, '2020-05-01', 60000.00, 1000.00, 4);