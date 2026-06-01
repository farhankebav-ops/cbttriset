package sg.bigo.ads.controller.c;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.InputStream, java.util.zip.GZIPInputStream] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.zip.GZIPInputStream] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.zip.GZIPInputStream] */
    @androidx.annotation.Nullable
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(byte[] r6) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L5b
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L5b
            java.util.zip.GZIPInputStream r6 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L44
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L44
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3c
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3c
            java.lang.String r4 = "UTF-8"
            r3.<init>(r6, r4)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3c
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L35
            r3.<init>()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L35
        L1f:
            java.lang.String r4 = r2.readLine()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L5f
            if (r4 == 0) goto L2b
            r3.append(r4)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L5f
            goto L1f
        L29:
            r0 = move-exception
            goto L4b
        L2b:
            r2.close()     // Catch: java.io.IOException -> L2e
        L2e:
            r6.close()     // Catch: java.io.IOException -> L31
        L31:
            r1.close()     // Catch: java.io.IOException -> L6c
            goto L6c
        L35:
            r3 = r0
            goto L5f
        L37:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L4b
        L3c:
            r2 = r0
        L3d:
            r3 = r2
            goto L5f
        L3f:
            r6 = move-exception
            r2 = r0
        L41:
            r0 = r6
            r6 = r2
            goto L4b
        L44:
            r6 = r0
            r2 = r6
            goto L3d
        L47:
            r6 = move-exception
            r1 = r0
            r2 = r1
            goto L41
        L4b:
            if (r2 == 0) goto L50
            r2.close()     // Catch: java.io.IOException -> L50
        L50:
            if (r6 == 0) goto L55
            r6.close()     // Catch: java.io.IOException -> L55
        L55:
            if (r1 == 0) goto L5a
            r1.close()     // Catch: java.io.IOException -> L5a
        L5a:
            throw r0
        L5b:
            r6 = r0
            r1 = r6
            r2 = r1
            goto L3d
        L5f:
            if (r2 == 0) goto L64
            r2.close()     // Catch: java.io.IOException -> L64
        L64:
            if (r6 == 0) goto L69
            r6.close()     // Catch: java.io.IOException -> L69
        L69:
            if (r1 == 0) goto L6c
            goto L31
        L6c:
            if (r3 != 0) goto L6f
            return r0
        L6f:
            java.lang.String r6 = r3.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.c.c.a(byte[]):java.lang.String");
    }
}
