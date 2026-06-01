package com.instagram.common.viewpoint.core;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C7 implements InterfaceC1572et {
    public static byte[] A01;
    public final boolean A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 126);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{75, 14, 48, 28, 29, 7, 22, 29, 7, 73, 83, 42, 29, 27, 29, 17, 14, 29, 88, 13, 10, 20, 66, 88, 30, 57, 44, 57, 56, 62, 119, 109};
    }

    public C7(boolean z2) {
        this.A00 = z2;
    }

    private void A02(Map<String, List<String>> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                for (String header : map.get(str)) {
                    String str2 = str + A00(1, 1, 74) + header;
                }
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1572et
    public final boolean AAQ() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1572et
    public final void ABN(HttpURLConnection httpURLConnection, Object obj) throws IOException {
        String str = httpURLConnection.getRequestMethod() + A00(0, 1, 21) + httpURLConnection.getURL().toString();
        if (obj instanceof String) {
            String str2 = A00(2, 9, 13) + ((String) obj);
        }
        A02(httpURLConnection.getRequestProperties());
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1572et
    public final void ABO(InterfaceC1555ec interfaceC1555ec) {
        if (interfaceC1555ec != null) {
            String str = A00(11, 13, 6) + interfaceC1555ec.getUrl();
            String str2 = A00(24, 8, 51) + interfaceC1555ec.A94();
            A02(interfaceC1555ec.A86());
        }
    }
}
