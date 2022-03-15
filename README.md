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

## Deploying on AWS
```shell
$ aws ecr create-repository --repository-name random-jokes --region ${AWS_REGION}
$ aws ecr get-login-password --region ${AWS_REGION} | docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/random-jokes
$ ./mvnw spring-boot:build-image -DskipTests -Dspring-boot.build-image.imageName=${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/random-jokes:0.0.1
$ docker push ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/random-jokes:0.0.1

## Deploy without ALB
$ cd aws-terraform
$ terraform init
$ terraform validate
$ terraform apply
$ terraform destroy
```
