package cn.march.model.exception.framework;

import java.util.List;

/**
 * Created by antsmarth on 15-8-26.
 */
public interface ExceptionService {

    ExceptionHandlerResult handler(String policy, Throwable exception, String chain_type);
    ExceptionService registerHandler(String policy, ExceptionHandler handler);

}
