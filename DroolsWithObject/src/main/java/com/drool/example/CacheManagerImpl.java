package com.drool.example;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

public class CacheManagerImpl {
    public CacheManager cacheManager;

    public CacheManagerImpl() {
        cacheManager
                = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)))
                .build();
        cacheManager.init();
    }
    public Cache<Object, Object> preConfigured() {
        return cacheManager.getCache("preConfigured", Object.class, Object.class);
    }

    public Cache<Object, Object> myCache() {
        return cacheManager.createCache("myCache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder.heap(10)).build());
    }

}
