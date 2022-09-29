package com.drool.example;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieContainerSessionsPool;
import org.kie.api.runtime.StatelessKieSession;

import java.io.StringReader;

public class KieSessionPoolCache implements KieSessionCache{
    public CacheManagerImpl cacheManager;
    public StatelessKieSession getKieSessionPoolCache(String drl) {
        KieContainer kieContainer;
        KieContainerSessionsPool pool = (KieContainerSessionsPool) cacheManager.preConfigured().get(drl);
        if (pool == null) {
            KieServices kieServices = KieServices.Factory.get();
            KieFileSystem kieFileSystem = KieServices.get().newKieFileSystem();
            kieFileSystem.write("src/main/resources/template.drl", kieServices.getResources().newReaderResource(new StringReader(drl)));
            KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
            kieContainer = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());
            pool = kieContainer.newKieSessionsPool(10);
            cacheManager.myCache().put(drl,pool);
        }
        StatelessKieSession kieSession = pool.newStatelessKieSession();
        return kieSession;
    }
}
