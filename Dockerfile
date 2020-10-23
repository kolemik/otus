FROM maven:3.6.3-openjdk-11 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM payara/micro:5.2020.2

COPY --from=build /usr/src/app/target/dz01.war $DEPLOY_DIR

EXPOSE 6900 8000

CMD ["--deploymentDir", "/opt/payara/deployments", "--contextroot", "ROOT", "--port", "8000"]