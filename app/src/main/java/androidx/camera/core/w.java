package androidx.camera.core;

import android.content.Context;
import android.webkit.WebView;
import androidx.camera.core.ImageCapture;
import androidx.work.WorkRequest;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerUpdater;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.ironsource.C2426l5;
import com.ironsource.C2435le;
import com.ironsource.C2606vb;
import com.ironsource.adapters.pangle.PangleAdapter;
import com.ironsource.adapters.pangle.PangleBannerAdListener;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.unity3d.mediation.LevelPlayInitListener;
import com.unity3d.mediation.LevelPlayInitRequest;
import com.vungle.ads.internal.ui.VungleWebClient;
import com.vungle.ads.internal.ui.view.WebViewAPI;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3758d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f3759f;

    public /* synthetic */ w(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i2) {
        this.f3755a = i2;
        this.f3756b = obj;
        this.f3757c = obj2;
        this.f3758d = obj3;
        this.e = obj4;
        this.f3759f = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3755a) {
            case 0:
                ((ImageCapture) this.f3756b).lambda$takePicture$3((ImageCapture.OutputFileOptions) this.f3757c, (ImageCapture.OutputFileOptions) this.f3758d, (Executor) this.e, (ImageCapture.OnImageSavedCallback) this.f3759f);
                break;
            case 1:
                WorkerUpdater.enqueueUniquelyNamedPeriodic$lambda$3((WorkManagerImpl) this.f3756b, (String) this.f3757c, (OperationImpl) this.f3758d, (e6.a) this.e, (WorkRequest) this.f3759f);
                break;
            case 2:
                PangleAdapter.loadBannerForBidding$lambda$13((ISBannerSize) this.f3756b, (BannerSmashListener) this.f3757c, (String) this.f3758d, (PAGBannerRequest) this.e, (PangleBannerAdListener) this.f3759f);
                break;
            case 3:
                C2606vb.a.a((LevelPlayInitRequest) this.f3756b, (C2435le) this.f3757c, (Context) this.f3758d, (C2426l5) this.e, (LevelPlayInitListener) this.f3759f);
                break;
            default:
                VungleWebClient.m3368shouldOverrideUrlLoading$lambda16$lambda15$lambda14((WebViewAPI.MraidDelegate) this.f3756b, (String) this.f3757c, (g7.x) this.f3758d, (VungleWebClient) this.e, (WebView) this.f3759f);
                break;
        }
    }
}
