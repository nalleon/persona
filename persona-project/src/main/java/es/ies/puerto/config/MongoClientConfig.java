package es.ies.puerto.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

public class MongoClientConfig extends AbstractMongoClientConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoClientConfig.class);
    @Value("PersonaDb")
    private String database;
    @Value("mongodb+srv://mackstm:@cluster0.frztcnu.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")
    private String connection;
    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Bean
    public MongoClientSettings mongoClientSettings() {
        LOGGER.info("Creating settings");
        return MongoClientSettings.builder().applyConnectionString(new ConnectionString(connection)).build();
    }
}
