package com.schambeck.monitoring.autoconfigure;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(HttpTraceRepository.class)
class HttpTraceActuatorAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    HttpTraceRepository httpTraceRepository() {
        return new InMemoryHttpTraceRepository();
    }

}
