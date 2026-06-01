package q4;

import com.google.firebase.analytics.FirebaseAnalytics;
import i4.k0;
import i4.m0;
import j4.q3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class w extends m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f13482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f13483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13484c;

    public w(ArrayList arrayList, AtomicInteger atomicInteger) {
        r2.q.y(!arrayList.isEmpty(), "empty list");
        this.f13482a = arrayList;
        r2.q.D(atomicInteger, FirebaseAnalytics.Param.INDEX);
        this.f13483b = atomicInteger;
        int size = arrayList.size();
        int iHashCode = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            iHashCode += ((m0) obj).hashCode();
        }
        this.f13484c = iHashCode;
    }

    @Override // i4.m0
    public final k0 a(q3 q3Var) {
        int andIncrement = this.f13483b.getAndIncrement() & Integer.MAX_VALUE;
        ArrayList arrayList = this.f13482a;
        return ((m0) arrayList.get(andIncrement % arrayList.size())).a(q3Var);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        ArrayList arrayList = wVar.f13482a;
        if (wVar == this) {
            return true;
        }
        if (this.f13484c != wVar.f13484c || this.f13483b != wVar.f13483b) {
            return false;
        }
        ArrayList arrayList2 = this.f13482a;
        return arrayList2.size() == arrayList.size() && new HashSet(arrayList2).containsAll(arrayList);
    }

    public final int hashCode() {
        return this.f13484c;
    }

    public final String toString() {
        e2.i iVar = new e2.i(w.class.getSimpleName());
        iVar.c(this.f13482a, "subchannelPickers");
        return iVar.toString();
    }
}
