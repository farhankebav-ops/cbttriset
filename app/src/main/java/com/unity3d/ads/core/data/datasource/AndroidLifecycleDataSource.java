package com.unity3d.ads.core.data.datasource;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import r2.q;
import t6.b1;
import t6.d1;
import t6.q0;
import t6.s0;
import t6.x0;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidLifecycleDataSource implements LifecycleDataSource, LifecycleEventObserver {
    private final q0 _appActive;
    private final b1 appActive;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.AndroidLifecycleDataSource$registerAppLifecycle$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.datasource.AndroidLifecycleDataSource$registerAppLifecycle$1", f = "AndroidLifecycleDataSource.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        int label;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return AndroidLifecycleDataSource.this.new AnonymousClass1(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(AndroidLifecycleDataSource.this);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public AndroidLifecycleDataSource() {
        d1 d1VarC = x0.c(Boolean.TRUE);
        this._appActive = d1VarC;
        this.appActive = new s0(d1VarC);
        registerAppLifecycle();
    }

    private final void registerAppLifecycle() {
        c0.u(c0.d(), null, new AnonymousClass1(null), 3);
    }

    @Override // com.unity3d.ads.core.data.datasource.LifecycleDataSource
    public boolean appIsForeground() {
        return ((Boolean) getAppActive().getValue()).booleanValue();
    }

    @Override // com.unity3d.ads.core.data.datasource.LifecycleDataSource
    public b1 getAppActive() {
        return this.appActive;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        k.e(source, "source");
        k.e(event, "event");
        q0 q0Var = this._appActive;
        int i2 = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        boolean zBooleanValue = true;
        if (i2 == 1) {
            zBooleanValue = false;
        } else if (i2 != 2) {
            zBooleanValue = ((Boolean) getAppActive().getValue()).booleanValue();
        }
        Boolean boolValueOf = Boolean.valueOf(zBooleanValue);
        d1 d1Var = (d1) q0Var;
        d1Var.getClass();
        d1Var.i(null, boolValueOf);
    }
}
