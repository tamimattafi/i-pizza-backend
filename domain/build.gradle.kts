plugins {
    kotlin("jvm") version "1.5.31"
}

group = "com.tamimattafi.pizza.backend"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_16

tasks.create("prepareKotlinBuildScriptModel") {
    //workaround to fix build error in gradle 7.0
}