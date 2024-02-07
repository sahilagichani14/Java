1 To build image with spring-boot plugin use this in pom.xml & command

<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<image>
						<name>dockerforjava:spring-boot</name>
					</image>
				</configuration>
			</plugin>
		</plugins>
</build>

"./mvnw package spring-boot:build-image" 

2 For google jib use this in pom.xml & command & before that do docker login or check jib website for username password config 

<plugin>
    <groupId>com.google.cloud.tools</groupId>
    <artifactId>jib-maven-plugin</artifactId>
    <version>3.3.2</version>
	<configuration>
	    <to>
		    <name>docker.io/sahilagichani14/dockerforjava:jib</name>
		</to>
	</configuration>
</plugin>

"./mvnw package -DskipTests jib:build"
"./mvnw package -DskipTests jib:dockerBuild"