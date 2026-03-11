# EmployeeTransfers Database Setup Guide

## Prerequisites
- PostgreSQL 17 installed and running on localhost:5432
- PostgreSQL CLI tools available (psql)
- Default postgres user with password: `12345`

## Quick Setup Instructions

### 1. Create the Database

Connect to PostgreSQL and create the employee_db database:

```bash
psql -U postgres -h localhost
```

Once connected to PostgreSQL, run:

```sql
CREATE DATABASE employee_db;
\c employee_db
```

### 2. Initialize Schema and Data

Run the setup.sql script to create tables and insert sample data:

```bash
psql -U postgres -h localhost -d employee_db -f setup.sql
```

Or paste the contents of setup.sql in the PostgreSQL CLI.

### 3. Verify the Setup

```sql
-- Connect to the database
\c employee_db

-- Check tables were created
\dt

-- Verify employees data
SELECT COUNT(*) FROM employees;
SELECT * FROM department;
```

## Database Configuration

The application uses the following connection details (see `application.properties`):

- **Host**: localhost
- **Port**: 5432
- **Database**: employee_db
- **Username**: postgres
- **Password**: ****
- **Driver**: PostgreSQL JDBC Driver

## Running the Application

### Via Maven

```bash
mvn clean install
mvn spring-boot:run
```

### Via JAR

```bash
java -jar target/employee-transfers-0.0.1.war
```

The application will start on `http://localhost:8080`

## API Endpoints

- **GET** `/api/v1/getAllEmployeeDetails` - Retrieve all employees
- **POST** `/api/v1/createEmployee` - Create a new employee
- **POST** `/api/v1/updateEmployee` - Update an existing employee
- **POST** `/api/v1/deleteEmployees` - Delete employees by ID

## Swagger Documentation

Once the application is running, access the Swagger UI at:
```
http://localhost:8080/swagger-ui.html
```

## Troubleshooting

### Connection Refused
If you get "Connection refused" error:
1. Verify PostgreSQL is running: `pg_ctl status`
2. Check if PostgreSQL is listening on port 5432: `netstat -an | grep 5432`
3. Verify credentials in application.properties match your PostgreSQL setup

### Table Not Found
If you get "Table does not exist" error:
1. Ensure setup.sql was executed successfully
2. Verify you're connected to the correct database: `\c employee_db`
3. Check tables exist: `\dt` in psql

### Authentication Failed
If authentication fails:
1. Reset PostgreSQL password: `ALTER USER postgres WITH PASSWORD '12345';`
2. Ensure no firewalls are blocking localhost:5432

## Database Schema

### Tables

**employees**
- emp_id: INTEGER PRIMARY KEY (auto-increment)
- name: VARCHAR(100) NOT NULL
- job_name: VARCHAR(100) NOT NULL
- manager_id: INTEGER
- hire_date: DATE NOT NULL
- salary: DECIMAL(10,2) NOT NULL
- commission: DECIMAL(10,2)
- dep_id: INTEGER NOT NULL (Foreign Key)

**department**
- deptno: DECIMAL(2,0) PRIMARY KEY
- dname: VARCHAR(14)
- loc: VARCHAR(13)

## Sample Data Included

The setup.sql includes 16 sample employees across 4 departments:
- 1. ACCOUNTING (New York)
- 2. RESEARCH (Dallas)
- 3. SALES (Chicago)
- 4. OPERATIONS (Boston)

