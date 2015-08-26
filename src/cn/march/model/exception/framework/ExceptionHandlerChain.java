

    package cn.march.model.exception.framework;

    /**
     * Created by antsmarth on 15-8-26.
     *
     * 异常处理链接口
     *
     */
    public interface ExceptionHandlerChain {

        //获取当前处理异常
        Throwable getException();
        //设置转译异常
        void setException(Throwable exception);
        //异常是否抛出
        boolean isExceptionHandler();
        //设置标志位
        void setExceptionHandler(boolean exceptionHandler);
        //异常处理业务
        void proceed();
        //创建异常处理结果
        ExceptionHandlerResult createExceptionHandlerResult();
    }
