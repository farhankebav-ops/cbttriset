package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lMM implements Thread.UncaughtExceptionHandler {
    public static volatile boolean IlO;
    private String EO;
    private final Thread.UncaughtExceptionHandler MY = Thread.getDefaultUncaughtExceptionHandler();

    private lMM() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        MY();
    }

    private void EO() {
        try {
            Method methodIlO = com.bytedance.sdk.component.utils.oc.IlO("com.bytedance.sdk.openadsdk.TTC2Proxy", "a", Context.class);
            if (methodIlO != null) {
                methodIlO.invoke(null, com.bytedance.sdk.openadsdk.core.cl.IlO());
            }
        } catch (Throwable unused) {
        }
        try {
            Method methodIlO2 = com.bytedance.sdk.component.utils.oc.IlO("com.bytedance.sdk.openadsdk.TTC3Proxy", "a", Context.class);
            if (methodIlO2 != null) {
                methodIlO2.invoke(null, com.bytedance.sdk.openadsdk.core.cl.IlO());
            }
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.settings.hp.aP().IlO();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.component.adexpress.IlO.MY.MY.MY();
        } catch (Throwable unused4) {
        }
    }

    public static lMM IlO() {
        return new lMM();
    }

    private void MY() {
        Context contextIlO = com.bytedance.sdk.openadsdk.core.cl.IlO();
        if (contextIlO == null) {
            return;
        }
        try {
            File file = new File(contextIlO.getFilesDir(), "TTCache");
            file.mkdirs();
            this.EO = file.getPath();
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        IlO = true;
        com.bytedance.sdk.component.lEW.DmF.sCrashHappened = true;
        com.bytedance.sdk.component.lEW.EO.tV.EO = true;
        boolean zContains = false;
        com.bytedance.sdk.component.lEW.vCE.IlO(false);
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            if (string != null) {
                zContains = string.contains(AdSlot.class.getPackage().getName());
            }
        } catch (Throwable unused) {
        }
        if (zContains) {
            IlO(thread, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.MY;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void IlO(java.lang.Thread r12, java.lang.Throwable r13) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.lMM.IlO(java.lang.Thread, java.lang.Throwable):void");
    }
}
