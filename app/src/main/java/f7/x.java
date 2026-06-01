package f7;

import java.util.List;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class x implements e6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11539a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f11541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f11542d;

    public /* synthetic */ x(int i2, String str, y yVar) {
        this.f11540b = i2;
        this.f11541c = str;
        this.f11542d = yVar;
    }

    @Override // e6.a
    public final Object invoke() {
        switch (this.f11539a) {
            case 0:
                String str = (String) this.f11541c;
                y yVar = (y) this.f11542d;
                int i2 = this.f11540b;
                d7.g[] gVarArr = new d7.g[i2];
                for (int i8 = 0; i8 < i2; i8++) {
                    gVarArr[i8] = r2.q.s(str + '.' + yVar.e[i8], d7.m.e, new d7.g[0]);
                }
                return gVarArr;
            default:
                return Http2Connection.pushRequestLater$lambda$32((Http2Connection) this.f11541c, this.f11540b, (List) this.f11542d);
        }
    }

    public /* synthetic */ x(Http2Connection http2Connection, int i2, List list) {
        this.f11541c = http2Connection;
        this.f11540b = i2;
        this.f11542d = list;
    }
}
