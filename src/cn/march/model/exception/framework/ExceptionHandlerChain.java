package cn.march.model.exception.framework;

/**
 * Created by antsmarth on 15-8-26.
 */
public interface ExceptionHandlerChain {

    Throwable getException();
    void setException(Throwable exception);
    boolean isExceptionHandler();
    void setExceptionHandler(boolean exceptionHandler);
    void proceed();
    ExceptionHandlerResult createExceptionHandlerResult();
}
