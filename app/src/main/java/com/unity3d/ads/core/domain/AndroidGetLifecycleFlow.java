package com.unity3d.ads.core.domain;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import e6.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;
import q6.c0;
import r2.q;
import t6.d;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidGetLifecycleFlow {
    private final Context applicationContext;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidGetLifecycleFlow$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidGetLifecycleFlow$invoke$2", f = "AndroidGetLifecycleFlow.kt", l = {64}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidGetLifecycleFlow$invoke$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.a {
            final /* synthetic */ AndroidGetLifecycleFlow$invoke$2$listener$1 $listener;
            final /* synthetic */ AndroidGetLifecycleFlow this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(AndroidGetLifecycleFlow androidGetLifecycleFlow, AndroidGetLifecycleFlow$invoke$2$listener$1 androidGetLifecycleFlow$invoke$2$listener$1) {
                super(0);
                this.this$0 = androidGetLifecycleFlow;
                this.$listener = androidGetLifecycleFlow$invoke$2$listener$1;
            }

            @Override // e6.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m3207invoke();
                return x.f13520a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m3207invoke() {
                ((Application) this.this$0.applicationContext).unregisterActivityLifecycleCallbacks(this.$listener);
            }
        }

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            AnonymousClass2 anonymousClass2 = AndroidGetLifecycleFlow.this.new AnonymousClass2(cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [android.app.Application$ActivityLifecycleCallbacks, com.unity3d.ads.core.domain.AndroidGetLifecycleFlow$invoke$2$listener$1] */
        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                final s6.x xVar = (s6.x) this.L$0;
                ?? r1 = new Application.ActivityLifecycleCallbacks() { // from class: com.unity3d.ads.core.domain.AndroidGetLifecycleFlow$invoke$2$listener$1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        k.e(activity, "activity");
                        s6.x xVar2 = xVar;
                        c0.u(xVar2, null, new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivityCreated$1(xVar2, activity, bundle, null), 3);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        k.e(activity, "activity");
                        s6.x xVar2 = xVar;
                        c0.u(xVar2, null, new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivityDestroyed$1(xVar2, activity, null), 3);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        k.e(activity, "activity");
                        s6.x xVar2 = xVar;
                        c0.u(xVar2, null, new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivityPaused$1(xVar2, activity, null), 3);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        k.e(activity, "activity");
                        s6.x xVar2 = xVar;
                        c0.u(xVar2, null, new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivityResumed$1(xVar2, activity, null), 3);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        k.e(activity, "activity");
                        k.e(bundle, "bundle");
                        s6.x xVar2 = xVar;
                        c0.u(xVar2, null, new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivitySaveInstanceState$1(xVar2, activity, bundle, null), 3);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                        k.e(activity, "activity");
                        s6.x xVar2 = xVar;
                        c0.u(xVar2, null, new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivityStarted$1(xVar2, activity, null), 3);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                        k.e(activity, "activity");
                        s6.x xVar2 = xVar;
                        c0.u(xVar2, null, new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivityStopped$1(xVar2, activity, null), 3);
                    }
                };
                ((Application) AndroidGetLifecycleFlow.this.applicationContext).registerActivityLifecycleCallbacks(r1);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(AndroidGetLifecycleFlow.this, r1);
                this.label = 1;
                if (q.m(xVar, anonymousClass1, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(s6.x xVar, c<? super x> cVar) {
            return ((AnonymousClass2) create(xVar, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public AndroidGetLifecycleFlow(Context applicationContext) {
        k.e(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
    }

    public final t6.e invoke() {
        if (!(this.applicationContext instanceof Application)) {
            throw new IllegalArgumentException("Application context is required");
        }
        return new d(new AnonymousClass2(null), v5.i.f17610a, -2, s6.a.f13718a);
    }
}
