package h7;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import f7.h0;
import f7.n0;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements g7.k, e7.e, e7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11732a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g7.c f11734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11735d;
    public final g7.j e;

    public a(g7.c cVar, String str) {
        this.f11734c = cVar;
        this.f11735d = str;
        this.e = cVar.f11598a;
    }

    @Override // g7.k
    public final g7.c a() {
        return this.f11734c;
    }

    @Override // g7.k
    public final g7.m b() {
        return d();
    }

    @Override // e7.e
    public e7.c beginStructure(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        g7.m mVarD = d();
        a.a kind = descriptor.getKind();
        boolean zA = kotlin.jvm.internal.k.a(kind, d7.m.f11202c);
        g7.c cVar = this.f11734c;
        if (zA || (kind instanceof d7.d)) {
            String strH = descriptor.h();
            if (mVarD instanceof g7.e) {
                return new t(cVar, (g7.e) mVarD);
            }
            throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.e.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarD.getClass()).f() + " as the serialized body of " + strH + " at element: " + s(), mVarD.toString(), -1);
        }
        if (!kotlin.jvm.internal.k.a(kind, d7.m.f11203d)) {
            String strH2 = descriptor.h();
            if (mVarD instanceof g7.x) {
                return new s(cVar, (g7.x) mVarD, this.f11735d, 8);
            }
            throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.x.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarD.getClass()).f() + " as the serialized body of " + strH2 + " at element: " + s(), mVarD.toString(), -1);
        }
        d7.g gVarE = o.e(descriptor.g(0), cVar.f11599b);
        a.a kind2 = gVarE.getKind();
        if ((kind2 instanceof d7.f) || kotlin.jvm.internal.k.a(kind2, d7.l.f11200b)) {
            String strH3 = descriptor.h();
            if (mVarD instanceof g7.x) {
                return new u(cVar, (g7.x) mVarD);
            }
            throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.x.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarD.getClass()).f() + " as the serialized body of " + strH3 + " at element: " + s(), mVarD.toString(), -1);
        }
        if (!cVar.f11598a.f11615c) {
            throw o.b(gVarE);
        }
        String strH4 = descriptor.h();
        if (mVarD instanceof g7.e) {
            return new t(cVar, (g7.e) mVarD);
        }
        throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.e.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarD.getClass()).f() + " as the serialized body of " + strH4 + " at element: " + s(), mVarD.toString(), -1);
    }

    public abstract g7.m c(String str);

    public final g7.m d() {
        g7.m mVarC;
        String str = (String) r5.l.e1(this.f11732a);
        return (str == null || (mVarC = c(str)) == null) ? q() : mVarC;
    }

    @Override // e7.e
    public final boolean decodeBoolean() {
        return e(r());
    }

    @Override // e7.c
    public final boolean decodeBooleanElement(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return e(p(descriptor, i2));
    }

    @Override // e7.e
    public final byte decodeByte() {
        return f(r());
    }

    @Override // e7.c
    public final byte decodeByteElement(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return f(p(descriptor, i2));
    }

    @Override // e7.e
    public final char decodeChar() {
        return g(r());
    }

    @Override // e7.c
    public final char decodeCharElement(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return g(p(descriptor, i2));
    }

    @Override // e7.c
    public final int decodeCollectionSize(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return -1;
    }

    @Override // e7.e
    public final double decodeDouble() {
        return h(r());
    }

    @Override // e7.c
    public final double decodeDoubleElement(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return h(p(descriptor, i2));
    }

    @Override // e7.e
    public final int decodeEnum(d7.g enumDescriptor) {
        kotlin.jvm.internal.k.e(enumDescriptor, "enumDescriptor");
        String tag = (String) r();
        kotlin.jvm.internal.k.e(tag, "tag");
        g7.m mVarC = c(tag);
        String strH = enumDescriptor.h();
        if (mVarC instanceof g7.b0) {
            return o.j(enumDescriptor, this.f11734c, ((g7.b0) mVarC).a(), "");
        }
        throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.b0.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarC.getClass()).f() + " as the serialized body of " + strH + " at element: " + t(tag), mVarC.toString(), -1);
    }

    @Override // e7.e
    public final float decodeFloat() {
        return i(r());
    }

    @Override // e7.c
    public final float decodeFloatElement(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return i(p(descriptor, i2));
    }

    @Override // e7.e
    public final e7.e decodeInline(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        if (r5.l.e1(this.f11732a) != null) {
            return j(r(), descriptor);
        }
        return new q(this.f11734c, q(), this.f11735d).decodeInline(descriptor);
    }

    @Override // e7.c
    public final e7.e decodeInlineElement(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return j(p(descriptor, i2), ((n0) descriptor).g(i2));
    }

    @Override // e7.e
    public final int decodeInt() {
        return k(r());
    }

    @Override // e7.c
    public final int decodeIntElement(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return k(p(descriptor, i2));
    }

    @Override // e7.e
    public final long decodeLong() {
        return l(r());
    }

    @Override // e7.c
    public final long decodeLongElement(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return l(p(descriptor, i2));
    }

    @Override // e7.e
    public boolean decodeNotNullMark() {
        return !(d() instanceof g7.u);
    }

    @Override // e7.e
    public final Void decodeNull() {
        return null;
    }

    @Override // e7.c
    public final Object decodeNullableSerializableElement(d7.g descriptor, int i2, b7.b deserializer, Object obj) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        kotlin.jvm.internal.k.e(deserializer, "deserializer");
        this.f11732a.add(p(descriptor, i2));
        Object objDecodeSerializableValue = (deserializer.getDescriptor().b() || decodeNotNullMark()) ? decodeSerializableValue(deserializer) : null;
        if (!this.f11733b) {
            r();
        }
        this.f11733b = false;
        return objDecodeSerializableValue;
    }

    @Override // e7.c
    public final boolean decodeSequentially() {
        return false;
    }

    @Override // e7.c
    public final Object decodeSerializableElement(d7.g descriptor, int i2, b7.b deserializer, Object obj) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        kotlin.jvm.internal.k.e(deserializer, "deserializer");
        this.f11732a.add(p(descriptor, i2));
        kotlin.jvm.internal.k.e(deserializer, "deserializer");
        Object objDecodeSerializableValue = decodeSerializableValue(deserializer);
        if (!this.f11733b) {
            r();
        }
        this.f11733b = false;
        return objDecodeSerializableValue;
    }

    @Override // e7.e
    public final Object decodeSerializableValue(b7.b deserializer) {
        kotlin.jvm.internal.k.e(deserializer, "deserializer");
        if (!(deserializer instanceof f7.b)) {
            return deserializer.deserialize(this);
        }
        g7.c cVar = this.f11734c;
        g7.j jVar = cVar.f11598a;
        b7.f fVar = (b7.f) ((f7.b) deserializer);
        String strH = o.h(fVar.getDescriptor(), cVar);
        g7.m mVarD = d();
        String strH2 = fVar.getDescriptor().h();
        if (!(mVarD instanceof g7.x)) {
            throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.x.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarD.getClass()).f() + " as the serialized body of " + strH2 + " at element: " + s(), mVarD.toString(), -1);
        }
        g7.x xVar = (g7.x) mVarD;
        g7.m mVar = (g7.m) xVar.get(strH);
        String strA = null;
        if (mVar != null) {
            g7.b0 b0VarE = g7.n.e(mVar);
            if (!(b0VarE instanceof g7.u)) {
                strA = b0VarE.a();
            }
        }
        try {
            return o.n(cVar, strH, xVar, n7.b.p((f7.b) deserializer, this, strA));
        } catch (b7.i e) {
            String message = e.getMessage();
            kotlin.jvm.internal.k.b(message);
            throw o.d(message, xVar.toString(), -1);
        }
    }

    @Override // e7.e
    public final short decodeShort() {
        return m(r());
    }

    @Override // e7.c
    public final short decodeShortElement(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return m(p(descriptor, i2));
    }

    @Override // e7.e
    public final String decodeString() {
        return n(r());
    }

    @Override // e7.c
    public final String decodeStringElement(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return n(p(descriptor, i2));
    }

    public final boolean e(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.e(tag, "tag");
        g7.m mVarC = c(tag);
        if (!(mVarC instanceof g7.b0)) {
            throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.b0.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarC.getClass()).f() + " as the serialized body of boolean at element: " + t(tag), mVarC.toString(), -1);
        }
        g7.b0 b0Var = (g7.b0) mVarC;
        try {
            h0 h0Var = g7.n.f11618a;
            String strA = b0Var.a();
            String[] strArr = c0.f11746a;
            kotlin.jvm.internal.k.e(strA, "<this>");
            Boolean bool = strA.equalsIgnoreCase(com.ironsource.mediationsdk.metadata.a.g) ? Boolean.TRUE : strA.equalsIgnoreCase("false") ? Boolean.FALSE : null;
            if (bool != null) {
                return bool.booleanValue();
            }
            u(b0Var, TypedValues.Custom.S_BOOLEAN, tag);
            throw null;
        } catch (IllegalArgumentException unused) {
            u(b0Var, TypedValues.Custom.S_BOOLEAN, tag);
            throw null;
        }
    }

    @Override // e7.c
    public void endStructure(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
    }

    public final byte f(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.e(tag, "tag");
        g7.m mVarC = c(tag);
        if (!(mVarC instanceof g7.b0)) {
            throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.b0.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarC.getClass()).f() + " as the serialized body of byte at element: " + t(tag), mVarC.toString(), -1);
        }
        g7.b0 b0Var = (g7.b0) mVarC;
        try {
            int iD = g7.n.d(b0Var);
            Byte bValueOf = (-128 > iD || iD > 127) ? null : Byte.valueOf((byte) iD);
            if (bValueOf != null) {
                return bValueOf.byteValue();
            }
            u(b0Var, "byte", tag);
            throw null;
        } catch (IllegalArgumentException unused) {
            u(b0Var, "byte", tag);
            throw null;
        }
    }

    public final char g(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.e(tag, "tag");
        g7.m mVarC = c(tag);
        if (!(mVarC instanceof g7.b0)) {
            throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.b0.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarC.getClass()).f() + " as the serialized body of char at element: " + t(tag), mVarC.toString(), -1);
        }
        g7.b0 b0Var = (g7.b0) mVarC;
        try {
            String strA = b0Var.a();
            kotlin.jvm.internal.k.e(strA, "<this>");
            int length = strA.length();
            if (length == 0) {
                throw new NoSuchElementException("Char sequence is empty.");
            }
            if (length == 1) {
                return strA.charAt(0);
            }
            throw new IllegalArgumentException("Char sequence has more than one element.");
        } catch (IllegalArgumentException unused) {
            u(b0Var, "char", tag);
            throw null;
        }
    }

    @Override // e7.e, e7.c
    public final i7.f getSerializersModule() {
        return this.f11734c.f11599b;
    }

    public final double h(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.e(tag, "tag");
        g7.m mVarC = c(tag);
        if (!(mVarC instanceof g7.b0)) {
            throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.b0.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarC.getClass()).f() + " as the serialized body of double at element: " + t(tag), mVarC.toString(), -1);
        }
        g7.b0 b0Var = (g7.b0) mVarC;
        try {
            h0 h0Var = g7.n.f11618a;
            double d8 = Double.parseDouble(b0Var.a());
            g7.j jVar = this.f11734c.f11598a;
            if (!Double.isInfinite(d8) && !Double.isNaN(d8)) {
                return d8;
            }
            Double dValueOf = Double.valueOf(d8);
            String output = d().toString();
            kotlin.jvm.internal.k.e(output, "output");
            throw o.c(-1, o.s(dValueOf, tag, output));
        } catch (IllegalArgumentException unused) {
            u(b0Var, "double", tag);
            throw null;
        }
    }

    public final float i(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.e(tag, "tag");
        g7.m mVarC = c(tag);
        if (!(mVarC instanceof g7.b0)) {
            throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.b0.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarC.getClass()).f() + " as the serialized body of float at element: " + t(tag), mVarC.toString(), -1);
        }
        g7.b0 b0Var = (g7.b0) mVarC;
        try {
            h0 h0Var = g7.n.f11618a;
            float f4 = Float.parseFloat(b0Var.a());
            g7.j jVar = this.f11734c.f11598a;
            if (!Float.isInfinite(f4) && !Float.isNaN(f4)) {
                return f4;
            }
            Float fValueOf = Float.valueOf(f4);
            String output = d().toString();
            kotlin.jvm.internal.k.e(output, "output");
            throw o.c(-1, o.s(fValueOf, tag, output));
        } catch (IllegalArgumentException unused) {
            u(b0Var, TypedValues.Custom.S_FLOAT, tag);
            throw null;
        }
    }

    public final e7.e j(Object obj, d7.g inlineDescriptor) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.e(tag, "tag");
        kotlin.jvm.internal.k.e(inlineDescriptor, "inlineDescriptor");
        if (!a0.a(inlineDescriptor)) {
            this.f11732a.add(tag);
            return this;
        }
        g7.m mVarC = c(tag);
        String strH = inlineDescriptor.h();
        if (mVarC instanceof g7.b0) {
            String source = ((g7.b0) mVarC).a();
            g7.c json = this.f11734c;
            kotlin.jvm.internal.k.e(json, "json");
            kotlin.jvm.internal.k.e(source, "source");
            return new j(new b0(source), json);
        }
        throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.b0.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarC.getClass()).f() + " as the serialized body of " + strH + " at element: " + t(tag), mVarC.toString(), -1);
    }

    public final int k(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.e(tag, "tag");
        g7.m mVarC = c(tag);
        if (mVarC instanceof g7.b0) {
            g7.b0 b0Var = (g7.b0) mVarC;
            try {
                return g7.n.d(b0Var);
            } catch (IllegalArgumentException unused) {
                u(b0Var, "int", tag);
                throw null;
            }
        }
        throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.b0.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarC.getClass()).f() + " as the serialized body of int at element: " + t(tag), mVarC.toString(), -1);
    }

    public final long l(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.e(tag, "tag");
        g7.m mVarC = c(tag);
        if (mVarC instanceof g7.b0) {
            g7.b0 b0Var = (g7.b0) mVarC;
            try {
                h0 h0Var = g7.n.f11618a;
                try {
                    return new b0(b0Var.a()).h();
                } catch (k e) {
                    throw new NumberFormatException(e.getMessage());
                }
            } catch (IllegalArgumentException unused) {
                u(b0Var, "long", tag);
                throw null;
            }
        }
        throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.b0.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarC.getClass()).f() + " as the serialized body of long at element: " + t(tag), mVarC.toString(), -1);
    }

    public final short m(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.e(tag, "tag");
        g7.m mVarC = c(tag);
        if (!(mVarC instanceof g7.b0)) {
            throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.b0.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarC.getClass()).f() + " as the serialized body of short at element: " + t(tag), mVarC.toString(), -1);
        }
        g7.b0 b0Var = (g7.b0) mVarC;
        try {
            int iD = g7.n.d(b0Var);
            Short shValueOf = (-32768 > iD || iD > 32767) ? null : Short.valueOf((short) iD);
            if (shValueOf != null) {
                return shValueOf.shortValue();
            }
            u(b0Var, "short", tag);
            throw null;
        } catch (IllegalArgumentException unused) {
            u(b0Var, "short", tag);
            throw null;
        }
    }

    public final String n(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.e(tag, "tag");
        g7.m mVarC = c(tag);
        if (!(mVarC instanceof g7.b0)) {
            throw o.d("Expected " + kotlin.jvm.internal.b0.a(g7.b0.class).f() + ", but had " + kotlin.jvm.internal.b0.a(mVarC.getClass()).f() + " as the serialized body of string at element: " + t(tag), mVarC.toString(), -1);
        }
        g7.b0 b0Var = (g7.b0) mVarC;
        if (!(b0Var instanceof g7.r)) {
            StringBuilder sbY = a1.a.y("Expected string value for a non-null key '", tag, "', got null literal instead at element: ");
            sbY.append(t(tag));
            throw o.d(sbY.toString(), d().toString(), -1);
        }
        g7.r rVar = (g7.r) b0Var;
        if (rVar.f11621a) {
            return rVar.f11623c;
        }
        g7.j jVar = this.f11734c.f11598a;
        StringBuilder sbY2 = a1.a.y("String literal for key '", tag, "' should be quoted at element: ");
        sbY2.append(t(tag));
        sbY2.append(".\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.");
        throw o.d(sbY2.toString(), d().toString(), -1);
    }

    public String o(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return descriptor.e(i2);
    }

    public final String p(d7.g gVar, int i2) {
        kotlin.jvm.internal.k.e(gVar, "<this>");
        String nestedName = o(gVar, i2);
        kotlin.jvm.internal.k.e(nestedName, "nestedName");
        return nestedName;
    }

    public abstract g7.m q();

    public final Object r() {
        ArrayList arrayList = this.f11732a;
        Object objRemove = arrayList.remove(r5.m.G0(arrayList));
        this.f11733b = true;
        return objRemove;
    }

    public final String s() {
        ArrayList arrayList = this.f11732a;
        return arrayList.isEmpty() ? "$" : r5.l.c1(arrayList, ".", "$.", null, null, 60);
    }

    public final String t(String currentTag) {
        kotlin.jvm.internal.k.e(currentTag, "currentTag");
        return s() + '.' + currentTag;
    }

    public final void u(g7.b0 b0Var, String str, String str2) {
        throw o.d("Failed to parse literal '" + b0Var + "' as " + (n6.t.n0(str, "i", false) ? "an " : "a ").concat(str) + " value at element: " + t(str2), d().toString(), -1);
    }
}
