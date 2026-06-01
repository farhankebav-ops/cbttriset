package com.ironsource;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: renamed from: com.ironsource.u1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2579u1 implements N1 {

    /* JADX INFO: renamed from: com.ironsource.u1$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InterfaceC2413ka f10325a;

        /* JADX INFO: renamed from: com.ironsource.u1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class C0204a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10326a;

            static {
                int[] iArr = new int[Lifecycle.Event.values().length];
                try {
                    iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Lifecycle.Event.ON_STOP.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f10326a = iArr;
            }
        }

        public a(InterfaceC2413ka listener) {
            kotlin.jvm.internal.k.e(listener, "listener");
            this.f10325a = listener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Lifecycle.Event event, a this$0) {
            kotlin.jvm.internal.k.e(event, "$event");
            kotlin.jvm.internal.k.e(this$0, "this$0");
            int i2 = C0204a.f10326a[event.ordinal()];
            if (i2 == 1) {
                this$0.f10325a.b();
                return;
            }
            if (i2 == 2) {
                this$0.f10325a.c();
            } else if (i2 == 3) {
                this$0.f10325a.d();
            } else {
                if (i2 != 4) {
                    return;
                }
                this$0.f10325a.a();
            }
        }

        public boolean equals(Object obj) {
            InterfaceC2413ka interfaceC2413ka = this.f10325a;
            a aVar = obj instanceof a ? (a) obj : null;
            return kotlin.jvm.internal.k.a(interfaceC2413ka, aVar != null ? aVar.f10325a : null);
        }

        public int hashCode() {
            return this.f10325a.hashCode();
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            kotlin.jvm.internal.k.e(source, "source");
            kotlin.jvm.internal.k.e(event, "event");
            IronSourceThreadManager.postMediationBackgroundTask$default(IronSourceThreadManager.INSTANCE, new ti(0, event, this), 0L, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(InterfaceC2413ka observer) {
        kotlin.jvm.internal.k.e(observer, "$observer");
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(new a(observer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(InterfaceC2413ka observer) {
        kotlin.jvm.internal.k.e(observer, "$observer");
        ProcessLifecycleOwner.Companion.get().getLifecycle().removeObserver(new a(observer));
    }

    @Override // com.ironsource.N1
    public void a(InterfaceC2413ka observer) {
        kotlin.jvm.internal.k.e(observer, "observer");
        IronLog.INTERNAL.verbose("Adding lifecycle event observer");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new si(observer, 0), 0L, 2, null);
    }

    @Override // com.ironsource.N1
    public void b(InterfaceC2413ka observer) {
        kotlin.jvm.internal.k.e(observer, "observer");
        IronLog.INTERNAL.verbose("Removing lifecycle event observer");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new si(observer, 1), 0L, 2, null);
    }
}
