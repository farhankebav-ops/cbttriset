package j4;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p3 extends i4.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f12369a;

    static {
        f12369a = !n7.b.R(System.getenv("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST")) && Boolean.parseBoolean(System.getenv("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST"));
    }

    @Override // i4.p0
    public final String a() {
        return "pick_first";
    }

    @Override // i4.p0
    public final i4.o0 b(i4.x xVar) {
        return f12369a ? new k3(xVar) : new o3(xVar);
    }

    @Override // i4.p0
    public final i4.e1 c(Map map) {
        try {
            return new i4.e1(new m3(x1.b("shuffleAddressList", map)));
        } catch (RuntimeException e) {
            return new i4.e1(i4.n1.m.g(e).h("Failed parsing configuration for pick_first"));
        }
    }
}
