package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.ApmHelper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea {
    private final com.bytedance.sdk.openadsdk.utils.IlO IlO = new com.bytedance.sdk.openadsdk.utils.IlO();
    private boolean MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private static final ea IlO = new ea();
    }

    public static ea IlO() {
        return IlO.IlO;
    }

    public com.bytedance.sdk.openadsdk.utils.IlO Cc() {
        return this.IlO;
    }

    public boolean EO() {
        return this.MY;
    }

    public void MY() {
        try {
            Context contextIlO = cl.IlO();
            if (contextIlO instanceof Application) {
                ((Application) contextIlO).registerActivityLifecycleCallbacks(this.IlO);
                this.MY = true;
            } else {
                if (contextIlO == null || contextIlO.getApplicationContext() == null) {
                    return;
                }
                ((Application) contextIlO.getApplicationContext()).registerActivityLifecycleCallbacks(this.IlO);
                this.MY = true;
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("registerActivityLifecycleError", "registerActivityLifecycle", th);
        }
    }

    public boolean tV() {
        return this.IlO.IlO();
    }

    public boolean IlO(boolean z2) {
        return this.IlO.IlO(z2);
    }
}
