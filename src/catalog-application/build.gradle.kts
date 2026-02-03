plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":catalog-domain"))
    testImplementation(kotlin("test"))
}
