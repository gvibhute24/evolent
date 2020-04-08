# Evolent Employee managment Steps to setup server application

# Clone the application
      ``bash
   git clone https://github.com/gvibhute24/evolent.git

# Create MySQL database
      ``bash
   create database evolent
 
# Change MySQL username and password as per your MySQL installation
      ``bash
  open src/main/resources/application-prod.properties file.
  change spring.datasource.username and spring.datasource.password properties as per your mysql installation
# Run the app
      ``bash
  mvn clean package
  java -jar -Dspring.profiles.active=prod evolent.jar
  The server will start on port 8080.

