# OTUS
## dz01

How to build docker image:
    
    docker image build -t kolemik:dz01 .
    
How to run docker image:

    docker run -d -p 8000:8000 kolemik:dz01
    
How to check URLs:

* http://localhost:8000/otusapp/kolemik/health
* http://localhost:8000/otusapp/kolemik/hello
* http://localhost:8000/otusapp/kolemik/hello/Qwe

