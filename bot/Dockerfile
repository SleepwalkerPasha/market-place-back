FROM amazoncorretto:17
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8081
COPY build/libs/bot-0.0.1-SNAPSHOT.jar bot.jar
ENTRYPOINT ["java","-jar","bot.jar"]