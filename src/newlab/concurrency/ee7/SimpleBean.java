package newlab.concurrency.ee7;

import javax.ejb.Stateless;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.logging.Logger;


@Stateless
public class SimpleBean {
    private UUID uuid = UUID.randomUUID();
    private Logger logger = Logger.getLogger("SimpleBean");

    public String apply(String val) {
        String res = uuid.toString() + "; val = " + val +"; ";
        res += "Start = " + new java.util.Date().toString() +"; ";

        try {
            Thread.sleep(1000);
            res += "Stop = " + new java.util.Date().toString()  +"; Msg = " + val +"; ";
        } catch (Exception e) {
            res += "Interrupt = " + new java.util.Date().toString()  +"; Msg = " + e.toString() +"; ";
        }

        return res;
    }

}
