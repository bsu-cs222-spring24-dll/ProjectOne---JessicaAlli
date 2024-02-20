plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.testng:testng:7.1.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("org.slf4j:slf4j-simple:1.7.36")
    implementation("org.json:json:20210307")
    implementation("net.minidev:json-smart:2.5.0")

}

tasks.test {
    useJUnitPlatform()
}