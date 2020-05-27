FROM gradle:4.7.0-jdk8-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
COPY ./src/ /src
COPY ./gradle/ /gradle
RUN gradle build

FROM bde2020/spark-submit:2.4.5-hadoop2.7 as spark-submit

ENV SPARK_APPLICATION_JAR_NAME spark_application
ENV SPARK_APPLICATION_MAIN_CLASS data_application.Runner
COPY --from=build /home/gradle/src/build/libs/*.jar /app/spark_application.jar
WORKDIR /app
COPY ./docker/run.sh /app/

CMD ["/bin/bash", "run.sh"]