package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class YU implements InterfaceC1154Vj {
    @Override // com.instagram.common.viewpoint.core.InterfaceC1154Vj
    public final void AHp(Throwable th, Object obj) {
        if (obj instanceof SM) {
            C1477dL adContext = ((SM) obj).A6e();
            if (adContext != null) {
                adContext.A0Q(th);
                return;
            }
            return;
        }
        if (!(obj instanceof View)) {
            return;
        }
        Context context = ((View) obj).getContext();
        if (!(context instanceof C1477dL)) {
            return;
        }
        ((C1477dL) context).A0Q(th);
    }
}
