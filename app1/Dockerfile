# our base build image
FROM maven:3.8.1-openjdk-17-slim AS builder

# copy the project files
COPY ./pom.xml ./pom.xml

# build all dependencies
RUN mvn dependency:go-offline -B

# copy your other files
COPY ./src ./src

# build for release
RUN mvn package


FROM eclipse-temurin:17-jre AS runner

# Install Extra Packages
RUN apt-get update \
    && apt-get install -y jq bash bc ca-certificates curl \
    && update-ca-certificates

#Env Sentry authen token
#ENV SENTRY_AUTH_TOKEN=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
# Copy jar file over from builder stage
ENV JAR_NAME=app1-0.0.1-SNAPSHOT.jar
COPY --from=builder target/$JAR_NAME ./app.jar

ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar ./app.jar" ]