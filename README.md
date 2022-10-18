Drones

To build and run -> ./gradlew clean bootRun 

Assumptions
1) Medication image are stored in the s3 bucket and UI passes the image S3 bucket url.
2) Medicine quantity is not considered
3) Drone States
   IDLE(1), LOADING(2), LOADED(3), DELIVERING(4), DELIVERED(5), RETURNING(6)
4) Drone model
   Lightweight(1), Middleweight(2), Cruiserweight(3), Heavyweight(4)


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

Fifth endpoint - http://localhost:8010/v1/drones/{droneId}/battery-capacitor -> GET

