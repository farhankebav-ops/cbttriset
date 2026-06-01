package com.instagram.common.viewpoint.core;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class a7 extends View {
    public static byte[] A0D;
    public static String[] A0E = {"6CPTD", "fXgP9xh", "ib2e4in6DthWL0Q8yAPc5xfntbPyX", "G2AJONpeKHBBwjt4Sz8dsS7zReejT0Uv", "ehyeN", "WBwJl6", "LCSmLTdRFMhZrs9WeNkLEUS62n49AyUU", "TtqxlXaAwuHndX0DwnqxXM3nrIfVxGxz"};
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public float A00;
    public int A01;
    public ObjectAnimator A02;
    public Bitmap A03;
    public boolean A04;
    public final float A05;
    public final float A06;
    public final Paint A07;
    public final Paint A08;
    public final Paint A09;
    public final Paint A0A;
    public final RectF A0B;
    public final RectF A0C;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0E;
            if (strArr[5].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A0E[2] = "SahMn6yRzkp23Kmva3Z5gQPUDBgZr";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
            i10++;
        }
    }

    public static void A01() {
        A0D = new byte[]{96, 98, 127, 119, 98, 117, 99, 99};
    }

    static {
        A01();
        A0F = (int) (AbstractC1180Wl.A02 * 5.0f);
        A0G = (int) (AbstractC1180Wl.A02 * 4.0f);
        A0H = (int) (AbstractC1180Wl.A02 * 10.0f);
    }

    public a7(C1477dL c1477dL, boolean z2) {
        super(c1477dL);
        this.A06 = Resources.getSystem().getDisplayMetrics().density * 3.0f;
        this.A05 = Resources.getSystem().getDisplayMetrics().density * 2.0f;
        this.A00 = 0.0f;
        this.A02 = null;
        this.A01 = -1;
        this.A04 = z2;
        this.A0B = new RectF();
        this.A0C = new RectF();
        this.A07 = new Paint(1);
        this.A07.setStyle(Paint.Style.STROKE);
        this.A07.setStrokeWidth(!this.A04 ? this.A06 : this.A05);
        this.A08 = new Paint(1);
        this.A08.setStyle(Paint.Style.STROKE);
        this.A08.setStrokeWidth(!this.A04 ? this.A06 : this.A05);
        this.A09 = new Paint(1);
        this.A0A = new Paint();
        this.A0A.setAntiAlias(true);
        this.A0A.setColor(-1);
        this.A0A.setTextSize(A0H);
    }

    public final void A02(float f4, int i2) {
        this.A01 = i2;
        setProgressWithAnimation(f4);
    }

    public final void A03(int i2, int i8, int i9) {
        this.A07.setColor(i2);
        this.A08.setColor(i8);
        this.A09.setColorFilter(new PorterDuffColorFilter(OP.A02(i8, i9), PorterDuff.Mode.SRC_ATOP));
    }

    @Override // android.view.View
    public final void clearAnimation() {
        if (this.A02 != null) {
            this.A02.cancel();
            this.A02 = null;
        }
    }

    public float getProgress() {
        return this.A00;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.A0B, 0.0f, 360.0f, false, this.A07);
        canvas.drawArc(this.A0B, -90.0f, ((100.0f - this.A00) * 360.0f) / 100.0f, false, this.A08);
        if (this.A03 != null) {
            canvas.drawBitmap(this.A03, new Rect(0, 0, this.A03.getWidth(), this.A03.getHeight()), this.A0C, this.A09);
        }
        if (this.A01 >= 0) {
            String str = this.A01 + A00(0, 0, 8);
            float f4 = this.A0B.left;
            float f8 = this.A0B.right;
            float sweepAngle = this.A0B.left;
            float f9 = f4 + ((f8 - sweepAngle) / 2.0f);
            float sweepAngle2 = this.A0A.measureText(str);
            float f10 = f9 - (sweepAngle2 / 2.0f);
            float f11 = this.A0B.top;
            float sweepAngle3 = A0G;
            float f12 = f11 + sweepAngle3;
            float f13 = this.A0B.bottom;
            float sweepAngle4 = this.A0B.top;
            canvas.drawText(str, f10, f12 + ((f13 - sweepAngle4) / 2.0f), this.A0A);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i8) {
        int iMin = Math.min(getDefaultSize(getSuggestedMinimumHeight(), i8), getDefaultSize(getSuggestedMinimumWidth(), i2));
        setMeasuredDimension(iMin, iMin);
        float f4 = !this.A04 ? this.A06 : this.A05;
        RectF rectF = this.A0B;
        int min = getPaddingLeft();
        float f8 = (f4 / 2.0f) + 0.0f + min;
        int min2 = getPaddingTop();
        float f9 = (f4 / 2.0f) + 0.0f + min2;
        int min3 = getPaddingRight();
        float f10 = (iMin - (f4 / 2.0f)) - min3;
        float strokeWidth = iMin;
        int min4 = getPaddingBottom();
        rectF.set(f8, f9, f10, (strokeWidth - (f4 / 2.0f)) - min4);
        int i9 = !this.A04 ? A0F : A0G;
        RectF rectF2 = this.A0C;
        float f11 = this.A0B.left + i9;
        float f12 = this.A0B.top + i9;
        float f13 = this.A0B.right - i9;
        float strokeWidth2 = this.A0B.bottom;
        rectF2.set(f11, f12, f13, strokeWidth2 - i9);
    }

    public void setImage(XX xx) {
        this.A03 = xx == null ? null : XY.A01(xx);
        invalidate();
    }

    public void setProgress(float f4) {
        this.A00 = Math.min(f4, 100.0f);
        postInvalidate();
    }

    public void setProgressWithAnimation(float f4) {
        this.A02 = ObjectAnimator.ofFloat(this, A00(0, 8, 107), f4);
        this.A02.setDuration(400L);
        this.A02.setInterpolator(new LinearInterpolator());
        this.A02.start();
    }
}
