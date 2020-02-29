# TestTask SPA

#### Single page application + RestAPI and Security
Developed with Java 8, JPA, Maven, Spring Framework, MySQL, Swagger

## Clone the repository
Run the command:
```
git clone https://github.com/BalthazRBlake/testTask.git
```

## Configure DataBase
Change schema, user and password for your own details in the file
> application.properties
```java
 8  spring.datasource.url=jdbc:mysql://localhost/testtask?createDatabaseIfNotExist=true
 9  spring.datasource.username=root
10  spring.datasource.password=MySQLPass
```
_we are using **testtask** schema for DataBase dumping_

## Build | Run the Project
#### To build the Project
First, go to the folder **testtask** with the command:
```
cd testtask
```
Then, run the command:
```
mvn clean install
```
#### To run the project
First, go to the folder **target** with the command:
```
cd target
```
Then, run the command:
```
java -jar testtask-0.0.1-SNAPSHOT.jar
```

## DataBase Dumping
Now that the project is up and running we can dump the test data to the new generated schema **testtask** (or the schema you defined in application.properties)

To attach your myFile.sql to the new schema run the following command:
```
mysql -u myUser -p testtask < myFile.sql
```
_**change myUser** for your user name (we have **root** in application.properties) and **change myFile.sql** for the file with data, you can find a testtask.sql file ready to use_

## Open the SPA
Go to the address:
> http://localhost:5000/
You will be ask for **username = TestTask** and **passaword = TestTask**

To navigate **RestAPI Swagger documentation** go to:
> http://localhost:5000/swagger-ui.html

To get the **JWT** make a **POST request** to:
> http://localhost:5000/api/authenticate
Enter the credentials:
```
{
  "password": "TestTask",
  "username": "TestTask"
}
```
To send a REST API request set the header:
> Authorization = FHHF "generated jwt"

**change "generated jwt"** for the POST response from _ http://localhost:5000/api/authenticate _, it looks something like:
>"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUZXNUYXNrIiwiZX"

So, the final header value would be like **FHHF eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUZXNUYXNrIiwiZX**
