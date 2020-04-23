# ======== Problem Statement =======
Build a RESTful service that calculates customer disccount and billing
- Details deliberately left out for security

# ======== Solution =======
# Frameworks used
- Spring Boot
- JPA
- H2 database
- JUnit

# Step-1: Clone, Build and Run
- Clone GIT Repository
- Run mvn clean install to generate jar
- java -jar --PATH-TO-JAR
- Home URL : http://localhost:8081
- Sample url to get amount: http://localhost:8081/billing/20000/Premium  (Get request)

# ======== Future Scope =======
- Addition of more customer types
- Adding discounts based on more parameters
- Add Spring security for Authentication/Authorization
- Use persistent database
- UI for getting billing and discount
- UI for adding different discount slabs
