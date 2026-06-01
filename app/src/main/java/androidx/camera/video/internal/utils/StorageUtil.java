package androidx.camera.video.internal.utils;

import android.os.StatFs;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import kotlin.jvm.internal.k;
import n6.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class StorageUtil {
    public static final StorageUtil INSTANCE = new StorageUtil();
    private static final String TAG = "StorageUtil";

    private StorageUtil() {
    }

    public static final String formatSize(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Bytes cannot be negative");
        }
        String[] strArr = {"B", "KB", "MB", "GB", "TB"};
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double d8 = j;
        int i2 = 0;
        double d9 = d8;
        while (d9 >= 1024.0d && i2 < 4) {
            d9 /= 1024.0d;
            i2++;
        }
        if (i2 == 0) {
            return decimalFormat.format(d9) + ' ' + strArr[i2];
        }
        StringBuilder sb = new StringBuilder();
        while (-1 < i2) {
            double dPow = Math.pow(1024.0d, i2);
            double dFloor = Math.floor(d8 / dPow);
            if (dFloor > 0.0d) {
                sb.append(decimalFormat.format(dFloor));
                sb.append(" ");
                sb.append(strArr[i2]);
                sb.append(" ");
                d8 -= dFloor * dPow;
            }
            i2--;
        }
        return m.T0(sb).toString();
    }

    public static final long getAvailableBytes(File file) {
        k.e(file, "file");
        String path = file.getPath();
        k.d(path, "getPath(...)");
        return getAvailableBytes(path);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        if (r0.equals(com.ironsource.B1.e) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        if (r0.equals("external_primary") != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        r3 = android.os.Environment.getExternalStorageDirectory();
        kotlin.jvm.internal.k.d(r3, "getExternalStorageDirectory(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        return getAvailableBytes(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long getAvailableBytesForMediaStoreUri(android.net.Uri r3) {
        /*
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.k.e(r3, r0)
            java.lang.String r0 = r3.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = kotlin.jvm.internal.k.a(r0, r1)
            if (r0 == 0) goto L81
            java.util.List r0 = r3.getPathSegments()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L68
            int r1 = r0.hashCode()
            r2 = -1921573490(0xffffffff8d771d8e, float:-7.6148327E-31)
            if (r1 == r2) goto L52
            r2 = -1820761141(0xffffffff937963cb, float:-3.147742E-27)
            if (r1 == r2) goto L49
            r2 = 570410685(0x21ffc6bd, float:1.7332078E-18)
            if (r1 == r2) goto L32
            goto L68
        L32:
            java.lang.String r1 = "internal"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3b
            goto L68
        L3b:
            java.io.File r3 = android.os.Environment.getDataDirectory()
            java.lang.String r0 = "getDataDirectory(...)"
            kotlin.jvm.internal.k.d(r3, r0)
            long r0 = getAvailableBytes(r3)
            return r0
        L49:
            java.lang.String r1 = "external"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5a
            goto L68
        L52:
            java.lang.String r1 = "external_primary"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L68
        L5a:
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r0 = "getExternalStorageDirectory(...)"
            kotlin.jvm.internal.k.d(r3, r0)
            long r0 = getAvailableBytes(r3)
            return r0
        L68:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown MediaStore URI: "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.String r0 = "StorageUtil"
            androidx.camera.core.Logger.w(r0, r3)
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            return r0
        L81:
            java.lang.String r0 = "Not a content uri: "
            java.lang.String r3 = a1.a.k(r0, r3)
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r3 = r3.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.utils.StorageUtil.getAvailableBytesForMediaStoreUri(android.net.Uri):long");
    }

    public static final boolean isStorageFullException(Exception e) {
        String message;
        k.e(e, "e");
        return (e instanceof FileNotFoundException) && (message = e.getMessage()) != null && m.q0(message, "No space left on device", false);
    }

    public static final long getAvailableBytes(String path) {
        k.e(path, "path");
        return new StatFs(path).getAvailableBytes();
    }
}
