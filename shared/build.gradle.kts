plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val decomposeVersion = extra["decompose.version"] as String
        val decomposeRouterVersion = extra["decomposeRouter.version"] as String
        val essentyVersion = extra["essenty.version"] as String
        val ktorVersion = extra["ktor.version"] as String

        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                dependencies {
                    implementation(compose.runtime)
                    implementation(compose.foundation)
                    implementation(compose.material)
                    @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                    implementation(compose.components.resources)
                    implementation("io.github.xxfast:decompose-router:${decomposeRouterVersion}")

                    // You will need to also bring in decompose and essenty
                    implementation("com.arkivanov.decompose:decompose:${decomposeVersion}")
                    implementation("com.arkivanov.decompose:extensions-compose-jetbrains:${decomposeVersion}")
                    implementation("com.arkivanov.essenty:parcelable:${essentyVersion}")

                    implementation("io.ktor:ktor-client-core:$ktorVersion")
                    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                }
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
            }
        }
    }
}

android {
    namespace = "com.example.firstcomposemultiplatorm"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
}