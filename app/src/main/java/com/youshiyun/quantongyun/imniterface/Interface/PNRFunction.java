package com.youshiyun.quantongyun.imniterface.Interface;

/**
 * Created by 侯程月  2018年08月09日.
 * QQ 437286343
 * 有参数没返回值
 */
public abstract class PNRFunction<Param> extends Function {
    public PNRFunction(String pFactionName) {
        super(pFactionName);
    }

    public abstract void function(Param data);

}
