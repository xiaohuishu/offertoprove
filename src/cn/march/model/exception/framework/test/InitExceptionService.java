


    package cn.march.model.exception.framework.test;

    import cn.march.model.exception.framework.ExceptionHandler;
    import cn.march.model.exception.framework.ExceptionService;
    import cn.march.model.exception.framework.default_impl.DefaultExceptionService;

    /**
     * Created by antsmarth on 15-8-26.
     *
     * 初始化异常业务类
     *
     */
    public class InitExceptionService {

        //异常业务类
        private ExceptionService exceptionService = null;
        //处理策略
        private String policy = "user";

        //构造方法
        public InitExceptionService() {

            //初始化方法
            initExceptionService();

        }

        //exceptionService getter方法
        public ExceptionService getExceptionService() {
                                                            return exceptionService;
                                                                                                                                        }

        /**
         * exceptionService类初始化方法：
         *      添加2个自定义异常处理器
         *
         */
        private void initExceptionService() {

            exceptionService = new DefaultExceptionService(2);
            initPolicy(policy, new UserDefineHandler1());
            initPolicy(policy, new UserDefineHandler2());

        }

        /**
         * 根据处理策略注册异常处理器：handler
         *
         * @param policy
         * @param handler
         */
        private void initPolicy(String policy, ExceptionHandler handler) {

            System.out.println("start init ExceptionService policy(user)...");
            exceptionService.registerHandler(policy, handler);

        }


    }
