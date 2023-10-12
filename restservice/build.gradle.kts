plugins {
    id("org.springframework.boot") version "3.1.3"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.9.0"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework:spring-web:6.0.12")
    implementation ("org.apache.httpcomponents.client5:httpclient5:5.1.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.3")
    testImplementation("org.testcontainers:junit-jupiter")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
    implementation(project(":common-utils"))
}