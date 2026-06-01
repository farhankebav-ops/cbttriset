package com.bytedance.sdk.openadsdk;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.openadsdk.cl.MY;
import com.bytedance.sdk.openadsdk.cl.MY.IlO;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class BusMonitorDependWrapper implements MY {
    private MY IlO;
    private Handler MY;

    public BusMonitorDependWrapper(MY my) {
        this.IlO = my;
    }

    public static Context getReflectContext() {
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, null);
            return (Application) objInvoke.getClass().getMethod("getApplication", null).invoke(objInvoke, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.cl.MY
    public Context getContext() {
        MY my = this.IlO;
        return (my == null || my.getContext() == null) ? getReflectContext() : this.IlO.getContext();
    }

    @Override // com.bytedance.sdk.openadsdk.cl.MY
    public Handler getHandler() {
        MY my = this.IlO;
        if (my != null && my.getHandler() != null) {
            return this.IlO.getHandler();
        }
        if (this.MY == null) {
            this.MY = new Handler(getSafeHandlerThread("pag_monitor", 0).getLooper());
        }
        return this.MY;
    }

    @Override // com.bytedance.sdk.openadsdk.cl.MY
    public int getOnceLogCount() {
        MY my = this.IlO;
        if (my != null) {
            return my.getOnceLogCount();
        }
        return 20;
    }

    @Override // com.bytedance.sdk.openadsdk.cl.MY
    public int getOnceLogInterval() {
        MY my = this.IlO;
        if (my != null) {
            return my.getOnceLogInterval();
        }
        return 1000;
    }

    @Override // com.bytedance.sdk.openadsdk.cl.MY
    public HandlerThread getSafeHandlerThread(String str, int i2) {
        HandlerThread safeHandlerThread;
        MY my = this.IlO;
        if (my != null && (safeHandlerThread = my.getSafeHandlerThread(str, i2)) != null) {
            return safeHandlerThread;
        }
        HandlerThread handlerThread = new HandlerThread("pag_monitor");
        handlerThread.start();
        return handlerThread;
    }

    @Override // com.bytedance.sdk.openadsdk.cl.MY
    public int getUploadIntervalTime() {
        int uploadIntervalTime;
        MY my = this.IlO;
        if (my == null || (uploadIntervalTime = my.getUploadIntervalTime()) < 1800000) {
            return 1800000;
        }
        return uploadIntervalTime;
    }

    @Override // com.bytedance.sdk.openadsdk.cl.MY
    public boolean isMonitorOpen() {
        MY my = this.IlO;
        if (my != null) {
            return my.isMonitorOpen();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.cl.MY
    public void onMonitorUpload(List<IlO> list) {
        MY my = this.IlO;
        if (my != null) {
            my.onMonitorUpload(list);
        }
    }
}
