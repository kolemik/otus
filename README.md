# OTUS
## dz01

How to build docker image:
    
    docker image build -t kolemik:dz01 .
    
How to run docker image:

    docker run -d -p 8080:8080 kolemik:dz01
    
How to check URLs:

* http://localhost:8080/dz01/controller/health
* http://localhost:8080/dz01/controller/hello
* http://localhost:8080/dz01/controller/hello/Qwe

