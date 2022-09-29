package com.drool.example;

import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.command.Command;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainerSessionsPool;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.*;

import static org.testng.collections.Lists.newArrayList;

public class TestKieSessionPoolCache {
    StatelessKieSession kieSession;
    KieSessionCache kieSessionPoolCache;
    @BeforeSuite
    public void KieSessionUsingContainer() throws FileNotFoundException {
        ObjectDataCompiler converter = new ObjectDataCompiler();
        FileInputStream template = new FileInputStream("src/test/resources/iap-task-selection.drt");
        String drl = converter.compile(getParamSets(), template);
        System.out.println("drl: " + drl);

        kieSession= kieSessionPoolCache.getKieSessionPoolCache(drl);
    }

    private Collection<Map<String, Object>> getParamSets() {
        List<Map<String, Object>> paramSets = new ArrayList<>();
        paramSets.add(getParam(1,37,"Salesforce masco","Platform Permission Set","Permission","User Account",4,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","TaskSpecification1"));
        paramSets.add(getParam(2,38,"Salesforce masco","JIT Access","Resource","Profiles",2,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","TaskSpecification2"));
        paramSets.add(getParam(3,39,"Finance FEB app","PeopleSoftFinancials","Resource","User Account",2,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","TaskPerformer1"));
        paramSets.add(getParam(4,31,"Salesforce masco","Platform Permission Set","Permission","Profiles",2,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","TaskPerformer2"));
        paramSets.add(getParam(5,40,"Finance FEB app","All","Permission","User Account",9,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","IdentityStatusValidationTask1"));
        paramSets.add(getParam(6,40,"","JIT Access","Permission","User Account",2,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","IdentityStatusValidationTask2"));
        paramSets.add(getParam(7,40,"Finance FEB app","JIT Access","null","User Account",2,"ENTITY_DATA_PROCESSING","RelationshipsAnalysis","IdentityStatusValidationTask3"));
        return paramSets;
    }

    private Map<String, Object> getParam(int salience,int id, String ApplicationIdentifier, String ApplicationTypeName, String EntityCategory, String NativeType, int eval_order, String staging_context, String task_category,String uri) {

        Map<String, Object> param = new HashMap<>();
        param.put("salience", salience);
        param.put("id", id);
        param.put("ApplicationIdentifier", ApplicationIdentifier);
        param.put("ApplicationTypeName", ApplicationTypeName);
        param.put("EntityCategory", EntityCategory);
        param.put("NativeType", NativeType);
        param.put("eval_order", eval_order);
        param.put("staging_context", staging_context);
        param.put("task_category", task_category);
        param.put("uri",uri);
        return param;
    }


    @Test(testName = "Execution Scoped globals")
    public void test1() throws FileNotFoundException {
        NewFact fact = new NewFact("Salesforce masco", "All", "Permission", "User Account", "ENTITY_DATA_PROCESSING", "RelationshipsAnalysis");
        List<Result> list = new ArrayList<>();
        final List<Command> commands = newArrayList();
        commands.add(CommandFactory.newInsert(fact,"fact"));
        commands.add(CommandFactory.newSetGlobal("list",list));
        FireAllRulesCommand fireAllRulesCommand = new FireAllRulesCommand();
        commands.add(fireAllRulesCommand);
        ExecutionResults results = kieSession.execute(CommandFactory.newBatchExecution(commands));
        System.out.println(results.getFactHandle("fact"));
        System.out.println(list);
    }
}
