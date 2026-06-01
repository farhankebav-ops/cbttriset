package okhttp3.internal;

import androidx.camera.core.processing.util.a;
import com.ironsource.C2300e4;
import java.io.EOFException;
import k6.d;
import kotlin.jvm.internal.k;
import n6.l;
import n6.m;
import n6.t;
import okhttp3.internal.idn.IdnaMappingTableInstanceKt;
import okhttp3.internal.idn.Punycode;
import r2.q;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class _HostnamesCommonKt {
    private static final l VERIFY_AS_IP_ADDRESS = new l("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static final boolean canParseAsIpAddress(String str) {
        k.e(str, "<this>");
        l lVar = VERIFY_AS_IP_ADDRESS;
        lVar.getClass();
        return lVar.f13103a.matcher(str).matches();
    }

    public static final byte[] canonicalizeInetAddress(byte[] address) {
        k.e(address, "address");
        if (!isMappedIpv4Address(address)) {
            return address;
        }
        d indices = q.D0(12, 16);
        k.e(indices, "indices");
        return indices.isEmpty() ? new byte[0] : j.i0(address, indices.f12709a, indices.f12710b + 1);
    }

    public static final boolean containsInvalidHostnameAsciiCodes(String str) {
        k.e(str, "<this>");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (k.g(cCharAt, 31) <= 0 || k.g(cCharAt, 127) >= 0 || m.x0(" #%/:?@[\\]", cCharAt, 0, 6) != -1) {
                return true;
            }
        }
        return false;
    }

    public static final boolean containsInvalidLabelLengths(String str) {
        k.e(str, "<this>");
        int length = str.length();
        if (1 <= length && length < 254) {
            int i2 = 0;
            while (true) {
                int iX0 = m.x0(str, '.', i2, 4);
                int length2 = iX0 == -1 ? str.length() - i2 : iX0 - i2;
                if (1 > length2 || length2 >= 64) {
                    break;
                }
                if (iX0 == -1 || iX0 == str.length() - 1) {
                    break;
                }
                i2 = iX0 + 1;
            }
            return false;
        }
        return true;
    }

    public static final boolean decodeIpv4Suffix(String input, int i2, int i8, byte[] address, int i9) {
        k.e(input, "input");
        k.e(address, "address");
        int i10 = i9;
        while (i2 < i8) {
            if (i10 == address.length) {
                return false;
            }
            if (i10 != i9) {
                if (input.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i11 = i2;
            int i12 = 0;
            while (i11 < i8) {
                char cCharAt = input.charAt(i11);
                if (k.g(cCharAt, 48) < 0 || k.g(cCharAt, 57) > 0) {
                    break;
                }
                if ((i12 == 0 && i2 != i11) || (i12 = ((i12 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i11++;
            }
            if (i11 - i2 == 0) {
                return false;
            }
            address[i10] = (byte) i12;
            i10++;
            i2 = i11;
        }
        return i10 == i9 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x007b, code lost:
    
        if (r4 == 16) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007d, code lost:
    
        if (r5 != (-1)) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0081, code lost:
    
        r5.j.b0(16 - (r4 - r5), r5, r4, r1, r1);
        java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final byte[] decodeIpv6(java.lang.String r10, int r11, int r12) {
        /*
            java.lang.String r0 = "input"
            kotlin.jvm.internal.k.e(r10, r0)
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = -1
            r4 = r2
            r5 = r3
            r6 = r5
        Le:
            if (r11 >= r12) goto L7b
            if (r4 != r0) goto L14
            goto L7f
        L14:
            int r7 = r11 + 2
            if (r7 > r12) goto L2c
            java.lang.String r8 = "::"
            boolean r8 = n6.t.m0(r10, r8, r11, r2)
            if (r8 == 0) goto L2c
            if (r5 == r3) goto L24
            goto L7f
        L24:
            int r4 = r4 + 2
            r5 = r4
            if (r7 != r12) goto L2a
            goto L7b
        L2a:
            r6 = r7
            goto L4e
        L2c:
            if (r4 == 0) goto L38
            java.lang.String r7 = ":"
            boolean r7 = n6.t.m0(r10, r7, r11, r2)
            if (r7 == 0) goto L3a
            int r11 = r11 + 1
        L38:
            r6 = r11
            goto L4e
        L3a:
            java.lang.String r7 = "."
            boolean r11 = n6.t.m0(r10, r7, r11, r2)
            if (r11 == 0) goto L7f
            int r11 = r4 + (-2)
            boolean r10 = decodeIpv4Suffix(r10, r6, r12, r1, r11)
            if (r10 != 0) goto L4b
            goto L7f
        L4b:
            int r4 = r4 + 2
            goto L7b
        L4e:
            r7 = r2
            r11 = r6
        L50:
            if (r11 >= r12) goto L62
            char r8 = r10.charAt(r11)
            int r8 = okhttp3.internal._UtilCommonKt.parseHexDigit(r8)
            if (r8 == r3) goto L62
            int r7 = r7 << 4
            int r7 = r7 + r8
            int r11 = r11 + 1
            goto L50
        L62:
            int r8 = r11 - r6
            if (r8 == 0) goto L7f
            r9 = 4
            if (r8 <= r9) goto L6a
            goto L7f
        L6a:
            int r8 = r4 + 1
            int r9 = r7 >>> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r1[r4] = r9
            int r4 = r4 + 2
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r1[r8] = r7
            goto Le
        L7b:
            if (r4 == r0) goto L8d
            if (r5 != r3) goto L81
        L7f:
            r10 = 0
            return r10
        L81:
            int r10 = r4 - r5
            int r10 = 16 - r10
            r5.j.b0(r10, r5, r4, r1, r1)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._HostnamesCommonKt.decodeIpv6(java.lang.String, int, int):byte[]");
    }

    public static final String idnToAscii(String host) throws EOFException {
        k.e(host, "host");
        l7.j jVar = new l7.j();
        jVar.d0(host);
        l7.j jVar2 = new l7.j();
        while (!jVar.M()) {
            if (!IdnaMappingTableInstanceKt.getIDNA_MAPPING_TABLE().map(jVar.s(), jVar2)) {
                return null;
            }
        }
        jVar.d0(_NormalizeJvmKt.normalizeNfc(jVar2.r()));
        Punycode punycode = Punycode.INSTANCE;
        String strDecode = punycode.decode(jVar.r());
        if (strDecode != null && strDecode.equals(_NormalizeJvmKt.normalizeNfc(strDecode))) {
            return punycode.encode(strDecode);
        }
        return null;
    }

    public static final String inet4AddressToAscii(byte[] address) {
        k.e(address, "address");
        if (address.length != 4) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        l7.j jVar = new l7.j();
        jVar.y(_UtilCommonKt.and(address[0], 255));
        jVar.x(46);
        jVar.y(_UtilCommonKt.and(address[1], 255));
        jVar.x(46);
        jVar.y(_UtilCommonKt.and(address[2], 255));
        jVar.x(46);
        jVar.y(_UtilCommonKt.and(address[3], 255));
        return jVar.r();
    }

    public static final String inet6AddressToAscii(byte[] address) {
        k.e(address, "address");
        int i2 = -1;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i9 < address.length) {
            int i11 = i9;
            while (i11 < 16 && address[i11] == 0 && address[i11 + 1] == 0) {
                i11 += 2;
            }
            int i12 = i11 - i9;
            if (i12 > i10 && i12 >= 4) {
                i2 = i9;
                i10 = i12;
            }
            i9 = i11 + 2;
        }
        l7.j jVar = new l7.j();
        while (i8 < address.length) {
            if (i8 == i2) {
                jVar.x(58);
                i8 += i10;
                if (i8 == 16) {
                    jVar.x(58);
                }
            } else {
                if (i8 > 0) {
                    jVar.x(58);
                }
                jVar.W((_UtilCommonKt.and(address[i8], 255) << 8) | _UtilCommonKt.and(address[i8 + 1], 255));
                i8 += 2;
            }
        }
        return jVar.r();
    }

    private static final boolean isMappedIpv4Address(byte[] bArr) {
        if (bArr.length != 16) {
            return false;
        }
        for (int i2 = 0; i2 < 10; i2++) {
            if (bArr[i2] != 0) {
                return false;
            }
        }
        return bArr[10] == -1 && bArr[11] == -1;
    }

    public static final String toCanonicalHost(String str) {
        k.e(str, "<this>");
        if (m.q0(str, ":", false)) {
            byte[] bArrDecodeIpv6 = (t.n0(str, C2300e4.i.f8403d, false) && t.f0(str, C2300e4.i.e, false)) ? decodeIpv6(str, 1, str.length() - 1) : decodeIpv6(str, 0, str.length());
            if (bArrDecodeIpv6 != null) {
                byte[] bArrCanonicalizeInetAddress = canonicalizeInetAddress(bArrDecodeIpv6);
                if (bArrCanonicalizeInetAddress.length == 16) {
                    return inet6AddressToAscii(bArrCanonicalizeInetAddress);
                }
                if (bArrCanonicalizeInetAddress.length == 4) {
                    return inet4AddressToAscii(bArrCanonicalizeInetAddress);
                }
                throw new AssertionError(a.f('\'', "Invalid IPv6 address: '", str));
            }
        } else {
            String strIdnToAscii = idnToAscii(str);
            if (strIdnToAscii != null && strIdnToAscii.length() != 0 && !containsInvalidHostnameAsciiCodes(strIdnToAscii) && !containsInvalidLabelLengths(strIdnToAscii)) {
                return strIdnToAscii;
            }
        }
        return null;
    }
}
