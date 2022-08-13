package org.zgd.code.domain.pipeline;

import org.zgd.code.domain.base.PojoDateInfo;
import org.zgd.code.domain.handler.*;

/**
 * @author thesky
 * @date 2022/7/15 17:19
 */
public class TemplateHandlerPipeline extends AbstractHandlerPipeline<CreateHandler<PojoDateInfo>> {

    @Override
    public void doHandler(PojoDateInfo pojoDateInfo) {
        installPipline();
        while (cur<tail){
            pipline.get(++cur).creat(pojoDateInfo);
        }
        cur = -1;
    }

    @Override
    public void installPipline() {
        CreateHandler<PojoDateInfo> initHandler = new InitHandler();
        CreateHandler<PojoDateInfo> entityCreateHandler = new EntityCreateHandler();
        CreateHandler<PojoDateInfo> serviceCreateHandler = new ServiceCreateHandler();
        CreateHandler<PojoDateInfo> serviceImplCreateHandler = new ServiceImplCreateHandler();
        CreateHandler<PojoDateInfo> controllerCreateHandler = new ControllerCreateHandler();
        addLast(initHandler);
        addLast(entityCreateHandler);
        addLast(serviceCreateHandler);
        addLast(serviceImplCreateHandler);
        addLast(controllerCreateHandler);
    }
}
