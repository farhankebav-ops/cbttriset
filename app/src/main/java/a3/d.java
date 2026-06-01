package a3;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.cbt.exam.browser.R;
import com.cbt.exam.browser.activity.b0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.ironsource.AbstractC2406k3;
import com.ironsource.C2575te;
import com.ironsource.C2677ze;
import com.ironsource.Ga;
import com.ironsource.InterfaceC2541re;
import com.ironsource.M2;
import com.ironsource.adapters.ironsource.nativeAd.IronSourceNativeAdAdapter;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.vungle.ads.internal.VungleInitializer;
import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.DownloadRequest;
import com.vungle.ads.internal.load.BaseAdLoader;
import com.vungle.ads.internal.load.BaseAdLoader$assetDownloadListener$1;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import m0.i;
import org.json.JSONObject;
import p0.j;
import p0.k;
import q0.h;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3214d;
    public final /* synthetic */ Object e;

    public /* synthetic */ d(Object obj, Object obj2, Object obj3, Object obj4, int i2) {
        this.f3211a = i2;
        this.f3212b = obj;
        this.f3213c = obj2;
        this.f3214d = obj3;
        this.e = obj4;
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object, q5.f] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f3211a) {
            case 0:
                LevelPlayNativeAd.a((LevelPlayNativeAd) this.f3212b, (AdapterNativeAdData) this.f3213c, (AdapterNativeAdViewBinder) this.f3214d, (AdInfo) this.e);
                return;
            case 1:
                ((ImageCapture) this.f3212b).lambda$takePicture$2((ImageCapture.OutputFileOptions) this.f3213c, (Executor) this.f3214d, (ImageCapture.OnImageSavedCallback) this.e);
                return;
            case 2:
                ((DefaultSurfaceProcessor) this.f3212b).lambda$initGlRenderer$9((DynamicRange) this.f3213c, (Map) this.f3214d, (CallbackToFutureAdapter.Completer) this.e);
                return;
            case 3:
                ((DualSurfaceProcessor) this.f3212b).lambda$initGlRenderer$5((DynamicRange) this.f3213c, (Map) this.f3214d, (CallbackToFutureAdapter.Completer) this.e);
                return;
            case 4:
                ((UserMetadata) this.f3212b).lambda$setNewSession$0((String) this.f3213c, (Map) this.f3214d, (List) this.e);
                return;
            case 5:
                Ga.a((Ga) this.f3212b, (M2) this.f3213c, (AbstractC2406k3) this.f3214d, (Long) this.e);
                return;
            case 6:
                C2677ze.a((InterfaceC2541re) this.f3212b, (Context) this.f3213c, (C2575te) this.f3214d, (Context) this.e);
                return;
            case 7:
                VungleInitializer.m3303init$lambda2((VungleInitializer) this.f3212b, (Context) this.f3213c, (String) this.f3214d, this.e);
                return;
            case 8:
                BaseAdLoader$assetDownloadListener$1.m3324onSuccess$lambda2((File) this.f3212b, (BaseAdLoader$assetDownloadListener$1) this.f3213c, (DownloadRequest) this.f3214d, (BaseAdLoader) this.e);
                return;
            case 9:
                BaseAdLoader$assetDownloadListener$1.m3322onError$lambda1((DownloadRequest) this.f3212b, (BaseAdLoader) this.f3213c, (BaseAdLoader$assetDownloadListener$1) this.f3214d, (AssetDownloadListener.DownloadError) this.e);
                return;
            case 10:
                Activity activity = (Activity) this.f3212b;
                Uri uri = (Uri) this.f3213c;
                ProgressDialog progressDialog = (ProgressDialog) this.f3214d;
                b0 b0Var = (b0) this.e;
                try {
                    InputStream inputStreamOpenInputStream = activity.getContentResolver().openInputStream(uri);
                    try {
                        if (inputStreamOpenInputStream == null) {
                            throw new IOException(activity.getString(R.string.txt_cbtfile_error_read));
                        }
                        activity.runOnUiThread(new com.vungle.ads.b(progressDialog, b0Var, a.a.v(q.m0(inputStreamOpenInputStream)), 5));
                        inputStreamOpenInputStream.close();
                        return;
                    } finally {
                        if (inputStreamOpenInputStream != null) {
                            try {
                                break;
                            } catch (Throwable th) {
                            }
                        }
                    }
                } catch (Exception e) {
                    activity.runOnUiThread(new com.vungle.ads.b(progressDialog, b0Var, e, 6));
                    return;
                }
            case 11:
                u0.a aVar = (u0.a) this.f3212b;
                k kVar = (k) this.f3213c;
                String str = kVar.f13292a;
                i iVar = (i) this.f3214d;
                j jVar = (j) this.e;
                aVar.getClass();
                Logger logger = u0.a.f17516f;
                try {
                    h hVarA = aVar.f17519c.a(str);
                    if (hVarA == null) {
                        String str2 = "Transport backend '" + str + "' is not registered";
                        logger.warning(str2);
                        iVar.a(new IllegalArgumentException(str2));
                    } else {
                        ((w0.i) aVar.e).j(new androidx.camera.core.processing.h(aVar, kVar, ((n0.c) hVarA).a(jVar), 9));
                        iVar.a(null);
                    }
                    return;
                } catch (Exception e4) {
                    logger.warning("Error scheduling event " + e4.getMessage());
                    iVar.a(e4);
                    return;
                }
            default:
                IronSourceNativeAdAdapter.loadNativeAdForBidding$lambda$0((IronSourceNativeAdAdapter) this.f3212b, (JSONObject) this.f3213c, (NativeAdSmashListener) this.f3214d, (String) this.e);
                return;
        }
    }
}
