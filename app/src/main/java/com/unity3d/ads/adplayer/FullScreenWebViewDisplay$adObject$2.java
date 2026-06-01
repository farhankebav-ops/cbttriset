package com.unity3d.ads.adplayer;

import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import e6.a;
import java.util.UUID;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import n7.b;
import q5.f;
import q5.g;
import q5.j;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FullScreenWebViewDisplay$adObject$2 extends l implements a {
    final /* synthetic */ FullScreenWebViewDisplay this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenWebViewDisplay$adObject$2(FullScreenWebViewDisplay fullScreenWebViewDisplay) {
        super(0);
        this.this$0 = fullScreenWebViewDisplay;
    }

    private static final AdRepository invoke$lambda$0(f fVar) {
        return (AdRepository) fVar.getValue();
    }

    @Override // e6.a
    public final AdObject invoke() {
        Object objM;
        f fVarB = b.B(g.f13496c, new FullScreenWebViewDisplay$adObject$2$invoke$$inlined$inject$default$1(this.this$0, ""));
        FullScreenWebViewDisplay fullScreenWebViewDisplay = this.this$0;
        try {
            AdRepository adRepositoryInvoke$lambda$0 = invoke$lambda$0(fVarB);
            UUID uuidFromString = UUID.fromString(fullScreenWebViewDisplay.opportunityId);
            k.d(uuidFromString, "fromString(opportunityId)");
            objM = adRepositoryInvoke$lambda$0.getAd(ProtobufExtensionsKt.toByteString(uuidFromString));
        } catch (Throwable th) {
            objM = q.M(th);
        }
        if (objM instanceof j) {
            objM = null;
        }
        return (AdObject) objM;
    }
}
