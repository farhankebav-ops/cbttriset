package androidx.savedstate.serialization.serializers;

import android.os.Parcelable;
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
public abstract class ParcelableSerializer<T extends Parcelable> implements c {
    private final g descriptor = q.q("android.os.Parcelable", new g[0]);

    @Override // b7.j, b7.b
    public final g getDescriptor() {
        return this.descriptor;
    }

    @Override // b7.b
    public final T deserialize(e decoder) {
        k.e(decoder, "decoder");
        if (!(decoder instanceof SavedStateDecoder)) {
            throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(this.descriptor.h(), decoder).toString());
        }
        SavedStateDecoder savedStateDecoder = (SavedStateDecoder) decoder;
        T t3 = (T) SavedStateReader.m129getParcelableimpl(SavedStateReader.m83constructorimpl(savedStateDecoder.getSavedState$savedstate_release()), savedStateDecoder.getKey$savedstate_release(), b0.a(Parcelable.class));
        k.c(t3, "null cannot be cast to non-null type T of androidx.savedstate.serialization.serializers.ParcelableSerializer");
        return t3;
    }

    @Override // b7.j
    public final void serialize(f encoder, T value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        if (!(encoder instanceof SavedStateEncoder)) {
            throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(this.descriptor.h(), encoder).toString());
        }
        SavedStateEncoder savedStateEncoder = (SavedStateEncoder) encoder;
        SavedStateWriter.m193putParcelableimpl(SavedStateWriter.m169constructorimpl(savedStateEncoder.getSavedState$savedstate_release()), savedStateEncoder.getKey$savedstate_release(), value);
    }
}
