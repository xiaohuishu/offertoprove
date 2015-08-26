package cn.march.model.exception.framework.test;

import cn.march.model.exception.framework.ExceptionHandler;
import cn.march.model.exception.framework.ExceptionService;
import cn.march.model.exception.framework.default_impl.DefaultExceptionService;

/**
 * Created by antsmarth on 15-8-26.
 */
public class InitExceptionService {

    private ExceptionService exceptionService = null;
    private String policy = "user";

    public InitExceptionService() {

        initExceptionService();

    }

    public ExceptionService getExceptionService() {
        return exceptionService;
    }

    private void initExceptionService() {

        exceptionService = new DefaultExceptionService(2);
        initPolicy(policy, new UserDefineHandler1());
        initPolicy(policy, new UserDefineHandler2());

    }

    private void initPolicy(String policy, ExceptionHandler handler) {

        System.out.println("start init ExceptionService policy(user)...");
        exceptionService.registerHandler(policy, handler);

    }


}
