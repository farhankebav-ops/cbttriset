package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import java.util.Locale;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class Z9 {
    public static ImageView A00(final C1477dL c1477dL, final C1120Ua c1120Ua, final AbstractC1752hy abstractC1752hy, final InterfaceC1208Xn interfaceC1208Xn, final Z5 z52, Handler handler, Z6 z62) {
        c1477dL.A0F().AAv(z52.name().toLowerCase(Locale.US));
        return abstractC1752hy.A2F() ? new Z4(c1477dL, handler, z62, abstractC1752hy.A1y(), new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.Z7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1477dL c1477dL2 = c1477dL;
                C1120Ua c1120Ua2 = c1120Ua;
                InterfaceC1208Xn interfaceC1208Xn2 = interfaceC1208Xn;
                Z5 z53 = z52;
                AbstractC1752hy abstractC1752hy2 = abstractC1752hy;
                Z9.A04(c1477dL2, c1120Ua2, interfaceC1208Xn2, z53, abstractC1752hy2.A25(), abstractC1752hy2.A23());
            }
        }) : new ZA(c1477dL, new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.Z8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1477dL c1477dL2 = c1477dL;
                C1120Ua c1120Ua2 = c1120Ua;
                InterfaceC1208Xn interfaceC1208Xn2 = interfaceC1208Xn;
                Z5 z53 = z52;
                AbstractC1752hy abstractC1752hy2 = abstractC1752hy;
                Z9.A04(c1477dL2, c1120Ua2, interfaceC1208Xn2, z53, abstractC1752hy2.A25(), abstractC1752hy2.A23());
            }
        });
    }

    public static ImageView A01(C1477dL c1477dL, C1120Ua c1120Ua, AbstractC1752hy abstractC1752hy, Z5 z52, InterfaceC1208Xn interfaceC1208Xn, Handler handler) {
        return A00(c1477dL, c1120Ua, abstractC1752hy, interfaceC1208Xn, z52, handler, Z6.A03);
    }

    public static void A04(C1477dL c1477dL, C1120Ua c1120Ua, InterfaceC1208Xn interfaceC1208Xn, Z5 z52, String str, N9 n9) {
        if (c1120Ua != null) {
            c1120Ua.A04(UZ.A0A, null);
        }
        c1477dL.A0F().AAu(z52.name().toLowerCase(Locale.US));
        if (O3.A00(c1477dL.A02()).A0O(c1477dL.A02(), true)) {
            interfaceC1208Xn.AAf(str, n9);
        } else {
            if (TextUtils.isEmpty(n9.A00())) {
                return;
            }
            WN.A0O(new WN(), c1477dL, WQ.A00(n9.A00()), str);
        }
    }
}
