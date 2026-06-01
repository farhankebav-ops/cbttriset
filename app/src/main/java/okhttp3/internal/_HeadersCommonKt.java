package okhttp3.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.k;
import n6.m;
import n7.b;
import okhttp3.Headers;
import q5.i;
import r5.j;
import r5.l;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class _HeadersCommonKt {
    private static final String charCode(char c7) {
        b.i(16);
        String string = Integer.toString(c7, 16);
        k.d(string, "toString(...)");
        return string.length() < 2 ? "0".concat(string) : string;
    }

    public static final Headers.Builder commonAdd(Headers.Builder builder, String name, String value) {
        k.e(builder, "<this>");
        k.e(name, "name");
        k.e(value, "value");
        headersCheckName(name);
        headersCheckValue(value, name);
        commonAddLenient(builder, name, value);
        return builder;
    }

    public static final Headers.Builder commonAddAll(Headers.Builder builder, Headers headers) {
        k.e(builder, "<this>");
        k.e(headers, "headers");
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            commonAddLenient(builder, headers.name(i2), headers.value(i2));
        }
        return builder;
    }

    public static final Headers.Builder commonAddLenient(Headers.Builder builder, String name, String value) {
        k.e(builder, "<this>");
        k.e(name, "name");
        k.e(value, "value");
        builder.getNamesAndValues$okhttp().add(name);
        builder.getNamesAndValues$okhttp().add(m.T0(value).toString());
        return builder;
    }

    public static final Headers commonBuild(Headers.Builder builder) {
        k.e(builder, "<this>");
        return new Headers((String[]) builder.getNamesAndValues$okhttp().toArray(new String[0]));
    }

    public static final boolean commonEquals(Headers headers, Object obj) {
        k.e(headers, "<this>");
        return (obj instanceof Headers) && Arrays.equals(headers.getNamesAndValues$okhttp(), ((Headers) obj).getNamesAndValues$okhttp());
    }

    public static final String commonGet(Headers.Builder builder, String name) {
        k.e(builder, "<this>");
        k.e(name, "name");
        int size = builder.getNamesAndValues$okhttp().size() - 2;
        int iA = z5.b.a(size, 0, -2);
        if (iA > size) {
            return null;
        }
        while (!name.equalsIgnoreCase(builder.getNamesAndValues$okhttp().get(size))) {
            if (size == iA) {
                return null;
            }
            size -= 2;
        }
        return builder.getNamesAndValues$okhttp().get(size + 1);
    }

    public static final int commonHashCode(Headers headers) {
        k.e(headers, "<this>");
        return Arrays.hashCode(headers.getNamesAndValues$okhttp());
    }

    public static final String commonHeadersGet(String[] namesAndValues, String name) {
        k.e(namesAndValues, "namesAndValues");
        k.e(name, "name");
        int length = namesAndValues.length - 2;
        int iA = z5.b.a(length, 0, -2);
        if (iA > length) {
            return null;
        }
        while (!name.equalsIgnoreCase(namesAndValues[length])) {
            if (length == iA) {
                return null;
            }
            length -= 2;
        }
        return namesAndValues[length + 1];
    }

    public static final Headers commonHeadersOf(String... inputNamesAndValues) {
        k.e(inputNamesAndValues, "inputNamesAndValues");
        if (inputNamesAndValues.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr = (String[]) Arrays.copyOf(inputNamesAndValues, inputNamesAndValues.length);
        int length = strArr.length;
        int i2 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            if (strArr[i8] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr[i8] = m.T0(inputNamesAndValues[i8]).toString();
        }
        int iA = z5.b.a(0, strArr.length - 1, 2);
        if (iA >= 0) {
            while (true) {
                String str = strArr[i2];
                String str2 = strArr[i2 + 1];
                headersCheckName(str);
                headersCheckValue(str2, str);
                if (i2 == iA) {
                    break;
                }
                i2 += 2;
            }
        }
        return new Headers(strArr);
    }

    public static final Iterator<i> commonIterator(Headers headers) {
        k.e(headers, "<this>");
        int size = headers.size();
        i[] iVarArr = new i[size];
        for (int i2 = 0; i2 < size; i2++) {
            iVarArr[i2] = new i(headers.name(i2), headers.value(i2));
        }
        return d0.g(iVarArr);
    }

    public static final String commonName(Headers headers, int i2) {
        k.e(headers, "<this>");
        String str = (String) j.p0(i2 * 2, headers.getNamesAndValues$okhttp());
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i2 + ']');
    }

    public static final Headers.Builder commonNewBuilder(Headers headers) {
        k.e(headers, "<this>");
        Headers.Builder builder = new Headers.Builder();
        l.R0(builder.getNamesAndValues$okhttp(), headers.getNamesAndValues$okhttp());
        return builder;
    }

    public static final Headers.Builder commonRemoveAll(Headers.Builder builder, String name) {
        k.e(builder, "<this>");
        k.e(name, "name");
        int i2 = 0;
        while (i2 < builder.getNamesAndValues$okhttp().size()) {
            if (name.equalsIgnoreCase(builder.getNamesAndValues$okhttp().get(i2))) {
                builder.getNamesAndValues$okhttp().remove(i2);
                builder.getNamesAndValues$okhttp().remove(i2);
                i2 -= 2;
            }
            i2 += 2;
        }
        return builder;
    }

    public static final Headers.Builder commonSet(Headers.Builder builder, String name, String value) {
        k.e(builder, "<this>");
        k.e(name, "name");
        k.e(value, "value");
        headersCheckName(name);
        headersCheckValue(value, name);
        builder.removeAll(name);
        commonAddLenient(builder, name, value);
        return builder;
    }

    public static final Headers commonToHeaders(Map<String, String> map) {
        k.e(map, "<this>");
        String[] strArr = new String[map.size() * 2];
        int i2 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String string = m.T0(key).toString();
            String string2 = m.T0(value).toString();
            headersCheckName(string);
            headersCheckValue(string2, string);
            strArr[i2] = string;
            strArr[i2 + 1] = string2;
            i2 += 2;
        }
        return new Headers(strArr);
    }

    public static final String commonToString(Headers headers) {
        k.e(headers, "<this>");
        StringBuilder sb = new StringBuilder();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strName = headers.name(i2);
            String strValue = headers.value(i2);
            sb.append(strName);
            sb.append(": ");
            if (_UtilCommonKt.isSensitiveHeader(strName)) {
                strValue = "██";
            }
            sb.append(strValue);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static final String commonValue(Headers headers, int i2) {
        k.e(headers, "<this>");
        String str = (String) j.p0((i2 * 2) + 1, headers.getNamesAndValues$okhttp());
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i2 + ']');
    }

    public static final List<String> commonValues(Headers headers, String name) {
        k.e(headers, "<this>");
        k.e(name, "name");
        int size = headers.size();
        List<String> listUnmodifiableList = null;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            if (name.equalsIgnoreCase(headers.name(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(headers.value(i2));
            }
        }
        if (arrayList != null) {
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
            k.d(listUnmodifiableList, "unmodifiableList(...)");
        }
        return listUnmodifiableList == null ? r.f13638a : listUnmodifiableList;
    }

    public static final void headersCheckName(String name) {
        k.e(name, "name");
        if (name.length() <= 0) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = name.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = name.charAt(i2);
            if ('!' > cCharAt || cCharAt >= 127) {
                throw new IllegalArgumentException(("Unexpected char 0x" + charCode(cCharAt) + " at " + i2 + " in header name: " + name).toString());
            }
        }
    }

    public static final void headersCheckValue(String value, String name) {
        k.e(value, "value");
        k.e(name, "name");
        int length = value.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = value.charAt(i2);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                StringBuilder sb = new StringBuilder("Unexpected char 0x");
                sb.append(charCode(cCharAt));
                sb.append(" at ");
                sb.append(i2);
                sb.append(" in ");
                sb.append(name);
                sb.append(" value");
                sb.append(_UtilCommonKt.isSensitiveHeader(name) ? "" : ": ".concat(value));
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }
}
