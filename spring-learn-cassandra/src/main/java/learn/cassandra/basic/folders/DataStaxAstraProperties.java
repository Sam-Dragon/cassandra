package learn.cassandra.basic.folders;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ConfigurationProperties(prefix = "datastax.astra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataStaxAstraProperties {

	private File secureConnectBundle;
}
