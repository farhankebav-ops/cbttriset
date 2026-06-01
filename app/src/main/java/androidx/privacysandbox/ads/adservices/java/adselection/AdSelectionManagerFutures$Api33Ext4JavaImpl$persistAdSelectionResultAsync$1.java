package androidx.privacysandbox.ads.adservices.java.adselection;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome;
import androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1", f = "AdSelectionManagerFutures.kt", l = {373}, m = "invokeSuspend")
public final class AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1 extends i implements p {
    final /* synthetic */ PersistAdSelectionResultRequest $persistAdSelectionResultRequest;
    int label;
    final /* synthetic */ AdSelectionManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1(AdSelectionManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, PersistAdSelectionResultRequest persistAdSelectionResultRequest, c<? super AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1> cVar) {
        super(2, cVar);
        this.this$0 = api33Ext4JavaImpl;
        this.$persistAdSelectionResultRequest = persistAdSelectionResultRequest;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1(this.this$0, this.$persistAdSelectionResultRequest, cVar);
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
        AdSelectionManager adSelectionManager = this.this$0.mAdSelectionManager;
        k.b(adSelectionManager);
        PersistAdSelectionResultRequest persistAdSelectionResultRequest = this.$persistAdSelectionResultRequest;
        this.label = 1;
        Object objPersistAdSelectionResult = adSelectionManager.persistAdSelectionResult(persistAdSelectionResultRequest, this);
        return objPersistAdSelectionResult == aVar ? aVar : objPersistAdSelectionResult;
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super AdSelectionOutcome> cVar) {
        return ((AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
