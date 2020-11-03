# syntax = docker/dockerfile:1.0-experimental

# Setup environment with:
#           $Env:DOCKER_BUILDKIT=1

FROM maven:3.6.3-openjdk-11 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN --mount=type=cache,target=/root/.m2 mvn -f /usr/src/app/pom.xml clean package

FROM payara/micro:5.2020.2

COPY --from=build /usr/src/app/target/dz02.war $DEPLOY_DIR

EXPOSE 6900 8000

CMD ["--deploymentDir", "/opt/payara/deployments", "--contextroot", "ROOT", "--port", "8000"]