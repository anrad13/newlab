package newlab.cdi.ee7;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;
//import javax.enterprise.

/**
 * Created by Radoselskiy on 07.08.2017.
 */
@Stateless

@Startup

public class CDIHandler {

    //@Inject Insta

    @Inject BeanAA aa;

    @PostConstruct
    private void init() {


    }

    public String get() {
        String r = "";

        r += "aa = " + aa.toString() + "; ";


        return r;

    }
}
