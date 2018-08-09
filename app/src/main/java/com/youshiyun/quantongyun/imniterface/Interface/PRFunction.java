package com.youshiyun.quantongyun.imniterface.Interface;

/**
 * Created by 侯程月  2018年08月09日.
 * QQ 437286343
 * 有参数有结果的
 */
public abstract class PRFunction<Param, Result> extends Function {
    public PRFunction(String pFactionName) {
        super(pFactionName);
    }

    public abstract Result function(Param data);
}
