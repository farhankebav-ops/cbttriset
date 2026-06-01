package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class IT implements InterfaceC1387bs {
    public static byte[] A01;
    public static String[] A02 = {"j0Llx0J1MSgFmdDCajgZS", "WqPPZqRc0dX4AocYH9RDHKNy8FKfctFv", "x4SSjhhb9i0sKdnf0Wf5s", "xtX3gCAokrJDAeXWoUYA8plxhmXwCeOm", "uRKBJqZuIeGTpbClJ99Pe9ZmQekDyja2", "rD1ESZhEMARN2moY0NiI8P2eIcx2KKt8", "vMF11DxP2anc735da3YXnRmNGLge", "xeUiMncNmqcgkFgn7eafy8FxNu3C"};
    public final /* synthetic */ C5G A00;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A02;
            if (strArr[2].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[6] = "mcgN6rOfJkIrJEn9BPtko0s6E0JP";
            strArr2[7] = "7NujJgKdrQLNFT4Mmbwt8V3uSlrM";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 20);
            i10++;
        }
    }

    public static void A01() {
        A01 = new byte[]{47, 46, 88, 27, 10, 25, 11, 16, 29, 28, 28, 14, 9, 52, 29, 2, 14, 28};
    }

    static {
        A01();
    }

    public IT(C5G c5g) {
        this.A00 = c5g;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1387bs
    public final void AEm() {
        C1451cu context = SP.A00();
        if (context != null) {
            context.A08().AAy(A00(10, 8, 127), AbstractC1090Sv.A2g, new C1091Sw(A00(0, 10, 108)));
        }
    }
}
