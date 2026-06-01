package com.unity3d.ads.core.domain;

import android.content.Context;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.core.RefactoredOkHttp3Client;
import e6.p;
import okhttp3.OkHttpClient;
import q5.x;
import q6.a0;
import r2.q;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.core.domain.AndroidHttpClientProvider$invoke$2$httpClient$client$1", f = "AndroidHttpClientProvider.kt", l = {83}, m = "invokeSuspend")
public final class AndroidHttpClientProvider$invoke$2$httpClient$client$1 extends i implements p {
    final /* synthetic */ boolean $usingRefactoredGatewayClient;
    int label;
    final /* synthetic */ AndroidHttpClientProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidHttpClientProvider$invoke$2$httpClient$client$1(boolean z2, AndroidHttpClientProvider androidHttpClientProvider, c<? super AndroidHttpClientProvider$invoke$2$httpClient$client$1> cVar) {
        super(2, cVar);
        this.$usingRefactoredGatewayClient = z2;
        this.this$0 = androidHttpClientProvider;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new AndroidHttpClientProvider$invoke$2$httpClient$client$1(this.$usingRefactoredGatewayClient, this.this$0, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            q.z0(obj);
            if (this.$usingRefactoredGatewayClient) {
                return new RefactoredOkHttp3Client(this.this$0.dispatchers, new OkHttpClient());
            }
            AndroidHttpClientProvider androidHttpClientProvider = this.this$0;
            Context context = androidHttpClientProvider.context;
            ISDKDispatchers iSDKDispatchers = this.this$0.dispatchers;
            this.label = 1;
            obj = androidHttpClientProvider.buildNetworkClient(context, iSDKDispatchers, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
        }
        return (HttpClient) obj;
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super HttpClient> cVar) {
        return ((AndroidHttpClientProvider$invoke$2$httpClient$client$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
