package j4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f12274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection f12275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Collection f12276d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m4 f12277f;
    public final boolean g;
    public final boolean h;

    public j4(List list, Collection collection, Collection collection2, m4 m4Var, boolean z2, boolean z7, boolean z8, int i2) {
        this.f12274b = list;
        r2.q.D(collection, "drainedSubstreams");
        this.f12275c = collection;
        this.f12277f = m4Var;
        this.f12276d = collection2;
        this.g = z2;
        this.f12273a = z7;
        this.h = z8;
        this.e = i2;
        r2.q.H(!z7 || list == null, "passThrough should imply buffer is null");
        r2.q.H((z7 && m4Var == null) ? false : true, "passThrough should imply winningSubstream != null");
        r2.q.H(!z7 || (collection.size() == 1 && collection.contains(m4Var)) || (collection.size() == 0 && m4Var.f12323b), "passThrough should imply winningSubstream is drained");
        r2.q.H((z2 && m4Var == null) ? false : true, "cancelled should imply committed");
    }

    public final j4 a(m4 m4Var) {
        Collection collectionUnmodifiableCollection;
        r2.q.H(!this.h, "hedging frozen");
        r2.q.H(this.f12277f == null, "already committed");
        Collection collection = this.f12276d;
        if (collection == null) {
            collectionUnmodifiableCollection = Collections.singleton(m4Var);
        } else {
            ArrayList arrayList = new ArrayList(collection);
            arrayList.add(m4Var);
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
        }
        return new j4(this.f12274b, this.f12275c, collectionUnmodifiableCollection, this.f12277f, this.g, this.f12273a, this.h, this.e + 1);
    }

    public final j4 b(m4 m4Var) {
        ArrayList arrayList = new ArrayList(this.f12276d);
        arrayList.remove(m4Var);
        return new j4(this.f12274b, this.f12275c, Collections.unmodifiableCollection(arrayList), this.f12277f, this.g, this.f12273a, this.h, this.e);
    }

    public final j4 c(m4 m4Var, m4 m4Var2) {
        ArrayList arrayList = new ArrayList(this.f12276d);
        arrayList.remove(m4Var);
        arrayList.add(m4Var2);
        return new j4(this.f12274b, this.f12275c, Collections.unmodifiableCollection(arrayList), this.f12277f, this.g, this.f12273a, this.h, this.e);
    }

    public final j4 d(m4 m4Var) {
        m4Var.f12323b = true;
        Collection collection = this.f12275c;
        if (!collection.contains(m4Var)) {
            return this;
        }
        ArrayList arrayList = new ArrayList(collection);
        arrayList.remove(m4Var);
        return new j4(this.f12274b, Collections.unmodifiableCollection(arrayList), this.f12276d, this.f12277f, this.g, this.f12273a, this.h, this.e);
    }

    public final j4 e(m4 m4Var) {
        List list;
        r2.q.H(!this.f12273a, "Already passThrough");
        boolean z2 = m4Var.f12323b;
        Collection collectionUnmodifiableCollection = this.f12275c;
        if (!z2) {
            if (collectionUnmodifiableCollection.isEmpty()) {
                collectionUnmodifiableCollection = Collections.singletonList(m4Var);
            } else {
                ArrayList arrayList = new ArrayList(collectionUnmodifiableCollection);
                arrayList.add(m4Var);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
        }
        Collection collection = collectionUnmodifiableCollection;
        m4 m4Var2 = this.f12277f;
        boolean z7 = m4Var2 != null;
        if (z7) {
            r2.q.H(m4Var2 == m4Var, "Another RPC attempt has already committed");
            list = null;
        } else {
            list = this.f12274b;
        }
        return new j4(list, collection, this.f12276d, this.f12277f, this.g, z7, this.h, this.e);
    }
}
