package com.instagram.common.viewpoint.core;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.da, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1492da extends ContentObserver {
    public final C0686Dc A00;

    public C1492da(Handler handler, C0686Dc c0686Dc) {
        super(handler);
        this.A00 = c0686Dc;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return false;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z2) {
        this.A00.A0f();
    }
}
