package okhttp3.internal.http2;

import kotlin.jvm.internal.k;
import l7.m;
import n6.t;
import okhttp3.internal._UtilJvmKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Http2 {
    private static final String[] BINARY;
    public static final m CONNECTION_PREFACE;
    private static final String[] FLAGS;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final Http2 INSTANCE = new Http2();
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    static {
        m mVar = m.f12880d;
        CONNECTION_PREFACE = r4.c.e("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        FRAME_NAMES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        FLAGS = new String[64];
        String[] strArr = new String[256];
        for (int i2 = 0; i2 < 256; i2++) {
            String binaryString = Integer.toBinaryString(i2);
            k.d(binaryString, "toBinaryString(...)");
            strArr[i2] = t.k0(_UtilJvmKt.format("%8s", binaryString), ' ', '0');
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i8 = iArr[0];
        strArr2[i8 | 8] = a1.a.r(new StringBuilder(), strArr2[i8], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i9 = 0; i9 < 3; i9++) {
            int i10 = iArr2[i9];
            int i11 = iArr[0];
            String[] strArr3 = FLAGS;
            int i12 = i11 | i10;
            strArr3[i12] = strArr3[i11] + '|' + strArr3[i10];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i11]);
            sb.append('|');
            strArr3[i12 | 8] = a1.a.r(sb, strArr3[i10], "|PADDED");
        }
        int length = FLAGS.length;
        for (int i13 = 0; i13 < length; i13++) {
            String[] strArr4 = FLAGS;
            if (strArr4[i13] == null) {
                strArr4[i13] = BINARY[i13];
            }
        }
    }

    private Http2() {
    }

    public final String formatFlags(int i2, int i8) {
        String str;
        if (i8 == 0) {
            return "";
        }
        if (i2 != 2 && i2 != 3) {
            if (i2 == 4 || i2 == 6) {
                return i8 == 1 ? "ACK" : BINARY[i8];
            }
            if (i2 != 7 && i2 != 8) {
                String[] strArr = FLAGS;
                if (i8 < strArr.length) {
                    str = strArr[i8];
                    k.b(str);
                } else {
                    str = BINARY[i8];
                }
                return (i2 != 5 || (i8 & 4) == 0) ? (i2 != 0 || (i8 & 32) == 0) ? str : t.l0(str, "PRIORITY", "COMPRESSED") : t.l0(str, "HEADERS", "PUSH_PROMISE");
            }
        }
        return BINARY[i8];
    }

    public final String formattedType$okhttp(int i2) {
        String[] strArr = FRAME_NAMES;
        return i2 < strArr.length ? strArr[i2] : _UtilJvmKt.format("0x%02x", Integer.valueOf(i2));
    }

    public final String frameLog(boolean z2, int i2, int i8, int i9, int i10) {
        return _UtilJvmKt.format("%s 0x%08x %5d %-13s %s", z2 ? "<<" : ">>", Integer.valueOf(i2), Integer.valueOf(i8), formattedType$okhttp(i9), formatFlags(i9, i10));
    }

    public final String frameLogWindowUpdate(boolean z2, int i2, int i8, long j) {
        return _UtilJvmKt.format("%s 0x%08x %5d %-13s %d", z2 ? "<<" : ">>", Integer.valueOf(i2), Integer.valueOf(i8), formattedType$okhttp(8), Long.valueOf(j));
    }
}
