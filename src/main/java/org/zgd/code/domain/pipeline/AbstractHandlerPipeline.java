package org.zgd.code.domain.pipeline;

import org.zgd.code.domain.base.PojoDateInfo;

import java.util.ArrayList;

/**
 * @author thesky
 * @date 2022/7/15 17:03
 */
public abstract class AbstractHandlerPipeline<T> {

    public ArrayList<T> pipline;
    public Integer tail;
    public Integer cur;

    public abstract void doHandler(PojoDateInfo info);

    public abstract void installPipline();

    public AbstractHandlerPipeline(){
        pipline = new ArrayList<>();
        tail =cur =-1;
    }


    public void addLast(T handler){
        pipline.add(handler);
        tail++;
    }

}
