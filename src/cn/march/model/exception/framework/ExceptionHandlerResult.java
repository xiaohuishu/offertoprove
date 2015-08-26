package cn.march.model.exception.framework;

/**
 * Created by antsmarth on 15-8-26.
 */
public class ExceptionHandlerResult {

    private Throwable exception;
    private Throwable new_exception;
    private boolean exceptionHandler;

    public ExceptionHandlerResult(Throwable exception, Throwable new_exception, boolean exceptionHandler) {

        this.exception = exception;
        this.new_exception = new_exception;
        this.exceptionHandler = exceptionHandler;

    }


    public void autoRunException() throws Throwable {

        if(this.new_exception != null)
            throw new_exception;
        if(!exceptionHandler)
            throw exception;

    }


}
