package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1207Xm extends LinearLayout {
    public static int A00 = (int) (AbstractC1180Wl.A02 * 56.0f);
    public static int A01 = (int) (AbstractC1180Wl.A02 * 56.0f);

    public abstract void A06();

    public abstract void A07();

    public abstract void A08();

    public abstract void A09(float f4, int i2);

    public abstract void A0A(C0940My c0940My, boolean z2);

    public abstract boolean A0B();

    public abstract int getToolbarActionMode();

    public abstract int getToolbarHeight();

    public abstract InterfaceC1206Xl getToolbarListener();

    public abstract void setAdReportingVisible(boolean z2);

    public abstract void setCTAClickListener(View.OnClickListener onClickListener);

    public abstract void setCTAClickListener(KE ke);

    public abstract void setFullscreen(boolean z2);

    public abstract void setPageDetails(N9 n9, String str, int i2, NF nf);

    public abstract void setPageDetailsVisible(boolean z2);

    public abstract void setProgress(float f4);

    public abstract void setProgressClickListener(View.OnClickListener onClickListener);

    public abstract void setProgressImage(XX xx);

    public abstract void setProgressImmediate(float f4);

    public abstract void setProgressSpinnerInvisible(boolean z2);

    public abstract void setToolbarActionMessage(String str);

    public abstract void setToolbarActionMode(int i2);

    public abstract void setToolbarListener(InterfaceC1206Xl interfaceC1206Xl);

    public AbstractC1207Xm(Context context) {
        super(context);
    }
}
