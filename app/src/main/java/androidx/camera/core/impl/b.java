package androidx.camera.core.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Range;
import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.arch.core.util.Function;
import androidx.camera.core.ZoomState;
import androidx.camera.lifecycle.LifecycleCameraProvider;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.fragment.app.SpecialEffectsController;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.WorkDatabase;
import com.cbt.exam.browser.activity.ActivitySplash;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.FormError;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.CrashlyticsRemoteConfigListener;
import com.google.firebase.crashlytics.internal.RemoteConfigDeferredProxy;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.mimikridev.ads.gdpr.GoogleMobileAdsConsentManager;
import com.mimikridev.ads.listener.OnShowAdCompleteListener;
import com.unity3d.ads.adplayer.AndroidWebViewContainer;
import com.unity3d.services.core.webview.WebView;
import com.vungle.ads.internal.platform.AndroidPlatform;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Function, CallbackToFutureAdapter.Resolver, InputConnectionCompat.OnCommitContentListener, CancellationSignal.OnCancelListener, SupportSQLiteOpenHelper.Factory, ActivityResultCallback, OnShowAdCompleteListener, Deferred.DeferredHandler, Continuation, x4.b, SuccessContinuation, ObjectConstructor, ConsentInformation.OnConsentInfoUpdateFailureListener, OnApplyWindowInsetsListener, OnSuccessListener, w1.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3611b;

    public /* synthetic */ b(Object obj, int i2) {
        this.f3610a = i2;
        this.f3611b = obj;
    }

    @Override // x4.b
    public void accept(Object obj) {
        switch (this.f3610a) {
            case 18:
                ((FirebaseInAppMessaging) this.f3611b).triggerInAppMessage((TriggeredInAppMessage) obj);
                break;
            case 19:
                ((AnalyticsEventsManager) this.f3611b).updateContextualTriggers((r2.o) obj);
                break;
            default:
                ((TestDeviceHelper) this.f3611b).processCampaignFetch((r2.o) obj);
                break;
        }
    }

    @Override // androidx.arch.core.util.Function, m0.f, x4.c
    public Object apply(Object obj) {
        switch (this.f3610a) {
            case 0:
                return AdapterCameraInfo.lambda$getZoomState$0((Range) this.f3611b, (ZoomState) obj);
            case 3:
                return LifecycleCameraProvider.Companion.createInstanceAsync$lambda$1((androidx.camera.core.impl.utils.a) this.f3611b, obj);
            default:
                return ProcessCameraProvider.Companion.getInstance$lambda$1((androidx.activity.u) this.f3611b, obj);
        }
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3610a) {
            case 1:
                return ((CameraRepository) this.f3611b).lambda$deinit$0(completer);
            case 2:
                return ((LiveDataObservable) this.f3611b).lambda$fetchData$1(completer);
            default:
                return ((AudioSource) this.f3611b).lambda$release$5(completer);
        }
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f3610a) {
            case 23:
                return ConstructorConstructor.lambda$newDefaultConstructor$9((Constructor) this.f3611b);
            default:
                return ConstructorConstructor.lambda$newUnsafeAllocator$19((Class) this.f3611b);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return WorkDatabase.Companion.create$lambda$0((Context) this.f3611b, configuration);
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void handle(Provider provider) {
        switch (this.f3610a) {
            case 13:
                ((CrashlyticsNativeComponentDeferredProxy) this.f3611b).lambda$new$0(provider);
                break;
            case 14:
                RemoteConfigDeferredProxy.lambda$setupListener$0((CrashlyticsRemoteConfigListener) this.f3611b, provider);
                break;
            default:
                ((ProxyAnalyticsConnector) this.f3611b).lambda$new$0(provider);
                break;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b8, code lost:
    
        if (r0.startsWith("application/") != false) goto L51;
     */
    @Override // androidx.activity.result.ActivityResultCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.b.onActivityResult(java.lang.Object):void");
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        switch (this.f3610a) {
            case 26:
                return AndroidWebViewContainer.applySafeAreaInsets$lambda$3((AndroidWebViewContainer) this.f3611b, view, windowInsetsCompat);
            default:
                return WebView.applySafeAreaInsets$lambda$3((WebView) this.f3611b, view, windowInsetsCompat);
        }
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        SpecialEffectsController.Operation._init_$lambda$0((SpecialEffectsController.Operation) this.f3611b);
    }

    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i2, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0((View) this.f3611b, inputContentInfoCompat, i2, bundle);
    }

    @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateFailureListener
    public void onConsentInfoUpdateFailure(FormError formError) {
        ((GoogleMobileAdsConsentManager.OnConsentGatheringCompleteListener) this.f3611b).consentGatheringComplete(formError);
    }

    @Override // com.mimikridev.ads.listener.OnShowAdCompleteListener
    public void onShowAdComplete() {
        ActivitySplash activitySplash = (ActivitySplash) this.f3611b;
        int i2 = ActivitySplash.f5121c;
        new Handler().postDelayed(new a3.b(activitySplash, 16), 3000L);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        AndroidPlatform.m3335updateAppSetID$lambda6((AndroidPlatform) this.f3611b, (AppSetIdInfo) obj);
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        return ConfigFetchHandler.lambda$fetchFromBackendAndCacheResponse$4((ConfigFetchHandler.FetchResponse) this.f3611b, (ConfigContainer) obj);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        switch (this.f3610a) {
            case 15:
                return Boolean.valueOf(((SessionReportingCoordinator) this.f3611b).onReportSendComplete(task));
            case 16:
                return CrashlyticsWorker.lambda$submit$1((Runnable) this.f3611b, task);
            default:
                return CrashlyticsWorker.lambda$submitTaskOnSuccess$5((SuccessContinuation) this.f3611b, task);
        }
    }
}
