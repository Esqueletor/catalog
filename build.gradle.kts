import org.gradle.api.plugins.JavaPluginExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "2.2.21" apply false
	kotlin("plugin.spring") version "2.2.21" apply false
	id("org.springframework.boot") version "4.0.1" apply false
	id("io.spring.dependency-management") version "1.1.7" apply false
	jacoco
}

group = "com.acme"
version = "0.0.1-SNAPSHOT"

allprojects {
	repositories {
		mavenCentral()
	}
}

subprojects {

	// Aplica Java + Kotlin explícitamente
	apply(plugin = "java")
	apply(plugin = "org.jetbrains.kotlin.jvm")

	// ✅ FORMA CORRECTA EN KOTLIN DSL
	extensions.configure<JavaPluginExtension> {
		toolchain {
			languageVersion.set(JavaLanguageVersion.of(21))
		}
	}

	tasks.withType<KotlinCompile>().configureEach {
		compilerOptions {
			freeCompilerArgs.addAll(
				"-Xjsr305=strict",
				"-Xannotation-default-target=param-property"
			)
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}
