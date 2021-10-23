plugins {
	id("org.springframework.boot") version "2.5.6" apply false
	id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
	kotlin("jvm") version "1.5.31" apply false
	kotlin("plugin.spring") version "1.5.31" apply false
}

repositories {
	mavenCentral()
	maven(url = "https://repo.spring.io/milestone")
}

subprojects {
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
  apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	group = "com.tamimattafi.pizza.backend"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
		maven(url = "https://repo.spring.io/milestone")
	}

	tasks.create("prepareKotlinBuildScriptModel") {
		//workaround to fix build error in gradle 7.0
	}

	tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
		kotlinOptions {
			jvmTarget = "1.8"
		}
	}
}