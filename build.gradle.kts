import org.jetbrains.kotlin.gradle.dsl.JvmTarget.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "3.0.1"
  id("io.spring.dependency-management") version "1.1.0"
  id("org.graalvm.buildtools.native") version "0.9.19"
  kotlin("jvm") version "1.8.0"
  kotlin("plugin.spring") version "1.8.0"
  id("com.github.ben-manes.versions") version "0.44.0"
  id("nl.littlerobots.version-catalog-update") version "0.7.0"
}

group = "dev.suresh"

version = "0.0.1"

java.sourceCompatibility = JavaVersion.VERSION_19

repositories { mavenCentral() }

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.springframework.security:spring-security-test")
}

tasks {
  withType<KotlinCompile> {
    compilerOptions {
      jvmTarget.set(JVM_19)
      freeCompilerArgs.addAll("-Xjsr305=strict")
    }
  }

  graalvmNative { metadataRepository { enabled.set(true) } }
  withType<Test> { useJUnitPlatform() }
}
