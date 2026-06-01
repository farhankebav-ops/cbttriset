package com.instagram.common.viewpoint.core;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2p, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C04292p extends AbstractC0684Da {
    public static String[] A04 = {"hk0dnqphYZ0B2FA2HHbeoaEOUC9cHUBv", "tTD1hmxYdA3U5n9t8Z20NsAIS", "BfpeWRttIDT9n", "BdF5VvNpfNEd8dAFz8yBB3tju8j2QPKu", "opIRFI8OjkHX6xnIsWRzCqWD0", "Ob0oYr4gU4dgC4EVWukqT8XlG8BtSCcB", "HPuRIIJ62FmEL4YF0ip1f4WrSa12U9bK", "7SB"};
    public final ImageView A00;
    public final C1477dL A01;
    public final AbstractC1100Tf<C04433d> A02;
    public final AbstractC1100Tf<DQ> A03;

    public C04292p(C1477dL c1477dL) {
        this(c1477dL, false);
    }

    public C04292p(C1477dL c1477dL, boolean z2) {
        ImageView.ScaleType scaleType;
        int color;
        super(c1477dL);
        this.A03 = new C0683Cz(this);
        this.A02 = new C0682Cy(this);
        this.A01 = c1477dL;
        this.A00 = new ImageView(c1477dL);
        if (!z2) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
            color = ViewCompat.MEASURED_STATE_MASK;
        } else {
            scaleType = ImageView.ScaleType.FIT_START;
            color = 0;
        }
        this.A00.setScaleType(scaleType);
        XP.A0K(this.A00, color);
        this.A00.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0684Da
    public final void A07() {
        super.A07();
        if (getVideoView() != null) {
            C1099Te<AbstractC1100Tf, C1098Td> eventBus = getVideoView().getEventBus();
            AbstractC1100Tf[] abstractC1100TfArr = new AbstractC1100Tf[2];
            String[] strArr = A04;
            if (strArr[3].charAt(25) != strArr[5].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[7] = "Nqq";
            strArr2[2] = "4efeQvUmAeHBj";
            abstractC1100TfArr[0] = this.A03;
            abstractC1100TfArr[1] = this.A02;
            eventBus.A03(abstractC1100TfArr);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0684Da
    public final void A08() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A02, this.A03);
        }
        super.A08();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        this.A00.layout(0, 0, i9 - i2, i10 - i8);
    }

    public void setImage(String str) {
        setImage(str, null);
    }

    public void setImage(String str, InterfaceC1261Zo interfaceC1261Zo) {
        if (str == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        KZ downloadImageTask = new KZ(this.A00, this.A01).A04();
        if (interfaceC1261Zo != null) {
            downloadImageTask.A06(interfaceC1261Zo);
        }
        downloadImageTask.A07(str);
    }
}
