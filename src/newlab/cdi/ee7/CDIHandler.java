package newlab.cdi.ee7;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.function.Supplier;


@Stateless
public class CDIHandler //implements Supplier<String>
{

    private String r = "Not initialized";
    //@Inject Insta

    @Inject @A InterfaceA interfaceA;

    @PostConstruct
    private void init() {
        r = "interfaceA = " + interfaceA.toString() + "; ";
    }

    public String get() {
        return r;
    }
}
