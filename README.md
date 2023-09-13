# SpringBootCRUDMySQL
A Basic CRUD Operation using Spring Boot and MySql.
Create, Insert, Update, Delete Examples are there

To Insert/Post Request
EndPoint -> http://localhost:8080/user/postUser
Json 
{
  "username": "Prakash123",
  "email":"Prakash123@gmail.com",
  "dob":"1997-10-04T15:53:16"
}


To Get All Users
http://localhost:8080/user/getAllUser


To Get Specofic user
http://localhost:8080/user/getUserById/2


To Update
http://localhost:8080/user/putUser/2
Json 
{
  "username": "Pawan123",
  "email":"Prakash123@gmail.com",
  "dob":"1997-10-04T15:53:16"
}


To Delete
http://localhost:8080/user/deleteUserById/2
