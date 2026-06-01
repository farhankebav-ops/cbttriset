package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import com.ironsource.C2300e4;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.i;
import r5.n;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MutablePreferences extends Preferences {
    private final AtomicBoolean frozen;
    private final Map<Preferences.Key<?>, Object> preferencesMap;

    /* JADX INFO: renamed from: androidx.datastore.preferences.core.MutablePreferences$toString$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // e6.l
        public final CharSequence invoke(Map.Entry<Preferences.Key<?>, Object> entry) {
            String strValueOf;
            k.e(entry, "entry");
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                StringBuilder sb = new StringBuilder();
                sb.append((CharSequence) C2300e4.i.f8403d);
                int i2 = 0;
                for (byte b8 : (byte[]) value) {
                    i2++;
                    if (i2 > 1) {
                        sb.append((CharSequence) ", ");
                    }
                    sb.append((CharSequence) String.valueOf((int) b8));
                }
                sb.append((CharSequence) C2300e4.i.e);
                strValueOf = sb.toString();
            } else {
                strValueOf = String.valueOf(entry.getValue());
            }
            return "  " + entry.getKey().getName() + " = " + strValueOf;
        }
    }

    public MutablePreferences() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public Map<Preferences.Key<?>, Object> asMap() {
        i iVar;
        Set<Map.Entry<Preferences.Key<?>, Object>> setEntrySet = this.preferencesMap.entrySet();
        int iD0 = x.d0(n.L0(setEntrySet, 10));
        if (iD0 < 16) {
            iD0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iD0);
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                k.d(bArrCopyOf, "copyOf(this, size)");
                iVar = new i(key, bArrCopyOf);
            } else {
                iVar = new i(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(iVar.f13498a, iVar.f13499b);
        }
        return Actual_jvmAndroidKt.immutableMap(linkedHashMap);
    }

    public final void checkNotFrozen$datastore_preferences_core_release() {
        if (this.frozen.get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void clear() {
        checkNotFrozen$datastore_preferences_core_release();
        this.preferencesMap.clear();
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public <T> boolean contains(Preferences.Key<T> key) {
        k.e(key, "key");
        return this.preferencesMap.containsKey(key);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.preferences.core.MutablePreferences
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            androidx.datastore.preferences.core.MutablePreferences r6 = (androidx.datastore.preferences.core.MutablePreferences) r6
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r0 = r6.preferencesMap
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            r3 = 1
            if (r0 != r2) goto L10
            return r3
        L10:
            int r0 = r0.size()
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            int r2 = r2.size()
            if (r0 == r2) goto L1d
            return r1
        L1d:
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r6 = r6.preferencesMap
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L26
            return r3
        L26:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L2e:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L67
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r2 = r2.get(r4)
            if (r2 == 0) goto L63
            java.lang.Object r0 = r0.getValue()
            boolean r4 = r0 instanceof byte[]
            if (r4 == 0) goto L5e
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L63
            byte[] r0 = (byte[]) r0
            byte[] r2 = (byte[]) r2
            boolean r0 = java.util.Arrays.equals(r0, r2)
            if (r0 == 0) goto L63
            r0 = r3
            goto L64
        L5e:
            boolean r0 = kotlin.jvm.internal.k.a(r0, r2)
            goto L64
        L63:
            r0 = r1
        L64:
            if (r0 != 0) goto L2e
            return r1
        L67:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.core.MutablePreferences.equals(java.lang.Object):boolean");
    }

    public final void freeze$datastore_preferences_core_release() {
        this.frozen.set(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.core.Preferences
    public <T> T get(Preferences.Key<T> key) {
        k.e(key, "key");
        T t3 = (T) this.preferencesMap.get(key);
        if (!(t3 instanceof byte[])) {
            return t3;
        }
        byte[] bArr = (byte[]) t3;
        T t7 = (T) Arrays.copyOf(bArr, bArr.length);
        k.d(t7, "copyOf(this, size)");
        return t7;
    }

    public final Map<Preferences.Key<?>, Object> getPreferencesMap$datastore_preferences_core_release() {
        return this.preferencesMap;
    }

    public int hashCode() {
        Iterator<T> it = this.preferencesMap.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final void minusAssign(Preferences.Key<?> key) {
        k.e(key, "key");
        checkNotFrozen$datastore_preferences_core_release();
        remove(key);
    }

    public final void plusAssign(Preferences prefs) {
        k.e(prefs, "prefs");
        checkNotFrozen$datastore_preferences_core_release();
        this.preferencesMap.putAll(prefs.asMap());
    }

    public final void putAll(Preferences.Pair<?>... pairs) {
        k.e(pairs, "pairs");
        checkNotFrozen$datastore_preferences_core_release();
        for (Preferences.Pair<?> pair : pairs) {
            setUnchecked$datastore_preferences_core_release(pair.getKey$datastore_preferences_core_release(), pair.getValue$datastore_preferences_core_release());
        }
    }

    public final <T> T remove(Preferences.Key<T> key) {
        k.e(key, "key");
        checkNotFrozen$datastore_preferences_core_release();
        return (T) this.preferencesMap.remove(key);
    }

    public final <T> void set(Preferences.Key<T> key, T t3) {
        k.e(key, "key");
        setUnchecked$datastore_preferences_core_release(key, t3);
    }

    public final void setUnchecked$datastore_preferences_core_release(Preferences.Key<?> key, Object obj) {
        k.e(key, "key");
        checkNotFrozen$datastore_preferences_core_release();
        if (obj == null) {
            remove(key);
            return;
        }
        if (obj instanceof Set) {
            this.preferencesMap.put(key, Actual_jvmAndroidKt.immutableCopyOfSet((Set) obj));
            return;
        }
        if (!(obj instanceof byte[])) {
            this.preferencesMap.put(key, obj);
            return;
        }
        Map<Preferences.Key<?>, Object> map = this.preferencesMap;
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        k.d(bArrCopyOf, "copyOf(this, size)");
        map.put(key, bArrCopyOf);
    }

    public String toString() {
        return r5.l.c1(this.preferencesMap.entrySet(), ",\n", "{\n", "\n}", AnonymousClass1.INSTANCE, 24);
    }

    public /* synthetic */ MutablePreferences(Map map, boolean z2, int i2, f fVar) {
        this((i2 & 1) != 0 ? new LinkedHashMap() : map, (i2 & 2) != 0 ? true : z2);
    }

    public final void plusAssign(Preferences.Pair<?> pair) {
        k.e(pair, "pair");
        checkNotFrozen$datastore_preferences_core_release();
        putAll(pair);
    }

    public MutablePreferences(Map<Preferences.Key<?>, Object> preferencesMap, boolean z2) {
        k.e(preferencesMap, "preferencesMap");
        this.preferencesMap = preferencesMap;
        this.frozen = new AtomicBoolean(z2);
    }
}
