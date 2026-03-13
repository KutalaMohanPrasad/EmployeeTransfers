# for local run

# EmployeeTransfers
Employee Transfers inside the organisation
cd C:\Users\Mohan\IdeaProjects\EmployeeTransfers

# run maven commands to build war file
mvn clean install


# docker commands
docker build -t kutalamohanprasad/employee-transfers:latest .
docker login
docker push kutalamohanprasad/employee-transfers:latest
docker-compose down -v
docker-compose up --build
# Wait 30 seconds → http://localhost:8080/swagger-ui.html


# commands to run in kubernetes
minikube start --driver=docker
minikube status
cd C:\Users\Mohan\IdeaProjects\EmployeeTransfers\src\main\resources
kubectl apply -f postgres-cred.yml
kubectl apply -f postgres-configmap.yml
kubectl apply -f postgres-deployment.yml

# check logs and wait for postgres to be ready
kubectl get pods
kubectl logs <pod-name>

# once pods is running, copy the sql file and run the sql commands to create database and tables
kubectl cp setup.sql <pod-name>:/tmp/setup.sql
kubectl exec -it <pod-name> -- psql -U postgres -f /tmp/setup.sql
# check table is screated
kubectl exec -it <pod-name> -- psql -U postgres -d employee_db
#employee_db=# SELECT * FROM department;
#employee_db=# SELECT * FROM employee;
# once database is ready, deploy the application
cd C:\Users\Mohan\IdeaProjects\EmployeeTransfers\src\main\resources
kubectl apply -f deployment.yml
# check logs and wait for application to be ready
kubectl get pods
kubectl logs <pod-name>
# for detail logs
kubectl describe pod <pod-name>
# once application is ready, 
kubectl port-forward service/employeetransfers-postgres-k8s 8080:8080
# access the application at http://localhost:8080/swagger-ui.html

# Delete everything (pods, services, deployments)
kubectl delete all --all
# stop the kubernetes
minikube stop
# stop the docker desktop
