# OTUS
## dz02

How to build docker image:
    
    docker image build -t kolemik:dz02 .
    
How to run docker image:

    docker run -d -p 8000:8000 kolemik:dz02
    
How to check URLs:

* http://localhost:8000/otusapp/kolemik/health
* http://localhost:8000/otusapp/kolemik/hello
* http://localhost:8000/otusapp/kolemik/hello/Qwe

