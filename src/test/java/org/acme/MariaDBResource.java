package org.acme;

import java.util.HashMap;
import java.util.Map;

import org.testcontainers.containers.MariaDBContainer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class MariaDBResource implements QuarkusTestResourceLifecycleManager {

    static MariaDBContainer<?> db = new MariaDBContainer<>("mariadb:10.3.6")
                                            .withDatabaseName("mydb")
                                            .withUsername("developer")
                                            .withPassword("developer");

    @Override
    public Map<String, String> start() {
        db.start();
        
        final Map<String, String> conf = new HashMap<>();
        conf.put("%test.quarkus.datasource.jdbc.url", db.getJdbcUrl());
        conf.put("%test.quarkus.datasource.username", "developer");
        conf.put("%test.quarkus.datasource.password", "developer");
        conf.put("%test.quarkus.datasource.db-kind", "mariadb");
        
        return conf;

    }

    @Override
    public void stop() {
       db.stop();
    }
    
}
