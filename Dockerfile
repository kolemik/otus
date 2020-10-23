FROM payara/micro

COPY target/dz01.war $DEPLOY_DIR

CMD ["--deploymentDir", "/opt/payara/deployments", "--contextroot", "ROOT"]