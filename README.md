# Assessment Application

Overview
This application is a containerized REST API built with Spring Boot, MongoDB, and Docker. It is deployed using Minikube and includes a CI/CD pipeline configured with GitHub Actions.

## Build and Run Locally

Prerequisites
Docker installed on your machine
MongoDB running locally or in a container

## Steps

1. Clone the repository:

git clone https://github.com/kyosk/assessment-app.git
cd assessment-app
Build the Docker image:

2. Build the Docker image:

docker build -t <docker-username>/assignment-app:latest .

3. Run MongoDB in Docker (if not running locally):
4. Run the application:

docker run -p 8080:8080 --link mongodb:mongo <docker-username>/assignment-app:latest

5. Access the application: Open your browser and navigate to:

http://localhost:8080/books

## Deploy on Minikube

### Minikube Setup Commands

Start Minikube:
   minikube start

### Enable Minikube Add-ons:

minikube addons enable ingress

minikube addons enable metrics-server

### Build the Docker image within Minikube:
eval $(minikube docker-env)

docker build -t <docker-username>/assignment-app:latest .

### Deploy the application: Apply the Kubernetes manifests:
kubectl apply -f deployment.yaml

kubectl apply -f service.yaml

### Verify the deployment:
kubectl get pods

kubectl get services

# Access the Application
### Get the Minikube IP:

minikube ip
Access the application: Open your browser and navigate to:

http://<minikube-ip>:<node-port>/books

### Access the application: Open your browser and navigate to:
http://localhost:32040/books

# CI/CD Pipeline in GitHub Actions

## Workflow Description

### Build and Push Docker Image:

The workflow builds the Docker image on every push to the main branch.
It pushes the image to Docker Hub using the credentials stored in GitHub Secrets.

### Steps in the Workflow:

Checkout the code from the repository.
Log in to Docker Hub using GitHub Secrets (DOCKER_USERNAME and DOCKER_PASSWORD).
Build the Docker image using the Dockerfile.
Push the image to Docker Hub.

### Trigger:

The workflow is triggered on any push to the main branch.

## Decisions

NodePort vs ClusterIP: We chose NodePort for local testing since it allows easy access from the host system to the service running inside Minikube.
CI/CD with GitHub Actions: GitHub Actions was selected for CI/CD due to its integration with the repository and ease of configuration.

## Assumptions

MongoDB is always running either locally or in a linked container.
The Docker image is pushed to Docker Hub manually or via the CI/CD pipeline before deploying on Minikube.

## Challenges

### Unauthorized Docker Push:

Resolved by correctly setting up GitHub Secrets for DOCKER_USERNAME and DOCKER_PASSWORD.

### Accessing Minikube Services:

Ensured Minikube IP and NodePort were properly configured and tested.

### Local Database Configuration:

Adjusted application.properties to use host.docker.internal for database connectivity when running inside Docker.

