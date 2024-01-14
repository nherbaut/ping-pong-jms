k: clean build-push k-refresh k-logs

clean:
	mvn clean
build: clean
	quarkus build -Dquarkus.container-image.build=true
build-push:
	quarkus build -Dquarkus.container-image.build=true -Dquarkus.container-image.push=true
run:
	quarkus dev
run-docker:
	docker run -ti \
	--name pingpongjms \
	--rm=true \
	-e QUARKUS_ARTEMIS_URL="tcp://broker.miage.dev:80" \
	-e QUARKUS_ARTEMIS_USERNAME="Raymond" \
	-e QUARKUS_ARTEMIS_PASSWORD="ac3Bae4pheay" \
	-p 8080:8080 \
	nherbaut/ping-pong-jms:1.0.0-SNAPSHOT

	
