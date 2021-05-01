# brave-clojure-on-aws
Exercises from the book "Clojure for the brave and true" deployed on Sleipnir, i.e. AWS serverless solutions.

![Slepnir](https://user-images.githubusercontent.com/807663/115037584-e8232100-9ece-11eb-91aa-ae71b7bfb66a.png)

## Requirements

To be able to deploy the project, development dependencies have to be installed:

1. Clojure
2. Leiningen

## Deploying

AWS Lambdas are managed with [Serverless](https://serverless.com/) framework.

To build and deploy a stack:
```
lein uberjar
npx sls deploy -v --stage dev
```

Currently the uberjar contains handlers for all the lambda functions, which shall be improved later.

## Development

Every book chapter is a separated namespace and is deployed to a dedicated AWS lambda function e.g.,
brave-clojure.chapter3 namespace for the 3rd chapter is deployed to an AWS lambda function named chapter3.

## Run locally

Is on the roadmap

## Tests

Is on the roadmap
