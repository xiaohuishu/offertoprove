


    package cn.march.model.exception.framework.test;

    /**
     * Created by antsmarth on 15-8-26.
     *
     * 测试异常Bean
     *
     */
    public class TestExceptionBean implements TestExceptionBean_Inter {

        //测试方法
        public void test_exception() {

            System.out.println("test_exception_bean start...");

            //抛出异常
            throw new RuntimeException("test_exception_bean throw RuntimeException...");
        }

    }
