package okhttp3.internal.http2;

import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements e6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f13237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Lockable f13238c;

    public /* synthetic */ b(Lockable lockable, long j, int i2) {
        this.f13236a = i2;
        this.f13238c = lockable;
        this.f13237b = j;
    }

    @Override // e6.a
    public final Object invoke() {
        long j_init_$lambda$2;
        switch (this.f13236a) {
            case 0:
                j_init_$lambda$2 = Http2Connection._init_$lambda$2((Http2Connection) this.f13238c, this.f13237b);
                break;
            default:
                j_init_$lambda$2 = RealWebSocket.initReaderAndWriter$lambda$3$lambda$2((RealWebSocket) this.f13238c, this.f13237b);
                break;
        }
        return Long.valueOf(j_init_$lambda$2);
    }
}
