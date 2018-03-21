# fn-recommend

Fn Project demo in Java implements a recommendation engine mock.

## Use case

You can get travel recommendation for a particular traveller based on age, destination and month of travelling.

## Implementation

- uses Jackson marshalling for JSON parameter (Traveller.java)
- can be deployed on remote Fn as shown here on [munz & more blog](http://www.munzandmore.com/2018/aws/fn-project-on-public-clouds)

## Test Data

Test data is provided in [./testdata](./testdata)

e.g. use the following command to call the recommendation engine:

```
curl -X POST --data @testdata/syd.json localhost:8080/r/advtravel/recommend
```

## Recommended Demo

###  Preparation

#### remote

``` 
fn apps d advtravel
fn start
```

#### local 

```
docker login DOCKER_ID  
export FN_REGISTRY=DOCKER_ID  
export FN_API_URL=http://microservices.click:8080
fn deploy --app advtravel  
```


### Live Demo Local Side

#### show local app (or deploy first)
```

fn apps list
[fn deploy --app advtravel --local]
fn apps l

```
#### show route

```
fn routes list advtravel
```

#### show logic and data

```
cd src/main/java/com/munzandmore/fn/
grep handle *.java
cat Traveller.java
``` 

#### test with curl  or Postman

```
curl -X POST --data @testdata/xyz.json localhost:8080/r/advtravel/recommend
```

### Live Demo Remote Side

```
fn apps c advtravel 
fn routes l advtravel
fn routes c advtravel /fn-recommend recommend:0.0.31
```

Then test from local curl

```
curl -X POST --data @testdata/xyz.json REMOTE_IP:8080/r/advtravel/recommend
```

Should work!
