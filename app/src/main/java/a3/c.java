package a3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.browser.trusted.TrustedWebActivityServiceConnectionPool;
import androidx.camera.core.SessionConfig;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.featuregroup.impl.ResolvedFeatureGroup;
import androidx.camera.core.impl.utils.MappingRedirectableLiveData;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.lifecycle.LifecycleCamera;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LiveData;
import androidx.room.MultiInstanceInvalidationClient;
import androidx.room.MultiInstanceInvalidationClient$callback$1;
import androidx.room.TransactionExecutor;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import com.bumptech.glide.load.Key;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.cbt.exam.browser.activity.ActivityScanner;
import com.cbt.exam.browser.activity.ConfirmActivity;
import com.cbt.exam.browser.activity.ExamQR;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.ironsource.adapters.pangle.PangleAdapter;
import com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.sdk.controller.v;
import com.mimikridev.utilmanager.config.Statistik;
import com.mimikridev.utilmanager.security.Dataku;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.services.ads.UnityAdsImplementation;
import com.unity3d.services.ads.gmascar.managers.BiddingBaseManager;
import com.unity3d.services.ads.gmascar.models.BiddingSignals;
import j2.q;
import java.io.UnsupportedEncodingException;
import java.util.List;
import l0.e;
import s6.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3210c;

    public /* synthetic */ c(int i2, Object obj, Object obj2) {
        this.f3208a = i2;
        this.f3209b = obj;
        this.f3210c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArrU;
        int i2 = this.f3208a;
        Object obj = this.f3210c;
        Object obj2 = this.f3209b;
        switch (i2) {
            case 0:
                LevelPlayNativeAd.a((LevelPlayNativeAd) obj2, (IronSourceError) obj);
                break;
            case 1:
                ((TrustedWebActivityServiceConnectionPool) obj2).lambda$connect$0((Uri) obj);
                break;
            case 2:
                MappingRedirectableLiveData.redirectTo$lambda$2((MappingRedirectableLiveData) obj2, (LiveData) obj);
                break;
            case 3:
                ((DualSurfaceProcessor) obj2).lambda$onInputSurface$1((SurfaceRequest) obj);
                break;
            case 4:
                ((DualSurfaceProcessor) obj2).lambda$onOutputSurface$3((SurfaceOutput) obj);
                break;
            case 5:
                LifecycleCamera.lambda$bind$0((ResolvedFeatureGroup) obj2, (SessionConfig) obj);
                break;
            case 6:
                ((AudioSource) obj2).lambda$setBufferProvider$0((BufferProvider) obj);
                break;
            case 7:
                ((AudioSource.AudioSourceCallback) obj2).onError((Throwable) obj);
                break;
            case 8:
                ((AudioSource) obj2).lambda$release$4((CallbackToFutureAdapter.Completer) obj);
                break;
            case 9:
                ((AudioSource) obj2).lambda$postMaxAmplitude$11((AudioSource.AudioSourceCallback) obj);
                break;
            case 10:
                ((ViewTransition) obj2).lambda$applyTransition$0((View[]) obj);
                break;
            case 11:
                ((ResourcesCompat.FontCallback) obj2).lambda$callbackSuccessAsync$0((Typeface) obj);
                break;
            case 12:
                MultiInstanceInvalidationClient$callback$1.onInvalidation$lambda$0((MultiInstanceInvalidationClient) obj2, (String[]) obj);
                break;
            case 13:
                TransactionExecutor.execute$lambda$1$lambda$0((Runnable) obj2, (TransactionExecutor) obj);
                break;
            case 14:
                ((WorkerWrapper) obj2).lambda$runWorker$0((q) obj);
                break;
            case 15:
                ConstraintTracker._set_state_$lambda$4$lambda$3((List) obj2, (ConstraintTracker) obj);
                break;
            case 16:
                ((WorkForegroundRunnable) obj2).lambda$run$0((SettableFuture) obj);
                break;
            case 17:
                ActivityScanner activityScanner = (ActivityScanner) obj2;
                String str = (String) obj;
                int i8 = ActivityScanner.f5118d;
                int i9 = 15;
                if (!str.startsWith(Dataku.keyId() + Dataku.keyUnix())) {
                    e eVar = activityScanner.f5120c;
                    if (eVar != null) {
                        eVar.b();
                    }
                    Intent intent = new Intent(activityScanner.getBaseContext(), (Class<?>) ExamQR.class);
                    intent.putExtra("url", str);
                    intent.putExtra("timer", 0);
                    intent.putExtra("timerstat", 0);
                    intent.putExtra("useragent", "");
                    intent.putExtra("from", "main_activity");
                    activityScanner.startActivity(intent);
                    new Handler(Looper.getMainLooper()).postDelayed(new b(activityScanner, i9), 150L);
                } else {
                    String[] strArrSplit = str.split(Dataku.keyUnix());
                    String str2 = strArrSplit[0];
                    String str3 = strArrSplit[1];
                    String str4 = null;
                    try {
                        try {
                            bArrU = a.a.u(r2.q.O(strArrSplit[2]), Dataku.keyId().getBytes(Key.STRING_CHARSET_NAME));
                        } catch (UnsupportedEncodingException unused) {
                            bArrU = null;
                        }
                        if (bArrU != null) {
                            str4 = new String(bArrU, Key.STRING_CHARSET_NAME);
                        }
                        break;
                    } catch (UnsupportedEncodingException unused2) {
                    }
                    String[] strArrSplit2 = str4.split(Dataku.keyUnix());
                    String str5 = strArrSplit2[0];
                    String str6 = strArrSplit2[1];
                    String str7 = strArrSplit2[2];
                    String str8 = strArrSplit2[3];
                    e eVar2 = activityScanner.f5120c;
                    if (eVar2 != null) {
                        eVar2.b();
                    }
                    Intent intent2 = new Intent(activityScanner.getBaseContext(), (Class<?>) ConfirmActivity.class);
                    if (str6.equals("null")) {
                        str6 = "0";
                    }
                    if (str7.equals("null")) {
                        str7 = "0";
                    }
                    if (str8.equals("null")) {
                        str8 = "0";
                    }
                    intent2.putExtra("url", str5);
                    intent2.putExtra("lamates", str6);
                    intent2.putExtra("useragent", str7);
                    intent2.putExtra("pesan", str8);
                    activityScanner.startActivity(intent2);
                    new Handler(Looper.getMainLooper()).postDelayed(new b(activityScanner, i9), 150L);
                }
                break;
            case 18:
                ((UserMetadata) obj2).lambda$updateRolloutsState$1((List) obj);
                break;
            case 19:
                n7.b.U((x) obj2, (ConfigUpdate) obj);
                break;
            case 20:
                PangleAdapter.showRewardedVideo$lambda$9$lambda$8((PAGRewardedAd) obj2, (Activity) obj);
                break;
            case 21:
                PangleAdapter.showInterstitial$lambda$12$lambda$11((PAGInterstitialAd) obj2, (Activity) obj);
                break;
            case 22:
                PangleAdapter.destroyBanner$lambda$14((PangleAdapter) obj2, (String) obj);
                break;
            case 23:
                ((v) obj2).j((String) obj);
                break;
            case 24:
                ((v.r) obj2).b((String) obj);
                break;
            case 25:
                Statistik.lambda$dg$4((Activity) obj2, (Context) obj);
                break;
            case 26:
                Statistik.lambda$sendData$3((Context) obj2, (String) obj);
                break;
            case 27:
                UnityAdsImplementation.lambda$load$1((IUnityAdsLoadListener) obj2, (String) obj);
                break;
            case 28:
                ((BiddingBaseManager) obj2).lambda$uploadSignals$2((BiddingSignals) obj);
                break;
            default:
                ((BiddingBaseManager) obj2).lambda$onUnityAdsTokenReady$0((String) obj);
                break;
        }
    }
}
