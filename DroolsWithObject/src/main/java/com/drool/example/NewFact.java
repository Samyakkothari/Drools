package com.drool.example;

import org.apache.poi.ss.formula.functions.T;
import org.kie.api.command.Command;

public class NewFact implements Command<T> {

    private final String applicationIdentifier;
    private final String applicationTypeName;
    private final String entityCategory;
    private final String nativeType;
    private final String stagingContext;
    private final String taskCategory;

    public NewFact(String applicationIdentifier,String applicationTypeName, String entityCategory, String nativeType, String stagingContext, String taskCategory) {
        this.applicationTypeName = applicationTypeName;
        this.applicationIdentifier = applicationIdentifier;
        this.entityCategory = entityCategory;
        this.nativeType = nativeType;
        this.stagingContext = stagingContext;
        this.taskCategory = taskCategory;
    }

    public String getApplicationTypeName() {
        return applicationTypeName;
    }

    public String getApplicationIdentifier() {
        return applicationIdentifier;
    }

    public String getEntityCategory() {
        return entityCategory;
    }

    public String getNativeType() {
        return nativeType;
    }

    public String getStagingContext() {
        return stagingContext;
    }

    public String getTaskCategory() {
        return taskCategory;
    }
}
