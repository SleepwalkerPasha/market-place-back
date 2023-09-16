FROM amazoncorretto:17
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8087
COPY build/libs/baggins-0.0.1-SNAPSHOT.jar baggins.jar
ENTRYPOINT ["java","-jar","baggins.jar"]