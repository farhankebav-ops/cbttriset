package h7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f2.g f11742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StringBuilder f11744d;
    public final String e;

    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Serializable, java.lang.Object[]] */
    public b0(String source) {
        kotlin.jvm.internal.k.e(source, "source");
        f2.g gVar = new f2.g(1, (byte) 0);
        gVar.f11325b = new Object[8];
        int[] iArr = new int[8];
        for (int i2 = 0; i2 < 8; i2++) {
            iArr[i2] = -1;
        }
        gVar.f11327d = iArr;
        gVar.f11326c = -1;
        this.f11742b = gVar;
        this.f11744d = new StringBuilder();
        this.e = source;
    }

    public static /* synthetic */ void m(b0 b0Var, String str, int i2, String str2, int i8) {
        if ((i8 & 2) != 0) {
            i2 = b0Var.f11741a;
        }
        if ((i8 & 4) != 0) {
            str2 = "";
        }
        b0Var.l(i2, str, str2);
        throw null;
    }

    public final int a(CharSequence charSequence, int i2) {
        int i8 = i2 + 4;
        if (i8 < charSequence.length()) {
            this.f11744d.append((char) (o(charSequence, i2 + 3) + (o(charSequence, i2) << 12) + (o(charSequence, i2 + 1) << 8) + (o(charSequence, i2 + 2) << 4)));
            return i8;
        }
        this.f11741a = i2;
        if (i8 < charSequence.length()) {
            return a(charSequence, this.f11741a);
        }
        m(this, "Unexpected EOF during unicode escape", 0, null, 6);
        throw null;
    }

    public boolean b() {
        int i2 = this.f11741a;
        if (i2 == -1) {
            return false;
        }
        while (true) {
            String str = this.e;
            if (i2 >= str.length()) {
                this.f11741a = i2;
                return false;
            }
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f11741a = i2;
                return (cCharAt == ',' || cCharAt == ':' || cCharAt == ']' || cCharAt == '}') ? false : true;
            }
            i2++;
        }
    }

    public final void c(int i2, String str) {
        String str2 = this.e;
        if (str2.length() - i2 < str.length()) {
            m(this, "Unexpected end of boolean literal", 0, null, 6);
            throw null;
        }
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            if (str.charAt(i8) != (str2.charAt(i2 + i8) | ' ')) {
                m(this, "Expected valid boolean literal prefix, but had '" + j() + '\'', 0, null, 6);
                throw null;
            }
        }
        this.f11741a = str.length() + i2;
    }

    public final String d() {
        g('\"');
        int i2 = this.f11741a;
        String str = this.e;
        int iX0 = n6.m.x0(str, '\"', i2, 4);
        if (iX0 == -1) {
            j();
            n((byte) 1, false);
            throw null;
        }
        int i8 = i2;
        while (i8 < iX0) {
            if (str.charAt(i8) == '\\') {
                int iS = this.f11741a;
                char cCharAt = str.charAt(i8);
                boolean z2 = false;
                while (cCharAt != '\"') {
                    StringBuilder sb = this.f11744d;
                    if (cCharAt == '\\') {
                        sb.append((CharSequence) str, iS, i8);
                        int iS2 = s(i8 + 1);
                        if (iS2 == -1) {
                            m(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
                            throw null;
                        }
                        int iA = iS2 + 1;
                        char cCharAt2 = str.charAt(iS2);
                        if (cCharAt2 == 'u') {
                            iA = a(str, iA);
                        } else {
                            char c7 = cCharAt2 < 'u' ? f.f11756a[cCharAt2] : (char) 0;
                            if (c7 == 0) {
                                m(this, "Invalid escaped char '" + cCharAt2 + '\'', 0, null, 6);
                                throw null;
                            }
                            sb.append(c7);
                        }
                        iS = s(iA);
                        if (iS == -1) {
                            m(this, "Unexpected EOF", iS, null, 4);
                            throw null;
                        }
                    } else {
                        i8++;
                        if (i8 >= str.length()) {
                            sb.append((CharSequence) str, iS, i8);
                            iS = s(i8);
                            if (iS == -1) {
                                m(this, "Unexpected EOF", iS, null, 4);
                                throw null;
                            }
                        } else {
                            continue;
                            cCharAt = str.charAt(i8);
                        }
                    }
                    i8 = iS;
                    z2 = true;
                    cCharAt = str.charAt(i8);
                }
                String string = !z2 ? str.subSequence(iS, i8).toString() : k(iS, i8);
                this.f11741a = i8 + 1;
                return string;
            }
            i8++;
        }
        this.f11741a = iX0 + 1;
        String strSubstring = str.substring(i2, iX0);
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        r4.f11741a = r3.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        return 10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte e() {
        /*
            r4 = this;
            int r0 = r4.f11741a
        L2:
            r1 = -1
            r2 = 10
            java.lang.String r3 = r4.e
            if (r0 == r1) goto L2d
            int r1 = r3.length()
            if (r0 >= r1) goto L2d
            int r1 = r0 + 1
            char r0 = r3.charAt(r0)
            r3 = 32
            if (r0 == r3) goto L2b
            if (r0 == r2) goto L2b
            r2 = 13
            if (r0 == r2) goto L2b
            r2 = 9
            if (r0 != r2) goto L24
            goto L2b
        L24:
            r4.f11741a = r1
            byte r0 = h7.o.f(r0)
            return r0
        L2b:
            r0 = r1
            goto L2
        L2d:
            int r0 = r3.length()
            r4.f11741a = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h7.b0.e():byte");
    }

    public final byte f(byte b8) {
        byte bE = e();
        if (bE == b8) {
            return bE;
        }
        n(b8, true);
        throw null;
    }

    public void g(char c7) {
        int i2 = this.f11741a;
        if (i2 == -1) {
            v(c7);
            throw null;
        }
        while (true) {
            String str = this.e;
            if (i2 >= str.length()) {
                this.f11741a = -1;
                v(c7);
                throw null;
            }
            int i8 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f11741a = i8;
                if (cCharAt == c7) {
                    return;
                }
                v(c7);
                throw null;
            }
            i2 = i8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0180, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0187, code lost:
    
        throw new e2.s(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0188, code lost:
    
        r10 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0189, code lost:
    
        if (r14 == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x018b, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0190, code lost:
    
        if (r10 == Long.MIN_VALUE) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0193, code lost:
    
        return -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0194, code lost:
    
        m(r21, "Numeric value overflow", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0199, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x019a, code lost:
    
        m(r21, "Expected numeric literal", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x019f, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e7, code lost:
    
        m(r21, "Unexpected symbol '" + r15 + "' in numeric literal", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ff, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0102, code lost:
    
        if (r12 == r1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0104, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0106, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0107, code lost:
    
        if (r1 == r12) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0109, code lost:
    
        if (r14 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x010d, code lost:
    
        if (r1 == (r12 - 1)) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0114, code lost:
    
        if (r20 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0116, code lost:
    
        if (r3 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x011e, code lost:
    
        if (r2.charAt(r12) != '\"') goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0120, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0123, code lost:
    
        m(r21, "Expected closing quotation mark", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x012a, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x012b, code lost:
    
        m(r21, "EOF", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0130, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0131, code lost:
    
        r21.f11741a = r12;
        r1 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0135, code lost:
    
        if (r13 == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0137, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x013a, code lost:
    
        if (r11 != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x013c, code lost:
    
        r3 = java.lang.Math.pow(10.0d, -r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0144, code lost:
    
        if (r11 != true) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0146, code lost:
    
        r3 = java.lang.Math.pow(10.0d, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x014b, code lost:
    
        r1 = r1 * r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0150, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0156, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x015e, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0160, code lost:
    
        r10 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0162, code lost:
    
        m(r21, "Can't convert " + r1 + " to Long", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x017a, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x017b, code lost:
    
        m(r21, "Numeric value overflow", 0, null, 6);
     */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long h() {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h7.b0.h():long");
    }

    public final String i() {
        String str = this.f11743c;
        if (str == null) {
            return d();
        }
        kotlin.jvm.internal.k.b(str);
        this.f11743c = null;
        return str;
    }

    public final String j() {
        String str = this.f11743c;
        if (str != null) {
            kotlin.jvm.internal.k.b(str);
            this.f11743c = null;
            return str;
        }
        int iT = t();
        String str2 = this.e;
        if (iT >= str2.length() || iT == -1) {
            m(this, "EOF", iT, null, 4);
            throw null;
        }
        byte bF = o.f(str2.charAt(iT));
        if (bF == 1) {
            return i();
        }
        if (bF != 0) {
            m(this, "Expected beginning of the string, but got " + str2.charAt(iT), 0, null, 6);
            throw null;
        }
        boolean z2 = false;
        while (o.f(str2.charAt(iT)) == 0) {
            iT++;
            if (iT >= str2.length()) {
                this.f11744d.append((CharSequence) str2, this.f11741a, iT);
                int iS = s(iT);
                if (iS == -1) {
                    this.f11741a = iT;
                    return k(0, 0);
                }
                iT = iS;
                z2 = true;
            }
        }
        String string = !z2 ? str2.subSequence(this.f11741a, iT).toString() : k(this.f11741a, iT);
        this.f11741a = iT;
        return string;
    }

    public final String k(int i2, int i8) {
        String str = this.e;
        StringBuilder sb = this.f11744d;
        sb.append((CharSequence) str, i2, i8);
        String string = sb.toString();
        kotlin.jvm.internal.k.d(string, "toString(...)");
        sb.setLength(0);
        return string;
    }

    public final void l(int i2, String message, String hint) {
        kotlin.jvm.internal.k.e(message, "message");
        kotlin.jvm.internal.k.e(hint, "hint");
        String strConcat = hint.length() == 0 ? "" : "\n".concat(hint);
        StringBuilder sbX = a1.a.x(message, " at path: ");
        sbX.append(this.f11742b.b());
        sbX.append(strConcat);
        throw o.d(sbX.toString(), this.e, i2);
    }

    public final void n(byte b8, boolean z2) {
        String strR = o.r(b8);
        int i2 = z2 ? this.f11741a - 1 : this.f11741a;
        int i8 = this.f11741a;
        String str = this.e;
        m(this, a1.a.o("Expected ", strR, ", but had '", (i8 == str.length() || i2 < 0) ? "EOF" : String.valueOf(str.charAt(i2)), "' instead"), i2, null, 4);
        throw null;
    }

    public final int o(CharSequence charSequence, int i2) {
        char cCharAt = charSequence.charAt(i2);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        m(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6);
        throw null;
    }

    public final String p(String keyToMatch) {
        kotlin.jvm.internal.k.e(keyToMatch, "keyToMatch");
        int i2 = this.f11741a;
        try {
            if (e() == 6 && kotlin.jvm.internal.k.a(r(), keyToMatch)) {
                this.f11743c = null;
                if (e() == 5) {
                    return r();
                }
            }
            return null;
        } finally {
            this.f11741a = i2;
            this.f11743c = null;
        }
    }

    public byte q() {
        int i2 = this.f11741a;
        while (true) {
            int iS = s(i2);
            if (iS == -1) {
                this.f11741a = iS;
                return (byte) 10;
            }
            char cCharAt = this.e.charAt(iS);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.f11741a = iS;
                return o.f(cCharAt);
            }
            i2 = iS + 1;
        }
    }

    public final String r() {
        if (q() != 1) {
            return null;
        }
        String strI = i();
        this.f11743c = strI;
        return strI;
    }

    public final int s(int i2) {
        if (i2 < this.e.length()) {
            return i2;
        }
        return -1;
    }

    public int t() {
        char cCharAt;
        int i2 = this.f11741a;
        if (i2 == -1) {
            return i2;
        }
        while (true) {
            String str = this.e;
            if (i2 >= str.length() || !((cCharAt = str.charAt(i2)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
                break;
            }
            i2++;
        }
        this.f11741a = i2;
        return i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("JsonReader(source='");
        sb.append((Object) this.e);
        sb.append("', currentPosition=");
        return com.ironsource.adqualitysdk.sdk.i.a0.c(sb, this.f11741a, ')');
    }

    public final boolean u() {
        int iT = t();
        String str = this.e;
        if (iT >= str.length() || iT == -1 || str.charAt(iT) != ',') {
            return false;
        }
        this.f11741a++;
        return true;
    }

    public final void v(char c7) {
        int i2 = this.f11741a;
        if (i2 > 0 && c7 == '\"') {
            try {
                this.f11741a = i2 - 1;
                String strJ = j();
                this.f11741a = i2;
                if (kotlin.jvm.internal.k.a(strJ, "null")) {
                    l(this.f11741a - 1, "Expected string literal but 'null' literal was found", "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw null;
                }
            } catch (Throwable th) {
                this.f11741a = i2;
                throw th;
            }
        }
        n(o.f(c7), true);
        throw null;
    }
}
