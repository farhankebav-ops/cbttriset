package h7;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class y extends e7.a implements g7.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g7.c f11781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f11782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f11783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i7.f f11784d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e2.f f11785f;
    public final g7.j g;
    public final m h;

    public y(g7.c cVar, d0 d0Var, b0 b0Var, d7.g descriptor, e2.f fVar) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        this.f11781a = cVar;
        this.f11782b = d0Var;
        this.f11783c = b0Var;
        this.f11784d = cVar.f11599b;
        this.e = -1;
        this.f11785f = fVar;
        g7.j jVar = cVar.f11598a;
        this.g = jVar;
        this.h = jVar.f11616d ? null : new m(descriptor);
    }

    @Override // g7.k
    public final g7.c a() {
        return this.f11781a;
    }

    @Override // g7.k
    public final g7.m b() {
        return new com.unity3d.scar.adapter.common.a(this.f11781a.f11598a, this.f11783c).e();
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Serializable, java.lang.Object, java.lang.Object[]] */
    @Override // e7.a, e7.e
    public final e7.c beginStructure(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        g7.c cVar = this.f11781a;
        d0 d0VarO = o.o(descriptor, cVar);
        b0 b0Var = this.f11783c;
        f2.g gVar = b0Var.f11742b;
        int i2 = gVar.f11326c + 1;
        gVar.f11326c = i2;
        Object[] objArr = (Object[]) gVar.f11325b;
        if (i2 == objArr.length) {
            int i8 = i2 * 2;
            ?? CopyOf = Arrays.copyOf(objArr, i8);
            kotlin.jvm.internal.k.d(CopyOf, "copyOf(...)");
            gVar.f11325b = CopyOf;
            int[] iArrCopyOf = Arrays.copyOf((int[]) gVar.f11327d, i8);
            kotlin.jvm.internal.k.d(iArrCopyOf, "copyOf(...)");
            gVar.f11327d = iArrCopyOf;
        }
        ((Object[]) gVar.f11325b)[i2] = descriptor;
        b0Var.g(d0VarO.f11752a);
        if (b0Var.q() != 4) {
            int iOrdinal = d0VarO.ordinal();
            return (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) ? new y(cVar, d0VarO, b0Var, descriptor, this.f11785f) : (this.f11782b == d0VarO && cVar.f11598a.f11616d) ? this : new y(cVar, d0VarO, b0Var, descriptor, this.f11785f);
        }
        b0.m(b0Var, "Unexpected leading comma", 0, null, 6);
        throw null;
    }

    @Override // e7.a, e7.e
    public final boolean decodeBoolean() {
        boolean z2;
        boolean z7;
        b0 b0Var = this.f11783c;
        int iT = b0Var.t();
        String str = b0Var.e;
        if (iT == str.length()) {
            b0.m(b0Var, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(iT) == '\"') {
            iT++;
            z2 = true;
        } else {
            z2 = false;
        }
        int iS = b0Var.s(iT);
        if (iS >= str.length() || iS == -1) {
            b0.m(b0Var, "EOF", 0, null, 6);
            throw null;
        }
        int i2 = iS + 1;
        int iCharAt = str.charAt(iS) | ' ';
        if (iCharAt == 102) {
            b0Var.c(i2, "alse");
            z7 = false;
        } else {
            if (iCharAt != 116) {
                b0.m(b0Var, "Expected valid boolean literal prefix, but had '" + b0Var.j() + '\'', 0, null, 6);
                throw null;
            }
            b0Var.c(i2, "rue");
            z7 = true;
        }
        if (!z2) {
            return z7;
        }
        if (b0Var.f11741a == str.length()) {
            b0.m(b0Var, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(b0Var.f11741a) == '\"') {
            b0Var.f11741a++;
            return z7;
        }
        b0.m(b0Var, "Expected closing quotation mark", 0, null, 6);
        throw null;
    }

    @Override // e7.a, e7.e
    public final byte decodeByte() {
        b0 b0Var = this.f11783c;
        long jH = b0Var.h();
        byte b8 = (byte) jH;
        if (jH == b8) {
            return b8;
        }
        b0.m(b0Var, "Failed to parse byte for input '" + jH + '\'', 0, null, 6);
        throw null;
    }

    @Override // e7.a, e7.e
    public final char decodeChar() {
        b0 b0Var = this.f11783c;
        String strJ = b0Var.j();
        if (strJ.length() == 1) {
            return strJ.charAt(0);
        }
        b0.m(b0Var, androidx.camera.core.processing.util.a.f('\'', "Expected single char, but got '", strJ), 0, null, 6);
        throw null;
    }

    @Override // e7.a, e7.e
    public final double decodeDouble() {
        b0 b0Var = this.f11783c;
        String strJ = b0Var.j();
        try {
            double d8 = Double.parseDouble(strJ);
            if (!Double.isInfinite(d8) && !Double.isNaN(d8)) {
                return d8;
            }
            o.p(b0Var, Double.valueOf(d8));
            throw null;
        } catch (IllegalArgumentException unused) {
            b0.m(b0Var, androidx.camera.core.processing.util.a.f('\'', "Failed to parse type 'double' for input '", strJ), 0, null, 6);
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e7.c
    public final int decodeElementIndex(d7.g descriptor) {
        String strD;
        b0 b0Var = this.f11783c;
        f2.g gVar = b0Var.f11742b;
        String str = b0Var.e;
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        d0 d0Var = this.f11782b;
        int iOrdinal = d0Var.ordinal();
        char c7 = ':';
        int i2 = 0;
        zU = false;
        boolean zU = false;
        int i8 = -1;
        if (iOrdinal == 0) {
            boolean zU2 = b0Var.u();
            while (true) {
                boolean zB = b0Var.b();
                m mVar = this.h;
                if (zB) {
                    strD = b0Var.d();
                    b0Var.g(c7);
                    int i9 = o.i(descriptor, this.f11781a, strD);
                    if (i9 != -3) {
                        if (mVar != null) {
                            f7.w wVar = mVar.f11764a;
                            if (i9 < 64) {
                                wVar.f11534c |= 1 << i9;
                            } else {
                                int i10 = (i9 >>> 6) - 1;
                                long[] jArr = wVar.f11535d;
                                jArr[i10] = jArr[i10] | (1 << (i9 & 63));
                            }
                        }
                        i8 = i9;
                    } else {
                        if (!this.g.f11614b) {
                            e2.f fVar = this.f11785f;
                            if (fVar == null || !kotlin.jvm.internal.k.a(fVar.f11230b, strD)) {
                                break;
                            }
                            fVar.f11230b = null;
                        }
                        ArrayList arrayList = new ArrayList();
                        byte bQ = b0Var.q();
                        if (bQ == 8 || bQ == 6) {
                            while (true) {
                                byte bQ2 = b0Var.q();
                                if (bQ2 == 1) {
                                    b0Var.d();
                                } else {
                                    if (bQ2 == 8 || bQ2 == 6) {
                                        arrayList.add(Byte.valueOf(bQ2));
                                    } else if (bQ2 == 9) {
                                        if (((Number) r5.l.d1(arrayList)).byteValue() != 8) {
                                            throw o.d("found ] instead of } at path: " + gVar, str, b0Var.f11741a);
                                        }
                                        r5.l.h1(arrayList);
                                    } else if (bQ2 == 7) {
                                        if (((Number) r5.l.d1(arrayList)).byteValue() != 6) {
                                            throw o.d("found } instead of ] at path: " + gVar, str, b0Var.f11741a);
                                        }
                                        r5.l.h1(arrayList);
                                    } else if (bQ2 == 10) {
                                        b0.m(b0Var, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6);
                                        throw null;
                                    }
                                    b0Var.e();
                                    if (arrayList.size() == 0) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            b0Var.j();
                        }
                        zU2 = b0Var.u();
                        c7 = ':';
                    }
                } else {
                    if (zU2) {
                        o.k(b0Var, "object");
                        throw null;
                    }
                    if (mVar != null) {
                        f7.w wVar2 = mVar.f11764a;
                        l lVar = wVar2.f11533b;
                        d7.g gVar2 = wVar2.f11532a;
                        int iD = gVar2.d();
                        while (true) {
                            long j = wVar2.f11534c;
                            long j3 = -1;
                            if (j != -1) {
                                int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j);
                                wVar2.f11534c |= 1 << iNumberOfTrailingZeros;
                                if (((Boolean) lVar.invoke(gVar2, Integer.valueOf(iNumberOfTrailingZeros))).booleanValue()) {
                                    i8 = iNumberOfTrailingZeros;
                                    break;
                                }
                            } else if (iD > 64) {
                                long[] jArr2 = wVar2.f11535d;
                                int length = jArr2.length;
                                loop3: while (i2 < length) {
                                    int i11 = i2 + 1;
                                    int i12 = i11 * 64;
                                    long j8 = jArr2[i2];
                                    while (j8 != j3) {
                                        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(~j8);
                                        j8 |= 1 << iNumberOfTrailingZeros2;
                                        int i13 = iNumberOfTrailingZeros2 + i12;
                                        if (((Boolean) lVar.invoke(gVar2, Integer.valueOf(i13))).booleanValue()) {
                                            jArr2[i2] = j8;
                                            i8 = i13;
                                            break loop3;
                                        }
                                        j3 = -1;
                                    }
                                    jArr2[i2] = j8;
                                    i2 = i11;
                                    j3 = -1;
                                }
                            }
                        }
                    } else {
                        i8 = -1;
                    }
                }
            }
            b0Var.l(n6.m.C0(strD, str.subSequence(0, b0Var.f11741a).toString(), 6), androidx.camera.core.processing.util.a.f('\'', "Encountered an unknown key '", strD), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
            throw null;
        }
        if (iOrdinal != 2) {
            boolean zU3 = b0Var.u();
            if (b0Var.b()) {
                int i14 = this.e;
                if (i14 != -1 && !zU3) {
                    b0.m(b0Var, "Expected end of the array or comma", 0, null, 6);
                    throw null;
                }
                i8 = i14 + 1;
                this.e = i8;
            } else if (zU3) {
                o.k(b0Var, "array");
                throw null;
            }
        } else {
            int i15 = this.e;
            byte b8 = i15 % 2 != 0;
            if (b8 != true) {
                b0Var.g(':');
            } else if (i15 != -1) {
                zU = b0Var.u();
            }
            if (b0Var.b()) {
                if (b8 != false) {
                    if (this.e == -1) {
                        int i16 = b0Var.f11741a;
                        if (zU) {
                            b0.m(b0Var, "Unexpected leading comma", i16, null, 4);
                            throw null;
                        }
                    } else {
                        int i17 = b0Var.f11741a;
                        if (!zU) {
                            b0.m(b0Var, "Expected comma after the key-value pair", i17, null, 4);
                            throw null;
                        }
                    }
                }
                i8 = this.e + 1;
                this.e = i8;
            } else if (zU) {
                o.k(b0Var, "object");
                throw null;
            }
        }
        if (d0Var != d0.e) {
            ((int[]) gVar.f11327d)[gVar.f11326c] = i8;
        }
        return i8;
    }

    @Override // e7.a, e7.e
    public final int decodeEnum(d7.g enumDescriptor) {
        kotlin.jvm.internal.k.e(enumDescriptor, "enumDescriptor");
        b0 b0Var = this.f11783c;
        return o.j(enumDescriptor, this.f11781a, b0Var.i(), " at path ".concat(b0Var.f11742b.b()));
    }

    @Override // e7.a, e7.e
    public final float decodeFloat() {
        b0 b0Var = this.f11783c;
        String strJ = b0Var.j();
        try {
            float f4 = Float.parseFloat(strJ);
            if (!Float.isInfinite(f4) && !Float.isNaN(f4)) {
                return f4;
            }
            o.p(b0Var, Float.valueOf(f4));
            throw null;
        } catch (IllegalArgumentException unused) {
            b0.m(b0Var, androidx.camera.core.processing.util.a.f('\'', "Failed to parse type 'float' for input '", strJ), 0, null, 6);
            throw null;
        }
    }

    @Override // e7.a, e7.e
    public final e7.e decodeInline(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return a0.a(descriptor) ? new j(this.f11783c, this.f11781a) : super.decodeInline(descriptor);
    }

    @Override // e7.a, e7.e
    public final int decodeInt() {
        b0 b0Var = this.f11783c;
        long jH = b0Var.h();
        int i2 = (int) jH;
        if (jH == i2) {
            return i2;
        }
        b0.m(b0Var, "Failed to parse int for input '" + jH + '\'', 0, null, 6);
        throw null;
    }

    @Override // e7.a, e7.e
    public final long decodeLong() {
        return this.f11783c.h();
    }

    @Override // e7.a, e7.e
    public final boolean decodeNotNullMark() {
        m mVar = this.h;
        if (!(mVar != null ? mVar.f11765b : false)) {
            b0 b0Var = this.f11783c;
            int iS = b0Var.s(b0Var.t());
            String str = b0Var.e;
            int length = str.length() - iS;
            boolean z2 = false;
            if (length >= 4 && iS != -1) {
                int i2 = 0;
                while (true) {
                    if (i2 < 4) {
                        if ("null".charAt(i2) != str.charAt(iS + i2)) {
                            break;
                        }
                        i2++;
                    } else if (length <= 4 || o.f(str.charAt(iS + 4)) != 0) {
                        z2 = true;
                        b0Var.f11741a = iS + 4;
                    }
                }
            }
            if (!z2) {
                return true;
            }
        }
        return false;
    }

    @Override // e7.a, e7.e
    public final Void decodeNull() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.Serializable, java.lang.Object, java.lang.Object[]] */
    @Override // e7.a, e7.c
    public final Object decodeSerializableElement(d7.g descriptor, int i2, b7.b deserializer, Object obj) {
        f2.g gVar = this.f11783c.f11742b;
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        kotlin.jvm.internal.k.e(deserializer, "deserializer");
        boolean z2 = this.f11782b == d0.e && (i2 & 1) == 0;
        if (z2) {
            int[] iArr = (int[]) gVar.f11327d;
            int i8 = gVar.f11326c;
            if (iArr[i8] == -2) {
                ((Object[]) gVar.f11325b)[i8] = p.f11767a;
            }
        }
        Object objDecodeSerializableElement = super.decodeSerializableElement(descriptor, i2, deserializer, obj);
        if (z2) {
            int[] iArr2 = (int[]) gVar.f11327d;
            int i9 = gVar.f11326c;
            if (iArr2[i9] != -2) {
                int i10 = i9 + 1;
                gVar.f11326c = i10;
                Object[] objArr = (Object[]) gVar.f11325b;
                if (i10 == objArr.length) {
                    int i11 = i10 * 2;
                    ?? CopyOf = Arrays.copyOf(objArr, i11);
                    kotlin.jvm.internal.k.d(CopyOf, "copyOf(...)");
                    gVar.f11325b = CopyOf;
                    int[] iArrCopyOf = Arrays.copyOf((int[]) gVar.f11327d, i11);
                    kotlin.jvm.internal.k.d(iArrCopyOf, "copyOf(...)");
                    gVar.f11327d = iArrCopyOf;
                }
            }
            Object[] objArr2 = (Object[]) gVar.f11325b;
            int i12 = gVar.f11326c;
            objArr2[i12] = objDecodeSerializableElement;
            ((int[]) gVar.f11327d)[i12] = -2;
        }
        return objDecodeSerializableElement;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011f  */
    @Override // e7.a, e7.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object decodeSerializableValue(b7.b r11) {
        /*
            Method dump skipped, instruction units count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h7.y.decodeSerializableValue(b7.b):java.lang.Object");
    }

    @Override // e7.a, e7.e
    public final short decodeShort() {
        b0 b0Var = this.f11783c;
        long jH = b0Var.h();
        short s7 = (short) jH;
        if (jH == s7) {
            return s7;
        }
        b0.m(b0Var, "Failed to parse short for input '" + jH + '\'', 0, null, 6);
        throw null;
    }

    @Override // e7.a, e7.e
    public final String decodeString() {
        return this.f11783c.i();
    }

    @Override // e7.a, e7.c
    public final void endStructure(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        if (this.f11781a.f11598a.f11614b && descriptor.d() == 0) {
            while (decodeElementIndex(descriptor) != -1) {
            }
        }
        b0 b0Var = this.f11783c;
        if (b0Var.u()) {
            o.k(b0Var, "");
            throw null;
        }
        b0Var.g(this.f11782b.f11753b);
        f2.g gVar = b0Var.f11742b;
        int i2 = gVar.f11326c;
        int[] iArr = (int[]) gVar.f11327d;
        if (iArr[i2] == -2) {
            iArr[i2] = -1;
            gVar.f11326c = i2 - 1;
        }
        int i8 = gVar.f11326c;
        if (i8 != -1) {
            gVar.f11326c = i8 - 1;
        }
    }

    @Override // e7.e, e7.c
    public final i7.f getSerializersModule() {
        return this.f11784d;
    }
}
