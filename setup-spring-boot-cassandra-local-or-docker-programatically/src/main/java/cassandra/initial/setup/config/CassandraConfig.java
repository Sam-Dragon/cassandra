package cassandra.initial.setup.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Value("${spring.data.cassandra.contact-points:localhost}")
//	@Value("${spring.data.cassandra.contact-points:127.0.0.1}")
	private String contactPoints;

	@Value("${spring.data.cassandra.port:9042}")
	private int port;

	@Value("${spring.data.cassandra.keyspace-name:local_keyspace}")
	private String keySpace;

	@Value("${spring.data.cassandra.schema-action:CREATE_IF_NOT_EXISTS}")
	private String schemaAction;
	
	@Value("${spring.data.cassandra.local-datacenter:datacenter1}")
	private String dataCenter;

	@Override
	protected String getKeyspaceName() {
		return keySpace;
	}

	@Override
	protected String getContactPoints() {
		return contactPoints;
	}

	@Override
	protected int getPort() {
		return port;
	}

	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.valueOf(schemaAction);
	}

	@Override
	protected String getLocalDataCenter() {
		return dataCenter;
	}
	
	@Bean
	@Override
	public CqlSessionFactoryBean cassandraSession() {
	    CqlSessionFactoryBean cqlSessionFactoryBean = new CqlSessionFactoryBean();
	    
	    cqlSessionFactoryBean.setKeyspaceName(keySpace);
	    cqlSessionFactoryBean.setLocalDatacenter(dataCenter);
	    cqlSessionFactoryBean.setPort(port);
	    cqlSessionFactoryBean.setContactPoints(contactPoints);
	    
	    return cqlSessionFactoryBean;
	}
	
	@Bean
    public CassandraMappingContext cassandraMapping() 
      throws ClassNotFoundException {
        return new CassandraMappingContext();
    }
}