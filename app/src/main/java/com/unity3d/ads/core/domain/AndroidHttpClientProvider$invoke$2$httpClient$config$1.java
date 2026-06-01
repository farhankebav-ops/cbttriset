package com.unity3d.ads.core.domain;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import e6.p;
import q5.j;
import q5.k;
import q5.x;
import q6.a0;
import r2.q;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.core.domain.AndroidHttpClientProvider$invoke$2$httpClient$config$1", f = "AndroidHttpClientProvider.kt", l = {104}, m = "invokeSuspend")
public final class AndroidHttpClientProvider$invoke$2$httpClient$config$1 extends i implements p {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidHttpClientProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidHttpClientProvider$invoke$2$httpClient$config$1(AndroidHttpClientProvider androidHttpClientProvider, c<? super AndroidHttpClientProvider$invoke$2$httpClient$config$1> cVar) {
        super(2, cVar);
        this.this$0 = androidHttpClientProvider;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        AndroidHttpClientProvider$invoke$2$httpClient$config$1 androidHttpClientProvider$invoke$2$httpClient$config$1 = new AndroidHttpClientProvider$invoke$2$httpClient$config$1(this.this$0, cVar);
        androidHttpClientProvider$invoke$2$httpClient$config$1.L$0 = obj;
        return androidHttpClientProvider$invoke$2$httpClient$config$1;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM;
        Object objMo3222invokegIAlus;
        w5.a aVar = w5.a.f17774a;
        int i2 = this.label;
        int i8 = 1;
        boolean z2 = false;
        boolean z7 = false;
        try {
            if (i2 == 0) {
                q.z0(obj);
                ConfigFileFromLocalStorage configFileFromLocalStorage = this.this$0.configFileFromLocalStorage;
                ConfigFileFromLocalStorage.Params params = new ConfigFileFromLocalStorage.Params(z7 ? 1 : 0, i8, z2 ? 1 : 0);
                this.label = 1;
                objMo3222invokegIAlus = configFileFromLocalStorage.mo3222invokegIAlus(params, this);
                if (objMo3222invokegIAlus == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                objMo3222invokegIAlus = ((k) obj).f13501a;
            }
            objM = new k(objMo3222invokegIAlus);
        } catch (Throwable th) {
            objM = q.M(th);
        }
        boolean z8 = objM instanceof j;
        Object obj2 = objM;
        if (z8) {
            obj2 = null;
        }
        k kVar = (k) obj2;
        if (kVar == null) {
            return null;
        }
        Object obj3 = kVar.f13501a;
        return (Configuration) (obj3 instanceof j ? null : obj3);
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super Configuration> cVar) {
        return ((AndroidHttpClientProvider$invoke$2$httpClient$config$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
