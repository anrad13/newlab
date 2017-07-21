package newlab.concurrency.ee7;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import java.util.concurrent.Future;

@Stateless

public class ConcurrencyHandler {

    @Resource(name = "DefaultManagedExecutorService")
    ManagedExecutorService executor;

    @Inject
    SimpleBean simpleBean;

    public String apply() {
        String res = "ConcurrencyHandler...\n";

        res += "Start non-concurrency bean...\n";
        res += simpleBean.apply("non-cuncurrency mode") + "\n";

        res += "Start concurrency class...\n";
        Future<String> futureResult = executor.submit(new SimpleCallableTask("Task 1", simpleBean));
        while (!futureResult.isDone()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            res += "SimpleCallableTask; result = " + futureResult.get() + "\n";
        } catch (Exception e) {
            e.printStackTrace();
        }



            return res;
    }
}
