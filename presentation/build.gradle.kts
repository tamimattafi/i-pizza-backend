group = "com.tamimattafi.pizza.backend"
version = "0.0.1-SNAPSHOT"
java.targetCompatibility = JavaVersion.VERSION_16

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.5.5")
    implementation(project(":domain"))
}