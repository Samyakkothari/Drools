package com.drool.example;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.*;

public class TestRuleParamsAsObjectMethod2 {
    private KieSession kieSession;

    @BeforeSuite

    public void KieSessionUsingContainer() throws FileNotFoundException {
        ObjectDataCompiler converter = new ObjectDataCompiler();
        FileInputStream template = new FileInputStream("src/test/resources/rule.drt");
        String drl = converter.compile(getParamSets(), template);
        System.out.println("drl: " + drl);

        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = KieServices.get().newKieFileSystem();
        kieFileSystem.write("src/main/resources/template.drl", kieServices.getResources().newReaderResource(new StringReader(drl)));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        KieContainer kieContainer = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());
        kieSession = kieContainer.newKieSession();
    }

    private Collection<Map<String, Object>> getParamSets() {
        List<Map<String, Object>> paramSets = new ArrayList<>();
        paramSets.add(getParam(1,"AppSelectorIsAll","AppSelectorIsAll",37,"All",0,"EntityCategory",12,2,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));
        paramSets.add(getParam(2,"NotAll","NotAll",38,"ApplicationType",1,"EntityCategory",12,2,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));
        paramSets.add(getParam(3,"NotAll","NotAll",39,"Application",34,"EntityType",13,2,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));
        paramSets.add(getParam(4,"NotAll","NotAll",31,"ApplicationType",1,"EntityType",13,2,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));
        paramSets.add(getParam(5,"AppSelectorIsAll","AppSelectorIsAll",40,"All",0,"EntityType",12,2,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));
        paramSets.add(getParam(6,"BothAll","BothAll",60,"All",0,"All",0,2,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));

        paramSets.add(getParam(21,"NotAll","NotAll",11,"Application",1,"EntityCategory",2,31,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));
        paramSets.add(getParam(22,"EntityTypeSelectorIsAll","EntityTypeSelectorIsAll",12,"Application",1,"All",0,32,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));
        paramSets.add(getParam(23,"NotAll","NotAll",13,"Application",1,"EntityType",5,33,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));
        paramSets.add(getParam(24,"NotAll","NotAll",14,"ApplicationType",9,"EntityCategory",2,34,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));
        paramSets.add(getParam(25,"AppSelectorIsAll","AppSelectorIsAll",15,"All",0,"EntityCategory",2,35,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));
        paramSets.add(getParam(26,"NotAll","NotAll",16,"ApplicationType",9,"EntityCategory",2,2,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));
        paramSets.add(getParam(27,"EntityTypeSelectorIsAll","EntityTypeSelectorIsAll",17,"ApplicationType",9,"All",0,37,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));
        paramSets.add(getParam(28,"AppSelectorIsAll","AppSelectorIsAll",18,"All",0,"EntityType",5,38,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));
        paramSets.add(getParam(29,"EntityTypeSelectorIsAll","EntityTypeSelectorIsAll2",19,"Application",1,"All",0,32,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","{ENTITY_FAILURE_OPERATION:Warning,nonUserTypeAttributes:contractor}","IdentityStatusValidation",	32,"false",null,"false","false","UPDATE",0,"IdentityStatusValidation","IdentityStatusValidation",null,"2019-04-12 08:35:56.649","2019-04-12 08:35:56.849"));
        return paramSets;
    }

    private Map<String, Object> getParam(int salience,String AgendaGroup,String ActivationGroup,int id, String app_selector, Integer app_select_id, String entity_type_selector, Integer entity_type_select_id, int eval_order, String staging_context, String task_category,String task_parameters,String name,Integer task_performer_id,String is_deleted,String content_type,String selected_entities,String selected_attributes,String operation,Integer tenant_org_id,String display_name,String description,String pre_conditions,String create_ts,String update_ts) {

        Map<String, Object> param = new HashMap<>();
        param.put("salience", salience);
        param.put("ActivationGroup", ActivationGroup);
        param.put("AgendaGroup", AgendaGroup);
        param.put("id", id);
        param.put("app_selector", app_selector);
        param.put("app_select_id", app_select_id);
        param.put("entity_type_selector", entity_type_selector);
        param.put("entity_type_select_id", entity_type_select_id);
        param.put("eval_order", eval_order);
        param.put("staging_context", staging_context);
        param.put("task_category", task_category);
        param.put("task_parameters", task_parameters);
        param.put("name", name);
        param.put("task_performer_id", task_performer_id);
        param.put("is_deleted", is_deleted);
        param.put("content_type", content_type);
        param.put("selected_entities", selected_entities);
        param.put("selected_attributes", selected_attributes);
        param.put("operation", operation);
        param.put("tenant_org_id", tenant_org_id);
        param.put("display_name", display_name);
        param.put("description", description);
        param.put("pre_conditions", pre_conditions);
        param.put("create_ts", create_ts);
        param.put("update_ts", update_ts);
        return param;
    }

    @Test(testName = "Can set multiple Agenda Group")
    public void test(){
        Fact fact = new Fact(1, 2, 22, 13, "ENTITY_DATA_PROCESSING", "RelationshipsAnalysis");
        List<Result> list = new ArrayList<>();
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup( "AppSelectorIsAll" ).setFocus();
        agenda.getAgendaGroup( "BothAll" ).setFocus();
        agenda.getAgendaGroup( "NotAll" ).setFocus();
        agenda.getAgendaGroup( "EntityTypeSelectorIsAll" ).setFocus();
        kieSession.insert(fact);
        kieSession.setGlobal("list",list);
        kieSession.fireAllRules();
        System.out.println(list);
    }

    @Test
    public void test1() {
        Fact fact = new Fact(1, 2554, 12, 3081, "ENTITY_DATA_PROCESSING", "RelationshipsAnalysis");
        List<Result> list = new ArrayList<>();
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup( "AppSelectorIsAll" ).setFocus();
        kieSession.insert(fact);
        kieSession.setGlobal("list",list);
        kieSession.fireAllRules();
        System.out.println(list);
    }
    @Test
    public void test2() {
        Fact fact = new Fact(1, 2554, 12, 3081, "ENTITY_DATA_PROCESSING", "RelationshipsAnalysis");
        List<Result> list = new ArrayList<>();
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup( "AppSelectorIsAll" ).setFocus();
        kieSession.insert(fact);
        kieSession.setGlobal("list",list);
        kieSession.fireAllRules();
        System.out.println(list);
    }
    @Test
    public void test3() {
        Fact fact = new Fact(9, 1, 2, 2, "ENTITY_DATA_PROCESSING", "RelationshipsAnalysis");
        List<Result> list = new ArrayList<>();
        Agenda agenda = kieSession.getAgenda();
        //agenda.getActivationGroup("EntityTypeSelectorIsAll12");
        agenda.getAgendaGroup( "AppSelectorIsAll" ).setFocus();
        kieSession.insert(fact);
        kieSession.setGlobal("list",list);
        kieSession.fireAllRules();
        System.out.println(list);
    }
    @Test(testName = "Two types of Activation Groups")
    public void test4(){
        Fact fact = new Fact(9, 1, 2, 2, "ENTITY_DATA_PROCESSING", "RelationshipsAnalysis");
        List<Result> list = new ArrayList<>();
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup( "EntityTypeSelectorIsAll" ).setFocus();
        kieSession.insert(fact);
        kieSession.setGlobal("list",list);
        kieSession.fireAllRules();
        System.out.println(list);
    }




    @AfterSuite
    public void closeSession(){
        kieSession.dispose();
    }
}
