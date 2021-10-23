apply(plugin = "org.springframework.boot")
apply(plugin = "io.spring.dependency-management")
apply(plugin = "org.jetbrains.kotlin.plugin.spring")

group = "com.tamimattafi.pizza.backend"
version = "0.0.1-SNAPSHOT"
java.targetCompatibility = JavaVersion.VERSION_16

dependencies {
    //SPRING BOOT
    implementation("org.springframework.boot:spring-boot-starter-security:2.5.5")
    implementation("org.springframework.boot:spring-boot-starter-web:2.5.5")
    implementation("org.springframework.boot.experimental:spring-boot-starter-data-r2dbc:0.1.0.M3")

    //KOTLIN
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    //MYSQL
    implementation("dev.miku:r2dbc-mysql:0.8.2.RELEASE")
    implementation("io.r2dbc:r2dbc-pool:0.8.7.RELEASE")
    runtimeOnly("mysql:mysql-connector-java:8.0.25")

    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))
}