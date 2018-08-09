package com.youshiyun.quantongyun.imniterface.Interface;

/**
 * Created by 侯程月  2018年08月09日.
 * QQ 437286343
 * 没有参数有返回值
 */
public abstract class NPRFunction<Result> extends Function {
    public NPRFunction(String pFactionName) {
        super(pFactionName);
    }
    public abstract Result function();
}
