# Java5Exam
Spring boot project for Java 5 exam

Simulates a library RESTful API

## Endpoint: 

| POST | http://localhost:8080/ | api/authors |  | -> create a new author |
| GET | http://localhost:8080/ | api/authors |  | -> get general information about all authors |
| GET | http://localhost:8080/ | api/authors | {id} | -> get detailed information about an author |

| POST | http://localhost:8080/ | api/books |  | -> create a new book |
| GET | http://localhost:8080/ | api/books |  | -> get general information about all books |
| GET | http://localhost:8080/ | api/authors | {id} | -> get detailed information about a book |
| PUT | http://localhost:8080/ | api/authors | {id} | -> update an author |
| DELETE | http://localhost:8080/ | api/authors | {id} | -> delete an existing author |

## Getting Started

### Prerequisites

1. **Java Development Kit (JDK)**

    ```bash
    # Ubuntu/Debian
    sudo apt install openjdk-21-jdk
    
    # Verify installation
    java --version  # Should show 21.0.x
    ```

2. **PostgreSQL**

    ```bash
    # Ubuntu/Debian
    sudo apt update
    sudo apt install postgresql postgresql-contrib
    
    # Start PostgreSQL service
    sudo service postgresql start
    ```

3. **Maven**

    ```bash
    # Ubuntu/Debian
    sudo apt install maven
    
    # Verify installation
    mvn --version
    ```

### Dependencies

The project uses the following dependencies:

- Spring Boot Parent (v3.4.1)

- Spring Boot Web Starter
- Spring Data JPA Starter
- Spring Boot Validation Starter
- PostgreSQL Driver
- Lombok

Add these to your `pom.xml`:

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.4.1</version>
</parent>

<dependencies>
    <!-- Spring Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- Validation -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    
    <!-- PostgreSQL Driver -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>
    
    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

### Database Setup

#### User and Database

Connect as postgres superuser:

```bash
sudo -u postgres psql
```

Create the developer user and the databases:

```postgresql
CREATE USER examdev WITH PASSWORD 'exam';
CREATE DATABASE examdb OWNER examdev;
```

> Names given here are important because they should match `application.properties` files

#### Tables

- Connect to LudoNexus Database as LudoNexus Developer user:

    ```postgresql
    \connect postgresql://examdev:exam@localhost:5432/examdb
    ```
  
- Create players and friendships tables:

    Using application property "hibernate ddl" set to "create-drop"


## Improvement to come

- Allow user to link an author to a book
