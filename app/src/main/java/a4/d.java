package a4;

import android.content.Context;
import c4.e;
import c4.i;
import c4.k;
import com.google.android.gms.ads.AdView;
import com.unity3d.scar.adapter.common.f;
import com.unity3d.services.ads.gmascar.handlers.ScarBannerAdHandler;
import com.unity3d.services.ads.gmascar.handlers.ScarInterstitialAdHandler;
import com.unity3d.services.ads.gmascar.handlers.ScarRewardedAdHandler;
import com.unity3d.services.banners.BannerView;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a.a f3223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f3224b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u3.a f3225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.unity3d.scar.adapter.common.d f3226d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f3227f;

    public d(com.unity3d.scar.adapter.common.d dVar, int i2) {
        this.e = i2;
        this.f3226d = dVar;
    }

    @Override // com.unity3d.scar.adapter.common.f
    public final void a(Context context, BannerView bannerView, u3.c cVar, int i2, int i8, ScarBannerAdHandler scarBannerAdHandler) {
        switch (this.e) {
            case 0:
                c4.c cVar2 = new c4.c(context, cVar, (b4.a) this.f3227f, this.f3226d, 0);
                cVar2.h = bannerView;
                cVar2.f4184i = i2;
                cVar2.j = i8;
                cVar2.k = new AdView(context);
                cVar2.g = new e(scarBannerAdHandler, cVar2);
                a.a.V(new c(cVar2, 0));
                break;
            default:
                y3.a aVar = new y3.a(context, cVar, (x3.a) this.f3227f, this.f3226d, 1);
                aVar.h = bannerView;
                aVar.f17836i = i2;
                aVar.j = i8;
                aVar.k = new AdView(context);
                aVar.g = new y3.b(scarBannerAdHandler, aVar);
                a.a.V(new c(aVar, 21));
                break;
        }
    }

    @Override // com.unity3d.scar.adapter.common.f
    public final void b(Context context, u3.c cVar, ScarInterstitialAdHandler scarInterstitialAdHandler) {
        switch (this.e) {
            case 0:
                c4.f fVar = new c4.f(context, cVar, (b4.a) this.f3227f, this.f3226d, 0);
                fVar.g = new i(scarInterstitialAdHandler, fVar);
                a.a.V(new b(this, fVar, cVar, 0));
                break;
            default:
                y3.c cVar2 = new y3.c(context, cVar, (x3.a) this.f3227f, this.f3226d, 0);
                cVar2.g = new y3.d(scarInterstitialAdHandler, cVar2);
                a.a.V(new b(this, cVar2, cVar, 9));
                break;
        }
    }

    @Override // com.unity3d.scar.adapter.common.f
    public final void c(Context context, u3.c cVar, ScarRewardedAdHandler scarRewardedAdHandler) {
        switch (this.e) {
            case 0:
                c4.f fVar = new c4.f(context, cVar, (b4.a) this.f3227f, this.f3226d, 1);
                fVar.g = new k(scarRewardedAdHandler, fVar);
                a.a.V(new b(this, fVar, cVar, 1));
                break;
            default:
                y3.c cVar2 = new y3.c(context, cVar, (x3.a) this.f3227f, this.f3226d, 1);
                cVar2.g = new y3.e(scarRewardedAdHandler, cVar2);
                a.a.V(new b(this, cVar2, cVar, 10));
                break;
        }
    }
}
