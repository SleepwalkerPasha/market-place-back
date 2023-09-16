FROM amazoncorretto:17
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8090
COPY build/libs/restservice-0.0.1-SNAPSHOT.jar restservice.jar
ENTRYPOINT ["java","-jar","restservice.jar"]