
# Deployment of Spring boot project using Docker and Minikube



## Deployment

First make the jar file of our spring boot project by using below command

```bash
  gradle build -X test
```


## Step 1: Create Dockerfile



```bash
FROM openjdk:8
WORKDIR /app
ADD build/libs/ElectricityBillPaymentApp-0.0.1-SNAPSHOT.jar .
EXPOSE 8081
ENTRYPOINT ["java","-jar","ElectricityBillPaymentApp-0.0.1-SNAPSHOT.jar"] 
```
    
## Step 2: Create docker-compose file

```bash
version: '3.9'
services:
  api:
    build: 
      context: .
    ports:
      - "8080:8081"
    depends_on:
      db:
        condition: service_healthy
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/postgres
      - SPRING_DATASOURCE_USERNAME=pavan
      - SPRING_DATASOURCE_PASSWORD=tiger
  db:
    image: postgres
    volumes:
      - db_data:/var/lib/postgresql/data
    environment:
      - POSTGRES_PASSWORD=tiger
      - POSTGRES_USER=pavan
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U pavan"]
      interval: 10s
      timeout: 5s
      retries: 5
volumes:
  db_data: {}
```

## Step 3: Install Docker



```bash
sudo yum update -y
sudo yum install docker -y
sudo systemctl start docker
sudo usermod -a -G docker ec2-user
sudo systemctl enable docker
sudo systemctl status docker
```

## Step 4: Install Git and clone the Repository



```bash
sudo yum install git
git clone url
```
In place of url mention your github Repository of Project


## Step 5: Install Docker Compose



```bash
wget https://github.com/docker/compose/releases/download/v2.5.0/docker-compose-linux-x86_64
sudo chmod +x docker-compose-linux-x86_64
sudo mv docker-compose-linux-x86_64 docker-compose
sudo mv docker-compose /usr/local/bin/docker-compose
```

## Step 6: Run the Docker compose file



```bash
docker-compose up -d
```

## Step 7: Accessing the Api

Go to Ec2 Instance and copy the Ip address 
Also copy the port no from docker-compose file


```bash
Ip_Address:portno/swagger-ui.html
```


This Deployment is using Docker is Done.
Now Lets see how to deploy the same project using Kubernates.


## Step 1: Install the Docker



```bash
sudo yum update -y
sudo yum install docker -y
sudo systemctl start docker
sudo usermod -a -G docker ec2-user
sudo systemctl enable docker
sudo systemctl status docker
```


## Step 2: Install the Kubectl



```bash
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo chmod +x kubectl
sudo mv kubectl /usr/bin/
sudo su -
kubectl
```

## Step 3: Install the Minikube



```bash
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
sudo install minikube-linux-amd64 /usr/local/bin/minikube
yum install conntrack -y
minikube start --vm-driver=none
```


## Step 4: Install Git and clone the Repository



```bash
sudo yum install git
git clone url
```
In place of url mention your github Repository of Project


## Step 5:Deploy all Deployment files 



```bash
kubectl apply -f file_name
```
In place of fine_name mention your deployment file names


## Step 6: Accessing the Api

Go to Ec2 Instance and copy the Ip address 
Also copy the port no of application on which it is running 

You can get the port no by using below command
```bash
kubectl get all
```

To access the Api on browser

```bash
Ip_Address:portno/swagger-ui.html
```
