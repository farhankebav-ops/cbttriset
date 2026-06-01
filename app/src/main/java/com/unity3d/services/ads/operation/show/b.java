package com.unity3d.services.ads.operation.show;

import android.app.job.JobParameters;
import androidx.core.util.Consumer;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.ironsource.adapters.vungle.banner.VungleBannerAdapter;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.store.core.api.Store;
import com.vungle.ads.BidTokenCallback;
import com.vungle.ads.internal.VungleInternal;
import com.vungle.ads.internal.load.BaseAdLoader;
import com.vungle.ads.internal.load.BaseAdLoader$assetDownloadListener$1;
import com.vungle.ads.internal.load.DefaultAdLoader;
import com.vungle.ads.internal.model.AdAsset;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.platform.AndroidPlatform;
import com.vungle.ads.internal.session.UnclosedAdDetector;
import com.vungle.ads.internal.ui.VungleWebClient;
import com.vungle.ads.internal.util.ImageLoader;
import e6.l;
import j2.q;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10991c;

    public /* synthetic */ b(int i2, Object obj, Object obj2) {
        this.f10989a = i2;
        this.f10990b = obj;
        this.f10991c = obj2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, q5.f] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i2 = this.f10989a;
        ?? r1 = this.f10991c;
        Object obj = this.f10990b;
        switch (i2) {
            case 0:
                ((ShowOperationState) obj).lambda$onUnityAdsShowStart$2((String) r1);
                break;
            case 1:
                ((ShowOperationState) obj).lambda$onUnityAdsShowComplete$3((UnityAds.UnityAdsShowCompletionState) r1);
                break;
            case 2:
                VungleInternal.m3310getAvailableBidTokensAsync$lambda2((BidTokenCallback) obj, r1);
                break;
            case 3:
                BaseAdLoader$assetDownloadListener$1.m3323onProgress$lambda0((BaseAdLoader) obj, (AdAsset) r1);
                break;
            case 4:
                DefaultAdLoader.AnonymousClass1.m3325onFailure$lambda1((DefaultAdLoader) obj, (Throwable) r1);
                break;
            case 5:
                AndroidPlatform.m3334getUserAgentLazy$lambda0((AndroidPlatform) obj, (Consumer) r1);
                break;
            case 6:
                UnclosedAdDetector.m3352writeUnclosedAdToFile$lambda5((UnclosedAdDetector) obj, (String) r1);
                break;
            case 7:
                VungleWebClient.m3364notifyPropertiesChange$lambda25$lambda24((VungleWebClient) obj, (String) r1);
                break;
            case 8:
                ImageLoader.m3378displayImage$lambda0((String) r1, (l) obj);
                break;
            case 9:
                Store.lambda$isFeatureSupported$0((Integer) obj, (String) r1);
                break;
            case 10:
                FilePreferences.m3332apply$lambda0((FilePreferences) obj, (HashMap) r1);
                break;
            case 11:
                FragmentStrictMode.handlePolicyViolation$lambda$0((FragmentStrictMode.Policy) obj, (Violation) r1);
                break;
            case 12:
                FragmentStrictMode.handlePolicyViolation$lambda$1((String) r1, (Violation) obj);
                break;
            case 13:
                ConstraintTrackingWorker.setupAndRunConstraintTrackingWork$lambda$2((ConstraintTrackingWorker) obj, (q) r1);
                break;
            case 14:
                int i8 = JobInfoSchedulerService.f5212a;
                ((JobInfoSchedulerService) obj).jobFinished((JobParameters) r1, false);
                break;
            default:
                VungleBannerAdapter.destroyBanner$lambda$4((JSONObject) obj, (VungleBannerAdapter) r1);
                break;
        }
    }

    public /* synthetic */ b(String str, Object obj, int i2) {
        this.f10989a = i2;
        this.f10991c = str;
        this.f10990b = obj;
    }
}
