package b7;

import androidx.activity.u;
import f7.c1;
import java.util.List;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlin.jvm.internal.e f4148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f4149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d7.b f4150c;

    public a(kotlin.jvm.internal.e eVar, c[] cVarArr) {
        this.f4148a = eVar;
        this.f4149b = r5.j.X(cVarArr);
        u uVar = new u(this);
        this.f4150c = new d7.b(q.r("kotlinx.serialization.ContextualSerializer", d7.k.f11199b, new d7.g[0], uVar), eVar);
    }

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        i7.f serializersModule = decoder.getSerializersModule();
        List list = this.f4149b;
        kotlin.jvm.internal.e eVar = this.f4148a;
        c cVarB = serializersModule.b(eVar, list);
        if (cVarB != null) {
            return decoder.decodeSerializableValue(cVarB);
        }
        c1.i(eVar);
        throw null;
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return this.f4150c;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object value) {
        kotlin.jvm.internal.k.e(value, "value");
        i7.f serializersModule = fVar.getSerializersModule();
        List list = this.f4149b;
        kotlin.jvm.internal.e eVar = this.f4148a;
        c cVarB = serializersModule.b(eVar, list);
        if (cVarB != null) {
            fVar.encodeSerializableValue(cVarB, value);
        } else {
            c1.i(eVar);
            throw null;
        }
    }
}
