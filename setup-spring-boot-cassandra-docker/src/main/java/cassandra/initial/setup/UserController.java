package cassandra.initial.setup;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cassandra.initial.setup.model.User;
import cassandra.initial.setup.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void addDefaults() {
		repository.saveAll(Arrays.asList(new User("Ram", "Natha", "Developer"),
				new User("Shyam", "Jalal", "Senior Developer"), new User("Tanu", "Mehta", " Manager")));
	}

	@PostMapping
	public void createUser(@RequestBody User user) {
		repository.save(user);
	}

	@GetMapping
	public List<User> getUsers() {
		return repository.findAll();
	}

	@GetMapping("/{name}")
	public User getUsersByName(@PathVariable String name) {
		return repository.findById(name).orElse(new User());
	}
}
