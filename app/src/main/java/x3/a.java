package x3;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import e2.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f17789a;

    public final AdRequest a(String str) {
        return str.isEmpty() ? b().build() : b().setAdString(str).build();
    }

    public final AdRequest.Builder b() {
        return new AdRequest.Builder().setRequestAgent(this.f17789a.f11230b).addNetworkExtrasBundle(AdMobAdapter.class, androidx.camera.core.processing.util.a.c("query_info_type", "requester_type_5"));
    }
}
