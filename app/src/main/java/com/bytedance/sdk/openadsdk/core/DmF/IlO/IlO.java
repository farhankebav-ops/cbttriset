package com.bytedance.sdk.openadsdk.core.DmF.IlO;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements Application.ActivityLifecycleCallbacks {
    private static volatile IlO IlO;
    private final MY MY;

    private IlO(Application application) {
        this.MY = MY.IlO(application);
    }

    public static IlO IlO(Application application) {
        if (IlO == null) {
            synchronized (IlO.class) {
                try {
                    if (IlO == null) {
                        IlO = new IlO(application);
                        application.registerActivityLifecycleCallbacks(IlO);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        MY my = this.MY;
        if (my != null) {
            my.IlO(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        MY my = this.MY;
        if (my != null) {
            my.MY(activity);
        }
    }

    public String IlO(String str, long j, int i2) {
        MY my = this.MY;
        if (my != null) {
            return my.IlO(str, j, i2);
        }
        return "null";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
