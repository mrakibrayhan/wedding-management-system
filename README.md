# Wedding Management System

A console-based **Wedding Management System** written in Java. It lets clients plan and book a wedding package (venue, food, and decoration, with an optional photographer add-on) across three regions of Bangladesh, while admins manage employees and staff teams behind the scenes.

## Features

**Login System**
- User registration and login before accessing the main system

**Admin Panel**
- Add, remove, and list employees (Part-Time / Full-Time)
- Create staff teams by pairing two employee IDs

**Client Panel**
- Register client details (name, phone, email, NID)
- Enter a wedding budget (minimum 200,000 Taka required to proceed)
- Choose a region: **Dhaka**, **Chattogram**, or **Sylhet**
- Each region offers its own:
  - Venue options with cost
  - Food packages with per-guest pricing
  - Decoration packages with cost
- Optional photographer add-on (+50,000 Taka)
- Automatic total cost calculation and booking confirmation
- Invalid budgets are rejected via a custom `InvalidBudget` exception

**Persistence**
- Client details and bookings are logged to file via `ClientFileReadWrite`
- Employee records are logged to file via `EmployeeFileReadWrite`

## Project Structure

```
src/
├── Start.java                     # Entry point: login + main menu (Admin / Client)
├── InvalidBudget.java              # Custom exception for insufficient budget
├── classes/
│   ├── Person.java                 # Base class (name, phone number)
│   ├── Client.java                 # Client details (extends Person)
│   ├── Employee.java                # Employee details (extends Person)
│   ├── Admin.java                   # Admin operations (employees, teams)
│   ├── Dhaka.java                   # Dhaka region packages & pricing
│   ├── Chattogram.java              # Chattogram region packages & pricing
│   └── Sylhet.java                  # Sylhet region packages & pricing
├── fileio/
│   ├── ClientFileReadWrite.java     # Read/write client & booking records
│   └── EmployeeFileReadWrite.java   # Read/write employee records
└── interfaces/
    ├── Team.java                    # Team-creation contract
    └── EmployeeOperations.java      # Employee management contract
```

## Requirements

- Java JDK 8 or later

## Build & Run

```bash
cd src
javac Start.java classes/*.java fileio/*.java interfaces/*.java InvalidBudget.java
java Start
```

## Usage Flow

1. **Register** a username/password, then **Login**.
2. Choose **Admin** or **Client**:
   - **Admin**: enter admin credentials, then manage employees and teams.
   - **Client**: enter your details, enter your budget (≥ 200,000 Taka), pick a region, and select venue/food/decoration options to get a final cost and booking confirmation.
3. Choose **Exit** to close the program.

## Project Type

Academic Java project demonstrating object-oriented design (inheritance, interfaces, custom exceptions) and file I/O for a console-based booking system.
