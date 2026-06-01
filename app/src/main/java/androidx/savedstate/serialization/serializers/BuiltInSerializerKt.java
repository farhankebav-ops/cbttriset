package androidx.savedstate.serialization.serializers;

import e7.e;
import e7.f;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class BuiltInSerializerKt {
    public static final String decoderErrorMessage(String serialName, e decoder) {
        k.e(serialName, "serialName");
        k.e(decoder, "decoder");
        return "Cannot deserialize " + serialName + " with '" + b0.a(decoder.getClass()).f() + "'. This serializer can only be used with SavedStateDecoder. Use 'decodeFromSavedState' instead.";
    }

    public static final String encoderErrorMessage(String serialName, f encoder) {
        k.e(serialName, "serialName");
        k.e(encoder, "encoder");
        return "Cannot serialize " + serialName + " with '" + b0.a(encoder.getClass()).f() + "'. This serializer can only be used with SavedStateEncoder. Use 'encodeToSavedState' instead.";
    }
}
