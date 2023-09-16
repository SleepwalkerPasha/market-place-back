FROM amazoncorretto:17
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8099
COPY build/libs/parser-0.0.1-SNAPSHOT.jar parser.jar
ENTRYPOINT ["java","-jar","parser.jar"]