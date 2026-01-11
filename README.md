# Contact List

Spring Boot + React application.

## Backend
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- **Liquibase** (for database schema management and initial data import)

## Frontend
- React

## Configuration

Database credentials are provided via environment variables:

- DB_URL
- DB_USERNAME
- DB_PASSWORD

See `application.properties.example` for details.

Liquibase configuration:

- Change logs are located in `backend/src/main/resources/db/changelog/db.changelog-master.xml`.
- Initial schema creation and CSV-based data import are versioned via Liquibase.
- `ddl-auto` is disabled in `application.properties` (`spring.jpa.hibernate.ddl-auto=none`) because Liquibase manages schema updates.

## Running locally

### Backend
```bash
mvn spring-boot:run