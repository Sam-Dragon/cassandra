package cassandra.initial.setup.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("user")
public class User {

	@PrimaryKey
	private String firstname;

	private String lastname;

	private String title;

	@Override
	public String toString() {
		return "{firstname=" + firstname + ", lastname=" + lastname + ", title=" + title + "}";
	}

}
