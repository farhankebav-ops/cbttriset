package com.pgl.ssdk;

import java.io.BufferedInputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class f0 {
    private static void a(byte[] bArr, int i2, byte[] bArr2) {
        for (int i8 = 0; i8 < i2; i8++) {
            bArr[i8] = (byte) (bArr[i8] ^ bArr2[i8 % bArr2.length]);
        }
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        int i2;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                i2 = bufferedInputStream.read(bArr);
                if (i2 > 0) {
                    sb.append(new String(bArr, 0, i2));
                }
            } catch (Exception unused) {
            }
        } while (i2 >= 4096);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r5) throws java.lang.Throwable {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L5a
            java.lang.String r2 = "sh"
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L5a
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L5b
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L5b
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L5b
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            byte[] r5 = r5.getBytes()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L5d
            r2.write(r5)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L5d
            r5 = 10
            r2.write(r5)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L5d
            r2.flush()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L5d
            r2.close()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L5d
            r1.waitFor()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L5d
            java.lang.String r0 = a(r3)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L5d
            r2.close()     // Catch: java.io.IOException -> L39
        L39:
            r3.close()     // Catch: java.io.IOException -> L6a
            goto L6a
        L3d:
            r5 = move-exception
        L3e:
            r0 = r2
            goto L4a
        L40:
            r5 = move-exception
            r3 = r0
            goto L3e
        L43:
            r3 = r0
            goto L5d
        L45:
            r5 = move-exception
            goto L49
        L47:
            r5 = move-exception
            r1 = r0
        L49:
            r3 = r0
        L4a:
            if (r0 == 0) goto L4f
            r0.close()     // Catch: java.io.IOException -> L4f
        L4f:
            if (r3 == 0) goto L54
            r3.close()     // Catch: java.io.IOException -> L54
        L54:
            if (r1 == 0) goto L59
            r1.destroy()
        L59:
            throw r5
        L5a:
            r1 = r0
        L5b:
            r2 = r0
            r3 = r2
        L5d:
            if (r2 == 0) goto L62
            r2.close()     // Catch: java.io.IOException -> L62
        L62:
            if (r3 == 0) goto L67
            r3.close()     // Catch: java.io.IOException -> L67
        L67:
            if (r1 != 0) goto L6a
            goto L6d
        L6a:
            r1.destroy()
        L6d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.f0.a(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.lang.String a(android.content.Context r9) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.f0.a(android.content.Context):java.lang.String");
    }
}
