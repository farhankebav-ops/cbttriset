package h7;

import com.ironsource.C2300e4;
import f7.h0;
import f7.n0;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class r implements g7.p, e7.f, e7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g7.c f11770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e6.l f11771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g7.j f11772d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f11773f;
    public final /* synthetic */ int g;
    public Object h;

    public r(g7.c cVar, e6.l lVar, char c7) {
        this.f11769a = new ArrayList();
        this.f11770b = cVar;
        this.f11771c = lVar;
        this.f11772d = cVar.f11598a;
    }

    @Override // g7.p
    public final g7.c a() {
        return this.f11770b;
    }

    @Override // g7.p
    public final void b(g7.m element) {
        kotlin.jvm.internal.k.e(element, "element");
        if (this.e == null || (element instanceof g7.x)) {
            encodeSerializableValue(g7.o.f11619a, element);
        } else {
            o.q(element, this.f11773f);
            throw null;
        }
    }

    @Override // e7.f
    public final e7.d beginCollection(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return beginStructure(descriptor);
    }

    @Override // e7.f
    public final e7.d beginStructure(d7.g descriptor) {
        r rVar;
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        e6.l nodeConsumer = r5.l.e1(this.f11769a) == null ? this.f11771c : new androidx.camera.core.impl.utils.a(this, 10);
        a.a kind = descriptor.getKind();
        boolean zA = kotlin.jvm.internal.k.a(kind, d7.m.f11202c);
        g7.c cVar = this.f11770b;
        if (zA || (kind instanceof d7.d)) {
            rVar = new r(cVar, nodeConsumer, 2);
        } else if (kotlin.jvm.internal.k.a(kind, d7.m.f11203d)) {
            d7.g gVarE = o.e(descriptor.g(0), cVar.f11599b);
            a.a kind2 = gVarE.getKind();
            if ((kind2 instanceof d7.f) || kotlin.jvm.internal.k.a(kind2, d7.l.f11200b)) {
                kotlin.jvm.internal.k.e(nodeConsumer, "nodeConsumer");
                v vVar = new v(cVar, nodeConsumer, 1);
                vVar.j = true;
                rVar = vVar;
            } else {
                if (!cVar.f11598a.f11615c) {
                    throw o.b(gVarE);
                }
                rVar = new r(cVar, nodeConsumer, 2);
            }
        } else {
            rVar = new r(cVar, nodeConsumer, 1);
        }
        String str = this.e;
        if (str != null) {
            if (rVar instanceof v) {
                v vVar2 = (v) rVar;
                vVar2.j(g7.n.b(str), C2300e4.h.W);
                String strH = this.f11773f;
                if (strH == null) {
                    strH = descriptor.h();
                }
                vVar2.j(g7.n.b(strH), "value");
            } else {
                String strH2 = this.f11773f;
                if (strH2 == null) {
                    strH2 = descriptor.h();
                }
                rVar.j(g7.n.b(strH2), str);
            }
            this.e = null;
            this.f11773f = null;
        }
        return rVar;
    }

    public final void c(d7.g descriptor, int i2, b7.j serializer, Object obj) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        kotlin.jvm.internal.k.e(serializer, "serializer");
        this.f11769a.add(h(descriptor, i2));
        r2.q.S(this, serializer, obj);
    }

    public final void d(Object obj, double d8) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.e(tag, "tag");
        j(g7.n.a(Double.valueOf(d8)), tag);
        this.f11772d.getClass();
        if (Double.isInfinite(d8) || Double.isNaN(d8)) {
            Double dValueOf = Double.valueOf(d8);
            String output = g().toString();
            kotlin.jvm.internal.k.e(output, "output");
            throw new n(o.s(dValueOf, tag, output));
        }
    }

    public final void e(Object obj, float f4) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.e(tag, "tag");
        j(g7.n.a(Float.valueOf(f4)), tag);
        this.f11772d.getClass();
        if (Float.isInfinite(f4) || Float.isNaN(f4)) {
            Float fValueOf = Float.valueOf(f4);
            String output = g().toString();
            kotlin.jvm.internal.k.e(output, "output");
            throw new n(o.s(fValueOf, tag, output));
        }
    }

    @Override // e7.f
    public final void encodeBoolean(boolean z2) {
        String tag = (String) i();
        kotlin.jvm.internal.k.e(tag, "tag");
        Boolean boolValueOf = Boolean.valueOf(z2);
        h0 h0Var = g7.n.f11618a;
        j(new g7.r(boolValueOf, false, null), tag);
    }

    @Override // e7.d
    public final void encodeBooleanElement(d7.g descriptor, int i2, boolean z2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        String strH = h(descriptor, i2);
        Boolean boolValueOf = Boolean.valueOf(z2);
        h0 h0Var = g7.n.f11618a;
        j(new g7.r(boolValueOf, false, null), strH);
    }

    @Override // e7.f
    public final void encodeByte(byte b8) {
        String tag = (String) i();
        kotlin.jvm.internal.k.e(tag, "tag");
        j(g7.n.a(Byte.valueOf(b8)), tag);
    }

    @Override // e7.d
    public final void encodeByteElement(d7.g descriptor, int i2, byte b8) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        j(g7.n.a(Byte.valueOf(b8)), h(descriptor, i2));
    }

    @Override // e7.f
    public final void encodeChar(char c7) {
        String tag = (String) i();
        kotlin.jvm.internal.k.e(tag, "tag");
        j(g7.n.b(String.valueOf(c7)), tag);
    }

    @Override // e7.d
    public final void encodeCharElement(d7.g descriptor, int i2, char c7) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        j(g7.n.b(String.valueOf(c7)), h(descriptor, i2));
    }

    @Override // e7.f
    public final void encodeDouble(double d8) {
        d(i(), d8);
    }

    @Override // e7.d
    public final void encodeDoubleElement(d7.g descriptor, int i2, double d8) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        d(h(descriptor, i2), d8);
    }

    @Override // e7.f
    public final void encodeEnum(d7.g enumDescriptor, int i2) {
        kotlin.jvm.internal.k.e(enumDescriptor, "enumDescriptor");
        String tag = (String) i();
        kotlin.jvm.internal.k.e(tag, "tag");
        j(g7.n.b(enumDescriptor.e(i2)), tag);
    }

    @Override // e7.f
    public final void encodeFloat(float f4) {
        e(i(), f4);
    }

    @Override // e7.d
    public final void encodeFloatElement(d7.g descriptor, int i2, float f4) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        e(h(descriptor, i2), f4);
    }

    @Override // e7.f
    public final e7.f encodeInline(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        if (r5.l.e1(this.f11769a) == null) {
            return new r(this.f11770b, this.f11771c, 0).encodeInline(descriptor);
        }
        if (this.e != null) {
            this.f11773f = descriptor.h();
        }
        return f(i(), descriptor);
    }

    @Override // e7.d
    public final e7.f encodeInlineElement(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return f(h(descriptor, i2), ((n0) descriptor).g(i2));
    }

    @Override // e7.f
    public final void encodeInt(int i2) {
        String tag = (String) i();
        kotlin.jvm.internal.k.e(tag, "tag");
        j(g7.n.a(Integer.valueOf(i2)), tag);
    }

    @Override // e7.d
    public final void encodeIntElement(d7.g descriptor, int i2, int i8) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        j(g7.n.a(Integer.valueOf(i8)), h(descriptor, i2));
    }

    @Override // e7.f
    public final void encodeLong(long j) {
        String tag = (String) i();
        kotlin.jvm.internal.k.e(tag, "tag");
        j(g7.n.a(Long.valueOf(j)), tag);
    }

    @Override // e7.d
    public final void encodeLongElement(d7.g descriptor, int i2, long j) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        j(g7.n.a(Long.valueOf(j)), h(descriptor, i2));
    }

    @Override // e7.f
    public final void encodeNull() {
        String str = (String) r5.l.e1(this.f11769a);
        if (str == null) {
            this.f11771c.invoke(g7.u.INSTANCE);
        } else {
            j(g7.u.INSTANCE, str);
        }
    }

    @Override // e7.d
    public void encodeNullableSerializableElement(d7.g descriptor, int i2, b7.j serializer, Object obj) {
        switch (this.g) {
            case 1:
                kotlin.jvm.internal.k.e(descriptor, "descriptor");
                kotlin.jvm.internal.k.e(serializer, "serializer");
                if (obj != null || this.f11772d.f11616d) {
                    c(descriptor, i2, serializer, obj);
                }
                break;
            default:
                c(descriptor, i2, serializer, obj);
                break;
        }
    }

    @Override // e7.d
    public final void encodeSerializableElement(d7.g descriptor, int i2, b7.j serializer, Object obj) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        kotlin.jvm.internal.k.e(serializer, "serializer");
        this.f11769a.add(h(descriptor, i2));
        encodeSerializableValue(serializer, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
    @Override // e7.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void encodeSerializableValue(b7.j r5, java.lang.Object r6) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h7.r.encodeSerializableValue(b7.j, java.lang.Object):void");
    }

    @Override // e7.f
    public final void encodeShort(short s7) {
        String tag = (String) i();
        kotlin.jvm.internal.k.e(tag, "tag");
        j(g7.n.a(Short.valueOf(s7)), tag);
    }

    @Override // e7.d
    public final void encodeShortElement(d7.g descriptor, int i2, short s7) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        j(g7.n.a(Short.valueOf(s7)), h(descriptor, i2));
    }

    @Override // e7.f
    public final void encodeString(String value) {
        kotlin.jvm.internal.k.e(value, "value");
        String tag = (String) i();
        kotlin.jvm.internal.k.e(tag, "tag");
        j(g7.n.b(value), tag);
    }

    @Override // e7.d
    public final void encodeStringElement(d7.g descriptor, int i2, String value) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        kotlin.jvm.internal.k.e(value, "value");
        j(g7.n.b(value), h(descriptor, i2));
    }

    @Override // e7.d
    public final void endStructure(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        if (!this.f11769a.isEmpty()) {
            i();
        }
        this.f11771c.invoke(g());
    }

    public final e7.f f(Object obj, d7.g inlineDescriptor) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.e(tag, "tag");
        kotlin.jvm.internal.k.e(inlineDescriptor, "inlineDescriptor");
        if (a0.a(inlineDescriptor)) {
            return new b(this, tag);
        }
        if (inlineDescriptor.isInline() && inlineDescriptor.equals(g7.n.f11618a)) {
            return new b(this, tag, inlineDescriptor);
        }
        this.f11769a.add(tag);
        return this;
    }

    public g7.m g() {
        switch (this.g) {
            case 0:
                g7.m mVar = (g7.m) this.h;
                if (mVar != null) {
                    return mVar;
                }
                throw new IllegalArgumentException("Primitive element has not been recorded. Is call to .encodeXxx is missing in serializer?");
            case 1:
                return new g7.x((LinkedHashMap) this.h);
            default:
                return new g7.e((ArrayList) this.h);
        }
    }

    @Override // e7.f
    public final i7.f getSerializersModule() {
        return this.f11770b.f11599b;
    }

    public final String h(d7.g descriptor, int i2) {
        String nestedName;
        kotlin.jvm.internal.k.e(descriptor, "<this>");
        switch (this.g) {
            case 2:
                kotlin.jvm.internal.k.e(descriptor, "descriptor");
                nestedName = String.valueOf(i2);
                break;
            default:
                kotlin.jvm.internal.k.e(descriptor, "descriptor");
                g7.c json = this.f11770b;
                kotlin.jvm.internal.k.e(json, "json");
                o.m(descriptor, json);
                nestedName = descriptor.e(i2);
                break;
        }
        kotlin.jvm.internal.k.e(nestedName, "nestedName");
        return nestedName;
    }

    public final Object i() {
        ArrayList arrayList = this.f11769a;
        if (arrayList.isEmpty()) {
            throw new b7.i("No tag in stack for requested element");
        }
        return arrayList.remove(r5.m.G0(arrayList));
    }

    public void j(g7.m element, String key) {
        switch (this.g) {
            case 0:
                kotlin.jvm.internal.k.e(key, "key");
                kotlin.jvm.internal.k.e(element, "element");
                if (key != "primitive") {
                    throw new IllegalArgumentException("This output can only consume primitives with 'primitive' tag");
                }
                if (((g7.m) this.h) != null) {
                    throw new IllegalArgumentException("Primitive element was already recorded. Does call to .encodeXxx happen more than once?");
                }
                this.h = element;
                this.f11771c.invoke(element);
                return;
            case 1:
                kotlin.jvm.internal.k.e(key, "key");
                kotlin.jvm.internal.k.e(element, "element");
                ((LinkedHashMap) this.h).put(key, element);
                return;
            default:
                kotlin.jvm.internal.k.e(key, "key");
                kotlin.jvm.internal.k.e(element, "element");
                ((ArrayList) this.h).add(Integer.parseInt(key), element);
                return;
        }
    }

    @Override // e7.d
    public final boolean shouldEncodeElementDefault(d7.g descriptor, int i2) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return this.f11772d.f11613a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(g7.c json, e6.l nodeConsumer, int i2) {
        this(json, nodeConsumer, (char) 0);
        this.g = i2;
        switch (i2) {
            case 1:
                kotlin.jvm.internal.k.e(json, "json");
                kotlin.jvm.internal.k.e(nodeConsumer, "nodeConsumer");
                this(json, nodeConsumer, (char) 0);
                this.h = new LinkedHashMap();
                break;
            case 2:
                kotlin.jvm.internal.k.e(json, "json");
                kotlin.jvm.internal.k.e(nodeConsumer, "nodeConsumer");
                this(json, nodeConsumer, (char) 0);
                this.h = new ArrayList();
                break;
            default:
                kotlin.jvm.internal.k.e(json, "json");
                kotlin.jvm.internal.k.e(nodeConsumer, "nodeConsumer");
                this.f11769a.add("primitive");
                break;
        }
    }

    @Override // e7.f
    public final void encodeNotNullMark() {
    }
}
