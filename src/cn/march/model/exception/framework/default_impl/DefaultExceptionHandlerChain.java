package cn.march.model.exception.framework.default_impl;

import cn.march.model.exception.framework.ExceptionHandler;
import cn.march.model.exception.framework.ExceptionHandlerChain;
import cn.march.model.exception.framework.ExceptionHandlerResult;

import java.util.List;

/**
 * Created by antsmarth on 15-8-26.
 */
public class DefaultExceptionHandlerChain implements ExceptionHandlerChain {

    private List<ExceptionHandler> handlers = null;
    private int currentHandlerIndex = 0;
    private Throwable exception;
    private Throwable new_exception;
    private boolean exceptionHandler;

    public DefaultExceptionHandlerChain(List<ExceptionHandler> handlers, Throwable exception) {

        this.handlers = handlers;
        this.exception = exception;

    }

    @Override
    public Throwable getException() {

        return this.exception;
    }

    @Override
    public void setException(Throwable exception) {

        this.setExceptionHandler(true);
        this.new_exception = exception;

    }

    @Override
    public boolean isExceptionHandler() {

        return this.exceptionHandler;
    }

    @Override
    public void setExceptionHandler(boolean exceptionHandler) {

        this.exceptionHandler = exceptionHandler;

    }

    @Override
    public void proceed() {

        while(canProceed()) {

            this.getCurrentExceptionHandler().handler(this);
            currentHandlerIndex++;

        }

    }

    public ExceptionHandlerResult createExceptionHandlerResult() {
        return new ExceptionHandlerResult(this.exception, this.new_exception, this.exceptionHandler);
    }

    private boolean canProceed() {
        return this.currentHandlerIndex <= handlers.size() - 1;
    }

    private ExceptionHandler getCurrentExceptionHandler() {
        return this.handlers.get(this.currentHandlerIndex);
    }

}
