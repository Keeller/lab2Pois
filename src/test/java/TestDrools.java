import POJOS.Client;
import POJOS.Credit;
import org.drools.core.command.assertion.AssertEquals;
import org.junit.Assert;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class TestDrools {

    KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();


    @Test
    public void testGood(){
        KieSession ksession = kc.newKieSession("ksession-rules");
        System.out.println(kc.verify().getMessages().toString());
        Client client3=new Client("ochen horoshy vasya",1300000,100,false);
        Credit credit=new Credit(0,0);
        ksession.insert(client3);
        ksession.insert(credit);
        ksession.fireAllRules();
        Assert.assertEquals(Integer.valueOf(3000),credit.getSumm());
        Assert.assertEquals(Integer.valueOf(70),credit.getPercent());
    }

    @Test
    public void testBad(){
        KieSession ksession = kc.newKieSession("ksession-rules");
        System.out.println(kc.verify().getMessages().toString());
        Client client=new Client("vasya",1200,2,false);
        Credit credit=new Credit(0,0);
        ksession.insert(client);
        ksession.insert(credit);
        ksession.fireAllRules();
        Assert.assertEquals(Integer.valueOf(1200),credit.getSumm());
        Assert.assertEquals(Integer.valueOf(30),credit.getPercent());
    }

    @Test
    public void testVeryBad(){
        KieSession ksession = kc.newKieSession("ksession-rules");
        System.out.println(kc.verify().getMessages().toString());
        Client client2=new Client("ochen plohoy vasya",1200000,1,true);
        Credit credit=new Credit(0,0);
        ksession.insert(client2);
        ksession.insert(credit);
        ksession.fireAllRules();
        Assert.assertEquals(Integer.valueOf(0),credit.getSumm());
        Assert.assertEquals(Integer.valueOf(0),credit.getPercent());
    }

}
