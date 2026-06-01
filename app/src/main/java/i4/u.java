package i4;

import com.ironsource.C2300e4;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f11960d = new a("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f11962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11963c;

    public u(SocketAddress socketAddress) {
        b bVar = b.f11821b;
        List listSingletonList = Collections.singletonList(socketAddress);
        r2.q.y(!listSingletonList.isEmpty(), "addrs is empty");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(listSingletonList));
        this.f11961a = listUnmodifiableList;
        r2.q.D(bVar, "attrs");
        this.f11962b = bVar;
        this.f11963c = listUnmodifiableList.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        List list = uVar.f11961a;
        List list2 = this.f11961a;
        if (list2.size() != list.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            if (!((SocketAddress) list2.get(i2)).equals(list.get(i2))) {
                return false;
            }
        }
        return this.f11962b.equals(uVar.f11962b);
    }

    public final int hashCode() {
        return this.f11963c;
    }

    public final String toString() {
        return C2300e4.i.f8403d + this.f11961a + "/" + this.f11962b + C2300e4.i.e;
    }
}
