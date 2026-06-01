package com.vungle.ads;

import android.app.ProgressDialog;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.lifecycle.LifecycleOwner;
import com.cbt.exam.browser.activity.b0;
import com.onesignal.core.activities.PermissionsActivity;
import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.AssetDownloader;
import com.vungle.ads.internal.downloader.DownloadRequest;
import com.vungle.ads.internal.load.DefaultAdLoader;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.Response;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.ui.VungleWebClient;
import com.vungle.ads.internal.util.LogEntry;
import j2.q;
import java.util.concurrent.Executors;
import l0.e;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f11000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f11001d;

    public /* synthetic */ b(VungleWebClient vungleWebClient, WebView webView, String str) {
        this.f10998a = 3;
        this.f10999b = vungleWebClient;
        this.f11001d = webView;
        this.f11000c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f10998a;
        Object obj = this.f11001d;
        Object obj2 = this.f11000c;
        Object obj3 = this.f10999b;
        switch (i2) {
            case 0:
                AnalyticsClient.m3243logError$lambda2((Sdk.SDKError.Reason) obj3, (String) obj2, (LogEntry) obj);
                return;
            case 1:
                AssetDownloader.m3312download$lambda0((DownloadRequest) obj3, (AssetDownloader) obj2, (AssetDownloadListener) obj);
                return;
            case 2:
                DefaultAdLoader.AnonymousClass1.m3326onResponse$lambda0((DefaultAdLoader) obj3, (Placement) obj2, (Response) obj);
                return;
            case 3:
                VungleWebClient.m3371shouldOverrideUrlLoading$lambda16$lambda6$lambda5((VungleWebClient) obj3, (WebView) obj, (String) obj2);
                return;
            case 4:
                PermissionsActivity.m3137onRequestPermissionsResult$lambda0((PermissionsActivity) obj3, (String[]) obj2, (int[]) obj);
                return;
            case 5:
                b0 b0Var = (b0) obj2;
                JSONObject jSONObject = (JSONObject) obj;
                ((ProgressDialog) obj3).dismiss();
                try {
                    b0Var.f5158a.s(jSONObject);
                    return;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            case 6:
                ((ProgressDialog) obj3).dismiss();
                Toast.makeText(((b0) obj2).f5158a, ((Exception) obj).getMessage(), 0).show();
                return;
            default:
                e eVar = (e) obj3;
                LifecycleOwner lifecycleOwner = (LifecycleOwner) obj;
                try {
                    eVar.f12737d = (ProcessCameraProvider) ((q) obj2).get();
                    Preview previewBuild = new Preview.Builder().build();
                    previewBuild.setSurfaceProvider(eVar.f12736c.getSurfaceProvider());
                    ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setBackpressureStrategy(0).build();
                    imageAnalysisBuild.setAnalyzer(Executors.newSingleThreadExecutor(), new l0.d(eVar));
                    eVar.f12737d.unbindAll();
                    eVar.f12734a = eVar.f12737d.bindToLifecycle(lifecycleOwner, eVar.f12735b, previewBuild, imageAnalysisBuild);
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
        }
    }

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i2) {
        this.f10998a = i2;
        this.f10999b = obj;
        this.f11000c = obj2;
        this.f11001d = obj3;
    }
}
