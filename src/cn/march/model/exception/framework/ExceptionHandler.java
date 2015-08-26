package cn.march.model.exception.framework;

/**
 * Created by antsmarth on 15-8-26.
 */
public interface ExceptionHandler {

    void handler(ExceptionHandlerChain chain);

}
