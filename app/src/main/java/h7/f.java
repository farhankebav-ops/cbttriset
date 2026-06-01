package h7;

import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f11756a = new char[Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f11757b = new byte[126];

    static {
        for (int i2 = 0; i2 < 32; i2++) {
        }
        a(8, 'b');
        a(9, 't');
        a(10, 'n');
        a(12, 'f');
        a(13, 'r');
        a(47, '/');
        a(34, '\"');
        a(92, '\\');
        byte[] bArr = f11757b;
        for (int i8 = 0; i8 < 33; i8++) {
            bArr[i8] = 127;
        }
        bArr[9] = 3;
        bArr[10] = 3;
        bArr[13] = 3;
        bArr[32] = 3;
        bArr[44] = 4;
        bArr[58] = 5;
        bArr[123] = 6;
        bArr[125] = 7;
        bArr[91] = 8;
        bArr[93] = 9;
        bArr[34] = 1;
        bArr[92] = 2;
    }

    public static void a(int i2, char c7) {
        if (c7 != 'u') {
            f11756a[c7] = (char) i2;
        }
    }
}
