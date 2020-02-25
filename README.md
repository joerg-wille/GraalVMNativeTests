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
## Test Projects
### HelloWorld
#### Compile Native

> cd helloworld  
> chmod +x mvnw*  
> ./mvnw clean package -Pgraal

#### Run Native
> ./target/classes/helloworld-osx-x86_64

==> WORKS

&nbsp; 
### Swagger-okhttp-gson
#### Generate Swagger Client
```
swagger-codegen generate -l java \
 -c swagger-codegen-config-okhttp-gson.json \
 -i src/main/resources/openProject_swagger.yaml \
 -o target/generated-sources
```
`mv ./target/generated-sources/src/main/java/net/jbw/openproject/ ./src/main/java/net/jbw/
`
#### Compile

> cd swagger-okhttp-gson  
> chmod +x mvnw*  
> ./mvnw clean package

#### Run
> java -jar ./target/swagger-okhttp-gson-1.0.0-SNAPSHOT-jar-with-dependencies.jar

#### Run with Tracing Agent

`java -agentlib:native-image-agent=config-output-dir=./src/main/resources/META-INF/native-image/net.jbw/swagger-rxjava -jar ./target/swagger-okhttp-gson-1.0.0-SNAPSHOT-jar-with-dependencies.jar`

#### Compile Native

> cd swagger-rxjava  
> chmod +x mvnw*  
> ./mvnw clean package -Pnative

#### Run Native
> ./target/classes/swagger-okhttp-gson-osx-x86_64

==> WORKS

&nbsp; 
### Swagger-RxJava
#### Generate Swagger Client
```
swagger-codegen generate -l java \
 -c swagger-codegen-config-rxjava.json \
 -i src/main/resources/openProject_swagger.yaml \
 -o target/generated-sources
```

#### Compile

> cd swagger-rxjava  
> chmod +x mvnw*  
> ./mvnw clean package

#### Run
> java -jar ./target/swagger-rxjava-1.0.0-SNAPSHOT-jar-with-dependencies.jar

#### Run with Tracing Agent

`java -agentlib:native-image-agent=config-output-dir=./src/main/resources/META-INF/native-image/net.jbw/swagger-rxjava -jar ./target/swagger-rxjava-1.0.0-SNAPSHOT-jar-with-dependencies.jar`

#### Compile Native

> cd swagger-rxjava  
> chmod +x mvnw*  
> ./mvnw clean package -Pnative

