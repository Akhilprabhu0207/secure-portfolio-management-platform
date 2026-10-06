# Secure Portfolio Management Platform

Spring Boot + React + PostgreSQL portfolio application demonstrating JWT authentication, role-based access, input validation, AWS deployment architecture and cross-browser Playwright testing.

## Data flow

Browser -> React/Vite -> Spring Security/JWT -> REST API -> PostgreSQL/RDS
GitHub Actions -> build/test -> deployment artifact -> AWS EC2

## Features
- JWT login and BCrypt password hashing
- USER and ADMIN authorization
- Bean Validation and REST error handling
- Portfolio holdings CRUD
- PostgreSQL/JPA
- Playwright Chromium, Firefox and WebKit
- Docker Compose local database
- AWS EC2 + RDS deployment guide
- GitHub Actions CI

## Local setup
Requires Java 21, Node 20 and Docker.

    docker compose up -d postgres
    cd backend && mvn spring-boot:run
    cd ../frontend && npm install && npm run dev

API: http://localhost:8080
UI: http://localhost:5173

## Tests

    cd backend && mvn test
    cd ../frontend && npm install && npx playwright install --with-deps && npm test

## Security
JWT secrets and database credentials come from environment variables. Production should use AWS Secrets Manager or SSM, HTTPS, restricted security groups and least-privilege database credentials.

## AWS
See docs/aws.md. The intended deployment is Linux EC2 for the application and private PostgreSQL RDS for persistence.
