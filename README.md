# appointment-service

A service to schedule appointments with avi medical practices.


## Local Development

This project is built with Java 17 and Gradle.

### Starting the service

`./gradlew clean bootRun`

### Running the tests

`./gradlew clean test`

## APIs

### Create Appointment

```
curl --location --request POST 'localhost:8080/appointments' \
--header 'Content-Type: application/json' \
--data-raw '{
    "notes": "Hey I am really sick!",
    "channel": "VIDEO_CALL",
    "reasonId":"2",
    "symptoms": ["FEVER","COUGH"],
    "startTime": "2022-07-23T07:14:27.831Z",
    "practiceId": "15"
}'
```

### Get Reasons

```
curl --location --request GET 'localhost:8080/reasons'
```

### Create Reason

```
curl --location --request POST 'localhost:8080/reasons' \
--header 'Content-Type: application/json' \
--data-raw '{
    "title": "Title",
    "description": "llorem ipsum"
}'
```
