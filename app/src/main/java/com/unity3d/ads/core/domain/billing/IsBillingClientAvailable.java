package com.unity3d.ads.core.domain.billing;

import q5.j;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IsBillingClientAvailable {
    public final boolean invoke() {
        Object objM;
        try {
            objM = Class.forName("com.android.billingclient.api.BillingClient");
        } catch (Throwable th) {
            objM = q.M(th);
        }
        return !(objM instanceof j);
    }
}
