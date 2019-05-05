![Logo](art/logo.png)

[![Build Status](https://travis-ci.com/CodeByAB/postnummer.svg?branch=master)](https://travis-ci.com/CodeByAB/postnummer)

## Dependencies
---
  * Node (10.xx)
  * Docker
  * Java?


## Building
---


### 1  
```bash
> sh setup.sh
```

if the script above does not work -- try

```bash
> bash -x setup.sh
```

### 2

```bash
> docker-compose build
```

## Running locally
---

```bash
> docker-compose up 
# Or 
# > docker-compose run [flags] (service) (e.g only api or web)
```


## Deploying
---

....


## Health check
---

....

<br/>
<br/>
<br/>
<br/>
<br/>






# deprecated (I will remove as soon as i've added the java api to docker
## How to start the postnummer application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/postnummer-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

## Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

## Status


