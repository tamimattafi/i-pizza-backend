plugins {
	kotlin("jvm") version "1.5.31" apply false
	kotlin("plugin.spring") version "1.5.31" apply false
	id("org.springframework.boot") version "2.5.6" apply false
	id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
}

buildscript {
	repositories {
		mavenCentral()
		maven(url = "https://repo.spring.io/milestone")
	}

	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
	}
}

subprojects {
  apply(plugin = "org.jetbrains.kotlin.jvm")

	repositories {
		mavenCentral()
		maven(url = "https://repo.spring.io/milestone")
	}

	tasks.create("prepareKotlinBuildScriptModel") {
		//workaround to fix build error in gradle 7.0
	}

	tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
		kotlinOptions {
			jvmTarget = "16"
		}
	}
}