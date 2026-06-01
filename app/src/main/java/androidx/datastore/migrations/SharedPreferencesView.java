package androidx.datastore.migrations;

import a1.a;
import android.content.SharedPreferences;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.k;
import r5.l;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesView {
    private final Set<String> keySet;
    private final SharedPreferences prefs;

    public SharedPreferencesView(SharedPreferences prefs, Set<String> set) {
        k.e(prefs, "prefs");
        this.prefs = prefs;
        this.keySet = set;
    }

    private final String checkKey(String str) {
        Set<String> set = this.keySet;
        if (set == null || set.contains(str)) {
            return str;
        }
        throw new IllegalStateException(a.l("Can't access key outside migration: ", str).toString());
    }

    public static /* synthetic */ String getString$default(SharedPreferencesView sharedPreferencesView, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return sharedPreferencesView.getString(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Set getStringSet$default(SharedPreferencesView sharedPreferencesView, String str, Set set, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            set = null;
        }
        return sharedPreferencesView.getStringSet(str, set);
    }

    public final boolean contains(String key) {
        k.e(key, "key");
        return this.prefs.contains(checkKey(key));
    }

    public final Map<String, Object> getAll() {
        Map<String, ?> all = this.prefs.getAll();
        k.d(all, "prefs.all");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Set<String> set = this.keySet;
            if (set != null ? set.contains(key) : true) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(x.d0(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key2 = entry2.getKey();
            Object value = entry2.getValue();
            if (value instanceof Set) {
                value = l.r1((Iterable) value);
            }
            linkedHashMap2.put(key2, value);
        }
        return linkedHashMap2;
    }

    public final boolean getBoolean(String key, boolean z2) {
        k.e(key, "key");
        return this.prefs.getBoolean(checkKey(key), z2);
    }

    public final float getFloat(String key, float f4) {
        k.e(key, "key");
        return this.prefs.getFloat(checkKey(key), f4);
    }

    public final int getInt(String key, int i2) {
        k.e(key, "key");
        return this.prefs.getInt(checkKey(key), i2);
    }

    public final long getLong(String key, long j) {
        k.e(key, "key");
        return this.prefs.getLong(checkKey(key), j);
    }

    public final String getString(String key, String str) {
        k.e(key, "key");
        return this.prefs.getString(checkKey(key), str);
    }

    public final Set<String> getStringSet(String key, Set<String> set) {
        k.e(key, "key");
        Set<String> stringSet = this.prefs.getStringSet(checkKey(key), set);
        if (stringSet != null) {
            return l.q1(stringSet);
        }
        return null;
    }
}
