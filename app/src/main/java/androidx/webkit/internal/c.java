package androidx.webkit.internal;

import androidx.work.impl.utils.IdGenerator;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.vungle.ads.internal.session.UnclosedAdDetector;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4088b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f4087a = i2;
        this.f4088b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4087a) {
            case 0:
                return JavaScriptReplyProxyImpl.lambda$forInvocationHandler$0((JsReplyProxyBoundaryInterface) this.f4088b);
            case 1:
                return WebViewRenderProcessImpl.lambda$forInvocationHandler$0((WebViewRendererBoundaryInterface) this.f4088b);
            case 2:
                return IdGenerator.nextAlarmManagerId$lambda$1((IdGenerator) this.f4088b);
            case 3:
                return ((CrashlyticsCore) this.f4088b).lambda$checkForPreviousCrash$10();
            case 4:
                return ((CampaignCacheClient) this.f4088b).lambda$get$1();
            case 5:
                return DisplayCallbacksImpl.lambda$maybeToTask$9((TaskCompletionSource) this.f4088b);
            case 6:
                return ((FirebaseInstallations) this.f4088b).deleteFirebaseInstallationId();
            case 7:
                return ((ConfigStorageClient) this.f4088b).read();
            default:
                return UnclosedAdDetector.m3350readUnclosedAdFromFile$lambda4((UnclosedAdDetector) this.f4088b);
        }
    }
}
