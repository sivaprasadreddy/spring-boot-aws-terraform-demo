# Random Jokes

```shell
$ ./mvnw clean package
$ ./mvnw spring-boot:build-image -DskipTests -Dspring-boot.build-image.imageName=sivaprasadreddy/random-jokes
$ docker run -d -p 8181:8080 sivaprasadreddy/random-jokes
```

## Using docker-compose

```shell
$ docker-compose up --build -d
$ docker-compose logs -f 
$ docker-compose down 
```
