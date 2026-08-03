SYSTEM DESIGN & ARCHITECTURE

# 1. Introduction

System Design defines the overall architecture and structure of the PharmaPulse application. It explains how different modules interact, how data flows through the system, and how the frontend, backend, and database work together.

# 2. System Architecture

PharmaPulse follows a Three-Tier Architecture.

Presentation Layer (Frontend)
        ↓
Business Logic Layer (Spring Boot Backend)
        ↓
Data Layer (MySQL Database)

### Frontend
- HTML
- CSS
- JavaScript

Responsibilities:
- User Interface
- Forms
- Dashboard
- Reports

### Backend
- Java Spring Boot

Responsibilities:
- Authentication
- Business Logic
- Inventory Management
- Prescription Validation
- Billing

### Database
- MySQL

Responsibilities:
- Store Users
- Store Medicines
- Store Inventory
- Store Sales
- Store Prescriptions

# 3. System Modules

## Login Module

Functions:
- Login
- Logout
- Session Management

## Dashboard Module

Functions:
- Display total medicines
- Display low stock
- Display expiry alerts
- Display daily sales

## Medicine Module

Functions:
- Add Medicine
- Update Medicine
- Delete Medicine
- Search Medicine

## Inventory Module

Functions:
- Monitor stock
- Update stock
- Low stock alert
- Expiry alert

## Prescription Module

Functions:
- Upload prescription
- Validate prescription
- Approve/Reject

## Billing Module

Functions:
- Add medicines
- Generate bill
- Update stock
- Save sales record

## Reports Module

Functions:
- Daily Sales Report
- Monthly Sales Report
- Low Stock Report
- Expiry Report

# 4. Use Case

Actors
- Admin
- Pharmacist

Admin can:
- Login
- Manage Medicines
- Manage Users
- View Reports

Pharmacist can:
- Login
- Search Medicines
- Validate Prescriptions
- Generate Bills
- Update Stock

# 5. Activity Flow

1. User Login
2. Open Dashboard
3. Search Medicine
4. Check Availability
5. Validate Prescription
6. Generate Bill
7. Update Inventory
8. Save Transaction
9. Logout

# 6. Data Flow

User
↓
Frontend
↓
Spring Boot Backend
↓
MySQL Database
↓
Backend
↓
Frontend
↓
User

# 7. Backend Structure

controller(Receives HTTP requests)

service(Contains logic)

repository(Communicates with MySQL)

entity(Java classes mapped to database tables)

dto(Transfers data between layers)

config(Application configuration)

security(Authentication and authorization)

exception(Centralized error handling)

# 8. Frontend Structure

css

js

login.html

dashboard.html

medicine.html

inventory.html

billing.html

reports.html

# 9. Advantages of the Design

- Easy maintenance
- Secure role-based access
- Faster development
- Supports future enhancements

# 10. Conclusion

The proposed system design provides a structured and scalable architecture for PharmaPulse. The modular approach improves maintainability, simplifies development, and enables future integration of advanced features such as AI-based prescription validation and barcode scanning.