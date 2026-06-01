package a3;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode;
import androidx.camera.lifecycle.LifecycleCameraProviderImpl;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.Fragment;
import androidx.room.InvalidationTracker;
import androidx.work.CoroutineWorker;
import com.cbt.exam.browser.R;
import com.cbt.exam.browser.activity.ActivityScanner;
import com.cbt.exam.browser.activity.ActivitySplash;
import com.cbt.exam.browser.activity.MainActivity;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import com.google.firebase.installations.FirebaseInstallations;
import com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd;
import com.mimikridev.utilmanager.config.Statistik;
import com.onesignal.OneSignal;
import com.onesignal.common.threading.Waiter;
import com.onesignal.core.internal.application.impl.ApplicationService;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.core.internal.purchases.impl.TrackGooglePurchase;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.services.ads.gmascar.managers.BiddingBaseManager;
import com.unity3d.services.ads.operation.show.ShowOperationState;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.view.ScarBannerContainer;
import com.vungle.ads.internal.VungleInitializer;
import com.vungle.ads.internal.load.BaseAdLoader;
import j2.q;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3207b;

    public /* synthetic */ b(Object obj, int i2) {
        this.f3206a = i2;
        this.f3207b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i2 = this.f3206a;
        Object obj = this.f3207b;
        switch (i2) {
            case 0:
                LevelPlayNativeAd.a((LevelPlayNativeAd) obj);
                break;
            case 1:
                ((Camera2CameraControl) obj).completeInFlightUpdate();
                break;
            case 2:
                ((CameraStateRegistry.OnOpenAvailableListener) obj).onOpenAvailable();
                break;
            case 3:
                ((CameraStateRegistry.OnConfigureAvailableListener) obj).onConfigureAvailable();
                break;
            case 4:
                ((q) obj).cancel(true);
                break;
            case 5:
                ((CallbackToFutureAdapter.Completer) obj).set(null);
                break;
            case 6:
                ((DualSurfaceProcessor) obj).lambda$release$4();
                break;
            case 7:
                ((DualSurfaceProcessorNode) obj).lambda$release$1();
                break;
            case 8:
                LifecycleCameraProviderImpl.shutdownAsync$lambda$6((LifecycleCameraProviderImpl) obj);
                break;
            case 9:
                ((AudioStream.AudioStreamCallback) obj).onSilenceStateChanged(true);
                break;
            case 10:
                ((Carousel) obj).lambda$updateItems$0();
                break;
            case 11:
                DefaultSpecialEffectsController.startTransitions$lambda$11((ArrayList) obj);
                break;
            case 12:
                ((Fragment) obj).lambda$performCreateView$0();
                break;
            case 13:
                ((InvalidationTracker) obj).onAutoCloseCallback$room_runtime_release();
                break;
            case 14:
                CoroutineWorker._init_$lambda$0((CoroutineWorker) obj);
                break;
            case 15:
                ((ActivityScanner) obj).finish();
                break;
            case 16:
                ActivitySplash activitySplash = (ActivitySplash) obj;
                int i8 = ActivitySplash.f5121c;
                activitySplash.getClass();
                Intent intent = new Intent(activitySplash.getApplicationContext(), (Class<?>) MainActivity.class);
                Uri uri = activitySplash.f5122a;
                if (uri != null) {
                    intent.setData(uri);
                    intent.setAction("android.intent.action.VIEW");
                    intent.addFlags(603979776);
                    intent.putExtra("CBT_URI", activitySplash.f5122a.toString());
                }
                activitySplash.startActivity(intent);
                activitySplash.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                activitySplash.finish();
                break;
            case 17:
                MainActivity mainActivity = (MainActivity) obj;
                int i9 = MainActivity.f5146s;
                mainActivity.getClass();
                try {
                    String deviceId = Statistik.getDeviceId(mainActivity);
                    if (deviceId == null || deviceId.isEmpty()) {
                        Log.w(PreferenceStores.ONESIGNAL, "External ID kosong, lewati login");
                    } else {
                        OneSignal.login(deviceId);
                        Log.i(PreferenceStores.ONESIGNAL, "Login berhasil dengan externalId: ".concat(deviceId));
                        String id = OneSignal.getUser().getPushSubscription().getId();
                        if (id == null || id.isEmpty()) {
                            Log.w(PreferenceStores.ONESIGNAL, "OneSignal ID belum tersedia");
                        } else {
                            Statistik.saveOneSignalId(mainActivity, id);
                            Log.i(PreferenceStores.ONESIGNAL, "Disimpan OneSignal ID: ".concat(id));
                        }
                    }
                } catch (Exception e) {
                    Log.e(PreferenceStores.ONESIGNAL, "Login gagal: " + e.getMessage());
                    return;
                }
                break;
            case 18:
                ((Dialog) obj).dismiss();
                break;
            case 19:
                ((ForegroundNotifier) obj).lambda$onActivityPaused$0();
                break;
            case 20:
                ((FirebaseInstallations) obj).lambda$getId$1();
                break;
            case 21:
                ApplicationService.m3139waitUntilActivityReady$lambda0((Waiter) obj);
                break;
            case 22:
                TrackGooglePurchase.m3143queryBoughtItems$lambda0((TrackGooglePurchase) obj);
                break;
            case 23:
                ((IUnityAdsTokenListener) obj).onUnityAdsTokenReady(null);
                break;
            case 24:
                ((BiddingBaseManager) obj).lambda$fetchSignals$1();
                break;
            case 25:
                ((ShowOperationState) obj).lambda$onUnityAdsShowClick$1();
                break;
            case 26:
                ((BannerView) obj).lambda$addScarContainer$0();
                break;
            case 27:
                ScarBannerContainer.lambda$destroy$0((ScarBannerContainer) obj);
                break;
            case 28:
                VungleInitializer.m3304init$lambda3((VungleInitializer) obj);
                break;
            default:
                BaseAdLoader.m3320loadAd$lambda0((BaseAdLoader) obj);
                break;
        }
    }
}
