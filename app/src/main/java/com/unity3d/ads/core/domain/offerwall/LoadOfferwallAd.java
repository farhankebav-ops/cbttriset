package com.unity3d.ads.core.domain.offerwall;

import com.unity3d.ads.core.data.manager.OfferwallManager;
import kotlin.jvm.internal.k;
import q5.x;
import v5.c;
import w5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LoadOfferwallAd {
    private final OfferwallManager offerwallManager;

    public LoadOfferwallAd(OfferwallManager offerwallManager) {
        k.e(offerwallManager, "offerwallManager");
        this.offerwallManager = offerwallManager;
    }

    public final Object invoke(String str, c<? super x> cVar) {
        Object objLoadAd = this.offerwallManager.loadAd(str, cVar);
        return objLoadAd == a.f17774a ? objLoadAd : x.f13520a;
    }
}
