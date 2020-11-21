NAME?=contacts
CONTAINER_NAME?=contacts-container
TAG?=latest
PORT?=10900

build:
	mvn clean package

run: build
	docker network create keycloak-network
	docker rm -f ${CONTAINER_NAME} || true
	docker build -t ${NAME}:${TAG} .
	docker run -dit -p ${PORT}:9080 --name ${CONTAINER_NAME} ${NAME}

.PHONY: run