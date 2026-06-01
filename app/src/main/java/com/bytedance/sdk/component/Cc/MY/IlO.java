package com.bytedance.sdk.component.Cc.MY;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements com.bytedance.sdk.component.Cc.tV<EO> {
    /* JADX WARN: Can't wrap try/catch for region: R(13:47|3|4|50|5|(7:52|6|(1:8)(1:55)|41|40|43|44)|15|48|16|(1:18)|24|43|44) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        r10 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    @Override // com.bytedance.sdk.component.Cc.tV
    /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.Cc.MY.EO<byte[]> IlO(com.bytedance.sdk.component.Cc.Cc r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "InternalHttpClient"
            r1 = 0
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L72 java.net.MalformedURLException -> L76
            java.lang.String r4 = r10.IlO()     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L72 java.net.MalformedURLException -> L76
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L72 java.net.MalformedURLException -> L76
            java.net.URLConnection r3 = r3.openConnection()     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L72 java.net.MalformedURLException -> L76
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L72 java.net.MalformedURLException -> L76
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L72 java.net.MalformedURLException -> L76
            r4 = 5000(0x1388, float:7.006E-42)
            r3.setConnectTimeout(r4)     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L72 java.net.MalformedURLException -> L76
            r3.setReadTimeout(r4)     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L72 java.net.MalformedURLException -> L76
            r3.connect()     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L72 java.net.MalformedURLException -> L76
            java.io.InputStream r4 = r3.getInputStream()     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L72 java.net.MalformedURLException -> L76
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67 java.net.MalformedURLException -> L6b
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67 java.net.MalformedURLException -> L6b
            r6.<init>()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67 java.net.MalformedURLException -> L6b
        L30:
            int r7 = r4.read(r5)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3f java.net.MalformedURLException -> L42
            r8 = -1
            if (r7 == r8) goto L46
            r6.write(r5, r2, r7)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3f java.net.MalformedURLException -> L42
            goto L30
        L3b:
            r10 = move-exception
        L3c:
            r1 = r4
            goto Lba
        L3f:
            r10 = move-exception
            r5 = r1
            goto L7a
        L42:
            r10 = move-exception
            r5 = r1
            goto L9a
        L46:
            r2 = 200(0xc8, float:2.8E-43)
            byte[] r5 = r6.toByteArray()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3f java.net.MalformedURLException -> L42
            boolean r10 = r10.MY()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L57 java.net.MalformedURLException -> L59
            if (r10 == 0) goto L5b
            java.util.Map r1 = r9.IlO(r3)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L57 java.net.MalformedURLException -> L59
            goto L5b
        L57:
            r10 = move-exception
            goto L7a
        L59:
            r10 = move-exception
            goto L9a
        L5b:
            com.bytedance.sdk.component.utils.NV.IlO(r4)
            com.bytedance.sdk.component.utils.NV.IlO(r6)
            java.lang.String r10 = "success"
            goto Lb4
        L64:
            r10 = move-exception
            r6 = r1
            goto L3c
        L67:
            r10 = move-exception
            r5 = r1
        L69:
            r6 = r5
            goto L7a
        L6b:
            r10 = move-exception
            r5 = r1
        L6d:
            r6 = r5
            goto L9a
        L6f:
            r10 = move-exception
            r6 = r1
            goto Lba
        L72:
            r10 = move-exception
            r4 = r1
            r5 = r4
            goto L69
        L76:
            r10 = move-exception
            r4 = r1
            r5 = r4
            goto L6d
        L7a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
            java.lang.String r7 = "IOException:"
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r7 = r10.getMessage()     // Catch: java.lang.Throwable -> L3b
            r3.append(r7)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3b
            android.util.Log.w(r0, r3)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L3b
        L93:
            com.bytedance.sdk.component.utils.NV.IlO(r4)
            com.bytedance.sdk.component.utils.NV.IlO(r6)
            goto Lb4
        L9a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
            java.lang.String r7 = "MalformedURLException:"
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r7 = r10.getMessage()     // Catch: java.lang.Throwable -> L3b
            r3.append(r7)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3b
            android.util.Log.w(r0, r3)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L3b
            goto L93
        Lb4:
            com.bytedance.sdk.component.Cc.MY.EO r0 = new com.bytedance.sdk.component.Cc.MY.EO
            r0.<init>(r2, r5, r10, r1)
            return r0
        Lba:
            com.bytedance.sdk.component.utils.NV.IlO(r1)
            com.bytedance.sdk.component.utils.NV.IlO(r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.Cc.MY.IlO.IlO(com.bytedance.sdk.component.Cc.Cc):com.bytedance.sdk.component.Cc.MY.EO");
    }

    private Map<String, String> IlO(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list != null && list.size() > 0) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }
}
