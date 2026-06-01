package s5;

import com.ironsource.G5;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e implements Map.Entry, f6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f13703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13705c;

    public e(f map, int i2) {
        k.e(map, "map");
        this.f13703a = map;
        this.f13704b = i2;
        this.f13705c = map.h;
    }

    public final void a() {
        if (this.f13703a.h != this.f13705c) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return k.a(entry.getKey(), getKey()) && k.a(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        a();
        return this.f13703a.f13707a[this.f13704b];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        a();
        Object[] objArr = this.f13703a.f13708b;
        k.b(objArr);
        return objArr[this.f13704b];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        a();
        f fVar = this.f13703a;
        fVar.c();
        Object[] objArr = fVar.f13708b;
        if (objArr == null) {
            int length = fVar.f13707a.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            fVar.f13708b = objArr;
        }
        int i2 = this.f13704b;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append(G5.T);
        sb.append(getValue());
        return sb.toString();
    }
}
