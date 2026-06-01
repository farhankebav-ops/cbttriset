package com.ironsource.adqualitysdk.sdk.i;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class jn {

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private jo f2849;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private boolean f2847 = false;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private Handler f2848 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private jg f2846 = new jj() { // from class: com.ironsource.adqualitysdk.sdk.i.jn.3
        @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            jn.m2741(jn.this);
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            jn.m2741(jn.this);
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            jn.m2740(jn.this, activity);
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            jn.m2743(jn.this, activity);
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            jn.m2741(jn.this);
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            jn.m2741(jn.this);
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            jn.m2741(jn.this);
        }
    };

    public jn(jo joVar) {
        this.f2849 = joVar;
        jf.m2685().m2686(this.f2846);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ void m2740(jn jnVar, final Activity activity) {
        jnVar.f2848.postDelayed(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jn.5
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                jn.m2744(jn.this);
                if (jn.this.f2849 != null) {
                    jn.this.f2849.mo472(activity);
                }
            }
        }, 500L);
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ void m2741(jn jnVar) {
        jnVar.f2848.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ boolean m2744(jn jnVar) {
        jnVar.f2847 = true;
        return true;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m2745() {
        this.f2848.removeCallbacksAndMessages(null);
        if (this.f2846 != null) {
            jf.m2685().m2689(this.f2846);
            this.f2846 = null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m2743(jn jnVar, Activity activity) {
        if (jnVar.f2847) {
            jnVar.f2847 = false;
            jo joVar = jnVar.f2849;
            if (joVar != null) {
                joVar.mo471(activity);
            }
        }
        jnVar.f2848.removeCallbacksAndMessages(null);
    }
}
