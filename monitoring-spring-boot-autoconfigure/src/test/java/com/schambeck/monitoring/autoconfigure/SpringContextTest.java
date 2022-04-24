package com.schambeck.monitoring.autoconfigure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

class SpringContextTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(HttpTraceActuatorAutoConfiguration.class));

    @Test
    void defaultServiceBacksOff() {
        this.contextRunner.withUserConfiguration(UserConfiguration.class).run((context) -> {
            assertThat(context).hasSingleBean(HttpTraceActuatorAutoConfiguration.class);
            assertThat(context).getBean("httpTraceRepository").isSameAs(context.getBean(HttpTraceRepository.class));
        });
    }

    @Configuration(proxyBeanMethods = false)
    static class UserConfiguration {
        @Bean
        HttpTraceRepository httpTraceRepository() {
            return new InMemoryHttpTraceRepository();
        }
    }

}
