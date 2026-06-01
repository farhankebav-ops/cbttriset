package f2;

import com.ironsource.G5;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h implements Map, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient m f11328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient n f11329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient o f11330c;

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        o oVar = this.f11330c;
        if (oVar == null) {
            p pVar = (p) this;
            o oVar2 = new o(pVar.e, 1, pVar.f11344f);
            this.f11330c = oVar2;
            oVar = oVar2;
        }
        return oVar.contains(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        m mVar = this.f11328a;
        if (mVar != null) {
            return mVar;
        }
        p pVar = (p) this;
        m mVar2 = new m(pVar, pVar.e, pVar.f11344f);
        this.f11328a = mVar2;
        return mVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return ((i) entrySet()).equals(((Map) obj).entrySet());
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        m mVar = this.f11328a;
        if (mVar == null) {
            p pVar = (p) this;
            m mVar2 = new m(pVar, pVar.e, pVar.f11344f);
            this.f11328a = mVar2;
            mVar = mVar2;
        }
        Iterator it = mVar.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i2 = ~(~(i2 + (next != null ? next.hashCode() : 0)));
        }
        return i2;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return ((p) this).size() == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        n nVar = this.f11329b;
        if (nVar != null) {
            return nVar;
        }
        p pVar = (p) this;
        n nVar2 = new n(pVar, new o(pVar.e, 0, pVar.f11344f));
        this.f11329b = nVar2;
        return nVar2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int i2 = ((p) this).f11344f;
        a.a.o(i2, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) i2) * 8, 1073741824L));
        sb.append('{');
        u it = ((m) entrySet()).iterator();
        boolean z2 = true;
        while (true) {
            c cVar = (c) it;
            if (!cVar.hasNext()) {
                sb.append('}');
                return sb.toString();
            }
            Map.Entry entry = (Map.Entry) cVar.next();
            if (!z2) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append(G5.T);
            sb.append(entry.getValue());
            z2 = false;
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        o oVar = this.f11330c;
        if (oVar != null) {
            return oVar;
        }
        p pVar = (p) this;
        o oVar2 = new o(pVar.e, 1, pVar.f11344f);
        this.f11330c = oVar2;
        return oVar2;
    }
}
