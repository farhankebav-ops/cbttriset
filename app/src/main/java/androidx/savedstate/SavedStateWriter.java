package androidx.savedstate;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateWriter {
    private final Bundle source;

    private /* synthetic */ SavedStateWriter(Bundle bundle) {
        this.source = bundle;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SavedStateWriter m167boximpl(Bundle bundle) {
        return new SavedStateWriter(bundle);
    }

    /* JADX INFO: renamed from: clear-impl, reason: not valid java name */
    public static final void m168clearimpl(Bundle bundle) {
        bundle.clear();
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Bundle m169constructorimpl(Bundle source) {
        k.e(source, "source");
        return source;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m170equalsimpl(Bundle bundle, Object obj) {
        return (obj instanceof SavedStateWriter) && k.a(bundle, ((SavedStateWriter) obj).m207unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m171equalsimpl0(Bundle bundle, Bundle bundle2) {
        return k.a(bundle, bundle2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m172hashCodeimpl(Bundle bundle) {
        return bundle.hashCode();
    }

    /* JADX INFO: renamed from: putAll-impl, reason: not valid java name */
    public static final void m173putAllimpl(Bundle bundle, Bundle from) {
        k.e(from, "from");
        bundle.putAll(from);
    }

    /* JADX INFO: renamed from: putBinder-impl, reason: not valid java name */
    public static final void m174putBinderimpl(Bundle bundle, String key, IBinder value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putBinder(key, value);
    }

    /* JADX INFO: renamed from: putBoolean-impl, reason: not valid java name */
    public static final void m175putBooleanimpl(Bundle bundle, String key, boolean z2) {
        k.e(key, "key");
        bundle.putBoolean(key, z2);
    }

    /* JADX INFO: renamed from: putBooleanArray-impl, reason: not valid java name */
    public static final void m176putBooleanArrayimpl(Bundle bundle, String key, boolean[] value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putBooleanArray(key, value);
    }

    /* JADX INFO: renamed from: putChar-impl, reason: not valid java name */
    public static final void m177putCharimpl(Bundle bundle, String key, char c7) {
        k.e(key, "key");
        bundle.putChar(key, c7);
    }

    /* JADX INFO: renamed from: putCharArray-impl, reason: not valid java name */
    public static final void m178putCharArrayimpl(Bundle bundle, String key, char[] value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putCharArray(key, value);
    }

    /* JADX INFO: renamed from: putCharSequence-impl, reason: not valid java name */
    public static final void m179putCharSequenceimpl(Bundle bundle, String key, CharSequence value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putCharSequence(key, value);
    }

    /* JADX INFO: renamed from: putCharSequenceArray-impl, reason: not valid java name */
    public static final void m180putCharSequenceArrayimpl(Bundle bundle, String key, CharSequence[] value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putCharSequenceArray(key, value);
    }

    /* JADX INFO: renamed from: putCharSequenceList-impl, reason: not valid java name */
    public static final void m181putCharSequenceListimpl(Bundle bundle, String key, List<? extends CharSequence> value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putCharSequenceArrayList(key, SavedStateWriterKt.toArrayListUnsafe(value));
    }

    /* JADX INFO: renamed from: putDouble-impl, reason: not valid java name */
    public static final void m182putDoubleimpl(Bundle bundle, String key, double d8) {
        k.e(key, "key");
        bundle.putDouble(key, d8);
    }

    /* JADX INFO: renamed from: putDoubleArray-impl, reason: not valid java name */
    public static final void m183putDoubleArrayimpl(Bundle bundle, String key, double[] value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putDoubleArray(key, value);
    }

    /* JADX INFO: renamed from: putFloat-impl, reason: not valid java name */
    public static final void m184putFloatimpl(Bundle bundle, String key, float f4) {
        k.e(key, "key");
        bundle.putFloat(key, f4);
    }

    /* JADX INFO: renamed from: putFloatArray-impl, reason: not valid java name */
    public static final void m185putFloatArrayimpl(Bundle bundle, String key, float[] value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putFloatArray(key, value);
    }

    /* JADX INFO: renamed from: putInt-impl, reason: not valid java name */
    public static final void m186putIntimpl(Bundle bundle, String key, int i2) {
        k.e(key, "key");
        bundle.putInt(key, i2);
    }

    /* JADX INFO: renamed from: putIntArray-impl, reason: not valid java name */
    public static final void m187putIntArrayimpl(Bundle bundle, String key, int[] value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putIntArray(key, value);
    }

    /* JADX INFO: renamed from: putIntList-impl, reason: not valid java name */
    public static final void m188putIntListimpl(Bundle bundle, String key, List<Integer> value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putIntegerArrayList(key, SavedStateWriterKt.toArrayListUnsafe(value));
    }

    /* JADX INFO: renamed from: putJavaSerializable-impl, reason: not valid java name */
    public static final <T extends Serializable> void m189putJavaSerializableimpl(Bundle bundle, String key, T value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putSerializable(key, value);
    }

    /* JADX INFO: renamed from: putLong-impl, reason: not valid java name */
    public static final void m190putLongimpl(Bundle bundle, String key, long j) {
        k.e(key, "key");
        bundle.putLong(key, j);
    }

    /* JADX INFO: renamed from: putLongArray-impl, reason: not valid java name */
    public static final void m191putLongArrayimpl(Bundle bundle, String key, long[] value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putLongArray(key, value);
    }

    /* JADX INFO: renamed from: putNull-impl, reason: not valid java name */
    public static final void m192putNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        bundle.putString(key, null);
    }

    /* JADX INFO: renamed from: putParcelable-impl, reason: not valid java name */
    public static final <T extends Parcelable> void m193putParcelableimpl(Bundle bundle, String key, T value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putParcelable(key, value);
    }

    /* JADX INFO: renamed from: putParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> void m194putParcelableArrayimpl(Bundle bundle, String key, T[] value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putParcelableArray(key, value);
    }

    /* JADX INFO: renamed from: putParcelableList-impl, reason: not valid java name */
    public static final <T extends Parcelable> void m195putParcelableListimpl(Bundle bundle, String key, List<? extends T> value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putParcelableArrayList(key, SavedStateWriterKt.toArrayListUnsafe(value));
    }

    /* JADX INFO: renamed from: putSavedState-impl, reason: not valid java name */
    public static final void m196putSavedStateimpl(Bundle bundle, String key, Bundle value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putBundle(key, value);
    }

    /* JADX INFO: renamed from: putSavedStateArray-impl, reason: not valid java name */
    public static final void m197putSavedStateArrayimpl(Bundle bundle, String key, Bundle[] value) {
        k.e(key, "key");
        k.e(value, "value");
        m194putParcelableArrayimpl(bundle, key, value);
    }

    /* JADX INFO: renamed from: putSavedStateList-impl, reason: not valid java name */
    public static final void m198putSavedStateListimpl(Bundle bundle, String key, List<Bundle> value) {
        k.e(key, "key");
        k.e(value, "value");
        m195putParcelableListimpl(bundle, key, value);
    }

    /* JADX INFO: renamed from: putSize-impl, reason: not valid java name */
    public static final void m199putSizeimpl(Bundle bundle, String key, Size value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putSize(key, value);
    }

    /* JADX INFO: renamed from: putSizeF-impl, reason: not valid java name */
    public static final void m200putSizeFimpl(Bundle bundle, String key, SizeF value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putSizeF(key, value);
    }

    /* JADX INFO: renamed from: putSparseParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> void m201putSparseParcelableArrayimpl(Bundle bundle, String key, SparseArray<T> value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putSparseParcelableArray(key, value);
    }

    /* JADX INFO: renamed from: putString-impl, reason: not valid java name */
    public static final void m202putStringimpl(Bundle bundle, String key, String value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putString(key, value);
    }

    /* JADX INFO: renamed from: putStringArray-impl, reason: not valid java name */
    public static final void m203putStringArrayimpl(Bundle bundle, String key, String[] value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putStringArray(key, value);
    }

    /* JADX INFO: renamed from: putStringList-impl, reason: not valid java name */
    public static final void m204putStringListimpl(Bundle bundle, String key, List<String> value) {
        k.e(key, "key");
        k.e(value, "value");
        bundle.putStringArrayList(key, SavedStateWriterKt.toArrayListUnsafe(value));
    }

    /* JADX INFO: renamed from: remove-impl, reason: not valid java name */
    public static final void m205removeimpl(Bundle bundle, String key) {
        k.e(key, "key");
        bundle.remove(key);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m206toStringimpl(Bundle bundle) {
        return "SavedStateWriter(source=" + bundle + ')';
    }

    public boolean equals(Object obj) {
        return m170equalsimpl(this.source, obj);
    }

    public int hashCode() {
        return m172hashCodeimpl(this.source);
    }

    public String toString() {
        return m206toStringimpl(this.source);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Bundle m207unboximpl() {
        return this.source;
    }
}
