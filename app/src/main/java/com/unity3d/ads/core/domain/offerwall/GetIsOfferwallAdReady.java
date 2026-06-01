package com.unity3d.ads.core.domain.offerwall;

import com.unity3d.ads.core.data.manager.OfferwallManager;
import kotlin.jvm.internal.k;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class GetIsOfferwallAdReady {
    private final OfferwallManager offerwallManager;

    public GetIsOfferwallAdReady(OfferwallManager offerwallManager) {
        k.e(offerwallManager, "offerwallManager");
        this.offerwallManager = offerwallManager;
    }

    public final Object invoke(String str, c<? super Boolean> cVar) {
        return this.offerwallManager.isAdReady(str, cVar);
    }
}
