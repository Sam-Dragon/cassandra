package cassandra.initial.setup.repositories;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;

import cassandra.initial.setup.model.User;

public interface UserRepository extends CassandraRepository<User, String>{
	
	List<User> findAll();
}
