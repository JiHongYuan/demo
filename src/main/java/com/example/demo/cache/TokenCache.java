package com.example.demo.cache;


import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class TokenCache {

    Cache<String, String> cache = Caffeine.newBuilder()
            .expireAfterWrite(3, TimeUnit.MINUTES)
            .maximumSize(5000)
            .build();

    public String get(String key) {
        String value = cache.getIfPresent(key);
        cache.invalidate(key);
        return value;
    }

    private void put(String key, String value) {
        cache.put(key, value);
    }

    public String supplier(String value, Supplier<Boolean> supplier) {
        String uuid = "";
        if (!supplier.get()) {
            uuid = UUID.randomUUID().toString();
            put(uuid, value);
        }
        return uuid;
    }

}
