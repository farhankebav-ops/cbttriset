package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import com.bytedance.sdk.openadsdk.ApmHelper;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements Application.ActivityLifecycleCallbacks {
    public static long EO = 0;
    public static boolean IlO = false;
    public static long MY;
    private final tV DmF;
    private volatile WeakReference<Activity> bWL;
    private final tV lEW;
    private final AtomicBoolean tV = new AtomicBoolean(false);
    private final RunnableC0121IlO Cc = new RunnableC0121IlO();
    private final vCE vCE = new vCE();
    private final Cc Bc = new Cc();
    private int NV = 0;
    private volatile CopyOnWriteArrayList<WeakReference<com.bytedance.sdk.component.adexpress.IlO>> EV = new CopyOnWriteArrayList<>();
    private HandlerThread rp = null;
    private Handler hp = null;
    private final LinkedList<Activity> ea = new LinkedList<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class Bc implements Runnable {
        private long EO;
        private long MY;
        private boolean tV;

        public Bc(long j, long j3, boolean z2) {
            this.MY = j;
            this.EO = j3;
            this.tV = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.tV) {
                com.bytedance.sdk.openadsdk.ea.EO.IlO().IlO(this.MY / 1000, this.EO / 1000);
            }
            IlO.this.tV();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class Cc implements Runnable {
        public Cc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ApmHelper.isIsInit()) {
                Handler handlerMY = com.bytedance.sdk.openadsdk.core.bWL.MY();
                Message messageObtain = Message.obtain(handlerMY, IlO.this.Cc);
                messageObtain.what = 1001;
                handlerMY.sendMessageDelayed(messageObtain, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class EO extends tV {
        private EO() {
            super();
        }

        @Override // com.bytedance.sdk.openadsdk.utils.IlO.tV, java.lang.Runnable
        public void run() {
            super.run();
            com.bytedance.sdk.openadsdk.utils.Cc.IlO();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.utils.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class RunnableC0121IlO implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            mmj.EO(new com.bytedance.sdk.component.lEW.lEW("reportPvFromBackGround") { // from class: com.bytedance.sdk.openadsdk.utils.IlO.IlO.1
                @Override // java.lang.Runnable
                public void run() {
                    ApmHelper.reportPvFromBackGround();
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY extends tV {
        private MY() {
            super();
        }

        @Override // com.bytedance.sdk.openadsdk.utils.IlO.tV, java.lang.Runnable
        public void run() {
            super.run();
            com.bytedance.sdk.openadsdk.vCE.MY.IlO().MY();
            com.bytedance.sdk.openadsdk.utils.Cc.MY();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class tV implements Runnable {
        private tV() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.tV.IlO.bWL bwlPTq = com.bytedance.sdk.openadsdk.core.settings.hp.aP().PTq();
            if (bwlPTq == null || bwlPTq.IlO() || !com.bytedance.sdk.component.utils.xF.lEW(com.bytedance.sdk.openadsdk.core.cl.IlO())) {
                return;
            }
            com.bytedance.sdk.openadsdk.tV.IlO.tV.IlO(com.bytedance.sdk.openadsdk.core.rp.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class vCE implements Runnable {
        public vCE() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.core.bWL.MY().removeMessages(1001);
            com.bytedance.sdk.openadsdk.core.cl.IlO();
        }
    }

    public IlO() {
        this.lEW = new MY();
        this.DmF = new EO();
        EO();
    }

    private void EO() {
        this.rp = com.bytedance.sdk.component.utils.lEW.IlO("lifecycle", 10);
        this.hp = new Handler(this.rp.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV() {
        com.bytedance.sdk.openadsdk.tV.IlO.IlO.IlO();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.ea.addFirst(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.EV != null && this.EV.size() > 0) {
            for (WeakReference<com.bytedance.sdk.component.adexpress.IlO> weakReference : this.EV) {
                if (weakReference != null && weakReference.get() != null) {
                    try {
                        weakReference.get().IlO(activity);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        if (this.bWL != null && this.bWL.get() == activity) {
            this.bWL = null;
        }
        this.ea.remove(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        int i2 = this.NV - 1;
        this.NV = i2;
        if (i2 < 0) {
            this.NV = 0;
        }
        if (ApmHelper.isIsInit()) {
            IlO(this.Bc);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        IlO(this.vCE);
        if (!IlO) {
            MY = System.currentTimeMillis();
            IlO = true;
        }
        this.bWL = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(final Activity activity) {
        Window window;
        try {
            if (BS.MY() && (window = activity.getWindow()) != null) {
                final View decorView = window.getDecorView();
                decorView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.IlO.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(@NonNull View view) {
                        decorView.removeOnAttachStateChangeListener(this);
                        if (BS.tV(activity)) {
                            BS.IlO(true);
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(@NonNull View view) {
                        decorView.removeOnAttachStateChangeListener(this);
                    }
                });
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.ActivityLifecycle", th);
        }
        this.NV++;
        if (this.tV.get()) {
            this.hp.removeCallbacks(this.DmF);
            this.hp.removeCallbacks(this.lEW);
            IlO(this.DmF);
        }
        this.tV.set(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.NV <= 0) {
            this.tV.set(true);
        }
        if (IlO()) {
            IlO = false;
            com.bytedance.sdk.openadsdk.core.bWL.MY.set(false);
            EO = System.currentTimeMillis();
            this.hp.removeCallbacks(this.DmF);
            this.hp.removeCallbacks(this.lEW);
            IlO(this.lEW);
        }
        IlO(new Bc(MY, EO, IlO()));
    }

    private void IlO(Runnable runnable) {
        if (!this.rp.isAlive()) {
            EO();
        }
        this.hp.postDelayed(runnable, 1000L);
    }

    public boolean MY(com.bytedance.sdk.component.adexpress.IlO ilO) {
        return this.EV.remove(new WeakReference(ilO));
    }

    public Activity MY() {
        if (this.ea.isEmpty()) {
            return null;
        }
        return this.ea.getFirst();
    }

    public void IlO(com.bytedance.sdk.component.adexpress.IlO ilO) {
        this.EV.add(new WeakReference<>(ilO));
    }

    public boolean IlO() {
        return this.tV.get();
    }

    public boolean IlO(boolean z2) {
        Activity activity;
        Window window;
        return (this.bWL == null || (activity = this.bWL.get()) == null || (window = activity.getWindow()) == null) ? z2 : window.getDecorView().hasWindowFocus();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
