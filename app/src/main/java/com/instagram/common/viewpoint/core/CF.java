package com.instagram.common.viewpoint.core;

import android.util.Log;
import com.vungle.ads.internal.protos.Sdk;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class CF implements InterfaceC1571es {
    public static byte[] A01;
    public final InterfaceC1572et A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 25);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{108, -114, -114, -112, -101, -97, 88, 110, -109, -116, -99, -98, -112, -97, -42, -11, 7, -3, -9, -26, -7, 5, 9, -7, 7, 8, -36, -11, 2, -8, 0, -7, 6, -62, 3, 2, -39, 6, 6, 3, 6, -126, -82, -83, -77, -92, -83, -77, 108, -109, -72, -81, -92, -126, -127, 115, 90, 101};
    }

    public CF(InterfaceC1572et interfaceC1572et) {
        this.A00 = interfaceC1572et;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1571es
    public final boolean ADE(C1569eq c1569eq) {
        InterfaceC1555ec interfaceC1555ecA00 = c1569eq.A00();
        if (this.A00.AAQ()) {
            Log.e(CF.class.getSimpleName(), A00(14, 27, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), c1569eq);
        }
        if (interfaceC1555ecA00 != null && interfaceC1555ecA00.A94() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1571es
    public final HttpURLConnection AG1(String str, Proxy proxy) throws IOException {
        URL url = new URL(str);
        if (proxy == null) {
            return (HttpURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection(proxy);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1571es
    public final InputStream AG2(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getInputStream();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1571es
    public final OutputStream AG3(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getOutputStream();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1571es
    public final void AGM(HttpURLConnection httpURLConnection, EnumC1567eo enumC1567eo, String str) throws IOException {
        httpURLConnection.setRequestMethod(enumC1567eo.A03());
        httpURLConnection.setDoOutput(enumC1567eo.A05());
        httpURLConnection.setDoInput(enumC1567eo.A04());
        if (str != null) {
            httpURLConnection.setRequestProperty(A00(41, 12, 38), str);
        }
        httpURLConnection.setRequestProperty(A00(0, 14, 18), A00(53, 5, 20));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1571es
    public final byte[] AGj(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 != -1) {
                byteArrayOutputStream.write(bArr, 0, i2);
            } else {
                byteArrayOutputStream.flush();
                byte[] data = byteArrayOutputStream.toByteArray();
                return data;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1571es
    public final void AKN(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(bArr);
    }
}
