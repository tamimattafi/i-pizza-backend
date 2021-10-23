plugins {
	id("org.springframework.boot") version "2.5.6"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.31"
	kotlin("plugin.spring") version "1.5.31"
}

group = "com.tamimattafi.pizza.backend"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_16

repositories {
	mavenCentral()
	maven(url = "https://repo.spring.io/milestone")
}

dependencies {
	//SPRING BOOT
	implementation("org.springframework.boot:spring-boot-starter-security:2.5.5")
	implementation("org.springframework.boot:spring-boot-starter-web:2.5.5")
	implementation("org.springframework.boot.experimental:spring-boot-starter-data-r2dbc")

	//KOTLIN
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	//СO-ROUTINES
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.5.2")

	//MYSQL
	implementation("dev.miku:r2dbc-mysql:0.8.2.RELEASE")
	implementation("io.r2dbc:r2dbc-pool:0.8.7.RELEASE")
	runtimeOnly("mysql:mysql-connector-java:8.0.25")

	//TEST
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.5") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}

	testImplementation("org.springframework.security:spring-security-test:5.5.1")
	testImplementation("io.projectreactor:reactor-test:3.4.11")
	testImplementation("org.springframework.boot.experimental:spring-boot-test-autoconfigure-r2dbc")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.boot.experimental:spring-boot-bom-r2dbc:0.1.0.M3")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}