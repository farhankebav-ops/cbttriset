package androidx.privacysandbox.ads.adservices.adselection;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion", f = "AdSelectionManagerImplCommon.kt", l = {231}, m = "getAdSelectionData")
public final class AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1 extends c {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdSelectionManagerImplCommon.Ext10Impl.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1(AdSelectionManagerImplCommon.Ext10Impl.Companion companion, v5.c<? super AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1> cVar) {
        super(cVar);
        this.this$0 = companion;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAdSelectionData(null, null, this);
    }
}
