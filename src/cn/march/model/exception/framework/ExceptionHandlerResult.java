



    package cn.march.model.exception.framework;

    /**
     * Created by antsmarth on 15-8-26.
     *
     * 异常处理结果类
     *
     */
    public class ExceptionHandlerResult {

        //处理异常
        private Throwable exception;
        //转译异常
        private Throwable new_exception;
        //异常是否抛出
        private boolean exceptionHandler;

        //构造方法
        public ExceptionHandlerResult(Throwable exception, Throwable new_exception, boolean exceptionHandler) {

            this.exception = exception;
            this.new_exception = new_exception;
            this.exceptionHandler = exceptionHandler;

        }

        /**
         * 执行异常方法：
         *      若存在转译异常,抛出
         *      若设置异常抛出标志位,若false则抛出
         *
         * @throws Throwable
         */
        public void autoRunException() throws Throwable {

            if(this.new_exception != null)
                throw new_exception;
            if(!exceptionHandler)
                throw exception;

        }


    }
