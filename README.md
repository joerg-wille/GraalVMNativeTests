# GraalVMNativeTests
Some tests with using GraalVM Native-Image to compile Java code to binary.  
(Only tested on macOS 10.14.6)

Prerequisites:
Maven    
GraalVM 20.0.0  
If you are using [SDKMAN](https://sdkman.io/install), try:
> sdk install java 20.0.0-grl  
> sdk use java 20.0.0-grl

## Maven archetype for projects using GraalVM native-image
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
## Test projects

&nbsp;
### HelloWorld
#### Compile Native
> cd helloworld  
> chmod +x mvnw*  
> ./mvnw clean package -Pgraal

#### Run Native
> ./target/classes/helloworld-osx-x86_64

==> WORKS

&nbsp; 
## Test projects using swagger/openapi generated clients
Additional prerequisites:  
swagger-codegen  
openapi-generator

If you are using [Homebrew](https://brew.sh/index), try:  
`brew install swagger-codegen`  
`brew install openapi-generator`  

The clients use rest-api to talk to a local instance of [OpenProject](https://docs.openproject.org/installation-and-operations/installation/docker/) running on docker.  
A [list](https://openapi-generator.tech/docs/generators/java/) of "Config Options" for java openapi-generator (similar to swagger-codegen).

### Swagger-okhttp-gson
> cd swagger-okhttp-gson  
> chmod +x mvnw* 

#### Generate Swagger Client
```
swagger-codegen generate -l java \
 -c swagger-codegen-config-okhttp-gson.json \
 -i src/main/resources/openProject_swagger.yaml \
 -o target/generated-sources
```
`mv ./target/generated-sources/src/main/java/net/jbw/openproject/ ./src/main/java/net/jbw/`

#### Compile
> ./mvnw clean package

#### Run
> java -jar ./target/swagger-okhttp-gson-1.0.0-SNAPSHOT-jar-with-dependencies.jar

#### Run with Tracing Agent
`java -agentlib:native-image-agent=config-output-dir=./src/main/resources/META-INF/native-image/net.jbw/swagger-okhttp-gson -jar ./target/swagger-okhttp-gson-1.0.0-SNAPSHOT-jar-with-dependencies.jar`

#### Compile Native
> ./mvnw clean package -Pnative

#### Run Native
> ./target/classes/swagger-okhttp-gson-osx-x86_64

==> WORKS

&nbsp; 
### Swagger-native (using Java11 native http client)
> cd swagger-native  
> chmod +x mvnw* 

#### Generate OpenApi Client
```
openapi-generator generate \
 -g java \
 -c openapi-generator-config-native.json \
 -i src/main/resources/openProject_swagger.yaml \
 -o target/generated-sources \
 --additional-properties library=native
```
`mv ./target/generated-sources/src/main/java/net/jbw/openproject/ ./src/main/java/net/jbw/`

#### Compile
> ./mvnw clean package

#### Run
> java -jar ./target/swagger-native-1.0.0-SNAPSHOT-jar-with-dependencies.jar

#### Run with Tracing Agent
`java -agentlib:native-image-agent=config-output-dir=./src/main/resources/META-INF/native-image/net.jbw/swagger-native -jar ./target/swagger-native-1.0.0-SNAPSHOT-jar-with-dependencies.jar`

#### Compile Native
> ./mvnw clean package -Pnative

#### Run Native
> ./target/classes/swagger-native-osx-x86_64

==> WORKS

&nbsp; 
### Swagger-native-async (using Java11 native http client with CompletableFuture)
> cd swagger-native-async  
> chmod +x mvnw* 

#### Build and install patched OpenApi Client
[Add async native Java Client](https://github.com/OpenAPITools/openapi-generator/pull/4721)  
[Patch (mail formatted)](https://github.com/OpenAPITools/openapi-generator/pull/4721.patch)  
... and some minor modifications.

> git clone https://joerg-wille@github.com/joerg-wille/openapi-generator.git  
> cd openapi-generator  
> mvn clean install  

#### Generate OpenApi Client using patched version
```
java -jar ~/.m2/repository/org/openapitools/openapi-generator-cli/4.3.0-SNAPSHOT/openapi-generator-cli-4.3.0-SNAPSHOT.jar generate \
 -g java \
 -c openapi-generator-config-native-async.json \
 -i src/main/resources/openProject_swagger.yaml \
 -o target/generated-sources \
 --additional-properties library=native,asyncNative=true
```
`mv ./target/generated-sources/src/main/java/net/jbw/openproject/ ./src/main/java/net/jbw/`

#### Compile
> ./mvnw clean package

#### Run
> java -jar ./target/swagger-native-async-1.0.0-SNAPSHOT-jar-with-dependencies.jar

#### Run with Tracing Agent
`java -agentlib:native-image-agent=config-output-dir=./src/main/resources/META-INF/native-image/net.jbw/swagger-native-async -jar ./target/swagger-native-async-1.0.0-SNAPSHOT-jar-with-dependencies.jar`

#### Compile Native
> ./mvnw clean package -Pnative

#### Run Native
> ./target/classes/swagger-native-async-osx-x86_64

==> WORKS

&nbsp; 
### Swagger-vertx
> cd swagger-vertx  
> chmod +x mvnw* 

#### Generate OpenApi Client
```
openapi-generator generate \
 -g java \
 -c openapi-generator-config-vertx.json \
 -i src/main/resources/openProject_swagger.yaml \
 -o target/generated-sources \
 --additional-properties library=vertx
```
`mv ./target/generated-sources/src/main/java/net/jbw/openproject/ ./src/main/java/net/jbw/`

#### Compile
> ./mvnw clean package

#### Run
> java -jar ./target/swagger-vertx-1.0.0-SNAPSHOT-jar-with-dependencies.jar

#### Run with Tracing Agent
`java -agentlib:native-image-agent=config-output-dir=./src/main/resources/META-INF/native-image/net.jbw/swagger-vertx -jar ./target/swagger-vertx-1.0.0-SNAPSHOT-jar-with-dependencies.jar`

#### Compile Native
> ./mvnw clean package -Pnative

#### Run Native
> ./target/classes/swagger-vertx-osx-x86_64

==> WORKS

&nbsp; 
### Swagger-retrofit2
> cd swagger-retrofit2  
> chmod +x mvnw*  

#### Generate Swagger Client
```
swagger-codegen generate -l java \
 -c swagger-codegen-config-retrofit2.json \
 -i src/main/resources/openProject_swagger.yaml \
 -o target/generated-sources
```
`mv ./target/generated-sources/src/main/java/net/jbw/openproject/ ./src/main/java/net/jbw/`

#### Compile
> ./mvnw clean package

#### Run
> java -jar ./target/swagger-retrofit2-1.0.0-SNAPSHOT-jar-with-dependencies.jar

#### Run with Tracing Agent
`java -agentlib:native-image-agent=config-output-dir=./src/main/resources/META-INF/native-image/net.jbw/swagger-retrofit2 -jar ./target/swagger-retrofit2-1.0.0-SNAPSHOT-jar-with-dependencies.jar`

#### Compile Native
> ./mvnw clean package -Pnative

==> DOES NOT WORK  

**Fatal error**: com.oracle.svm.core.util.VMError$HostedError: com.oracle.svm.core.util.UserError$UserException: Static field or an object referenced from a static field changed during native image generation?
  object:java.lang.ref.SoftReference@3b8d1a9a  of class: java.lang.ref.SoftReference

 ```
./mvnw clean package -Pnative
/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Detecting the operating system and CPU architecture
[INFO] ------------------------------------------------------------------------
[INFO] os.detected.name: osx
[INFO] os.detected.arch: x86_64
[INFO] os.detected.version: 10.14
[INFO] os.detected.version.major: 10
[INFO] os.detected.version.minor: 14
[INFO] os.detected.classifier: osx-x86_64
[INFO] 
[INFO] ---------------------< net.jbw:swagger-retrofit2 >----------------------
[INFO] Building swagger-retrofit2 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ swagger-retrofit2 ---
[INFO] Deleting /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ swagger-retrofit2 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 14 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ swagger-retrofit2 ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 216 source files to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/classes
[WARNING] /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/src/main/java/net/jbw/openproject/client/invoker/ApiClient.java: /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/src/main/java/net/jbw/openproject/client/invoker/ApiClient.java uses unchecked or unsafe operations.
[WARNING] /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/src/main/java/net/jbw/openproject/client/invoker/ApiClient.java: Recompile with -Xlint:unchecked for details.
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ swagger-retrofit2 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ swagger-retrofit2 ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ swagger-retrofit2 ---
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ swagger-retrofit2 ---
[INFO] Building jar: /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-assembly-plugin:3.2.0:single (make-assembly) @ swagger-retrofit2 ---
[INFO] Building jar: /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT-jar-with-dependencies.jar
[INFO] 
[INFO] --- native-image-maven-plugin:20.0.0:native-image (default) @ swagger-retrofit2 ---
[INFO] ImageClasspath Entry: com.squareup.retrofit2:retrofit:jar:2.7.2:compile (file:///Users/joerg/.m2/repository/com/squareup/retrofit2/retrofit/2.7.2/retrofit-2.7.2.jar)
[INFO] ImageClasspath Entry: com.squareup.okhttp3:okhttp:jar:3.14.7:compile (file:///Users/joerg/.m2/repository/com/squareup/okhttp3/okhttp/3.14.7/okhttp-3.14.7.jar)
[INFO] ImageClasspath Entry: com.squareup.okio:okio:jar:1.17.2:compile (file:///Users/joerg/.m2/repository/com/squareup/okio/okio/1.17.2/okio-1.17.2.jar)
[INFO] ImageClasspath Entry: com.squareup.retrofit2:adapter-rxjava2:jar:2.7.2:compile (file:///Users/joerg/.m2/repository/com/squareup/retrofit2/adapter-rxjava2/2.7.2/adapter-rxjava2-2.7.2.jar)
[INFO] ImageClasspath Entry: io.reactivex.rxjava2:rxjava:jar:2.0.0:compile (file:///Users/joerg/.m2/repository/io/reactivex/rxjava2/rxjava/2.0.0/rxjava-2.0.0.jar)
[INFO] ImageClasspath Entry: org.reactivestreams:reactive-streams:jar:1.0.3:compile (file:///Users/joerg/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar)
[INFO] ImageClasspath Entry: com.squareup.retrofit2:converter-gson:jar:2.7.2:compile (file:///Users/joerg/.m2/repository/com/squareup/retrofit2/converter-gson/2.7.2/converter-gson-2.7.2.jar)
[INFO] ImageClasspath Entry: com.google.code.gson:gson:jar:2.8.5:compile (file:///Users/joerg/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar)
[INFO] ImageClasspath Entry: com.squareup.retrofit2:converter-scalars:jar:2.7.2:compile (file:///Users/joerg/.m2/repository/com/squareup/retrofit2/converter-scalars/2.7.2/converter-scalars-2.7.2.jar)
[INFO] ImageClasspath Entry: io.gsonfire:gson-fire:jar:1.8.3:compile (file:///Users/joerg/.m2/repository/io/gsonfire/gson-fire/1.8.3/gson-fire-1.8.3.jar)
[INFO] ImageClasspath Entry: org.apache.oltu.oauth2:org.apache.oltu.oauth2.client:jar:1.0.2:compile (file:///Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.client/1.0.2/org.apache.oltu.oauth2.client-1.0.2.jar)
[INFO] ImageClasspath Entry: org.apache.oltu.oauth2:org.apache.oltu.oauth2.common:jar:1.0.2:compile (file:///Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.common/1.0.2/org.apache.oltu.oauth2.common-1.0.2.jar)
[INFO] ImageClasspath Entry: org.json:json:jar:20140107:compile (file:///Users/joerg/.m2/repository/org/json/json/20140107/json-20140107.jar)
[INFO] ImageClasspath Entry: commons-codec:commons-codec:jar:1.9:compile (file:///Users/joerg/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar)
[INFO] ImageClasspath Entry: org.slf4j:slf4j-api:jar:1.7.7:compile (file:///Users/joerg/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar)
[INFO] ImageClasspath Entry: io.swagger.core.v3:swagger-annotations:jar:2.1.1:compile (file:///Users/joerg/.m2/repository/io/swagger/core/v3/swagger-annotations/2.1.1/swagger-annotations-2.1.1.jar)
[INFO] ImageClasspath Entry: net.jbw:swagger-retrofit2:jar:1.0.0-SNAPSHOT (file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar)
[WARNING] jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-rxjava/native-image.properties does not match recommended META-INF/native-image/${groupId}/${artifactId}/native-image.properties layout.
[INFO] Executing: /Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/bin/native-image -cp /Users/joerg/.m2/repository/com/squareup/retrofit2/retrofit/2.7.2/retrofit-2.7.2.jar:/Users/joerg/.m2/repository/com/squareup/okhttp3/okhttp/3.14.7/okhttp-3.14.7.jar:/Users/joerg/.m2/repository/com/squareup/okio/okio/1.17.2/okio-1.17.2.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/adapter-rxjava2/2.7.2/adapter-rxjava2-2.7.2.jar:/Users/joerg/.m2/repository/io/reactivex/rxjava2/rxjava/2.0.0/rxjava-2.0.0.jar:/Users/joerg/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-gson/2.7.2/converter-gson-2.7.2.jar:/Users/joerg/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-scalars/2.7.2/converter-scalars-2.7.2.jar:/Users/joerg/.m2/repository/io/gsonfire/gson-fire/1.8.3/gson-fire-1.8.3.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.client/1.0.2/org.apache.oltu.oauth2.client-1.0.2.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.common/1.0.2/org.apache.oltu.oauth2.common-1.0.2.jar:/Users/joerg/.m2/repository/org/json/json/20140107/json-20140107.jar:/Users/joerg/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar:/Users/joerg/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar:/Users/joerg/.m2/repository/io/swagger/core/v3/swagger-annotations/2.1.1/swagger-annotations-2.1.1.jar:/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar -H:Class=net.jbw.App -H:Name=swagger-retrofit2-osx-x86_64
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-retrofit2/jni-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-retrofit2-rxjava/jni-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-rxjava/jni-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-retrofit2/reflect-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-retrofit2-rxjava/reflect-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-rxjava/reflect-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-retrofit2/resource-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-retrofit2-rxjava/resource-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-rxjava/resource-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-retrofit2/proxy-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-retrofit2-rxjava/proxy-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-rxjava/proxy-config.json
Executing [
/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/bin/java \
-XX:+UnlockExperimentalVMOptions \
-XX:+EnableJVMCI \
-Dtruffle.TrustAllTruffleRuntimeProviders=true \
-Dtruffle.TruffleRuntime=com.oracle.truffle.api.impl.DefaultTruffleRuntime \
-Dgraalvm.ForcePolyglotInvalid=true \
-Dgraalvm.locatorDisabled=true \
-Dsubstratevm.IgnoreGraalVersionCheck=true \
-Djava.lang.invoke.stringConcat=BC_SB \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.runtime=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.code=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.aarch64=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.amd64=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.meta=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.hotspot=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.services=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.common=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.code.site=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.code.stack=ALL-UNNAMED \
--add-opens \
jdk.internal.vm.compiler/org.graalvm.compiler.debug=ALL-UNNAMED \
--add-opens \
jdk.internal.vm.compiler/org.graalvm.compiler.nodes=ALL-UNNAMED \
--add-opens \
jdk.unsupported/sun.reflect=ALL-UNNAMED \
--add-opens \
java.base/jdk.internal.module=ALL-UNNAMED \
--add-opens \
java.base/jdk.internal.ref=ALL-UNNAMED \
--add-opens \
java.base/jdk.internal.reflect=ALL-UNNAMED \
--add-opens \
java.base/java.io=ALL-UNNAMED \
--add-opens \
java.base/java.lang=ALL-UNNAMED \
--add-opens \
java.base/java.lang.reflect=ALL-UNNAMED \
--add-opens \
java.base/java.lang.invoke=ALL-UNNAMED \
--add-opens \
java.base/java.lang.ref=ALL-UNNAMED \
--add-opens \
java.base/java.net=ALL-UNNAMED \
--add-opens \
java.base/java.nio=ALL-UNNAMED \
--add-opens \
java.base/java.nio.file=ALL-UNNAMED \
--add-opens \
java.base/java.security=ALL-UNNAMED \
--add-opens \
java.base/javax.crypto=ALL-UNNAMED \
--add-opens \
java.base/java.util=ALL-UNNAMED \
--add-opens \
java.base/java.util.concurrent.atomic=ALL-UNNAMED \
--add-opens \
java.base/sun.security.x509=ALL-UNNAMED \
--add-opens \
java.base/jdk.internal.logger=ALL-UNNAMED \
--add-opens \
org.graalvm.sdk/org.graalvm.nativeimage.impl=ALL-UNNAMED \
--add-opens \
org.graalvm.sdk/org.graalvm.polyglot=ALL-UNNAMED \
--add-opens \
org.graalvm.truffle/com.oracle.truffle.polyglot=ALL-UNNAMED \
--add-opens \
org.graalvm.truffle/com.oracle.truffle.api.impl=ALL-UNNAMED \
-XX:+UseJVMCINativeLibrary \
-Xss10m \
-Xms1g \
-Xmx14g \
-Duser.country=US \
-Duser.language=en \
-Djava.awt.headless=true \
-Dorg.graalvm.version=20.0.0 \
-Dorg.graalvm.config=CE \
-Dcom.oracle.graalvm.isaot=true \
-Djava.system.class.loader=com.oracle.svm.hosted.NativeImageSystemClassLoader \
-Xshare:off \
--module-path \
/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/truffle/truffle-api.jar \
-javaagent:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/svm.jar=traceInitialization \
-Djdk.internal.lambda.disableEagerInitialization=true \
-Djdk.internal.lambda.eagerlyInitialize=false \
-Djava.lang.invoke.InnerClassLambdaMetafactory.initializeLambdas=false \
-Dfile.encoding=UTF-8 \
-cp \
/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/llvm-wrapper-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/svm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/objectfile.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/graal-llvm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/llvm-platform-specific-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/javacpp-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/svm-llvm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/pointsto.jar \
com.oracle.svm.hosted.NativeImageGeneratorRunner$JDK9Plus \
-imagecp \
/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/llvm-wrapper-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/svm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/objectfile.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/graal-llvm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/llvm-platform-specific-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/javacpp-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/svm-llvm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/pointsto.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/library-support.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/retrofit/2.7.2/retrofit-2.7.2.jar:/Users/joerg/.m2/repository/com/squareup/okhttp3/okhttp/3.14.7/okhttp-3.14.7.jar:/Users/joerg/.m2/repository/com/squareup/okio/okio/1.17.2/okio-1.17.2.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/adapter-rxjava2/2.7.2/adapter-rxjava2-2.7.2.jar:/Users/joerg/.m2/repository/io/reactivex/rxjava2/rxjava/2.0.0/rxjava-2.0.0.jar:/Users/joerg/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-gson/2.7.2/converter-gson-2.7.2.jar:/Users/joerg/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-scalars/2.7.2/converter-scalars-2.7.2.jar:/Users/joerg/.m2/repository/io/gsonfire/gson-fire/1.8.3/gson-fire-1.8.3.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.client/1.0.2/org.apache.oltu.oauth2.client-1.0.2.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.common/1.0.2/org.apache.oltu.oauth2.common-1.0.2.jar:/Users/joerg/.m2/repository/org/json/json/20140107/json-20140107.jar:/Users/joerg/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar:/Users/joerg/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar:/Users/joerg/.m2/repository/io/swagger/core/v3/swagger-annotations/2.1.1/swagger-annotations-2.1.1.jar:/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar \
-H:Path=/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/classes \
-H:+PrintAnalysisCallTree \
-H:+TraceClassInitialization \
-H:+ReportExceptionStackTraces \
-H:+StackTrace \
-H:+JNI \
-H:+AddAllCharsets \
-H:EnableURLProtocols=http,https \
-H:+EnableAllSecurityServices \
-H:+AllowIncompleteClasspath \
-H:+ReportUnsupportedElementsAtRuntime \
-H:FallbackThreshold=0 \
-H:ClassInitialization=net.jbw.openproject.client.api.UsersApi:build_time \
-H:JNIConfigurationResources=META-INF/native-image/net.jbw/swagger-retrofit2/jni-config.json \
-H:JNIConfigurationResources=META-INF/native-image/net.jbw/swagger-retrofit2-rxjava/jni-config.json \
-H:JNIConfigurationResources=META-INF/native-image/net.jbw/swagger-rxjava/jni-config.json \
-H:ReflectionConfigurationResources=META-INF/native-image/net.jbw/swagger-retrofit2/reflect-config.json \
-H:ReflectionConfigurationResources=META-INF/native-image/net.jbw/swagger-retrofit2-rxjava/reflect-config.json \
-H:ReflectionConfigurationResources=META-INF/native-image/net.jbw/swagger-rxjava/reflect-config.json \
-H:ResourceConfigurationResources=META-INF/native-image/net.jbw/swagger-retrofit2/resource-config.json \
-H:ResourceConfigurationResources=META-INF/native-image/net.jbw/swagger-retrofit2-rxjava/resource-config.json \
-H:ResourceConfigurationResources=META-INF/native-image/net.jbw/swagger-rxjava/resource-config.json \
-H:DynamicProxyConfigurationResources=META-INF/native-image/net.jbw/swagger-retrofit2/proxy-config.json \
-H:DynamicProxyConfigurationResources=META-INF/native-image/net.jbw/swagger-retrofit2-rxjava/proxy-config.json \
-H:DynamicProxyConfigurationResources=META-INF/native-image/net.jbw/swagger-rxjava/proxy-config.json \
-H:Class=net.jbw.App \
-H:Name=swagger-retrofit2-osx-x86_64 \
-H:CLibraryPath=/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/clibraries/darwin-amd64
]
[swagger-retrofit2-osx-x86_64:7111]    classlist:   1,750.79 ms,  1.23 GB
[swagger-retrofit2-osx-x86_64:7111]        (cap):     663.65 ms,  1.23 GB
[swagger-retrofit2-osx-x86_64:7111]        setup:   1,775.39 ms,  1.23 GB
[swagger-retrofit2-osx-x86_64:7111]   (typeflow):  11,837.61 ms,  3.80 GB
[swagger-retrofit2-osx-x86_64:7111]    (objects):  10,444.62 ms,  3.80 GB
[swagger-retrofit2-osx-x86_64:7111]   (features):     675.90 ms,  3.80 GB
[swagger-retrofit2-osx-x86_64:7111]     analysis:  23,543.02 ms,  3.80 GB
Printing call tree to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/classes/reports/call_tree_swagger-retrofit2-osx-x86_64_20200225_225111.txt
Printing list of used methods to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/classes/reports/used_methods_swagger-retrofit2-osx-x86_64_20200225_225112.txt
Printing list of used classes to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/classes/reports/used_classes_swagger-retrofit2-osx-x86_64_20200225_225113.txt
Printing list of used packages to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/classes/reports/used_packages_swagger-retrofit2-osx-x86_64_20200225_225113.txt
[swagger-retrofit2-osx-x86_64:7111]     (clinit):     365.52 ms,  3.80 GB
[swagger-retrofit2-osx-x86_64:7111]     universe:     961.82 ms,  3.80 GB
[swagger-retrofit2-osx-x86_64:7111]      (parse):   2,768.42 ms,  3.80 GB
[swagger-retrofit2-osx-x86_64:7111]     (inline):   1,593.12 ms,  3.80 GB
[swagger-retrofit2-osx-x86_64:7111]    (compile):  11,333.48 ms,  4.28 GB
[swagger-retrofit2-osx-x86_64:7111]      compile:  16,761.18 ms,  4.28 GB
[swagger-retrofit2-osx-x86_64:7111]        image:     943.82 ms,  4.28 GB
Fatal error: com.oracle.svm.core.util.VMError$HostedError: com.oracle.svm.core.util.UserError$UserException: Static field or an object referenced from a static field changed during native image generation?
  object:java.lang.ref.SoftReference@3b8d1a9a  of class: java.lang.ref.SoftReference
  reachable through:
    object: [Ljava.lang.ref.SoftReference;@3d242659  of class: java.lang.ref.SoftReference[]
    object: Form(Object,Object,int,Object)void  of class: java.lang.invoke.MethodTypeForm
    object: (MethodHandle,Object,int,Object)void  of class: java.lang.invoke.MethodType
    object: MethodHandle(MethodHandle,Object,int,Object)void  of class: java.lang.invoke.DirectMethodHandle
    object: [Ljava.lang.invoke.MethodHandle;@4ff17571  of class: java.lang.invoke.MethodHandle[]
    object: Invokers(Object,int,Object)void  of class: java.lang.invoke.Invokers
    object: (Object,int,Object)void  of class: java.lang.invoke.MethodType
    root: java.lang.invoke.MethodHandleImpl$AsVarargsCollector.invokeWithArguments(Object[])

	at com.oracle.svm.core.util.VMError.shouldNotReachHere(VMError.java:70)
	at com.oracle.svm.hosted.NativeImageGenerator.doRun(NativeImageGenerator.java:641)
	at com.oracle.svm.hosted.NativeImageGenerator.lambda$run$0(NativeImageGenerator.java:445)
	at java.base/java.util.concurrent.ForkJoinTask$AdaptedRunnableAction.exec(ForkJoinTask.java:1407)
	at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:290)
	at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1020)
	at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1656)
	at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1594)
	at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:177)
Caused by: com.oracle.svm.core.util.UserError$UserException: Static field or an object referenced from a static field changed during native image generation?
  object:java.lang.ref.SoftReference@3b8d1a9a  of class: java.lang.ref.SoftReference
  reachable through:
    object: [Ljava.lang.ref.SoftReference;@3d242659  of class: java.lang.ref.SoftReference[]
    object: Form(Object,Object,int,Object)void  of class: java.lang.invoke.MethodTypeForm
    object: (MethodHandle,Object,int,Object)void  of class: java.lang.invoke.MethodType
    object: MethodHandle(MethodHandle,Object,int,Object)void  of class: java.lang.invoke.DirectMethodHandle
    object: [Ljava.lang.invoke.MethodHandle;@4ff17571  of class: java.lang.invoke.MethodHandle[]
    object: Invokers(Object,int,Object)void  of class: java.lang.invoke.Invokers
    object: (Object,int,Object)void  of class: java.lang.invoke.MethodType
    root: java.lang.invoke.MethodHandleImpl$AsVarargsCollector.invokeWithArguments(Object[])

	at com.oracle.svm.core.util.UserError.abort(UserError.java:68)
	at com.oracle.svm.hosted.image.NativeImageHeapWriter.verifyTargetDidNotChange(NativeImageHeapWriter.java:129)
	at com.oracle.svm.hosted.image.NativeImageHeapWriter.writeReference(NativeImageHeapWriter.java:157)
	at com.oracle.svm.hosted.image.NativeImageHeapWriter.write(NativeImageHeapWriter.java:146)
	at com.oracle.svm.hosted.image.NativeImageHeapWriter.writeConstant(NativeImageHeapWriter.java:183)
	at com.oracle.svm.hosted.image.NativeImageHeapWriter.writeObject(NativeImageHeapWriter.java:375)
	at com.oracle.svm.hosted.image.NativeImageHeapWriter.writeHeap(NativeImageHeapWriter.java:88)
	at com.oracle.svm.hosted.image.NativeBootImage.build(NativeBootImage.java:472)
	at com.oracle.svm.hosted.NativeImageGenerator.doRun(NativeImageGenerator.java:630)
	... 7 more
Error: Image build request failed with exit status 1
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  55.042 s
[INFO] Finished at: 2020-02-25T22:51:32+01:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.graalvm.nativeimage:native-image-maven-plugin:20.0.0:native-image (default) on project swagger-retrofit2: Execution of /Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/bin/native-image -cp /Users/joerg/.m2/repository/com/squareup/retrofit2/retrofit/2.7.2/retrofit-2.7.2.jar:/Users/joerg/.m2/repository/com/squareup/okhttp3/okhttp/3.14.7/okhttp-3.14.7.jar:/Users/joerg/.m2/repository/com/squareup/okio/okio/1.17.2/okio-1.17.2.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/adapter-rxjava2/2.7.2/adapter-rxjava2-2.7.2.jar:/Users/joerg/.m2/repository/io/reactivex/rxjava2/rxjava/2.0.0/rxjava-2.0.0.jar:/Users/joerg/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-gson/2.7.2/converter-gson-2.7.2.jar:/Users/joerg/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-scalars/2.7.2/converter-scalars-2.7.2.jar:/Users/joerg/.m2/repository/io/gsonfire/gson-fire/1.8.3/gson-fire-1.8.3.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.client/1.0.2/org.apache.oltu.oauth2.client-1.0.2.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.common/1.0.2/org.apache.oltu.oauth2.common-1.0.2.jar:/Users/joerg/.m2/repository/org/json/json/20140107/json-20140107.jar:/Users/joerg/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar:/Users/joerg/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar:/Users/joerg/.m2/repository/io/swagger/core/v3/swagger-annotations/2.1.1/swagger-annotations-2.1.1.jar:/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2/target/swagger-retrofit2-1.0.0-SNAPSHOT.jar -H:Class=net.jbw.App -H:Name=swagger-retrofit2-osx-x86_64 returned non-zero result -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
 ```

#### Run Native
> ./target/classes/swagger-rxjava-osx-x86_64


&nbsp; 
### Swagger-retrofit2-rxjava
> cd swagger-retrofit2-rxjava  
> chmod +x mvnw*  

#### Generate Swagger Client
```
swagger-codegen generate -l java \
 -c swagger-codegen-config-retrofit2-rxjava.json \
 -i src/main/resources/openProject_swagger.yaml \
 -o target/generated-sources
```
`mv ./target/generated-sources/src/main/java/net/jbw/openproject/ ./src/main/java/net/jbw/`

#### Compile
> ./mvnw clean package

#### Run
> java -jar ./target/swagger-retrofit2-rxjava-1.0.0-SNAPSHOT-jar-with-dependencies.jar

#### Run with Tracing Agent
`java -agentlib:native-image-agent=config-output-dir=./src/main/resources/META-INF/native-image/net.jbw/swagger-retrofit2-rxjava -jar ./target/swagger-retrofit2-rxjava-1.0.0-SNAPSHOT-jar-with-dependencies.jar`

#### Compile Native
> ./mvnw clean package -Pnative

==> DOES NOT WORK  
**Fatal error**: com.oracle.svm.core.util.VMError$HostedError: com.oracle.svm.core.util.UserError$UserException:  
Static field or an object referenced from a static field changed during native image generation?  
  object:java.lang.ref.SoftReference@19ecfb89  of class: java.lang.ref.SoftReference

 ```
./mvnw clean package -Pnative
/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Detecting the operating system and CPU architecture
[INFO] ------------------------------------------------------------------------
[INFO] os.detected.name: osx
[INFO] os.detected.arch: x86_64
[INFO] os.detected.version: 10.14
[INFO] os.detected.version.major: 10
[INFO] os.detected.version.minor: 14
[INFO] os.detected.classifier: osx-x86_64
[INFO] 
[INFO] ------------------< net.jbw:swagger-retrofit2-rxjava >------------------
[INFO] Building swagger-retrofit2-rxjava 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ swagger-retrofit2-rxjava ---
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ swagger-retrofit2-rxjava ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 6 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ swagger-retrofit2-rxjava ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 216 source files to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/classes
[WARNING] /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/src/main/java/net/jbw/openproject/client/invoker/ApiClient.java: /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/src/main/java/net/jbw/openproject/client/invoker/ApiClient.java uses unchecked or unsafe operations.
[WARNING] /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/src/main/java/net/jbw/openproject/client/invoker/ApiClient.java: Recompile with -Xlint:unchecked for details.
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ swagger-retrofit2-rxjava ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ swagger-retrofit2-rxjava ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ swagger-retrofit2-rxjava ---
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ swagger-retrofit2-rxjava ---
[INFO] Building jar: /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/swagger-retrofit2-rxjava-1.0.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-assembly-plugin:3.2.0:single (make-assembly) @ swagger-retrofit2-rxjava ---
[INFO] Building jar: /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/swagger-retrofit2-rxjava-1.0.0-SNAPSHOT-jar-with-dependencies.jar
[INFO] 
[INFO] --- native-image-maven-plugin:20.0.0:native-image (default) @ swagger-retrofit2-rxjava ---
[INFO] ImageClasspath Entry: io.reactivex.rxjava2:rxjava:jar:2.2.18:compile (file:///Users/joerg/.m2/repository/io/reactivex/rxjava2/rxjava/2.2.18/rxjava-2.2.18.jar)
[INFO] ImageClasspath Entry: org.reactivestreams:reactive-streams:jar:1.0.3:compile (file:///Users/joerg/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar)
[INFO] ImageClasspath Entry: com.squareup.retrofit2:retrofit:jar:2.7.2:compile (file:///Users/joerg/.m2/repository/com/squareup/retrofit2/retrofit/2.7.2/retrofit-2.7.2.jar)
[INFO] ImageClasspath Entry: com.squareup.okhttp3:okhttp:jar:3.14.7:compile (file:///Users/joerg/.m2/repository/com/squareup/okhttp3/okhttp/3.14.7/okhttp-3.14.7.jar)
[INFO] ImageClasspath Entry: com.squareup.okio:okio:jar:1.17.2:compile (file:///Users/joerg/.m2/repository/com/squareup/okio/okio/1.17.2/okio-1.17.2.jar)
[INFO] ImageClasspath Entry: com.squareup.retrofit2:adapter-rxjava2:jar:2.7.2:compile (file:///Users/joerg/.m2/repository/com/squareup/retrofit2/adapter-rxjava2/2.7.2/adapter-rxjava2-2.7.2.jar)
[INFO] ImageClasspath Entry: com.squareup.retrofit2:converter-gson:jar:2.7.2:compile (file:///Users/joerg/.m2/repository/com/squareup/retrofit2/converter-gson/2.7.2/converter-gson-2.7.2.jar)
[INFO] ImageClasspath Entry: com.google.code.gson:gson:jar:2.8.5:compile (file:///Users/joerg/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar)
[INFO] ImageClasspath Entry: com.squareup.retrofit2:converter-scalars:jar:2.7.2:compile (file:///Users/joerg/.m2/repository/com/squareup/retrofit2/converter-scalars/2.7.2/converter-scalars-2.7.2.jar)
[INFO] ImageClasspath Entry: io.gsonfire:gson-fire:jar:1.8.3:compile (file:///Users/joerg/.m2/repository/io/gsonfire/gson-fire/1.8.3/gson-fire-1.8.3.jar)
[INFO] ImageClasspath Entry: org.apache.oltu.oauth2:org.apache.oltu.oauth2.client:jar:1.0.2:compile (file:///Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.client/1.0.2/org.apache.oltu.oauth2.client-1.0.2.jar)
[INFO] ImageClasspath Entry: org.apache.oltu.oauth2:org.apache.oltu.oauth2.common:jar:1.0.2:compile (file:///Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.common/1.0.2/org.apache.oltu.oauth2.common-1.0.2.jar)
[INFO] ImageClasspath Entry: org.json:json:jar:20140107:compile (file:///Users/joerg/.m2/repository/org/json/json/20140107/json-20140107.jar)
[INFO] ImageClasspath Entry: commons-codec:commons-codec:jar:1.9:compile (file:///Users/joerg/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar)
[INFO] ImageClasspath Entry: org.slf4j:slf4j-api:jar:1.7.7:compile (file:///Users/joerg/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar)
[INFO] ImageClasspath Entry: io.swagger.core.v3:swagger-annotations:jar:2.1.1:compile (file:///Users/joerg/.m2/repository/io/swagger/core/v3/swagger-annotations/2.1.1/swagger-annotations-2.1.1.jar)
[INFO] ImageClasspath Entry: net.jbw:swagger-retrofit2-rxjava:jar:1.0.0-SNAPSHOT (file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/swagger-retrofit2-rxjava-1.0.0-SNAPSHOT.jar)
[WARNING] jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/swagger-retrofit2-rxjava-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-rxjava/native-image.properties does not match recommended META-INF/native-image/${groupId}/${artifactId}/native-image.properties layout.
[INFO] Executing: /Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/bin/native-image -cp /Users/joerg/.m2/repository/io/reactivex/rxjava2/rxjava/2.2.18/rxjava-2.2.18.jar:/Users/joerg/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/retrofit/2.7.2/retrofit-2.7.2.jar:/Users/joerg/.m2/repository/com/squareup/okhttp3/okhttp/3.14.7/okhttp-3.14.7.jar:/Users/joerg/.m2/repository/com/squareup/okio/okio/1.17.2/okio-1.17.2.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/adapter-rxjava2/2.7.2/adapter-rxjava2-2.7.2.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-gson/2.7.2/converter-gson-2.7.2.jar:/Users/joerg/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-scalars/2.7.2/converter-scalars-2.7.2.jar:/Users/joerg/.m2/repository/io/gsonfire/gson-fire/1.8.3/gson-fire-1.8.3.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.client/1.0.2/org.apache.oltu.oauth2.client-1.0.2.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.common/1.0.2/org.apache.oltu.oauth2.common-1.0.2.jar:/Users/joerg/.m2/repository/org/json/json/20140107/json-20140107.jar:/Users/joerg/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar:/Users/joerg/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar:/Users/joerg/.m2/repository/io/swagger/core/v3/swagger-annotations/2.1.1/swagger-annotations-2.1.1.jar:/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/swagger-retrofit2-rxjava-1.0.0-SNAPSHOT.jar -H:Class=net.jbw.App -H:Name=swagger-retrofit2-rxjava-osx-x86_64
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/swagger-retrofit2-rxjava-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-rxjava/jni-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/swagger-retrofit2-rxjava-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-rxjava/reflect-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/swagger-retrofit2-rxjava-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-rxjava/resource-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/swagger-retrofit2-rxjava-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-rxjava/proxy-config.json
Executing [
/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/bin/java \
-XX:+UnlockExperimentalVMOptions \
-XX:+EnableJVMCI \
-Dtruffle.TrustAllTruffleRuntimeProviders=true \
-Dtruffle.TruffleRuntime=com.oracle.truffle.api.impl.DefaultTruffleRuntime \
-Dgraalvm.ForcePolyglotInvalid=true \
-Dgraalvm.locatorDisabled=true \
-Dsubstratevm.IgnoreGraalVersionCheck=true \
-Djava.lang.invoke.stringConcat=BC_SB \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.runtime=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.code=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.aarch64=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.amd64=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.meta=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.hotspot=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.services=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.common=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.code.site=ALL-UNNAMED \
--add-exports \
jdk.internal.vm.ci/jdk.vm.ci.code.stack=ALL-UNNAMED \
--add-opens \
jdk.internal.vm.compiler/org.graalvm.compiler.debug=ALL-UNNAMED \
--add-opens \
jdk.internal.vm.compiler/org.graalvm.compiler.nodes=ALL-UNNAMED \
--add-opens \
jdk.unsupported/sun.reflect=ALL-UNNAMED \
--add-opens \
java.base/jdk.internal.module=ALL-UNNAMED \
--add-opens \
java.base/jdk.internal.ref=ALL-UNNAMED \
--add-opens \
java.base/jdk.internal.reflect=ALL-UNNAMED \
--add-opens \
java.base/java.io=ALL-UNNAMED \
--add-opens \
java.base/java.lang=ALL-UNNAMED \
--add-opens \
java.base/java.lang.reflect=ALL-UNNAMED \
--add-opens \
java.base/java.lang.invoke=ALL-UNNAMED \
--add-opens \
java.base/java.lang.ref=ALL-UNNAMED \
--add-opens \
java.base/java.net=ALL-UNNAMED \
--add-opens \
java.base/java.nio=ALL-UNNAMED \
--add-opens \
java.base/java.nio.file=ALL-UNNAMED \
--add-opens \
java.base/java.security=ALL-UNNAMED \
--add-opens \
java.base/javax.crypto=ALL-UNNAMED \
--add-opens \
java.base/java.util=ALL-UNNAMED \
--add-opens \
java.base/java.util.concurrent.atomic=ALL-UNNAMED \
--add-opens \
java.base/sun.security.x509=ALL-UNNAMED \
--add-opens \
java.base/jdk.internal.logger=ALL-UNNAMED \
--add-opens \
org.graalvm.sdk/org.graalvm.nativeimage.impl=ALL-UNNAMED \
--add-opens \
org.graalvm.sdk/org.graalvm.polyglot=ALL-UNNAMED \
--add-opens \
org.graalvm.truffle/com.oracle.truffle.polyglot=ALL-UNNAMED \
--add-opens \
org.graalvm.truffle/com.oracle.truffle.api.impl=ALL-UNNAMED \
-XX:+UseJVMCINativeLibrary \
-Xss10m \
-Xms1g \
-Xmx14g \
-Duser.country=US \
-Duser.language=en \
-Djava.awt.headless=true \
-Dorg.graalvm.version=20.0.0 \
-Dorg.graalvm.config=CE \
-Dcom.oracle.graalvm.isaot=true \
-Djava.system.class.loader=com.oracle.svm.hosted.NativeImageSystemClassLoader \
-Xshare:off \
--module-path \
/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/truffle/truffle-api.jar \
-javaagent:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/svm.jar=traceInitialization \
-Djdk.internal.lambda.disableEagerInitialization=true \
-Djdk.internal.lambda.eagerlyInitialize=false \
-Djava.lang.invoke.InnerClassLambdaMetafactory.initializeLambdas=false \
-Dfile.encoding=UTF-8 \
-cp \
/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/llvm-wrapper-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/svm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/objectfile.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/graal-llvm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/llvm-platform-specific-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/javacpp-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/svm-llvm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/pointsto.jar \
com.oracle.svm.hosted.NativeImageGeneratorRunner$JDK9Plus \
-imagecp \
/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/llvm-wrapper-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/svm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/objectfile.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/graal-llvm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/llvm-platform-specific-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/javacpp-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/svm-llvm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/pointsto.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/library-support.jar:/Users/joerg/.m2/repository/io/reactivex/rxjava2/rxjava/2.2.18/rxjava-2.2.18.jar:/Users/joerg/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/retrofit/2.7.2/retrofit-2.7.2.jar:/Users/joerg/.m2/repository/com/squareup/okhttp3/okhttp/3.14.7/okhttp-3.14.7.jar:/Users/joerg/.m2/repository/com/squareup/okio/okio/1.17.2/okio-1.17.2.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/adapter-rxjava2/2.7.2/adapter-rxjava2-2.7.2.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-gson/2.7.2/converter-gson-2.7.2.jar:/Users/joerg/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-scalars/2.7.2/converter-scalars-2.7.2.jar:/Users/joerg/.m2/repository/io/gsonfire/gson-fire/1.8.3/gson-fire-1.8.3.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.client/1.0.2/org.apache.oltu.oauth2.client-1.0.2.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.common/1.0.2/org.apache.oltu.oauth2.common-1.0.2.jar:/Users/joerg/.m2/repository/org/json/json/20140107/json-20140107.jar:/Users/joerg/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar:/Users/joerg/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar:/Users/joerg/.m2/repository/io/swagger/core/v3/swagger-annotations/2.1.1/swagger-annotations-2.1.1.jar:/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/swagger-retrofit2-rxjava-1.0.0-SNAPSHOT.jar \
-H:Path=/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/classes \
-H:+PrintAnalysisCallTree \
-H:+TraceClassInitialization \
-H:+ReportExceptionStackTraces \
-H:+StackTrace \
-H:+JNI \
-H:+AddAllCharsets \
-H:EnableURLProtocols=http,https \
-H:+EnableAllSecurityServices \
-H:+AllowIncompleteClasspath \
-H:+ReportUnsupportedElementsAtRuntime \
-H:FallbackThreshold=0 \
-H:ClassInitialization=net.jbw.openproject.client.api.UsersApi:build_time \
-H:JNIConfigurationResources=META-INF/native-image/net.jbw/swagger-rxjava/jni-config.json \
-H:ReflectionConfigurationResources=META-INF/native-image/net.jbw/swagger-rxjava/reflect-config.json \
-H:ResourceConfigurationResources=META-INF/native-image/net.jbw/swagger-rxjava/resource-config.json \
-H:DynamicProxyConfigurationResources=META-INF/native-image/net.jbw/swagger-rxjava/proxy-config.json \
-H:Class=net.jbw.App \
-H:Name=swagger-retrofit2-rxjava-osx-x86_64 \
-H:CLibraryPath=/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/clibraries/darwin-amd64
]
[swagger-retrofit2-rxjava-osx-x86_64:6216]    classlist:   1,793.31 ms,  1.29 GB
[swagger-retrofit2-rxjava-osx-x86_64:6216]        (cap):     679.09 ms,  1.29 GB
[swagger-retrofit2-rxjava-osx-x86_64:6216]        setup:   1,783.81 ms,  1.29 GB
[swagger-retrofit2-rxjava-osx-x86_64:6216]   (typeflow):  11,946.35 ms,  4.22 GB
[swagger-retrofit2-rxjava-osx-x86_64:6216]    (objects):  10,075.00 ms,  4.22 GB
[swagger-retrofit2-rxjava-osx-x86_64:6216]   (features):     676.97 ms,  4.22 GB
[swagger-retrofit2-rxjava-osx-x86_64:6216]     analysis:  23,298.65 ms,  4.22 GB
Printing call tree to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/classes/reports/call_tree_swagger-retrofit2-rxjava-osx-x86_64_20200225_215842.txt
Printing list of used methods to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/classes/reports/used_methods_swagger-retrofit2-rxjava-osx-x86_64_20200225_215843.txt
Printing list of used classes to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/classes/reports/used_classes_swagger-retrofit2-rxjava-osx-x86_64_20200225_215843.txt
Printing list of used packages to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/classes/reports/used_packages_swagger-retrofit2-rxjava-osx-x86_64_20200225_215843.txt
[swagger-retrofit2-rxjava-osx-x86_64:6216]     (clinit):     371.18 ms,  4.22 GB
[swagger-retrofit2-rxjava-osx-x86_64:6216]     universe:     946.61 ms,  4.22 GB
[swagger-retrofit2-rxjava-osx-x86_64:6216]      (parse):   2,734.40 ms,  4.22 GB
[swagger-retrofit2-rxjava-osx-x86_64:6216]     (inline):   1,465.10 ms,  4.22 GB
[swagger-retrofit2-rxjava-osx-x86_64:6216]    (compile):  12,091.28 ms,  4.22 GB
[swagger-retrofit2-rxjava-osx-x86_64:6216]      compile:  17,317.92 ms,  4.22 GB
[swagger-retrofit2-rxjava-osx-x86_64:6216]        image:   1,938.27 ms,  4.22 GB
Fatal error: com.oracle.svm.core.util.VMError$HostedError: com.oracle.svm.core.util.UserError$UserException: Static field or an object referenced from a static field changed during native image generation?
  object:java.lang.ref.SoftReference@1f19b8c4  of class: java.lang.ref.SoftReference
  reachable through:
    object: [Ljava.lang.ref.SoftReference;@3b326b7d  of class: java.lang.ref.SoftReference[]
    object: Form(Object,Object,int,Object)void  of class: java.lang.invoke.MethodTypeForm
    object: (MethodHandle,Object,int,Object)void  of class: java.lang.invoke.MethodType
    object: MethodHandle(MethodHandle,Object,int,Object)void  of class: java.lang.invoke.DirectMethodHandle
    object: [Ljava.lang.invoke.MethodHandle;@e3c381  of class: java.lang.invoke.MethodHandle[]
    object: Invokers(Object,int,Object)void  of class: java.lang.invoke.Invokers
    object: (Object,int,Object)void  of class: java.lang.invoke.MethodType
    root: java.lang.invoke.MethodHandleImpl$AsVarargsCollector.invokeWithArguments(Object[])

	at com.oracle.svm.core.util.VMError.shouldNotReachHere(VMError.java:70)
	at com.oracle.svm.hosted.NativeImageGenerator.doRun(NativeImageGenerator.java:641)
	at com.oracle.svm.hosted.NativeImageGenerator.lambda$run$0(NativeImageGenerator.java:445)
	at java.base/java.util.concurrent.ForkJoinTask$AdaptedRunnableAction.exec(ForkJoinTask.java:1407)
	at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:290)
	at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1020)
	at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1656)
	at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1594)
	at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:177)
Caused by: com.oracle.svm.core.util.UserError$UserException: Static field or an object referenced from a static field changed during native image generation?
  object:java.lang.ref.SoftReference@1f19b8c4  of class: java.lang.ref.SoftReference
  reachable through:
    object: [Ljava.lang.ref.SoftReference;@3b326b7d  of class: java.lang.ref.SoftReference[]
    object: Form(Object,Object,int,Object)void  of class: java.lang.invoke.MethodTypeForm
    object: (MethodHandle,Object,int,Object)void  of class: java.lang.invoke.MethodType
    object: MethodHandle(MethodHandle,Object,int,Object)void  of class: java.lang.invoke.DirectMethodHandle
    object: [Ljava.lang.invoke.MethodHandle;@e3c381  of class: java.lang.invoke.MethodHandle[]
    object: Invokers(Object,int,Object)void  of class: java.lang.invoke.Invokers
    object: (Object,int,Object)void  of class: java.lang.invoke.MethodType
    root: java.lang.invoke.MethodHandleImpl$AsVarargsCollector.invokeWithArguments(Object[])

	at com.oracle.svm.core.util.UserError.abort(UserError.java:68)
	at com.oracle.svm.hosted.image.NativeImageHeapWriter.verifyTargetDidNotChange(NativeImageHeapWriter.java:129)
	at com.oracle.svm.hosted.image.NativeImageHeapWriter.writeReference(NativeImageHeapWriter.java:157)
	at com.oracle.svm.hosted.image.NativeImageHeapWriter.write(NativeImageHeapWriter.java:146)
	at com.oracle.svm.hosted.image.NativeImageHeapWriter.writeConstant(NativeImageHeapWriter.java:183)
	at com.oracle.svm.hosted.image.NativeImageHeapWriter.writeObject(NativeImageHeapWriter.java:375)
	at com.oracle.svm.hosted.image.NativeImageHeapWriter.writeHeap(NativeImageHeapWriter.java:88)
	at com.oracle.svm.hosted.image.NativeBootImage.build(NativeBootImage.java:472)
	at com.oracle.svm.hosted.NativeImageGenerator.doRun(NativeImageGenerator.java:630)
	... 7 more
Error: Image build request failed with exit status 1
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  56.616 s
[INFO] Finished at: 2020-02-25T21:59:03+01:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.graalvm.nativeimage:native-image-maven-plugin:20.0.0:native-image (default) on project swagger-retrofit2-rxjava: Execution of /Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/bin/native-image -cp /Users/joerg/.m2/repository/io/reactivex/rxjava2/rxjava/2.2.18/rxjava-2.2.18.jar:/Users/joerg/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/retrofit/2.7.2/retrofit-2.7.2.jar:/Users/joerg/.m2/repository/com/squareup/okhttp3/okhttp/3.14.7/okhttp-3.14.7.jar:/Users/joerg/.m2/repository/com/squareup/okio/okio/1.17.2/okio-1.17.2.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/adapter-rxjava2/2.7.2/adapter-rxjava2-2.7.2.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-gson/2.7.2/converter-gson-2.7.2.jar:/Users/joerg/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-scalars/2.7.2/converter-scalars-2.7.2.jar:/Users/joerg/.m2/repository/io/gsonfire/gson-fire/1.8.3/gson-fire-1.8.3.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.client/1.0.2/org.apache.oltu.oauth2.client-1.0.2.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.common/1.0.2/org.apache.oltu.oauth2.common-1.0.2.jar:/Users/joerg/.m2/repository/org/json/json/20140107/json-20140107.jar:/Users/joerg/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar:/Users/joerg/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar:/Users/joerg/.m2/repository/io/swagger/core/v3/swagger-annotations/2.1.1/swagger-annotations-2.1.1.jar:/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-retrofit2-rxjava/target/swagger-retrofit2-rxjava-1.0.0-SNAPSHOT.jar -H:Class=net.jbw.App -H:Name=swagger-retrofit2-rxjava-osx-x86_64 returned non-zero result -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
 ```

#### Run Native
> ./target/classes/swagger-rxjava-osx-x86_64

