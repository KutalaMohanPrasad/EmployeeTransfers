# Docker Setup and Build Guide

## Prerequisites

- Docker installed (version 20.10 or later)
- Docker Compose installed (version 1.29 or later)
- Maven build completed (WAR file generated at `target/employee-transfers-0.0.1.war`)

## Quick Start with Docker Compose

### 1. Build and Run Everything

```bash
cd C:\Users\Mohan\IdeaProjects\EmployeeTransfers
docker-compose up --build
```

This will:
- Build the Spring Boot application Docker image
- Start PostgreSQL 17 container
- Start the application container
- Create the employee_db database
- Expose the app on `http://localhost:8080`
- Expose PostgreSQL on `localhost:5432`

### 2. Verify Everything is Running

```bash
docker-compose ps
```

You should see:
- `postgres17` container running (Port 5432)
- `app` container running (Port 8080)

### 3. Access the Application

- **API Base URL**: `http://localhost:8080`
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`

### 4. Stop Everything

```bash
docker-compose down
```

To also remove volumes (database data):
```bash
docker-compose down -v
```

## Manual Docker Build

If you want to build just the image manually:

```bash
# First, ensure the WAR file is built
mvn clean package -DskipTests

# Then build the Docker image
docker build -t employee-transfers:0.0.1 .

# Run the container (requires PostgreSQL running separately)
docker run -p 8080:8080 \
  -e DB_HOST=host.docker.internal \
  -e DB_NAME=employee_db \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=12345 \
  employee-transfers:0.0.1
```

## Docker Configuration Details

### Application Container (Dockerfile)

- **Base Image**: `eclipse-temurin:17-jre-jammy` (modern Java 17 runtime)
- **Port**: 8080 (exposed)
- **Startup Command**: `java -jar app.war`

### PostgreSQL Container (docker-compose.yml)

- **Image**: `postgres:17` (official PostgreSQL 17)
- **Port**: 5432
- **Database**: postgres (auto-created)
- **Username**: postgres
- **Password**: 12345
- **Container Name**: postgres17

### Network

Both containers run on the same Docker network, so the application can reach PostgreSQL using hostname `postgres17` (or the Docker Compose service name).

## Environment Variables

The application accepts these environment variables (used in deployment.yml):

```
DB_HOST          - PostgreSQL hostname (default: postgres17 in docker-compose)
DB_NAME          - Database name (default: employee_db)
POSTGRES_USER    - Database username (default: postgres)
POSTGRES_PASSWORD - Database password (default: 12345)
```

## Troubleshooting

### Error: "failed to resolve source metadata for docker.io/library/openjdk:latest"
**Solution**: This is fixed! The Dockerfile now uses `eclipse-temurin:17-jre-jammy` which is maintained and available.

### Application can't connect to PostgreSQL
**Solution**: 
- Check if postgres17 container is running: `docker-compose ps`
- Verify both containers are on the same network: `docker network ls`
- Check PostgreSQL logs: `docker-compose logs postgres17`

### Port 8080 already in use
**Solution**: Change the port mapping in docker-compose.yml:
```yaml
ports:
  - "8081:8080"  # Use external port 8081
```

### Database not initialized
**Solution**: The setup.sql script needs to be executed after PostgreSQL starts:
```bash
# Get container ID
docker-compose ps

# Execute setup script
docker exec postgres17 psql -U postgres -d postgres -f /path/to/setup.sql
```

## Building for Kubernetes

For Kubernetes deployment (as configured in deployment.yml):

```bash
# Build the image
docker build -t employee-transfers:0.0.1 .

# Tag for your registry
docker tag employee-transfers:0.0.1 your-registry/employee-transfers:0.0.1

# Push to registry
docker push your-registry/employee-transfers:0.0.1

# Update deployment.yml to use your registry image
# Then apply to Kubernetes:
kubectl apply -f deployment.yml
```

## Development Workflow

1. **Make code changes**
2. **Rebuild WAR file**: `mvn clean package -DskipTests`
3. **Rebuild Docker image**: `docker-compose build`
4. **Restart containers**: `docker-compose up`

## Docker Security Best Practices

For production deployments:

1. **Use specific image tags** (not `:latest`)
   ```dockerfile
   FROM eclipse-temurin:17.0.9-7-jre-jammy
   ```

2. **Run with non-root user**
   ```dockerfile
   RUN useradd -m appuser
   USER appuser
   ```

3. **Set resource limits** in docker-compose.yml:
   ```yaml
   services:
     app:
       deploy:
         resources:
           limits:
             cpus: '2'
             memory: 512M
   ```

4. **Use environment-specific configs**
   ```bash
   docker-compose -f docker-compose.yml -f docker-compose.prod.yml up
   ```

## Commands Reference

```bash
# Build and start
docker-compose up --build

# Start in background
docker-compose up -d

# View logs
docker-compose logs -f app
docker-compose logs -f postgres17

# Execute command in container
docker-compose exec app sh
docker-compose exec postgres17 psql -U postgres

# Rebuild specific service
docker-compose build app

# Stop all services
docker-compose stop

# Remove all services and networks
docker-compose down

# Remove volumes as well
docker-compose down -v
```

## Next Steps

1. Run `docker-compose up --build`
2. Wait for both containers to be healthy
3. Access `http://localhost:8080/swagger-ui.html`
4. Test the API endpoints
5. Check logs if there are any issues

