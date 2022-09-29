package com.drool.example;

import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.command.Command;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.*;
import org.kie.api.runtime.rule.Agenda;
import org.kie.internal.command.CommandFactory;
import org.kie.internal.utils.KieHelper;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.*;

import static org.testng.collections.Lists.newArrayList;

public class SampleTest {

    private KieSession kieSession;

    @BeforeSuite
    public void KieSessionFromDrl() throws FileNotFoundException {
        ObjectDataCompiler converter = new ObjectDataCompiler();
        FileInputStream template = new FileInputStream("src/test/resources/sample.drt");
        String drl = converter.compile(getParamSets(), template);
        System.out.println("drl: " + drl);
        kieSession=this.createKieSessionFromDRL(drl);
    }

    private KieSession createKieSessionFromDRL(String drl) {
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);
        Results results = kieHelper.verify();
        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)) {
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println(message.getText() + "Error");
            }
        }
        return kieHelper.build().newKieSession();
    }
/*    private StatelessKieSession kieSession;
    private KieContainer kieContainer;

    @BeforeSuite

    public void KieSessionUsingContainer() throws FileNotFoundException {
        ObjectDataCompiler converter = new ObjectDataCompiler();
        FileInputStream template = new FileInputStream("src/test/resources/sample.drt");
        String drl = converter.compile(getParamSets(), template);
        System.out.println("drl: " + drl);

        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = KieServices.get().newKieFileSystem();
        kieFileSystem.write("src/main/resources/template.drl", kieServices.getResources().newReaderResource(new StringReader(drl)));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        kieContainer = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());
        KieContainerSessionsPool pool = kieContainer.newKieSessionsPool(10);
        kieSession = pool.newStatelessKieSession();
    }*/

    private Collection<Map<String, Object>> getParamSets() {
        List<Map<String, Object>> paramSets = new ArrayList<>();
        List<String>list1=new ArrayList<>();
        list1.add("\"TaskSpecification1\"");
        list1.add("\"TaskSpecification2\"");
/*        List<String>list2=new ArrayList<>();
        list2.add("TaskSpecification3");
        list2.add("TaskSpecification4");*/
        List<String>list2=new ArrayList<>();
        list2.add("\"TaskSpecification3\"");
        list2.add("\"TaskSpecification4\"");

        Map<String,String> namedTags=new LinkedHashMap<>();
/*        namedTags.put("\"Key1\"","\"Value1\"");
        namedTags.put("\"Key2\"","\"Value2\"");*/
        namedTags.put("Key1","Value1");
        namedTags.put("Key2","Value2");

        Map<String,String> namedTags1=new LinkedHashMap<>();
        namedTags1.put("Key3","Value3");
        namedTags1.put("Key4","Value4");

        paramSets.add(getParam(1, 37,  "ENTITY_DATA_PROCESSING", "RelationshipsAnalysis", list1,"uri1",namedTags));
        paramSets.add(getParam(2, 38,  "ENTITY_DATA", "RelationshipsAnalysis", list2,"uri2",namedTags1));
        paramSets.add(getParam(3, 39,  "PROCESSING", "RelationshipsAnalysis", list1,"uri3",namedTags));
        paramSets.add(getParam(4, 31,  "ENTITY_DATA", "RelationshipsAnalysis", list1,"uri4",namedTags1));
        paramSets.add(getParam(5, 40, "", "RelationshipsAnalysis", list2,"uri5",namedTags));
        paramSets.add(getParam(6, 40, null, "RelationshipsAnalysis", list1,"uri6",namedTags1));
        paramSets.add(getParam(7, 40, "ENTITY_DATA_PROCESSING", "RelationshipsAnalysis", list2,"uri7",namedTags));
        return paramSets;
    }

    private Map<String, Object> getParam(int salience, int id, String staging_context, String task_category, List<String> names,String uri,Map<String,String> namedTags) {

        Map<String, Object> param = new HashMap<>();
        param.put("salience", salience);
        param.put("id", id);
        param.put("staging_context", staging_context);
        param.put("task_category", task_category);
        param.put("names", names);
        param.put("uri",uri);
        param.put("namedTags",namedTags);
        return param;
    }

/*    @Test(testName = "Execution Scoped globals")
    public void test1() throws FileNotFoundException {
        Fact fact =new Fact("ENTITY_DATA_PROCESSING");
        List<Result> list = new ArrayList<>();
        final List<Command> commands = newArrayList();
        commands.add(CommandFactory.newInsert(fact, "fact"));
        commands.add(CommandFactory.newSetGlobal("list", list));
        FireAllRulesCommand fireAllRulesCommand = new FireAllRulesCommand();
        commands.add(fireAllRulesCommand);
        ExecutionResults results = kieSession.execute(CommandFactory.newBatchExecution(commands));
        System.out.println(results.getFactHandle("fact"));
        System.out.println(list);
    }*/
    @Test(description = "Fact just with Both list and one parameter")
    public void test3() {
        List<String>list2=new ArrayList<>();
        list2.add("TaskSpecification3");
        list2.add("TaskSpecification4");
        Fact fact = new Fact("ENTITY_DATA_PROCESSING",list2);
        List<Result> list = new ArrayList<>();
        Agenda agenda = kieSession.getAgenda();
        //agenda.getActivationGroup("EntityTypeSelectorIsAll12");
        kieSession.insert(fact);
        kieSession.setGlobal("list",list);
        kieSession.fireAllRules();
        System.out.println(list);
    }
    @Test(description = "Fact just with StagingContext")
    public void test4() {
        List<String>list2=new ArrayList<>();
        list2.add("TaskSpecification3");
        list2.add("TaskSpecification4");
        Fact fact = new Fact("ENTITY_DATA_PROCESSING");
        List<Result> list = new ArrayList<>();
        kieSession.insert(fact);
        kieSession.setGlobal("list",list);
        kieSession.fireAllRules();
        System.out.println(list);
    }

    @Test(description = "Fact just with list")
    public void test5() {
        List<String>list2=new ArrayList<>();
        list2.add("TaskSpecification3");
        list2.add("TaskSpecification4");
        Fact fact = new Fact(list2);
        List<Result> list = new ArrayList<>();
        kieSession.insert(fact);
        kieSession.setGlobal("list",list);
        kieSession.fireAllRules();
        System.out.println(list);
    }

    @Test(description = "Fact just with list")
    public void test7() {
        List<String>list2=new ArrayList<>();
        list2.add("TaskSpecification1");
        list2.add("TaskSpecification2");
        Fact fact = new Fact(list2);
        List<Result> list = new ArrayList<>();
        kieSession.insert(fact);
        kieSession.setGlobal("list",list);
        kieSession.fireAllRules();
        System.out.println(list);
    }

    @Test(description = "Fact just with Map")
    public void test6() {
        Map<String,String> namedTags=new LinkedHashMap<>();
        namedTags.put("Key1","Value1");
        namedTags.put("Key2","Value2");
        Fact fact = new Fact(namedTags);
        List<Result> list = new ArrayList<>();
        kieSession.insert(fact);
        kieSession.setGlobal("list",list);
        kieSession.fireAllRules();
        System.out.println(list);
    }


    //($list memberOf tags)
}
