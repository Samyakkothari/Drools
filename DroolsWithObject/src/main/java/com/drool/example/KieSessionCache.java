package com.drool.example;

import org.kie.api.runtime.StatelessKieSession;

public interface KieSessionCache {
     StatelessKieSession getKieSessionPoolCache(String drl);
}
