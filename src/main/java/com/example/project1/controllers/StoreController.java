package com.example.project1.controllers;

import com.example.project1.dto.Store;
import com.example.project1.feigns.variant2.StoreClient2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreClient2 storeClient;

    @GetMapping("get-all")
    public List<Store> getAll() {
        return storeClient.getStores();
    }
}
