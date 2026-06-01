package com.bykv.vk.openvk.preload.a.d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f4859a = new String[128];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f4860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Writer f4861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f4862d = new int[32];
    private int e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f4863f;
    private String g;
    private boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f4864i;
    private String j;
    private boolean k;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f4859a[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f4859a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f4860b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.g = ":";
        this.k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f4861c = writer;
    }

    private int i() {
        int i2 = this.e;
        if (i2 != 0) {
            return this.f4862d[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void j() throws IOException {
        if (this.j != null) {
            l();
            c(this.j);
            this.j = null;
        }
    }

    private void k() throws IOException {
        if (this.f4863f == null) {
            return;
        }
        this.f4861c.write(10);
        int i2 = this.e;
        for (int i8 = 1; i8 < i2; i8++) {
            this.f4861c.write(this.f4863f);
        }
    }

    private void l() throws IOException {
        int i2 = i();
        if (i2 == 5) {
            this.f4861c.write(44);
        } else if (i2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        k();
        b(4);
    }

    private void m() throws IOException {
        int i2 = i();
        if (i2 == 1) {
            b(2);
            k();
            return;
        }
        if (i2 == 2) {
            this.f4861c.append(',');
            k();
        } else {
            if (i2 == 4) {
                this.f4861c.append((CharSequence) this.g);
                b(5);
                return;
            }
            if (i2 != 6) {
                if (i2 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            b(7);
        }
    }

    public final void a(boolean z2) {
        this.h = z2;
    }

    public final void b(boolean z2) {
        this.f4864i = z2;
    }

    public final void c(boolean z2) {
        this.k = z2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f4861c.close();
        int i2 = this.e;
        if (i2 > 1 || (i2 == 1 && this.f4862d[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.e = 0;
    }

    public final c d() throws IOException {
        j();
        return a(1, '[');
    }

    public final c e() throws IOException {
        return a(1, 2, ']');
    }

    public final c f() throws IOException {
        j();
        return a(3, '{');
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f4861c.flush();
    }

    public final c g() throws IOException {
        return a(3, 5, '}');
    }

    public final c h() throws IOException {
        if (this.j != null) {
            if (!this.k) {
                this.j = null;
                return this;
            }
            j();
        }
        m();
        this.f4861c.write("null");
        return this;
    }

    public final boolean a() {
        return this.h;
    }

    public final boolean b() {
        return this.f4864i;
    }

    public final boolean c() {
        return this.k;
    }

    private c a(int i2, char c7) throws IOException {
        m();
        a(i2);
        this.f4861c.write(c7);
        return this;
    }

    private void b(int i2) {
        this.f4862d[this.e - 1] = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f4864i
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.bykv.vk.openvk.preload.a.d.c.f4860b
            goto L9
        L7:
            java.lang.String[] r0 = com.bykv.vk.openvk.preload.a.d.c.f4859a
        L9:
            java.io.Writer r1 = r8.f4861c
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f4861c
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f4861c
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f4861c
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f4861c
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.d.c.c(java.lang.String):void");
    }

    public final c d(boolean z2) throws IOException {
        j();
        m();
        this.f4861c.write(z2 ? com.ironsource.mediationsdk.metadata.a.g : "false");
        return this;
    }

    public final c b(String str) throws IOException {
        if (str == null) {
            return h();
        }
        j();
        m();
        c(str);
        return this;
    }

    private c a(int i2, int i8, char c7) throws IOException {
        int i9 = i();
        if (i9 != i8 && i9 != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.j == null) {
            this.e--;
            if (i9 == i8) {
                k();
            }
            this.f4861c.write(c7);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.j);
    }

    private void a(int i2) {
        int i8 = this.e;
        int[] iArr = this.f4862d;
        if (i8 == iArr.length) {
            this.f4862d = Arrays.copyOf(iArr, i8 << 1);
        }
        int[] iArr2 = this.f4862d;
        int i9 = this.e;
        this.e = i9 + 1;
        iArr2[i9] = i2;
    }

    public final c a(String str) throws IOException {
        if (str != null) {
            if (this.j == null) {
                if (this.e != 0) {
                    this.j = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    public final c a(Boolean bool) throws IOException {
        if (bool == null) {
            return h();
        }
        j();
        m();
        this.f4861c.write(bool.booleanValue() ? com.ironsource.mediationsdk.metadata.a.g : "false");
        return this;
    }

    public final c a(long j) throws IOException {
        j();
        m();
        this.f4861c.write(Long.toString(j));
        return this;
    }

    public final c a(Number number) throws IOException {
        if (number == null) {
            return h();
        }
        j();
        String string = number.toString();
        if (!this.h && (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(number)));
        }
        m();
        this.f4861c.append((CharSequence) string);
        return this;
    }
}
