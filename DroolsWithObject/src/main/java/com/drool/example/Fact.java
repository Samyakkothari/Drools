package com.drool.example;

import org.apache.poi.ss.formula.functions.T;
import org.kie.api.command.Command;

import java.util.List;
import java.util.Map;

public class Fact implements Command<T> {

    private Map<String, String> namedTags;
    private Integer applicationTypeId;
    private Integer applicationId;
    private Integer entityCategoryId;
    private Integer entityTypeId;
    private String stagingContext;
    private String taskCategory;
    private List<String> names;


    public Fact(Integer applicationTypeId, Integer applicationId, Integer entityCategoryId, Integer entityTypeId, String stagingContext, String taskCategory) {
        this.applicationTypeId = applicationTypeId;
        this.applicationId = applicationId;
        this.entityCategoryId = entityCategoryId;
        this.entityTypeId = entityTypeId;
        this.stagingContext = stagingContext;
        this.taskCategory = taskCategory;
    }
    public Fact(String stagingContext,List<String> names){
        this.stagingContext=stagingContext;
        this.names=names;
    }
    public Fact(List<String> names){
        this.names=names;
    }


    public Fact(Map<String,String> namedTags){
        this.namedTags=namedTags;
    }
    public Fact(String stagingContext){
        this.stagingContext=stagingContext;
    }

    public Integer getApplicationTypeId() {
        return applicationTypeId;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public Integer getEntityCategoryId() {
        return entityCategoryId;
    }

    public Integer getEntityTypeId() {
        return entityTypeId;
    }

    public String getStagingContext() {
        return stagingContext;
    }

    public String getTaskCategory() {
        return taskCategory;
    }
    public List<String> getNames() {
        return names;
    }
    public Map<String, String> getNamedTags() {
        return namedTags;
    }

    public void setNamedTags(Map<String, String> namedTags) {
        this.namedTags = namedTags;
    }
}
