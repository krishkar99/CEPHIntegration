plugins {
	java
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.openapi.generator") version "7.1.0"
	id("com.diffplug.spotless") version "6.25.0"
}

group = "com.cephintegration"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(19)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-jersey")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("javax.validation:validation-api:2.0.1.Final")
	implementation("io.swagger.core.v3:swagger-annotations:2.2.20")
	implementation("org.openapitools:jackson-databind-nullable:0.2.6")
	implementation("javax.annotation:javax.annotation-api:1.3.2")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
	implementation("io.swagger.core.v3:swagger-models:2.2.20")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
//	implementation("org.flywaydb:flyway-core")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.testcontainers:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	runtimeOnly("org.postgresql:postgresql")

	// Spring security libs
//	implementation("org.springframework.boot:spring-boot-starter-security")
//	testImplementation("org.springframework.security:spring-security-test")
//	implementation("io.jsonwebtoken:jjwt-api:0.12.5")
//	implementation("io.jsonwebtoken:jjwt-impl:0.12.5")
//	implementation("io.jsonwebtoken:jjwt-jackson:0.12.5")
	// https://mvnrepository.com/artifact/org.postgresql/postgresql
//	implementation("org.postgresql:postgresql:42.7.3")
}



val spec = "$rootDir/src/main/resources/openapi/api_spec.yaml"
val generatedSourcesDir = "$buildDir/generated/openapi"

openApiGenerate {
	generatorName.set("spring")
	inputSpec.set(spec)
	outputDir.set(generatedSourcesDir)
	apiPackage.set("com.ceph_integration.api")
	modelPackage.set("com.ceph_integration.model")
	configOptions.set(mapOf(
			"dateLibrary" to "java8","useSpringBoot3" to "true","useTags" to "true" ,"performBeanValidation" to "true","interfaceOnly" to "true"
			,   "integer" to "Long","int" to "Long"
	))
}

spotless {
	java {
		importOrder()
		removeUnusedImports()
		googleJavaFormat()
//        prettier()
		formatAnnotations()
	}
}




tasks.withType<Test> {
	useJUnitPlatform()
}

sourceSets {
	getByName("main") {
		java {
			srcDir("$generatedSourcesDir/src/main/java")
		}
	}
}

tasks {
	val openApiGenerate by getting
	val compileJava by getting {
		dependsOn(openApiGenerate)
	}

}