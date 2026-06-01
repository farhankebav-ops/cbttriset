package androidx.savedstate.serialization;

import android.os.Parcelable;
import androidx.savedstate.serialization.serializers.CharSequenceArraySerializer;
import androidx.savedstate.serialization.serializers.CharSequenceListSerializer;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultJavaSerializableSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.IBinderSerializer;
import androidx.savedstate.serialization.serializers.ParcelableArraySerializer;
import androidx.savedstate.serialization.serializers.ParcelableListSerializer;
import androidx.savedstate.serialization.serializers.SparseParcelableArraySerializer;
import b7.b;
import d7.g;
import e7.e;
import java.util.Arrays;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import l6.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateDecoder_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T decodeFormatSpecificTypesOnPlatform(SavedStateDecoder savedStateDecoder, b strategy) {
        k.e(savedStateDecoder, "<this>");
        k.e(strategy, "strategy");
        g descriptor = strategy.getDescriptor();
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceDescriptor())) {
            return (T) CharSequenceSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableDescriptor())) {
            return (T) DefaultParcelableSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicJavaSerializableDescriptor())) {
            return (T) DefaultJavaSerializableSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicIBinderDescriptor())) {
            return (T) IBinderSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceArrayDescriptor()) || k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceArrayDescriptor())) {
            return (T) CharSequenceArraySerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceListDescriptor()) || k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceListDescriptor())) {
            return (T) CharSequenceListSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableArrayDescriptor())) {
            Parcelable[] parcelableArrDeserialize = ParcelableArraySerializer.INSTANCE.deserialize((e) savedStateDecoder);
            return (T) Arrays.copyOf(parcelableArrDeserialize, parcelableArrDeserialize.length, a.a.B(getArrayKClass(strategy)));
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableArrayDescriptor())) {
            return (T) ParcelableArraySerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableListDescriptor()) || k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableListDescriptor())) {
            return (T) ParcelableListSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getSparseParcelableArrayDescriptor()) || k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor()) || k.a(descriptor, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
            return (T) SparseParcelableArraySerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        return null;
    }

    private static final c getArrayKClass(b bVar) {
        Object objDeserialize = bVar.deserialize(EmptyArrayDecoder.INSTANCE);
        k.b(objDeserialize);
        return b0.a(objDeserialize.getClass());
    }
}
