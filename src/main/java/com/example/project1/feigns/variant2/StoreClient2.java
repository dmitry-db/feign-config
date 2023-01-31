package com.example.project1.feigns.variant2;

import com.example.project1.dto.Store;
import feign.Headers;
import feign.RequestLine;

import java.util.List;

public interface StoreClient2 {

    @RequestLine("GET /stores")
    @Headers("Content-Type: application/json")
    List<Store> getStores();
}
