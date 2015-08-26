package cn.march.model.exception.framework.test;

/**
 * Created by antsmarth on 15-8-26.
 */
public class TestExceptionBean implements TestExceptionBean_Inter {

    public void test_exception() {

        System.out.println("test_exception_bean start...");

        throw new RuntimeException("test_exception_bean throw RuntimeException...");
    }

}
