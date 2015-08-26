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
 */
public class ProxyClass_Test {

    @Test
    public void proxy_test() throws Throwable {

        InitExceptionService exceptionService = new InitExceptionService();

        final TestExceptionBean_Inter test_bean = new TestExceptionBean();

        try {

            test_bean.test_exception();

        }catch(Throwable throwable) {

            exceptionService.getExceptionService().handler("user", throwable).autoRunException();
        }
    }



}
