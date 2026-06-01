package com.google.firebase.inappmessaging.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import d5.m0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ForegroundNotifier implements Application.ActivityLifecycleCallbacks {
    public static final long DELAY_MILLIS = 1000;
    private Runnable check;
    private final Handler handler = new Handler();
    private boolean foreground = false;
    private boolean paused = true;
    private final o5.b foregroundSubject = new o5.b();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityPaused$0() {
        boolean z2 = this.foreground;
        this.foreground = !(z2 && this.paused) && z2;
    }

    public w4.a foregroundFlowable() {
        o5.b bVar = this.foregroundSubject;
        bVar.getClass();
        d5.m mVar = new d5.m(bVar, 3);
        int i2 = s4.d.f13683a;
        z4.b.b(i2, "bufferSize");
        return new m0(mVar, i2).c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.paused = true;
        Runnable runnable = this.check;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Handler handler = this.handler;
        a3.b bVar = new a3.b(this, 19);
        this.check = bVar;
        handler.postDelayed(bVar, 1000L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.paused = false;
        boolean z2 = this.foreground;
        this.foreground = true;
        Runnable runnable = this.check;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        if (z2) {
            return;
        }
        Logging.logi("went foreground");
        this.foregroundSubject.b(InAppMessageStreamManager.ON_FOREGROUND);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
