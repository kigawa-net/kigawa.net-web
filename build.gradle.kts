plugins {
    id("java")
    id("org.springframework.boot") version "3.0.0-M2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "net.kigawa"
version = "1.0dev"
java.sourceCompatibility =  JavaVersion.VERSION_17

repositories {
    mavenCentral()

    maven("https://repo.spring.io/milestone")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}