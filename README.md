The Hotel Booking System is a Java-based application designed to manage room bookings for a hotel. It allows for customer profile creation, room management, and booking transactions. The system includes features for adding new bookings and displaying booking details.

### Technical Specifications:
- **Programming Language:** Java
- **Database:** MySQL
- **External Libraries:** JDBC (for database integration) and GUI library (for graphical user interface)

### Key Features and Implementation:
1. **Classes and Objects:**
   - **Customer:** Represents hotel customers.
   - **Room:** Represents hotel rooms.
   - **Booking:** Links customers to rooms for specific dates and durations.

2. **Inheritance:** 
   - **Person (abstract class):** Common attributes for **Customer** and **Employee** classes.
   - **Customer & Employee:** Extend **Person**.

3. **Method Overriding:** 
   - Methods like `toString()` are customized for subclasses.

4. **Polymorphism:** 
   - The **Person** class allows handling of both **Customer** and **Employee** objects through a common interface.

5. **Design Patterns:**
   - **Singleton Pattern:** Used in **BookingManager** to manage all booking operations via a single instance.
   - **Factory Pattern:** Used in **RoomFactory** to create room objects based on type.

6. **Collections:** 
   - Uses **ArrayList** and **HashMap** for managing rooms and bookings.

7. **Error Handling:** 
   - SQL exceptions are managed with try-catch blocks.

8. **Interfaces:**
   - **IHotelService Interface:** Defines common hotel operations for the **BookingManager**.

### Database Integration:
- **MySQL:** Stores data about customers, rooms, and bookings.
- **JDBC:** Connects to the database, executes queries, and handles transactions.

### External Libraries:
- **JDBC API:** For database operations.
- **GUI Library:** For the graphical user interface.

### Conclusion:
The **Hotel Booking System** integrates object-oriented programming principles with practical hotel management features, demonstrating solid design patterns and real-world applicability. It combines theoretical concepts with a functional, robust software solution for hotel management.
