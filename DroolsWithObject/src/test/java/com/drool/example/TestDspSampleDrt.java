package com.drool.example;

import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.command.Command;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieContainerSessionsPool;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.testng.collections.Lists.newArrayList;

public class TestDspSampleDrt {
    private StatelessKieSession kieSession;
    private KieContainer kieContainer;
    //Date date=new Date();
    Format formatter = new SimpleDateFormat("dd-MMM-yy");
    String date = formatter.format(new Date());
    //String date = formatter.format("31/03/2015");

    public TestDspSampleDrt() throws ParseException {
    }


    @BeforeSuite

    public void KieSessionUsingContainer() throws FileNotFoundException {
        ObjectDataCompiler converter = new ObjectDataCompiler();
        FileInputStream template = new FileInputStream("src/test/resources/dsp-sample.drt");
        String drl = converter.compile(getParamSets(), template);
        System.out.println("drl: " + drl);

        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = KieServices.get().newKieFileSystem();
        kieFileSystem.write("src/main/resources/template.drl", kieServices.getResources().newReaderResource(new StringReader(drl)));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        kieContainer = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());
        KieContainerSessionsPool pool = kieContainer.newKieSessionsPool(10);
        kieSession = pool.newStatelessKieSession();
    }

    private Collection<Map<String, Object>> getParamSets() {
        List<Map<String, Object>> paramSets = new ArrayList<>();
        List<String>tags=new ArrayList<>();
        tags.add("\"Tag1\"");
        tags.add("\"Tag2\"");
        paramSets.add(getParam(1,"Sailpoint Certification Definition Name","Sailpoint",tags,null,"Sailpoint/ IdM Certification Type","Sailpoint","JDOE","Sailpoint Certification Group Name",date,1,"Transfer Access Review @01-09-22","support1@customer.com","Transfer Access Review Batch @08-09-22"));
        paramSets.add(getParam(2,"Dsp Certification Definition Name",null,tags,null,"Dsp/ IdM Certification Type","Dsp","JDOE","Dsp Certification Group Name",date,2,"Transfer Access Review @02-09-22","support2@customer.com","Transfer Access Review Batch @09-06-22"));
        paramSets.add(getParam(3,"Sailpoint Certification Definition Name","Sailpoint",tags,null,"Sailpoint/ IdM Certification Type","Sailpoint","JDOE","Sailpoint Certification Group Name",date,3,"Transfer Access Review @03-09-22","support@customer3.com","Transfer Access Review Batch @10-09-22"));
        paramSets.add(getParam(4,"Iap Certification Definition Name","Iap",Collections.emptyList(),null,"Iap/ IdM Certification Type","Iap","JDOE","IAp Certification Group Name",date,4,"Transfer Access Review @04-09-22","support4@customer.com","Transfer Access Review Batch @11-08-22"));
        paramSets.add(getParam(5,"Iap Certification Definition Name","Iap",tags,null,"Iap/ IdM Certification Type","Iap","JDOE","Iap Certification Group Name",date,5,"Transfer Access Review @05-09-22","support5@customer.com","Transfer Access Review Batch @12-08-22"));
        paramSets.add(getParam(6,"Dsp Certification Definition Name",null,tags,null,"Dsp/ IdM Certification Type","Dsp","JDOE","Dsp Certification Group Name",date,6,"Transfer Access Review @06-09-22","support6@customer.com","Transfer Access Review Batch @13-o8-22"));
        paramSets.add(getParam(7,"Sailpoint Certification Definition Name","Sailpoint",tags,null,"Sailpoint/ IdM Certification Type","Sailpoint","JDOE","Sailpoint Certification Group Name",date,7,"Transfer Access Review @07-09-22","support7@customer.com","Transfer Access Review Batch @14-09-22"));
        return paramSets;
    }

    private Map<String, Object> getParam(int salience,String definitionName, String certificationService, List<String> tags, Map<String, String> namedTags,
                                         String certificationType, String certificationContentType, String reviewOwner, String reviewName, String reviewExpiryDate, int processCount,
                                         String campaignNamePattern,String supportEmail,String campaignBatchNamePattern) {

        Map<String, Object> param = new HashMap<>();
        param.put("salience",salience);
        param.put("definitionName", definitionName);
        param.put("certificationService", certificationService);
        param.put("tags", tags);
        param.put("namedTags", namedTags);
        param.put("certificationType", certificationType);
        param.put("certificationContentType", certificationContentType);
        param.put("reviewOwner", reviewOwner);
        param.put("reviewName", reviewName);
        param.put("reviewExpiryDate", reviewExpiryDate);
        param.put("processCount",processCount);
        param.put("campaignNamePattern",campaignNamePattern);
        param.put("supportEmail",supportEmail);
        param.put("campaignBatchNamePattern",campaignBatchNamePattern);
        return param;
    }


    @Test(testName = "Execution Scoped globals")
    public void test1() throws FileNotFoundException {
        DspSampleFact fact = new DspSampleFact("Sailpoint Certification Definition Name", "Sailpoint", "Sailpoint/ IdM Certification Type", "Sailpoint", "JDOE","Sailpoint Certification Group Name",date,1);
        List<Result> list = new ArrayList<>();
        final List<Command> commands = newArrayList();
        commands.add(CommandFactory.newInsert(fact,"fact"));
        commands.add(CommandFactory.newSetGlobal("list",list));
        FireAllRulesCommand fireAllRulesCommand = new FireAllRulesCommand();
        commands.add(fireAllRulesCommand);
        ExecutionResults results = kieSession.execute(CommandFactory.newBatchExecution(commands));
        System.out.println(results.getFactHandle("fact"));
        System.out.println(fact.getCampaignNamePattern());
    }

    @Test(testName = "Facts provided with list")
    public void test2() throws FileNotFoundException {
        List<String>tags=new ArrayList<>();
        tags.add("Tag1");
        tags.add("Tag2");
        DspSampleFact fact = new DspSampleFact("Sailpoint Certification Definition Name", "Sailpoint",tags, "Sailpoint/ IdM Certification Type", "Sailpoint", "JDOE","Sailpoint Certification Group Name",date,1);
        List<Result> list = new ArrayList<>();
        final List<Command> commands = newArrayList();
        commands.add(CommandFactory.newInsert(fact,"fact"));
        commands.add(CommandFactory.newSetGlobal("list",list));
        FireAllRulesCommand fireAllRulesCommand = new FireAllRulesCommand();
        commands.add(fireAllRulesCommand);
        ExecutionResults results = kieSession.execute(CommandFactory.newBatchExecution(commands));
        System.out.println("CampaignNamePattern is "+fact.getCampaignNamePattern());
        System.out.println("CampaignBatchNamePattern is "+fact.getCampaignBatchNamePattern());
    }
    @Test(testName = "Facts provided with negative parameter in the list")
    public void test3() throws FileNotFoundException {
        List<String>tags=new ArrayList<>();
        tags.add("Tag3");
        tags.add("Tag4");
        DspSampleFact fact = new DspSampleFact("Sailpoint Certification Definition Name", "Sailpoint",tags, "Sailpoint/ IdM Certification Type", "Sailpoint", "JDOE","Sailpoint Certification Group Name",date,1);
        List<Result> list = new ArrayList<>();
        final List<Command> commands = newArrayList();
        commands.add(CommandFactory.newInsert(fact,"fact"));
        commands.add(CommandFactory.newSetGlobal("list",list));
        FireAllRulesCommand fireAllRulesCommand = new FireAllRulesCommand();
        commands.add(fireAllRulesCommand);
        ExecutionResults results = kieSession.execute(CommandFactory.newBatchExecution(commands));
        System.out.println("CampaignNamePattern is "+fact.getCampaignNamePattern());
        System.out.println("CampaignBatchNamePattern is "+fact.getCampaignBatchNamePattern());
    }
    @Test(testName = "Facts provided with list")
    public void test4() throws FileNotFoundException {
        List<String>tags=new ArrayList<>();
        tags.add("Tag1");
        tags.add("Tag2");
        DspSampleFact fact = new DspSampleFact(null, null,Collections.emptyList(), null, null, null,null,null,6);
        List<Result> list = new ArrayList<>();
        final List<Command> commands = newArrayList();
        commands.add(CommandFactory.newInsert(fact,"fact"));
        commands.add(CommandFactory.newSetGlobal("list",list));
        FireAllRulesCommand fireAllRulesCommand = new FireAllRulesCommand();
        commands.add(fireAllRulesCommand);
        ExecutionResults results = kieSession.execute(CommandFactory.newBatchExecution(commands));
        System.out.println("CampaignNamePattern is "+fact.getCampaignNamePattern());
        System.out.println("CampaignBatchNamePattern is "+fact.getCampaignBatchNamePattern());
    }

    @Test(testName = "Facts provided with list")
    public void test5() throws FileNotFoundException {
        List<String>tags=new ArrayList<>();
        tags.add("Tag1");
        tags.add("Tag2");
        DspSampleFact fact = new DspSampleFact(null, null,tags, null, null, null,null,null,6);
        List<Result> list = new ArrayList<>();
        final List<Command> commands = newArrayList();
        commands.add(CommandFactory.newInsert(fact,"fact"));
        commands.add(CommandFactory.newSetGlobal("list",list));
        FireAllRulesCommand fireAllRulesCommand = new FireAllRulesCommand();
        commands.add(fireAllRulesCommand);
        ExecutionResults results = kieSession.execute(CommandFactory.newBatchExecution(commands));
        System.out.println(results.getFactHandle("fact"));
        System.out.println(list);
        System.out.println("CampaignNamePattern is "+fact.getCampaignNamePattern());
        System.out.println("CampaignBatchNamePattern is "+fact.getCampaignBatchNamePattern());
    }


    @AfterSuite
    public void closeSession(){
        kieContainer.dispose();
    }
}
