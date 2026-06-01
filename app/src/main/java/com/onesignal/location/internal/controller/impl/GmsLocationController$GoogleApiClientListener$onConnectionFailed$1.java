package com.onesignal.location.internal.controller.impl;

import com.onesignal.location.internal.controller.impl.GmsLocationController;
import e6.l;
import q5.x;
import r2.q;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.onesignal.location.internal.controller.impl.GmsLocationController$GoogleApiClientListener$onConnectionFailed$1", f = "GmsLocationController.kt", l = {156}, m = "invokeSuspend")
public final class GmsLocationController$GoogleApiClientListener$onConnectionFailed$1 extends i implements l {
    int label;
    final /* synthetic */ GmsLocationController.GoogleApiClientListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GmsLocationController$GoogleApiClientListener$onConnectionFailed$1(GmsLocationController.GoogleApiClientListener googleApiClientListener, c<? super GmsLocationController$GoogleApiClientListener$onConnectionFailed$1> cVar) {
        super(1, cVar);
        this.this$0 = googleApiClientListener;
    }

    @Override // x5.a
    public final c<x> create(c<?> cVar) {
        return new GmsLocationController$GoogleApiClientListener$onConnectionFailed$1(this.this$0, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            q.z0(obj);
            GmsLocationController gmsLocationController = this.this$0._parent;
            this.label = 1;
            if (gmsLocationController.stop(this) == aVar) {
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

    @Override // e6.l
    public final Object invoke(c<? super x> cVar) {
        return ((GmsLocationController$GoogleApiClientListener$onConnectionFailed$1) create(cVar)).invokeSuspend(x.f13520a);
    }
}
