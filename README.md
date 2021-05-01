# brave-clojure-on-aws
Exercises from the book "Clojure for the brave and true" deployed on Sleipnir, i.e. AWS serverless solutions.

![Slepnir](https://user-images.githubusercontent.com/807663/115037584-e8232100-9ece-11eb-91aa-ae71b7bfb66a.png)

## Deploying

AWS Lambdas are managed with [Serverless](https://serverless.com/) framework.

To build and deploy a stack
```
lein uberjar
npx sls deploy -v --stage dev
```

Currently the uberjar contains handlers for all the lambda functions, which shall be improved later.

## Run locally

Is on the roadmap

## Tests

Is on the roadmap
