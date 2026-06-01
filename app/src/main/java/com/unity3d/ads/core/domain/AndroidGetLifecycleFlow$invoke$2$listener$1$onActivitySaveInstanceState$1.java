package com.unity3d.ads.core.domain;

import android.app.Activity;
import android.os.Bundle;
import com.unity3d.ads.core.domain.LifecycleEvent;
import e6.p;
import java.lang.ref.WeakReference;
import q6.a0;
import r2.q;
import s6.w;
import s6.x;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.core.domain.AndroidGetLifecycleFlow$invoke$2$listener$1$onActivitySaveInstanceState$1", f = "AndroidGetLifecycleFlow.kt", l = {54}, m = "invokeSuspend")
public final class AndroidGetLifecycleFlow$invoke$2$listener$1$onActivitySaveInstanceState$1 extends i implements p {
    final /* synthetic */ x $$this$channelFlow;
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Bundle $bundle;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidGetLifecycleFlow$invoke$2$listener$1$onActivitySaveInstanceState$1(x xVar, Activity activity, Bundle bundle, c<? super AndroidGetLifecycleFlow$invoke$2$listener$1$onActivitySaveInstanceState$1> cVar) {
        super(2, cVar);
        this.$$this$channelFlow = xVar;
        this.$activity = activity;
        this.$bundle = bundle;
    }

    @Override // x5.a
    public final c<q5.x> create(Object obj, c<?> cVar) {
        return new AndroidGetLifecycleFlow$invoke$2$listener$1$onActivitySaveInstanceState$1(this.$$this$channelFlow, this.$activity, this.$bundle, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            q.z0(obj);
            x xVar = this.$$this$channelFlow;
            LifecycleEvent.SaveInstanceState saveInstanceState = new LifecycleEvent.SaveInstanceState(new WeakReference(this.$activity), this.$bundle);
            this.label = 1;
            if (((w) xVar).f13759d.c(saveInstanceState, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
        }
        return q5.x.f13520a;
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super q5.x> cVar) {
        return ((AndroidGetLifecycleFlow$invoke$2$listener$1$onActivitySaveInstanceState$1) create(a0Var, cVar)).invokeSuspend(q5.x.f13520a);
    }
}
