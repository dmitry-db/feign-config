package com.example.project1.configurations;

import com.example.project1.feignproperties.CommonFeignProperties;
import com.example.project1.feigns.variant2.StoreClient2;
import feign.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.project1.feigns.variant2")
public class FeignConfiguration {

    @Autowired
    private CommonFeignProperties serviceProperties;

    @Bean
    public StoreClient2 storeClient2() {
        return FeignClientConfigBuilder.
                feignBuildJson(StoreClient2.class, serviceProperties, feignContract());
    }

    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}
