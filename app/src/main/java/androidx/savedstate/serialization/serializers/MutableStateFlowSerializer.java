package androidx.savedstate.serialization.serializers;

import b7.c;
import d7.f;
import d7.g;
import d7.o;
import e7.e;
import kotlin.jvm.internal.k;
import n6.m;
import r2.q;
import t6.d1;
import t6.q0;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableStateFlowSerializer<T> implements c {
    private final g descriptor;
    private final c valueSerializer;

    public MutableStateFlowSerializer(c valueSerializer) {
        g oVar;
        k.e(valueSerializer, "valueSerializer");
        this.valueSerializer = valueSerializer;
        a.a kind = valueSerializer.getDescriptor().getKind();
        if (kind instanceof f) {
            oVar = q.e("kotlinx.coroutines.flow.MutableStateFlow", (f) kind);
        } else {
            g original = valueSerializer.getDescriptor();
            k.e(original, "original");
            if (m.A0("kotlinx.coroutines.flow.MutableStateFlow")) {
                throw new IllegalArgumentException("Blank serial names are prohibited");
            }
            if (original.getKind() instanceof f) {
                throw new IllegalArgumentException("For primitive descriptors please use 'PrimitiveSerialDescriptor' instead");
            }
            if ("kotlinx.coroutines.flow.MutableStateFlow".equals(original.h())) {
                throw new IllegalArgumentException(("The name of the wrapped descriptor (kotlinx.coroutines.flow.MutableStateFlow) cannot be the same as the name of the original descriptor (" + original.h() + ')').toString());
            }
            oVar = new o(original);
        }
        this.descriptor = oVar;
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return this.descriptor;
    }

    @Override // b7.b
    public q0 deserialize(e decoder) {
        k.e(decoder, "decoder");
        return x0.c(decoder.decodeSerializableValue(this.valueSerializer));
    }

    @Override // b7.j
    public void serialize(e7.f encoder, q0 value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        encoder.encodeSerializableValue(this.valueSerializer, ((d1) value).getValue());
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }
}
