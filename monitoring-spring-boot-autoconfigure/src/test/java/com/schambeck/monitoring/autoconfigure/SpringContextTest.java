package com.schambeck.monitoring.autoconfigure;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = HttpTraceActuatorAutoConfiguration.class)
class SpringContextTest {

    @Test
    void whenSpringContextIsBootstrapped_thenNoExceptions() {
        // no body
    }

}