==> DOES NOT WORK  
**Fatal error**: com.oracle.svm.core.util.VMError$HostedError: com.oracle.svm.core.util.UserError$UserException:  
Static field or an object referenced from a static field changed during native image generation?  
  object:java.lang.ref.SoftReference@19ecfb89  of class: java.lang.ref.SoftReference

 ```
kermit:swagger-rxjava joerg$ ./mvnw clean package -Pnative
/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava
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
[INFO] -----------------------< net.jbw:swagger-rxjava >-----------------------
[INFO] Building swagger-rxjava 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ swagger-rxjava ---
[INFO] Deleting /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ swagger-rxjava ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 5 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ swagger-rxjava ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 216 source files to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/classes
[WARNING] /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/src/main/java/net/jbw/openproject/client/invoker/ApiClient.java: /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/src/main/java/net/jbw/openproject/client/invoker/ApiClient.java uses unchecked or unsafe operations.
[WARNING] /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/src/main/java/net/jbw/openproject/client/invoker/ApiClient.java: Recompile with -Xlint:unchecked for details.
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ swagger-rxjava ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ swagger-rxjava ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ swagger-rxjava ---
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ swagger-rxjava ---
[INFO] Building jar: /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/swagger-rxjava-1.0.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-assembly-plugin:3.2.0:single (make-assembly) @ swagger-rxjava ---
Downloading from central: https://repo.maven.apache.org/maven2/org/jvnet/wagon-svn/wagon-svn/1.12/wagon-svn-1.12.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/jvnet/wagon-svn/wagon-svn/1.12/wagon-svn-1.12.pom (2.6 kB at 7.0 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/jvnet/wagon-svn/wagon-svn/1.12/wagon-svn-1.12.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/jvnet/wagon-svn/wagon-svn/1.12/wagon-svn-1.12.jar (20 kB at 251 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-ssh-external/3.0.0/wagon-ssh-external-3.0.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-ssh-external/3.0.0/wagon-ssh-external-3.0.0.pom (3.9 kB at 74 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-providers/3.0.0/wagon-providers-3.0.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-providers/3.0.0/wagon-providers-3.0.0.pom (2.7 kB at 47 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon/3.0.0/wagon-3.0.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon/3.0.0/wagon-3.0.0.pom (21 kB at 374 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-ssh-common/3.0.0/wagon-ssh-common-3.0.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-ssh-common/3.0.0/wagon-ssh-common-3.0.0.pom (2.0 kB at 6.4 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-provider-api/3.0.0/wagon-provider-api-3.0.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-provider-api/3.0.0/wagon-provider-api-3.0.0.pom (1.9 kB at 35 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-ssh-external/3.0.0/wagon-ssh-external-3.0.0.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-provider-api/3.0.0/wagon-provider-api-3.0.0.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-ssh-common/3.0.0/wagon-ssh-common-3.0.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-ssh-external/3.0.0/wagon-ssh-external-3.0.0.jar (15 kB at 255 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-ssh-common/3.0.0/wagon-ssh-common-3.0.0.jar (27 kB at 193 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-provider-api/3.0.0/wagon-provider-api-3.0.0.jar (55 kB at 289 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-webdav/1.0-beta-2/wagon-webdav-1.0-beta-2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-webdav/1.0-beta-2/wagon-webdav-1.0-beta-2.pom (1.5 kB at 23 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-providers/1.0-beta-2/wagon-providers-1.0-beta-2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-providers/1.0-beta-2/wagon-providers-1.0-beta-2.pom (1.8 kB at 28 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-webdav/1.0-beta-2/wagon-webdav-1.0-beta-2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-webdav/1.0-beta-2/wagon-webdav-1.0-beta-2.jar (17 kB at 262 kB/s)
[INFO] Building jar: /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/swagger-rxjava-1.0.0-SNAPSHOT-jar-with-dependencies.jar
[INFO] 
[INFO] --- native-image-maven-plugin:20.0.0:native-image (default) @ swagger-rxjava ---
[INFO] ImageClasspath Entry: org.graalvm.nativeimage:svm:jar:20.0.0:compile (file:///Users/joerg/.m2/repository/org/graalvm/nativeimage/svm/20.0.0/svm-20.0.0.jar)
[WARNING] Ignoring non-jar type ImageClasspath Entry org.graalvm.nativeimage:svm-hosted-native-linux-amd64:tar.gz:20.0.0:compile
[WARNING] Ignoring non-jar type ImageClasspath Entry org.graalvm.nativeimage:svm-hosted-native-darwin-amd64:tar.gz:20.0.0:compile
[WARNING] Ignoring non-jar type ImageClasspath Entry org.graalvm.nativeimage:svm-hosted-native-windows-amd64:tar.gz:20.0.0:compile
[INFO] ImageClasspath Entry: org.graalvm.sdk:graal-sdk:jar:20.0.0:compile (file:///Users/joerg/.m2/repository/org/graalvm/sdk/graal-sdk/20.0.0/graal-sdk-20.0.0.jar)
[WARNING] jar:file:///Users/joerg/.m2/repository/org/graalvm/sdk/graal-sdk/20.0.0/graal-sdk-20.0.0.jar!/META-INF/native-image/org.graalvm.polyglot/native-image.properties does not match recommended META-INF/native-image/${groupId}/${artifactId}/native-image.properties layout.
[WARNING] jar:file:///Users/joerg/.m2/repository/org/graalvm/sdk/graal-sdk/20.0.0/graal-sdk-20.0.0.jar!/META-INF/native-image/org.graalvm.home/native-image.properties does not match recommended META-INF/native-image/${groupId}/${artifactId}/native-image.properties layout.
[INFO] ImageClasspath Entry: org.graalvm.nativeimage:objectfile:jar:20.0.0:compile (file:///Users/joerg/.m2/repository/org/graalvm/nativeimage/objectfile/20.0.0/objectfile-20.0.0.jar)
[INFO] ImageClasspath Entry: org.graalvm.nativeimage:pointsto:jar:20.0.0:compile (file:///Users/joerg/.m2/repository/org/graalvm/nativeimage/pointsto/20.0.0/pointsto-20.0.0.jar)
[INFO] ImageClasspath Entry: org.graalvm.truffle:truffle-nfi:jar:20.0.0:compile (file:///Users/joerg/.m2/repository/org/graalvm/truffle/truffle-nfi/20.0.0/truffle-nfi-20.0.0.jar)
[INFO] ImageClasspath Entry: org.graalvm.truffle:truffle-api:jar:20.0.0:compile (file:///Users/joerg/.m2/repository/org/graalvm/truffle/truffle-api/20.0.0/truffle-api-20.0.0.jar)
[WARNING] Ignoring non-jar type ImageClasspath Entry org.graalvm.truffle:truffle-nfi-native-linux-amd64:tar.gz:20.0.0:compile
[WARNING] Ignoring non-jar type ImageClasspath Entry org.graalvm.truffle:truffle-nfi-native-linux-aarch64:tar.gz:20.0.0:compile
[WARNING] Ignoring non-jar type ImageClasspath Entry org.graalvm.truffle:truffle-nfi-native-darwin-amd64:tar.gz:20.0.0:compile
[INFO] ImageClasspath Entry: org.graalvm.compiler:compiler:jar:20.0.0:compile (file:///Users/joerg/.m2/repository/org/graalvm/compiler/compiler/20.0.0/compiler-20.0.0.jar)
[INFO] ImageClasspath Entry: io.reactivex.rxjava2:rxjava:jar:2.2.18:compile (file:///Users/joerg/.m2/repository/io/reactivex/rxjava2/rxjava/2.2.18/rxjava-2.2.18.jar)
[INFO] ImageClasspath Entry: org.reactivestreams:reactive-streams:jar:1.0.3:compile (file:///Users/joerg/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar)
[INFO] ImageClasspath Entry: com.squareup.retrofit2:retrofit:jar:2.7.1:compile (file:///Users/joerg/.m2/repository/com/squareup/retrofit2/retrofit/2.7.1/retrofit-2.7.1.jar)
[INFO] ImageClasspath Entry: com.squareup.okhttp3:okhttp:jar:3.14.4:compile (file:///Users/joerg/.m2/repository/com/squareup/okhttp3/okhttp/3.14.4/okhttp-3.14.4.jar)
[INFO] ImageClasspath Entry: com.squareup.okio:okio:jar:1.17.2:compile (file:///Users/joerg/.m2/repository/com/squareup/okio/okio/1.17.2/okio-1.17.2.jar)
[INFO] ImageClasspath Entry: com.squareup.retrofit2:adapter-rxjava2:jar:2.7.1:compile (file:///Users/joerg/.m2/repository/com/squareup/retrofit2/adapter-rxjava2/2.7.1/adapter-rxjava2-2.7.1.jar)
[INFO] ImageClasspath Entry: com.squareup.retrofit2:converter-gson:jar:2.7.1:compile (file:///Users/joerg/.m2/repository/com/squareup/retrofit2/converter-gson/2.7.1/converter-gson-2.7.1.jar)
[INFO] ImageClasspath Entry: com.google.code.gson:gson:jar:2.8.5:compile (file:///Users/joerg/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar)
[INFO] ImageClasspath Entry: com.squareup.retrofit2:converter-scalars:jar:2.7.1:compile (file:///Users/joerg/.m2/repository/com/squareup/retrofit2/converter-scalars/2.7.1/converter-scalars-2.7.1.jar)
[INFO] ImageClasspath Entry: io.gsonfire:gson-fire:jar:1.8.3:compile (file:///Users/joerg/.m2/repository/io/gsonfire/gson-fire/1.8.3/gson-fire-1.8.3.jar)
[INFO] ImageClasspath Entry: org.apache.oltu.oauth2:org.apache.oltu.oauth2.client:jar:1.0.2:compile (file:///Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.client/1.0.2/org.apache.oltu.oauth2.client-1.0.2.jar)
[INFO] ImageClasspath Entry: org.apache.oltu.oauth2:org.apache.oltu.oauth2.common:jar:1.0.2:compile (file:///Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.common/1.0.2/org.apache.oltu.oauth2.common-1.0.2.jar)
[INFO] ImageClasspath Entry: org.json:json:jar:20140107:compile (file:///Users/joerg/.m2/repository/org/json/json/20140107/json-20140107.jar)
[INFO] ImageClasspath Entry: commons-codec:commons-codec:jar:1.9:compile (file:///Users/joerg/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar)
[INFO] ImageClasspath Entry: org.slf4j:slf4j-api:jar:1.7.7:compile (file:///Users/joerg/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar)
[INFO] ImageClasspath Entry: io.swagger.core.v3:swagger-annotations:jar:2.1.1:compile (file:///Users/joerg/.m2/repository/io/swagger/core/v3/swagger-annotations/2.1.1/swagger-annotations-2.1.1.jar)
[INFO] ImageClasspath Entry: net.jbw:swagger-rxjava:jar:1.0.0-SNAPSHOT (file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/swagger-rxjava-1.0.0-SNAPSHOT.jar)
[INFO] Executing: /Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/bin/native-image -cp /Users/joerg/.m2/repository/org/graalvm/nativeimage/svm/20.0.0/svm-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/sdk/graal-sdk/20.0.0/graal-sdk-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/nativeimage/objectfile/20.0.0/objectfile-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/nativeimage/pointsto/20.0.0/pointsto-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/truffle/truffle-nfi/20.0.0/truffle-nfi-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/truffle/truffle-api/20.0.0/truffle-api-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/compiler/compiler/20.0.0/compiler-20.0.0.jar:/Users/joerg/.m2/repository/io/reactivex/rxjava2/rxjava/2.2.18/rxjava-2.2.18.jar:/Users/joerg/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/retrofit/2.7.1/retrofit-2.7.1.jar:/Users/joerg/.m2/repository/com/squareup/okhttp3/okhttp/3.14.4/okhttp-3.14.4.jar:/Users/joerg/.m2/repository/com/squareup/okio/okio/1.17.2/okio-1.17.2.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/adapter-rxjava2/2.7.1/adapter-rxjava2-2.7.1.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-gson/2.7.1/converter-gson-2.7.1.jar:/Users/joerg/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-scalars/2.7.1/converter-scalars-2.7.1.jar:/Users/joerg/.m2/repository/io/gsonfire/gson-fire/1.8.3/gson-fire-1.8.3.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.client/1.0.2/org.apache.oltu.oauth2.client-1.0.2.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.common/1.0.2/org.apache.oltu.oauth2.common-1.0.2.jar:/Users/joerg/.m2/repository/org/json/json/20140107/json-20140107.jar:/Users/joerg/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar:/Users/joerg/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar:/Users/joerg/.m2/repository/io/swagger/core/v3/swagger-annotations/2.1.1/swagger-annotations-2.1.1.jar:/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/swagger-rxjava-1.0.0-SNAPSHOT.jar -H:Class=net.jbw.App -H:Name=swagger-rxjava-osx-x86_64
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/swagger-rxjava-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-rxjava/jni-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/swagger-rxjava-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-rxjava/reflect-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/swagger-rxjava-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-rxjava/resource-config.json
Apply jar:file:///Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/swagger-rxjava-1.0.0-SNAPSHOT.jar!/META-INF/native-image/net.jbw/swagger-rxjava/proxy-config.json
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
/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/llvm-wrapper-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/svm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/objectfile.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/graal-llvm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/llvm-platform-specific-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/javacpp-shadowed.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/svm-llvm.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/builder/pointsto.jar:/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/library-support.jar:/Users/joerg/.m2/repository/org/graalvm/nativeimage/svm/20.0.0/svm-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/sdk/graal-sdk/20.0.0/graal-sdk-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/nativeimage/objectfile/20.0.0/objectfile-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/nativeimage/pointsto/20.0.0/pointsto-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/truffle/truffle-nfi/20.0.0/truffle-nfi-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/truffle/truffle-api/20.0.0/truffle-api-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/compiler/compiler/20.0.0/compiler-20.0.0.jar:/Users/joerg/.m2/repository/io/reactivex/rxjava2/rxjava/2.2.18/rxjava-2.2.18.jar:/Users/joerg/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/retrofit/2.7.1/retrofit-2.7.1.jar:/Users/joerg/.m2/repository/com/squareup/okhttp3/okhttp/3.14.4/okhttp-3.14.4.jar:/Users/joerg/.m2/repository/com/squareup/okio/okio/1.17.2/okio-1.17.2.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/adapter-rxjava2/2.7.1/adapter-rxjava2-2.7.1.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-gson/2.7.1/converter-gson-2.7.1.jar:/Users/joerg/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-scalars/2.7.1/converter-scalars-2.7.1.jar:/Users/joerg/.m2/repository/io/gsonfire/gson-fire/1.8.3/gson-fire-1.8.3.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.client/1.0.2/org.apache.oltu.oauth2.client-1.0.2.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.common/1.0.2/org.apache.oltu.oauth2.common-1.0.2.jar:/Users/joerg/.m2/repository/org/json/json/20140107/json-20140107.jar:/Users/joerg/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar:/Users/joerg/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar:/Users/joerg/.m2/repository/io/swagger/core/v3/swagger-annotations/2.1.1/swagger-annotations-2.1.1.jar:/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/swagger-rxjava-1.0.0-SNAPSHOT.jar \
-H:Path=/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/classes \
-H:ClassInitialization=org.graalvm.polyglot:build_time \
-H:Features=org.graalvm.home.HomeFinderFeature \
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
-H:Name=swagger-rxjava-osx-x86_64 \
-H:CLibraryPath=/Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/lib/svm/clibraries/darwin-amd64
]
[swagger-rxjava-osx-x86_64:4481]    classlist:   1,989.44 ms,  1.24 GB
[swagger-rxjava-osx-x86_64:4481]        (cap):     698.08 ms,  1.24 GB
[swagger-rxjava-osx-x86_64:4481]        setup:   1,782.69 ms,  1.24 GB
[swagger-rxjava-osx-x86_64:4481]   (typeflow):  11,776.45 ms,  3.31 GB
[swagger-rxjava-osx-x86_64:4481]    (objects):  10,040.77 ms,  3.31 GB
[swagger-rxjava-osx-x86_64:4481]   (features):     778.92 ms,  3.31 GB
[swagger-rxjava-osx-x86_64:4481]     analysis:  23,174.63 ms,  3.31 GB
Printing call tree to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/classes/reports/call_tree_swagger-rxjava-osx-x86_64_20200225_135237.txt
Printing list of used methods to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/classes/reports/used_methods_swagger-rxjava-osx-x86_64_20200225_135238.txt
Printing list of used classes to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/classes/reports/used_classes_swagger-rxjava-osx-x86_64_20200225_135238.txt
Printing list of used packages to /Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/classes/reports/used_packages_swagger-rxjava-osx-x86_64_20200225_135238.txt
[swagger-rxjava-osx-x86_64:4481]     (clinit):     388.75 ms,  3.74 GB
[swagger-rxjava-osx-x86_64:4481]     universe:     945.12 ms,  3.74 GB
[swagger-rxjava-osx-x86_64:4481]      (parse):   2,996.53 ms,  3.74 GB
[swagger-rxjava-osx-x86_64:4481]     (inline):   1,571.94 ms,  3.74 GB
[swagger-rxjava-osx-x86_64:4481]    (compile):  11,695.96 ms,  3.74 GB
[swagger-rxjava-osx-x86_64:4481]      compile:  17,349.83 ms,  3.74 GB
[swagger-rxjava-osx-x86_64:4481]        image:   2,171.53 ms,  3.74 GB
Fatal error: com.oracle.svm.core.util.VMError$HostedError: com.oracle.svm.core.util.UserError$UserException: Static field or an object referenced from a static field changed during native image generation?
  object:java.lang.ref.SoftReference@19ecfb89  of class: java.lang.ref.SoftReference
  reachable through:
    object: [Ljava.lang.ref.SoftReference;@6e04bbae  of class: java.lang.ref.SoftReference[]
    object: Form(Object,Object,int,Object)void  of class: java.lang.invoke.MethodTypeForm
    object: (MethodHandle,Object,int,Object)void  of class: java.lang.invoke.MethodType
    object: MethodHandle(MethodHandle,Object,int,Object)void  of class: java.lang.invoke.DirectMethodHandle
    object: [Ljava.lang.invoke.MethodHandle;@432ff19d  of class: java.lang.invoke.MethodHandle[]
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
  object:java.lang.ref.SoftReference@19ecfb89  of class: java.lang.ref.SoftReference
  reachable through:
    object: [Ljava.lang.ref.SoftReference;@6e04bbae  of class: java.lang.ref.SoftReference[]
    object: Form(Object,Object,int,Object)void  of class: java.lang.invoke.MethodTypeForm
    object: (MethodHandle,Object,int,Object)void  of class: java.lang.invoke.MethodType
    object: MethodHandle(MethodHandle,Object,int,Object)void  of class: java.lang.invoke.DirectMethodHandle
    object: [Ljava.lang.invoke.MethodHandle;@432ff19d  of class: java.lang.invoke.MethodHandle[]
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
[INFO] Total time:  01:00 min
[INFO] Finished at: 2020-02-25T13:52:59+01:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.graalvm.nativeimage:native-image-maven-plugin:20.0.0:native-image (default) on project swagger-rxjava: Execution of /Library/Java/JavaVirtualMachines/graalvm-ce-java11-20.0.0/Contents/Home/bin/native-image -cp /Users/joerg/.m2/repository/org/graalvm/nativeimage/svm/20.0.0/svm-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/sdk/graal-sdk/20.0.0/graal-sdk-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/nativeimage/objectfile/20.0.0/objectfile-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/nativeimage/pointsto/20.0.0/pointsto-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/truffle/truffle-nfi/20.0.0/truffle-nfi-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/truffle/truffle-api/20.0.0/truffle-api-20.0.0.jar:/Users/joerg/.m2/repository/org/graalvm/compiler/compiler/20.0.0/compiler-20.0.0.jar:/Users/joerg/.m2/repository/io/reactivex/rxjava2/rxjava/2.2.18/rxjava-2.2.18.jar:/Users/joerg/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/retrofit/2.7.1/retrofit-2.7.1.jar:/Users/joerg/.m2/repository/com/squareup/okhttp3/okhttp/3.14.4/okhttp-3.14.4.jar:/Users/joerg/.m2/repository/com/squareup/okio/okio/1.17.2/okio-1.17.2.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/adapter-rxjava2/2.7.1/adapter-rxjava2-2.7.1.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-gson/2.7.1/converter-gson-2.7.1.jar:/Users/joerg/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar:/Users/joerg/.m2/repository/com/squareup/retrofit2/converter-scalars/2.7.1/converter-scalars-2.7.1.jar:/Users/joerg/.m2/repository/io/gsonfire/gson-fire/1.8.3/gson-fire-1.8.3.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.client/1.0.2/org.apache.oltu.oauth2.client-1.0.2.jar:/Users/joerg/.m2/repository/org/apache/oltu/oauth2/org.apache.oltu.oauth2.common/1.0.2/org.apache.oltu.oauth2.common-1.0.2.jar:/Users/joerg/.m2/repository/org/json/json/20140107/json-20140107.jar:/Users/joerg/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar:/Users/joerg/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar:/Users/joerg/.m2/repository/io/swagger/core/v3/swagger-annotations/2.1.1/swagger-annotations-2.1.1.jar:/Users/joerg/Documents/Repositories/github.com/GraalVMNativeTests/swagger-rxjava/target/swagger-rxjava-1.0.0-SNAPSHOT.jar -H:Class=net.jbw.App -H:Name=swagger-rxjava-osx-x86_64 returned non-zero result -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException

 ```

#### Run Native
> ./target/classes/swagger-rxjava-osx-x86_64
