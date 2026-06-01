package okhttp3.internal.idn;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import k6.b;
import kotlin.jvm.internal.k;
import l7.j;
import l7.m;
import n6.t;
import r2.q;
import r4.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Punycode {
    private static final int BASE = 36;
    private static final int DAMP = 700;
    private static final int INITIAL_BIAS = 72;
    private static final int INITIAL_N = 128;
    private static final m PREFIX;
    private static final int SKEW = 38;
    private static final int TMAX = 26;
    private static final int TMIN = 1;
    public static final Punycode INSTANCE = new Punycode();
    private static final String PREFIX_STRING = "xn--";

    static {
        m mVar = m.f12880d;
        PREFIX = c.e("xn--");
    }

    private Punycode() {
    }

    private final int adapt(int i2, int i8, boolean z2) {
        int i9 = z2 ? i2 / 700 : i2 / 2;
        int i10 = (i9 / i8) + i9;
        int i11 = 0;
        while (i10 > 455) {
            i10 /= 35;
            i11 += 36;
        }
        return ((i10 * 36) / (i10 + 38)) + i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [char] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    private final List<Integer> codePoints(String str, int i2, int i8) {
        ArrayList arrayList = new ArrayList();
        while (i2 < i8) {
            int iCharAt = str.charAt(i2);
            if (55296 <= iCharAt && iCharAt < 57344) {
                int i9 = i2 + 1;
                char cCharAt = i9 < i8 ? str.charAt(i9) : (char) 0;
                if (Character.isLowSurrogate(iCharAt) || !Character.isLowSurrogate(cCharAt)) {
                    iCharAt = 63;
                } else {
                    iCharAt = 65536 + (((iCharAt & IronSourceError.ERROR_RV_SHOW_CALLED_WRONG_STATE) << 10) | (cCharAt & 1023));
                    i2 = i9;
                }
            }
            arrayList.add(Integer.valueOf(iCharAt));
            i2++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean decodeLabel(String str, int i2, int i8, j jVar) {
        int i9;
        int i10;
        int i11 = 1;
        if (!t.j0(str, i2, true, PREFIX_STRING, 0, 4)) {
            jVar.c0(i2, i8, str);
            return true;
        }
        int i12 = i2 + 4;
        ArrayList arrayList = new ArrayList();
        int iB0 = n6.m.B0(str, '-', i8, 4);
        char c7 = '0';
        char c8 = '[';
        char c9 = '{';
        if (iB0 >= i12) {
            while (i12 < iB0) {
                int i13 = i12 + 1;
                char cCharAt = str.charAt(i12);
                if (('a' > cCharAt || cCharAt >= '{') && (('A' > cCharAt || cCharAt >= '[') && (('0' > cCharAt || cCharAt >= ':') && cCharAt != '-'))) {
                    return false;
                }
                arrayList.add(Integer.valueOf(cCharAt));
                i12 = i13;
            }
            i12++;
        }
        int i14 = 128;
        int iAdapt = INITIAL_BIAS;
        int i15 = 0;
        loop1: while (i12 < i8) {
            int i16 = i11;
            b bVarW0 = q.w0(q.D0(36, Integer.MAX_VALUE), 36);
            int i17 = bVarW0.f12709a;
            int i18 = bVarW0.f12710b;
            int i19 = bVarW0.f12711c;
            if ((i19 > 0 && i17 <= i18) || (i19 < 0 && i18 <= i17)) {
                i9 = i15;
                int i20 = i16;
                while (i12 != i8) {
                    int i21 = i12 + 1;
                    char cCharAt2 = str.charAt(i12);
                    if ('a' <= cCharAt2 && cCharAt2 < c9) {
                        i10 = cCharAt2 - 'a';
                    } else if ('A' <= cCharAt2 && cCharAt2 < c8) {
                        i10 = cCharAt2 - 'A';
                    } else {
                        if (c7 > cCharAt2 || cCharAt2 >= ':') {
                            break loop1;
                        }
                        i10 = cCharAt2 - 22;
                    }
                    int i22 = i20;
                    int i23 = i10 * i22;
                    int i24 = i9;
                    if (i24 > Integer.MAX_VALUE - i23) {
                        break loop1;
                    }
                    i9 = i24 + i23;
                    int i25 = i17 <= iAdapt ? i16 : i17 >= iAdapt + 26 ? 26 : i17 - iAdapt;
                    if (i10 >= i25) {
                        int i26 = 36 - i25;
                        if (i22 > Integer.MAX_VALUE / i26) {
                            break loop1;
                        }
                        i20 = i22 * i26;
                        if (i17 != i18) {
                            i17 += i19;
                            i12 = i21;
                            c7 = '0';
                            c8 = '[';
                            c9 = '{';
                        }
                    }
                    i12 = i21;
                }
                return false;
            }
            i9 = i15;
            iAdapt = adapt(i9 - i15, arrayList.size() + 1, i15 == 0 ? i16 : false);
            int size = i9 / (arrayList.size() + 1);
            if (i14 > Integer.MAX_VALUE - size) {
                return false;
            }
            i14 += size;
            int size2 = i9 % (arrayList.size() + 1);
            if (i14 > 1114111) {
                return false;
            }
            arrayList.add(size2, Integer.valueOf(i14));
            i15 = size2 + 1;
            i11 = i16;
            c7 = '0';
            c8 = '[';
            c9 = '{';
        }
        boolean z2 = i11;
        int size3 = arrayList.size();
        int i27 = 0;
        while (i27 < size3) {
            Object obj = arrayList.get(i27);
            i27++;
            jVar.e0(((Number) obj).intValue());
        }
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean encodeLabel(String str, int i2, int i8, j jVar) {
        int i9;
        int i10;
        int i11;
        int i12 = 1;
        if (!requiresEncode(str, i2, i8)) {
            jVar.c0(i2, i8, str);
            return true;
        }
        jVar.w(PREFIX);
        List<Integer> listCodePoints = codePoints(str, i2, i8);
        Iterator<Integer> it = listCodePoints.iterator();
        int i13 = 0;
        while (true) {
            i9 = 128;
            if (!it.hasNext()) {
                break;
            }
            int iIntValue = it.next().intValue();
            if (iIntValue < 128) {
                jVar.x(iIntValue);
                i13++;
            }
        }
        if (i13 > 0) {
            jVar.x(45);
        }
        int iAdapt = INITIAL_BIAS;
        int i14 = 0;
        int i15 = i13;
        while (i15 < listCodePoints.size()) {
            Iterator<T> it2 = listCodePoints.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it2.next();
            if (it2.hasNext()) {
                int iIntValue2 = ((Number) next).intValue();
                if (iIntValue2 < i9) {
                    iIntValue2 = Integer.MAX_VALUE;
                }
                do {
                    Object next2 = it2.next();
                    int iIntValue3 = ((Number) next2).intValue();
                    if (iIntValue3 < i9) {
                        iIntValue3 = Integer.MAX_VALUE;
                    }
                    if (iIntValue2 > iIntValue3) {
                        next = next2;
                        iIntValue2 = iIntValue3;
                    }
                } while (it2.hasNext());
            }
            int iIntValue4 = ((Number) next).intValue();
            int i16 = (i15 + 1) * (iIntValue4 - i9);
            if (i14 <= Integer.MAX_VALUE - i16) {
                int i17 = i14 + i16;
                Iterator<Integer> it3 = listCodePoints.iterator();
                while (it3.hasNext()) {
                    int iIntValue5 = it3.next().intValue();
                    if (iIntValue5 < iIntValue4) {
                        if (i17 != Integer.MAX_VALUE) {
                            i17++;
                        }
                    } else if (iIntValue5 == iIntValue4) {
                        b bVarW0 = q.w0(q.D0(36, Integer.MAX_VALUE), 36);
                        int i18 = bVarW0.f12709a;
                        int i19 = bVarW0.f12710b;
                        int i20 = bVarW0.f12711c;
                        if ((i20 > 0 && i18 <= i19) || (i20 < 0 && i19 <= i18)) {
                            i11 = i17;
                            while (true) {
                                if (i18 <= iAdapt) {
                                    i10 = i12;
                                } else {
                                    i10 = i12;
                                    i12 = i18 >= iAdapt + 26 ? 26 : i18 - iAdapt;
                                }
                                if (i11 < i12) {
                                    break;
                                }
                                int i21 = i11 - i12;
                                int i22 = 36 - i12;
                                jVar.x(getPunycodeDigit((i21 % i22) + i12));
                                i11 = i21 / i22;
                                if (i18 == i19) {
                                    break;
                                }
                                i18 += i20;
                                i12 = i10;
                            }
                        } else {
                            i10 = i12;
                            i11 = i17;
                        }
                        jVar.x(getPunycodeDigit(i11));
                        int i23 = i15 + 1;
                        iAdapt = adapt(i17, i23, i15 == i13 ? i10 : false);
                        i15 = i23;
                        i17 = 0;
                        i12 = i10;
                    }
                }
                i14 = i17 + 1;
                i9 = iIntValue4 + 1;
            }
            return false;
        }
        return i12;
    }

    private final int getPunycodeDigit(int i2) {
        if (i2 < 26) {
            return i2 + 97;
        }
        if (i2 < 36) {
            return i2 + 22;
        }
        throw new IllegalStateException(("unexpected digit: " + i2).toString());
    }

    private final boolean requiresEncode(String str, int i2, int i8) {
        while (i2 < i8) {
            if (str.charAt(i2) >= 128) {
                return true;
            }
            i2++;
        }
        return false;
    }

    public final String decode(String string) {
        int iX0;
        k.e(string, "string");
        int length = string.length();
        j jVar = new j();
        for (int i2 = 0; i2 < length; i2 = iX0 + 1) {
            iX0 = n6.m.x0(string, '.', i2, 4);
            if (iX0 == -1) {
                iX0 = length;
            }
            if (!decodeLabel(string, i2, iX0, jVar)) {
                return null;
            }
            if (iX0 >= length) {
                break;
            }
            jVar.x(46);
        }
        return jVar.r();
    }

    public final String encode(String string) {
        int iX0;
        k.e(string, "string");
        int length = string.length();
        j jVar = new j();
        for (int i2 = 0; i2 < length; i2 = iX0 + 1) {
            iX0 = n6.m.x0(string, '.', i2, 4);
            if (iX0 == -1) {
                iX0 = length;
            }
            if (!encodeLabel(string, i2, iX0, jVar)) {
                return null;
            }
            if (iX0 >= length) {
                break;
            }
            jVar.x(46);
        }
        return jVar.r();
    }

    public final m getPREFIX() {
        return PREFIX;
    }

    public final String getPREFIX_STRING() {
        return PREFIX_STRING;
    }
}
