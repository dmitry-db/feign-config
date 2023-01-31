package com.example.project1.feignproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@PropertySource(value = "classpath:/feign.properties")
@ConfigurationProperties(prefix = "feign.common")
@Configuration
public class CommonFeignProperties {

    private int connectTimeoutMillis;

    private int readTimeoutMillis;

    private String url;
}
