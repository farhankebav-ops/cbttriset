package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0996Pe implements InterfaceC1557ee {
    public static byte[] A03;
    public static String[] A04 = {"vUQacvUb1jgaOB1nXCILUaEr4ItZ5QEs", "N", "ozPzI", "iemFS7qx3ItQSdDQeBrvuJ9y9CMkfIqY", "EwROMxnfRd6F7268i4EpvPtVg3hQf", "a", "qVu8", "3RxrE6NsEsLt8TXu"};
    public final /* synthetic */ long A00;
    public final /* synthetic */ VR A01;
    public final /* synthetic */ VU A02;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{85, 80, 5, 87, 81, 3, 7, 0, 57, 108, 104, 63, 104, 57, 59, 44, 53, 41, 40, 35, 30, 5, 3, 22, 18, 15, 9, 8, 92, 70, 78, 120, 111, 107, 120, 111, 61, 120, 111, 111, 114, 111, 61, 114, 126, 126, 104, 111, 111, 120, 121, 124, 74, 93, 89, 74, 93, 15, 93, 74, 95, 67, 70, 74, 75, 15, 92, 90, 76, 76, 74, 92, 92, 73, 90, 67, 67, 86, 63, 62, 19, 63, 61, 32, 60, 53, 36, 53, 16, 17, 58, 13, 13, 16, 13};
    }

    static {
        A01();
    }

    public C0996Pe(VU vu, VR vr, long j) {
        this.A02 = vu;
        this.A01 = vr;
        this.A00 = j;
    }

    private final void A02(C1569eq c1569eq) {
        VQ.A06(this.A01);
        try {
            InterfaceC1555ec response = c1569eq.A00();
            if (response != null) {
                String strA6v = response.A6v();
                VX serverResponse = this.A02.A06.A07(this.A02.A05, strA6v, this.A00);
                if (serverResponse.A01() == VW.A03) {
                    PV pv = (PV) serverResponse;
                    String strA04 = pv.A04();
                    AdErrorType adErrorTypeAdErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(pv.A03(), AdErrorType.ERROR_MESSAGE);
                    if (strA04 != null) {
                        strA6v = strA04;
                    }
                    this.A02.A05.A0F().A3O(XG.A01(this.A02.A01), adErrorTypeAdErrorTypeFromCode.getErrorCode(), strA6v, adErrorTypeAdErrorTypeFromCode.isPublicError());
                    this.A02.A0E(V1.A01(adErrorTypeAdErrorTypeFromCode, strA6v));
                    return;
                }
            }
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String message = c1569eq.getMessage();
            LH lhA0F = this.A02.A05.A0F();
            long jA01 = XG.A01(this.A02.A01);
            int errorCode = adErrorType.getErrorCode();
            boolean zIsPublicError = adErrorType.isPublicError();
            if (A04[2].length() == 29) {
                throw new RuntimeException();
            }
            A04[4] = "NZ18w";
            lhA0F.A3O(jA01, errorCode, message, zIsPublicError);
            this.A02.A0E(V1.A01(adErrorType, message));
        } catch (JSONException e) {
            AdErrorType adErrorType2 = AdErrorType.NETWORK_ERROR;
            String errorMessage = c1569eq.getMessage();
            this.A02.A05.A0F().A3O(XG.A01(this.A02.A01), adErrorType2.getErrorCode(), A00(15, 15, 30) + e.getMessage(), adErrorType2.isPublicError());
            this.A02.A0E(V1.A01(adErrorType2, errorMessage));
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1557ee
    public final void ACo(InterfaceC1555ec interfaceC1555ec) {
        VF.A05(A00(78, 10, 40), A00(51, 27, 87), A00(8, 7, 114));
        if (interfaceC1555ec != null) {
            String strA6v = interfaceC1555ec.A6v();
            int iA02 = U7.A02(this.A02.A05);
            String[] strArr = A04;
            String str = strArr[5];
            String response = strArr[1];
            if (str.length() != response.length()) {
                throw new RuntimeException();
            }
            A04[2] = "kblvpkFa8oUK1ItVGqcsW93nH";
            if (iA02 > 0) {
                W2.A00(this.A02.A05).A0C(strA6v);
            }
            VQ.A06(this.A01);
            this.A02.A0O(strA6v, this.A00, this.A01);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1557ee
    public final void ADC(Exception exc) {
        VF.A05(A00(88, 7, 7), A00(30, 21, 101), A00(0, 8, 30));
        if (C1569eq.class.equals(exc.getClass())) {
            A02((C1569eq) exc);
            return;
        }
        AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
        String errorMessage = exc.getMessage();
        this.A02.A05.A0F().A3O(XG.A01(this.A02.A01), adErrorType.getErrorCode(), errorMessage, adErrorType.isPublicError());
        this.A02.A0E(V1.A01(adErrorType, errorMessage));
    }
}
