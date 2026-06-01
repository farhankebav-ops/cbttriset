package n6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class m extends t {
    public static boolean A0(String str) {
        kotlin.jvm.internal.k.e(str, "<this>");
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (!n7.b.A(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static int B0(String str, char c7, int i2, int i8) {
        if ((i8 & 2) != 0) {
            i2 = u0(str);
        }
        kotlin.jvm.internal.k.e(str, "<this>");
        return str.lastIndexOf(c7, i2);
    }

    public static int C0(String string, CharSequence charSequence, int i2) {
        int iU0 = (i2 & 2) != 0 ? u0(charSequence) : 0;
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(string, "string");
        return !(charSequence instanceof String) ? w0(charSequence, string, iU0, 0, false, true) : ((String) charSequence).lastIndexOf(string, iU0);
    }

    public static String D0(int i2, String str) {
        CharSequence charSequenceSubSequence;
        kotlin.jvm.internal.k.e(str, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.h(i2, "Desired length ", " is less than zero."));
        }
        if (i2 <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(i2);
            int length = i2 - str.length();
            int i8 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append('0');
                    if (i8 == length) {
                        break;
                    }
                    i8++;
                }
            }
            sb.append((CharSequence) str);
            charSequenceSubSequence = sb;
        }
        return charSequenceSubSequence.toString();
    }

    public static final boolean E0(CharSequence charSequence, int i2, CharSequence other, int i8, int i9, boolean z2) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        if (i8 < 0 || i2 < 0 || i2 > charSequence.length() - i9 || i8 > other.length() - i9) {
            return false;
        }
        for (int i10 = 0; i10 < i9; i10++) {
            if (!n7.b.o(charSequence.charAt(i2 + i10), other.charAt(i8 + i10), z2)) {
                return false;
            }
        }
        return true;
    }

    public static String F0(String str, String str2) {
        kotlin.jvm.internal.k.e(str, "<this>");
        if (!t.n0(str, str2, false)) {
            return str;
        }
        String strSubstring = str.substring(str2.length());
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String G0(String str, String str2) {
        kotlin.jvm.internal.k.e(str, "<this>");
        if (!t.f0(str, str2, false)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - str2.length());
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final void H0(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.g(i2, "Limit must be non-negative, but was ").toString());
        }
    }

    public static final List I0(String str, CharSequence charSequence, int i2) {
        H0(i2);
        int iV0 = v0(charSequence, str, 0, false);
        if (iV0 == -1 || i2 == 1) {
            return r2.q.j0(charSequence.toString());
        }
        boolean z2 = i2 > 0;
        int i8 = 10;
        if (z2 && i2 <= 10) {
            i8 = i2;
        }
        ArrayList arrayList = new ArrayList(i8);
        int length = 0;
        do {
            arrayList.add(charSequence.subSequence(length, iV0).toString());
            length = str.length() + iV0;
            if (z2 && arrayList.size() == i2 - 1) {
                break;
            }
            iV0 = v0(charSequence, str, length, false);
        } while (iV0 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List J0(String str, char[] cArr) {
        kotlin.jvm.internal.k.e(str, "<this>");
        if (cArr.length == 1) {
            return I0(String.valueOf(cArr[0]), str, 0);
        }
        H0(0);
        d7.j jVar = new d7.j(new c(str, 0, new u(cArr, 0)), 1);
        ArrayList arrayList = new ArrayList(r5.n.L0(jVar, 10));
        Iterator it = jVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList;
            }
            k6.d range = (k6.d) bVar.next();
            kotlin.jvm.internal.k.e(range, "range");
            arrayList.add(str.subSequence(range.f12709a, range.f12710b + 1).toString());
        }
    }

    public static List K0(String str, String[] strArr, int i2) {
        int i8 = (i2 & 4) != 0 ? 0 : 2;
        kotlin.jvm.internal.k.e(str, "<this>");
        if (strArr.length == 1) {
            String str2 = strArr[0];
            if (str2.length() != 0) {
                return I0(str2, str, i8);
            }
        }
        H0(i8);
        d7.j jVar = new d7.j(new c(str, i8, new u(r5.j.X(strArr), 1)), 1);
        ArrayList arrayList = new ArrayList(r5.n.L0(jVar, 10));
        Iterator it = jVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList;
            }
            k6.d range = (k6.d) bVar.next();
            kotlin.jvm.internal.k.e(range, "range");
            arrayList.add(str.subSequence(range.f12709a, range.f12710b + 1).toString());
        }
    }

    public static boolean L0(String str, char c7) {
        return str.length() > 0 && n7.b.o(str.charAt(0), c7, false);
    }

    public static String M0(char c7, String str, String str2) {
        int iX0 = x0(str, c7, 0, 6);
        if (iX0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iX0 + 1, str.length());
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String N0(String str, String delimiter) {
        kotlin.jvm.internal.k.e(delimiter, "delimiter");
        int iY0 = y0(str, delimiter, 0, false, 6);
        if (iY0 == -1) {
            return str;
        }
        String strSubstring = str.substring(delimiter.length() + iY0, str.length());
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String O0(char c7, String str, String str2) {
        int iB0 = B0(str, c7, 0, 6);
        if (iB0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iB0 + 1, str.length());
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String P0(String missingDelimiterValue, String str) {
        kotlin.jvm.internal.k.e(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int iC0 = C0(str, missingDelimiterValue, 6);
        if (iC0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(str.length() + iC0, missingDelimiterValue.length());
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String Q0(String missingDelimiterValue, char c7) {
        kotlin.jvm.internal.k.e(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int iX0 = x0(missingDelimiterValue, c7, 0, 6);
        if (iX0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(0, iX0);
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String R0(String missingDelimiterValue, String str) {
        kotlin.jvm.internal.k.e(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int iC0 = C0(str, missingDelimiterValue, 6);
        if (iC0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(0, iC0);
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String S0(int i2, String str) {
        kotlin.jvm.internal.k.e(str, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.h(i2, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i2 > length) {
            i2 = length;
        }
        String strSubstring = str.substring(0, i2);
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence T0(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            boolean zA = n7.b.A(charSequence.charAt(!z2 ? i2 : length));
            if (z2) {
                if (!zA) {
                    break;
                }
                length--;
            } else if (zA) {
                i2++;
            } else {
                z2 = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static String U0(String str, char... cArr) {
        kotlin.jvm.internal.k.e(str, "<this>");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            char cCharAt = str.charAt(!z2 ? i2 : length);
            int length2 = cArr.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length2) {
                    i8 = -1;
                    break;
                }
                if (cCharAt == cArr[i8]) {
                    break;
                }
                i8++;
            }
            boolean z7 = i8 >= 0;
            if (z2) {
                if (!z7) {
                    break;
                }
                length--;
            } else if (z7) {
                i2++;
            } else {
                z2 = true;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    public static boolean q0(CharSequence charSequence, CharSequence other, boolean z2) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        if (other instanceof String) {
            if (y0(charSequence, (String) other, 0, z2, 2) >= 0) {
                return true;
            }
        } else if (w0(charSequence, other, 0, charSequence.length(), z2, false) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean r0(CharSequence charSequence, char c7) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return x0(charSequence, c7, 0, 2) >= 0;
    }

    public static String s0(int i2, String str) {
        kotlin.jvm.internal.k.e(str, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.h(i2, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i2 > length) {
            i2 = length;
        }
        String strSubstring = str.substring(i2);
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static boolean t0(String str, char c7) {
        return str.length() > 0 && n7.b.o(str.charAt(u0(str)), c7, false);
    }

    public static final int u0(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int v0(CharSequence charSequence, String string, int i2, boolean z2) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(string, "string");
        return (z2 || !(charSequence instanceof String)) ? w0(charSequence, string, i2, charSequence.length(), z2, false) : ((String) charSequence).indexOf(string, i2);
    }

    public static final int w0(CharSequence charSequence, CharSequence charSequence2, int i2, int i8, boolean z2, boolean z7) {
        k6.b bVar;
        CharSequence charSequence3 = charSequence2;
        int i9 = i2;
        int i10 = i8;
        if (z7) {
            int iU0 = u0(charSequence);
            if (i9 > iU0) {
                i9 = iU0;
            }
            if (i10 < 0) {
                i10 = 0;
            }
            bVar = new k6.b(i9, i10, -1);
        } else {
            if (i9 < 0) {
                i9 = 0;
            }
            int length = charSequence.length();
            if (i10 > length) {
                i10 = length;
            }
            bVar = new k6.d(i9, i10, 1);
        }
        boolean z8 = charSequence instanceof String;
        int i11 = bVar.f12711c;
        int i12 = bVar.f12710b;
        int i13 = bVar.f12709a;
        if (z8 && (charSequence3 instanceof String)) {
            if ((i11 > 0 && i13 <= i12) || (i11 < 0 && i12 <= i13)) {
                int i14 = i13;
                while (true) {
                    String str = (String) charSequence3;
                    if (!t.j0(str, 0, z2, (String) charSequence, i14, str.length())) {
                        if (i14 == i12) {
                            break;
                        }
                        i14 += i11;
                    } else {
                        return i14;
                    }
                }
            }
        } else if ((i11 > 0 && i13 <= i12) || (i11 < 0 && i12 <= i13)) {
            int i15 = i13;
            while (!E0(charSequence3, 0, charSequence, i15, charSequence3.length(), z2)) {
                if (i15 != i12) {
                    i15 += i11;
                    charSequence3 = charSequence2;
                }
            }
            return i15;
        }
        return -1;
    }

    public static int x0(CharSequence charSequence, char c7, int i2, int i8) {
        if ((i8 & 2) != 0) {
            i2 = 0;
        }
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return !(charSequence instanceof String) ? z0(charSequence, new char[]{c7}, i2, false) : ((String) charSequence).indexOf(c7, i2);
    }

    public static /* synthetic */ int y0(CharSequence charSequence, String str, int i2, boolean z2, int i8) {
        if ((i8 & 2) != 0) {
            i2 = 0;
        }
        if ((i8 & 4) != 0) {
            z2 = false;
        }
        return v0(charSequence, str, i2, z2);
    }

    public static final int z0(CharSequence charSequence, char[] cArr, int i2, boolean z2) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        if (!z2 && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length != 1) {
                throw new IllegalArgumentException("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(cArr[0], i2);
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int iU0 = u0(charSequence);
        if (i2 > iU0) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i2);
            for (char c7 : cArr) {
                if (n7.b.o(c7, cCharAt, z2)) {
                    return i2;
                }
            }
            if (i2 == iU0) {
                return -1;
            }
            i2++;
        }
    }
}
