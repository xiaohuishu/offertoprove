


    package cn.march.model.exception.framework.test;

    import cn.march.model.exception.framework.ExceptionHandler;
    import cn.march.model.exception.framework.ExceptionHandlerChain;

    import java.lang.reflect.InvocationTargetException;

    /**
     * Created by antsmarth on 15-8-26.
     *
     * 用户自定义处理器 - 1
     *
     */
    public class UserDefineHandler1 implements ExceptionHandler {

        /**
         * 处理方法
         * @param chain
         */
        @Override
        public void handler(ExceptionHandlerChain chain) {

            System.out.println("UserDefineHandler1 start process: " + chain.getException());

            chain.setExceptionHandler(true);

           // chain.proceed();


        }
    }
