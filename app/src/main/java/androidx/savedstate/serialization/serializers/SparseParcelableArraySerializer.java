package androidx.savedstate.serialization.serializers;

import android.os.Parcelable;
import android.util.SparseArray;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import b7.c;
import d7.g;
import e7.e;
import e7.f;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SparseParcelableArraySerializer implements c {
    public static final SparseParcelableArraySerializer INSTANCE = new SparseParcelableArraySerializer();
    private static final g descriptor = q.q("android.util.SparseArray<android.os.Parcelable>", new g[0]);

    private SparseParcelableArraySerializer() {
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.b
    public SparseArray<Parcelable> deserialize(e decoder) {
        k.e(decoder, "decoder");
        if (!(decoder instanceof SavedStateDecoder)) {
            throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(INSTANCE.getDescriptor().h(), decoder).toString());
        }
        SavedStateDecoder savedStateDecoder = (SavedStateDecoder) decoder;
        return SavedStateReader.m151getSparseParcelableArrayimpl(SavedStateReader.m83constructorimpl(savedStateDecoder.getSavedState$savedstate_release()), savedStateDecoder.getKey$savedstate_release(), b0.a(Parcelable.class));
    }

    @Override // b7.j
    public void serialize(f encoder, SparseArray<Parcelable> value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        if (!(encoder instanceof SavedStateEncoder)) {
            throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(INSTANCE.getDescriptor().h(), encoder).toString());
        }
        SavedStateEncoder savedStateEncoder = (SavedStateEncoder) encoder;
        SavedStateWriter.m201putSparseParcelableArrayimpl(SavedStateWriter.m169constructorimpl(savedStateEncoder.getSavedState$savedstate_release()), savedStateEncoder.getKey$savedstate_release(), value);
    }
}
