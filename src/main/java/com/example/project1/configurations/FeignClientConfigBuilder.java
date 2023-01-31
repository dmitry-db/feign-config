package com.example.project1.configurations;

import com.example.project1.feignproperties.CommonFeignProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Contract;
import feign.Feign;
import feign.Request;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

import java.util.concurrent.TimeUnit;

public class FeignClientConfigBuilder {

    public static <T> T feignBuildJson(Class<T> tClass, CommonFeignProperties properties, Contract contract) {
        return Feign.builder()
                .client(new OkHttpClient())
                .contract(contract)
                .encoder(initJacksonEncoder())
                .decoder(initJacksonDecoder())
                .options(new Request.Options(
                        properties.getConnectTimeoutMillis(),
                        TimeUnit.MILLISECONDS,
                        properties.getReadTimeoutMillis(),
                        TimeUnit.MILLISECONDS, true)
                )
                .logger(new Slf4jLogger(FeignConfiguration.class.getName()))
                .target(tClass, properties.getUrl());
    }

    private static Encoder initJacksonEncoder() {
        return new JacksonEncoder(createObjectMapper());
    }

    private static Decoder initJacksonDecoder() {
        return new JacksonDecoder(createObjectMapper());
    }

    private static ObjectMapper createObjectMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .findAndRegisterModules();
    }
}
