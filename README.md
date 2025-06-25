# 🍲 RecipeOrchestratorAPI

## 📌 Description
**RecipeOrchestratorAPI** is a Spring Boot-based backend application that orchestrates the loading of recipe data from an external API ([dummyjson.com/recipes](https://dummyjson.com/recipes)) into an in-memory H2 database. It provides RESTful endpoints to search and retrieve recipes using free-text queries (on recipe name and cuisine) or by recipe ID.

---

## 🚀 Features

- 🔄 Load recipes from third-party API into H2 in-memory DB
- 🔍 Free-text search on recipe name and cuisine using Hibernate Search
- 🔎 Retrieve recipe by ID
- ✅ Clean code practices with modular design
- ⚠️ Input data validation
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
git clone git@github.com:spyadav0402/-RecipeOrchestratorAPI.git
cd -RecipeOrchestratorAPI

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run



🔗 API Endpoints

| Method | Endpoint                   | Description                                |
| ------ | -------------------------- | ------------------------------------------ |
| POST   | /api/recipes/load          | Load all recipes from external API into H2 |
| GET    | /api/recipes/search?query= | Full-text search on name and cuisine       |
| GET    | /api/recipes/{id}          | Retrieve a specific recipe by ID           |

🧪 Testing
Run unit tests using: mvn test

🙌 Author
Shri Prakash Yadav
💼 Backend Developer (Java, Spring Boot)
📧 Contact: +91 8058915391
