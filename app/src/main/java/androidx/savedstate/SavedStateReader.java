package androidx.savedstate;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.camera.core.processing.util.a;
import androidx.core.location.LocationRequestCompat;
import androidx.core.os.BundleCompat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import l6.c;
import s5.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateReader {
    private final Bundle source;

    private /* synthetic */ SavedStateReader(Bundle bundle) {
        this.source = bundle;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SavedStateReader m82boximpl(Bundle bundle) {
        return new SavedStateReader(bundle);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Bundle m83constructorimpl(Bundle source) {
        k.e(source, "source");
        return source;
    }

    /* JADX INFO: renamed from: contains-impl, reason: not valid java name */
    public static final boolean m84containsimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.containsKey(key);
    }

    /* JADX INFO: renamed from: contentDeepEquals-impl, reason: not valid java name */
    public static final boolean m85contentDeepEqualsimpl(Bundle bundle, Bundle other) {
        k.e(other, "other");
        return SavedStateReaderKt__SavedStateReader_androidKt.contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt(bundle, other);
    }

    /* JADX INFO: renamed from: contentDeepHashCode-impl, reason: not valid java name */
    public static final int m86contentDeepHashCodeimpl(Bundle bundle) {
        return SavedStateReaderKt__SavedStateReader_androidKt.contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt(bundle);
    }

    /* JADX INFO: renamed from: contentDeepToString-impl, reason: not valid java name */
    public static final String m87contentDeepToStringimpl(Bundle bundle) {
        int size = bundle.size();
        if (size > 429496729) {
            size = 429496729;
        }
        StringBuilder sb = new StringBuilder((size * 5) + 2);
        SavedStateReaderKt__SavedStateReader_androidKt.contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt(bundle, sb, new ArrayList());
        String string = sb.toString();
        k.d(string, "toString(...)");
        return string;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m88equalsimpl(Bundle bundle, Object obj) {
        return (obj instanceof SavedStateReader) && k.a(bundle, ((SavedStateReader) obj).m166unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m89equalsimpl0(Bundle bundle, Bundle bundle2) {
        return k.a(bundle, bundle2);
    }

    /* JADX INFO: renamed from: getBinder-impl, reason: not valid java name */
    public static final IBinder m90getBinderimpl(Bundle bundle, String key) {
        k.e(key, "key");
        IBinder binder = bundle.getBinder(key);
        if (binder != null) {
            return binder;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getBinderOrNull-impl, reason: not valid java name */
    public static final IBinder m91getBinderOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getBinder(key);
    }

    /* JADX INFO: renamed from: getBoolean-impl, reason: not valid java name */
    public static final boolean m92getBooleanimpl(Bundle bundle, String key) {
        k.e(key, "key");
        boolean z2 = bundle.getBoolean(key, false);
        if (z2 || !bundle.getBoolean(key, true)) {
            return z2;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getBooleanArray-impl, reason: not valid java name */
    public static final boolean[] m93getBooleanArrayimpl(Bundle bundle, String key) {
        k.e(key, "key");
        boolean[] booleanArray = bundle.getBooleanArray(key);
        if (booleanArray != null) {
            return booleanArray;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getBooleanArrayOrNull-impl, reason: not valid java name */
    public static final boolean[] m94getBooleanArrayOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getBooleanArray(key);
    }

    /* JADX INFO: renamed from: getBooleanOrNull-impl, reason: not valid java name */
    public static final Boolean m95getBooleanOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        boolean z2 = bundle.getBoolean(key, false);
        if (z2 || !bundle.getBoolean(key, true)) {
            return Boolean.valueOf(z2);
        }
        return null;
    }

    /* JADX INFO: renamed from: getChar-impl, reason: not valid java name */
    public static final char m96getCharimpl(Bundle bundle, String key) {
        k.e(key, "key");
        char c7 = bundle.getChar(key, (char) 0);
        if (c7 == 0 && bundle.getChar(key, (char) 65535) == 65535) {
            throw a.e(key);
        }
        return c7;
    }

    /* JADX INFO: renamed from: getCharArray-impl, reason: not valid java name */
    public static final char[] m97getCharArrayimpl(Bundle bundle, String key) {
        k.e(key, "key");
        char[] charArray = bundle.getCharArray(key);
        if (charArray != null) {
            return charArray;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getCharArrayOrNull-impl, reason: not valid java name */
    public static final char[] m98getCharArrayOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getCharArray(key);
    }

    /* JADX INFO: renamed from: getCharOrNull-impl, reason: not valid java name */
    public static final Character m99getCharOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        char c7 = bundle.getChar(key, (char) 0);
        if (c7 == 0 && bundle.getChar(key, (char) 65535) == 65535) {
            return null;
        }
        return Character.valueOf(c7);
    }

    /* JADX INFO: renamed from: getCharSequence-impl, reason: not valid java name */
    public static final CharSequence m100getCharSequenceimpl(Bundle bundle, String key) {
        k.e(key, "key");
        CharSequence charSequence = bundle.getCharSequence(key);
        if (charSequence != null) {
            return charSequence;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getCharSequenceArray-impl, reason: not valid java name */
    public static final CharSequence[] m101getCharSequenceArrayimpl(Bundle bundle, String key) {
        k.e(key, "key");
        CharSequence[] charSequenceArray = bundle.getCharSequenceArray(key);
        if (charSequenceArray != null) {
            return charSequenceArray;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getCharSequenceArrayOrNull-impl, reason: not valid java name */
    public static final CharSequence[] m102getCharSequenceArrayOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getCharSequenceArray(key);
    }

    /* JADX INFO: renamed from: getCharSequenceList-impl, reason: not valid java name */
    public static final List<CharSequence> m103getCharSequenceListimpl(Bundle bundle, String key) {
        k.e(key, "key");
        ArrayList<CharSequence> charSequenceArrayList = bundle.getCharSequenceArrayList(key);
        if (charSequenceArrayList != null) {
            return charSequenceArrayList;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getCharSequenceListOrNull-impl, reason: not valid java name */
    public static final List<CharSequence> m104getCharSequenceListOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getCharSequenceArrayList(key);
    }

    /* JADX INFO: renamed from: getCharSequenceOrNull-impl, reason: not valid java name */
    public static final CharSequence m105getCharSequenceOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getCharSequence(key);
    }

    /* JADX INFO: renamed from: getDouble-impl, reason: not valid java name */
    public static final double m106getDoubleimpl(Bundle bundle, String key) {
        k.e(key, "key");
        double d8 = bundle.getDouble(key, Double.MIN_VALUE);
        if (d8 == Double.MIN_VALUE && bundle.getDouble(key, Double.MAX_VALUE) == Double.MAX_VALUE) {
            throw a.e(key);
        }
        return d8;
    }

    /* JADX INFO: renamed from: getDoubleArray-impl, reason: not valid java name */
    public static final double[] m107getDoubleArrayimpl(Bundle bundle, String key) {
        k.e(key, "key");
        double[] doubleArray = bundle.getDoubleArray(key);
        if (doubleArray != null) {
            return doubleArray;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getDoubleArrayOrNull-impl, reason: not valid java name */
    public static final double[] m108getDoubleArrayOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getDoubleArray(key);
    }

    /* JADX INFO: renamed from: getDoubleOrNull-impl, reason: not valid java name */
    public static final Double m109getDoubleOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        double d8 = bundle.getDouble(key, Double.MIN_VALUE);
        if (d8 == Double.MIN_VALUE && bundle.getDouble(key, Double.MAX_VALUE) == Double.MAX_VALUE) {
            return null;
        }
        return Double.valueOf(d8);
    }

    /* JADX INFO: renamed from: getFloat-impl, reason: not valid java name */
    public static final float m110getFloatimpl(Bundle bundle, String key) {
        k.e(key, "key");
        float f4 = bundle.getFloat(key, Float.MIN_VALUE);
        if (f4 == Float.MIN_VALUE && bundle.getFloat(key, Float.MAX_VALUE) == Float.MAX_VALUE) {
            throw a.e(key);
        }
        return f4;
    }

    /* JADX INFO: renamed from: getFloatArray-impl, reason: not valid java name */
    public static final float[] m111getFloatArrayimpl(Bundle bundle, String key) {
        k.e(key, "key");
        float[] floatArray = bundle.getFloatArray(key);
        if (floatArray != null) {
            return floatArray;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getFloatArrayOrNull-impl, reason: not valid java name */
    public static final float[] m112getFloatArrayOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getFloatArray(key);
    }

    /* JADX INFO: renamed from: getFloatOrNull-impl, reason: not valid java name */
    public static final Float m113getFloatOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        float f4 = bundle.getFloat(key, Float.MIN_VALUE);
        if (f4 == Float.MIN_VALUE && bundle.getFloat(key, Float.MAX_VALUE) == Float.MAX_VALUE) {
            return null;
        }
        return Float.valueOf(f4);
    }

    /* JADX INFO: renamed from: getInt-impl, reason: not valid java name */
    public static final int m114getIntimpl(Bundle bundle, String key) {
        k.e(key, "key");
        int i2 = bundle.getInt(key, Integer.MIN_VALUE);
        if (i2 == Integer.MIN_VALUE && bundle.getInt(key, Integer.MAX_VALUE) == Integer.MAX_VALUE) {
            throw a.e(key);
        }
        return i2;
    }

    /* JADX INFO: renamed from: getIntArray-impl, reason: not valid java name */
    public static final int[] m115getIntArrayimpl(Bundle bundle, String key) {
        k.e(key, "key");
        int[] intArray = bundle.getIntArray(key);
        if (intArray != null) {
            return intArray;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getIntArrayOrNull-impl, reason: not valid java name */
    public static final int[] m116getIntArrayOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getIntArray(key);
    }

    /* JADX INFO: renamed from: getIntList-impl, reason: not valid java name */
    public static final List<Integer> m117getIntListimpl(Bundle bundle, String key) {
        k.e(key, "key");
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(key);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getIntListOrNull-impl, reason: not valid java name */
    public static final List<Integer> m118getIntListOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getIntegerArrayList(key);
    }

    /* JADX INFO: renamed from: getIntOrNull-impl, reason: not valid java name */
    public static final Integer m119getIntOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        int i2 = bundle.getInt(key, Integer.MIN_VALUE);
        if (i2 == Integer.MIN_VALUE && bundle.getInt(key, Integer.MAX_VALUE) == Integer.MAX_VALUE) {
            return null;
        }
        return Integer.valueOf(i2);
    }

    /* JADX INFO: renamed from: getJavaSerializable-impl, reason: not valid java name */
    public static final <T extends Serializable> T m120getJavaSerializableimpl(Bundle bundle, String key) {
        k.e(key, "key");
        k.k();
        throw null;
    }

    /* JADX INFO: renamed from: getJavaSerializableOrNull-impl, reason: not valid java name */
    public static final <T extends Serializable> T m122getJavaSerializableOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        k.k();
        throw null;
    }

    /* JADX INFO: renamed from: getLong-impl, reason: not valid java name */
    public static final long m124getLongimpl(Bundle bundle, String key) {
        k.e(key, "key");
        long j = bundle.getLong(key, Long.MIN_VALUE);
        if (j == Long.MIN_VALUE && bundle.getLong(key, LocationRequestCompat.PASSIVE_INTERVAL) == LocationRequestCompat.PASSIVE_INTERVAL) {
            throw a.e(key);
        }
        return j;
    }

    /* JADX INFO: renamed from: getLongArray-impl, reason: not valid java name */
    public static final long[] m125getLongArrayimpl(Bundle bundle, String key) {
        k.e(key, "key");
        long[] longArray = bundle.getLongArray(key);
        if (longArray != null) {
            return longArray;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getLongArrayOrNull-impl, reason: not valid java name */
    public static final long[] m126getLongArrayOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getLongArray(key);
    }

    /* JADX INFO: renamed from: getLongOrNull-impl, reason: not valid java name */
    public static final Long m127getLongOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        long j = bundle.getLong(key, Long.MIN_VALUE);
        if (j == Long.MIN_VALUE && bundle.getLong(key, LocationRequestCompat.PASSIVE_INTERVAL) == LocationRequestCompat.PASSIVE_INTERVAL) {
            return null;
        }
        return Long.valueOf(j);
    }

    /* JADX INFO: renamed from: getParcelable-impl, reason: not valid java name */
    public static final <T extends Parcelable> T m128getParcelableimpl(Bundle bundle, String key) {
        k.e(key, "key");
        k.k();
        throw null;
    }

    /* JADX INFO: renamed from: getParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> T[] m130getParcelableArrayimpl(Bundle bundle, String key) {
        k.e(key, "key");
        k.k();
        throw null;
    }

    /* JADX INFO: renamed from: getParcelableArrayOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> T[] m132getParcelableArrayOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        k.k();
        throw null;
    }

    /* JADX INFO: renamed from: getParcelableList-impl, reason: not valid java name */
    public static final <T extends Parcelable> List<T> m134getParcelableListimpl(Bundle bundle, String key) {
        k.e(key, "key");
        k.k();
        throw null;
    }

    /* JADX INFO: renamed from: getParcelableListOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> List<T> m136getParcelableListOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        k.k();
        throw null;
    }

    /* JADX INFO: renamed from: getParcelableOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> T m138getParcelableOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        k.k();
        throw null;
    }

    /* JADX INFO: renamed from: getSavedState-impl, reason: not valid java name */
    public static final Bundle m140getSavedStateimpl(Bundle bundle, String key) {
        k.e(key, "key");
        Bundle bundle2 = bundle.getBundle(key);
        if (bundle2 != null) {
            return bundle2;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getSavedStateArray-impl, reason: not valid java name */
    public static final Bundle[] m141getSavedStateArrayimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return (Bundle[]) m131getParcelableArrayimpl(bundle, key, b0.a(Bundle.class));
    }

    /* JADX INFO: renamed from: getSavedStateArrayOrNull-impl, reason: not valid java name */
    public static final Bundle[] m142getSavedStateArrayOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return (Bundle[]) m133getParcelableArrayOrNullimpl(bundle, key, b0.a(Bundle.class));
    }

    /* JADX INFO: renamed from: getSavedStateList-impl, reason: not valid java name */
    public static final List<Bundle> m143getSavedStateListimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return m135getParcelableListimpl(bundle, key, b0.a(Bundle.class));
    }

    /* JADX INFO: renamed from: getSavedStateListOrNull-impl, reason: not valid java name */
    public static final List<Bundle> m144getSavedStateListOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return m137getParcelableListOrNullimpl(bundle, key, b0.a(Bundle.class));
    }

    /* JADX INFO: renamed from: getSavedStateOrNull-impl, reason: not valid java name */
    public static final Bundle m145getSavedStateOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getBundle(key);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static final Size m146getSizeimpl(Bundle bundle, String key) {
        k.e(key, "key");
        Size size = bundle.getSize(key);
        if (size != null) {
            return size;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getSizeF-impl, reason: not valid java name */
    public static final SizeF m147getSizeFimpl(Bundle bundle, String key) {
        k.e(key, "key");
        SizeF sizeF = bundle.getSizeF(key);
        if (sizeF != null) {
            return sizeF;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getSizeFOrNull-impl, reason: not valid java name */
    public static final SizeF m148getSizeFOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getSizeF(key);
    }

    /* JADX INFO: renamed from: getSizeOrNull-impl, reason: not valid java name */
    public static final Size m149getSizeOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getSize(key);
    }

    /* JADX INFO: renamed from: getSparseParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> SparseArray<T> m150getSparseParcelableArrayimpl(Bundle bundle, String key) {
        k.e(key, "key");
        k.k();
        throw null;
    }

    /* JADX INFO: renamed from: getSparseParcelableArrayOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> SparseArray<T> m152getSparseParcelableArrayOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        k.k();
        throw null;
    }

    /* JADX INFO: renamed from: getString-impl, reason: not valid java name */
    public static final String m154getStringimpl(Bundle bundle, String key) {
        k.e(key, "key");
        String string = bundle.getString(key);
        if (string != null) {
            return string;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getStringArray-impl, reason: not valid java name */
    public static final String[] m155getStringArrayimpl(Bundle bundle, String key) {
        k.e(key, "key");
        String[] stringArray = bundle.getStringArray(key);
        if (stringArray != null) {
            return stringArray;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getStringArrayOrNull-impl, reason: not valid java name */
    public static final String[] m156getStringArrayOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getStringArray(key);
    }

    /* JADX INFO: renamed from: getStringList-impl, reason: not valid java name */
    public static final List<String> m157getStringListimpl(Bundle bundle, String key) {
        k.e(key, "key");
        ArrayList<String> stringArrayList = bundle.getStringArrayList(key);
        if (stringArrayList != null) {
            return stringArrayList;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getStringListOrNull-impl, reason: not valid java name */
    public static final List<String> m158getStringListOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getStringArrayList(key);
    }

    /* JADX INFO: renamed from: getStringOrNull-impl, reason: not valid java name */
    public static final String m159getStringOrNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return bundle.getString(key);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m160hashCodeimpl(Bundle bundle) {
        return bundle.hashCode();
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m161isEmptyimpl(Bundle bundle) {
        return bundle.isEmpty();
    }

    /* JADX INFO: renamed from: isNull-impl, reason: not valid java name */
    public static final boolean m162isNullimpl(Bundle bundle, String key) {
        k.e(key, "key");
        return m84containsimpl(bundle, key) && bundle.get(key) == null;
    }

    /* JADX INFO: renamed from: size-impl, reason: not valid java name */
    public static final int m163sizeimpl(Bundle bundle) {
        return bundle.size();
    }

    /* JADX INFO: renamed from: toMap-impl, reason: not valid java name */
    public static final Map<String, Object> m164toMapimpl(Bundle bundle) {
        f fVar = new f(bundle.size());
        for (String str : bundle.keySet()) {
            k.b(str);
            fVar.put(str, bundle.get(str));
        }
        return fVar.b();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m165toStringimpl(Bundle bundle) {
        return "SavedStateReader(source=" + bundle + ')';
    }

    public boolean equals(Object obj) {
        return m88equalsimpl(this.source, obj);
    }

    public int hashCode() {
        return m160hashCodeimpl(this.source);
    }

    public String toString() {
        return m165toStringimpl(this.source);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Bundle m166unboximpl() {
        return this.source;
    }

    /* JADX INFO: renamed from: getJavaSerializable-impl, reason: not valid java name */
    public static final <T extends Serializable> T m121getJavaSerializableimpl(Bundle bundle, String key, c serializableClass) {
        k.e(key, "key");
        k.e(serializableClass, "serializableClass");
        T t3 = (T) BundleCompat.getSerializable(bundle, key, a.a.B(serializableClass));
        if (t3 != null) {
            return t3;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getJavaSerializableOrNull-impl, reason: not valid java name */
    public static final <T extends Serializable> T m123getJavaSerializableOrNullimpl(Bundle bundle, String key, c serializableClass) {
        k.e(key, "key");
        k.e(serializableClass, "serializableClass");
        return (T) BundleCompat.getSerializable(bundle, key, a.a.B(serializableClass));
    }

    /* JADX INFO: renamed from: getParcelable-impl, reason: not valid java name */
    public static final <T extends Parcelable> T m129getParcelableimpl(Bundle bundle, String key, c parcelableClass) {
        k.e(key, "key");
        k.e(parcelableClass, "parcelableClass");
        T t3 = (T) BundleCompat.getParcelable(bundle, key, a.a.B(parcelableClass));
        if (t3 != null) {
            return t3;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> T[] m131getParcelableArrayimpl(Bundle bundle, String key, c parcelableClass) {
        k.e(key, "key");
        k.e(parcelableClass, "parcelableClass");
        T[] tArr = (T[]) m133getParcelableArrayOrNullimpl(bundle, key, parcelableClass);
        if (tArr != null) {
            return tArr;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getParcelableArrayOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> T[] m133getParcelableArrayOrNullimpl(Bundle bundle, String key, c parcelableClass) {
        k.e(key, "key");
        k.e(parcelableClass, "parcelableClass");
        T[] tArr = (T[]) BundleCompat.getParcelableArray(bundle, key, a.a.B(parcelableClass));
        if (tArr != null) {
            return tArr;
        }
        return null;
    }

    /* JADX INFO: renamed from: getParcelableList-impl, reason: not valid java name */
    public static final <T extends Parcelable> List<T> m135getParcelableListimpl(Bundle bundle, String key, c parcelableClass) {
        k.e(key, "key");
        k.e(parcelableClass, "parcelableClass");
        ArrayList parcelableArrayList = BundleCompat.getParcelableArrayList(bundle, key, a.a.B(parcelableClass));
        if (parcelableArrayList != null) {
            return parcelableArrayList;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getParcelableListOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> List<T> m137getParcelableListOrNullimpl(Bundle bundle, String key, c parcelableClass) {
        k.e(key, "key");
        k.e(parcelableClass, "parcelableClass");
        return BundleCompat.getParcelableArrayList(bundle, key, a.a.B(parcelableClass));
    }

    /* JADX INFO: renamed from: getParcelableOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> T m139getParcelableOrNullimpl(Bundle bundle, String key, c parcelableClass) {
        k.e(key, "key");
        k.e(parcelableClass, "parcelableClass");
        return (T) BundleCompat.getParcelable(bundle, key, a.a.B(parcelableClass));
    }

    /* JADX INFO: renamed from: getSparseParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> SparseArray<T> m151getSparseParcelableArrayimpl(Bundle bundle, String key, c parcelableClass) {
        k.e(key, "key");
        k.e(parcelableClass, "parcelableClass");
        SparseArray<T> sparseArrayM153getSparseParcelableArrayOrNullimpl = m153getSparseParcelableArrayOrNullimpl(bundle, key, parcelableClass);
        if (sparseArrayM153getSparseParcelableArrayOrNullimpl != null) {
            return sparseArrayM153getSparseParcelableArrayOrNullimpl;
        }
        throw a.e(key);
    }

    /* JADX INFO: renamed from: getSparseParcelableArrayOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> SparseArray<T> m153getSparseParcelableArrayOrNullimpl(Bundle bundle, String key, c parcelableClass) {
        k.e(key, "key");
        k.e(parcelableClass, "parcelableClass");
        return BundleCompat.getSparseParcelableArray(bundle, key, a.a.B(parcelableClass));
    }
}
