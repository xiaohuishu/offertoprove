

    package cn.march.model.exception.framework;

    /**
     * Created by antsmarth on 15-8-26.
     *
     * 异常处理接口
     */
    public interface ExceptionHandler {

        //异常处理方法
        void handler(ExceptionHandlerChain chain);

    }
