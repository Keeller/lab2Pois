package main;

import POJOS.Client;
import POJOS.Credit;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        System.out.println(kc.verify().getMessages().toString());
        execute(kc);
    }



    public static void execute( KieContainer kc ) {
        KieSession ksession = kc.newKieSession("ksession-rules");
        Client client=new Client("vasya",1200,2,false);
        Client client1=new Client("ne ochen vasya",900,1,false);
        Client client2=new Client("ochen plohoy vasya",1200000,1,true);
        Client client3=new Client("ochen horoshy vasya",1300000,100,false);
        Credit credit=new Credit(0,0);
        ksession.insert(client);
        ksession.insert(client1);
        ksession.insert(client2);
        ksession.insert(client3);
        ksession.insert(credit);
        ksession.fireAllRules();


    }
}
