package com.sale.config.kafka;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaPropertiesConfig {

    private String topicSale;

    private Integer maxBlockMs;

    private String producerBootstrapServers;

    private String consumerBootstrapServers;

    private String consumerAutoOffsetReset;

    private String topicCustomerPollingName;

}
