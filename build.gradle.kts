plugins {
	kotlin("jvm") version "1.5.31"
	kotlin("plugin.spring") version "1.5.31"
	id("org.springframework.boot") version "2.5.6"
}

repositories {
	mavenCentral()
	maven(url = "https://repo.spring.io/milestone")
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