package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.if, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class Cif extends AbstractRunnableC1164Vt {
    public static byte[] A02;
    public final /* synthetic */ MW A00;
    public final /* synthetic */ String A01;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-77, -65, -78, -66, -62, -78, -69, -80, -58, -84, -80, -82, -67, -67, -74, -69, -76};
    }

    public Cif(MW mw, String str) {
        this.A00 = mw;
        this.A01 = str;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        try {
            this.A00.A06.await();
            synchronized (this.A00.A02) {
                Iterator<String> itKeys = this.A00.A02.A05().keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (this.A00.A0J(this.A01)) {
                        this.A00.A0E((N2) this.A00.A02.A05().get(next), next, next.equals(this.A01));
                    }
                }
                this.A00.A02.A06();
                this.A00.A08();
            }
        } catch (InterruptedException e) {
            InterfaceC1089Su interfaceC1089SuA08 = this.A00.A03.A08();
            String encryptedId = A00(0, 17, 22);
            interfaceC1089SuA08.AAy(encryptedId, AbstractC1090Sv.A1B, new C1091Sw(e));
        } catch (JSONException e4) {
            this.A00.A0M();
            InterfaceC1089Su interfaceC1089SuA082 = this.A00.A03.A08();
            String encryptedId2 = A00(0, 17, 22);
            interfaceC1089SuA082.AAy(encryptedId2, AbstractC1090Sv.A1A, new C1091Sw(e4));
        }
    }
}
