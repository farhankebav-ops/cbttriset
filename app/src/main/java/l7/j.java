package l7;

import androidx.core.location.LocationRequestCompat;
import com.vungle.ads.internal.protos.Sdk;
import j4.c3;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements l, k, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k0 f12867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12868b;

    @Override // l7.k
    public final /* bridge */ /* synthetic */ k A(int i2) {
        e0(i2);
        return this;
    }

    @Override // l7.k
    public final /* bridge */ /* synthetic */ k C(String str) {
        d0(str);
        return this;
    }

    @Override // l7.l
    public final String D() {
        return h(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // l7.k
    public final /* bridge */ /* synthetic */ k E(m mVar) {
        w(mVar);
        return this;
    }

    @Override // l7.l
    public final void F(long j) throws EOFException {
        if (this.f12868b < j) {
            throw new EOFException();
        }
    }

    @Override // l7.k
    public final /* bridge */ /* synthetic */ k G(long j) {
        y(j);
        return this;
    }

    @Override // l7.k
    public final long H(o0 source) {
        kotlin.jvm.internal.k.e(source, "source");
        long j = 0;
        while (true) {
            long j3 = source.read(this, 8192L);
            if (j3 == -1) {
                return j;
            }
            j += j3;
        }
    }

    @Override // l7.l
    public final boolean I(long j, m bytes) {
        kotlin.jvm.internal.k.e(bytes, "bytes");
        return l(bytes.d(), bytes, j);
    }

    @Override // l7.l
    public final m J(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("byteCount: ", j).toString());
        }
        if (this.f12868b < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new m(o(j));
        }
        m mVarU = u((int) j);
        skip(j);
        return mVarU;
    }

    @Override // l7.l
    public final long K(j jVar) {
        long j = this.f12868b;
        if (j > 0) {
            jVar.write(this, j);
        }
        return j;
    }

    @Override // l7.l
    public final byte[] L() {
        return o(this.f12868b);
    }

    @Override // l7.l
    public final boolean M() {
        return this.f12868b == 0;
    }

    @Override // l7.l
    public final long N(long j, m bytes) {
        kotlin.jvm.internal.k.e(bytes, "bytes");
        byte[] bArr = m7.a.f12996a;
        return m7.a.a(this, bytes, 0L, j, bytes.d());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        r1 = new l7.j();
        r1.y(r8);
        r1.x(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
    
        if (r2 != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        r1.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0062, code lost:
    
        throw new java.lang.NumberFormatException("Number too large: ".concat(r1.r()));
     */
    @Override // l7.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long O() throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.j.O():long");
    }

    @Override // l7.l
    public final String P(Charset charset) {
        kotlin.jvm.internal.k.e(charset, "charset");
        return q(this.f12868b, charset);
    }

    @Override // l7.k
    public final /* bridge */ /* synthetic */ k Q(long j) {
        W(j);
        return this;
    }

    @Override // l7.l
    public final m R() {
        return J(this.f12868b);
    }

    @Override // l7.k
    public final /* bridge */ /* synthetic */ k S(int i2, int i8, String str) {
        c0(i2, i8, str);
        return this;
    }

    @Override // l7.k
    public final OutputStream T() {
        return new c3(this, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008d A[EDGE_INSN: B:43:0x008d->B:37:0x008d BREAK  A[LOOP:0: B:5:0x000b->B:45:?], SYNTHETIC] */
    @Override // l7.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long U() throws java.io.EOFException {
        /*
            r14 = this;
            long r0 = r14.f12868b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L94
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            l7.k0 r6 = r14.f12867a
            kotlin.jvm.internal.k.b(r6)
            byte[] r7 = r6.f12872a
            int r8 = r6.f12873b
            int r9 = r6.f12874c
        L16:
            if (r8 >= r9) goto L79
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L25
            r11 = 57
            if (r10 > r11) goto L25
            int r11 = r10 + (-48)
            goto L3a
        L25:
            r11 = 97
            if (r10 < r11) goto L30
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L30
            int r11 = r10 + (-87)
            goto L3a
        L30:
            r11 = 65
            if (r10 < r11) goto L65
            r11 = 70
            if (r10 > r11) goto L65
            int r11 = r10 + (-55)
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L16
        L4a:
            l7.j r0 = new l7.j
            r0.<init>()
            r0.W(r4)
            r0.x(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.r()
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L65:
            if (r0 == 0) goto L69
            r1 = 1
            goto L79
        L69:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = l7.b.l(r10)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L79:
            if (r8 != r9) goto L85
            l7.k0 r7 = r6.a()
            r14.f12867a = r7
            l7.l0.a(r6)
            goto L87
        L85:
            r6.f12873b = r8
        L87:
            if (r1 != 0) goto L8d
            l7.k0 r6 = r14.f12867a
            if (r6 != 0) goto Lb
        L8d:
            long r1 = r14.f12868b
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.f12868b = r1
            return r4
        L94:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.j.U():long");
    }

    @Override // l7.l
    public final InputStream V() {
        return new i(this, 0);
    }

    public final void W(long j) {
        if (j == 0) {
            x(48);
            return;
        }
        long j3 = (j >>> 1) | j;
        long j8 = j3 | (j3 >>> 2);
        long j9 = j8 | (j8 >>> 4);
        long j10 = j9 | (j9 >>> 8);
        long j11 = j10 | (j10 >>> 16);
        long j12 = j11 | (j11 >>> 32);
        long j13 = j12 - ((j12 >>> 1) & 6148914691236517205L);
        long j14 = ((j13 >>> 2) & 3689348814741910323L) + (j13 & 3689348814741910323L);
        long j15 = ((j14 >>> 4) + j14) & 1085102592571150095L;
        long j16 = j15 + (j15 >>> 8);
        long j17 = j16 + (j16 >>> 16);
        int i2 = (int) ((((j17 & 63) + ((j17 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        k0 k0VarV = v(i2);
        byte[] bArr = k0VarV.f12872a;
        int i8 = k0VarV.f12874c;
        for (int i9 = (i8 + i2) - 1; i9 >= i8; i9--) {
            bArr[i9] = m7.a.f12996a[(int) (15 & j)];
            j >>>= 4;
        }
        k0VarV.f12874c += i2;
        this.f12868b += (long) i2;
    }

    public final void X(int i2) {
        k0 k0VarV = v(4);
        byte[] bArr = k0VarV.f12872a;
        int i8 = k0VarV.f12874c;
        bArr[i8] = (byte) ((i2 >>> 24) & 255);
        bArr[i8 + 1] = (byte) ((i2 >>> 16) & 255);
        bArr[i8 + 2] = (byte) ((i2 >>> 8) & 255);
        bArr[i8 + 3] = (byte) (i2 & 255);
        k0VarV.f12874c = i8 + 4;
        this.f12868b += 4;
    }

    public final void Y(long j) {
        k0 k0VarV = v(8);
        byte[] bArr = k0VarV.f12872a;
        int i2 = k0VarV.f12874c;
        bArr[i2] = (byte) ((j >>> 56) & 255);
        bArr[i2 + 1] = (byte) ((j >>> 48) & 255);
        bArr[i2 + 2] = (byte) ((j >>> 40) & 255);
        bArr[i2 + 3] = (byte) ((j >>> 32) & 255);
        bArr[i2 + 4] = (byte) ((j >>> 24) & 255);
        bArr[i2 + 5] = (byte) ((j >>> 16) & 255);
        bArr[i2 + 6] = (byte) ((j >>> 8) & 255);
        bArr[i2 + 7] = (byte) (j & 255);
        k0VarV.f12874c = i2 + 8;
        this.f12868b += 8;
    }

    public final void Z(int i2) {
        k0 k0VarV = v(2);
        byte[] bArr = k0VarV.f12872a;
        int i8 = k0VarV.f12874c;
        bArr[i8] = (byte) ((i2 >>> 8) & 255);
        bArr[i8 + 1] = (byte) (i2 & 255);
        k0VarV.f12874c = i8 + 2;
        this.f12868b += 2;
    }

    public final void a() throws EOFException {
        skip(this.f12868b);
    }

    public final void a0(String str, int i2, int i8, Charset charset) {
        kotlin.jvm.internal.k.e(charset, "charset");
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.g(i2, "beginIndex < 0: ").toString());
        }
        if (i8 < i2) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("endIndex < beginIndex: ", i8, " < ", i2).toString());
        }
        if (i8 > str.length()) {
            StringBuilder sbV = a1.a.v(i8, "endIndex > string.length: ", " > ");
            sbV.append(str.length());
            throw new IllegalArgumentException(sbV.toString().toString());
        }
        if (charset.equals(n6.a.f13073a)) {
            c0(i2, i8, str);
            return;
        }
        String strSubstring = str.substring(i2, i8);
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        byte[] bytes = strSubstring.getBytes(charset);
        kotlin.jvm.internal.k.d(bytes, "getBytes(...)");
        m3451write(bytes, 0, bytes.length);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final j clone() {
        j jVar = new j();
        if (this.f12868b == 0) {
            return jVar;
        }
        k0 k0Var = this.f12867a;
        kotlin.jvm.internal.k.b(k0Var);
        k0 k0VarC = k0Var.c();
        jVar.f12867a = k0VarC;
        k0VarC.g = k0VarC;
        k0VarC.f12876f = k0VarC;
        for (k0 k0Var2 = k0Var.f12876f; k0Var2 != k0Var; k0Var2 = k0Var2.f12876f) {
            k0 k0Var3 = k0VarC.g;
            kotlin.jvm.internal.k.b(k0Var3);
            kotlin.jvm.internal.k.b(k0Var2);
            k0Var3.b(k0Var2.c());
        }
        jVar.f12868b = this.f12868b;
        return jVar;
    }

    public final void b0(OutputStream out, long j) throws IOException {
        kotlin.jvm.internal.k.e(out, "out");
        b.e(this.f12868b, 0L, j);
        k0 k0Var = this.f12867a;
        long j3 = j;
        while (j3 > 0) {
            kotlin.jvm.internal.k.b(k0Var);
            int iMin = (int) Math.min(j3, k0Var.f12874c - k0Var.f12873b);
            out.write(k0Var.f12872a, k0Var.f12873b, iMin);
            int i2 = k0Var.f12873b + iMin;
            k0Var.f12873b = i2;
            long j8 = iMin;
            this.f12868b -= j8;
            j3 -= j8;
            if (i2 == k0Var.f12874c) {
                k0 k0VarA = k0Var.a();
                this.f12867a = k0VarA;
                l0.a(k0Var);
                k0Var = k0VarA;
            }
        }
    }

    @Override // l7.l
    public final boolean c(long j) {
        return this.f12868b >= j;
    }

    public final void c0(int i2, int i8, String string) {
        char cCharAt;
        kotlin.jvm.internal.k.e(string, "string");
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.g(i2, "beginIndex < 0: ").toString());
        }
        if (i8 < i2) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("endIndex < beginIndex: ", i8, " < ", i2).toString());
        }
        if (i8 > string.length()) {
            StringBuilder sbV = a1.a.v(i8, "endIndex > string.length: ", " > ");
            sbV.append(string.length());
            throw new IllegalArgumentException(sbV.toString().toString());
        }
        while (i2 < i8) {
            char cCharAt2 = string.charAt(i2);
            if (cCharAt2 < 128) {
                k0 k0VarV = v(1);
                byte[] bArr = k0VarV.f12872a;
                int i9 = k0VarV.f12874c - i2;
                int iMin = Math.min(i8, 8192 - i9);
                int i10 = i2 + 1;
                bArr[i2 + i9] = (byte) cCharAt2;
                while (true) {
                    i2 = i10;
                    if (i2 >= iMin || (cCharAt = string.charAt(i2)) >= 128) {
                        break;
                    }
                    i10 = i2 + 1;
                    bArr[i2 + i9] = (byte) cCharAt;
                }
                int i11 = k0VarV.f12874c;
                int i12 = (i9 + i2) - i11;
                k0VarV.f12874c = i11 + i12;
                this.f12868b += (long) i12;
            } else {
                if (cCharAt2 < 2048) {
                    k0 k0VarV2 = v(2);
                    byte[] bArr2 = k0VarV2.f12872a;
                    int i13 = k0VarV2.f12874c;
                    bArr2[i13] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i13 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    k0VarV2.f12874c = i13 + 2;
                    this.f12868b += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    k0 k0VarV3 = v(3);
                    byte[] bArr3 = k0VarV3.f12872a;
                    int i14 = k0VarV3.f12874c;
                    bArr3[i14] = (byte) ((cCharAt2 >> '\f') | Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE);
                    bArr3[i14 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i14 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    k0VarV3.f12874c = i14 + 3;
                    this.f12868b += 3;
                } else {
                    int i15 = i2 + 1;
                    char cCharAt3 = i15 < i8 ? string.charAt(i15) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        x(63);
                        i2 = i15;
                    } else {
                        int i16 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        k0 k0VarV4 = v(4);
                        byte[] bArr4 = k0VarV4.f12872a;
                        int i17 = k0VarV4.f12874c;
                        bArr4[i17] = (byte) ((i16 >> 18) | 240);
                        bArr4[i17 + 1] = (byte) (((i16 >> 12) & 63) | 128);
                        bArr4[i17 + 2] = (byte) (((i16 >> 6) & 63) | 128);
                        bArr4[i17 + 3] = (byte) ((i16 & 63) | 128);
                        k0VarV4.f12874c = i17 + 4;
                        this.f12868b += 4;
                        i2 += 2;
                    }
                }
                i2++;
            }
        }
    }

    @Override // l7.l
    public final void d(j sink, long j) throws EOFException {
        kotlin.jvm.internal.k.e(sink, "sink");
        long j3 = this.f12868b;
        if (j3 >= j) {
            sink.write(this, j);
        } else {
            sink.write(this, j3);
            throw new EOFException();
        }
    }

    public final void d0(String string) {
        kotlin.jvm.internal.k.e(string, "string");
        c0(0, string.length(), string);
    }

    public final long e() {
        long j = this.f12868b;
        if (j == 0) {
            return 0L;
        }
        k0 k0Var = this.f12867a;
        kotlin.jvm.internal.k.b(k0Var);
        k0 k0Var2 = k0Var.g;
        kotlin.jvm.internal.k.b(k0Var2);
        int i2 = k0Var2.f12874c;
        return (i2 >= 8192 || !k0Var2.e) ? j : j - ((long) (i2 - k0Var2.f12873b));
    }

    public final void e0(int i2) {
        if (i2 < 128) {
            x(i2);
            return;
        }
        if (i2 < 2048) {
            k0 k0VarV = v(2);
            byte[] bArr = k0VarV.f12872a;
            int i8 = k0VarV.f12874c;
            bArr[i8] = (byte) ((i2 >> 6) | 192);
            bArr[i8 + 1] = (byte) ((i2 & 63) | 128);
            k0VarV.f12874c = i8 + 2;
            this.f12868b += 2;
            return;
        }
        if (55296 <= i2 && i2 < 57344) {
            x(63);
            return;
        }
        if (i2 < 65536) {
            k0 k0VarV2 = v(3);
            byte[] bArr2 = k0VarV2.f12872a;
            int i9 = k0VarV2.f12874c;
            bArr2[i9] = (byte) ((i2 >> 12) | Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE);
            bArr2[i9 + 1] = (byte) (((i2 >> 6) & 63) | 128);
            bArr2[i9 + 2] = (byte) ((i2 & 63) | 128);
            k0VarV2.f12874c = i9 + 3;
            this.f12868b += 3;
            return;
        }
        if (i2 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x".concat(b.m(i2)));
        }
        k0 k0VarV3 = v(4);
        byte[] bArr3 = k0VarV3.f12872a;
        int i10 = k0VarV3.f12874c;
        bArr3[i10] = (byte) ((i2 >> 18) | 240);
        bArr3[i10 + 1] = (byte) (((i2 >> 12) & 63) | 128);
        bArr3[i10 + 2] = (byte) (((i2 >> 6) & 63) | 128);
        bArr3[i10 + 3] = (byte) ((i2 & 63) | 128);
        k0VarV3.f12874c = i10 + 4;
        this.f12868b += 4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        long j = this.f12868b;
        j jVar = (j) obj;
        if (j != jVar.f12868b) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        k0 k0Var = this.f12867a;
        kotlin.jvm.internal.k.b(k0Var);
        k0 k0Var2 = jVar.f12867a;
        kotlin.jvm.internal.k.b(k0Var2);
        int i2 = k0Var.f12873b;
        int i8 = k0Var2.f12873b;
        long j3 = 0;
        while (j3 < this.f12868b) {
            long jMin = Math.min(k0Var.f12874c - i2, k0Var2.f12874c - i8);
            long j8 = 0;
            while (j8 < jMin) {
                int i9 = i2 + 1;
                int i10 = i8 + 1;
                if (k0Var.f12872a[i2] != k0Var2.f12872a[i8]) {
                    return false;
                }
                j8++;
                i2 = i9;
                i8 = i10;
            }
            if (i2 == k0Var.f12874c) {
                k0Var = k0Var.f12876f;
                kotlin.jvm.internal.k.b(k0Var);
                i2 = k0Var.f12873b;
            }
            if (i8 == k0Var2.f12874c) {
                k0Var2 = k0Var2.f12876f;
                kotlin.jvm.internal.k.b(k0Var2);
                i8 = k0Var2.f12873b;
            }
            j3 += jMin;
        }
        return true;
    }

    @Override // l7.l
    public final int f(f0 options) throws EOFException {
        kotlin.jvm.internal.k.e(options, "options");
        int iD = m7.a.d(this, options, false);
        if (iD == -1) {
            return -1;
        }
        skip(options.f12848a[iD].d());
        return iD;
    }

    public final void g(long j, j out, long j3) {
        kotlin.jvm.internal.k.e(out, "out");
        long j8 = j;
        b.e(this.f12868b, j8, j3);
        if (j3 == 0) {
            return;
        }
        out.f12868b += j3;
        k0 k0Var = this.f12867a;
        while (true) {
            kotlin.jvm.internal.k.b(k0Var);
            long j9 = k0Var.f12874c - k0Var.f12873b;
            if (j8 < j9) {
                break;
            }
            j8 -= j9;
            k0Var = k0Var.f12876f;
        }
        k0 k0Var2 = k0Var;
        long j10 = j3;
        while (j10 > 0) {
            kotlin.jvm.internal.k.b(k0Var2);
            k0 k0VarC = k0Var2.c();
            int i2 = k0VarC.f12873b + ((int) j8);
            k0VarC.f12873b = i2;
            k0VarC.f12874c = Math.min(i2 + ((int) j10), k0VarC.f12874c);
            k0 k0Var3 = out.f12867a;
            if (k0Var3 == null) {
                k0VarC.g = k0VarC;
                k0VarC.f12876f = k0VarC;
                out.f12867a = k0VarC;
            } else {
                k0 k0Var4 = k0Var3.g;
                kotlin.jvm.internal.k.b(k0Var4);
                k0Var4.b(k0VarC);
            }
            j10 -= (long) (k0VarC.f12874c - k0VarC.f12873b);
            k0Var2 = k0Var2.f12876f;
            j8 = 0;
        }
    }

    @Override // l7.l
    public final String h(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("limit < 0: ", j).toString());
        }
        long j3 = LocationRequestCompat.PASSIVE_INTERVAL;
        if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
            j3 = j + 1;
        }
        long j8 = j3;
        long j9 = j((byte) 10, 0L, j8);
        if (j9 != -1) {
            return m7.a.c(this, j9);
        }
        if (j8 < this.f12868b && i(j8 - 1) == 13 && i(j8) == 10) {
            return m7.a.c(this, j8);
        }
        j jVar = new j();
        g(0L, jVar, Math.min(32, this.f12868b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f12868b, j) + " content=" + jVar.J(jVar.f12868b).e() + (char) 8230);
    }

    public final int hashCode() {
        k0 k0Var = this.f12867a;
        if (k0Var == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i8 = k0Var.f12874c;
            for (int i9 = k0Var.f12873b; i9 < i8; i9++) {
                i2 = (i2 * 31) + k0Var.f12872a[i9];
            }
            k0Var = k0Var.f12876f;
            kotlin.jvm.internal.k.b(k0Var);
        } while (k0Var != this.f12867a);
        return i2;
    }

    public final byte i(long j) {
        b.e(this.f12868b, j, 1L);
        k0 k0Var = this.f12867a;
        if (k0Var == null) {
            kotlin.jvm.internal.k.b(null);
            throw null;
        }
        long j3 = this.f12868b;
        if (j3 - j < j) {
            while (j3 > j) {
                k0Var = k0Var.g;
                kotlin.jvm.internal.k.b(k0Var);
                j3 -= (long) (k0Var.f12874c - k0Var.f12873b);
            }
            return k0Var.f12872a[(int) ((((long) k0Var.f12873b) + j) - j3)];
        }
        long j8 = 0;
        while (true) {
            int i2 = k0Var.f12874c;
            int i8 = k0Var.f12873b;
            long j9 = ((long) (i2 - i8)) + j8;
            if (j9 > j) {
                return k0Var.f12872a[(int) ((((long) i8) + j) - j8)];
            }
            k0Var = k0Var.f12876f;
            kotlin.jvm.internal.k.b(k0Var);
            j8 = j9;
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final long j(byte b8, long j, long j3) {
        k0 k0Var;
        long j8 = 0;
        if (0 > j || j > j3) {
            StringBuilder sb = new StringBuilder("size=");
            sb.append(this.f12868b);
            androidx.camera.core.processing.util.a.y(sb, " fromIndex=", j, " toIndex=");
            sb.append(j3);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        long j9 = this.f12868b;
        if (j3 > j9) {
            j3 = j9;
        }
        if (j == j3 || (k0Var = this.f12867a) == null) {
            return -1L;
        }
        if (j9 - j < j) {
            while (j9 > j) {
                k0Var = k0Var.g;
                kotlin.jvm.internal.k.b(k0Var);
                j9 -= (long) (k0Var.f12874c - k0Var.f12873b);
            }
            while (j9 < j3) {
                byte[] bArr = k0Var.f12872a;
                int iMin = (int) Math.min(k0Var.f12874c, (((long) k0Var.f12873b) + j3) - j9);
                for (int i2 = (int) ((((long) k0Var.f12873b) + j) - j9); i2 < iMin; i2++) {
                    if (bArr[i2] == b8) {
                        return ((long) (i2 - k0Var.f12873b)) + j9;
                    }
                }
                j9 += (long) (k0Var.f12874c - k0Var.f12873b);
                k0Var = k0Var.f12876f;
                kotlin.jvm.internal.k.b(k0Var);
                j = j9;
            }
            return -1L;
        }
        while (true) {
            long j10 = ((long) (k0Var.f12874c - k0Var.f12873b)) + j8;
            if (j10 > j) {
                break;
            }
            k0Var = k0Var.f12876f;
            kotlin.jvm.internal.k.b(k0Var);
            j8 = j10;
        }
        while (j8 < j3) {
            byte[] bArr2 = k0Var.f12872a;
            int iMin2 = (int) Math.min(k0Var.f12874c, (((long) k0Var.f12873b) + j3) - j8);
            for (int i8 = (int) ((((long) k0Var.f12873b) + j) - j8); i8 < iMin2; i8++) {
                if (bArr2[i8] == b8) {
                    return ((long) (i8 - k0Var.f12873b)) + j8;
                }
            }
            j8 += (long) (k0Var.f12874c - k0Var.f12873b);
            k0Var = k0Var.f12876f;
            kotlin.jvm.internal.k.b(k0Var);
            j = j8;
        }
        return -1L;
    }

    public final long k(m targetBytes) {
        int i2;
        int i8;
        kotlin.jvm.internal.k.e(targetBytes, "targetBytes");
        k0 k0Var = this.f12867a;
        if (k0Var == null) {
            return -1L;
        }
        long j = this.f12868b;
        long j3 = 0;
        if (j < 0) {
            while (j > 0) {
                k0Var = k0Var.g;
                kotlin.jvm.internal.k.b(k0Var);
                j -= (long) (k0Var.f12874c - k0Var.f12873b);
            }
            if (targetBytes.d() == 2) {
                byte bI = targetBytes.i(0);
                byte bI2 = targetBytes.i(1);
                while (j < this.f12868b) {
                    byte[] bArr = k0Var.f12872a;
                    i2 = (int) ((((long) k0Var.f12873b) + j3) - j);
                    int i9 = k0Var.f12874c;
                    while (i2 < i9) {
                        byte b8 = bArr[i2];
                        if (b8 == bI || b8 == bI2) {
                            i8 = k0Var.f12873b;
                        } else {
                            i2++;
                        }
                    }
                    j3 = ((long) (k0Var.f12874c - k0Var.f12873b)) + j;
                    k0Var = k0Var.f12876f;
                    kotlin.jvm.internal.k.b(k0Var);
                    j = j3;
                }
                return -1L;
            }
            byte[] bArrH = targetBytes.h();
            while (j < this.f12868b) {
                byte[] bArr2 = k0Var.f12872a;
                i2 = (int) ((((long) k0Var.f12873b) + j3) - j);
                int i10 = k0Var.f12874c;
                while (i2 < i10) {
                    byte b9 = bArr2[i2];
                    for (byte b10 : bArrH) {
                        if (b9 == b10) {
                            i8 = k0Var.f12873b;
                        }
                    }
                    i2++;
                }
                j3 = ((long) (k0Var.f12874c - k0Var.f12873b)) + j;
                k0Var = k0Var.f12876f;
                kotlin.jvm.internal.k.b(k0Var);
                j = j3;
            }
            return -1L;
        }
        j = 0;
        while (true) {
            long j8 = ((long) (k0Var.f12874c - k0Var.f12873b)) + j;
            if (j8 > 0) {
                break;
            }
            k0Var = k0Var.f12876f;
            kotlin.jvm.internal.k.b(k0Var);
            j = j8;
        }
        if (targetBytes.d() == 2) {
            byte bI3 = targetBytes.i(0);
            byte bI4 = targetBytes.i(1);
            while (j < this.f12868b) {
                byte[] bArr3 = k0Var.f12872a;
                i2 = (int) ((((long) k0Var.f12873b) + j3) - j);
                int i11 = k0Var.f12874c;
                while (i2 < i11) {
                    byte b11 = bArr3[i2];
                    if (b11 == bI3 || b11 == bI4) {
                        i8 = k0Var.f12873b;
                    } else {
                        i2++;
                    }
                }
                j3 = ((long) (k0Var.f12874c - k0Var.f12873b)) + j;
                k0Var = k0Var.f12876f;
                kotlin.jvm.internal.k.b(k0Var);
                j = j3;
            }
            return -1L;
        }
        byte[] bArrH2 = targetBytes.h();
        while (j < this.f12868b) {
            byte[] bArr4 = k0Var.f12872a;
            i2 = (int) ((((long) k0Var.f12873b) + j3) - j);
            int i12 = k0Var.f12874c;
            while (i2 < i12) {
                byte b12 = bArr4[i2];
                for (byte b13 : bArrH2) {
                    if (b12 == b13) {
                        i8 = k0Var.f12873b;
                    }
                }
                i2++;
            }
            j3 = ((long) (k0Var.f12874c - k0Var.f12873b)) + j;
            k0Var = k0Var.f12876f;
            kotlin.jvm.internal.k.b(k0Var);
            j = j3;
        }
        return -1L;
        return ((long) (i2 - i8)) + j;
    }

    public final boolean l(int i2, m bytes, long j) {
        kotlin.jvm.internal.k.e(bytes, "bytes");
        if (i2 >= 0 && j >= 0 && ((long) i2) + j <= this.f12868b && i2 <= bytes.d()) {
            return i2 == 0 || m7.a.a(this, bytes, j, j + 1, i2) != -1;
        }
        return false;
    }

    public final h n(h unsafeCursor) {
        kotlin.jvm.internal.k.e(unsafeCursor, "unsafeCursor");
        byte[] bArr = m7.a.f12996a;
        if (unsafeCursor == b.f12839a) {
            unsafeCursor = new h();
        }
        if (unsafeCursor.f12852a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.f12852a = this;
        unsafeCursor.f12853b = true;
        return unsafeCursor;
    }

    public final byte[] o(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("byteCount: ", j).toString());
        }
        if (this.f12868b < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    public final short p() throws EOFException {
        short s7 = readShort();
        return (short) (((s7 & 255) << 8) | ((65280 & s7) >>> 8));
    }

    @Override // l7.l
    public final j0 peek() {
        return b.c(new h0(this));
    }

    public final String q(long j, Charset charset) throws EOFException {
        kotlin.jvm.internal.k.e(charset, "charset");
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("byteCount: ", j).toString());
        }
        if (this.f12868b < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        k0 k0Var = this.f12867a;
        kotlin.jvm.internal.k.b(k0Var);
        int i2 = k0Var.f12873b;
        if (((long) i2) + j > k0Var.f12874c) {
            return new String(o(j), charset);
        }
        int i8 = (int) j;
        String str = new String(k0Var.f12872a, i2, i8, charset);
        int i9 = k0Var.f12873b + i8;
        k0Var.f12873b = i9;
        this.f12868b -= j;
        if (i9 == k0Var.f12874c) {
            this.f12867a = k0Var.a();
            l0.a(k0Var);
        }
        return str;
    }

    public final String r() {
        return q(this.f12868b, n6.a.f13073a);
    }

    @Override // l7.o0
    public final long read(j sink, long j) {
        kotlin.jvm.internal.k.e(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("byteCount < 0: ", j).toString());
        }
        long j3 = this.f12868b;
        if (j3 == 0) {
            return -1L;
        }
        if (j > j3) {
            j = j3;
        }
        sink.write(this, j);
        return j;
    }

    @Override // l7.l
    public final byte readByte() throws EOFException {
        if (this.f12868b == 0) {
            throw new EOFException();
        }
        k0 k0Var = this.f12867a;
        kotlin.jvm.internal.k.b(k0Var);
        int i2 = k0Var.f12873b;
        int i8 = k0Var.f12874c;
        int i9 = i2 + 1;
        byte b8 = k0Var.f12872a[i2];
        this.f12868b--;
        if (i9 != i8) {
            k0Var.f12873b = i9;
            return b8;
        }
        this.f12867a = k0Var.a();
        l0.a(k0Var);
        return b8;
    }

    @Override // l7.l
    public final void readFully(byte[] sink) throws EOFException {
        kotlin.jvm.internal.k.e(sink, "sink");
        int i2 = 0;
        while (i2 < sink.length) {
            int i8 = read(sink, i2, sink.length - i2);
            if (i8 == -1) {
                throw new EOFException();
            }
            i2 += i8;
        }
    }

    @Override // l7.l
    public final int readInt() throws EOFException {
        if (this.f12868b < 4) {
            throw new EOFException();
        }
        k0 k0Var = this.f12867a;
        kotlin.jvm.internal.k.b(k0Var);
        int i2 = k0Var.f12873b;
        int i8 = k0Var.f12874c;
        if (i8 - i2 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = k0Var.f12872a;
        int i9 = i2 + 3;
        int i10 = ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 2] & 255) << 8);
        int i11 = i2 + 4;
        int i12 = (bArr[i9] & 255) | i10;
        this.f12868b -= 4;
        if (i11 != i8) {
            k0Var.f12873b = i11;
            return i12;
        }
        this.f12867a = k0Var.a();
        l0.a(k0Var);
        return i12;
    }

    @Override // l7.l
    public final long readLong() throws EOFException {
        if (this.f12868b < 8) {
            throw new EOFException();
        }
        k0 k0Var = this.f12867a;
        kotlin.jvm.internal.k.b(k0Var);
        int i2 = k0Var.f12873b;
        int i8 = k0Var.f12874c;
        if (i8 - i2 < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = k0Var.f12872a;
        int i9 = i2 + 7;
        long j = ((((long) bArr[i2 + 3]) & 255) << 32) | ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i2 + 1]) & 255) << 48) | ((((long) bArr[i2 + 2]) & 255) << 40) | ((((long) bArr[i2 + 4]) & 255) << 24) | ((((long) bArr[i2 + 5]) & 255) << 16) | ((((long) bArr[i2 + 6]) & 255) << 8);
        int i10 = i2 + 8;
        long j3 = j | (((long) bArr[i9]) & 255);
        this.f12868b -= 8;
        if (i10 != i8) {
            k0Var.f12873b = i10;
            return j3;
        }
        this.f12867a = k0Var.a();
        l0.a(k0Var);
        return j3;
    }

    @Override // l7.l
    public final short readShort() throws EOFException {
        if (this.f12868b < 2) {
            throw new EOFException();
        }
        k0 k0Var = this.f12867a;
        kotlin.jvm.internal.k.b(k0Var);
        int i2 = k0Var.f12873b;
        int i8 = k0Var.f12874c;
        if (i8 - i2 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = k0Var.f12872a;
        int i9 = i2 + 1;
        int i10 = (bArr[i2] & 255) << 8;
        int i11 = i2 + 2;
        int i12 = (bArr[i9] & 255) | i10;
        this.f12868b -= 2;
        if (i11 == i8) {
            this.f12867a = k0Var.a();
            l0.a(k0Var);
        } else {
            k0Var.f12873b = i11;
        }
        return (short) i12;
    }

    public final int s() throws EOFException {
        int i2;
        int i8;
        int i9;
        if (this.f12868b == 0) {
            throw new EOFException();
        }
        byte bI = i(0L);
        if ((bI & 128) == 0) {
            i2 = bI & 127;
            i9 = 0;
            i8 = 1;
        } else if ((bI & 224) == 192) {
            i2 = bI & 31;
            i8 = 2;
            i9 = 128;
        } else if ((bI & 240) == 224) {
            i2 = bI & 15;
            i8 = 3;
            i9 = 2048;
        } else {
            if ((bI & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i2 = bI & 7;
            i8 = 4;
            i9 = 65536;
        }
        long j = i8;
        if (this.f12868b < j) {
            StringBuilder sbV = a1.a.v(i8, "size < ", ": ");
            sbV.append(this.f12868b);
            sbV.append(" (to read code point prefixed 0x");
            sbV.append(b.l(bI));
            sbV.append(')');
            throw new EOFException(sbV.toString());
        }
        for (int i10 = 1; i10 < i8; i10++) {
            long j3 = i10;
            byte bI2 = i(j3);
            if ((bI2 & 192) != 128) {
                skip(j3);
                return 65533;
            }
            i2 = (i2 << 6) | (bI2 & 63);
        }
        skip(j);
        if (i2 > 1114111) {
            return 65533;
        }
        if ((55296 > i2 || i2 >= 57344) && i2 >= i9) {
            return i2;
        }
        return 65533;
    }

    @Override // l7.l
    public final void skip(long j) throws EOFException {
        while (j > 0) {
            k0 k0Var = this.f12867a;
            if (k0Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, k0Var.f12874c - k0Var.f12873b);
            long j3 = iMin;
            this.f12868b -= j3;
            j -= j3;
            int i2 = k0Var.f12873b + iMin;
            k0Var.f12873b = i2;
            if (i2 == k0Var.f12874c) {
                this.f12867a = k0Var.a();
                l0.a(k0Var);
            }
        }
    }

    public final m t() {
        long j = this.f12868b;
        if (j <= 2147483647L) {
            return u((int) j);
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f12868b).toString());
    }

    @Override // l7.o0
    public final r0 timeout() {
        return r0.NONE;
    }

    public final String toString() {
        return t().toString();
    }

    public final m u(int i2) {
        if (i2 == 0) {
            return m.f12880d;
        }
        b.e(this.f12868b, 0L, i2);
        k0 k0Var = this.f12867a;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i2) {
            kotlin.jvm.internal.k.b(k0Var);
            int i11 = k0Var.f12874c;
            int i12 = k0Var.f12873b;
            if (i11 == i12) {
                throw new AssertionError("s.limit == s.pos");
            }
            i9 += i11 - i12;
            i10++;
            k0Var = k0Var.f12876f;
        }
        byte[][] bArr = new byte[i10][];
        int[] iArr = new int[i10 * 2];
        k0 k0Var2 = this.f12867a;
        int i13 = 0;
        while (i8 < i2) {
            kotlin.jvm.internal.k.b(k0Var2);
            bArr[i13] = k0Var2.f12872a;
            i8 += k0Var2.f12874c - k0Var2.f12873b;
            iArr[i13] = Math.min(i8, i2);
            iArr[i13 + i10] = k0Var2.f12873b;
            k0Var2.f12875d = true;
            i13++;
            k0Var2 = k0Var2.f12876f;
        }
        return new m0(bArr, iArr);
    }

    public final k0 v(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        k0 k0Var = this.f12867a;
        if (k0Var == null) {
            k0 k0VarB = l0.b();
            this.f12867a = k0VarB;
            k0VarB.g = k0VarB;
            k0VarB.f12876f = k0VarB;
            return k0VarB;
        }
        k0 k0Var2 = k0Var.g;
        kotlin.jvm.internal.k.b(k0Var2);
        if (k0Var2.f12874c + i2 <= 8192 && k0Var2.e) {
            return k0Var2;
        }
        k0 k0VarB2 = l0.b();
        k0Var2.b(k0VarB2);
        return k0VarB2;
    }

    public final void w(m byteString) {
        kotlin.jvm.internal.k.e(byteString, "byteString");
        byteString.u(byteString.d(), this);
    }

    @Override // l7.k
    public final /* bridge */ /* synthetic */ k write(byte[] bArr) {
        m3450write(bArr);
        return this;
    }

    @Override // l7.k
    public final /* bridge */ /* synthetic */ k writeByte(int i2) {
        x(i2);
        return this;
    }

    @Override // l7.k
    public final /* bridge */ /* synthetic */ k writeInt(int i2) {
        X(i2);
        return this;
    }

    @Override // l7.k
    public final /* bridge */ /* synthetic */ k writeShort(int i2) {
        Z(i2);
        return this;
    }

    public final void x(int i2) {
        k0 k0VarV = v(1);
        byte[] bArr = k0VarV.f12872a;
        int i8 = k0VarV.f12874c;
        k0VarV.f12874c = i8 + 1;
        bArr[i8] = (byte) i2;
        this.f12868b++;
    }

    public final void y(long j) {
        boolean z2;
        if (j == 0) {
            x(48);
            return;
        }
        if (j < 0) {
            j = -j;
            if (j < 0) {
                d0("-9223372036854775808");
                return;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        byte[] bArr = m7.a.f12996a;
        int iNumberOfLeadingZeros = ((64 - Long.numberOfLeadingZeros(j)) * 10) >>> 5;
        int i2 = iNumberOfLeadingZeros + (j > m7.a.f12997b[iNumberOfLeadingZeros] ? 1 : 0);
        if (z2) {
            i2++;
        }
        k0 k0VarV = v(i2);
        byte[] bArr2 = k0VarV.f12872a;
        int i8 = k0VarV.f12874c + i2;
        while (j != 0) {
            long j3 = 10;
            i8--;
            bArr2[i8] = m7.a.f12996a[(int) (j % j3)];
            j /= j3;
        }
        if (z2) {
            bArr2[i8 - 1] = 45;
        }
        k0VarV.f12874c += i2;
        this.f12868b += (long) i2;
    }

    @Override // l7.k
    public final /* bridge */ /* synthetic */ k write(byte[] bArr, int i2, int i8) {
        m3451write(bArr, i2, i8);
        return this;
    }

    @Override // l7.n0
    public final void write(j source, long j) {
        k0 k0VarB;
        kotlin.jvm.internal.k.e(source, "source");
        if (source != this) {
            b.e(source.f12868b, 0L, j);
            while (j > 0) {
                k0 k0Var = source.f12867a;
                kotlin.jvm.internal.k.b(k0Var);
                int i2 = k0Var.f12874c;
                k0 k0Var2 = source.f12867a;
                kotlin.jvm.internal.k.b(k0Var2);
                long j3 = i2 - k0Var2.f12873b;
                int i8 = 0;
                if (j < j3) {
                    k0 k0Var3 = this.f12867a;
                    k0 k0Var4 = k0Var3 != null ? k0Var3.g : null;
                    if (k0Var4 != null && k0Var4.e) {
                        if ((((long) k0Var4.f12874c) + j) - ((long) (k0Var4.f12875d ? 0 : k0Var4.f12873b)) <= 8192) {
                            k0 k0Var5 = source.f12867a;
                            kotlin.jvm.internal.k.b(k0Var5);
                            k0Var5.d(k0Var4, (int) j);
                            source.f12868b -= j;
                            this.f12868b += j;
                            return;
                        }
                    }
                    k0 k0Var6 = source.f12867a;
                    kotlin.jvm.internal.k.b(k0Var6);
                    int i9 = (int) j;
                    if (i9 > 0 && i9 <= k0Var6.f12874c - k0Var6.f12873b) {
                        if (i9 >= 1024) {
                            k0VarB = k0Var6.c();
                        } else {
                            k0VarB = l0.b();
                            byte[] bArr = k0Var6.f12872a;
                            byte[] bArr2 = k0VarB.f12872a;
                            int i10 = k0Var6.f12873b;
                            r5.j.b0(0, i10, i10 + i9, bArr, bArr2);
                        }
                        k0VarB.f12874c = k0VarB.f12873b + i9;
                        k0Var6.f12873b += i9;
                        k0 k0Var7 = k0Var6.g;
                        kotlin.jvm.internal.k.b(k0Var7);
                        k0Var7.b(k0VarB);
                        source.f12867a = k0VarB;
                    } else {
                        throw new IllegalArgumentException("byteCount out of range");
                    }
                }
                k0 k0Var8 = source.f12867a;
                kotlin.jvm.internal.k.b(k0Var8);
                long j8 = k0Var8.f12874c - k0Var8.f12873b;
                source.f12867a = k0Var8.a();
                k0 k0Var9 = this.f12867a;
                if (k0Var9 == null) {
                    this.f12867a = k0Var8;
                    k0Var8.g = k0Var8;
                    k0Var8.f12876f = k0Var8;
                } else {
                    k0 k0Var10 = k0Var9.g;
                    kotlin.jvm.internal.k.b(k0Var10);
                    k0Var10.b(k0Var8);
                    k0 k0Var11 = k0Var8.g;
                    if (k0Var11 != k0Var8) {
                        kotlin.jvm.internal.k.b(k0Var11);
                        if (k0Var11.e) {
                            int i11 = k0Var8.f12874c - k0Var8.f12873b;
                            k0 k0Var12 = k0Var8.g;
                            kotlin.jvm.internal.k.b(k0Var12);
                            int i12 = 8192 - k0Var12.f12874c;
                            k0 k0Var13 = k0Var8.g;
                            kotlin.jvm.internal.k.b(k0Var13);
                            if (!k0Var13.f12875d) {
                                k0 k0Var14 = k0Var8.g;
                                kotlin.jvm.internal.k.b(k0Var14);
                                i8 = k0Var14.f12873b;
                            }
                            if (i11 <= i12 + i8) {
                                k0 k0Var15 = k0Var8.g;
                                kotlin.jvm.internal.k.b(k0Var15);
                                k0Var8.d(k0Var15, i11);
                                k0Var8.a();
                                l0.a(k0Var8);
                            }
                        }
                    } else {
                        throw new IllegalStateException("cannot compact");
                    }
                }
                source.f12868b -= j8;
                this.f12868b += j8;
                j -= j8;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        kotlin.jvm.internal.k.e(sink, "sink");
        k0 k0Var = this.f12867a;
        if (k0Var == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), k0Var.f12874c - k0Var.f12873b);
        sink.put(k0Var.f12872a, k0Var.f12873b, iMin);
        int i2 = k0Var.f12873b + iMin;
        k0Var.f12873b = i2;
        this.f12868b -= (long) iMin;
        if (i2 == k0Var.f12874c) {
            this.f12867a = k0Var.a();
            l0.a(k0Var);
        }
        return iMin;
    }

    public final int read(byte[] sink, int i2, int i8) {
        kotlin.jvm.internal.k.e(sink, "sink");
        b.e(sink.length, i2, i8);
        k0 k0Var = this.f12867a;
        if (k0Var == null) {
            return -1;
        }
        int iMin = Math.min(i8, k0Var.f12874c - k0Var.f12873b);
        byte[] bArr = k0Var.f12872a;
        int i9 = k0Var.f12873b;
        r5.j.b0(i2, i9, i9 + iMin, bArr, sink);
        int i10 = k0Var.f12873b + iMin;
        k0Var.f12873b = i10;
        this.f12868b -= (long) iMin;
        if (i10 == k0Var.f12874c) {
            this.f12867a = k0Var.a();
            l0.a(k0Var);
        }
        return iMin;
    }

    @Override // l7.k
    public final k B() {
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, l7.n0
    public final void close() {
    }

    @Override // l7.k, l7.n0, java.io.Flushable
    public final void flush() {
    }

    @Override // l7.l, l7.k
    public final j getBuffer() {
        return this;
    }

    @Override // l7.k
    public final k z() {
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        kotlin.jvm.internal.k.e(source, "source");
        int iRemaining = source.remaining();
        int i2 = iRemaining;
        while (i2 > 0) {
            k0 k0VarV = v(1);
            int iMin = Math.min(i2, 8192 - k0VarV.f12874c);
            source.get(k0VarV.f12872a, k0VarV.f12874c, iMin);
            i2 -= iMin;
            k0VarV.f12874c += iMin;
        }
        this.f12868b += (long) iRemaining;
        return iRemaining;
    }

    /* JADX INFO: renamed from: write, reason: collision with other method in class */
    public final void m3450write(byte[] source) {
        kotlin.jvm.internal.k.e(source, "source");
        m3451write(source, 0, source.length);
    }

    /* JADX INFO: renamed from: write, reason: collision with other method in class */
    public final void m3451write(byte[] source, int i2, int i8) {
        kotlin.jvm.internal.k.e(source, "source");
        long j = i8;
        b.e(source.length, i2, j);
        int i9 = i8 + i2;
        while (i2 < i9) {
            k0 k0VarV = v(1);
            int iMin = Math.min(i9 - i2, 8192 - k0VarV.f12874c);
            int i10 = i2 + iMin;
            r5.j.b0(k0VarV.f12874c, i2, i10, source, k0VarV.f12872a);
            k0VarV.f12874c += iMin;
            i2 = i10;
        }
        this.f12868b += j;
    }
}
