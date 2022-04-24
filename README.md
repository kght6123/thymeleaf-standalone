# thymeleaf-standalone

## Reference

https://github.com/thymeleaf/thymeleaf/issues/561#issuecomment-490648829

## With Docker Run

```sh
$ docker volume create --name maven-repo
$ docker run -it -v $PWD:/usr/src/app/thymeleaf-standalone -v maven-repo:/root/.m2 -w /usr/src/app/thymeleaf-standalone maven:3.8.5-amazoncorretto-11 mvn package
$ docker run -it -v $PWD:/usr/src/app/thymeleaf-standalone -v maven-repo:/root/.m2 -w /usr/src/app/thymeleaf-standalone maven:3.8.5-amazoncorretto-11 mvn exec:java

<!DOCTYPE HTML>
<html>
<head>
    <title>Name & Date HTML example</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p >Hello, foo!!</p>
    <p>Today is 2022-04-24T16:10:06.191229.</p>
                1
                2
                1
</body>
</html>
Hello World!

$ docker run -it -v $PWD:/usr/src/app/develop maven:3.8.5-amazoncorretto-11 bash
```

## With Docker Proect Setup

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
```
