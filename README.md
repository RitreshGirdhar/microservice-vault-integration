# Spring Cloud based Microservice and Hashcorp vault integration

### Pre-requisite
* Some knowledge of Spring boot and docker will be helpful.

Here, I am using docker for ease of set up
```
docker run --cap-add=IPC_LOCK -d --name=dev-vault -p8200:8200 -e 'VAULT_DEV_ROOT_TOKEN_ID=myroot' vault
```

### Login http://localhost:8200/ui/ with token value myroot


Happy learning!
