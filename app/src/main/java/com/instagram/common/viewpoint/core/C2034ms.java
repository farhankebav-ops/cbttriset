package com.instagram.common.viewpoint.core;

import android.os.Looper;
import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ms, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2034ms implements C9U {
    @Override // com.instagram.common.viewpoint.core.C9U
    public final /* synthetic */ C9T AGJ(C9P c9p, C2154or c2154or) {
        return C9R.A00(this, c9p, c2154or);
    }

    @Override // com.instagram.common.viewpoint.core.C9U
    public final /* synthetic */ void AGK() {
    }

    @Override // com.instagram.common.viewpoint.core.C9U
    public final C9G A34(C9P c9p, C2154or c2154or) {
        if (c2154or.A0O == null) {
            return null;
        }
        final int i2 = 1;
        return new C2032mq(new C9E(new Exception(i2) { // from class: com.facebook.ads.redexgen.X.9z
            public final int A00;

            {
                this.A00 = i2;
            }
        }, AdError.MEDIAVIEW_MISSING_ERROR_CODE));
    }

    @Override // com.instagram.common.viewpoint.core.C9U
    public final int A7O(C2154or c2154or) {
        return c2154or.A0O != null ? 1 : 0;
    }

    @Override // com.instagram.common.viewpoint.core.C9U
    public final void AIu(Looper looper, C05567m c05567m) {
    }
}
