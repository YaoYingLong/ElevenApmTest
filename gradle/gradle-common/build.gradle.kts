plugins {
    id("java")
}

group = "com.icode.eleven"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}


task("hello") {
    doLast {
        println("Hello world!!  eleven")
    }
}

task("upper") {
    doLast {
        val someString:String = "mY_nAmE"
        println("Original: " + someString)
        println("Upper case: " + someString.toUpperCase())
    }
}

// 任务依赖
task("intro") {
    doLast {
        println("I'm Gradle")
        dependsOn("hello")
    }
}

// Lazy dependsOn - 其他的任务还没有存在，必须加上单引号

task("taskY") {
    doLast {
        println("I'm taskY")
    }
}

task("taskX") {
    doLast {
        println("I'm taskX")
    }
}

// 定义一个函数，用于创建动态的Gradle任务
fun createDynamicTask(taskName: String, group: String, description: String) {
    // 注册一个新的任务
    tasks.register(taskName) {
        // 在这里可以添加更多的配置和行为
        doLast {
            println("执行动态创建的任务: $taskName")
        }
    }
}

// 在初始化阶段调用该函数创建任务
tasks.register("initializeDynamicTasks") {
    doLast {
        // 根据需要动态创建任务
        listOf("task1", "task2", "task3").forEach {
            createDynamicTask(it, "custom", "自定义任务: $it")
        }
    }
}

task("clean2") {
    doLast {
        println("Default Cleaning!")
    }
}

task("run2") {
    doLast {
        println("Default Running!")
    }
}
task("other2") {
    doLast {
        println("I'm not a default task!")
    }
}

task("distribution") {
    doLast {
        println("We build the zip with version=$version")
    }
}
