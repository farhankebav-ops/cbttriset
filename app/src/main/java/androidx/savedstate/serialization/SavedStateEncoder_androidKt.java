package androidx.savedstate.serialization;

import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.savedstate.serialization.serializers.CharSequenceArraySerializer;
import androidx.savedstate.serialization.serializers.CharSequenceListSerializer;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultJavaSerializableSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.IBinderSerializer;
import androidx.savedstate.serialization.serializers.ParcelableArraySerializer;
import androidx.savedstate.serialization.serializers.ParcelableListSerializer;
import androidx.savedstate.serialization.serializers.SparseParcelableArraySerializer;
import b7.j;
import d7.g;
import e7.f;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateEncoder_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean encodeFormatSpecificTypesOnPlatform(SavedStateEncoder savedStateEncoder, j strategy, T t3) {
        k.e(savedStateEncoder, "<this>");
        k.e(strategy, "strategy");
        g descriptor = strategy.getDescriptor();
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceDescriptor())) {
            CharSequenceSerializer charSequenceSerializer = CharSequenceSerializer.INSTANCE;
            k.c(t3, "null cannot be cast to non-null type kotlin.CharSequence");
            charSequenceSerializer.serialize((f) savedStateEncoder, (CharSequence) t3);
            return true;
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableDescriptor())) {
            DefaultParcelableSerializer defaultParcelableSerializer = DefaultParcelableSerializer.INSTANCE;
            k.c(t3, "null cannot be cast to non-null type android.os.Parcelable");
            defaultParcelableSerializer.serialize((f) savedStateEncoder, (Parcelable) t3);
            return true;
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicJavaSerializableDescriptor())) {
            DefaultJavaSerializableSerializer defaultJavaSerializableSerializer = DefaultJavaSerializableSerializer.INSTANCE;
            k.c(t3, "null cannot be cast to non-null type java.io.Serializable");
            defaultJavaSerializableSerializer.serialize((f) savedStateEncoder, (Serializable) t3);
            return true;
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicIBinderDescriptor())) {
            IBinderSerializer iBinderSerializer = IBinderSerializer.INSTANCE;
            k.c(t3, "null cannot be cast to non-null type android.os.IBinder");
            iBinderSerializer.serialize((f) savedStateEncoder, (IBinder) t3);
            return true;
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceArrayDescriptor()) || k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceArrayDescriptor())) {
            CharSequenceArraySerializer charSequenceArraySerializer = CharSequenceArraySerializer.INSTANCE;
            k.c(t3, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
            charSequenceArraySerializer.serialize((f) savedStateEncoder, (CharSequence[]) t3);
            return true;
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceListDescriptor()) || k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceListDescriptor())) {
            CharSequenceListSerializer charSequenceListSerializer = CharSequenceListSerializer.INSTANCE;
            k.c(t3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.CharSequence>");
            charSequenceListSerializer.serialize((f) savedStateEncoder, (List<? extends CharSequence>) t3);
            return true;
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableArrayDescriptor()) || k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableArrayDescriptor())) {
            ParcelableArraySerializer parcelableArraySerializer = ParcelableArraySerializer.INSTANCE;
            k.c(t3, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
            parcelableArraySerializer.serialize((f) savedStateEncoder, (Parcelable[]) t3);
            return true;
        }
        if (k.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableListDescriptor()) || k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableListDescriptor())) {
            ParcelableListSerializer parcelableListSerializer = ParcelableListSerializer.INSTANCE;
            k.c(t3, "null cannot be cast to non-null type kotlin.collections.List<android.os.Parcelable>");
            parcelableListSerializer.serialize((f) savedStateEncoder, (List<? extends Parcelable>) t3);
            return true;
        }
        if (!k.a(descriptor, SavedStateCodecUtils_androidKt.getSparseParcelableArrayDescriptor()) && !k.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor()) && !k.a(descriptor, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
            return false;
        }
        SparseParcelableArraySerializer sparseParcelableArraySerializer = SparseParcelableArraySerializer.INSTANCE;
        k.c(t3, "null cannot be cast to non-null type android.util.SparseArray<android.os.Parcelable>");
        sparseParcelableArraySerializer.serialize((f) savedStateEncoder, (SparseArray<Parcelable>) t3);
        return true;
    }
}
