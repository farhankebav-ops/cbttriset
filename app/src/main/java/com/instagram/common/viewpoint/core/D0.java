package com.instagram.common.viewpoint.core;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class D0 extends ImageView implements InterfaceC1494dc {
    public static byte[] A05;
    public static String[] A06 = {"4xWU9o1Qdv49zg4k19WdZrOQJ68qlBKJ", "QfpLWsUkij8dLfBb7Aagb5qXzjDoxZj6", "QolGMRpELvSET2", "SiemLW4oVdpf", "uXL2k0aAaj67psTeNQKHhn5IgBi2NdXT", "OArHsnP", "A54GrsZIV89x3qzJRphed5abiMfcDTpl", "7SQmPw6zIXtGY8y4ylHwiNNuEQdMSmlG"};
    public static final int A07;
    public static final int A08;
    public E1 A00;
    public final Paint A01;
    public final C1477dL A02;
    public final C1120Ua A03;
    public final DE A04;

    public static String A03(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 62);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{-100, -60, -61, -76, 111, -112, -77};
    }

    static {
        A06();
        A08 = (int) (AbstractC1180Wl.A02 * 40.0f);
        A07 = (int) (AbstractC1180Wl.A02 * 10.0f);
    }

    public D0(C1477dL c1477dL, C1120Ua c1120Ua) {
        super(c1477dL);
        this.A04 = new DE() { // from class: com.facebook.ads.redexgen.X.2q
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(DF df) {
                this.A00.A09();
            }
        };
        this.A03 = c1120Ua;
        this.A02 = c1477dL;
        this.A01 = new Paint();
        this.A01.setColor(Integer.MIN_VALUE);
        setColorFilter(-1);
        setPadding(A07, A07, A07, A07);
        setContentDescription(A03(0, 7, 17));
        A05();
        setOnClickListener(new ViewOnClickListenerC1511du(this));
    }

    private void A04() {
        setImageBitmap(XY.A01(XX.ICON_MUTE));
    }

    private void A05() {
        setImageBitmap(XY.A01(XX.ICON_UN_MUTE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A07() {
        return this.A00 != null && this.A00.getVolume() == 0.0f;
    }

    public final void A09() {
        if (this.A00 == null) {
            return;
        }
        boolean zA07 = A07();
        if (A06[3].length() != 12) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[7] = "aX931uSfPaE8IiOHtPCxhipRkXbTn1t9";
        strArr[4] = "ET7wr0zhj8rUQx1GjBOUHwAZuNFVr5BQ";
        if (zA07) {
            A04();
        } else {
            A05();
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1494dc
    public final void AAm(E1 e12) {
        this.A00 = e12;
        if (this.A00 != null) {
            this.A00.getEventBus().A05(this.A04);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1494dc
    public final void AJk(E1 e12) {
        if (this.A00 != null) {
            C1099Te<AbstractC1100Tf, C1098Td> eventBus = this.A00.getEventBus();
            DE de = this.A04;
            String[] strArr = A06;
            if (strArr[2].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[6] = "f5V50lgekxKfxPRjN4EQZ5T7YD8zyqkA";
            strArr2[1] = "6bYokHrcutoPgrqwaKTDD5vNcVht1LGT";
            eventBus.A06(de);
        }
        this.A00 = null;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        int y = getWidth() / 2;
        int x2 = getHeight() / 2;
        canvas.drawCircle(y, x2, Math.min(y, x2), this.A01);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        int height = A08;
        int width = A08;
        setMeasuredDimension(height, width);
    }
}
