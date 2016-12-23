FROM airhacks/wildfly

MAINTAINER Robert Brem <brem_robert@hotmail.com>

ADD target/battleapp.war ${DEPLOYMENT_DIR}