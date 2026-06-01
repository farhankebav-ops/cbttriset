package com.unity3d.services;

import com.unity3d.ads.core.domain.GetHeaderBiddingToken;
import e6.p;
import q5.f;
import q5.x;
import q6.a0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.UnityAdsSDK$fetchToken$token$1", f = "UnityAdsSDK.kt", l = {170}, m = "invokeSuspend")
public final class UnityAdsSDK$fetchToken$token$1 extends i implements p {
    final /* synthetic */ f $getHeaderBiddingToken$delegate;
    final /* synthetic */ f $tokenNumberProvider$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnityAdsSDK$fetchToken$token$1(f fVar, f fVar2, c<? super UnityAdsSDK$fetchToken$token$1> cVar) {
        super(2, cVar);
        this.$getHeaderBiddingToken$delegate = fVar;
        this.$tokenNumberProvider$delegate = fVar2;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new UnityAdsSDK$fetchToken$token$1(this.$getHeaderBiddingToken$delegate, this.$tokenNumberProvider$delegate, cVar);
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
        GetHeaderBiddingToken getHeaderBiddingTokenFetchToken$lambda$10 = UnityAdsSDK.fetchToken$lambda$10(this.$getHeaderBiddingToken$delegate);
        int iInvoke = UnityAdsSDK.fetchToken$lambda$9(this.$tokenNumberProvider$delegate).invoke();
        this.label = 1;
        Object objInvoke$default = GetHeaderBiddingToken.DefaultImpls.invoke$default(getHeaderBiddingTokenFetchToken$lambda$10, iInvoke, null, this, 2, null);
        return objInvoke$default == aVar ? aVar : objInvoke$default;
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super String> cVar) {
        return ((UnityAdsSDK$fetchToken$token$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
