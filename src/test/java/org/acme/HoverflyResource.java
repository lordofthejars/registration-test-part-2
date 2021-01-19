package org.acme;

import java.util.Map;

import javax.ws.rs.core.MediaType;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import static io.specto.hoverfly.junit.core.HoverflyConfig.localConfigs;
import static io.specto.hoverfly.junit.core.SimulationSource.dsl;
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service;
import static io.specto.hoverfly.junit.dsl.ResponseCreators.success;
import static io.specto.hoverfly.junit.core.HoverflyMode.SIMULATE;
import io.specto.hoverfly.junit.core.Hoverfly;

public class HoverflyResource implements QuarkusTestResourceLifecycleManager {

    private Hoverfly hoverfly;

    @Override
    public Map<String, String> start() {
        hoverfly = new Hoverfly(localConfigs().destination("banned-user-service"), SIMULATE);

        hoverfly.start();
        hoverfly.simulate(
            dsl(
                service("banned-user-service")
                .get("/api/Alex")
                .willReturn(success("true", MediaType.TEXT_HTML))
                .get("/api/Ada")
                .willReturn(success("false", MediaType.TEXT_HTML))
            )
        );
        
        return null;
    }

    @Override
    public void stop() {
        hoverfly.close();
    }
    
}
