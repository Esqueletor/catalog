plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.openapi.generator")
}

dependencies {
    implementation(project(":catalog-application"))
    implementation(project(":catalog-infrastructure"))
    implementation(project(":catalog-domain")) // 👈 necesario para wiring

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
    implementation("org.openapitools:jackson-databind-nullable:0.2.6")

    testImplementation(kotlin("test"))
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.2.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

openApiGenerate {
    generatorName.set("spring")
    inputSpec.set("$projectDir/src/main/resources/openapi/catalog-api.yaml")
    outputDir.set("$buildDir/generated")
    apiPackage.set("com.acme.catalog.api.generated")
    modelPackage.set("com.acme.catalog.api.generated.model")

    configOptions.set(
        mapOf(
            "interfaceOnly" to "true",
            "delegatePattern" to "true",
            "useSpringBoot3" to "true"
        )
    )
}

sourceSets["main"].java {
    srcDir("$buildDir/generated/src/main/java")
}

tasks.named("compileKotlin") {
    dependsOn("openApiGenerate")
}