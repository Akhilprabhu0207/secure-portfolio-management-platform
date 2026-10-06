# AWS EC2 + RDS deployment

1. Create PostgreSQL RDS in private subnets.
2. Create a Linux EC2 host for the Spring Boot service.
3. Permit RDS 5432 only from the EC2 security group.
4. Store DATABASE_URL, credentials and JWT_SECRET in SSM Parameter Store or Secrets Manager.
5. Run the JAR with systemd on EC2.
6. Put Nginx or an ALB in front and enforce HTTPS.
7. Use GitHub OIDC with an IAM deployment role instead of long-lived AWS keys.

This repository contains deployment configuration and documentation; it does not claim an AWS deployment has already been performed.