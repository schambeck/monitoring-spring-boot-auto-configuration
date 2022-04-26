package com.schambeck.monitoring.autoconfigure;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig
@ContextConfiguration(classes = HttpTraceActuatorAutoConfiguration.class)
class SpringContextTest {

    @Autowired
    HttpTraceRepository httpTraceRepository;

    @Test
    void httpTraceRepository() {
        assertNotNull(httpTraceRepository);
    }

}
