## SpringBoot Native

#### Build and Test

```bash
# Native compile
$ ./gradlew nativeCompile
$ build/native/nativeCompile/spring-native
# Native test
$ ./gradlew nativeTest

# Create container image
$ ./gradlew bootBuildImage
$ docker run --rm -p 8080:8080 spring-native:0.0.1
```