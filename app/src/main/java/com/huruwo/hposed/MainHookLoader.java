package com.huruwo.hposed;

import com.huruwo.hposed.utils.LogXUtils;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;


public class MainHookLoader implements IXposedHookLoadPackage {
    private ClassLoader classLoader;
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals("com.tencent.mm")) {
            LogXUtils.e(lpparam.packageName + " start hook");
            classLoader = lpparam.classLoader;
        } else {
            return;
        }
    }
}
