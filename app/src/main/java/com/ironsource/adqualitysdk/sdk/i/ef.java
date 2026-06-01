package com.ironsource.adqualitysdk.sdk.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ef extends ej {

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f1958 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f1959 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f1960 = 56232;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f1961 = 54978;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f1962 = 58608;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f1963 = 41651;

    public ef(ee eeVar, ee eeVar2, Cdo cdo) {
        super(eeVar, eeVar2, cdo);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2192(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (o.f2985) {
            try {
                char[] cArr2 = new char[cArr.length];
                o.f2986 = 0;
                char[] cArr3 = new char[2];
                while (true) {
                    int i8 = o.f2986;
                    if (i8 < cArr.length) {
                        cArr3[0] = cArr[i8];
                        cArr3[1] = cArr[i8 + 1];
                        int i9 = 58224;
                        for (int i10 = 0; i10 < 16; i10++) {
                            char c7 = cArr3[1];
                            char c8 = cArr3[0];
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f1963)) ^ ((c8 >>> 5) + f1961)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f1962) ^ ((c9 + i9) ^ ((c9 << 4) + f1960))));
                            i9 -= 40503;
                        }
                        int i11 = o.f2986;
                        cArr2[i11] = cArr3[0];
                        cArr2[i11 + 1] = cArr3[1];
                        o.f2986 = i11 + 2;
                    } else {
                        str2 = new String(cArr2, 0, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
    
        if ((r8 instanceof org.json.JSONObject) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
    
        return new com.ironsource.adqualitysdk.sdk.i.du(((org.json.JSONObject) r8).opt((java.lang.String) r0.m2153()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
    
        if ((r8 instanceof org.json.JSONArray) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        r4 = new com.ironsource.adqualitysdk.sdk.i.du(((org.json.JSONArray) r8).opt(r0.m2152().intValue()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
    
        r8 = com.ironsource.adqualitysdk.sdk.i.ef.f1958 + 51;
        com.ironsource.adqualitysdk.sdk.i.ef.f1959 = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
    
        if ((r8 % 2) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
    
        if ((r8 instanceof java.util.Map) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0093, code lost:
    
        return new com.ironsource.adqualitysdk.sdk.i.du(((java.util.Map) r8).get(r0.m2153()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0096, code lost:
    
        if ((r8 instanceof java.util.List) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ab, code lost:
    
        return new com.ironsource.adqualitysdk.sdk.i.du(((java.util.List) r8).get(r0.m2152().intValue()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
    
        if (r8.getClass().isArray() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c7, code lost:
    
        return new com.ironsource.adqualitysdk.sdk.i.du(((java.lang.Object[]) r8)[r0.m2152().intValue()]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c8, code lost:
    
        r0 = r9.m1723();
        r4 = new java.lang.StringBuilder();
        r4.append(m2192("\ueb66杕\ua954ꡥﮥᳪ\uf66c髶촠\uda68\uf5ee촭죾\udb79䀑倰\u12bf誒ㄔ\ue448帎撿檴䪸\uf8ed鉱\ufaf2믯Ꞵ管\u2073涌몭鐎\uecce蝍榣適隕垵\uf5fcꥇ", (android.view.ViewConfiguration.getTouchSlop() >> 8) + 42).intern());
        r4.append(r7);
        r4.append(m2190());
        r4.append(m2192("\ue6a1╦ሖ㐬쟪\uf630䀑倰棕㡕麄璬芆\ued01䝽醽鄈墥샜짿\uf5fcꥇᏘ䟀죛ㆨ댶\ua7ec膏桐\ua634➃橥팎ꆢ艹鿴᷈\ue49c\ud917䰀ᧅ", 40 - android.graphics.ImageFormat.getBitsPerPixel(0)).intern());
        r4.append(r8);
        com.ironsource.adqualitysdk.sdk.i.co.m1671(r0, r4.toString(), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
    
        if ((r8 instanceof org.json.JSONObject) != false) goto L17;
     */
    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.ironsource.adqualitysdk.sdk.i.du mo2156(com.ironsource.adqualitysdk.sdk.i.ds r8, com.ironsource.adqualitysdk.sdk.i.cp r9) {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ef.mo2156(com.ironsource.adqualitysdk.sdk.i.ds, com.ironsource.adqualitysdk.sdk.i.cp):com.ironsource.adqualitysdk.sdk.i.du");
    }
}
