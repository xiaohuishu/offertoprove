



    package cn.march.model.exception.framework.default_impl;

    import cn.march.model.exception.framework.ExceptionHandler;
    import cn.march.model.exception.framework.ExceptionHandlerChain;
    import cn.march.model.exception.framework.ExceptionHandlerResult;

    import java.util.List;

    /**
     * Created by antsmarth on 15-8-26.
     * 类的职责：
     *      默认异常处理链的实现类
     *      类中包括自定义异常处理类的集合 handlers : List<ExceptionHandler>
     *      需要捕获处理的异常 exception : Throwable
     *      需要转译的新的异常 new_exception : Throwable
     *      异常是否需要抛出 exceptionHandler : boolean
     *
     */
    public class DefaultExceptionHandlerChain implements ExceptionHandlerChain {

        //自定义异常处理类集合
        private List<ExceptionHandler> handlers = null;
        //当前异常处理器游标
        private int currentHandlerIndex = 0;
        //捕获异常
        private Throwable exception;
        //转译异常
        private Throwable new_exception;
        //异常是否抛出
        private boolean exceptionHandler;

        //构造方法,通过传入自定义异常处理类集合和捕获异常构造对象
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

        /**
         * 异常处理方法：
         *      遍历自定义异常处理类集合,调用处理方法
         */
        @Override
        public void proceed() {

            while(canProceed()) {

                this.getCurrentExceptionHandler().handler(this);
                currentHandlerIndex++;

            }

        }

        /**
         * 通过捕获异常与转译异常和是否抛出异常标志位,创建异常处理结果类;
         * @return ExceptionHandlerResult : result
         */
        public ExceptionHandlerResult createExceptionHandlerResult() {
            return new ExceptionHandlerResult(this.exception, this.new_exception, this.exceptionHandler);
        }

        /**
         * 判断处理类集合是否遍历完成
         * @return boolean : flag
         */
        private boolean canProceed() {
            return this.currentHandlerIndex <= handlers.size() - 1;
        }

        /**
         * 通过当前处理类游标获取实际的异常处理类
         * @return ExceptionHandler : handler
         */
        private ExceptionHandler getCurrentExceptionHandler() {
            return this.handlers.get(this.currentHandlerIndex);
        }

    }
