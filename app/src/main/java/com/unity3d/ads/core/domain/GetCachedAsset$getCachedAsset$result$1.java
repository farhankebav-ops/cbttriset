package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.repository.CacheRepository;
import e6.p;
import q5.x;
import q6.a0;
import r2.q;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.core.domain.GetCachedAsset$getCachedAsset$result$1", f = "GetCachedAsset.kt", l = {39}, m = "invokeSuspend")
public final class GetCachedAsset$getCachedAsset$result$1 extends i implements p {
    final /* synthetic */ String $fileName;
    int label;
    final /* synthetic */ GetCachedAsset this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetCachedAsset$getCachedAsset$result$1(GetCachedAsset getCachedAsset, String str, c<? super GetCachedAsset$getCachedAsset$result$1> cVar) {
        super(2, cVar);
        this.this$0 = getCachedAsset;
        this.$fileName = str;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new GetCachedAsset$getCachedAsset$result$1(this.this$0, this.$fileName, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            return obj;
        }
        q.z0(obj);
        CacheRepository cacheRepository = this.this$0.cacheRepository;
        String str = this.$fileName;
        this.label = 1;
        Object objRetrieveFile = cacheRepository.retrieveFile(str, this);
        return objRetrieveFile == aVar ? aVar : objRetrieveFile;
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super CacheResult> cVar) {
        return ((GetCachedAsset$getCachedAsset$result$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
