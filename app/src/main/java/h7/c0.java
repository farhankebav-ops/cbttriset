package h7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f11746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f11747b;

    static {
        String[] strArr = new String[93];
        for (int i2 = 0; i2 < 32; i2++) {
            strArr[i2] = "\\u" + b(i2 >> 12) + b(i2 >> 8) + b(i2 >> 4) + b(i2);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f11746a = strArr;
        byte[] bArr = new byte[93];
        for (int i8 = 0; i8 < 32; i8++) {
            bArr[i8] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        f11747b = bArr;
    }

    public static final void a(StringBuilder sb, String value) {
        kotlin.jvm.internal.k.e(value, "value");
        sb.append('\"');
        int length = value.length();
        int i2 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = value.charAt(i8);
            String[] strArr = f11746a;
            if (cCharAt < strArr.length && strArr[cCharAt] != null) {
                sb.append((CharSequence) value, i2, i8);
                sb.append(strArr[cCharAt]);
                i2 = i8 + 1;
            }
        }
        if (i2 != 0) {
            sb.append((CharSequence) value, i2, value.length());
        } else {
            sb.append(value);
        }
        sb.append('\"');
    }

    public static final char b(int i2) {
        int i8 = i2 & 15;
        return (char) (i8 < 10 ? i8 + 48 : i8 + 87);
    }
}
