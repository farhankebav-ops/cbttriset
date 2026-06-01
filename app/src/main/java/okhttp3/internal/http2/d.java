package okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements e6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Http2Connection f13243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ErrorCode f13245d;

    public /* synthetic */ d(Http2Connection http2Connection, int i2, ErrorCode errorCode, int i8) {
        this.f13242a = i8;
        this.f13243b = http2Connection;
        this.f13244c = i2;
        this.f13245d = errorCode;
    }

    @Override // e6.a
    public final Object invoke() {
        switch (this.f13242a) {
            case 0:
                return Http2Connection.writeSynResetLater$lambda$12(this.f13243b, this.f13244c, this.f13245d);
            default:
                return Http2Connection.pushResetLater$lambda$40(this.f13243b, this.f13244c, this.f13245d);
        }
    }
}
