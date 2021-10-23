plugins {
    kotlin("jvm") version "1.5.31"
}

tasks.create("prepareKotlinBuildScriptModel") {
    //workaround to fix build error in gradle 7.0
}