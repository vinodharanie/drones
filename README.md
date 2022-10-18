Drones

To build and run 
1) ./gradlew clean build
2) ./gradlew bootRun 

Assumptions
1) Medication image are stored in the s3 bucket and UI passes the image S3 bucket url.



First endpoint - http://localhost:8010/v1/drones -> POST
{
"serialNumber" : "testttt",
"modelId" : "3",
"weightLimit" : "33333",
"batteryCapacity" : "32.9",
"state" : "2"
}

Second endpoint - http://localhost:8010/v1/drones/{droneId}/medications -> PUT
[1,4]

Third endpoint - http://localhost:8010/v1/drones/{droneId}/medications -> GET

Forth endpoint - http://localhost:8010/v1/drones/states -> GET



