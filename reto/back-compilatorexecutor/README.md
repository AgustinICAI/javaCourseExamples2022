## maven build and run
```
$ mvn compile
$ mvn function:run
```

## to invoke it
### locally
```
curl -i -F className=AppTest -F method=test -F upload=@"./AppTest.java" http://localhost:8080/
```
### remote
```
$ curl -i -F className=AppTest -F method=test -F upload=@"./AppTest.java" https://europe-west1-icai-293810.cloudfunctions.net/function-1
```
