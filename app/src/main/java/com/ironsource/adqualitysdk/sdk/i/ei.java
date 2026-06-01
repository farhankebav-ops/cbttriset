package com.ironsource.adqualitysdk.sdk.i;

import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ei extends ej {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f1975 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1976;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f1977 = {'R', 187, 210, 208, 208, 169, 162, 205, 203, 198, 208, 203, 202, 206, 203, 202, 163, 169, 212, 203, 202, 203, 202, 205, 204, 210, 170, 168, 210, 212, 170, 162, 206, 212, 209, 203, 204, 211, 206, 204, 206, 167, 'D', 141, 142, 139, 146, 'q', 'T', 'T', 'q', 154, 156, 152, 146, 145, 'j', 'q', 152, 'n', 'q', 155, 147, 'i', 'd', 131, 'e', 'n', 149, 'n', 'q', 152, 151, 155, 153, 151, 150, 151, 154, 147, 139, 'i', 'n', '^', 202, 202};

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private ee f1978;

    public ei(ee eeVar, ee eeVar2, ee eeVar3, Cdo cdo) {
        super(eeVar, eeVar2, cdo);
        this.f1978 = eeVar3;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private ee m2198() {
        int i2 = f1975 + 109;
        int i8 = i2 % 128;
        f1976 = i8;
        if (i2 % 2 != 0) {
            throw null;
        }
        ee eeVar = this.f1978;
        f1975 = (i8 + 95) % 128;
        return eeVar;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2199(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
        String str2;
        Object bytes = str;
        if (str != null) {
            bytes = str.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        synchronized (g.f2126) {
            try {
                int i2 = iArr[0];
                int i8 = iArr[1];
                int i9 = iArr[2];
                int i10 = iArr[3];
                char[] cArr = new char[i8];
                System.arraycopy(f1977, i2, cArr, 0, i8);
                if (bArr != null) {
                    char[] cArr2 = new char[i8];
                    g.f2125 = 0;
                    char c7 = 0;
                    while (true) {
                        int i11 = g.f2125;
                        if (i11 >= i8) {
                            break;
                        }
                        if (bArr[i11] == 1) {
                            cArr2[i11] = (char) (((cArr[i11] << 1) + 1) - c7);
                        } else {
                            cArr2[i11] = (char) ((cArr[i11] << 1) - c7);
                        }
                        c7 = cArr2[i11];
                        g.f2125 = i11 + 1;
                    }
                    cArr = cArr2;
                }
                if (i10 > 0) {
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr, 0, cArr3, 0, i8);
                    int i12 = i8 - i10;
                    System.arraycopy(cArr3, 0, cArr, i12, i10);
                    System.arraycopy(cArr3, i10, cArr, 0, i12);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    g.f2125 = 0;
                    while (true) {
                        int i13 = g.f2125;
                        if (i13 >= i8) {
                            break;
                        }
                        cArr4[i13] = cArr[(i8 - i13) - 1];
                        g.f2125 = i13 + 1;
                    }
                    cArr = cArr4;
                }
                if (i9 > 0) {
                    g.f2125 = 0;
                    while (true) {
                        int i14 = g.f2125;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr[i14] = (char) (cArr[i14] - iArr[2]);
                        g.f2125 = i14 + 1;
                    }
                }
                str2 = new String(cArr);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ej
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            int i2 = f1976 + 51;
            f1975 = i2 % 128;
            if (i2 % 2 == 0) {
                obj.getClass();
                throw null;
            }
            if (ei.class == obj.getClass()) {
                if (!super.equals(obj)) {
                    f1975 = (f1976 + 95) % 128;
                    return false;
                }
                ee eeVar = this.f1978;
                ee eeVar2 = ((ei) obj).f1978;
                return eeVar != null ? eeVar.equals(eeVar2) : eeVar2 == null;
            }
        }
        return false;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ej
    public final int hashCode() {
        int iHashCode;
        f1975 = (f1976 + 99) % 128;
        int iHashCode2 = super.hashCode() * 31;
        ee eeVar = this.f1978;
        if (eeVar != null) {
            f1976 = (f1975 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
            iHashCode = eeVar.hashCode();
            f1976 = (f1975 + 67) % 128;
        } else {
            iHashCode = 0;
        }
        return iHashCode2 + iHashCode;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ej
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(m2199("\u0000\u0001\u0001", false, new int[]{83, 3, 156, 0}).intern());
        sb.append(m2198().toString());
        String string = sb.toString();
        f1975 = (f1976 + 17) % 128;
        return string;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    public final du mo2156(ds dsVar, cp cpVar) {
        int i2 = f1976 + 45;
        f1975 = i2 % 128;
        try {
        } catch (Exception e) {
            String strM1723 = cpVar.m1723();
            StringBuilder sb = new StringBuilder();
            sb.append(m2199("\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0001\u0000", false, new int[]{0, 42, 96, 0}).intern());
            sb.append(this);
            sb.append(m2190());
            co.m1671(strM1723, sb.toString(), e);
        }
        if (i2 % 2 == 0) {
            m2202().m2189(dsVar, cpVar);
            m2198().m2189(dsVar, cpVar);
            m2201().m2189(dsVar, cpVar).m2153();
            throw null;
        }
        du duVarM2189 = m2202().m2189(dsVar, cpVar);
        du duVarM21892 = m2198().m2189(dsVar, cpVar);
        Object objM2153 = m2201().m2189(dsVar, cpVar).m2153();
        if (objM2153 instanceof JSONObject) {
            ((JSONObject) objM2153).put((String) duVarM2189.m2153(), duVarM21892.m2153());
        } else if (objM2153 instanceof JSONArray) {
            ((JSONArray) objM2153).put(duVarM2189.m2152().intValue(), duVarM21892.m2153());
        } else if (objM2153 instanceof Map) {
            ((Map) objM2153).put(duVarM2189.m2153(), duVarM21892.m2153());
        } else if (objM2153 instanceof List) {
            f1976 = (f1975 + 25) % 128;
            ((List) objM2153).set(duVarM2189.m2152().intValue(), duVarM21892.m2153());
        } else if (objM2153.getClass().isArray()) {
            ((Object[]) objM2153)[duVarM2189.m2152().intValue()] = duVarM21892.m2153();
        } else {
            String strM17232 = cpVar.m1723();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m2199("\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0001\u0000", false, new int[]{0, 42, 96, 0}).intern());
            sb2.append(this);
            sb2.append(m2190());
            sb2.append(m2199("\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001", false, new int[]{42, 41, 39, 6}).intern());
            sb2.append(objM2153);
            co.m1671(strM17232, sb2.toString(), null);
        }
        int i8 = f1976 + 113;
        f1975 = i8 % 128;
        if (i8 % 2 != 0) {
            return duVarM21892;
        }
        throw null;
    }
}
