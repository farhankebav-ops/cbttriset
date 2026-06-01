package k4;

import androidx.webkit.ProxyConfig;
import j4.f1;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m4.b f12627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m4.b f12628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m4.b f12629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m4.b f12630d;
    public static final m4.b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m4.b f12631f;

    static {
        l7.m mVar = m4.b.g;
        f12627a = new m4.b(mVar, "https");
        f12628b = new m4.b(mVar, ProxyConfig.MATCH_HTTP);
        l7.m mVar2 = m4.b.e;
        f12629c = new m4.b(mVar2, "POST");
        f12630d = new m4.b(mVar2, "GET");
        e = new m4.b(f1.f12188i.f11972a, "application/grpc");
        f12631f = new m4.b("te", "trailers");
    }
}
