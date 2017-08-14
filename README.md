# car-tracker-seed
seed for the Full-Stack IOT training project: car-tracker

## directory structure:

**`client`** [*module-client*]: contains ui app (HTML, CSS, JS, fonts, images)      
**`api`** [*module-api*]: contains REST API

## mock sensor: 
[http://mocker.egen.io](http://mocker.egen.io)

## requirements:
[https://learn.egen.io](https://learn.egen.io/courses/overview.html)

## Api Endpoints
#Module Vehicle: 
GET localhost:8080/api/vehicles - To get all the details of vehicles
PUT localhost:8080/api/vehicles - To put the details of vehicles
GET localhost:8080/api/vehicles/(Vinnumber) - To get the details of a vehicles with a vin number
DELETE localhost:8080/api/vehicles/(Vinnumber) -  To delete the details of a vehicle with a vin number

#Module Readings:
GET localhost:8080/api/readings - To get details of all the readings received
POST localhost:8080/api/readings - To post readings of a vehicle

#Module Alerts:
GET localhost:8080/api/alerts - To get details of all the alerts triggered
GET localhost:8080/api/alerts/vin/(vinnumber) - To get the alerts of a vehicles with a vin
GET localhost:8080/api/alerts/priority/(priorityvalue) - To get only the specified priority alerts


##Whenever the application receives a reading it checks if it has the details of the vehicle in its database.
If present it checks if it has any issue and if it has it triggers an alert. If there is no such vehicles, it
just saves the vehicles in the database.

