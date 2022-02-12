# Zoho-comments

It is a Basic  Comment App for different users. 

Technology Used : JAVA Swing, Mysql.
Tools Used : Eclipse , WampServer.

Mysql Table : signup,login,comment


How to Run : Download the project in your eclipse and run , but for database connection you have to install Wampserver and in that you have to make mentioned tables by yourself.
-> Also user has to add mysql driver in project for executing queries/ making connection with database. 
->Email should be in "@gmail.com" format.
-> Password should be greater than 8 size and also contains a upper case Alphabet & character.


Process:  -> First in Login class ,if User is using first time , user has to create account by using signup option and there he has to add Email,Password & secret code.After creating it will redirect user to login class
->In the login class user has to pass valid credentials otherwise it will show Error .After logging in user can filter comments for there username and also can post the comment and it will show there email and comment that user did.


Show Password: 
![Screenshot (181)](https://user-images.githubusercontent.com/70019204/153707318-3329957f-9ec8-4d32-9ada-63ab8d50889d.png)

Comment Class
![Screenshot (182)](https://user-images.githubusercontent.com/70019204/153707320-e2843537-096c-4273-996a-92f4682b49d5.png)

Testing by clicking on submit
![Screenshot (183)](https://user-images.githubusercontent.com/70019204/153707321-85d5e602-66a5-4bc4-856e-52ccdbfa0ca2.png)

After Submit
![Screenshot (184)](https://user-images.githubusercontent.com/70019204/153707322-1fcb9ec4-178c-43ad-8b50-1e0582686be1.png)

Filter Button
![Screenshot (185)](https://user-images.githubusercontent.com/70019204/153707323-73eeb409-2534-470a-8133-412ebc381b48.png)

After Filter
![Screenshot (186)](https://user-images.githubusercontent.com/70019204/153707324-d33930c5-885e-40d5-a47e-716c526a1152.png)


![Screenshot (187)](https://user-images.githubusercontent.com/70019204/153707325-5f294120-642b-4ad7-bf98-45c5de77e5e0.png)

Reset Password
![Screenshot (188)](https://user-images.githubusercontent.com/70019204/153707328-9b2261a5-8f4c-48ee-bedc-9807d987c43e.png)

Poor Password
![Screenshot (189)](https://user-images.githubusercontent.com/70019204/153707329-c5925a93-8a66-425a-9a97-a3bf92096c12.png)


Sign Up class
![Screenshot (179)](https://user-images.githubusercontent.com/70019204/153707332-72c7a8f8-a19a-4e1d-9c61-8ef5dee761fb.png)

Checking for valid credentials
![Screenshot (180)](https://user-images.githubusercontent.com/70019204/153707333-965a1b84-1520-4e6f-a5cd-9e0ca304bd39.png)








Database Tables:- 

mysql>
mysql> use online
Database changed
mysql> ;
ERROR:
No query specified

mysql> select *from signup;
+------------------------+----------+-------------+
| Email                  | Password | Secret_Code |
+------------------------+----------+-------------+
| jaikumar8503@gmail.com | 1234     | jai         |
| tanish@gmail.com       | 12345    | tanish      |
| fsdfa@g.com            | asdsa    | dsdsd       |
| jai1213@gmail.com      | k        | k           |
| jai@gmail.com          | Jai123@@ | sdsds       |
| tanish@gmail.com       | Jai123@@ | jai         |
| tanish@gmail.com       | Jai123@@ | 12345       |
+------------------------+----------+-------------+
7 rows in set (0.00 sec)

mysql> select *from signup;
+------------------------+----------+-------------+
| Email                  | Password | Secret_Code |
+------------------------+----------+-------------+
| jaikumar8503@gmail.com | 1234     | jai         |
| tanish@gmail.com       | 12345    | tanish      |
| fsdfa@g.com            | asdsa    | dsdsd       |
| jai1213@gmail.com      | k        | k           |
| jai@gmail.com          | Jai123@@ | sdsds       |
| tanish@gmail.com       | Jai123@@ | jai         |
| tanish@gmail.com       | Jai123@@ | 12345       |
+------------------------+----------+-------------+
7 rows in set (0.00 sec)

mysql> select *from signup;
+------------------------+----------+-------------+
| Email                  | Password | Secret_Code |
+------------------------+----------+-------------+
| jaikumar8503@gmail.com | 1234     | jai         |
| tanish@gmail.com       | 12345    | tanish      |
| fsdfa@g.com            | asdsa    | dsdsd       |
| jai1213@gmail.com      | k        | k           |
| jai@gmail.com          | Jai123@@ | sdsds       |
| tanish@gmail.com       | Jai123@@ | jai         |
| tanish@gmail.com       | Jai123@@ | 12345       |
| jai8503@gmail.com      |          | 12345       |
+------------------------+----------+-------------+
8 rows in set (0.00 sec)

mysql> show tables;
+------------------+
| Tables_in_online |
+------------------+
| comment          |
| login            |
| signup           |
+------------------+
3 rows in set (1.25 sec)

mysql> select *from signup;
+------------------------+---------------------+-------------+
| Email                  | Password            | Secret_Code |
+------------------------+---------------------+-------------+
| jaikumar8503@gmail.com | 1234                | jai         |
| tanish@gmail.com       | Jai123@@            | tanish      |
| fsdfa@g.com            | asdsa               | dsdsd       |
| jai1213@gmail.com      | k                   | k           |
| jai@gmail.com          | Jai123@@            | sdsds       |
| tanish@gmail.com       | Jai123@@            | jai         |
| tanish@gmail.com       | Jai123@@            | 12345       |
| jai8503@gmail.com      | dsadsaksdsdsadssdsa | 12345       |
| test@gmail.com         | Jai123@@            | jai         |
+------------------------+---------------------+-------------+
9 rows in set (0.02 sec)

mysql> select *from login;
Empty set (0.05 sec)

mysql> select *from comment;
+------------------------+--------------------------+
| Email                  | Comment                  |
+------------------------+--------------------------+
| jaikumar8503@gmail.com | First project            |
| jaikumar8503@gmail.com | Second project           |
| jaikumar8503@gmail.com | jai                      |
| tanish@gmail.com       | dafsfd                   |
| tanish@gmail.com       | jjjj                     |
| tanish@gmail.com       |                          |
| tanish@gmail.com       | sdass aadfdsf dsfd sd df |
| tanish@gmail.com       | jja                      |
| tanish@gmail.com       | is it working?           |
| tanish@gmail.com       | how are you?             |
| tanish@gmail.com       | dekh                     |
| tanish@gmail.com       | dsadsads                 |
| tanish@gmail.com       | xcxcxczczx               |
| tanish@gmail.com       | cdsddddddddddddd         |
| tanish@gmail.com       | dwaqqqqqqqqqqq           |
| tanish@gmail.com       | wqqqqqqqqqqqqqqqqqqq     |
| tanish@gmail.com       | wqqqqqqqqqqqqqqqq        |
| tanish@gmail.com       | wqqqqqqqqqqq             |
| tanish@gmail.com       | kkk                      |
| tanish@gmail.com       | kk                       |
| tanish@gmail.com       | kk                       |
| tanish@gmail.com       | kk                       |
| tanish@gmail.com       | k                        |
| tanish@gmail.com       | dd                       |
| jai8503@gmail.com      | jjjj                     |
| test@gmail.com         | it is testing .          |
| test@gmail.com         | testing                  |
| test@gmail.com         | testing                  |
| test@gmail.com         | testing                  |
| test@gmail.com         | testing                  |
| test@gmail.com         | testing                  |
+------------------------+--------------------------+
31 rows in set (0.02 sec)

mysql>
