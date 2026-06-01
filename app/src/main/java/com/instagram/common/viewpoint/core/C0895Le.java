package com.instagram.common.viewpoint.core;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Le, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0895Le implements InterfaceC1173Wc {
    public static byte[] A01;
    public static String[] A02 = {"RKj", "", "UN15gotjq8", "ajoBiEUEQKFJNLqm", "ifgUnXqkKiJSPGKzKRtyUVwCV1ynqJ", "MgNPOwYKG3krpOkrgoqalUsb7GIlLECG", "4d5pH5OlBXd1RidH0kkNXmSukCNaNWUQ", "ZdfTYbLhRFsUmKvgir0oysIbzYx0fUOP"};
    public final /* synthetic */ C0893Lc A00;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-31, -7, -21, -23, -7, -29};
    }

    static {
        A01();
    }

    public C0895Le(C0893Lc c0893Lc) {
        this.A00 = c0893Lc;
    }

    public /* synthetic */ C0895Le(C0893Lc c0893Lc, C0911Lu c0911Lu) {
        this(c0893Lc);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1173Wc
    public final void ACp() {
        this.A00.A0a.setToolbarActionMessage(A00(0, 0, 19));
        this.A00.A0I();
        if (this.A00.A0X) {
            boolean zA0V = this.A00.A0V();
            String[] strArr = A02;
            if (strArr[5].charAt(0) == strArr[7].charAt(0)) {
                throw new RuntimeException();
            }
            A02[4] = "QDC88FCswtzFK8CArK72WEL9jXMBl5";
            if (zA0V) {
                this.A00.A0a.setToolbarActionMode(1);
                return;
            }
        }
        this.A00.A0a.setToolbarActionMode(0);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1173Wc
    public final void AEn(float f4) {
        float fA04;
        this.A00.A0O((int) f4);
        if (this.A00.A0Y) {
            if (this.A00.A0E) {
                AbstractC1752hy abstractC1752hy = this.A00.A0I;
                if (A02[6].charAt(27) != 'a') {
                    throw new RuntimeException();
                }
                A02[4] = "3MuDy2E798EtOoHK0e0a3SiH1QgAy5";
                fA04 = 1.0f - (f4 / abstractC1752hy.A20().A0H().A03());
                if (this.A00.A0H || fA04 < 1.0f) {
                    this.A00.A0H = false;
                    this.A00.A0a.setToolbarActionMessage(this.A00.A0I.A24().A02().replace(A00(0, 6, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), String.valueOf((int) f4)));
                } else {
                    this.A00.A0H = true;
                    AbstractC1207Xm abstractC1207Xm = this.A00.A0a;
                    String strA00 = A00(0, 0, 19);
                    if (A02[3].length() != 16) {
                        abstractC1207Xm.setToolbarActionMessage(strA00);
                    } else {
                        String[] strArr = A02;
                        strArr[5] = "wpbUz5ctYXHuYyRf6fVCU3uRzsMt7dE8";
                        strArr[7] = "BBfRd69Z77LUH69GeqVAIKhho7h2fuMA";
                        abstractC1207Xm.setToolbarActionMessage(strA00);
                    }
                }
            } else {
                fA04 = 1.0f - (f4 / this.A00.A0I.A20().A0H().A04());
            }
            this.A00.A0a.setProgress(100.0f * fA04);
            float fA03 = this.A00.A0I.A20().A0H().A03() - f4;
            float percentageOfReward = this.A00.A0I.A20().A0H().A04();
            boolean z2 = fA03 >= percentageOfReward;
            if (!this.A00.A0H && z2) {
                this.A00.A0a.setToolbarActionMode(1);
                return;
            }
            return;
        }
        this.A00.A0a.setProgress(100.0f * (1.0f - (f4 / this.A00.A0J.A07())));
    }
}
