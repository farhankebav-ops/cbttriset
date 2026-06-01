package com.bytedance.sdk.openadsdk.oeT;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc implements tV {
    Handler IlO = null;
    private tV MY;

    public Cc(tV tVVar) {
        this.MY = tVVar;
    }

    private Context lEW() {
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, null);
            return (Application) objInvoke.getClass().getMethod("getApplication", null).invoke(objInvoke, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.oeT.tV
    public Map<String, String> Bc() {
        tV tVVar = this.MY;
        return (tVVar == null || tVVar.Bc() == null) ? new HashMap() : this.MY.Bc();
    }

    @Override // com.bytedance.sdk.openadsdk.oeT.tV
    public String Cc() {
        tV tVVar = this.MY;
        if (tVVar != null) {
            return tVVar.Cc();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.oeT.tV
    public String EO() {
        tV tVVar = this.MY;
        return (tVVar == null || TextUtils.isEmpty(tVVar.EO())) ? "null" : this.MY.EO();
    }

    @Override // com.bytedance.sdk.openadsdk.oeT.tV
    public ExecutorService IlO() {
        tV tVVar = this.MY;
        return (tVVar == null || tVVar.IlO() == null) ? Executors.newCachedThreadPool() : this.MY.IlO();
    }

    @Override // com.bytedance.sdk.openadsdk.oeT.tV
    public Context MY() {
        tV tVVar = this.MY;
        return (tVVar == null || tVVar.MY() == null) ? lEW() : this.MY.MY();
    }

    @Override // com.bytedance.sdk.openadsdk.oeT.tV
    public Handler tV() {
        tV tVVar = this.MY;
        if (tVVar != null && tVVar.Bc() != null) {
            return this.MY.tV();
        }
        Handler handler = new Handler(IlO("pag_strategy", -1).getLooper());
        this.IlO = handler;
        return handler;
    }

    @Override // com.bytedance.sdk.openadsdk.oeT.tV
    public JSONObject vCE() {
        tV tVVar = this.MY;
        if (tVVar != null) {
            return tVVar.vCE();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.oeT.tV
    public JSONObject IlO(JSONObject jSONObject) {
        tV tVVar = this.MY;
        return tVVar != null ? tVVar.IlO(jSONObject) : jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.oeT.tV
    public HandlerThread IlO(String str, int i2) {
        HandlerThread handlerThreadIlO;
        tV tVVar = this.MY;
        if (tVVar != null && (handlerThreadIlO = tVVar.IlO(str, i2)) != null) {
            return handlerThreadIlO;
        }
        HandlerThread handlerThread = new HandlerThread("pag_strategy", -1);
        handlerThread.start();
        return handlerThread;
    }
}
