# 💰 FinTrack – Personal Finance Management System

A secure and modern full-stack finance tracking application built using React and Spring Boot. FinTrack helps users manage income, expenses, and financial transactions with real-time analytics and an interactive dashboard.

---

## 🚀 Features

### 🔐 Authentication & Security

- JWT-based Authentication
- Secure Login & Registration
- Password Encryption with BCrypt
- Protected REST APIs using Spring Security
- User-specific transaction access

### 📊 Dashboard & Analytics

- Total Balance Overview
- Income & Expense Tracking
- Interactive Expense Charts
- Category-wise Analytics
- Recent Transaction History

### 💳 Transaction Management

- Add Transactions
- Delete Transactions
- View All Transactions
- Categorize Income & Expenses
- Real-time Financial Insights

---

## 🛠️ Tech Stack

### Frontend

- React.js
- React Router
- Axios
- Tailwind CSS
- Recharts

### Backend

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT Authentication

### Database

- MySQL

### Tools

- Postman
- Git & GitHub
- IntelliJ IDEA
- VS Code

---

## 📁 Project Structure

```bash
FinTrack/
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── entity/
│   ├── dto/
│   ├── config/
│   └── security/
│
├── frontend/
│   ├── components/
│   ├── pages/
│   ├── services/
│   ├── routes/
│   └── assets/
│
└── README.md
```

---

## ⚙️ Backend Setup

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/fintrack.git
cd fintrack
```

### 2️⃣ Configure MySQL Database

Create a database:

```sql
CREATE DATABASE finance_db;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3️⃣ Run the Backend Server

```bash
cd backend
mvn spring-boot:run
```

Backend runs at:

```bash
http://localhost:8080
```

---

## 🎨 Frontend Setup

### 1️⃣ Install Dependencies

```bash
cd frontend
npm install
```

### 2️⃣ Start Development Server

```bash
npm run dev
```

Frontend runs at:

```bash
http://localhost:5173
```

---

## 🔑 JWT Authentication Flow

1. User registers or logs in
2. Backend validates credentials
3. JWT token is generated
4. Token is sent to frontend
5. Frontend stores token securely
6. Protected API requests use:

```http
Authorization: Bearer <token>
```

---

## 📡 API Endpoints

### Authentication APIs

| Method | Endpoint         | Description   |
| ------ | ---------------- | ------------- |
| POST   | `/auth/register` | Register User |
| POST   | `/auth/login`    | Login User    |

### Transaction APIs

| Method | Endpoint                  | Description        |
| ------ | ------------------------- | ------------------ |
| GET    | `/api/transactions`       | Fetch Transactions |
| POST   | `/api/transactions`       | Add Transaction    |
| DELETE | `/api/transactions/{id}`  | Delete Transaction |

---

## 📦 Sample Transaction JSON

```json
{
  "title": "Salary",
  "amount": 50000,
  "type": "INCOME",
  "category": "Job"
}
```

---

## 🔒 Spring Security Configuration

The backend security layer includes:

- JWT Authentication Filter
- Security Filter Chain
- BCrypt Password Encoder
- Authentication Manager
- Route Authorization

Example:

```java
.requestMatchers("/api/**").authenticated()
```

---

## 📈 Dashboard Components

### 💵 Top Cards

Displays:

- Total Balance
- Total Income
- Total Expenses

### 📊 Expense Chart

Visual representation of expense trends.

### 🥧 Circle Chart

Displays category-wise spending analytics.

### 💳 Recent Transactions

Shows latest user transaction history.

---

## 🌐 CORS Configuration

```java
@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }
}
```

---

## 🚀 Deployment

### Frontend

- Vercel
- Netlify

### Backend

- Render
- Railway
- AWS

---

## 🔮 Future Improvements

- Budget Planning Module
- Export Reports (PDF/Excel)
- Email Notifications
- Recurring Transactions
- AI-powered Expense Insights
- Multi-Currency Support
- Docker Deployment
- Mobile Responsiveness Improvements

---

## 📸 Screenshots

Add your project screenshots inside:

```bash
/frontend/screenshots
```

Example:

- Dashboard Page
- Login Page
- Expense Analytics
- Transaction History

---

## 🧠 Learning Outcomes

This project helped in understanding:

- Full Stack Development
- REST API Development
- Spring Security
- JWT Authentication
- React State Management
- Database Integration
- Secure Authentication Systems
- Dashboard UI Design

---

## 👨‍💻 Author

### Mohamed Fazil

- Full Stack Developer
- Java & Spring Boot Enthusiast
- React Developer

GitHub:

```bash
https://github.com/MohamedFazil1406
```

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub.

---

## 📄 License

This project is licensed under the MIT License.
