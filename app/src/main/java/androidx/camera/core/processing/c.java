package androidx.camera.core.processing;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import androidx.camera.core.ImageProcessor;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.camera.video.internal.audio.BufferedAudioStream;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.room.QueryInterceptorDatabase;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.ironsource.C2271cb;
import com.ironsource.C2281d3;
import com.ironsource.C2298e2;
import com.ironsource.C2308ec;
import com.ironsource.C2411k8;
import com.ironsource.C2426l5;
import com.ironsource.C2473ne;
import com.ironsource.C2606vb;
import com.ironsource.C2648y2;
import com.ironsource.Da;
import com.ironsource.InterfaceC2233a9;
import com.ironsource.M9;
import com.ironsource.P9;
import com.ironsource.Q1;
import com.ironsource.X2;
import com.ironsource.Y8;
import com.ironsource.adapters.pangle.PangleAdapter;
import com.ironsource.adapters.pangle.PangleInterstitialAdListener;
import com.ironsource.adapters.pangle.PangleRewardedVideoAdListener;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.onesignal.core.internal.application.impl.ApplicationService;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ironsourceads.InitListener;
import com.unity3d.ironsourceads.InitRequest;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.LevelPlayInitListener;
import com.unity3d.mediation.LevelPlayInitRequest;
import com.unity3d.services.ads.operation.load.LoadOperationState;
import com.unity3d.services.core.webview.WebView;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3691d;

    public /* synthetic */ c(Object obj, Object obj2, Object obj3, int i2) {
        this.f3688a = i2;
        this.f3689b = obj;
        this.f3690c = obj2;
        this.f3691d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.f3688a) {
            case 0:
                ((DefaultSurfaceProcessor) this.f3689b).lambda$executeSafely$12((Runnable) this.f3690c, (Runnable) this.f3691d);
                break;
            case 1:
                ((InternalImageProcessor) this.f3689b).lambda$safeProcess$0((ImageProcessor.Request) this.f3690c, (CallbackToFutureAdapter.Completer) this.f3691d);
                break;
            case 2:
                ((SurfaceProcessorNode) this.f3689b).lambda$sendSurfaceOutputs$0((SurfaceEdge) this.f3690c, (Map.Entry) this.f3691d);
                break;
            case 3:
                ((DualSurfaceProcessor) this.f3689b).lambda$executeSafely$8((Runnable) this.f3690c, (Runnable) this.f3691d);
                break;
            case 4:
                ((AudioSource) this.f3689b).lambda$setAudioSourceCallback$6((Executor) this.f3690c, (AudioSource.AudioSourceCallback) this.f3691d);
                break;
            case 5:
                ((BufferedAudioStream) this.f3689b).lambda$setCallback$3((AudioStream.AudioStreamCallback) this.f3690c, (Executor) this.f3691d);
                break;
            case 6:
                QueryInterceptorDatabase.query$lambda$7((QueryInterceptorDatabase) this.f3689b, (String) this.f3690c, (Object[]) this.f3691d);
                break;
            case 7:
                QueryInterceptorDatabase.execSQL$lambda$11((QueryInterceptorDatabase) this.f3689b, (String) this.f3690c, (ArrayList) this.f3691d);
                break;
            case 8:
                WorkerUpdater.updateWorkImpl$lambda$2((SettableFuture) this.f3689b, (WorkManagerImpl) this.f3690c, (WorkRequest) this.f3691d);
                break;
            case 9:
                ((CrashlyticsCore) this.f3689b).lambda$logException$1((Throwable) this.f3690c, (Map) this.f3691d);
                break;
            case 10:
                ((BiConsumer) this.f3689b).accept((String) this.f3690c, (ConfigContainer) this.f3691d);
                break;
            case 11:
                Da.a((LevelPlayAdInfo) this.f3689b, (LevelPlayAdError) this.f3690c, (Da) this.f3691d);
                break;
            case 12:
                P9.a((InitRequest) this.f3689b, (Context) this.f3690c, (InitListener) this.f3691d);
                break;
            case 13:
                Q1.c.a((Q1) this.f3689b, (String) this.f3690c, (Q1.d) this.f3691d);
                break;
            case 14:
                X2.a.a((X2) this.f3689b, (View) this.f3690c, (View) this.f3691d);
                break;
            case 15:
                PangleAdapter.initSdk$lambda$0((Context) this.f3689b, (PAGConfig) this.f3690c, (PangleAdapter) this.f3691d);
                break;
            case 16:
                PangleAdapter.loadInterstitialInternal$lambda$10((String) this.f3689b, (PAGInterstitialRequest) this.f3690c, (PangleInterstitialAdListener) this.f3691d);
                break;
            case 17:
                PangleAdapter.loadRewardedVideoInternal$lambda$7((String) this.f3689b, (PAGRewardedRequest) this.f3690c, (PangleRewardedVideoAdListener) this.f3691d);
                break;
            case 18:
                C2271cb.a((C2271cb) this.f3689b, (LevelPlayAdError) this.f3690c, (LevelPlayAdInfo) this.f3691d);
                break;
            case 19:
                C2271cb.a((Activity) this.f3689b, (C2271cb) this.f3690c, (String) this.f3691d);
                break;
            case 20:
                C2281d3.a((C2281d3) this.f3689b, (M9) this.f3690c, (C2411k8) this.f3691d);
                break;
            case 21:
                C2298e2.a((C2298e2) this.f3689b, (InterfaceC2233a9) this.f3690c, (Y8) this.f3691d);
                break;
            case 22:
                C2308ec.a((C2308ec) this.f3689b, (AdapterNativeAdData) this.f3690c, (AdapterNativeAdViewBinder) this.f3691d);
                break;
            case 23:
                C2606vb.b((Context) this.f3689b, (LevelPlayInitRequest) this.f3690c, (LevelPlayInitListener) this.f3691d);
                break;
            case 24:
                C2606vb.a.a((LevelPlayInitListener) this.f3689b, (C2426l5) this.f3690c, (C2473ne) this.f3691d);
                break;
            case 25:
                C2648y2.a((C2648y2) this.f3689b, (View) this.f3690c, (FrameLayout.LayoutParams) this.f3691d);
                break;
            case 26:
                ApplicationService.m3138decorViewReady$lambda1((ApplicationService) this.f3689b, (Runnable) this.f3690c, (ApplicationService) this.f3691d);
                break;
            case 27:
                ((LoadOperationState) this.f3689b).lambda$onUnityAdsFailedToLoad$0((UnityAds.UnityAdsLoadError) this.f3690c, (String) this.f3691d);
                break;
            case 28:
                ((IUnityAdsInitializationListener) this.f3689b).onInitializationFailed((UnityAds.UnityAdsInitializationError) this.f3690c, (String) this.f3691d);
                break;
            default:
                WebView.evaluateJavascript$lambda$1((WebView) this.f3689b, (String) this.f3690c, (ValueCallback) this.f3691d);
                break;
        }
    }
}
