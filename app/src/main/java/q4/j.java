package q4;

import java.net.SocketAddress;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f13451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13452b;

    public j(i4.u uVar) {
        r2.q.D(uVar, "eag");
        List list = uVar.f11961a;
        this.f13451a = new String[list.size()];
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            this.f13451a[i2] = ((SocketAddress) it.next()).toString();
            i2++;
        }
        Arrays.sort(this.f13451a);
        this.f13452b = Arrays.hashCode(this.f13451a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (jVar.f13452b == this.f13452b) {
            String[] strArr = jVar.f13451a;
            int length = strArr.length;
            String[] strArr2 = this.f13451a;
            if (length == strArr2.length) {
                return Arrays.equals(strArr, strArr2);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13452b;
    }

    public final String toString() {
        return Arrays.toString(this.f13451a);
    }
}
