package com.bykv.vk.openvk.preload.a.d;

import com.bykv.vk.openvk.preload.a.b.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Reader f4846b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f4850i;
    private int j;
    private String k;
    private int[] l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String[] f4851n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int[] f4852o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4847c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final char[] f4848d = new char[1024];
    private int e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4849f = 0;
    private int g = 0;
    private int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f4845a = 0;
    private int m = 1;

    static {
        e.f4810a = new e() { // from class: com.bykv.vk.openvk.preload.a.d.a.1
            @Override // com.bykv.vk.openvk.preload.a.b.e
            public final void a(a aVar) throws IOException {
                if (aVar instanceof com.bykv.vk.openvk.preload.a.b.a.e) {
                    throw null;
                }
                int iQ = aVar.f4845a;
                if (iQ == 0) {
                    iQ = aVar.q();
                }
                if (iQ == 13) {
                    aVar.f4845a = 9;
                    return;
                }
                if (iQ == 12) {
                    aVar.f4845a = 8;
                } else {
                    if (iQ == 14) {
                        aVar.f4845a = 10;
                        return;
                    }
                    throw new IllegalStateException("Expected a name but was " + aVar.f() + aVar.r());
                }
            }
        };
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.l = iArr;
        iArr[0] = 6;
        this.f4851n = new String[32];
        this.f4852o = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f4846b = reader;
    }

    private int s() throws IOException {
        String str;
        String str2;
        int i2;
        char c7 = this.f4848d[this.e];
        if (c7 == 't' || c7 == 'T') {
            str = com.ironsource.mediationsdk.metadata.a.g;
            str2 = "TRUE";
            i2 = 5;
        } else if (c7 == 'f' || c7 == 'F') {
            str = "false";
            str2 = "FALSE";
            i2 = 6;
        } else {
            if (c7 != 'n' && c7 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i2 = 7;
        }
        int length = str.length();
        for (int i8 = 1; i8 < length; i8++) {
            if (this.e + i8 >= this.f4849f && !b(i8 + 1)) {
                return 0;
            }
            char c8 = this.f4848d[this.e + i8];
            if (c8 != str.charAt(i8) && c8 != str2.charAt(i8)) {
                return 0;
            }
        }
        if ((this.e + length < this.f4849f || b(length + 1)) && a(this.f4848d[this.e + length])) {
            return 0;
        }
        this.e += length;
        this.f4845a = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0094, code lost:
    
        if (a(r14) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0096, code lost:
    
        return r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0097, code lost:
    
        if (r9 != 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0099, code lost:
    
        if (r10 == 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009f, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a1, code lost:
    
        if (r13 == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a5, code lost:
    
        if (r11 != 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a7, code lost:
    
        if (r13 != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a9, code lost:
    
        if (r13 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ac, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ad, code lost:
    
        r19.f4850i = r11;
        r19.e += r8;
        r19.f4845a = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b8, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b9, code lost:
    
        if (r9 == 2) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00bc, code lost:
    
        if (r9 == 4) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00bf, code lost:
    
        if (r9 != 7) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c2, code lost:
    
        return r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c3, code lost:
    
        r19.j = r8;
        r19.f4845a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c9, code lost:
    
        return 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int t() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.d.a.t():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        v();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String u() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.e
            int r4 = r3 + r2
            int r5 = r6.f4849f
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f4848d
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.v()
            goto L5c
        L4e:
            char[] r3 = r6.f4848d
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.b(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r1 = r2
            goto L7e
        L5e:
            if (r0 != 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L6b:
            char[] r3 = r6.f4848d
            int r4 = r6.e
            r0.append(r3, r4, r2)
            int r3 = r6.e
            int r3 = r3 + r2
            r6.e = r3
            r2 = 1
            boolean r2 = r6.b(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f4848d
            int r3 = r6.e
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f4848d
            int r3 = r6.e
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.e
            int r2 = r2 + r1
            r6.e = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.d.a.u():java.lang.String");
    }

    private void v() throws IOException {
        if (!this.f4847c) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void w() throws IOException {
        char c7;
        do {
            if (this.e >= this.f4849f && !b(1)) {
                return;
            }
            char[] cArr = this.f4848d;
            int i2 = this.e;
            int i8 = i2 + 1;
            this.e = i8;
            c7 = cArr[i2];
            if (c7 == '\n') {
                this.g++;
                this.h = i8;
                return;
            }
        } while (c7 != '\r');
    }

    private char x() throws IOException {
        int i2;
        if (this.e == this.f4849f && !b(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.f4848d;
        int i8 = this.e;
        int i9 = i8 + 1;
        this.e = i9;
        char c7 = cArr[i8];
        if (c7 == '\n') {
            this.g++;
            this.h = i9;
            return c7;
        }
        if (c7 == '\"' || c7 == '\'' || c7 == '/' || c7 == '\\') {
            return c7;
        }
        if (c7 == 'b') {
            return '\b';
        }
        if (c7 == 'f') {
            return '\f';
        }
        if (c7 == 'n') {
            return '\n';
        }
        if (c7 == 'r') {
            return '\r';
        }
        if (c7 == 't') {
            return '\t';
        }
        if (c7 != 'u') {
            throw b("Invalid escape sequence");
        }
        if (i8 + 5 > this.f4849f && !b(4)) {
            throw b("Unterminated escape sequence");
        }
        int i10 = this.e;
        int i11 = i10 + 4;
        char c8 = 0;
        while (i10 < i11) {
            char c9 = this.f4848d[i10];
            char c10 = (char) (c8 << 4);
            if (c9 >= '0' && c9 <= '9') {
                i2 = c9 - '0';
            } else if (c9 >= 'a' && c9 <= 'f') {
                i2 = c9 - 'W';
            } else {
                if (c9 < 'A' || c9 > 'F') {
                    throw new NumberFormatException("\\u".concat(new String(this.f4848d, this.e, 4)));
                }
                i2 = c9 - '7';
            }
            c8 = (char) (i2 + c10);
            i10++;
        }
        this.e += 4;
        return c8;
    }

    private void y() throws IOException {
        b(true);
        int i2 = this.e;
        int i8 = i2 - 1;
        this.e = i8;
        if (i2 + 4 <= this.f4849f || b(5)) {
            char[] cArr = this.f4848d;
            if (cArr[i8] == ')' && cArr[i2] == ']' && cArr[i2 + 1] == '}' && cArr[i2 + 2] == '\'' && cArr[i2 + 3] == '\n') {
                this.e += 5;
            }
        }
    }

    public final void a(boolean z2) {
        this.f4847c = z2;
    }

    public void b() throws IOException {
        int iQ = this.f4845a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + f() + r());
        }
        int i2 = this.m;
        this.m = i2 - 1;
        int[] iArr = this.f4852o;
        int i8 = i2 - 2;
        iArr[i8] = iArr[i8] + 1;
        this.f4845a = 0;
    }

    public void c() throws IOException {
        int iQ = this.f4845a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 1) {
            a(3);
            this.f4845a = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + r());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4845a = 0;
        this.l[0] = 8;
        this.m = 1;
        this.f4846b.close();
    }

    public void d() throws IOException {
        int iQ = this.f4845a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + f() + r());
        }
        int i2 = this.m;
        int i8 = i2 - 1;
        this.m = i8;
        this.f4851n[i8] = null;
        int[] iArr = this.f4852o;
        int i9 = i2 - 2;
        iArr[i9] = iArr[i9] + 1;
        this.f4845a = 0;
    }

    public boolean e() throws IOException {
        int iQ = this.f4845a;
        if (iQ == 0) {
            iQ = q();
        }
        return (iQ == 2 || iQ == 4) ? false : true;
    }

    public b f() throws IOException {
        int iQ = this.f4845a;
        if (iQ == 0) {
            iQ = q();
        }
        switch (iQ) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String g() throws IOException {
        String strB;
        int iQ = this.f4845a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 14) {
            strB = u();
        } else if (iQ == 12) {
            strB = b('\'');
        } else {
            if (iQ != 13) {
                throw new IllegalStateException("Expected a name but was " + f() + r());
            }
            strB = b('\"');
        }
        this.f4845a = 0;
        this.f4851n[this.m - 1] = strB;
        return strB;
    }

    public String h() throws IOException {
        String str;
        int iQ = this.f4845a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 10) {
            str = u();
        } else if (iQ == 8) {
            str = b('\'');
        } else if (iQ == 9) {
            str = b('\"');
        } else if (iQ == 11) {
            str = this.k;
            this.k = null;
        } else if (iQ == 15) {
            str = Long.toString(this.f4850i);
        } else {
            if (iQ != 16) {
                throw new IllegalStateException("Expected a string but was " + f() + r());
            }
            str = new String(this.f4848d, this.e, this.j);
            this.e += this.j;
        }
        this.f4845a = 0;
        int[] iArr = this.f4852o;
        int i2 = this.m - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean i() throws IOException {
        int iQ = this.f4845a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 5) {
            this.f4845a = 0;
            int[] iArr = this.f4852o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iQ != 6) {
            throw new IllegalStateException("Expected a boolean but was " + f() + r());
        }
        this.f4845a = 0;
        int[] iArr2 = this.f4852o;
        int i8 = this.m - 1;
        iArr2[i8] = iArr2[i8] + 1;
        return false;
    }

    public void j() throws IOException {
        int iQ = this.f4845a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ != 7) {
            throw new IllegalStateException("Expected null but was " + f() + r());
        }
        this.f4845a = 0;
        int[] iArr = this.f4852o;
        int i2 = this.m - 1;
        iArr[i2] = iArr[i2] + 1;
    }

    public double k() throws IOException {
        int iQ = this.f4845a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 15) {
            this.f4845a = 0;
            int[] iArr = this.f4852o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f4850i;
        }
        if (iQ == 16) {
            this.k = new String(this.f4848d, this.e, this.j);
            this.e += this.j;
        } else if (iQ == 8 || iQ == 9) {
            this.k = b(iQ == 8 ? '\'' : '\"');
        } else if (iQ == 10) {
            this.k = u();
        } else if (iQ != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + r());
        }
        this.f4845a = 11;
        double d8 = Double.parseDouble(this.k);
        if (!this.f4847c && (Double.isNaN(d8) || Double.isInfinite(d8))) {
            throw new d("JSON forbids NaN and infinities: " + d8 + r());
        }
        this.k = null;
        this.f4845a = 0;
        int[] iArr2 = this.f4852o;
        int i8 = this.m - 1;
        iArr2[i8] = iArr2[i8] + 1;
        return d8;
    }

    public long l() throws IOException {
        int iQ = this.f4845a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 15) {
            this.f4845a = 0;
            int[] iArr = this.f4852o;
            int i2 = this.m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f4850i;
        }
        if (iQ == 16) {
            this.k = new String(this.f4848d, this.e, this.j);
            this.e += this.j;
        } else {
            if (iQ != 8 && iQ != 9 && iQ != 10) {
                throw new IllegalStateException("Expected a long but was " + f() + r());
            }
            if (iQ == 10) {
                this.k = u();
            } else {
                this.k = b(iQ == 8 ? '\'' : '\"');
            }
            try {
                long j = Long.parseLong(this.k);
                this.f4845a = 0;
                int[] iArr2 = this.f4852o;
                int i8 = this.m - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        }
        this.f4845a = 11;
        double d8 = Double.parseDouble(this.k);
        long j3 = (long) d8;
        if (j3 != d8) {
            throw new NumberFormatException("Expected a long but was " + this.k + r());
        }
        this.k = null;
        this.f4845a = 0;
        int[] iArr3 = this.f4852o;
        int i9 = this.m - 1;
        iArr3[i9] = iArr3[i9] + 1;
        return j3;
    }

    public int m() throws IOException {
        int iQ = this.f4845a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 15) {
            long j = this.f4850i;
            int i2 = (int) j;
            if (j != i2) {
                throw new NumberFormatException("Expected an int but was " + this.f4850i + r());
            }
            this.f4845a = 0;
            int[] iArr = this.f4852o;
            int i8 = this.m - 1;
            iArr[i8] = iArr[i8] + 1;
            return i2;
        }
        if (iQ == 16) {
            this.k = new String(this.f4848d, this.e, this.j);
            this.e += this.j;
        } else {
            if (iQ != 8 && iQ != 9 && iQ != 10) {
                throw new IllegalStateException("Expected an int but was " + f() + r());
            }
            if (iQ == 10) {
                this.k = u();
            } else {
                this.k = b(iQ == 8 ? '\'' : '\"');
            }
            try {
                int i9 = Integer.parseInt(this.k);
                this.f4845a = 0;
                int[] iArr2 = this.f4852o;
                int i10 = this.m - 1;
                iArr2[i10] = iArr2[i10] + 1;
                return i9;
            } catch (NumberFormatException unused) {
            }
        }
        this.f4845a = 11;
        double d8 = Double.parseDouble(this.k);
        int i11 = (int) d8;
        if (i11 != d8) {
            throw new NumberFormatException("Expected an int but was " + this.k + r());
        }
        this.k = null;
        this.f4845a = 0;
        int[] iArr3 = this.f4852o;
        int i12 = this.m - 1;
        iArr3[i12] = iArr3[i12] + 1;
        return i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a3, code lost:
    
        v();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:61:0x009d. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.d.a.n():void");
    }

    public String o() {
        StringBuilder sb = new StringBuilder("$");
        int i2 = this.m;
        for (int i8 = 0; i8 < i2; i8++) {
            int i9 = this.l[i8];
            if (i9 == 1 || i9 == 2) {
                sb.append('[');
                sb.append(this.f4852o[i8]);
                sb.append(']');
            } else if (i9 == 3 || i9 == 4 || i9 == 5) {
                sb.append('.');
                String str = this.f4851n[i8];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public final boolean p() {
        return this.f4847c;
    }

    public final int q() throws IOException {
        int iB;
        int[] iArr = this.l;
        int i2 = this.m;
        int i8 = iArr[i2 - 1];
        if (i8 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i8 == 2) {
            int iB2 = b(true);
            if (iB2 != 44) {
                if (iB2 != 59) {
                    if (iB2 != 93) {
                        throw b("Unterminated array");
                    }
                    this.f4845a = 4;
                    return 4;
                }
                v();
            }
        } else {
            if (i8 == 3 || i8 == 5) {
                iArr[i2 - 1] = 4;
                if (i8 == 5 && (iB = b(true)) != 44) {
                    if (iB != 59) {
                        if (iB != 125) {
                            throw b("Unterminated object");
                        }
                        this.f4845a = 2;
                        return 2;
                    }
                    v();
                }
                int iB3 = b(true);
                if (iB3 == 34) {
                    this.f4845a = 13;
                    return 13;
                }
                if (iB3 == 39) {
                    v();
                    this.f4845a = 12;
                    return 12;
                }
                if (iB3 == 125) {
                    if (i8 == 5) {
                        throw b("Expected name");
                    }
                    this.f4845a = 2;
                    return 2;
                }
                v();
                this.e--;
                if (!a((char) iB3)) {
                    throw b("Expected name");
                }
                this.f4845a = 14;
                return 14;
            }
            if (i8 == 4) {
                iArr[i2 - 1] = 5;
                int iB4 = b(true);
                if (iB4 != 58) {
                    if (iB4 != 61) {
                        throw b("Expected ':'");
                    }
                    v();
                    if (this.e < this.f4849f || b(1)) {
                        char[] cArr = this.f4848d;
                        int i9 = this.e;
                        if (cArr[i9] == '>') {
                            this.e = i9 + 1;
                        }
                    }
                }
            } else if (i8 == 6) {
                if (this.f4847c) {
                    y();
                }
                this.l[this.m - 1] = 7;
            } else if (i8 == 7) {
                if (b(false) == -1) {
                    this.f4845a = 17;
                    return 17;
                }
                v();
                this.e--;
            } else if (i8 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iB5 = b(true);
        if (iB5 == 34) {
            this.f4845a = 9;
            return 9;
        }
        if (iB5 == 39) {
            v();
            this.f4845a = 8;
            return 8;
        }
        if (iB5 != 44 && iB5 != 59) {
            if (iB5 == 91) {
                this.f4845a = 3;
                return 3;
            }
            if (iB5 != 93) {
                if (iB5 == 123) {
                    this.f4845a = 1;
                    return 1;
                }
                this.e--;
                int iS = s();
                if (iS != 0) {
                    return iS;
                }
                int iT = t();
                if (iT != 0) {
                    return iT;
                }
                if (!a(this.f4848d[this.e])) {
                    throw b("Expected value");
                }
                v();
                this.f4845a = 10;
                return 10;
            }
            if (i8 == 1) {
                this.f4845a = 4;
                return 4;
            }
        }
        if (i8 != 1 && i8 != 2) {
            throw b("Unexpected value");
        }
        v();
        this.e--;
        this.f4845a = 7;
        return 7;
    }

    public final String r() {
        StringBuilder sbW = a1.a.w(this.g + 1, " at line ", " column ", (this.e - this.h) + 1, " path ");
        sbW.append(o());
        return sbW.toString();
    }

    public String toString() {
        return getClass().getSimpleName() + r();
    }

    public void a() throws IOException {
        int iQ = this.f4845a;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 3) {
            a(1);
            this.f4852o[this.m - 1] = 0;
            this.f4845a = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + r());
        }
    }

    private void c(char c7) throws IOException {
        char[] cArr = this.f4848d;
        while (true) {
            int i2 = this.e;
            int i8 = this.f4849f;
            while (true) {
                if (i2 < i8) {
                    int i9 = i2 + 1;
                    char c8 = cArr[i2];
                    if (c8 == c7) {
                        this.e = i9;
                        return;
                    }
                    if (c8 == '\\') {
                        this.e = i9;
                        x();
                        break;
                    } else {
                        if (c8 == '\n') {
                            this.g++;
                            this.h = i9;
                        }
                        i2 = i9;
                    }
                } else {
                    this.e = i2;
                    if (!b(1)) {
                        throw b("Unterminated string");
                    }
                }
            }
        }
    }

    private String b(char c7) throws IOException {
        char[] cArr = this.f4848d;
        StringBuilder sb = null;
        while (true) {
            int i2 = this.e;
            int i8 = this.f4849f;
            int i9 = i2;
            while (true) {
                if (i9 < i8) {
                    int i10 = i9 + 1;
                    char c8 = cArr[i9];
                    if (c8 == c7) {
                        this.e = i10;
                        int i11 = (i10 - i2) - 1;
                        if (sb == null) {
                            return new String(cArr, i2, i11);
                        }
                        sb.append(cArr, i2, i11);
                        return sb.toString();
                    }
                    if (c8 == '\\') {
                        this.e = i10;
                        int i12 = i10 - i2;
                        int i13 = i12 - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max(i12 << 1, 16));
                        }
                        sb.append(cArr, i2, i13);
                        sb.append(x());
                    } else {
                        if (c8 == '\n') {
                            this.g++;
                            this.h = i10;
                        }
                        i9 = i10;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i9 - i2) << 1, 16));
                    }
                    sb.append(cArr, i2, i9 - i2);
                    this.e = i9;
                    if (!b(1)) {
                        throw b("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean a(char c7) throws IOException {
        if (c7 == '\t' || c7 == '\n' || c7 == '\f' || c7 == '\r' || c7 == ' ') {
            return false;
        }
        if (c7 != '#') {
            if (c7 == ',') {
                return false;
            }
            if (c7 != '/' && c7 != '=') {
                if (c7 == '{' || c7 == '}' || c7 == ':') {
                    return false;
                }
                if (c7 != ';') {
                    switch (c7) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        v();
        return false;
    }

    private void a(int i2) {
        int i8 = this.m;
        int[] iArr = this.l;
        if (i8 == iArr.length) {
            int i9 = i8 << 1;
            this.l = Arrays.copyOf(iArr, i9);
            this.f4852o = Arrays.copyOf(this.f4852o, i9);
            this.f4851n = (String[]) Arrays.copyOf(this.f4851n, i9);
        }
        int[] iArr2 = this.l;
        int i10 = this.m;
        this.m = i10 + 1;
        iArr2[i10] = i2;
    }

    private boolean a(String str) throws IOException {
        int i2;
        int length = str.length();
        while (true) {
            if (this.e + length > this.f4849f && !b(length)) {
                return false;
            }
            char[] cArr = this.f4848d;
            int i8 = this.e;
            if (cArr[i8] != '\n') {
                while (i2 < length) {
                    i2 = this.f4848d[this.e + i2] == str.charAt(i2) ? i2 + 1 : 0;
                }
                return true;
            }
            this.g++;
            this.h = i8 + 1;
            this.e++;
        }
    }

    private boolean b(int i2) throws IOException {
        int i8;
        int i9;
        char[] cArr = this.f4848d;
        int i10 = this.h;
        int i11 = this.e;
        this.h = i10 - i11;
        int i12 = this.f4849f;
        if (i12 != i11) {
            int i13 = i12 - i11;
            this.f4849f = i13;
            System.arraycopy(cArr, i11, cArr, 0, i13);
        } else {
            this.f4849f = 0;
        }
        this.e = 0;
        do {
            Reader reader = this.f4846b;
            int i14 = this.f4849f;
            int i15 = reader.read(cArr, i14, cArr.length - i14);
            if (i15 == -1) {
                return false;
            }
            i8 = this.f4849f + i15;
            this.f4849f = i8;
            if (this.g == 0 && (i9 = this.h) == 0 && i8 > 0 && cArr[0] == 65279) {
                this.e++;
                this.h = i9 + 1;
                i2++;
            }
        } while (i8 < i2);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0072, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int b(boolean r9) throws java.io.IOException {
        /*
            r8 = this;
            char[] r0 = r8.f4848d
            int r1 = r8.e
            int r2 = r8.f4849f
        L6:
            r3 = 1
            if (r1 != r2) goto L32
            r8.e = r1
            boolean r1 = r8.b(r3)
            if (r1 == 0) goto L16
            int r1 = r8.e
            int r2 = r8.f4849f
            goto L32
        L16:
            if (r9 != 0) goto L1a
            r9 = -1
            return r9
        L1a:
            java.io.EOFException r9 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "End of input"
            r0.<init>(r1)
            java.lang.String r1 = r8.r()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L32:
            int r4 = r1 + 1
            char r5 = r0[r1]
            r6 = 10
            if (r5 != r6) goto L42
            int r1 = r8.g
            int r1 = r1 + r3
            r8.g = r1
            r8.h = r4
            goto Lae
        L42:
            r6 = 32
            if (r5 == r6) goto Lae
            r6 = 13
            if (r5 == r6) goto Lae
            r6 = 9
            if (r5 == r6) goto Lae
            r6 = 47
            if (r5 != r6) goto L99
            r8.e = r4
            r7 = 2
            if (r4 != r2) goto L65
            r8.e = r1
            boolean r1 = r8.b(r7)
            int r2 = r8.e
            int r2 = r2 + r3
            r8.e = r2
            if (r1 != 0) goto L65
            goto L72
        L65:
            r8.v()
            int r1 = r8.e
            char r2 = r0[r1]
            r3 = 42
            if (r2 == r3) goto L7f
            if (r2 == r6) goto L73
        L72:
            return r5
        L73:
            int r1 = r1 + 1
            r8.e = r1
            r8.w()
            int r1 = r8.e
            int r2 = r8.f4849f
            goto L6
        L7f:
            int r1 = r1 + 1
            r8.e = r1
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r8.a(r1)
            if (r1 == 0) goto L92
            int r1 = r8.e
            int r1 = r1 + r7
            int r2 = r8.f4849f
            goto L6
        L92:
            java.lang.String r9 = "Unterminated comment"
            java.io.IOException r9 = r8.b(r9)
            throw r9
        L99:
            r1 = 35
            if (r5 != r1) goto Lab
            r8.e = r4
            r8.v()
            r8.w()
            int r1 = r8.e
            int r2 = r8.f4849f
            goto L6
        Lab:
            r8.e = r4
            return r5
        Lae:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.d.a.b(boolean):int");
    }

    private IOException b(String str) throws IOException {
        StringBuilder sbR = androidx.camera.core.processing.util.a.r(str);
        sbR.append(r());
        throw new d(sbR.toString());
    }
}
