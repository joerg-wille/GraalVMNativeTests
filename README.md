# GraalVMNativeTests
Some tests with using GraalVM Native-Image to compile Java code to binary. 

## Graal Archetype
Projects are generated with "local" graalvm-blank archetype:  

1. install archetype

 > cd ./graalvm-blank-archetype  
 > ./create-maven-archetype.sh  
 > cd ./tmp/target/generated-sources/archetype  

 add `<configuration><skip>true</skip></configuration>`  
 to ./tmp/target/generated-sources/archetype/pom.xml for plugin maven-gpg-plugin  

 > mvn install  
 > mvn install archetype:update-local-catalog

2. generate project from local archetype

 ```
mvn archetype:generate\
 -DarchetypeCatalog=local\
 -DarchetypeGroupId=am.ik.archetype\
 -DarchetypeArtifactId=graalvm-blank-archetype\
 -DarchetypeVersion=0.1.4\
 -DgroupId=net.jbw\
 -DartifactId=helloworld\
 -Dversion=1.0.0-SNAPSHOT\
 -B
 ```

&nbsp; 
##Test Projects
###HelloWorld
####Compile Native

> cd helloworld  
> chmod +x mvnw*  
> ./mvnw clean package -Pgraal

####Run Native
> ./target/classes/helloworld-osx-x86_64

&nbsp; 
###Swagger-RxJava
####Compile

> cd swagger-rxjava  
> chmod +x mvnw*  
> ./mvnw clean package

####Run
> java -jar ./target/swagger-rxjava-1.0.0-SNAPSHOT-jar-with-dependencies.jar

####Run with Tracing Agent

`java -agentlib:native-image-agent=config-output-dir=./src/main/resources/META-INF/native-image/net.jbw/swagger-rxjava -jar ./target/swagger-rxjava-1.0.0-SNAPSHOT-jar-with-dependencies.jar`

####Compile Native

> cd swagger-rxjava  
> chmod +x mvnw*  
> ./mvnw clean package -Pnative

####Run Native
> ./target/classes/swagger-rxjava-osx-x86_64








