# OTUS
## dz02

### How to build docker image:
    
    export DOCKER_BUILDKIT=1
    docker build -t kolemik/otus:dz02 .

### How to prepare configmap:
    
    kubectl create configmap flyway-config --from-file=sql/ --dry-run=client -o yaml > flyway-configmap.yaml
or
    
    kubectl create configmap flyway-config --from-file=sql/ --dry-run=client -o yaml | kubectl apply -f -

### How to restart deployment

    kubectl rollout restart deployment.apps/dz02-deployment

### How to start minikube

    minikube start --vm-driver=docker --ports=[0.0.0.0:32000:32000,0.0.0.0:8080:80]
    
### How to run docker image:

    docker run -d -p 8000:8000 kolemik:dz02
    
### How to check URLs:

* http://localhost:8000/otusapp/kolemik/health
* http://localhost:8000/otusapp/kolemik/hello
* http://localhost:8000/otusapp/kolemik/hello/Qwe

