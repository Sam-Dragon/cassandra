# Local Database Connection

# Steps

======== Set up the local & docker database as mentioned below ========

# Local Database Setup
1. Installation of Cassandra locally based on OS. Follow the youtube link below <br>
	<a href="https://www.youtube.com/watch?v=hJxlkHafYsQ">https://www.youtube.com/watch?v=hJxlkHafYsQ</a>
<br><br>

2. Set the cassandra installed bin folder in PATH of system environment variables settings <br>
   else you need to navigate to that installed path everytime & start the cassandra with below command
<br><br>

3. Start the cassandra db using "cassandra -f" or "cassandra" command <br>
	- Make sure it runs successfully, if any issues please go through above link [POINT 1]
<br><br>

# Docker Database Setup
1. Installation of Cassandra using docker. Run the commands mentioned below <br>
	<b> docker pull cassandra <br>
		docker run -d -p 9041:9042 --name docker_cassandra cassandra </b> <br><br>
<u>USECASE</u> : I have changed the port to 9041 for running to differentiate between local & docker database	

=======================================================================
<br><br>

1. In this use case, we will connect to docker database if database properties are set 
<br> else we will connect to local database
<br><br>

2. Enable the application properties for docker database & verify it will connect to it
<br> Likewise, if you comment it, it will connect to local database
<br><br>

3. Once the DB is ready, run the following application <br>
	- Hit the url mentioned below & it must display message <br>
	<a href="http://localhost:8080/">http://localhost:8080/</a>
<br><br>

4. If above hit is successful, next you can hit the users api <br>
	<a href="http://localhost:8080/users">http://localhost:8080/users/</a>
<br><br>

5. This ensures the database connection is working with docker & local database
<br><br>

# Docker Database Commands [CQLSH]
- Run the command & pick the container id <br>
<b> docker ps </b>
<br><br>
- Next, run the following command to get into the database <br>
<b> docker exec -it 80eccd74c3d1  cqlsh </b>
- Verify the database content with api

# Learning: 
- Look at CassandraConfig.java file where we setup the configuration programmatically

# Note
- Cassandra once started with above commands. You can restart the container using <br>
	<b> docker start docker_cassandra </b>

# Useful Links
@ Additional Configuration Properties

> https://facingissuesonit.com/2022/02/13/cassandra-spring-boot-properties/#:~:text=Cassandra%20Configuration%20Properties&text=Compression%20supported%20by%20the%20Cassandra%20binary%20protocol.&text=Socket%20option%3A%20connection%20time%20out.&text=Queries%20consistency%20level.&text=Comma%2Dseparated%20cluster%20node%20addresses.