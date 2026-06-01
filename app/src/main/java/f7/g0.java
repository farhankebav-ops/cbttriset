package f7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g0 extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b7.c f11457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b7.c f11458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f0 f11460d;

    public g0(b7.c cVar, b7.c cVar2, byte b8) {
        this.f11457a = cVar;
        this.f11458b = cVar2;
    }

    @Override // f7.a
    public final Object a() {
        switch (this.f11459c) {
            case 0:
                return new HashMap();
            default:
                return new LinkedHashMap();
        }
    }

    @Override // f7.a
    public final int b(Object obj) {
        int size;
        switch (this.f11459c) {
            case 0:
                HashMap map = (HashMap) obj;
                kotlin.jvm.internal.k.e(map, "<this>");
                size = map.size();
                break;
            default:
                LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
                kotlin.jvm.internal.k.e(linkedHashMap, "<this>");
                size = linkedHashMap.size();
                break;
        }
        return size * 2;
    }

    @Override // f7.a
    public final void c(int i2, Object obj) {
        switch (this.f11459c) {
            case 0:
                kotlin.jvm.internal.k.e((HashMap) obj, "<this>");
                break;
            default:
                kotlin.jvm.internal.k.e((LinkedHashMap) obj, "<this>");
                break;
        }
    }

    @Override // f7.a
    public final Iterator d(Object obj) {
        switch (this.f11459c) {
            case 0:
                Map map = (Map) obj;
                kotlin.jvm.internal.k.e(map, "<this>");
                return map.entrySet().iterator();
            default:
                Map map2 = (Map) obj;
                kotlin.jvm.internal.k.e(map2, "<this>");
                return map2.entrySet().iterator();
        }
    }

    @Override // f7.a
    public final int e(Object obj) {
        switch (this.f11459c) {
            case 0:
                Map map = (Map) obj;
                kotlin.jvm.internal.k.e(map, "<this>");
                return map.size();
            default:
                Map map2 = (Map) obj;
                kotlin.jvm.internal.k.e(map2, "<this>");
                return map2.size();
        }
    }

    @Override // f7.a
    public final void g(e7.c cVar, Object obj, int i2, int i8) {
        Map builder = (Map) obj;
        kotlin.jvm.internal.k.e(builder, "builder");
        if (i8 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        k6.b bVarW0 = r2.q.w0(r2.q.D0(0, i8 * 2), 2);
        int i9 = bVarW0.f12709a;
        int i10 = bVarW0.f12710b;
        int i11 = bVarW0.f12711c;
        if ((i11 <= 0 || i9 > i10) && (i11 >= 0 || i10 > i9)) {
            return;
        }
        while (true) {
            k(cVar, i2 + i9, builder, false);
            if (i9 == i10) {
                return;
            } else {
                i9 += i11;
            }
        }
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        switch (this.f11459c) {
        }
        return this.f11460d;
    }

    @Override // f7.a
    public final /* bridge */ /* synthetic */ void h(e7.c cVar, int i2, Object obj) {
        k(cVar, i2, (Map) obj, true);
    }

    @Override // f7.a
    public final Object i(Object obj) {
        switch (this.f11459c) {
            case 0:
                kotlin.jvm.internal.k.e(null, "<this>");
                return new HashMap((Map) null);
            default:
                kotlin.jvm.internal.k.e(null, "<this>");
                return new LinkedHashMap((Map) null);
        }
    }

    @Override // f7.a
    public final Object j(Object obj) {
        switch (this.f11459c) {
            case 0:
                HashMap map = (HashMap) obj;
                kotlin.jvm.internal.k.e(map, "<this>");
                return map;
            default:
                LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
                kotlin.jvm.internal.k.e(linkedHashMap, "<this>");
                return linkedHashMap;
        }
    }

    public final void k(e7.c cVar, int i2, Map builder, boolean z2) {
        int iDecodeElementIndex;
        kotlin.jvm.internal.k.e(builder, "builder");
        Object objDecodeSerializableElement = cVar.decodeSerializableElement(getDescriptor(), i2, this.f11457a, null);
        if (z2) {
            iDecodeElementIndex = cVar.decodeElementIndex(getDescriptor());
            if (iDecodeElementIndex != i2 + 1) {
                throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("Value must follow key in a map, index for key: ", i2, ", returned index for value: ", iDecodeElementIndex).toString());
            }
        } else {
            iDecodeElementIndex = i2 + 1;
        }
        boolean zContainsKey = builder.containsKey(objDecodeSerializableElement);
        b7.c cVar2 = this.f11458b;
        builder.put(objDecodeSerializableElement, (!zContainsKey || (cVar2.getDescriptor().getKind() instanceof d7.f)) ? cVar.decodeSerializableElement(getDescriptor(), iDecodeElementIndex, cVar2, null) : cVar.decodeSerializableElement(getDescriptor(), iDecodeElementIndex, cVar2, r5.x.b0(builder, objDecodeSerializableElement)));
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        int iE = e(obj);
        d7.g descriptor = getDescriptor();
        e7.d dVarBeginCollection = fVar.beginCollection(descriptor, iE);
        Iterator itD = d(obj);
        int i2 = 0;
        while (itD.hasNext()) {
            Map.Entry entry = (Map.Entry) itD.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i8 = i2 + 1;
            dVarBeginCollection.encodeSerializableElement(getDescriptor(), i2, this.f11457a, key);
            i2 += 2;
            dVarBeginCollection.encodeSerializableElement(getDescriptor(), i8, this.f11458b, value);
        }
        dVarBeginCollection.endStructure(descriptor);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g0(b7.c kSerializer, b7.c vSerializer, int i2) {
        this(kSerializer, vSerializer, (byte) 0);
        this.f11459c = i2;
        switch (i2) {
            case 1:
                kotlin.jvm.internal.k.e(kSerializer, "kSerializer");
                kotlin.jvm.internal.k.e(vSerializer, "vSerializer");
                this(kSerializer, vSerializer, (byte) 0);
                d7.g keyDesc = kSerializer.getDescriptor();
                d7.g valueDesc = vSerializer.getDescriptor();
                kotlin.jvm.internal.k.e(keyDesc, "keyDesc");
                kotlin.jvm.internal.k.e(valueDesc, "valueDesc");
                this.f11460d = new f0("kotlin.collections.LinkedHashMap", keyDesc, valueDesc);
                break;
            default:
                kotlin.jvm.internal.k.e(kSerializer, "kSerializer");
                kotlin.jvm.internal.k.e(vSerializer, "vSerializer");
                d7.g keyDesc2 = kSerializer.getDescriptor();
                d7.g valueDesc2 = vSerializer.getDescriptor();
                kotlin.jvm.internal.k.e(keyDesc2, "keyDesc");
                kotlin.jvm.internal.k.e(valueDesc2, "valueDesc");
                this.f11460d = new f0("kotlin.collections.HashMap", keyDesc2, valueDesc2);
                break;
        }
    }
}
