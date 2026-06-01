package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import java.util.Set;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferencesKeys {
    public static final Preferences.Key<Boolean> booleanKey(String name) {
        k.e(name, "name");
        return new Preferences.Key<>(name);
    }

    public static final Preferences.Key<byte[]> byteArrayKey(String name) {
        k.e(name, "name");
        return new Preferences.Key<>(name);
    }

    public static final Preferences.Key<Double> doubleKey(String name) {
        k.e(name, "name");
        return new Preferences.Key<>(name);
    }

    public static final Preferences.Key<Float> floatKey(String name) {
        k.e(name, "name");
        return new Preferences.Key<>(name);
    }

    public static final Preferences.Key<Integer> intKey(String name) {
        k.e(name, "name");
        return new Preferences.Key<>(name);
    }

    public static final Preferences.Key<Long> longKey(String name) {
        k.e(name, "name");
        return new Preferences.Key<>(name);
    }

    public static final Preferences.Key<String> stringKey(String name) {
        k.e(name, "name");
        return new Preferences.Key<>(name);
    }

    public static final Preferences.Key<Set<String>> stringSetKey(String name) {
        k.e(name, "name");
        return new Preferences.Key<>(name);
    }
}
