import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val kotlin_version: String by project
val logback_version = "1.4.12" // مقداردهی به متغیر logback_version

plugins {
    kotlin("jvm") version "2.1.10"
    id("io.ktor.plugin") version "3.0.3"
    id("application") // پلاگین برای ساخت برنامه قابل اجرا
    id("com.gradleup.shadow") version "8.3.5" // پلاگین Shadow
}

group = "ir.androidmaterial"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty")
    implementation("ch.qos.logback:logback-classic:$logback_version") // استفاده از متغیر logback_version
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-config-yaml")
    testImplementation("io.ktor:ktor-server-test-host")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    implementation("org.telegram:telegrambots:6.8.0") // برای ارتباط با تلگرام
    implementation("io.ktor:ktor-client-core:2.3.5")  // برای درخواست‌های HTTP
    implementation("org.web3j:core:4.9.5") // برای تعامل با بلاکچین

    implementation("io.ktor:ktor-server-host-common:2.3.5")
    implementation("io.ktor:ktor-server-status-pages:2.3.5")

    implementation("ch.qos.logback:logback-classic:1.4.12") // Logback
    implementation("org.slf4j:slf4j-api:2.0.16") // SLF4J API
}

tasks.withType<ShadowJar> {
    archiveBaseName.set("mmd-ktor-telegram") // نام فایل JAR
    archiveClassifier.set("all") // پسوند فایل (اختیاری)
    mergeServiceFiles() // ادغام فایل‌های سرویس
    manifest {
        attributes["Main-Class"] = application.mainClass.get() // کلاس اصلی از application
    }
}
