# Local Database Connection

# Steps

1. Installation of Cassandra using docker. Run the commands mentioned below <br>
	<b> docker pull cassandra <br>
		docker run -d -p 9041:9042 --name docker_cassandra cassandra </b> <br><br>
<u>USECASE</u> : I have changed the port to 9041 for running, as going forward i will connect to docker database 
<br> if properties are set else we will connect to local database	
<br><br>

2. Once the DB is ready, run the following application <br>
	- Hit the url mentioned below & it must display message <br>
	<a href="http://localhost:8080/">http://localhost:8080/</a>
<br><br>

3. If above hit is successful, next you can hit the users api <br>
	<a href="http://localhost:8080/users">http://localhost:8080/users/</a>
<br><br>

4. This ensures the database is working on docker & you can start creating your own use cases
<br><br>

# Learning: 
- For database <br>
	- contact-points: You can use IP "host.docker.internal"

# Note
- Cassandra once started with above commands. You can restart the container using <br>
	<b> docker start docker_cassandra </b>

# Useful Links
@ Additional Configuration Properties

> https://facingissuesonit.com/2022/02/13/cassandra-spring-boot-properties/#:~:text=Cassandra%20Configuration%20Properties&text=Compression%20supported%20by%20the%20Cassandra%20binary%20protocol.&text=Socket%20option%3A%20connection%20time%20out.&text=Queries%20consistency%20level.&text=Comma%2Dseparated%20cluster%20node%20addresses.