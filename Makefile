NAME?=contact
CONTAINER_NAME?=contacts-container
TAG?=latest
PORT?=10900

build:
	mvn clean package

run: build
	docker rm -f ${CONTAINER_NAME} || true
	docker image build -t ${NAME}:${TAG} .
	docker run -dit -p ${PORT}:8080 --name ${CONTAINER_NAME} ${NAME}

.PHONY: run