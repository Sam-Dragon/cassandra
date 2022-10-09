package cassandra.initial.setup.config;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraEntityClassScanner;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;

@Configuration
@EnableConfigurationProperties(CassandraProperties.class)
@ConfigurationProperties("spring.data.cassandra")
public class CassandraConfig extends AbstractCassandraConfiguration {

	private static int DB_LOCAL_REPLICATION_FACTOR = 1;
	private static int DB_DEFAULT_REPLICATION_FACTOR = 3;
	private static int DB_DEFAULT_CASSNDRA_PORT = 9042;
	private static String DB_DEFAULT_CASSNDRA_HOST = "localhost";
	private static String DB_DEFAULT_KEYSPACE_NAME = "local_keyspace";

	private final CassandraProperties properties;

	public CassandraConfig(CassandraProperties properties) {
		// properties.getRequest().setConsistency(DefaultConsistencyLevel.LOCAL_QUORUM);
		this.properties = properties;
	}

	public Integer getReplicationFactor() {
		return properties.getContactPoints().stream().filter(c -> c.equalsIgnoreCase(DB_DEFAULT_CASSNDRA_HOST))
				.findAny().map(c -> DB_LOCAL_REPLICATION_FACTOR).orElse(DB_DEFAULT_REPLICATION_FACTOR);
	}

	@Override
	protected String getKeyspaceName() {
		return Optional.ofNullable(properties.getKeyspaceName()).map(String::toLowerCase)
				.orElse(DB_DEFAULT_KEYSPACE_NAME);
	}

	@Override
	protected String getContactPoints() {
		return properties.getContactPoints().stream().collect(Collectors.joining(","));
	}

	@Override
	protected int getPort() {
		return Optional.ofNullable(properties.getPort()).orElse(DB_DEFAULT_CASSNDRA_PORT);
	}

	@Override
	public SchemaAction getSchemaAction() {
		return Optional.ofNullable(properties.getSchemaAction()).map(SchemaAction::valueOf).orElse(SchemaAction.NONE);
	}

	@Override
	protected String getLocalDataCenter() {
		return properties.getLocalDatacenter();
	}

	@Override
	public String[] getEntityBasePackages() {
		return new String[] { "cassandra.initial.setup.model" };
	}

	@Bean
	@Override
	public CqlSessionFactoryBean cassandraSession() {
		CqlSessionFactoryBean cqlSessionFactoryBean = new CqlSessionFactoryBean();

		cqlSessionFactoryBean.setKeyspaceCreations(getKeyspaceCreations());
		cqlSessionFactoryBean.setKeyspaceName(getKeyspaceName());
		cqlSessionFactoryBean.setLocalDatacenter(getLocalDataCenter());
		cqlSessionFactoryBean.setPort(getPort());
		cqlSessionFactoryBean.setContactPoints(getContactPoints());

		return cqlSessionFactoryBean;
	}

	@Bean
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
		CassandraMappingContext mappingContext = new CassandraMappingContext();
		mappingContext.setInitialEntitySet(getInitialEntitySet());

		return mappingContext;
	}

	@Override
	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
		return Collections.singletonList(CreateKeyspaceSpecification.createKeyspace(getKeyspaceName()).ifNotExists()
				.with(KeyspaceOption.DURABLE_WRITES, true).withSimpleReplication(getReplicationFactor()));
	}

	@Override
	protected Set<Class<?>> getInitialEntitySet() throws ClassNotFoundException {
		return CassandraEntityClassScanner.scan(getEntityBasePackages());
	}

	@Override
	protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
		return Collections.singletonList(DropKeyspaceSpecification.dropKeyspace(getKeyspaceName()));
	}

}