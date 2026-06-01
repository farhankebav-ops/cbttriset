package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class YF implements View.OnClickListener {
    public final /* synthetic */ N9 A00;
    public final /* synthetic */ C1120Ua A01;
    public final /* synthetic */ InterfaceC1208Xn A02;
    public final /* synthetic */ YG A03;
    public final /* synthetic */ String A04;

    public YF(YG yg, C1120Ua c1120Ua, InterfaceC1208Xn interfaceC1208Xn, String str, N9 n9) {
        this.A03 = yg;
        this.A01 = c1120Ua;
        this.A02 = interfaceC1208Xn;
        this.A04 = str;
        this.A00 = n9;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A01.A04(UZ.A0A, null);
            if (this.A03.A01.A0O(this.A03.A02.A02(), true)) {
                this.A02.AAf(this.A04, this.A00);
            } else if (!TextUtils.isEmpty(this.A00.A00())) {
                WN.A0O(new WN(), this.A03.A02, WQ.A00(this.A00.A00()), this.A04);
            }
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
