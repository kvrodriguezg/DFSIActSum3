FROM openjdk:17-oracle

WORKDIR /app
COPY target/exp3_s8_katlheen_rodriguez-0.0.1-SNAPSHOT.jar app.jar
COPY Wallet_QDFT58GMUP87U6WS /app/oracle_wallet
EXPOSE 9090

CMD ["java","-jar","app.jar"]