package androidx.savedstate.serialization;

import android.os.IBinder;
import android.os.Parcelable;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import b7.f;
import d7.g;
import f7.c;
import java.io.Serializable;
import kotlin.jvm.internal.b0;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateCodecUtils_androidKt {
    private static final g charSequenceArrayDescriptor;
    private static final g charSequenceListDescriptor;
    private static final g nullablePolymorphicSparseParcelableArrayDescriptor;
    private static final g parcelableArrayDescriptor;
    private static final g parcelableListDescriptor;
    private static final g polymorphicCharSequenceArrayDescriptor;
    private static final g polymorphicCharSequenceListDescriptor;
    private static final g polymorphicParcelableArrayDescriptor;
    private static final g polymorphicParcelableListDescriptor;
    private static final g polymorphicSparseParcelableArrayDescriptor;
    private static final g sparseParcelableArrayDescriptor;
    private static final g polymorphicCharSequenceDescriptor = new f(b0.a(CharSequence.class)).getDescriptor();
    private static final g polymorphicParcelableDescriptor = new f(b0.a(Parcelable.class)).getDescriptor();
    private static final g polymorphicJavaSerializableDescriptor = new f(b0.a(Serializable.class)).getDescriptor();
    private static final g polymorphicIBinderDescriptor = new f(b0.a(IBinder.class)).getDescriptor();

    static {
        DefaultParcelableSerializer defaultParcelableSerializer = DefaultParcelableSerializer.INSTANCE;
        parcelableArrayDescriptor = q.a(b0.a(Parcelable.class), defaultParcelableSerializer).f11477c;
        polymorphicParcelableArrayDescriptor = q.a(b0.a(Parcelable.class), new f(b0.a(Parcelable.class))).f11477c;
        parcelableListDescriptor = (c) q.c(defaultParcelableSerializer).f11432c;
        polymorphicParcelableListDescriptor = (c) q.c(new f(b0.a(Parcelable.class))).f11432c;
        CharSequenceSerializer charSequenceSerializer = CharSequenceSerializer.INSTANCE;
        charSequenceArrayDescriptor = q.a(b0.a(CharSequence.class), charSequenceSerializer).f11477c;
        polymorphicCharSequenceArrayDescriptor = q.a(b0.a(CharSequence.class), new f(b0.a(CharSequence.class))).f11477c;
        charSequenceListDescriptor = (c) q.c(charSequenceSerializer).f11432c;
        polymorphicCharSequenceListDescriptor = (c) q.c(new f(b0.a(CharSequence.class))).f11432c;
        sparseParcelableArrayDescriptor = new SparseArraySerializer(defaultParcelableSerializer).getDescriptor();
        polymorphicSparseParcelableArrayDescriptor = new SparseArraySerializer(new f(b0.a(Parcelable.class))).getDescriptor();
        nullablePolymorphicSparseParcelableArrayDescriptor = new SparseArraySerializer(q.Y(new f(b0.a(Parcelable.class)))).getDescriptor();
    }

    public static final g getCharSequenceArrayDescriptor() {
        return charSequenceArrayDescriptor;
    }

    public static final g getCharSequenceListDescriptor() {
        return charSequenceListDescriptor;
    }

    public static final g getNullablePolymorphicSparseParcelableArrayDescriptor() {
        return nullablePolymorphicSparseParcelableArrayDescriptor;
    }

    public static final g getParcelableArrayDescriptor() {
        return parcelableArrayDescriptor;
    }

    public static final g getParcelableListDescriptor() {
        return parcelableListDescriptor;
    }

    public static final g getPolymorphicCharSequenceArrayDescriptor() {
        return polymorphicCharSequenceArrayDescriptor;
    }

    public static final g getPolymorphicCharSequenceDescriptor() {
        return polymorphicCharSequenceDescriptor;
    }

    public static final g getPolymorphicCharSequenceListDescriptor() {
        return polymorphicCharSequenceListDescriptor;
    }

    public static final g getPolymorphicIBinderDescriptor() {
        return polymorphicIBinderDescriptor;
    }

    public static final g getPolymorphicJavaSerializableDescriptor() {
        return polymorphicJavaSerializableDescriptor;
    }

    public static final g getPolymorphicParcelableArrayDescriptor() {
        return polymorphicParcelableArrayDescriptor;
    }

    public static final g getPolymorphicParcelableDescriptor() {
        return polymorphicParcelableDescriptor;
    }

    public static final g getPolymorphicParcelableListDescriptor() {
        return polymorphicParcelableListDescriptor;
    }

    public static final g getPolymorphicSparseParcelableArrayDescriptor() {
        return polymorphicSparseParcelableArrayDescriptor;
    }

    public static final g getSparseParcelableArrayDescriptor() {
        return sparseParcelableArrayDescriptor;
    }

    public static /* synthetic */ void getCharSequenceArrayDescriptor$annotations() {
    }

    public static /* synthetic */ void getParcelableArrayDescriptor$annotations() {
    }

    public static /* synthetic */ void getPolymorphicCharSequenceArrayDescriptor$annotations() {
    }

    public static /* synthetic */ void getPolymorphicParcelableArrayDescriptor$annotations() {
    }
}
