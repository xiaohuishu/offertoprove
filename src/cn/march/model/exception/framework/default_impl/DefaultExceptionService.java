



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
     *
     * 默认异常业务处理逻辑实现类：
     *      继承于ExceptionService接口
     *      通过接受从客户端捕获到的异常对象,和处理策略
     *      初始化自定义异常处理类,与处理策略相关联(Map<String, List<ExceptionHandler>>)
     *      通过调用ExceptionHandlerChain处理链完成实际的业务操作
     */
    public class DefaultExceptionService implements ExceptionService{

        //处理策略,自定义异常处理类集合
        private Map<String, List<ExceptionHandler>> policy_handlers = null;
        //异常处理责任链
        private ExceptionHandlerChain chain = null;

        //构造方法
        public DefaultExceptionService(int cap) {

            policy_handlers = new HashMap<>(cap);

        }

        public DefaultExceptionService() {
            this(1);
        }


        /**
         * 实际的处理业务方法：
         *      接受从客户端传递过来的处理策略：String policy
         *                        捕获异常：Throwable exception
         *      调用默认异常处理链的处理方法: DefaultExceptionHandlerChain.proceed();
         *      返回异常处理结果;
         *
         * @param policy : 处理策略
         * @param exception ： 捕获异常
         * @return ExceptionHandlerResult
         */
        @Override
        public ExceptionHandlerResult handler(String policy, Throwable exception, String chain_type) {

            switch (chain_type) {

                case "default" :
                    chain = new DefaultExceptionHandlerChain(this.getPolicyHandler(policy),exception);
                    break;
                case "other" :
                    System.out.println("nothing chain found...");
                    break;
                default:
                    break;

            }

            if(null == chain)
                throw new RuntimeException("请检查异常处理链类是否配置或者存在...");

            chain.proceed();

            return chain.createExceptionHandlerResult();

        }


        /**
         * 向某个具体的处理策略添加指定的异常处理器
         *
         * @param policy
         * @param handler
         * @return
         */
        @Override
        public ExceptionService registerHandler(String policy, ExceptionHandler handler) {

            this.getPolicyHandler(policy).add(handler);

            return this;
        }

        /**
         * 获取某个处理策略的异常处理器集合
         *
         * @param policy
         * @return
         */
        private List<ExceptionHandler> getPolicyHandler(String policy) {

            if(!policy_handlers.containsKey(policy))
                policy_handlers.put(policy, new ArrayList<ExceptionHandler>(2));

            return policy_handlers.get(policy);

        }

    }
