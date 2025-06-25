# -RecipeOrchestratorAPI
RecipeOrchestratorAPI is a Spring Boot-based backend application that loads recipe data from an external API (dummyjson.com/recipes) into an in-memory H2 database. It exposes RESTful APIs to search and retrieve recipes using free-text queries (on name and cuisine) or by recipe ID.

# 🍲 RecipeOrchestratorAPI

## 📌 Description
**RecipeOrchestratorAPI** is a Spring Boot-based backend application that orchestrates the loading of recipe data from an external API ([dummyjson.com/recipes](https://dummyjson.com/recipes)) into an in-memory H2 database. It provides RESTful endpoints to search and retrieve recipes using free-text queries (on recipe name and cuisine) or by recipe ID.

---

## 🚀 Features

- 🔄 Load recipes from third-party API into H2 in-memory DB
- 🔍 Free-text search on recipe `name` and `cuisine` using Hibernate Search
- 🔎 Find recipe by `ID`
- ✅ Clean code practices with modular design
- ⚠️ Input data validations
- 📄 Swagger/OpenAPI documentation
- 🧪 Unit test coverage
- ⚙️ Externalized configuration
- 🔁 Resilient and optimized external API integration
- 📋 Centralized exception handling and logging

---

## 📂 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate Search (Lucene)
- H2 In-Memory Database
- Swagger/OpenAPI
- JUnit & Mockito

---

## 🛠️ Setup & Run

### Prerequisites
- Java 17+
- Maven

### Steps

```bash
# Clone the repository
git clone https://github.com/your-username/RecipeOrchestratorAPI.git
cd RecipeOrchestratorAPI

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run



🔗 API Endpoints
Method	Endpoint	Description
POST	/api/recipes/load	Load all recipes from external API to H2 DB
GET	/api/recipes/search?query=	Full-text search on name & cuisine
GET	/api/recipes/{id}	Get a specific recipe by ID

🧪 Testing
Run unit tests:

bash
Copy
Edit
mvn test
📘 API Documentation
Once app is running, access Swagger UI at:
📍 http://localhost:8080/swagger-ui.html

🙌 Author
Shri Prakash Yadav
💼 Backend Developer (Java, Spring Boot)
📧 Contact: +91 8058915391
