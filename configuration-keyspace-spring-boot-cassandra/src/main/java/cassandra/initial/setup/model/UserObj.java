package cassandra.initial.setup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserObj {

	private String lastname;

	private String title;

	@Override
	public String toString() {
		return "{lastname=" + lastname + ", title=" + title + "}";
	}

}
