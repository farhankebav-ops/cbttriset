package com.unity3d.ads.core.data.repository;

import e6.p;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import q5.x;
import q6.a0;
import r2.q;
import t6.x0;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.core.data.repository.AndroidSessionRepository$nativeConfiguration$1", f = "AndroidSessionRepository.kt", l = {177}, m = "invokeSuspend")
public final class AndroidSessionRepository$nativeConfiguration$1 extends i implements p {
    int label;
    final /* synthetic */ AndroidSessionRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidSessionRepository$nativeConfiguration$1(AndroidSessionRepository androidSessionRepository, c<? super AndroidSessionRepository$nativeConfiguration$1> cVar) {
        super(2, cVar);
        this.this$0 = androidSessionRepository;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new AndroidSessionRepository$nativeConfiguration$1(this.this$0, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a aVar = a.f17774a;
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            return obj;
        }
        q.z0(obj);
        t6.e eVar = this.this$0.persistedNativeConfiguration;
        this.label = 1;
        Object objL = x0.l(eVar, this);
        return objL == aVar ? aVar : objL;
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super NativeConfigurationOuterClass.NativeConfiguration> cVar) {
        return ((AndroidSessionRepository$nativeConfiguration$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
