


    package cn.march.model.exception.framework;

    import java.util.List;

    /**
     * Created by antsmarth on 15-8-26.
     *
     * 异常业务处理接口
     *      声明业务处理方法 ： handler(...)
     *      根据处理策略,注册自定义处理器 : registerHandler(...)
     *
     */
    public interface ExceptionService {

        //处理业务方法
        ExceptionHandlerResult handler(String policy, Throwable exception, String chain_type);
        //根据处理策略,注册自定义处理器
        ExceptionService registerHandler(String policy, ExceptionHandler handler);

    }
