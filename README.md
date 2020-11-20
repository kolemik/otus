# OTUS
## dz02

How to build docker image:
    
    export DOCKER_BUILDKIT=1
    docker build -t kolemik/otus:dz02 .

How to prepare configmap
    
    kubectl create configmap flyway-config --from-file=sql/ --dry-run=client -o yaml > flyway-configmap.yaml
    
How to run docker image:

    docker run -d -p 8000:8000 kolemik:dz02
    
How to check URLs:

* http://localhost:8000/otusapp/kolemik/health
* http://localhost:8000/otusapp/kolemik/hello
* http://localhost:8000/otusapp/kolemik/hello/Qwe

