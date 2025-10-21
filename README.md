# 📚 Library API

A simple RESTful API built with **Spring Boot** to manage books, authors, and categories in a library.

---

## 🚀 Features
- CRUD operations for:
  - Books (`/books`)
  - Authors (`/authors`)
  - Categories (`/categories`)
- Relationships:
  - Each book belongs to one author and one category.
  - Each author and category can have many books.

---

## 🧩 Domain Models

### Author
- `id`: Long  
- `name`: String  
- `email`: String  
- `nacionality`: String  
- `books`: List\<Book>

### Book
- `id`: Long  
- `title`: String  
- `publicationYear`: Integer  
- `price`: BigDecimal  
- `category`: Category  
- `author`: Author  

### Category
- `id`: Long  
- `name`: String  
- `description`: String  
- `books`: List\<Book>

---

## 🌐 Endpoints

### 📘 Books
| Method | Endpoint | Description |
|--------|-----------|-------------|
| GET | `/books` | Get all books |
| POST | `/books` | Create a new book |
| PUT | `/books/{id}` | Update a book |
| DELETE | `/books/{id}` | Delete a book |

### 🧑‍💼 Authors
| Method | Endpoint | Description |
|--------|-----------|-------------|
| GET | `/authors` | Get all authors |
| POST | `/authors` | Create a new author |
| PUT | `/authors/{id}` | Update an author |
| DELETE | `/authors/{id}` | Delete an author |

### 🏷️ Categories
| Method | Endpoint | Description |
|--------|-----------|-------------|
| GET | `/categories` | Get all categories |
| POST | `/categories` | Create a new category |
| PUT | `/categories/{id}` | Update a category |
| DELETE | `/categories/{id}` | Delete a category |

---

🧱 Tech Stack
Java 21
Spring Boot 3
Spring Data JPA / Hibernate
Lombok
Postgree

--- 

📄 License
MIT License.

--- 
👨‍💻 Author: Hugo Bezerra Figueiroa
