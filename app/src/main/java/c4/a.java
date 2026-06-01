package c4;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f4179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f4180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u3.c f4181d;
    public final com.unity3d.scar.adapter.common.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f4182f;
    public Object g;

    public /* synthetic */ a(Context context, u3.c cVar, Object obj, com.unity3d.scar.adapter.common.d dVar, int i2) {
        this.f4178a = i2;
        this.f4180c = context;
        this.f4181d = cVar;
        this.f4182f = obj;
        this.e = dVar;
    }

    public final void a(u3.b bVar) {
        AdRequest adRequestBuild;
        switch (this.f4178a) {
            case 0:
                b4.a aVar = (b4.a) this.f4182f;
                String str = this.f4181d.f17530d;
                aVar.getClass();
                e2.f fVar = aVar.f4145a;
                if (str.isEmpty()) {
                    AdRequest.Builder requestAgent = new AdRequest.Builder().setRequestAgent(fVar.f11230b);
                    Bundle bundle = new Bundle();
                    bundle.putString("query_info_type", "requester_type_5");
                    adRequestBuild = requestAgent.addNetworkExtrasBundle(AdMobAdapter.class, bundle).build();
                } else {
                    AdRequest.Builder requestAgent2 = new AdRequest.Builder().setRequestAgent(fVar.f11230b);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("query_info_type", "requester_type_5");
                    adRequestBuild = requestAgent2.addNetworkExtrasBundle(AdMobAdapter.class, bundle2).setAdString(str).build();
                }
                if (bVar != null) {
                    ((b) this.g).f4183a = bVar;
                }
                b(adRequestBuild);
                break;
            default:
                AdRequest adRequestA = ((x3.a) this.f4182f).a(this.f4181d.f17530d);
                if (bVar != null) {
                    ((b) this.g).f4183a = bVar;
                }
                b(adRequestA);
                break;
        }
    }

    public abstract void b(AdRequest adRequest);
}
