# 🏠 Rent House Management System - Spring Boot Backend

This project is a Spring Boot REST API backend for a Rent House Management System. It provides APIs for managing **Users**, **Properties**, **Locations**, **Rentals**, and **Payments**. The application connects to a PostgreSQL database.

## 🚀 Base URL

http://localhost:8080/api/admin/


---

## 📦 API Endpoints

### 📍 Location APIs

**POST** `/locations/createLocation`  
Create a new location.

```json
{
  "district": "Banadir",
  "city": "Mogadishu",
  "address": "Km4, Hodan"
}

GET /locations/getAll
Get all locations.

GET /locations/getById/{id}
Get a location by ID.

PUT /locations/{id}
Update a location.
{
  "district": "Banadir",
  "city": "Mogadishu",
  "address": "Km4, Hodan"
}

DELETE /locations/{id}
Delete a location.

👤 User APIs
POST /create-user
Create a new user.
{
  "fullName": "Ibra Loyza",
  "email": "ibra@example.com",
  "password": "123456",
  "role": "TENANT"
}
GET /get-All-Users
Get all users.

GET /{id}
Get user by ID.

PUT /update/{id}
Update user by ID.

{
  "name": "Ali Ahmed",
  "email": "ali.ahmed@example.com",
  "password": "newPassword",
  "role": "TENANT"
}
DELETE /{id}
Delete user.

🏘️ Property APIs
POST /property/create-property
Create a new property.

{
  "title": "Modern Apartment",
  "description": "2-bedroom apartment near the city center.",
  "price": 500.0,
  "category": "RENT",
  "propertyType": "APARTMENT",
  "userId": 1,
  "locationId": 2
}

GET /property/getAll
Get all properties.

GET /property/{id}
Get property by ID.

PUT /property/update/{id}
Update property.

{
  "title": "Updated Apartment",
  "description": "Updated description",
  "price": 550.0,
  "category": "RENT",
  "propertyType": "APARTMENT"
}

DELETE /property/{id}
Delete property.

🏠 Rental APIs
POST /rentals/create-rental
Create a rental.
{
  "propertyId": 1,
  "tenantId": 2,
  "startDate": "2025-08-01",
  "endDate": "2026-08-01",
  "status": "ACTIVE"
}

GET /rentals/getAll
Get all rentals.

GET /rentals/{id}
Get rental by ID.

PUT /rentals/update/{id}
Update a rental.
{
  "propertyId": 1,
  "tenantId": 2,
  "startDate": "2025-08-01",
  "endDate": "2026-12-01",
  "status": "ACTIVE"
}

DELETE /rentals/delete/{id}
Delete a rental.

💳 Payment APIs
POST /payments/createPayment
Create a payment.
{
  "rentalId": 1,
  "amount": 750.0,
  "paymentDate": "2025-07-23",
  "status": "PAID",
  "paymentMethod": "CREDIT_CARD",
  "referenceId": "TXN12345"
}
GET /payments/getAll
Get all payments.

GET /payments/getById/{id}
Get payment by ID.

DELETE /payments/delete/{id}
Delete payment.

⚙️ Technologies Used
Java 17+

Spring Boot

PostgreSQL

Spring Data JPA

Lombok

-------------------------------------------------------------------------------------------------
http://localhost:8080/api/admin/

---

## 📦 API Endpoints

---

### 🔹 User API

| Method | Endpoint               | Description         |
|--------|------------------------|---------------------|
| POST   | `/create-user`         | Create a new user   |
| GET    | `/get-All-Users`       | Get all users       |
| GET    | `/{id}`                | Get user by ID      |
| PUT    | `/update/{id}`         | Update user by ID   |
| DELETE | `/{id}`                | Delete user by ID   |

---

### 🔹 Property API

| Method | Endpoint                    | Description           |
|--------|-----------------------------|-----------------------|
| POST   | `/property/create-property` | Create a property     |
| GET    | `/property/getAll`          | Get all properties    |
| GET    | `/property/{id}`            | Get property by ID    |
| PUT    | `/property/update/{id}`     | Update property       |
| DELETE | `/property/{id}`            | Delete property       |

> RequestBody for POST: `PropertyRequestDTO`  
> RequestBody for PUT: `Property`

---

### 🔹 Location API

| Method | Endpoint                    | Description          |
|--------|-----------------------------|----------------------|
| POST   | `/locations/createLocation` | Create a location    |
| GET    | `/locations/getAll`         | Get all locations    |
| GET    | `/locations/getById/{id}`   | Get location by ID   |
| PUT    | `/locations/{id}`           | Update location      |
| DELETE | `/locations/{id}`           | Delete location      |

> RequestBody for POST/PUT: `Location`

---

### 🔹 Rental API

| Method | Endpoint                     | Description          |
|--------|------------------------------|----------------------|
| POST   | `/rentals/create-rental`     | Create a rental      |
| GET    | `/rentals/getAll`            | Get all rentals      |
| GET    | `/rentals/{id}`              | Get rental by ID     |
| PUT    | `/rentals/update/{id}`       | Update rental        |
| DELETE | `/rentals/delete/{id}`       | Delete rental        |

> RequestBody for POST/PUT: `RentalRequestDTO`

---

### 🔹 Payment API

| Method | Endpoint                     | Description           |
|--------|------------------------------|-----------------------|
| POST   | `/payments/createPayment`    | Create a payment      |
| GET    | `/payments/getAll`           | Get all payments      |
| GET    | `/payments/getById/{id}`     | Get payment by ID     |
| DELETE | `/payments/delete/{id}`      | Delete payment        |

> RequestBody for POST: `PaymentRequestDTO`  
> ResponseBody: `PaymentResponseDTO`

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Web
- PostgreSQL
- Lombok

---

## 🧪 Testing the APIs

You can use **Postman**, **Insomnia**, or any HTTP client to test these endpoints.

Ensure your Spring Boot app is running and your PostgreSQL database is correctly configured.

---

## 📝 Authors

- Developed by: `ibrahim hassan ahmed`
- GitHub: [your-github-profile](https://github.com/your-github-profile)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.





