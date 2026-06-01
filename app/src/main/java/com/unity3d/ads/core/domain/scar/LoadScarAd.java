package com.unity3d.ads.core.domain.scar;

import com.unity3d.ads.core.data.manager.ScarManager;
import kotlin.jvm.internal.k;
import q5.x;
import v5.c;
import w5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LoadScarAd {
    private final ScarManager scarManager;

    public LoadScarAd(ScarManager scarManager) {
        k.e(scarManager, "scarManager");
        this.scarManager = scarManager;
    }

    public final Object invoke(String str, String str2, String str3, String str4, String str5, int i2, c<? super x> cVar) {
        Object objLoadAd;
        boolean zA = k.a(str, "banner");
        x xVar = x.f13520a;
        return (!zA && (objLoadAd = this.scarManager.loadAd(str, str2, str4, str3, str5, i2, cVar)) == a.f17774a) ? objLoadAd : xVar;
    }
}
