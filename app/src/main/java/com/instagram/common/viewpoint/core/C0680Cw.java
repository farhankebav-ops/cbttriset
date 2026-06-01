package com.instagram.common.viewpoint.core;

import android.R;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.GravityCompat;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0680Cw extends RelativeLayout implements InterfaceC1494dc {
    public static byte[] A0B;
    public static String[] A0C = {"QrML4Ecz92sfYCeCtaSnFCosFmipGlTz", "VhmrcYjsqpOA7Iy", "ZK9HRS350jRidth", "ZjYoflRzQYTDfI0m0JAvuVl9vp7GlkSu", "MmC", "ZvQ3uBw3DQ7M1xesozkO3pU9", "XD5i8EmzP8U96tjWoOsk6YaJBmNCgDM7", "cjtQcAKtxYCLU"};
    public static final int A0D;
    public static final int A0E;
    public int A00;
    public int A01;
    public ObjectAnimator A02;
    public AbstractC1100Tf A03;
    public AbstractC1100Tf A04;
    public AbstractC1100Tf A05;
    public AbstractC1100Tf A06;
    public E1 A07;
    public boolean A08;
    public boolean A09;
    public final ProgressBar A0A;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 83);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        String[] strArr = A0C;
        if (strArr[0].charAt(7) != strArr[6].charAt(7)) {
            throw new RuntimeException();
        }
        A0C[4] = "F3xM2b87YXaGRbor1WnSFNsn05JfW";
        A0B = new byte[]{-5, -3, -6, -14, -3, -16, -2, -2};
    }

    static {
        A03();
        A0D = (int) (AbstractC1180Wl.A02 * 8.0f);
        A0E = (int) (AbstractC1180Wl.A02 * 6.0f);
    }

    public C0680Cw(C1477dL c1477dL, int i2) {
        this(c1477dL, A0E, -12549889, 0, i2);
    }

    public C0680Cw(C1477dL c1477dL, int i2, int i8) {
        this(c1477dL, i8, -12549889, 0, i2);
    }

    public C0680Cw(C1477dL c1477dL, int i2, int i8, int i9, int i10) {
        super(c1477dL);
        this.A08 = false;
        this.A01 = -1;
        this.A09 = true;
        this.A06 = new DM() { // from class: com.facebook.ads.redexgen.X.2P
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C3Q c3q) {
                if (this.A00.A07 != null) {
                    this.A00.A09(true);
                }
            }
        };
        this.A04 = new DR() { // from class: com.facebook.ads.redexgen.X.2N
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C3Y c3y) {
                this.A00.A02();
            }
        };
        this.A05 = new DP() { // from class: com.facebook.ads.redexgen.X.2K
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(DQ dq) {
                if (this.A00.A07 != null) {
                    this.A00.A09(true);
                }
            }
        };
        this.A03 = new DX() { // from class: com.facebook.ads.redexgen.X.2G
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C04433d c04433d) {
                if (this.A00.A07 != null && this.A00.A09) {
                    this.A00.A06();
                }
            }
        };
        this.A00 = i10;
        this.A0A = new ProgressBar(c1477dL, null, R.attr.progressBarStyleHorizontal);
        A08(i8, i9, false);
        this.A0A.setMax(10000);
        addView(this.A0A, new RelativeLayout.LayoutParams(-1, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        if (this.A02 != null) {
            this.A02.cancel();
            this.A02.setTarget(null);
            this.A02 = null;
            this.A0A.clearAnimation();
        }
    }

    public final void A06() {
        A02();
        this.A02 = ObjectAnimator.ofInt(this.A0A, A01(0, 8, 56), 0, 0);
        this.A02.setDuration(0L);
        this.A02.setInterpolator(new LinearInterpolator());
        this.A02.start();
        this.A01 = -1;
    }

    public final void A07(int i2) {
        if (this.A08) {
            return;
        }
        A02();
        int i8 = this.A00;
        int i9 = i8 > 0 ? (i2 * 10000) / i8 : 0;
        int i10 = this.A01;
        int progress = A0C[3].charAt(25);
        if (progress != 112) {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[0] = "EPor81PzILPcuU6FixKr7Fru1uzRlGJl";
        strArr[6] = "FnG13n1zUgJ6jZbSKNpX0gvuGbObv9dX";
        if (i10 >= i9 || i8 <= i2) {
            int progress2 = this.A00;
            if (progress2 != -1) {
                int duration = this.A0A.getProgress();
                if (duration < 10000) {
                    this.A0A.setProgress(10000);
                    return;
                }
                return;
            }
            return;
        }
        ProgressBar progressBar = this.A0A;
        int duration2 = this.A01;
        this.A02 = ObjectAnimator.ofInt(progressBar, A01(0, 8, 56), duration2, i9);
        ObjectAnimator objectAnimator = this.A02;
        int duration3 = Math.min(250, i8 - i2);
        objectAnimator.setDuration(duration3);
        this.A02.setInterpolator(new LinearInterpolator());
        this.A02.start();
        this.A01 = i9;
    }

    public final void A08(int i2, int i8, boolean z2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i8);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(i2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        if (z2) {
            gradientDrawable.setCornerRadius(40.0f);
            gradientDrawable2.setCornerRadius(40.0f);
            gradientDrawable3.setCornerRadius(40.0f);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable3, new ScaleDrawable(gradientDrawable2, GravityCompat.START, 1.0f, -1.0f)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        this.A0A.setProgressDrawable(layerDrawable);
    }

    public final void A09(boolean z2) {
        if (this.A07 == null) {
            return;
        }
        A02();
        int currentPositionInMillis = this.A07.getCurrentPositionInMillis();
        int position = this.A00;
        int duration = position == -1 ? this.A07.getDuration() : this.A00;
        int i2 = duration > 0 ? (currentPositionInMillis * 10000) / duration : 0;
        int position2 = this.A01;
        if (position2 >= i2 || duration <= currentPositionInMillis) {
            int position3 = this.A00;
            if (position3 != -1) {
                ProgressBar progressBar = this.A0A;
                String[] strArr = A0C;
                String str = strArr[1];
                String str2 = strArr[2];
                int duration2 = str.length();
                int position4 = str2.length();
                if (duration2 != position4) {
                    throw new RuntimeException();
                }
                A0C[4] = "qF0L9nDi3kEsuJUK3R2iV2qYkdzV6";
                int duration3 = progressBar.getProgress();
                if (duration3 < 10000) {
                    this.A0A.setProgress(10000);
                    return;
                }
                return;
            }
            return;
        }
        if (z2) {
            ProgressBar progressBar2 = this.A0A;
            int position5 = this.A01;
            this.A02 = ObjectAnimator.ofInt(progressBar2, A01(0, 8, 56), position5, i2);
            ObjectAnimator objectAnimator = this.A02;
            int position6 = Math.min(250, duration - currentPositionInMillis);
            objectAnimator.setDuration(position6);
            this.A02.setInterpolator(new LinearInterpolator());
            this.A02.start();
        } else {
            ProgressBar progressBar3 = this.A0A;
            int duration4 = A0C[7].length();
            if (duration4 != 13) {
                progressBar3.setProgress(i2);
            } else {
                A0C[5] = "fU59jt";
                progressBar3.setProgress(i2);
            }
        }
        this.A01 = i2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1494dc
    public final void AAm(E1 e12) {
        this.A07 = e12;
        e12.getEventBus().A03(this.A04, this.A05, this.A06, this.A03);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1494dc
    public final void AJk(E1 e12) {
        e12.getEventBus().A04(this.A06, this.A05, this.A04, this.A03);
        this.A07 = null;
    }

    public int getCustomDuration() {
        return this.A00;
    }

    public void setCustomDuration(int i2) {
        this.A00 = i2;
    }

    public void setShouldClearAnimationWhenVideoCompleted(boolean z2) {
        this.A09 = z2;
    }
}
