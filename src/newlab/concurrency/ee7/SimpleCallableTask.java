package newlab.concurrency.ee7;


import javax.inject.Inject;
import java.util.concurrent.Callable;

public class SimpleCallableTask implements Callable<String> {

        //@Inject
        SimpleBean simpleBean;

        private String val = "";

        public SimpleCallableTask(String val, SimpleBean simpleBean) {
            this.val = val;
            this.simpleBean = simpleBean;
        }
        public String call() {
            String res = "SimpleCallableTask = " + val + "; " + simpleBean.apply("concur mode for " + val);
            //String res = "SimpleCallableTask = " + val;
            return res;
        }


}
