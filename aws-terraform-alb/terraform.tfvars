name               = "random-jokes"
environment        = "test"
region             = "us-east-1"
availability_zones = ["us-east-1a", "us-east-1b"]
public_subnets     = ["10.0.16.0/20", "10.0.48.0/20"]
s3_bucket_name     = "sivalabsrandomjokes"
//container_image    = "sivaprasadreddy/random-jokes:latest"
container_image    = "972824157910.dkr.ecr.us-east-1.amazonaws.com/random-jokes:0.0.1"
container_memory   = 1024
