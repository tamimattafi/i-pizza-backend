apply(plugin = "org.springframework.boot")
apply(plugin = "io.spring.dependency-management")

group = "com.tamimattafi.pizza.backend"
version = "0.0.1-SNAPSHOT"
java.targetCompatibility = JavaVersion.VERSION_16

dependencies {
    implementation("org.springframework.boot.experimental:spring-boot-starter-data-r2dbc:0.1.0.M3")
    implementation(project(":domain"))
}