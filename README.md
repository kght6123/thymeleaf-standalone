# thymeleaf-standalone

## Reference

https://github.com/thymeleaf/thymeleaf/issues/561#issuecomment-490648829

## With Docker

```sh
$ docker run maven:3.8.5-amazoncorretto-11 java -version
$ docker run maven:3.8.5-amazoncorretto-11 mvn -version
$ cd develop
$ docker run -it -v $PWD:/usr/src/app/develop maven:3.8.5-amazoncorretto-11 bash

# mvn archetype:generate -DgroupId=jp.kght6123.thymeleaf.standalone -DartifactId=thymeleaf-standalone -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
# mv ./thymeleaf-standalone /usr/src/app/develop
# exit

$ sudo chown -R kght6123:kght6123 thymeleaf-standalone/*
$ cd thymeleaf-standalone
$ docker run -it -v $PWD:/usr/src/app/thymeleaf-standalone maven:3.8.5-amazoncorretto-11 sh -c "cd /usr/src/app/thymeleaf-standalone && mvn package"
$ docker run -it -v $PWD:/usr/src/app/thymeleaf-standalone maven:3.8.5-amazoncorretto-11 java -cp /usr/src/app/thymeleaf-standalone/target/thymeleaf-standalone-1.0-SNAPSHOT.jar jp.kght6123.thymeleaf.standalone.App
Hello World!

https://github.com/thymeleaf/thymeleaf/issues/561#issuecomment-490648829

docker volume create --name maven-repo
```

## Memo

https://www.mojohaus.org/exec-maven-plugin/examples/example-exec-for-java-programs.html

