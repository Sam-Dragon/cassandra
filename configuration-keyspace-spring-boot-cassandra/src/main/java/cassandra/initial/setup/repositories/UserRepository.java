package cassandra.initial.setup.repositories;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import cassandra.initial.setup.model.User;
import cassandra.initial.setup.model.UserObj;

public interface UserRepository extends CassandraRepository<User, String>{
	
	List<User> findAll();
	
	@Query("select lastname, title from User")
	List<UserObj> getAll();
}
