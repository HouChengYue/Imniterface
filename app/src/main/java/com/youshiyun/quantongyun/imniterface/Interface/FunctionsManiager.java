package com.youshiyun.quantongyun.imniterface.Interface;

import android.text.TextUtils;
import java.util.HashMap;

/**
 * Created by 侯程月  2018年08月09日.
 * QQ 437286343
 * 接口管理类
 */
public class FunctionsManiager {
    private static final FunctionsManiager ourInstance = new FunctionsManiager();

    public static FunctionsManiager getInstance() {
        return ourInstance;
    }

    private FunctionsManiager() {
        mStringNPNRFunctionHashMap = new HashMap<>();
        mStringNPRFunctionHashMap = new HashMap<>();
        mStringPNRFunctionHashMap = new HashMap<>();
        mStringPRFunctionHashMap = new HashMap<>();
    }


    private HashMap<String, NPNRFunction> mStringNPNRFunctionHashMap;
    private HashMap<String, NPRFunction> mStringNPRFunctionHashMap;
    private HashMap<String, PNRFunction> mStringPNRFunctionHashMap;
    private HashMap<String, PRFunction> mStringPRFunctionHashMap;

    public FunctionsManiager addFunction(NPNRFunction pFunction) {
        mStringNPNRFunctionHashMap.put(pFunction.mFactionName, pFunction);
        return this;
    }

    public FunctionsManiager addFunction(NPRFunction pFunction) {
        mStringNPRFunctionHashMap.put(pFunction.mFactionName, pFunction);
        return this;
    }

    public FunctionsManiager addFunction(PNRFunction pFunction) {
        mStringPNRFunctionHashMap.put(pFunction.mFactionName, pFunction);
        return this;
    }

    public FunctionsManiager addFunction(PRFunction pFunction) {
        mStringPRFunctionHashMap.put(pFunction.mFactionName, pFunction);
        return this;
    }

    public void invokeFuction(String factionName) {
        if (TextUtils.isEmpty(factionName)) {
            return;
        }
        if (mStringNPNRFunctionHashMap != null) {
            NPNRFunction lNPNRFunction = mStringNPNRFunctionHashMap.get(factionName);
            if (lNPNRFunction != null) {
                lNPNRFunction.function();
            } else {
                throw new FunctionExcption("没有该Fuction");
            }
        } else {
            throw new FunctionExcption("没有初始化FunctionsManiager");
        }
    }

    public <Res> Res invokeFuction(String factionName, Class<Res> c) {
        if (TextUtils.isEmpty(factionName)) {
            return null;
        }
        if (mStringNPRFunctionHashMap != null) {
            NPRFunction lNPRFunction = mStringNPRFunctionHashMap.get(factionName);
            if (lNPRFunction != null) {
                if (c != null) {
                    return c.cast(lNPRFunction.function());
                } else {
                    return (Res) lNPRFunction.function();
                }
            } else {
                throw new FunctionExcption("没有该Fuction");
            }

        } else {
            throw new FunctionExcption("没有初始化FunctionsManiager");
        }
    }

    public <Param> void invokeFuction(String factionName, Param data) {
        if (TextUtils.isEmpty(factionName)) {
            return;
        }
        if (mStringPNRFunctionHashMap != null) {
            PNRFunction lPNRFunction = mStringPNRFunctionHashMap.get(factionName);
            if (lPNRFunction != null) {
                lPNRFunction.function(data);
            } else {
                throw new FunctionExcption("没有该Fuction");
            }

        } else {
            throw new FunctionExcption("没有初始化FunctionsManiager");
        }
    }

    public <Param, Res> Res invokeFuction(String factionName, Param data, Class<Res> c) {
        if (TextUtils.isEmpty(factionName)) {
            return null;
        }
        if (mStringPRFunctionHashMap != null) {
            PRFunction lPRFunction = mStringPRFunctionHashMap.get(factionName);
            if (lPRFunction != null) {
                if (c != null) {
                 return c.cast(lPRFunction.function(data));
                }
                return (Res) lPRFunction.function(data);
            } else {
                throw new FunctionExcption("没有该Fuction");
            }

        } else {
            throw new FunctionExcption("没有初始化FunctionsManiager");
        }
    }
}
