FROM maven:3.8-jdk-11 AS builder

WORKDIR /app
COPY . .
RUN mvn --file=transactions-jpa-service/pom.xml clean package

FROM mxi0200913a/wildfly-server:latest AS final
COPY --from=builder /app/transactions-jpa-service/target/transactions-jpa-service.war /opt/deployments/transactions-jpa-service.war
COPY scripts/jndi.cli /opt/resources/jndi.cli
COPY scripts/install.sh /opt/resources/install.sh