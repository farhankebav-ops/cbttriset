package com.instagram.common.viewpoint.core;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1297aQ extends LinearLayout {
    public static byte[] A04;
    public static String[] A05 = {"5HLU", "cJmhtdIbv5Y5xdwCDl3dT8HPvklAUmwI", "4stzzs6gVfUC8wPYX", "7o6tBFGKBnQKcZsvXBJ4ayd9LnRtCNJ", "BSijPHOaulEPVGa4U1fKlqwI", "TamflSlcNH2rcKEIo3f72qWopMk8DENN", "Hhh3HDuTgivrAf4KqreTZK2", "SugScFu"};
    public static final float A06;
    public static final int A07;
    public static final int A08;
    public final TextView A00;
    public final TextView A01;
    public final TextView A02;
    public final boolean A03;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{31, 26, 26, 27, 10, 31, 23, 18, 13};
    }

    static {
        A01();
        A06 = Resources.getSystem().getDisplayMetrics().density;
        A08 = (int) (A06 * 6.0f);
        A07 = (int) (A06 * 8.0f);
    }

    public C1297aQ(C1477dL c1477dL, C0940My c0940My, boolean z2, int i2, int i8, int i9) {
        super(c1477dL);
        setOrientation(1);
        this.A02 = new TextView(c1477dL);
        XP.A0W(this.A02, true, i2);
        this.A02.setEllipsize(TextUtils.TruncateAt.END);
        this.A02.setLineSpacing(A08, 1.0f);
        this.A01 = new TextView(c1477dL);
        this.A00 = new TextView(c1477dL);
        XP.A0W(this.A00, false, i8);
        this.A00.setEllipsize(TextUtils.TruncateAt.END);
        this.A00.setLineSpacing(A08, 1.0f);
        this.A03 = U7.A17(c1477dL);
        int i10 = this.A03 ? -2 : -1;
        addView(this.A02, new LinearLayout.LayoutParams(i10, -2));
        addView(this.A01, new LinearLayout.LayoutParams(i10, -2));
        this.A01.setVisibility(8);
        A03(c0940My, z2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, -2);
        layoutParams.setMargins(0, i9, 0, 0);
        addView(this.A00, layoutParams);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C1297aQ(C1477dL c1477dL, C0940My c0940My, boolean z2, boolean z7, boolean z8) {
        int i2 = z7 ? 18 : 22;
        int i8 = z7 ? 14 : 16;
        int i9 = A07;
        this(c1477dL, c0940My, z2, i2, i8, z8 ? i9 / 2 : i9);
    }

    public final void A02() {
        this.A02.setTypeface(this.A02.getTypeface(), 1);
    }

    public final void A03(C0940My c0940My, boolean z2) {
        this.A02.setTextColor(c0940My.A07(z2));
        this.A01.setTextColor(c0940My.A05(z2));
        this.A00.setTextColor(c0940My.A06(z2));
    }

    public final void A04(String str, String str2, String str3, boolean z2, boolean z7) {
        boolean z8 = !TextUtils.isEmpty(str);
        boolean z9 = !TextUtils.isEmpty(str2);
        TextView textView = this.A02;
        if (!z8) {
            str = str2;
        }
        textView.setText(str);
        if (str3 != null) {
            this.A01.setText(str3);
        }
        TextView textView2 = this.A00;
        if (!z8) {
            str2 = A00(0, 0, 51);
        }
        textView2.setText(str2);
        int i2 = 3;
        String[] strArr = A05;
        if (strArr[6].length() != strArr[4].length()) {
            String[] strArr2 = A05;
            strArr2[3] = "nuTyQWYrKUsKt4wC014k9cpf4UiNlrc";
            strArr2[0] = "l7Wy";
            if (!z8 || !z9) {
                TextView textView3 = this.A02;
                if (A05[1].charAt(4) != 'F') {
                    String[] strArr3 = A05;
                    strArr3[3] = "qWmgL2iM9nfMb7yMq7CVR7HS6Guvx6S";
                    strArr3[0] = "mFhP";
                    if (z2) {
                        i2 = 2;
                    } else if (z7) {
                        i2 = 4;
                    }
                    textView3.setMaxLines(i2);
                    return;
                }
            } else {
                this.A02.setMaxLines(z2 ? 1 : 2);
                this.A00.setMaxLines(z2 ? 1 : z7 ? 3 : 2);
                return;
            }
        }
        throw new RuntimeException();
    }

    public TextView getDescriptionTextView() {
        return this.A00;
    }

    public TextView getTitleTextView() {
        return this.A02;
    }

    public void setAlignment(int i2) {
        if (this.A03) {
            setGravity(i2);
        }
        this.A02.setGravity(i2);
        this.A00.setGravity(i2);
    }

    public void setCTAClickListener(KE ke) {
        ViewOnClickListenerC1301aU viewOnClickListenerC1301aUA03 = AbstractC1302aV.A03(ke, A00(0, 9, 20));
        this.A02.setOnClickListener(viewOnClickListenerC1301aUA03);
        this.A00.setOnClickListener(viewOnClickListenerC1301aUA03);
        this.A01.setOnClickListener(viewOnClickListenerC1301aUA03);
    }

    public void setDescriptionTextSize(int i2) {
        this.A00.setTextSize(i2);
    }

    public void setDescriptionVisibility(int i2) {
        this.A00.setVisibility(i2);
    }

    public void setTitleTextSize(int i2) {
        this.A02.setTextSize(i2);
    }
}
