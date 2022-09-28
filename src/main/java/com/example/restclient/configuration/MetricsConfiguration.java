package com.example.restclient.configuration;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.httpcomponents.PoolingHttpClientConnectionManagerMetricsBinder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MetricsConfiguration {

    PoolingHttpClientConnectionManager connectionManager;
    MeterRegistry meterRegistry;

    @Autowired
    public MetricsConfiguration(PoolingHttpClientConnectionManager connectionManager, MeterRegistry meterRegistry) {
        this.connectionManager = connectionManager;
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void setupConnectionPoolMetrics() {
        new PoolingHttpClientConnectionManagerMetricsBinder(connectionManager, "my-rest-client-pool")
                .bindTo(meterRegistry);
    }

}
