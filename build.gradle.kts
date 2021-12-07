plugins {
    id("java")
    id("war")
}

group = "cz.vsb.bed0152.jat.flightreservation"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

dependencies {
    compileOnly("javax:javaee-api:8.0.1")
    compileOnly("org.projectlombok:lombok:${Lombok.version}")
    compileOnly("javax.faces:javax.faces-api:2.3")
    compileOnly("javax:javaee-api:8.0.1")

    annotationProcessor("org.projectlombok:lombok:${Lombok.version}")

    implementation("org.glassfish:javax.faces:2.3.3.102")
    implementation("com.github.adminfaces:admin-template:${AdminFaces.templateVersion}")
    implementation("org.hibernate:hibernate-core:${Hibernate.version}")
    implementation("org.hibernate.validator:hibernate-validator:${Hibernate.validatorVersion}")
    implementation("mysql:mysql-connector-java:${MySqlConnector.version}")
}