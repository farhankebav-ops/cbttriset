package androidx.savedstate.serialization;

import d7.g;
import i7.f;
import i7.h;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class EmptyArrayDecoder extends e7.a {
    public static final EmptyArrayDecoder INSTANCE = new EmptyArrayDecoder();
    private static final f serializersModule = h.f12046a;

    private EmptyArrayDecoder() {
    }

    @Override // e7.c
    public int decodeElementIndex(g descriptor) {
        k.e(descriptor, "descriptor");
        return -1;
    }

    @Override // e7.e, e7.c
    public f getSerializersModule() {
        return serializersModule;
    }
}
