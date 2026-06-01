package com.unity3d.ads.adplayer;

import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import e6.a;
import java.util.UUID;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.j;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidFullscreenWebViewAdPlayer$adObject$2 extends l implements a {
    final /* synthetic */ AndroidFullscreenWebViewAdPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidFullscreenWebViewAdPlayer$adObject$2(AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer) {
        super(0);
        this.this$0 = androidFullscreenWebViewAdPlayer;
    }

    @Override // e6.a
    public final AdObject invoke() {
        Object objM;
        AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer = this.this$0;
        try {
            AdRepository adRepository = androidFullscreenWebViewAdPlayer.adRepository;
            UUID uuidFromString = UUID.fromString(androidFullscreenWebViewAdPlayer.opportunityId);
            k.d(uuidFromString, "fromString(opportunityId)");
            objM = adRepository.getAd(ProtobufExtensionsKt.toByteString(uuidFromString));
        } catch (Throwable th) {
            objM = q.M(th);
        }
        if (objM instanceof j) {
            objM = null;
        }
        return (AdObject) objM;
    }
}
