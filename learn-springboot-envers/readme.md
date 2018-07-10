# Project summary

## 1. Restful endpoints for CRUD operations
1. GET /users/{id}
2. POST /users
3. PUT /users/{id}
4. DELETE /users/{id}

## 2. How to run the application?
1. Right click on the application.
2. Run as/Debug as Spring Boot App.

## 3. How to invoke the APIs?
1. Install Postman.
2. Import Spring-Envers.postman_collection.json file present under resources folder in the project.

## 4. How to validate the audited data in database?
1. Run the Spring boot application
2. Open http://localhost:8080/learn-envers/h2-console.
3. Paste "jdbc:h2:~/learn4DB" against JDBC URL.
4. Hit enter.
5. Validate the data by querying the transaction and audit tables.
