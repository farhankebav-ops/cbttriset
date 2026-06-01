package com.instagram.common.viewpoint.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class KE extends AbstractC1282aB implements View.OnClickListener {
    public static byte[] A0D;
    public static String[] A0E = {"zJy5N3L509NIqOAGCBmq2SY7W4xK8HwT", "H2", ExifInterface.LONGITUDE_EAST, "vMyDxD7xbIgTd", "0bWjMiKAxESivC84rSJqWsF4vTTr4zpm", "NIsgbM1VoVKu1UXdUm6ipB03AExBFzGo", "hF", "2iAtRdiONhZPMieR3MSLVzPYox5YjbDW"};
    public static final int A0F;
    public int A00;
    public int A01;
    public Bitmap A02;
    public Paint A03;
    public Rect A04;
    public C1477dL A05;
    public C1174Wd A06;
    public KG A07;
    public String A08;
    public String A09;
    public boolean A0A;
    public final a5 A0B;
    public final Map<String, String> A0C;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 121);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0D = new byte[]{-30, -21, -24, -30, -22, -34, -14, -18, -12, -15, -30, -28, -23, -27, -80, -16, -24, -10, -10, -24, -15, -22, -24, -11, 40, 38, 24, 37, 22, 31, 28, 22, 30};
    }

    static {
        A04();
        A0F = (int) (AbstractC1180Wl.A02 * 24.0f);
    }

    public KE(C1477dL c1477dL, AbstractC1752hy abstractC1752hy, C0940My c0940My, US us, InterfaceC1208Xn interfaceC1208Xn, C1550eX c1550eX, XH xh, InterfaceC1190Wv interfaceC1190Wv) {
        this(c1477dL, abstractC1752hy.A0r(), c0940My, abstractC1752hy.A20().A0J().A06(), us, interfaceC1208Xn, c1550eX, xh, abstractC1752hy.A21(), interfaceC1190Wv);
        this.A0B.A08(abstractC1752hy);
    }

    public KE(C1477dL c1477dL, String str, C0940My c0940My, US us, InterfaceC1208Xn interfaceC1208Xn, C1550eX c1550eX, XH xh, N3 n32) {
        this(c1477dL, str, c0940My, false, us, interfaceC1208Xn, c1550eX, xh, n32);
    }

    public KE(C1477dL c1477dL, String str, C0940My c0940My, boolean z2, US us, InterfaceC1208Xn interfaceC1208Xn, C1550eX c1550eX, XH xh, N3 n32) {
        super(c1477dL, c0940My);
        this.A0C = new HashMap();
        this.A05 = c1477dL;
        this.A0A = z2;
        this.A0B = new a5(c1477dL, str, c1550eX, xh, us, n32, interfaceC1208Xn);
        setOnClickListener(this);
        XP.A0E(1001, this);
    }

    public KE(C1477dL c1477dL, String str, C0940My c0940My, boolean z2, US us, InterfaceC1208Xn interfaceC1208Xn, C1550eX c1550eX, XH xh, N3 n32, InterfaceC1190Wv interfaceC1190Wv) {
        super(c1477dL, c0940My);
        this.A0C = new HashMap();
        this.A05 = c1477dL;
        this.A0A = z2;
        this.A0B = new a5(c1477dL, str, c1550eX, xh, us, n32, interfaceC1208Xn, interfaceC1190Wv);
        setOnClickListener(this);
        XP.A0E(1001, this);
    }

    public static Bitmap A00(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private void A02() {
        if (this.A0A && this.A09 != null) {
            this.A02 = A00(XY.A03(this.A05, this.A09.contains(A01(12, 12, 10)) ? XX.MESSENGER : XX.WHATSAPP));
            this.A03 = new Paint();
            setPadding(A0F, 0, A0F, 0);
        }
    }

    private void A03() {
        if (this.A06 != null) {
            C1174Wd c1174Wd = this.A06;
            if (A0E[0].charAt(27) != 'K') {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[6] = "Jn";
            strArr[1] = "nM";
            c1174Wd.A06();
        }
        if (this.A07 != null) {
            this.A07.A04();
        }
    }

    public static boolean A05(AbstractC1752hy abstractC1752hy) {
        return ((long) abstractC1752hy.A1w()) > 0 && abstractC1752hy.A1u() >= 0;
    }

    public final ME A0E(String str) {
        if (TextUtils.isEmpty(this.A08) || TextUtils.isEmpty(this.A09)) {
            return ME.A09;
        }
        A03();
        this.A0C.put(A01(0, 12, 6), str);
        return this.A0B.A05(this.A08, this.A09, this.A0C);
    }

    public final boolean A0F(AbstractC1752hy abstractC1752hy, AbstractC1207Xm abstractC1207Xm) {
        if (this.A06 != null || !A05(abstractC1752hy) || abstractC1752hy.A24().A01() == null || abstractC1752hy.A24().A00() == null) {
            return false;
        }
        this.A07 = new KG(abstractC1752hy.A1u(), abstractC1752hy.A1w(), abstractC1752hy.A1v(), abstractC1752hy.A24().A01(), abstractC1752hy.A24().A00(), abstractC1207Xm, this);
        this.A06 = new C1174Wd(abstractC1752hy.A1w(), this.A07);
        this.A06.A07();
        return true;
    }

    public a5 getCtaActionHelper() {
        return this.A0B;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            A0E(A01(24, 9, 58));
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        A03();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.A02 != null) {
            this.A04 = new Rect(0, 0, this.A02.getWidth(), this.A02.getHeight());
            this.A01 = this.A02.getWidth();
            this.A00 = 12;
            int shift = (this.A01 + this.A00) / 2;
            canvas.save();
            canvas.translate(shift, 0.0f);
        }
        super.onDraw(canvas);
        if (this.A02 != null) {
            float width = (getWidth() / 2.0f) - ((getPaint().measureText((String) getText()) + 10.0f) / 2.0f);
            float textWidth = this.A01;
            float f4 = width - textWidth;
            float textWidth2 = this.A00;
            int i2 = (int) (f4 - textWidth2);
            int top = (getHeight() / 2) - (this.A01 / 2);
            int left = this.A01;
            Rect destRect = new Rect(i2, top, left + i2, this.A01 + top);
            canvas.drawBitmap(this.A02, this.A04, destRect, this.A03);
            canvas.restore();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 != 0) {
            A03();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (!z2) {
            A03();
        }
    }

    public void setCreativeAsCtaLoggingHelper(C1176Wh c1176Wh) {
        this.A0B.A09(c1176Wh);
    }

    public void setCta(C0941Mz c0941Mz, String str, Map<String, String> extraData) {
        setCta(c0941Mz, str, extraData, null);
    }

    public void setCta(C0941Mz c0941Mz, String str, Map<String, String> extraData, InterfaceC1190Wv interfaceC1190Wv, InterfaceC1277a4 interfaceC1277a4) {
        setCta(c0941Mz, str, extraData, interfaceC1277a4);
        this.A0B.A0A(interfaceC1190Wv);
    }

    public void setCta(C0941Mz c0941Mz, String str, Map<String, String> extraData, InterfaceC1277a4 interfaceC1277a4) {
        this.A08 = str;
        this.A09 = c0941Mz.A05();
        this.A0C.putAll(extraData);
        this.A0B.A0B(interfaceC1277a4);
        String strA04 = c0941Mz.A04();
        if (!TextUtils.isEmpty(strA04)) {
            String buttonText = this.A09;
            if (!TextUtils.isEmpty(buttonText)) {
                setText(strA04);
                A02();
                return;
            }
        }
        setVisibility(8);
    }

    public void setIsInAppBrowser(boolean z2) {
        this.A0B.A0C(z2);
    }
}
