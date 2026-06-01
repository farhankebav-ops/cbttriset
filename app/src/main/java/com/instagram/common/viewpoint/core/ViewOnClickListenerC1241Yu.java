package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1241Yu implements View.OnClickListener {
    public static String[] A03 = {"qTn7FHoQ", "BapBypyKyXgi02nUaikHNoU7eY2sLlHG", "hAbogJy7", "1kKCdLvWKNxoPSiH", "Xjk6qTkQoY8vuVUP", "RHy2P55wnjv0LaFNgRpD8dXF", "4s2GzZI6q8xqZAbl0Skgz3P6Lr2GKXBU", "B9Ul8cdGX1dUct8fF9ORVNarLvr0UfHM"};
    public final /* synthetic */ O6 A00;
    public final /* synthetic */ C1228Yh A01;
    public final /* synthetic */ C1242Yv A02;

    public ViewOnClickListenerC1241Yu(C1242Yv c1242Yv, C1228Yh c1228Yh, O6 o62) {
        this.A02 = c1242Yv;
        this.A01 = c1228Yh;
        this.A00 = o62;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A01.A01();
            this.A02.A02.AEP(this.A00);
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
            String[] strArr = A03;
            if (strArr[3].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[3] = "Wxfvm9MNAlg6MGh9";
            strArr2[4] = "9MWDJcBk5PnwUytH";
        }
    }
}
