package okhttp3;

import java.util.List;
import okhttp3.internal.connection.ConnectPlan;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements e6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CertificatePinner f13220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f13221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f13222d;

    public /* synthetic */ a(CertificatePinner certificatePinner, Object obj, Object obj2, int i2) {
        this.f13219a = i2;
        this.f13220b = certificatePinner;
        this.f13221c = obj;
        this.f13222d = obj2;
    }

    @Override // e6.a
    public final Object invoke() {
        switch (this.f13219a) {
            case 0:
                return CertificatePinner.check$lambda$1(this.f13220b, (List) this.f13221c, (String) this.f13222d);
            default:
                return ConnectPlan.connectTls$lambda$4(this.f13220b, (Handshake) this.f13221c, (Address) this.f13222d);
        }
    }
}
