package okhttp3.internal.url;

import java.io.EOFException;
import java.nio.charset.Charset;
import kotlin.jvm.internal.k;
import l7.j;
import n6.a;
import n6.m;
import okhttp3.internal._UtilCommonKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class _UrlKt {
    public static final String FORM_ENCODE_SET = " !\"#$&'()+,/:;<=>?@[\\]^`{|}~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    public static final String canonicalize(String str, int i2, int i8, String encodeSet, boolean z2, boolean z7, boolean z8, boolean z9) {
        k.e(str, "<this>");
        k.e(encodeSet, "encodeSet");
        return canonicalizeWithCharset$default(str, i2, i8, encodeSet, z2, z7, z8, z9, null, 128, null);
    }

    public static /* synthetic */ String canonicalize$default(String str, int i2, int i8, String str2, boolean z2, boolean z7, boolean z8, boolean z9, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i2 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = str.length();
        }
        if ((i9 & 8) != 0) {
            z2 = false;
        }
        if ((i9 & 16) != 0) {
            z7 = false;
        }
        if ((i9 & 32) != 0) {
            z8 = false;
        }
        if ((i9 & 64) != 0) {
            z9 = false;
        }
        return canonicalize(str, i2, i8, str2, z2, z7, z8, z9);
    }

    public static final String canonicalizeWithCharset(String str, int i2, int i8, String encodeSet, boolean z2, boolean z7, boolean z8, boolean z9, Charset charset) throws EOFException {
        k.e(str, "<this>");
        k.e(encodeSet, "encodeSet");
        int iCharCount = i2;
        while (iCharCount < i8) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z9) || m.r0(encodeSet, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z2 || (z7 && !isPercentEncoded(str, iCharCount, i8)))) || (iCodePointAt == 43 && z8)))) {
                j jVar = new j();
                jVar.c0(i2, iCharCount, str);
                writeCanonicalized(jVar, str, iCharCount, i8, encodeSet, z2, z7, z8, z9, charset);
                return jVar.r();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        String strSubstring = str.substring(i2, i8);
        k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String canonicalizeWithCharset$default(String str, int i2, int i8, String str2, boolean z2, boolean z7, boolean z8, boolean z9, Charset charset, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i2 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = str.length();
        }
        if ((i9 & 8) != 0) {
            z2 = false;
        }
        if ((i9 & 16) != 0) {
            z7 = false;
        }
        if ((i9 & 32) != 0) {
            z8 = false;
        }
        if ((i9 & 64) != 0) {
            z9 = false;
        }
        if ((i9 & 128) != 0) {
            charset = null;
        }
        return canonicalizeWithCharset(str, i2, i8, str2, z2, z7, z8, z9, charset);
    }

    public static final char[] getHEX_DIGITS() {
        return HEX_DIGITS;
    }

    public static final boolean isPercentEncoded(String str, int i2, int i8) {
        k.e(str, "<this>");
        int i9 = i2 + 2;
        return i9 < i8 && str.charAt(i2) == '%' && _UtilCommonKt.parseHexDigit(str.charAt(i2 + 1)) != -1 && _UtilCommonKt.parseHexDigit(str.charAt(i9)) != -1;
    }

    public static final String percentDecode(String str, int i2, int i8, boolean z2) {
        k.e(str, "<this>");
        for (int i9 = i2; i9 < i8; i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                j jVar = new j();
                jVar.c0(i2, i9, str);
                writePercentDecoded(jVar, str, i9, i8, z2);
                return jVar.r();
            }
        }
        String strSubstring = str.substring(i2, i8);
        k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String percentDecode$default(String str, int i2, int i8, boolean z2, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i2 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = str.length();
        }
        if ((i9 & 4) != 0) {
            z2 = false;
        }
        return percentDecode(str, i2, i8, z2);
    }

    public static final void writeCanonicalized(j jVar, String input, int i2, int i8, String encodeSet, boolean z2, boolean z7, boolean z8, boolean z9, Charset charset) throws EOFException {
        k.e(jVar, "<this>");
        k.e(input, "input");
        k.e(encodeSet, "encodeSet");
        j jVar2 = null;
        while (i2 < i8) {
            int iCodePointAt = input.codePointAt(i2);
            if (!z2 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 32 && encodeSet == FORM_ENCODE_SET) {
                    jVar.d0("+");
                } else if (iCodePointAt == 43 && z8) {
                    jVar.d0(z2 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z9) || m.r0(encodeSet, (char) iCodePointAt) || (iCodePointAt == 37 && (!z2 || (z7 && !isPercentEncoded(input, i2, i8)))))) {
                    if (jVar2 == null) {
                        jVar2 = new j();
                    }
                    if (charset == null || charset.equals(a.f13073a)) {
                        jVar2.e0(iCodePointAt);
                    } else {
                        jVar2.a0(input, i2, Character.charCount(iCodePointAt) + i2, charset);
                    }
                    while (!jVar2.M()) {
                        byte b8 = jVar2.readByte();
                        jVar.x(37);
                        char[] cArr = HEX_DIGITS;
                        jVar.x(cArr[((b8 & 255) >> 4) & 15]);
                        jVar.x(cArr[b8 & 15]);
                    }
                } else {
                    jVar.e0(iCodePointAt);
                }
            }
            i2 += Character.charCount(iCodePointAt);
        }
    }

    public static final void writePercentDecoded(j jVar, String encoded, int i2, int i8, boolean z2) {
        int i9;
        k.e(jVar, "<this>");
        k.e(encoded, "encoded");
        while (i2 < i8) {
            int iCodePointAt = encoded.codePointAt(i2);
            if (iCodePointAt == 37 && (i9 = i2 + 2) < i8) {
                int hexDigit = _UtilCommonKt.parseHexDigit(encoded.charAt(i2 + 1));
                int hexDigit2 = _UtilCommonKt.parseHexDigit(encoded.charAt(i9));
                if (hexDigit == -1 || hexDigit2 == -1) {
                    jVar.e0(iCodePointAt);
                    i2 += Character.charCount(iCodePointAt);
                } else {
                    jVar.x((hexDigit << 4) + hexDigit2);
                    i2 = Character.charCount(iCodePointAt) + i9;
                }
            } else if (iCodePointAt == 43 && z2) {
                jVar.x(32);
                i2++;
            } else {
                jVar.e0(iCodePointAt);
                i2 += Character.charCount(iCodePointAt);
            }
        }
    }
}
