package okhttp3.internal;

import androidx.camera.core.processing.util.a;
import d7.i;
import e6.l;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.k;
import l7.b;
import l7.f0;
import l7.g0;
import l7.j;
import l7.m;
import l7.t;
import r2.q;
import r4.c;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class _UtilCommonKt {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final f0 UNICODE_BOMS;
    public static final String USER_AGENT = "okhttp/5.1.0";

    static {
        m mVar = m.f12880d;
        UNICODE_BOMS = b.f(c.d("efbbbf"), c.d("feff"), c.d("fffe0000"), c.d("fffe"), c.d("0000feff"));
    }

    public static final <E> void addIfAbsent(List<E> list, E e) {
        k.e(list, "<this>");
        if (list.contains(e)) {
            return;
        }
        list.add(e);
    }

    public static final int and(byte b8, int i2) {
        return b8 & i2;
    }

    public static final void checkOffsetAndCount(long j, long j3, long j8) {
        if ((j3 | j8) < 0 || j3 > j || j - j3 < j8) {
            StringBuilder sbT = a.t("length=", j, ", offset=");
            sbT.append(j3);
            sbT.append(", count=");
            sbT.append(j3);
            throw new ArrayIndexOutOfBoundsException(sbT.toString());
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        k.e(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] strArr, String value) {
        k.e(strArr, "<this>");
        k.e(value, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        k.d(objArrCopyOf, "copyOf(...)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[strArr2.length - 1] = value;
        return strArr2;
    }

    public static final void deleteContents(t tVar, g0 directory) {
        k.e(tVar, "<this>");
        k.e(directory, "directory");
        try {
            IOException iOException = null;
            for (g0 g0Var : tVar.list(directory)) {
                try {
                    if (tVar.metadata(g0Var).f12899b) {
                        deleteContents(tVar, g0Var);
                    }
                    tVar.delete(g0Var);
                } catch (IOException e) {
                    if (iOException == null) {
                        iOException = e;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    public static final void deleteIfExists(t tVar, g0 path) {
        k.e(tVar, "<this>");
        k.e(path, "path");
        try {
            tVar.delete(path);
        } catch (FileNotFoundException unused) {
        }
    }

    public static final int delimiterOffset(String str, String delimiters, int i2, int i8) {
        k.e(str, "<this>");
        k.e(delimiters, "delimiters");
        while (i2 < i8) {
            if (n6.m.r0(delimiters, str.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return i8;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i2, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i2 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = str.length();
        }
        return delimiterOffset(str, str2, i2, i8);
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, l predicate) {
        k.e(iterable, "<this>");
        k.e(predicate, "predicate");
        ArrayList arrayList = r.f13638a;
        for (T t3 : iterable) {
            if (((Boolean) predicate.invoke(t3)).booleanValue()) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList();
                }
                d0.b(arrayList);
                arrayList.add(t3);
            }
        }
        return arrayList;
    }

    public static final f0 getUNICODE_BOMS() {
        return UNICODE_BOMS;
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        k.e(strArr, "<this>");
        k.e(comparator, "comparator");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                i iVarG = d0.g(strArr2);
                while (iVarG.hasNext()) {
                    if (comparator.compare(str, (String) iVarG.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final void ignoreIoExceptions(e6.a block) {
        k.e(block, "block");
        try {
            block.invoke();
        } catch (IOException unused) {
        }
    }

    public static final int indexOf(String[] strArr, String value, Comparator<String> comparator) {
        k.e(strArr, "<this>");
        k.e(value, "value");
        k.e(comparator, "comparator");
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], value) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        k.e(str, "<this>");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (k.g(cCharAt, 31) <= 0 || k.g(cCharAt, 127) >= 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i2, int i8) {
        k.e(str, "<this>");
        while (i2 < i8) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i8;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i2, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i2 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i2, i8);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i2, int i8) {
        k.e(str, "<this>");
        int i9 = i8 - 1;
        if (i2 <= i9) {
            while (true) {
                char cCharAt = str.charAt(i9);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i9 + 1;
                }
                if (i9 == i2) {
                    break;
                }
                i9--;
            }
        }
        return i2;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i2, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i2 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i2, i8);
    }

    public static final int indexOfNonWhitespace(String str, int i2) {
        k.e(str, "<this>");
        int length = str.length();
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = 0;
        }
        return indexOfNonWhitespace(str, i2);
    }

    public static final <T> List<T> interleave(Iterable<? extends T> a8, Iterable<? extends T> b8) {
        k.e(a8, "a");
        k.e(b8, "b");
        Iterator<? extends T> it = a8.iterator();
        Iterator<? extends T> it2 = b8.iterator();
        s5.c cVarN = q.N();
        while (true) {
            if (!it.hasNext() && !it2.hasNext()) {
                return q.o(cVarN);
            }
            if (it.hasNext()) {
                cVarN.add(it.next());
            }
            if (it2.hasNext()) {
                cVarN.add(it2.next());
            }
        }
    }

    public static final String[] intersect(String[] strArr, String[] other, Comparator<? super String> comparator) {
        k.e(strArr, "<this>");
        k.e(other, "other");
        k.e(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = other.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (comparator.compare(str, other[i2]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i2++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isCivilized(l7.t r2, l7.g0 r3) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.k.e(r2, r0)
            java.lang.String r0 = "file"
            kotlin.jvm.internal.k.e(r3, r0)
            l7.n0 r0 = r2.sink(r3)
            r2.delete(r3)     // Catch: java.lang.Throwable -> L18 java.io.IOException -> L24
            r2 = 1
            if (r0 == 0) goto L17
            r0.close()     // Catch: java.lang.Throwable -> L17
        L17:
            return r2
        L18:
            r1 = move-exception
            if (r0 == 0) goto L2f
            r0.close()     // Catch: java.lang.Throwable -> L1f
            goto L2f
        L1f:
            r0 = move-exception
            a.a.h(r1, r0)
            goto L2f
        L24:
            if (r0 == 0) goto L2d
            r0.close()     // Catch: java.lang.Throwable -> L2a
            goto L2d
        L2a:
            r0 = move-exception
        L2b:
            r1 = r0
            goto L2f
        L2d:
            r0 = 0
            goto L2b
        L2f:
            if (r1 != 0) goto L36
            r2.delete(r3)
            r2 = 0
            return r2
        L36:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._UtilCommonKt.isCivilized(l7.t, l7.g0):boolean");
    }

    public static final boolean isSensitiveHeader(String name) {
        k.e(name, "name");
        return name.equalsIgnoreCase("Authorization") || name.equalsIgnoreCase("Cookie") || name.equalsIgnoreCase("Proxy-Authorization") || name.equalsIgnoreCase("Set-Cookie");
    }

    public static final int parseHexDigit(char c7) {
        if ('0' <= c7 && c7 < ':') {
            return c7 - '0';
        }
        if ('a' <= c7 && c7 < 'g') {
            return c7 - 'W';
        }
        if ('A' > c7 || c7 >= 'G') {
            return -1;
        }
        return c7 - '7';
    }

    public static final int readMedium(l7.l lVar) throws IOException {
        k.e(lVar, "<this>");
        return and(lVar.readByte(), 255) | (and(lVar.readByte(), 255) << 16) | (and(lVar.readByte(), 255) << 8);
    }

    public static final int skipAll(j jVar, byte b8) throws EOFException {
        k.e(jVar, "<this>");
        int i2 = 0;
        while (!jVar.M() && jVar.i(0L) == b8) {
            i2++;
            jVar.readByte();
        }
        return i2;
    }

    public static final long toLongOrDefault(String str, long j) {
        k.e(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static final int toNonNegativeInt(String str, int i2) {
        if (str != null) {
            try {
                long j = Long.parseLong(str);
                if (j > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (j < 0) {
                    return 0;
                }
                return (int) j;
            } catch (NumberFormatException unused) {
            }
        }
        return i2;
    }

    public static final String trimSubstring(String str, int i2, int i8) {
        k.e(str, "<this>");
        int iIndexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i2, i8);
        String strSubstring = str.substring(iIndexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, iIndexOfFirstNonAsciiWhitespace, i8));
        k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i2, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i2 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = str.length();
        }
        return trimSubstring(str, i2, i8);
    }

    public static final Throwable withSuppressed(Exception exc, List<? extends Exception> suppressed) {
        k.e(exc, "<this>");
        k.e(suppressed, "suppressed");
        Iterator<? extends Exception> it = suppressed.iterator();
        while (it.hasNext()) {
            a.a.h(exc, it.next());
        }
        return exc;
    }

    public static final void writeMedium(l7.k kVar, int i2) throws IOException {
        k.e(kVar, "<this>");
        kVar.writeByte((i2 >>> 16) & 255);
        kVar.writeByte((i2 >>> 8) & 255);
        kVar.writeByte(i2 & 255);
    }

    public static final int and(short s7, int i2) {
        return s7 & i2;
    }

    public static final int delimiterOffset(String str, char c7, int i2, int i8) {
        k.e(str, "<this>");
        while (i2 < i8) {
            if (str.charAt(i2) == c7) {
                return i2;
            }
            i2++;
        }
        return i8;
    }

    public static final long and(int i2, long j) {
        return j & ((long) i2);
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c7, int i2, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i2 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = str.length();
        }
        return delimiterOffset(str, c7, i2, i8);
    }
}
