package com.drool.example;

import org.drools.ruleunit.RuleUnit;

public class Result implements RuleUnit {
    private int id;
    private int eval_order;
    private String name;
    private int task_performer_id;
    private String is_deleted;
    private String selected_entities;
    private String selected_attributes;
    private String operation;
    private String display_name;
    private String description;
    private String create_ts;
    private String update_ts;

    public Result(int id,int eval_order,String name,int task_performer_id,String is_deleted,
                  String selected_entities,String selected_attributes,String operation,
                  String display_name,String description,String create_ts,String update_ts) {
        this.id = id;
        this.eval_order=eval_order;
        this.name=name;
        this.task_performer_id=task_performer_id;
        this.is_deleted=is_deleted;
        this.selected_entities=selected_entities;
        this.selected_attributes=selected_attributes;
        this.operation=operation;
        this.display_name=display_name;
        this.description=description;
        this.create_ts=create_ts;
        this.update_ts=update_ts;
    }
    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", eval_order=" + eval_order +
                ", name='" + name + '\'' +
                ", task_performer_id=" + task_performer_id +
                ", is_deleted='" + is_deleted + '\'' +
                ", selected_entities='" + selected_entities + '\'' +
                ", selected_attributes='" + selected_attributes + '\'' +
                ", operation='" + operation + '\'' +
                ", display_name='" + display_name + '\'' +
                ", description='" + description + '\'' +
                ", create_ts='" + create_ts + '\'' +
                ", update_ts='" + update_ts + '\'' +
                '}';
    }
}
