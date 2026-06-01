package h7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class z extends e7.b implements g7.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f11786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g7.c f11787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f11788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g7.p[] f11789d;
    public final i7.f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g7.j f11790f;
    public boolean g;
    public String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f11791i;

    public z(g composer, g7.c cVar, d0 d0Var, g7.p[] pVarArr) {
        kotlin.jvm.internal.k.e(composer, "composer");
        this.f11786a = composer;
        this.f11787b = cVar;
        this.f11788c = d0Var;
        this.f11789d = pVarArr;
        this.e = cVar.f11599b;
        this.f11790f = cVar.f11598a;
        int iOrdinal = d0Var.ordinal();
        if (pVarArr != null) {
            g7.p pVar = pVarArr[iOrdinal];
            if (pVar == null && pVar == this) {
                return;
            }
            pVarArr[iOrdinal] = this;
        }
    }

    @Override // g7.p
    public final g7.c a() {
        return this.f11787b;
    }

    @Override // g7.p
    public final void b(g7.m element) {
        kotlin.jvm.internal.k.e(element, "element");
        if (this.h == null || (element instanceof g7.x)) {
            encodeSerializableValue(g7.o.f11619a, element);
        } else {
            o.q(element, this.f11791i);
            throw null;
        }
    }

    @Override // e7.b, e7.f
    public final e7.d beginStructure(d7.g descriptor) {
        g7.p pVar;
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        g7.c cVar = this.f11787b;
        d0 d0VarO = o.o(descriptor, cVar);
        char c7 = d0VarO.f11752a;
        g gVar = this.f11786a;
        gVar.c(c7);
        gVar.f11759b = true;
        String str = this.h;
        if (str != null) {
            String strH = this.f11791i;
            if (strH == null) {
                strH = descriptor.h();
            }
            gVar.a();
            encodeString(str);
            gVar.c(':');
            encodeString(strH);
            this.h = null;
            this.f11791i = null;
        }
        if (this.f11788c == d0VarO) {
            return this;
        }
        g7.p[] pVarArr = this.f11789d;
        return (pVarArr == null || (pVar = pVarArr[d0VarO.ordinal()]) == null) ? new z(gVar, cVar, d0VarO, pVarArr) : pVar;
    }

    @Override // e7.b, e7.f
    public final void encodeBoolean(boolean z2) {
        if (this.g) {
            encodeString(String.valueOf(z2));
        } else {
            this.f11786a.f11758a.j(String.valueOf(z2));
        }
    }

    @Override // e7.b, e7.f
    public final void encodeByte(byte b8) {
        if (this.g) {
            encodeString(String.valueOf((int) b8));
        } else {
            this.f11786a.b(b8);
        }
    }

    @Override // e7.b, e7.f
    public final void encodeChar(char c7) {
        encodeString(String.valueOf(c7));
    }

    @Override // e7.b, e7.f
    public final void encodeDouble(double d8) {
        boolean z2 = this.g;
        g gVar = this.f11786a;
        if (z2) {
            encodeString(String.valueOf(d8));
        } else {
            gVar.f11758a.j(String.valueOf(d8));
        }
        if (Double.isInfinite(d8) || Double.isNaN(d8)) {
            throw o.a(gVar.f11758a.toString(), Double.valueOf(d8));
        }
    }

    @Override // e7.b
    public final boolean encodeElement(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        int iOrdinal = this.f11788c.ordinal();
        g gVar = this.f11786a;
        if (iOrdinal == 1) {
            if (!gVar.f11759b) {
                gVar.c(',');
            }
            gVar.a();
            return true;
        }
        boolean z2 = false;
        if (iOrdinal == 2) {
            if (gVar.f11759b) {
                this.g = true;
                gVar.a();
                return true;
            }
            if (i2 % 2 == 0) {
                gVar.c(',');
                gVar.a();
                z2 = true;
            } else {
                gVar.c(':');
                gVar.i();
            }
            this.g = z2;
            return true;
        }
        if (iOrdinal == 3) {
            if (i2 == 0) {
                this.g = true;
            }
            if (i2 == 1) {
                gVar.c(',');
                gVar.i();
                this.g = false;
            }
            return true;
        }
        if (!gVar.f11759b) {
            gVar.c(',');
        }
        gVar.a();
        o.m(descriptor, this.f11787b);
        encodeString(descriptor.e(i2));
        gVar.c(':');
        gVar.i();
        return true;
    }

    @Override // e7.b, e7.f
    public final void encodeEnum(d7.g enumDescriptor, int i2) {
        kotlin.jvm.internal.k.e(enumDescriptor, "enumDescriptor");
        encodeString(enumDescriptor.e(i2));
    }

    @Override // e7.b, e7.f
    public final void encodeFloat(float f4) {
        boolean z2 = this.g;
        g gVar = this.f11786a;
        if (z2) {
            encodeString(String.valueOf(f4));
        } else {
            gVar.f11758a.j(String.valueOf(f4));
        }
        if (Float.isInfinite(f4) || Float.isNaN(f4)) {
            throw o.a(gVar.f11758a.toString(), Float.valueOf(f4));
        }
    }

    @Override // e7.b, e7.f
    public final e7.f encodeInline(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        boolean zA = a0.a(descriptor);
        d0 d0Var = this.f11788c;
        g7.c cVar = this.f11787b;
        g hVar = this.f11786a;
        if (zA) {
            if (!(hVar instanceof i)) {
                hVar = new i(hVar.f11758a, this.g);
            }
            return new z(hVar, cVar, d0Var, null);
        }
        if (descriptor.isInline() && descriptor.equals(g7.n.f11618a)) {
            if (!(hVar instanceof h)) {
                hVar = new h(hVar.f11758a, this.g);
            }
            return new z(hVar, cVar, d0Var, null);
        }
        if (this.h == null) {
            return super.encodeInline(descriptor);
        }
        this.f11791i = descriptor.h();
        return this;
    }

    @Override // e7.b, e7.f
    public final void encodeInt(int i2) {
        if (this.g) {
            encodeString(String.valueOf(i2));
        } else {
            this.f11786a.d(i2);
        }
    }

    @Override // e7.b, e7.f
    public final void encodeLong(long j) {
        if (this.g) {
            encodeString(String.valueOf(j));
        } else {
            this.f11786a.e(j);
        }
    }

    @Override // e7.b, e7.f
    public final void encodeNull() {
        this.f11786a.f("null");
    }

    @Override // e7.b, e7.d
    public final void encodeNullableSerializableElement(d7.g descriptor, int i2, b7.j serializer, Object obj) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        kotlin.jvm.internal.k.e(serializer, "serializer");
        if (obj != null || this.f11790f.f11616d) {
            super.encodeNullableSerializableElement(descriptor, i2, serializer, obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    @Override // e7.b, e7.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void encodeSerializableValue(b7.j r5, java.lang.Object r6) {
        /*
            r4 = this;
            java.lang.String r0 = "serializer"
            kotlin.jvm.internal.k.e(r5, r0)
            g7.c r0 = r4.f11787b
            g7.j r1 = r0.f11598a
            boolean r2 = r5 instanceof f7.b
            if (r2 == 0) goto L14
            g7.a r1 = r1.h
            g7.a r3 = g7.a.f11594a
            if (r1 == r3) goto L4b
            goto L42
        L14:
            g7.a r1 = r1.h
            int r1 = r1.ordinal()
            if (r1 == 0) goto L4b
            r3 = 1
            if (r1 == r3) goto L2a
            r0 = 2
            if (r1 != r0) goto L23
            goto L4b
        L23:
            e2.s r5 = new e2.s
            r6 = 3
            r5.<init>(r6)
            throw r5
        L2a:
            d7.g r1 = r5.getDescriptor()
            a.a r1 = r1.getKind()
            d7.m r3 = d7.m.f11201b
            boolean r3 = kotlin.jvm.internal.k.a(r1, r3)
            if (r3 != 0) goto L42
            d7.m r3 = d7.m.e
            boolean r1 = kotlin.jvm.internal.k.a(r1, r3)
            if (r1 == 0) goto L4b
        L42:
            d7.g r1 = r5.getDescriptor()
            java.lang.String r0 = h7.o.h(r1, r0)
            goto L4c
        L4b:
            r0 = 0
        L4c:
            if (r2 == 0) goto La8
            r1 = r5
            f7.b r1 = (f7.b) r1
            if (r6 == 0) goto L85
            b7.j r1 = n7.b.q(r1, r4, r6)
            if (r0 == 0) goto L78
            boolean r5 = r5 instanceof b7.g
            if (r5 != 0) goto L5e
            goto L78
        L5e:
            d7.g r5 = r1.getDescriptor()
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.k.e(r5, r2)
            java.util.Set r5 = f7.c1.b(r5)
            boolean r5 = r5.contains(r0)
            if (r5 != 0) goto L72
            goto L78
        L72:
            java.lang.ClassCastException r5 = new java.lang.ClassCastException
            r5.<init>()
            throw r5
        L78:
            d7.g r5 = r1.getDescriptor()
            a.a r5 = r5.getKind()
            h7.o.g(r5)
            r5 = r1
            goto La8
        L85:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Value for serializer "
            r5.<init>(r6)
            b7.f r1 = (b7.f) r1
            d7.g r6 = r1.getDescriptor()
            r5.append(r6)
            java.lang.String r6 = " should always be non-null. Please report issue to the kotlinx.serialization tracker."
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        La8:
            if (r0 == 0) goto Lb6
            d7.g r1 = r5.getDescriptor()
            java.lang.String r1 = r1.h()
            r4.h = r0
            r4.f11791i = r1
        Lb6:
            r5.serialize(r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h7.z.encodeSerializableValue(b7.j, java.lang.Object):void");
    }

    @Override // e7.b, e7.f
    public final void encodeShort(short s7) {
        if (this.g) {
            encodeString(String.valueOf((int) s7));
        } else {
            this.f11786a.g(s7);
        }
    }

    @Override // e7.b, e7.f
    public final void encodeString(String value) {
        kotlin.jvm.internal.k.e(value, "value");
        this.f11786a.h(value);
    }

    @Override // e7.b, e7.d
    public final void endStructure(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        g gVar = this.f11786a;
        gVar.getClass();
        gVar.f11759b = false;
        gVar.c(this.f11788c.f11753b);
    }

    @Override // e7.f
    public final i7.f getSerializersModule() {
        return this.e;
    }

    @Override // e7.b, e7.d
    public final boolean shouldEncodeElementDefault(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return this.f11790f.f11613a;
    }
}
