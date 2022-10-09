# Keyspace, Table via Configuration

======================= DOCKER DATABSE =======================
1. Installation of Cassandra using docker. Run the commands mentioned below <br>
	<b> docker pull cassandra <br>
		docker run -d -p 9041:9042 --name docker_cassandra cassandra </b> <br><br>

==============================================================

1. Keyspace configuration gives us the way to manage keyspaces, tables
> schema-action
	CREATE <br>
	CREATE_IF_NOT_EXISTS  --> RECOMMENDED DURING DEVELOPMENT<br>
	NONE				  --> RECOMMENDED DURING PRODUCTION<br>
	RECREATE<br>
	RECREATE_DROP_UNUSED
<br><br>

2. We will use docker database for testing the same
<br><br>

3. Now, when we run for the first time, all keyspaces, tables etc must be created
<br><br>

4. Once the DB is ready, run the application <br>
	- Hit the url mentioned below & it must display message <br>
	<a href="http://localhost:8080/">http://localhost:8080/</a>
<br><br>

5. If above hit is successful, next you can hit the users api <br>
	<a href="http://localhost:8080/users">http://localhost:8080/users/</a>
<br><br>

6. If the data is returned, it means we are successful in creating database 
& displaying loaded data which was inserted during start up
<br><br>

# Docker Database Commands [CQLSH]
- Run the command & pick the container id <br>
<b> docker ps </b>
<br><br>
- Next, run the following command to get into the database <br>
<b> docker exec -it 80eccd74c3d1  cqlsh </b>
<br><br>
- Verify the database content w.r.t api

# CQL Commands
- Describe keyspaces to see our keyspace <br>
<b> DESCRIBE KEYSPACES </b>
<br><br>
- Drop keyspaces if already present <br>
<b> DROP KEYSPACE docker_keyspace </b>