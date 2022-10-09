package cassandra.initial.setup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories(basePackages = "cassandra.initial.setup")
public class CassandraBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CassandraBasicsApplication.class, args);
	}

}
