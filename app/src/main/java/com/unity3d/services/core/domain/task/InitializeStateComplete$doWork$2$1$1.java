package com.unity3d.services.core.domain.task;

import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$2$1$1", f = "InitializeStateComplete.kt", l = {}, m = "invokeSuspend")
public final class InitializeStateComplete$doWork$2$1$1 extends i implements p {
    /* synthetic */ Object L$0;
    int label;

    public InitializeStateComplete$doWork$2$1$1(c<? super InitializeStateComplete$doWork$2$1$1> cVar) {
        super(2, cVar);
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        InitializeStateComplete$doWork$2$1$1 initializeStateComplete$doWork$2$1$1 = new InitializeStateComplete$doWork$2$1$1(cVar);
        initializeStateComplete$doWork$2$1$1.L$0 = obj;
        return initializeStateComplete$doWork$2$1$1;
    }

    @Override // e6.p
    public final Object invoke(ByteStringStoreOuterClass.ByteStringStore byteStringStore, c<? super ByteStringStoreOuterClass.ByteStringStore> cVar) {
        return ((InitializeStateComplete$doWork$2$1$1) create(byteStringStore, cVar)).invokeSuspend(x.f13520a);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a aVar = a.f17774a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.z0(obj);
        ByteStringStoreOuterClass.ByteStringStore byteStringStoreBuild = ((ByteStringStoreOuterClass.ByteStringStore) this.L$0).toBuilder().clear().build();
        k.d(byteStringStoreBuild, "it.toBuilder().clear().build()");
        return byteStringStoreBuild;
    }
}
