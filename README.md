# Spring Cloud application integration with Hashcorp vault

### Pre-requisite
* Some knowledge of Spring boot and docker will be helpful.

Here, I am using docker for ease of set up


Run below command to run vault server in development mode
```
docker run --cap-add=IPC_LOCK -d --name=dev-vault -p8200:8200 -e 'VAULT_DEV_ROOT_TOKEN_ID=myroot' vault
```

Confirm that docker is up using below command 
```
 ritgirdh$ docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
9ad13a11b2d5        vault               "docker-entrypoint.s…"   25 hours ago        Up 25 hours         0.0.0.0:8200->8200/tcp   dev-vault
```

Login http://localhost:8200/ui/ with token value myroot
// TODO - screen shot

Now create secret for weather service 

```
docker exec -it 9ad13a11b2d5 sh
/ # vault kv put secret/weather-service weather.username=demouser weather.password=demopassword
Get "https://127.0.0.1:8200/v1/sys/internal/ui/mounts/secret/weather-service": http: server gave HTTP response to HTTPS client
/ # export VAULT_ADDR="http://127.0.0.1:8200"
/ # export export VAULT_TOKEN="myroot"
/ # vault kv put secret/weather-service weather.username=demouser weather.password=demopassword
Key              Value
---              -----
created_time     2021-05-05T15:45:20.1485816Z
deletion_time    n/a
destroyed        false
version          1
```

Now add for QA and prod profile
```
docker exec -it 9ad13a11b2d5 sh
/ # vault kv put secret/weather-service/qa weather.username=qauser weather.password=qapassword
Key              Value
---              -----
created_time     2021-05-05T15:46:25.801457Z
deletion_time    n/a
destroyed        false
version          1
```

```
docker exec -it 9ad13a11b2d5 sh
/ # vault kv put secret/weather-service/prod weather.username=produser weather.password=prodpassword
Key              Value
---              -----
created_time     2021-05-05T15:46:50.5295174Z
deletion_time    n/a
destroyed        false
version          1
```
```
//TODO Screen shot
```

Build microservice
```
ritgirdh$ cd microservice/
ritgirdh$ mvn clean install
....
```
Run 
``` 
docker run -d -p8080:8080 weather-service -spring.active.profile=qa
```
curl -ivk http://locahost:8080/weather
In qa Sunny
In prod Rainy


Now make change in vault and see whether its getting reflected in the application 


Happy learning!
