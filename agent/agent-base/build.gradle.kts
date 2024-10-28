plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.icode.eleven"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.javassist:javassist:3.25.0-GA")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks {
    shadowJar {
        manifest {
            attributes.put("Main-Class", "com.icode.eleven.PreAgentMain")
            attributes.put("Agent-Class", "com.icode.eleven.PreAgentMain")
            attributes.put("Premain-Class", "com.icode.eleven.PreAgentMain")
            attributes.put("Can-Redefine-Classes", "true")
            attributes.put("Can-Retransform-Classes", "true")
        }

        dependsOn(assemble)
    }
//    jar {
//        manifest {
//            attributes.put("Main-Class", "com.icode.eleven.PreAgentMain")
//            attributes.put("Agent-Class", "com.icode.eleven.PreAgentMain")
//            attributes.put("Premain-Class", "com.icode.eleven.PreAgentMain")
//            attributes.put("Can-Redefine-Classes", "true")
//            attributes.put("Can-Retransform-Classes", "true")
//        }
//    }
}



