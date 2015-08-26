


    package cn.march.model.exception.framework.test;

    import cn.march.model.exception.framework.ExceptionHandlerResult;
    import org.junit.Test;

    import java.lang.reflect.InvocationHandler;
    import java.lang.reflect.InvocationTargetException;
    import java.lang.reflect.Method;
    import java.lang.reflect.Proxy;
    import java.util.function.Consumer;

    /**
     * Created by antsmarth on 15-8-26.
     *
     * 单元测试类：
     *
     *      测试TestExceptionBean
     *
     *
     */
    public class ProxyClass_Test {

        @Test
        public void proxy_test() throws Throwable {

            //初始化ExceptionService方法
            InitExceptionService exceptionService = new InitExceptionService();

            //创建测试Bean
            TestExceptionBean_Inter test_bean = new TestExceptionBean();

            try {

                //调用测试方法
                test_bean.test_exception();

            }catch(Throwable throwable) {

                //接受异常并交给ExceptionService类处理
                exceptionService.getExceptionService().handler("user", throwable, "default").autoRunException();
            }
        }

    }
