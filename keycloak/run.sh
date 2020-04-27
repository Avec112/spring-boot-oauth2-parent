#!/bin/bash


wget -c https://downloads.jboss.org/keycloak/9.0.3/keycloak-9.0.3.zip

unzip -n keycloak-9.0.3.zip

cd keycloak-9.0.3/bin
./add-user-keycloak.sh -r master -u admin -p password
#./add-user-keycloak.sh -r oauth2-sample -u user1 -p password
 ./standalone.sh -Djboss.socket.binding.port-offset=10 -Dkeycloak.migration.action=import -Dkeycloak.migration.provider=singleFile -Dkeycloak.migration.file=../../oauth2-sample-realm-config.json -Dkeycloak.migration.strategy=OVERWRITE_EXISTING
