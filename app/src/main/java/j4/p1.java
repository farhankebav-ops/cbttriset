package j4;

import java.net.SocketAddress;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f12363a = new p1[256];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12364b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12365c = 0;

    public SocketAddress a() {
        if (c()) {
            return (SocketAddress) ((i4.u) ((List) this.f12363a).get(this.f12364b)).f11961a.get(this.f12365c);
        }
        throw new IllegalStateException("Index is past the end of the address group list");
    }

    public boolean b() {
        if (c()) {
            i4.u uVar = (i4.u) ((List) this.f12363a).get(this.f12364b);
            int i2 = this.f12365c + 1;
            this.f12365c = i2;
            if (i2 >= uVar.f11961a.size()) {
                int i8 = this.f12364b + 1;
                this.f12364b = i8;
                this.f12365c = 0;
                if (i8 < ((List) this.f12363a).size()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean c() {
        return this.f12364b < ((List) this.f12363a).size();
    }

    public void d() {
        this.f12364b = 0;
        this.f12365c = 0;
    }

    public boolean e(SocketAddress socketAddress) {
        for (int i2 = 0; i2 < ((List) this.f12363a).size(); i2++) {
            int iIndexOf = ((i4.u) ((List) this.f12363a).get(i2)).f11961a.indexOf(socketAddress);
            if (iIndexOf != -1) {
                this.f12364b = i2;
                this.f12365c = iIndexOf;
                return true;
            }
        }
        return false;
    }
}
