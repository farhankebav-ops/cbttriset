package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1721hO implements InterfaceC0917Ma {
    public static byte[] A02;
    public final /* synthetic */ C05426y A00;
    public final /* synthetic */ Runnable A01;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 58);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{64, 78, 68, 71, 78, 20, 79, 18, 77, 104, 109, 124, 120, 105, 126, 44, 101, 127, 44, 98, 121, 96, 96, 44, 99, 98, 44, 96, 99, 109, 104, 69, 98, 120, 105, 126, 127, 120, 101, 120, 101, 109, 96, 77, 104, 59, 28, 6, 23, 0, 1, 6, 27, 6, 27, 19, 30, 82, 27, 31, 2, 0, 23, 1, 1, 27, 29, 28, 82, 20, 27, 0, 23, 22, 63, 48, 1, 63, 61, 42, 55, 40, 55, 42, 39, 101, 106, 96, 118, 107, 109, 96, 42, 109, 106, 112, 97, 106, 112, 42, 101, 103, 112, 109, 107, 106, 42, 82, 77, 65, 83, 34, 51, 42, 109, 108, 75, 108, 118, 103, 112, 113, 118, 107, 118, 107, 99, 110, 78, 109, 101, 101, 107, 108, 101, 75, 111, 114, 112, 103, 113, 113, 107, 109, 108};
    }

    public C1721hO(C05426y c05426y, Runnable runnable) {
        this.A00 = c05426y;
        this.A01 = runnable;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0917Ma
    public final void ADY(C1778iS c1778iS, String str, boolean z2) {
        this.A00.A07.A0C();
        boolean z7 = !TextUtils.isEmpty(str);
        if (z2 && z7) {
            try {
                Intent intent = new Intent(A00(85, 26, 62));
                intent.setData(WQ.A00(str));
                WB.A0D(this.A00.A0B, intent);
            } catch (W9 e) {
                Throwable cause = e.getCause();
                W9 cause2 = e;
                if (cause != null) {
                    cause2 = e.getCause();
                }
                this.A00.A0B.A08().AAy(A00(74, 11, 100), AbstractC1090Sv.A04, new C1091Sw(cause2));
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0917Ma
    public final void ADZ(C1778iS c1778iS) {
        this.A00.A07.A04();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0917Ma
    public final void ADa(C1778iS c1778iS) {
        this.A00.A07.A05();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0917Ma
    public final void ADb(C1778iS c1778iS) {
        if (c1778iS != this.A00.A00) {
            return;
        }
        if (c1778iS == null) {
            this.A00.A0B.A08().AAy(A00(111, 3, Sdk.SDKError.Reason.TPAT_ERROR_VALUE), AbstractC1090Sv.A0X, new C1091Sw(A00(8, 37, 54)));
            ADc(c1778iS, AdError.internalError(2004));
            return;
        }
        this.A00.A0H().removeCallbacks(this.A01);
        this.A00.A01 = c1778iS;
        this.A00.A0L();
        this.A00.A07.A0F(c1778iS);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0917Ma
    public final void ADc(C1778iS c1778iS, AdError adError) {
        if (c1778iS != this.A00.A00) {
            return;
        }
        this.A00.A0H().removeCallbacks(this.A01);
        this.A00.A0Q(c1778iS);
        this.A00.A0B.A0F().A5Y(adError.getErrorCode(), adError.getErrorMessage());
        this.A00.A07.A0G(new V1(adError.getErrorCode(), adError.getErrorMessage()));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0917Ma
    public final void ADd(C1778iS c1778iS) {
        VF.A05(A00(114, 31, 56), A00(45, 29, 72), A00(0, 8, 77));
        this.A00.A07.A0D();
        this.A00.A0O();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0917Ma
    public final void ADe() {
        this.A00.A07.A08();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0917Ma
    public final void ADf() {
        this.A00.A07.A06();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0917Ma
    public final void ADg() {
        this.A00.A07.A07();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0917Ma
    public final void onInterstitialActivityDestroyed() {
        this.A00.A07.A02();
    }
}
