package newlab.concurrency.ee7;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
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
        List<Future<String>> results = new ArrayList<>();

        for (int i = 0; i<50; i++) {
            Future<String> futureResult = executor.submit(new SimpleCallableTask("Task " + i, simpleBean));
            results.add(futureResult);
        }
        while (! this.isDone(results)) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        res += this.buildResult(results);

        /*
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
        */



            return res;
    }

    private boolean isDone(List<Future<String>> l) {
        for( Future<String> f : l ) {
            if ( !f.isDone() ) {
                return false;
            }
        }
        return true;
    }

    private String buildResult(List<Future<String>> l) {
        String res = "";
        for( Future<String> f : l ) {
            try {
                res += "SimpleCallableTask; result = " + f.get() + "\n";
            } catch (Exception e) {
                res += "SimpleCallableTask; exception = " +  e.toString() + "\n";
            }
        }
        return res;
    }

}
