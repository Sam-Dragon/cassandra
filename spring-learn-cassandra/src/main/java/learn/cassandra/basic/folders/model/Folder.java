package learn.cassandra.basic.folders.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("folders_by_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Folder {

	@PrimaryKeyColumn(value = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String id;

	@PrimaryKeyColumn(value = "label", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
	private String label;

	@CassandraType(type = Name.TEXT)
	private String color;
}
