package f7;

import com.ironsource.C2300e4;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t0 implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b7.c f11518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b7.c f11519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d7.h f11521d;

    public t0(b7.c cVar, b7.c cVar2, byte b8) {
        this.f11518a = cVar;
        this.f11519b = cVar2;
    }

    public final Object a(Object obj, Object obj2) {
        switch (this.f11520c) {
            case 0:
                return new s0(obj, obj2);
            default:
                return new q5.i(obj, obj2);
        }
    }

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        Object objA;
        Object obj = c1.f11429c;
        kotlin.jvm.internal.k.e(decoder, "decoder");
        d7.g descriptor = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor);
        boolean zDecodeSequentially = cVarBeginStructure.decodeSequentially();
        b7.c cVar = this.f11519b;
        b7.c cVar2 = this.f11518a;
        if (zDecodeSequentially) {
            objA = a(cVarBeginStructure.decodeSerializableElement(getDescriptor(), 0, cVar2, null), cVarBeginStructure.decodeSerializableElement(getDescriptor(), 1, cVar, null));
        } else {
            Object objDecodeSerializableElement = obj;
            Object objDecodeSerializableElement2 = objDecodeSerializableElement;
            while (true) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex != -1) {
                    if (iDecodeElementIndex == 0) {
                        objDecodeSerializableElement = cVarBeginStructure.decodeSerializableElement(getDescriptor(), 0, cVar2, null);
                    } else {
                        if (iDecodeElementIndex != 1) {
                            throw new b7.i(a1.a.g(iDecodeElementIndex, "Invalid index: "));
                        }
                        objDecodeSerializableElement2 = cVarBeginStructure.decodeSerializableElement(getDescriptor(), 1, cVar, null);
                    }
                } else {
                    if (objDecodeSerializableElement == obj) {
                        throw new b7.i("Element 'key' is missing");
                    }
                    if (objDecodeSerializableElement2 == obj) {
                        throw new b7.i("Element 'value' is missing");
                    }
                    objA = a(objDecodeSerializableElement, objDecodeSerializableElement2);
                }
            }
        }
        cVarBeginStructure.endStructure(descriptor);
        return objA;
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        switch (this.f11520c) {
        }
        return this.f11521d;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        Object key;
        Object value;
        e7.d dVarBeginStructure = fVar.beginStructure(getDescriptor());
        d7.g descriptor = getDescriptor();
        b7.c cVar = this.f11518a;
        switch (this.f11520c) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                kotlin.jvm.internal.k.e(entry, "<this>");
                key = entry.getKey();
                break;
            default:
                q5.i iVar = (q5.i) obj;
                kotlin.jvm.internal.k.e(iVar, "<this>");
                key = iVar.f13498a;
                break;
        }
        dVarBeginStructure.encodeSerializableElement(descriptor, 0, cVar, key);
        d7.g descriptor2 = getDescriptor();
        b7.c cVar2 = this.f11519b;
        switch (this.f11520c) {
            case 0:
                Map.Entry entry2 = (Map.Entry) obj;
                kotlin.jvm.internal.k.e(entry2, "<this>");
                value = entry2.getValue();
                break;
            default:
                q5.i iVar2 = (q5.i) obj;
                kotlin.jvm.internal.k.e(iVar2, "<this>");
                value = iVar2.f13499b;
                break;
        }
        dVarBeginStructure.encodeSerializableElement(descriptor2, 1, cVar2, value);
        dVarBeginStructure.endStructure(getDescriptor());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t0(final b7.c cVar, final b7.c cVar2, int i2) {
        this(cVar, cVar2, (byte) 0);
        this.f11520c = i2;
        switch (i2) {
            case 1:
                this(cVar, cVar2, (byte) 0);
                final int i8 = 1;
                this.f11521d = r2.q.p("kotlin.Pair", new d7.g[0], new e6.l() { // from class: f7.r0
                    @Override // e6.l
                    public final Object invoke(Object obj) {
                        d7.a buildSerialDescriptor = (d7.a) obj;
                        switch (i8) {
                            case 0:
                                kotlin.jvm.internal.k.e(buildSerialDescriptor, "$this$buildSerialDescriptor");
                                d7.a.a(buildSerialDescriptor, C2300e4.h.W, cVar.getDescriptor());
                                d7.a.a(buildSerialDescriptor, "value", cVar2.getDescriptor());
                                break;
                            default:
                                kotlin.jvm.internal.k.e(buildSerialDescriptor, "$this$buildClassSerialDescriptor");
                                d7.a.a(buildSerialDescriptor, "first", cVar.getDescriptor());
                                d7.a.a(buildSerialDescriptor, "second", cVar2.getDescriptor());
                                break;
                        }
                        return q5.x.f13520a;
                    }
                });
                break;
            default:
                final int i9 = 0;
                this.f11521d = r2.q.r("kotlin.collections.Map.Entry", d7.m.f11203d, new d7.g[0], new e6.l() { // from class: f7.r0
                    @Override // e6.l
                    public final Object invoke(Object obj) {
                        d7.a buildSerialDescriptor = (d7.a) obj;
                        switch (i9) {
                            case 0:
                                kotlin.jvm.internal.k.e(buildSerialDescriptor, "$this$buildSerialDescriptor");
                                d7.a.a(buildSerialDescriptor, C2300e4.h.W, cVar.getDescriptor());
                                d7.a.a(buildSerialDescriptor, "value", cVar2.getDescriptor());
                                break;
                            default:
                                kotlin.jvm.internal.k.e(buildSerialDescriptor, "$this$buildClassSerialDescriptor");
                                d7.a.a(buildSerialDescriptor, "first", cVar.getDescriptor());
                                d7.a.a(buildSerialDescriptor, "second", cVar2.getDescriptor());
                                break;
                        }
                        return q5.x.f13520a;
                    }
                });
                break;
        }
    }
}
