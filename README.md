# Spring Boot Application to demonstrate AWS Rekognition for Text Detection


## Getting Started

* Set properties `aws.access-key` and `aws.secret-key` in application.properties or via command line properties (see https://aws.amazon.com/de/blogs/security/wheres-my-secret-access-key/)
* Start application
* Call POST `http://localhost:8080/v1/api/image/text-detection` with form-data key=image and value=<your image>
