package cn.march.model.exception.framework.default_impl;

import cn.march.model.exception.framework.ExceptionHandler;
import cn.march.model.exception.framework.ExceptionHandlerChain;
import cn.march.model.exception.framework.ExceptionHandlerResult;
import cn.march.model.exception.framework.ExceptionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by antsmarth on 15-8-26.
 */
public class DefaultExceptionService implements ExceptionService{

    private Map<String, List<ExceptionHandler>> policy_handlers = null;
    private ExceptionHandlerChain chain = null;

    public DefaultExceptionService(int cap) {

        policy_handlers = new HashMap<>(cap);

    }

    public DefaultExceptionService() {
        this(1);
    }


    @Override
    public ExceptionHandlerResult handler(String policy, Throwable exception) {

        chain = new DefaultExceptionHandlerChain(this.getPolicyHandler(policy), exception);

        chain.proceed();

        return chain.createExceptionHandlerResult();

    }


    @Override
    public ExceptionService registerHandler(String policy, ExceptionHandler handler) {

        this.getPolicyHandler(policy).add(handler);

        return this;
    }

    private List<ExceptionHandler> getPolicyHandler(String policy) {

        if(!policy_handlers.containsKey(policy))
            policy_handlers.put(policy, new ArrayList<ExceptionHandler>(2));

        return policy_handlers.get(policy);

    }

}
