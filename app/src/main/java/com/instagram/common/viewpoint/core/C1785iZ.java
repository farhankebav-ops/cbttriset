package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1785iZ implements InterfaceC1377bi {
    public final /* synthetic */ C7L A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.InterfaceC1377bi
    public final void AAe() {
        String strA00 = this.A00.A03.A23().A00();
        if (TextUtils.isEmpty(strA00)) {
            return;
        }
        WN.A0O(new WN(), this.A00.A04, WQ.A00(strA00), this.A00.A7G());
    }

    public C1785iZ(C7L c7l) {
        this.A00 = c7l;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1377bi
    public final void AD8(C5G c5g) {
        new Handler(Looper.getMainLooper()).postDelayed(new C1787ib(this, c5g), 1L);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1377bi
    public final void ADO() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1377bi
    public final void AFS(View view, MotionEvent motionEvent) {
    }
}
