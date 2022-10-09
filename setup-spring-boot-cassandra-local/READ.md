# Local Database Connection

# Steps

1. Installation of Cassandra locally based on OS. Follow the youtube link below <br>
	<a href="https://www.youtube.com/watch?v=hJxlkHafYsQ">https://www.youtube.com/watch?v=hJxlkHafYsQ</a>
<br><br>

2. Set the cassandra installed bin folder in PATH of system environment variables settings <br>
   else you need to navigate to that installed path everytime & start the cassandra with below command
<br><br>

3. Start the cassandra db using "cassandra -f" or "cassandra" command <br>
	- Make sure it runs successfully, if any issues please go through above link [POINT 1]
<br><br>

4. Once the DB is ready, run the following application <br>
	- Hit the url mentioned below & it must display message <br>
	<a href="http://localhost:8080/">http://localhost:8080/</a>
<br><br>

5. If above hit is successful, next you can hit the users api <br>
	<a href="http://localhost:8080/users">http://localhost:8080/users/</a>
<br><br>

6. This ensures the database is working locally & you can start creating your own use cases
<br><br>

# Learning: 
- For local databases <br>
	- local-datacenter:  "datacenter1" is default <br>
	- contact-points: 	 Either you can use IP "127.0.0.1" Or you can use "localhost"

# Note: 
- Installation of database locally is possible before Cassandra 4.0 <br>

# Useful Links
@ Additional Configuration Properties

> https://facingissuesonit.com/2022/02/13/cassandra-spring-boot-properties/#:~:text=Cassandra%20Configuration%20Properties&text=Compression%20supported%20by%20the%20Cassandra%20binary%20protocol.&text=Socket%20option%3A%20connection%20time%20out.&text=Queries%20consistency%20level.&text=Comma%2Dseparated%20cluster%20node%20addresses.