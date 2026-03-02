package com.example.metrics;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Map<String, Long> counters = new HashMap<>();

    // Flag to block reflection attack
    private static boolean instanceCreated = false;

    // Private constructor
    private MetricsRegistry() {
        if (instanceCreated) {
            throw new RuntimeException("Use getInstance() - Singleton already created");
        }
        instanceCreated = true;
    }

    // Static Holder Pattern (lazy + thread-safe)
    private static class Holder {
        private static final MetricsRegistry INSTANCE = new MetricsRegistry();
    }

    public static MetricsRegistry getInstance() {
        return Holder.INSTANCE;
    }

    // ====== Metrics Methods ======

    public synchronized void setCount(String key, long value) {
        counters.put(key, value);
    }

    public synchronized void increment(String key) {
        counters.put(key, getCount(key) + 1);
    }

    public synchronized long getCount(String key) {
        return counters.getOrDefault(key, 0L);
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }

    // Preserve singleton during deserialization
    @Serial
    protected Object readResolve() {
        return getInstance();
    }
}