package com.effectivejava;


import org.springframework.cache.Cache;

import java.util.HashMap;
import java.util.concurrent.Callable;

public class EagerCache implements Cache {


    private static EagerCache instance = new EagerCache();
    private HashMap<Object, Object> map;

    private EagerCache() {
        this.map = new HashMap<>();
    }


    public static EagerCache getInstance() {

        return instance;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Object getNativeCache() {
        return null;
    }

    @Override
    public ValueWrapper get(Object key) {
        return null;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        return null;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {

        map = new HashMap<>();
    }

    @Override
    public void evict(Object key) {

    }

    @Override
    public void clear() {

    }
}
