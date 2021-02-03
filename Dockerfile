FROM openjdk:11
EXPOSE 8086
ARG JAR_FILE=build/libs/chatweaver.jar
ADD ${JAR_FILE} chatweaver.jar

ARG lombokjar=lombok.jar
ADD https://projectlombok.org/downloads/${lombokjar} lombok.jar


ENTRYPOINT ["java","-jar","/chatweaver.jar"]
# Make sure only 1 jar file is assembled
#RUN test $(find ./build/libs -type f -name '*.jar' | wc -l) -eq 1
