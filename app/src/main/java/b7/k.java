package b7;

import java.util.List;
import l6.r;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class k implements e6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f4155b;

    public /* synthetic */ k(List list, int i2) {
        this.f4154a = i2;
        this.f4155b = list;
    }

    @Override // e6.a
    public final Object invoke() {
        switch (this.f4154a) {
            case 0:
                return ((r) this.f4155b.get(0)).c();
            case 1:
                return ((r) this.f4155b.get(0)).c();
            case 2:
                return Handshake.Companion.get$lambda$3(this.f4155b);
            default:
                return Handshake.Companion.handshake$lambda$2(this.f4155b);
        }
    }
}
