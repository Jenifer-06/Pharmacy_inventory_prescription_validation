Software Requiremets Specification(SRS)

   1. Introduction :
   The Pharmacy Inventory & Prescription Validation Platform enables pharmacists to manage medicine inventory, validate prescriptions, monitor stock levels efficiently. The system aims to reduce manual work and improve accuracy.
   
   2. Purpose :
   The purpose of this system is to automate pharmacy management by providing a centralized platform for inventory tracking, prescription validation, billing, and reporting. It helps pharmacists serve customers faster while maintaining accurate inventory records.
   
   3. Scope :
   The system will:
       Manage medicine inventory.
       Validate prescriptions.
       Track medicine stock and expiry dates.
       Produce sales and inventory reports.

   4. Functional Requirements :
   1- User Authentication :
        Secure login for Admin and Pharmacist.
        Role-based access control.
   2- Medicine Management :
        Add medicines.
        Update medicine details.
        Delete medicines.
        Search medicines.
   3- Inventory Management :
        Update stock.
        View available stock.
        Display low-stock alerts.
        Track expiry dates.
   4- Prescription Validation :
        Upload prescription details.
        Verify medicine availability.
        Check expiry status.
        Display validation results.
   5- Billing :
        Generate invoices.
        Calculate total amount.
        Save transaction history.
   6- Reports :
        Daily sales report.
        Monthly sales report.
        Low-stock report.
        Expired medicine report.

   5. Non-Functional Requirements :
        Secure authentication.
        Fast response time.
        User-friendly interface.
        Reliable database.
        Scalable architecture.
        Data backup support.

   6. Assumptions :
        Pharmacy staff have valid login credentials.
        Medicine data is entered correctly.
        Stable internet connection is available.
        The database server is operational.

   7. Constraints :
        Web application only.
        Uses MySQL as the database.
        Requires Java and Spring Boot for the backend.
        Requires React.js for the frontend.

   8. Expected Outcome :
        The system should improve pharmacy efficiency, reduce manual errors, ensure better inventory control, and provide accurate prescription validation and reporting.
   