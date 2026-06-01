package androidx.datastore.preferences.core;

import java.util.Map;
import kotlin.jvm.internal.k;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Preferences {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Key<T> {
        private final String name;

        public Key(String name) {
            k.e(name, "name");
            this.name = name;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                return k.a(this.name, ((Key) obj).name);
            }
            return false;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public final Pair<T> to(T t3) {
            return new Pair<>(this, t3);
        }

        public String toString() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Pair<T> {
        private final Key<T> key;
        private final T value;

        public Pair(Key<T> key, T t3) {
            k.e(key, "key");
            this.key = key;
            this.value = t3;
        }

        public final Key<T> getKey$datastore_preferences_core_release() {
            return this.key;
        }

        public final T getValue$datastore_preferences_core_release() {
            return this.value;
        }
    }

    public abstract Map<Key<?>, Object> asMap();

    public abstract <T> boolean contains(Key<T> key);

    public abstract <T> T get(Key<T> key);

    public final MutablePreferences toMutablePreferences() {
        return new MutablePreferences(x.o0(asMap()), false);
    }

    public final Preferences toPreferences() {
        return new MutablePreferences(x.o0(asMap()), true);
    }
}
