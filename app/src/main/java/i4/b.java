package i4;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f11821b = new b(new IdentityHashMap());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f11822a;

    public b(IdentityHashMap identityHashMap) {
        this.f11822a = identityHashMap;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        IdentityHashMap identityHashMap = ((b) obj).f11822a;
        IdentityHashMap identityHashMap2 = this.f11822a;
        if (identityHashMap2.size() != identityHashMap.size()) {
            return false;
        }
        for (Map.Entry entry : identityHashMap2.entrySet()) {
            if (!identityHashMap.containsKey(entry.getKey()) || !Objects.equals(entry.getValue(), identityHashMap.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iHash = 0;
        for (Map.Entry entry : this.f11822a.entrySet()) {
            iHash += Objects.hash(entry.getKey(), entry.getValue());
        }
        return iHash;
    }

    public final String toString() {
        return this.f11822a.toString();
    }
}
