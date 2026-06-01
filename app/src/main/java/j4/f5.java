package j4;

import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f12196a = Logger.getLogger(f5.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f12197b = "-bin".getBytes(e2.d.f11227a);

    public static boolean a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i2 = length; i2 < bArr.length; i2++) {
            if (bArr[i2] != bArr2[i2 - length]) {
                return false;
            }
        }
        return true;
    }
}
